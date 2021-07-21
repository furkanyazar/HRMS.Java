package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.ActivationEmployerService;
import furkanyazar.hrms.business.abstracts.EmailService;
import furkanyazar.hrms.business.abstracts.EmployerService;
import furkanyazar.hrms.business.abstracts.PhotoService;
import furkanyazar.hrms.business.concretes.helpers.EmailCheckHelper;
import furkanyazar.hrms.business.concretes.helpers.EmployerCheckHelper;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.ErrorResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.core.utilities.results.SuccessResult;
import furkanyazar.hrms.dataAccess.abstracts.ActivationEmployerDao;
import furkanyazar.hrms.dataAccess.abstracts.EmployerDao;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.Employer;
import furkanyazar.hrms.entities.concretes.Photo;
import furkanyazar.hrms.entities.concretes.Update;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private ActivationEmployerService activationEmployerService;
	private EmailService emailService;
	private ActivationEmployerDao activationEmployerDao;
	private PhotoService photoService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ActivationEmployerService activationEmployerService,
			EmailService emailService, ActivationEmployerDao activationEmployerDao, PhotoService photoService) {
		super();
		this.employerDao = employerDao;
		this.activationEmployerService = activationEmployerService;
		this.emailService = emailService;
		this.activationEmployerDao = activationEmployerDao;
		this.photoService = photoService;
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
		photoService.add(new Photo(), employer);
		activationEmployerService.add(new ActivationEmployer(), employer);
		return new SuccessResult(emailService.sendEmail(employer).getMessage());
	}

	@Override
	public DataResult<Boolean> confirmEmail() {
		return new SuccessDataResult<Boolean>("Email onaylandı");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.getById(id), "İş veren detayları listelendi");
	}

	@Override
	public Result setIsActivated(ActivationEmployer activationEmployer, Employer employer, Boolean isActivated,
			int id) {
		employer = getById(id).getData();
		activationEmployer = activationEmployerService.getByUserId(employer.getId()).getData();
		activationEmployer.setIsActivated(isActivated);
		activationEmployerDao.save(activationEmployer);
		return new Result(true, "İş veren aktiflik durumu değiştirildi");
	}

	@Override
	public DataResult<Employer> findByEmailAndPassword(String email, String password) {
		return new SuccessDataResult<Employer>(employerDao.findByEmailAndPassword(email, password));
	}

	@Override
	public Result edit(Update update, int id) {
		try {
			Employer employer = getById(id).getData();

			employer.setCompanyName(update.getCompanyName());
			employer.setWebsite(update.getWebsite());
			employer.setEmail(update.getEmail());
			employer.setPhoneNumber(update.getPhoneNumber());

			employerDao.save(employer);

			return new Result(true, "Bilgiler kaydedildi");
		} catch (Exception e) {
			return new Result(false, "Bir hata oluştu");
		}
	}

}
