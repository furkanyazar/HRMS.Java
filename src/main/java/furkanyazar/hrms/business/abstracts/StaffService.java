package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Staff;

public interface StaffService {
	
	DataResult<List<Staff>> getAll();
	DataResult<Boolean> confirmEmployer();
	
	Result add(Staff staff);

}
