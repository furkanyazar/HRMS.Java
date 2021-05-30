package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    JobPosting getById(int id);

    List<JobPosting> getByIsActivated(Boolean isActivated);

    List<JobPosting> getByIsActivatedOrderByApplicationDeadlineAsc(Boolean isActivated);

    List<JobPosting> getByIsActivatedOrderByApplicationDeadlineDesc(Boolean isActivated);

    List<JobPosting> getByIsActivatedAndUserId(Boolean isActivated, int userId);

}
