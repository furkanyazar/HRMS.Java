package furkanyazar.hrms.adapters;

import furkanyazar.hrms.entities.concretes.Employee;

public interface UserCheckService {
	
	Boolean validate(Employee employee);

}
