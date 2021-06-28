package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.entities.concretes.Skill;

public interface SkillService {

    DataResult<List<Skill>> findAll();
    
}
