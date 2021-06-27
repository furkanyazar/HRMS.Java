package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.EmployeeService;
import furkanyazar.hrms.business.abstracts.FavoriteService;
import furkanyazar.hrms.business.abstracts.JobPostingService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.ErrorResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.FavoriteDao;
import furkanyazar.hrms.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;
    private EmployeeService employeeService;
    private JobPostingService jobPostingService;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao, EmployeeService employeeService, JobPostingService jobPostingService) {
        super();
        this.favoriteDao = favoriteDao;
        this.employeeService = employeeService;
        this.jobPostingService = jobPostingService;
    }

    @Override
    public Result add(Favorite favorite, int userId, int jobPostingId) {
        Boolean checkDoesItContain = false;
        List<Favorite> allFavorites = favoriteDao.findAll();

        for (Favorite f : allFavorites) {
            if (f.getUser().getId() == userId && f.getJobPosting().getId() == jobPostingId) {
                checkDoesItContain = true;
                break;
            }
        }

        if (checkDoesItContain) {
            return new ErrorResult("Zaten ekli");
        }

        favorite.setUser(employeeService.findById(userId).getData());
        favorite.setJobPosting(jobPostingService.getById(jobPostingId).getData());
        favoriteDao.save(favorite);
        return new Result(true, "Favorilere eklendi");
    }

    @Override
    public Result delete(Favorite favorite) {
        favoriteDao.delete(favorite);
        return new Result(true, "Favorilerden kaldırıldı");
    }

    @Override
    public DataResult<List<Favorite>> findAll() {
        return new SuccessDataResult<List<Favorite>>(favoriteDao.findAll(), "Favoriler listelendi");
    }

}
