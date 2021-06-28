package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.DepartmentService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.DepartmentDao;
import furkanyazar.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        super();
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> findAll() {
        return new SuccessDataResult<List<Department>>(departmentDao.findAll(), "Bölümler listelendi");
    }
    
}
