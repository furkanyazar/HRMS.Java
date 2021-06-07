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
@Data
@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "user_id")
	// private int userId;

	// @Column(name = "job_id")
	// private int jobId;

	@Column(name = "business_name")
	private String departmentId;
	
	@Column(name = "starting_date")
	private Date startingDate;
	
	@Column(name = "ending_date")
	private Date endingDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

}
