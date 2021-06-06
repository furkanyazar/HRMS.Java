package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.JobPostingService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {

    private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

    @GetMapping("/getByIsActivated")
	public DataResult<List<JobPosting>> getByIsActivated() {
		return jobPostingService.getByIsActivated(true);
	}

    @GetMapping("/getByIsActivatedOrderByApplicationDeadlineAsc")
	public DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineAsc() {
		return jobPostingService.getByIsActivatedOrderByApplicationDeadlineAsc(true);
	}

    @GetMapping("/getByIsActivatedOrderByApplicationDeadlineDesc")
	public DataResult<List<JobPosting>> getByIsActivatedOrderByApplicationDeadlineDesc() {
		return jobPostingService.getByIsActivatedOrderByApplicationDeadlineDesc(true);
	}

    @PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return jobPostingService.add(jobPosting);
	}

    @GetMapping("/getByIsActivatedAndUserId")
	public DataResult<List<JobPosting>> getByIsActivatedAndUserId(int userId) {
		return jobPostingService.getByIsActivatedAndUserId(true, userId);
	}
	
	@PostMapping("/setIsActivated")
	public Result setIsActivated(Boolean isActivated, int id) {
		return jobPostingService.setIsActivated(new JobPosting(), isActivated, id);
	}
}
