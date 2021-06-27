package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Photo;
import furkanyazar.hrms.entities.concretes.User;

public interface PhotoService {
	
	Result add(Photo photo, User user);

	DataResult<Photo> findByUserIs(int userId);

}
