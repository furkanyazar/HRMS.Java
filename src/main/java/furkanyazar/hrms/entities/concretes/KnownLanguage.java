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
// @PrimaryKeyJoinColumn(name = "language_id")
@Data
@Entity
@Table(name = "known_languages")
@AllArgsConstructor
@NoArgsConstructor
public class KnownLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	// @Column(name = "user_id")
	// private int userId;
	
	// @Column(name = "language_id")
	// private int languageId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

}
