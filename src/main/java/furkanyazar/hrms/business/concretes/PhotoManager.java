package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.PhotoService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.PhotoDao;
import furkanyazar.hrms.entities.concretes.Photo;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class PhotoManager implements PhotoService {
	
	private PhotoDao photoDao;

	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public Result add(Photo photo, User user) {
		photo.setPhotoLink("https://www.pngitem.com/pimgs/m/78-786293_1240-x-1240-0-avatar-profile-icon-png.png");
		photo.setUser(user);
		photoDao.save(photo);
		return new Result(true, "Resim yüklendi");
	}

	@Override
	public DataResult<Photo> findByUserIs(int userId) {
		return new SuccessDataResult<Photo>(photoDao.findByUserId(userId), "Data döndü");
	}

}
