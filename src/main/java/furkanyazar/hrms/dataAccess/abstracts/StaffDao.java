package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

    Staff findByEmailAndPassword(String email, String password);

    Staff findById(int id);

}
