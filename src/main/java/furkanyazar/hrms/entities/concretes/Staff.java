package furkanyazar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@Entity
@Table(name = "system_workers")
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends User {

	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;

}
