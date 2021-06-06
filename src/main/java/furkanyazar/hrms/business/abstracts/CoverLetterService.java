package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	
}
