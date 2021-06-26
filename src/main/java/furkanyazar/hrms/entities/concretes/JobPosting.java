package furkanyazar.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @PrimaryKeyJoinColumn(name = "user_id")
// @PrimaryKeyJoinColumn(name = "job_id")
// @PrimaryKeyJoinColumn(name = "city_id")
@Data
@Entity
@Table(name = "job_postings")
// @Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;

    // @Column(name = "job_id")
	// private int jobId;

    // @Column(name = "city_id")
	// private int cityId;

    // @Column(name = "user_id")
	// private int userId;

    @Column(name = "description")
    private String description;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "open_position")
    private int openPosition;

    @Column(name = "last_date")
    private Date lastDate;

    @Column(name = "is_activated")
    private Boolean isActivated;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "working_time_id")
    private WorkingTime workingTime;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;

}
