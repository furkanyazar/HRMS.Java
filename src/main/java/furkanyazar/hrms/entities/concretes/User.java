package furkanyazar.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
// @Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ownedSkills", "knownLanguages", "experiences", "jobPostings", "activations", "activationEmployers", "educations"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<JobPosting> jobPostings;

	@OneToMany(mappedBy = "user")
	private List<Activation> activations;

	@OneToMany(mappedBy = "user")
	private List<ActivationEmployer> activationEmployers;

	@OneToMany(mappedBy = "user")
	private List<Education> educations;

	@OneToMany(mappedBy = "user")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "user")
	private List<KnownLanguage> knownLanguages;

	@OneToMany(mappedBy = "user")
	private List<OwnedSkill> ownedSkills;

}
