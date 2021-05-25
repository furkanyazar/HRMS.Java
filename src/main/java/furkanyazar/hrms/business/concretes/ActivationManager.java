package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.ActivationService;
import furkanyazar.hrms.business.concretes.helpers.ActivationCodeCreator;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.ActivationDao;
import furkanyazar.hrms.entities.concretes.Activation;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class ActivationManager implements ActivationService {
	
	private ActivationDao activationDao;

	@Autowired
	public ActivationManager(ActivationDao activationDao) {
		super();
		this.activationDao = activationDao;
	}

	@Override
	public DataResult<List<Activation>> getAll() {
		return new SuccessDataResult<List<Activation>>(activationDao.findAll(), "Aktivasyonlar listelendi");
	}

	@Override
	public Result add(Activation activation, User user) {
		activation.setActivationCode(ActivationCodeCreator.createRandomCode());
		activation.setIsActivated(false);
		activation.setUserId(user.getId());
		activationDao.save(activation);
		return new Result(true, "Aktivasyon eklendi");
	}

}
