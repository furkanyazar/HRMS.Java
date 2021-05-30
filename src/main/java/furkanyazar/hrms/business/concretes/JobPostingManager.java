package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.JobPostingService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.JobPostingDao;
import furkanyazar.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        super();
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public DataResult<List<JobPosting>> getByIsActivated(Boolean isActivated) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActivated(isActivated), "Aktif iş pozisyonları listelendi");
    }

    @Override
    public DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineAsc(Boolean isActivated) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActivatedOrderByApplicationDeadlineAsc(isActivated), "Aktif iş pozisyonları artan tarihe göre listelendi");
    }

    @Override
    public DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineDesc(Boolean isActivated) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActivatedOrderByApplicationDeadlineDesc(isActivated), "Aktif iş pozisyonları düşen tarihe göre listelendi");
    }

    @Override
    public Result add(JobPosting jobPosting) {
        jobPostingDao.save(jobPosting);
        return new Result(true, "İş pozisyonu eklendi");
    }

    @Override
    public DataResult<List<JobPosting>> getByIsActivatedAndUserId(Boolean isActivated, int userId) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActivatedAndUserId(isActivated, userId), "Firmaya göre aktif iş ilanları listelendi");
    }

    @Override
    public JobPosting getById(int id) {
        return jobPostingDao.getById(id);
    }

    @Override
    public Result setIsActivated(JobPosting jobPosting, Boolean isActivated, int id) {
        jobPosting = getById(id);
        jobPosting.setIsActivated(isActivated);
        jobPostingDao.save(jobPosting);
        return new Result(true, "İş aktiflik durumu güncellendi");
    }
    
}
