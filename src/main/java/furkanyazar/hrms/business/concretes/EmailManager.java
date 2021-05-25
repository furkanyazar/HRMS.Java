package furkanyazar.hrms.business.concretes;

import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.EmailService;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessResult;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email gönderildi: " + user.getEmail());
	}

}
