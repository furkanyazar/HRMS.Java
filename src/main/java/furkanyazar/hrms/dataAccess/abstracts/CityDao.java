package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
    
}
