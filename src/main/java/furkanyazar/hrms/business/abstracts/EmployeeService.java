package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Employee;

public interface EmployeeService {

    DataResult<List<Employee>> getAll();

    DataResult<List<Employee>> findByEmail(String email);

    DataResult<List<Employee>> findByIdentityNumber(String identityNumber);

    DataResult<Boolean> checkIfRealPerson(Employee employee);

    DataResult<Boolean> confirmEmail();

    DataResult<Employee> findById(int id);

    Result add(Employee employee);

    DataResult<Employee> findByEmailAndPassword(String email, String password);

    Result edit(String coverLetter, String github, String linkedin, Employee employee, int id);

}
