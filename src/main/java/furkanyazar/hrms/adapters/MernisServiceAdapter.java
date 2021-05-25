package furkanyazar.hrms.adapters;

import java.rmi.RemoteException;

import furkanyazar.hrms.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService {

	@SuppressWarnings("deprecation")
	@Override
	public Boolean validate(Employee employee) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		Boolean result;

		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()),
					employee.getName(), employee.getSurname(), employee.getDateOfBirth().getYear());
		} catch (NumberFormatException e) {
			result = false;
			e.printStackTrace();
		} catch (RemoteException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

}
