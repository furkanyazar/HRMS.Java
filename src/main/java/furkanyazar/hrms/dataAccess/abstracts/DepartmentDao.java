package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
    
}
