package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    
}
