package furkanyazar.hrms.entities.concretes;

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
@Data
@Entity
@Table(name = "activation_employers")
@AllArgsConstructor
@NoArgsConstructor
public class ActivationEmployer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	// @Column(name = "user_id")
	// private int userId;
	
	@Column(name = "is_activated")
	private Boolean isActivated;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
