package furkanyazar.hrms.business.concretes.helpers;

import furkanyazar.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {

	public static boolean checkFields(Employer employer) {
		if (employer.getEmail().isEmpty() || employer.getPassword().isEmpty() || employer.getCompanyName().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getWebsite().isEmpty()) {
			return false;
		}

		return true;
	}

}
