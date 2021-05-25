package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.JobService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.ErrorResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.core.utilities.results.SuccessResult;
import furkanyazar.hrms.dataAccess.abstracts.JobDao;
import furkanyazar.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {
	
	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll(), "İşler listelendi");
	}

	@Override
	public Result add(Job job) {
		if (findByName(job.getName()).getData().size() != 0){
			return new ErrorResult("İş zaten ekli");
		}
		
		jobDao.save(job);
		return new SuccessResult("İş eklendi");
	}

	@Override
	public DataResult<List<Job>> findByName(String name) {
		return new SuccessDataResult<List<Job>>(jobDao.findByName(name), "Ada göre listelendi");
	}

}
