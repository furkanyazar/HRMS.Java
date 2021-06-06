package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Github;

public interface GithubService {
	
	Result add(Github github);

	DataResult<Github> findByUserId(int userId);

}
