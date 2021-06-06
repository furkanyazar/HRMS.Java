package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.OwnedSkill;

public interface OwnedSkillDao extends JpaRepository<OwnedSkill, Integer> {

}
