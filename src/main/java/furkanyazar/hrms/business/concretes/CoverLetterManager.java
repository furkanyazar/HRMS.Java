package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.CoverLetterService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.CoverLetterDao;
import furkanyazar.hrms.entities.concretes.CoverLetter;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class CoverLetterManager implements CoverLetterService {
	
	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter, User user) {
		coverLetter.setArticle("");
		coverLetter.setUser(user);
		coverLetterDao.save(coverLetter);
		return new Result(true, "Önyazı eklendi");
	}

	@Override
	public DataResult<CoverLetter> findByUserId(int userId) {
		return new SuccessDataResult<CoverLetter>(coverLetterDao.findByUserId(userId), "Data döndü");
	}

	@Override
	public Result edit(String coverLetter, int id) {
		try {
			CoverLetter tempCoverLetter = findByUserId(id).getData();

			tempCoverLetter.setArticle(coverLetter);
			
			coverLetterDao.save(tempCoverLetter);

			return new Result(true, "Bilgiler kaydedildi");
		} catch (Exception e) {
			return new Result(false, "Bir hata oluştu");
		}
	}

}
