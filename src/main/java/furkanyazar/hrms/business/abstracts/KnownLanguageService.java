package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageService {
	
	Result add(KnownLanguage knownLanguage);

	DataResult<List<KnownLanguage>> findByUserId(int userId);

}
