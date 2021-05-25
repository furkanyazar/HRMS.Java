package furkanyazar.hrms.adapters;

import org.springframework.stereotype.Service;

import furkanyazar.hrms.entities.concretes.Employee;

@Service
public class FakeMernisServiceAdapter implements UserCheckService {
	
	public Boolean validate(Employee employee) {
		return true;
	}

}
