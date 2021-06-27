package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.CoverLetter;
import furkanyazar.hrms.entities.concretes.User;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter, User user);

	DataResult<CoverLetter> findByUserId(int userId);

	Result edit(String coverLetter, int id);
	
}
