package furkanyazar.hrms.business.concretes.helpers;

import java.util.Random;

public class ActivationCodeCreator {
	
	public static String createRandomCode() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String code = "";
		Random random = new Random();
		
		for (int i = 0; i < 6; i++) {
			code += chars.charAt(random.nextInt(chars.length()));
		}
		
		return code;
	}

}
