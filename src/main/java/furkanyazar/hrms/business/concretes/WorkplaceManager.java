package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.WorkplaceService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.WorkplaceDao;
import furkanyazar.hrms.entities.concretes.Workplace;

@Service
public class WorkplaceManager implements WorkplaceService {

    private WorkplaceDao workplaceDao;

    public WorkplaceManager(WorkplaceDao workplaceDao) {
        super();
        this.workplaceDao = workplaceDao;
    }

    @Override
    public DataResult<List<Workplace>> getAll() {
        return new SuccessDataResult<List<Workplace>>(workplaceDao.findAll(), "Çalışma yerleri listelendi");
    }
    
}
