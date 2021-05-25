package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.StaffService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.StaffDao;
import furkanyazar.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {
	
	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(staffDao.findAll(), "Çalışanlar listelendi");
	}

	@Override
	public Result add(Staff staff) {
		staffDao.save(staff);
		return new Result(true, "Çalışan eklendi");
	}

	@Override
	public DataResult<Boolean> confirmEmployer() {
		return new SuccessDataResult<Boolean>("İş veren onaylandı");
	}
	
}
