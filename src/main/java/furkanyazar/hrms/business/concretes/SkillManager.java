package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.SkillService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.SkillDao;
import furkanyazar.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        super();
        this.skillDao = skillDao;
    }

    @Override
    public DataResult<List<Skill>> findAll() {
        return new SuccessDataResult<List<Skill>>(skillDao.findAll());
    }
    
}
