package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.adapters.UserCheckService;
import furkanyazar.hrms.business.abstracts.ActivationService;
import furkanyazar.hrms.business.abstracts.EmailService;
import furkanyazar.hrms.business.abstracts.EmployeeService;
import furkanyazar.hrms.business.concretes.helpers.EmployeeCheckHelper;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.ErrorResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.core.utilities.results.SuccessResult;
import furkanyazar.hrms.dataAccess.abstracts.EmployeeDao;
import furkanyazar.hrms.entities.concretes.Activation;
import furkanyazar.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private ActivationService activationService;
	private UserCheckService userCheckService;
	private EmailService emailService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, ActivationService activationService, UserCheckService userCheckService, EmailService emailService) {
		super();
		this.employeeDao = employeeDao;
		this.activationService = activationService;
		this.userCheckService = userCheckService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(), "İş arayanlar listelendi");
	}

	@Override
	public DataResult<List<Employee>> findByEmail(String email) {
		return new SuccessDataResult<List<Employee>>(employeeDao.findByEmail(email), "Emaile göre listelendi");
	}

	@Override
	public DataResult<List<Employee>> findByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<List<Employee>>(employeeDao.findByIdentityNumber(identityNumber),
				"Kimlik noya göre listelendi");
	}

	@Override
	public DataResult<Boolean> checkIfRealPerson(Employee employee) {
		return new DataResult<Boolean>(userCheckService.validate(employee), true);
	}

	@Override
	public Result add(Employee employee) {
		Boolean checkEmail = findByEmail(employee.getEmail()).getData().size() != 0;
		Boolean checkIdentityNumber = findByIdentityNumber(employee.getIdentityNumber()).getData().size() != 0;
		Boolean checkIfRealPerson = !checkIfRealPerson(employee).getData();
		Boolean checkFields = !EmployeeCheckHelper.checkFields(employee);

		if (checkEmail || checkIdentityNumber || checkIfRealPerson || checkFields) {
			String errorMessage = "";

			if (checkEmail || checkIdentityNumber)
				errorMessage += "Email veya kimlik no zaten kayıtlı\n";

			if (checkIfRealPerson)
				errorMessage += "Kullanıcı gerçek değil\n";

			if (checkFields)
				errorMessage += "Bazı bilgiler eksik";

			return new ErrorResult(errorMessage);
		}

		employeeDao.save(employee);
		activationService.add(new Activation(), employee);
		return new SuccessResult(emailService.sendEmail(employee).getMessage());
	}

	@Override
	public DataResult<Boolean> confirmEmail() {
		return new SuccessDataResult<Boolean>("Email onaylandı");
	}

	@Override
	public DataResult<Employee> findById(int id) {
		return new SuccessDataResult<Employee>(employeeDao.findById(id), "Kullanıcı listelendi");
	}

	@Override
	public DataResult<Employee> findByEmailAndPassword(String email, String password) {
		return new SuccessDataResult<Employee>(employeeDao.findByEmailAndPassword(email, password));
	}

}
