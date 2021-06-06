package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Github;

public interface GithubDao extends JpaRepository<Github, Integer> {

    Github findByUserId(int userId);

}
