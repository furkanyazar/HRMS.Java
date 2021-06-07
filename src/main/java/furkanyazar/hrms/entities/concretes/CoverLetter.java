package furkanyazar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@Data
@Entity
@Table(name = "cover_letters")
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetter {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "article")
	private String article;

}
