package furkanyazar.hrms.business.concretes.helpers;

import furkanyazar.hrms.entities.concretes.Employee;

public class EmployeeCheckHelper {

	public static boolean checkFields(Employee employee) {
		if (employee.getEmail().isEmpty() || employee.getPassword().isEmpty() || employee.getName().isEmpty()
				|| employee.getSurname().isEmpty() || employee.getIdentityNumber().isEmpty()
				|| employee.getDateOfBirth().toString().isEmpty()) {
			return false;
		}

		return true;
	}

}
