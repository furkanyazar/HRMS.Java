package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.KnownLanguageService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.KnownLanguageDao;
import furkanyazar.hrms.entities.concretes.KnownLanguage;

@Service
public class KnownLanguageManager implements KnownLanguageService {
	
	private KnownLanguageDao knownLanguageDao;

	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
	}

	@Override
	public Result add(KnownLanguage knownLanguage) {
		knownLanguageDao.save(knownLanguage);
		return new Result(true, "Dil eklendi");
	}

	@Override
	public DataResult<List<KnownLanguage>> findByUserId(int userId) {
		return new SuccessDataResult<List<KnownLanguage>>(knownLanguageDao.findByUserId(userId), "Data döndü");
	}

}
