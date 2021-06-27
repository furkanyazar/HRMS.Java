package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
    
}
