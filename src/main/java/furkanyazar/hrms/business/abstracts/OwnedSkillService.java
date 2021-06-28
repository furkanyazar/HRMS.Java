package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.OwnedSkill;

public interface OwnedSkillService {
	
	Result add(OwnedSkill ownedSkill);

	DataResult<List<OwnedSkill>> findByUserId(int userId);

	DataResult<OwnedSkill> findById(int id);

	Result remove(int id);

}
