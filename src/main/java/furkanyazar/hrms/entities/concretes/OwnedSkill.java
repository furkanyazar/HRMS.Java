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
// @PrimaryKeyJoinColumn(name = "skill_id")
@Data
@Entity
@Table(name = "owned_skills")
@AllArgsConstructor
@NoArgsConstructor
public class OwnedSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	// @Column(name = "user_id")
	// private int userId;
	
	// @Column(name = "skill_id")
	// private int skillId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

}
