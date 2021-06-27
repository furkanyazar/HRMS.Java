package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
    
    User findByIdAndPassword(int id, String password);

}
