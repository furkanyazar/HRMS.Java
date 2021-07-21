package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Update;

public interface UpdateService {
    
    Result add(Update update);

    DataResult<List<Update>> getAll();

    DataResult<Update> findByUserId(int userId);

    Result update(int userId);

}
