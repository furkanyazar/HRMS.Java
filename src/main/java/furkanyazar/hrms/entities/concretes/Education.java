package furkanyazar.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@PrimaryKeyJoinColumn(name = "school_id")
@PrimaryKeyJoinColumn(name = "department_id")
@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "school_id")
	private int schoolId;

	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "starting_date")
	private Date startingDate;
	
	@Column(name = "ending_date")
	private Date endingDate;

}
