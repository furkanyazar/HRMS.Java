package furkanyazar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.GithubService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Github;

@RestController
@RequestMapping("/api/githubs")
@CrossOrigin
public class GithubsController {
	
	private GithubService githubService;

	@Autowired
	public GithubsController(GithubService githubService) {
		super();
		this.githubService = githubService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Github github) {
		return githubService.add(github);
	}

	@GetMapping("findByUserId")
	public DataResult<Github> findByUserId(int userId) {
		return githubService.findByUserId(userId);
	}

}
