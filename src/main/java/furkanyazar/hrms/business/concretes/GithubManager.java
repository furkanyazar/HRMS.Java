package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.GithubService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.GithubDao;
import furkanyazar.hrms.entities.concretes.Github;

@Service
public class GithubManager implements GithubService {
	
	private GithubDao githubDao;

	@Autowired
	public GithubManager(GithubDao githubDao) {
		super();
		this.githubDao = githubDao;
	}

	@Override
	public Result add(Github github) {
		githubDao.save(github);
		return new Result(true, "Github adresi eklendi");
	}

	@Override
	public DataResult<Github> findByUserId(int userId) {
		return new DataResult<Github>(githubDao.findByUserId(userId), true);
	}

}
