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

	@Override
	public DataResult<Staff> findByEmailAndPassword(String email, String password) {
		return new SuccessDataResult<Staff>(staffDao.findByEmailAndPassword(email, password), "Çalışan listelendi");
	}

	@Override
	public DataResult<Staff> findById(int id) {
		return new SuccessDataResult<Staff>(staffDao.findById(id));
	}

	@Override
	public Result edit(Staff staff, int id) {
		try {
			Staff tempStaff = findById(id).getData();

			tempStaff.setName(staff.getName());
			tempStaff.setSurname(staff.getSurname());
			tempStaff.setEmail(staff.getEmail());

			staffDao.save(tempStaff);

			return new Result(true, "Bilgiler kaydedildi");
		} catch (Exception e) {
			return new Result(false, "Bir hata oluştu");
		}
	}

}
