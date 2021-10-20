package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    JobPosting getById(int id);

    List<JobPosting> getByIsActivated(Boolean isActivated);

    List<JobPosting> getByIsActivatedOrderByLastDateAsc(Boolean isActivated);

    List<JobPosting> getByIsActivatedOrderByLastDateDesc(Boolean isActivated);

    List<JobPosting> getByIsActivatedAndUserId(Boolean isActivated, int userId);

    List<JobPosting> getByIsActivatedAndCityId(Boolean isActivated, int cityId);

    List<JobPosting> getByIsActivatedAndWorkingTimeId(Boolean isActivated, int workingTimeId);

    List<JobPosting> getByIsActivatedAndCityIdAndWorkingTimeId(boolean isActivated, int cityId, int workingTimeId);
}
