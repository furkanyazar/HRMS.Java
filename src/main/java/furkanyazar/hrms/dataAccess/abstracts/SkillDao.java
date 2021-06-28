package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
    
}
