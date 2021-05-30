package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

    JobPosting getById(int id);

    DataResult<List<JobPosting>> getByIsActivated(Boolean isActivated);

    DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineAsc(Boolean isActivated);

    DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineDesc(Boolean isActivated);

    DataResult<List<JobPosting>> getByIsActivatedAndUserId(Boolean isActivated, int userId);

    Result add(JobPosting jobPosting);

    Result setIsActivated(JobPosting jobPosting, Boolean isActivated, int id);

}
