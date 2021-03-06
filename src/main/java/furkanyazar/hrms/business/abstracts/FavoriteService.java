package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Favorite;

public interface FavoriteService {

    Result add(Favorite favorite, int userId, int jobPostingId);

    Result delete(int userId, int jobPostingId);

    DataResult<List<Favorite>> findAll();

    DataResult<List<Favorite>> findByUserId(int id);
    
}
