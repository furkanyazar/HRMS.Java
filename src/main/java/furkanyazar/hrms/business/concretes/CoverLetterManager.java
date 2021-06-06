package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.CoverLetterService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.CoverLetterDao;
import furkanyazar.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {
	
	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new Result(true, "Önyazı eklendi");
	}

	@Override
	public DataResult<CoverLetter> findByUserId(int userId) {
		return new SuccessDataResult<CoverLetter>(coverLetterDao.findByUserId(userId), "Data döndü");
	}

}
