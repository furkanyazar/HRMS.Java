package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.GithubService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.dataAccess.abstracts.GithubDao;
import furkanyazar.hrms.entities.concretes.Github;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class GithubManager implements GithubService {
	
	private GithubDao githubDao;

	@Autowired
	public GithubManager(GithubDao githubDao) {
		super();
		this.githubDao = githubDao;
	}

	@Override
	public Result add(Github github, User user) {
		github.setGithubLink("");
		github.setUser(user);
		githubDao.save(github);
		return new Result(true, "Github adresi eklendi");
	}

	@Override
	public DataResult<Github> findByUserId(int userId) {
		return new DataResult<Github>(githubDao.findByUserId(userId), true);
	}

	@Override
	public Result edit(String github, int id) {
		try {
			Github tempGithub = findByUserId(id).getData();

			tempGithub.setGithubLink(github);

			githubDao.save(tempGithub);

			return new Result(true, "Bilgiler kaydedildi");
		} catch (Exception e) {
			return new Result(false, "Bir hata oluştu");
		}
	}

}
