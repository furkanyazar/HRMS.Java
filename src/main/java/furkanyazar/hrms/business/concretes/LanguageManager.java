package furkanyazar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.LanguageService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.LanguageDao;
import furkanyazar.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        super();
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> findAll() {
        return new SuccessDataResult<List<Language>>(languageDao.findAll());
    }
    
}
