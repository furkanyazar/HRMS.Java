package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.PhotoService;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.PhotoDao;
import furkanyazar.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {
	
	private PhotoDao photoDao;

	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public Result add(Photo photo) {
		photoDao.save(photo);
		return new Result(true, "Resim yüklendi");
	}

}
