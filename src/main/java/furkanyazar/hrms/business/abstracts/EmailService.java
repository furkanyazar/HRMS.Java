package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.User;

public interface EmailService {
	
	Result sendEmail(User user);

}
