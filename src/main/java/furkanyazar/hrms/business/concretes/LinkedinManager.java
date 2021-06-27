package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.LinkedinService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.LinkedinDao;
import furkanyazar.hrms.entities.concretes.Linkedin;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class LinkedinManager implements LinkedinService {
	
	private LinkedinDao linkedinDao;

	@Autowired
	public LinkedinManager(LinkedinDao linkedinDao) {
		super();
		this.linkedinDao = linkedinDao;
	}

	@Override
	public Result add(Linkedin linkedin, User user) {
		linkedin.setLinkedinLink("");
		linkedin.setUser(user);
		linkedinDao.save(linkedin);
		return new Result(true, "Linkedin hesabı eklendi");
	}

	@Override
	public DataResult<Linkedin> findByUserId(int userId) {
		return new SuccessDataResult<Linkedin>(linkedinDao.findByUserId(userId), "Data döndü");
	}

	@Override
	public Result edit(String linkedin, int id) {
		try {
			Linkedin tempLinkedin = findByUserId(id).getData();

			tempLinkedin.setLinkedinLink(linkedin);

			linkedinDao.save(tempLinkedin);

			return new Result(true, "Bilgiler kaydedildi");
		} catch (Exception e) {
			return new Result(false, "Bir hata oluştu");
		}
	}

}
