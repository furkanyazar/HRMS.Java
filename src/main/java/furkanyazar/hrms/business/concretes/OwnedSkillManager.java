package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.OwnedSkillService;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.OwnedSkillDao;
import furkanyazar.hrms.entities.concretes.OwnedSkill;

@Service
public class OwnedSkillManager implements OwnedSkillService {
	
	private OwnedSkillDao ownedSkillDao;

	@Autowired
	public OwnedSkillManager(OwnedSkillDao ownedSkillDao) {
		super();
		this.ownedSkillDao = ownedSkillDao;
	}

	@Override
	public Result add(OwnedSkill ownedSkill) {
		ownedSkillDao.save(ownedSkill);
		return new Result(true, "Yetenek eklendi");
	}

}
