package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.OwnedSkill;

public interface OwnedSkillDao extends JpaRepository<OwnedSkill, Integer> {

    List<OwnedSkill> findByUserId(int userId);

}
