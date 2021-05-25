package furkanyazar.hrms.business.concretes.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import furkanyazar.hrms.entities.concretes.Employer;

public class EmailCheckHelper {

	public static boolean checkEmail(Employer employer) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@" + employer.getWebsite(), Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(employer.getEmail());
		return matcher.find();
	}

}
