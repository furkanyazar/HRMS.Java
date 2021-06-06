package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.ExperienceService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.ExperienceDao;
import furkanyazar.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	
	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> findByUserIdOrderByEndingDateDesc(int userId) {
		return new DataResult<List<Experience>>(experienceDao.findByUserIdOrderByEndingDateDesc(userId), true, "Deneyim sıralandı");
	}

	@Override
	public Result add(Experience experience) {
		experienceDao.save(experience);
		return new Result(true, "Deneyim eklendi");
	}

	@Override
	public DataResult<List<Experience>> findByUserId(int userId) {
		return new SuccessDataResult<List<Experience>>(experienceDao.findByUserId(userId), "Data döndü");
	}

}
