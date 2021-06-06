package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.EducationService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.EducationDao;
import furkanyazar.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		educationDao.save(education);
		return new Result(true, "Eğitim eklendi");
	}

	@Override
	public DataResult<List<Education>> findByUserIdOrderByEndingDateDesc(int userId) {
		return new DataResult<List<Education>>(educationDao.findByUserIdOrderByEndingDateDesc(userId), true, "Eğitim sıralandı");
	}

}
