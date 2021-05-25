package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.ActivationEmployerService;
import furkanyazar.hrms.business.abstracts.EmailService;
import furkanyazar.hrms.business.abstracts.EmployerService;
import furkanyazar.hrms.business.concretes.helpers.EmailCheckHelper;
import furkanyazar.hrms.business.concretes.helpers.EmployerCheckHelper;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.ErrorResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.core.utilities.results.SuccessResult;
import furkanyazar.hrms.dataAccess.abstracts.EmployerDao;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private ActivationEmployerService activationEmployerService;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ActivationEmployerService activationEmployerService, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.activationEmployerService = activationEmployerService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İş verenler listelendi");
	}

	@Override
	public DataResult<List<Employer>> findByEmail(String email) {
		return new SuccessDataResult<List<Employer>>(employerDao.findByEmail(email), "Emaile göre listelendi");
	}

	@Override
	public Result add(Employer employer) {
		Boolean checkEmail = findByEmail(employer.getEmail()).getData().size() != 0;
		Boolean checkFields = !EmployerCheckHelper.checkFields(employer);
		Boolean checkIfComunity = !EmailCheckHelper.checkEmail(employer);
		
		if (checkEmail || checkFields || checkIfComunity) {
			String errorMessage = "";

			if (checkEmail)
				errorMessage += "Email zaten kayıtlı\n";

			if (checkIfComunity)
				errorMessage += "Kullanıcı şirket değil\n";

			if (checkFields)
				errorMessage += "Bazı bilgiler eksik";

			return new ErrorResult(errorMessage);
		}
		
		employerDao.save(employer);
		activationEmployerService.add(new ActivationEmployer(), employer);
		return new SuccessResult(emailService.sendEmail(employer).getMessage());
	}
	
	@Override
	public DataResult<Boolean> confirmEmail() {
		return new SuccessDataResult<Boolean>("Email onaylandı");
	}

}
