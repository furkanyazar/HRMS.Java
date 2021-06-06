package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

    Photo findByUserId(int userId);

}
