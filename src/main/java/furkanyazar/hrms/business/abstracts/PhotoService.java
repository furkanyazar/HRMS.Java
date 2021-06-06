package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Photo;

public interface PhotoService {
	
	Result add(Photo photo);

	DataResult<Photo> findByUserIs(int userId);

}
