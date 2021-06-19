package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
    
    DataResult<List<WorkingTime>> getAll();

}
