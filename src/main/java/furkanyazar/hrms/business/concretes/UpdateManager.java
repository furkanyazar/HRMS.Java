package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.UpdateService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.UpdateDao;
import furkanyazar.hrms.entities.concretes.Update;

@Service
public class UpdateManager implements UpdateService {

    private UpdateDao updateDao;
    private EmployerManager employerManager;

    @Autowired
    public UpdateManager(UpdateDao updateDao, EmployerManager employerManager) {
        super();
        this.updateDao = updateDao;
        this.employerManager = employerManager;
    }

    @Override
    public Result add(Update update) {
        updateDao.save(update);
        return new Result(true, "Kaydedildi");
    }

    @Override
    public DataResult<List<Update>> getAll() {
        return new DataResult<List<Update>>(updateDao.findAll(), true, "Veri döndü");
    }

    @Override
    public DataResult<Update> findByUserId(int userId) {
        return new DataResult<Update>(updateDao.findByUserId(userId), true, "Veri döndü");
    }

    @Override
    public Result update(int userId) {
        Update update = findByUserId(userId).getData();
        Result result = employerManager.edit(update, userId);
        updateDao.delete(update);
        return result;
    }
    
}
