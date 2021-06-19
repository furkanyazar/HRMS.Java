package furkanyazar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.LinkedinService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Linkedin;

@RestController
@RequestMapping("/api/linkedins")
@CrossOrigin
public class LinkedinsController {
	
	private LinkedinService linkedinService;

	@Autowired
	public LinkedinsController(LinkedinService linkedinService) {
		super();
		this.linkedinService = linkedinService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Linkedin linkedin) {
		return linkedinService.add(linkedin);
	}

	@GetMapping("/findByUserId")
	public DataResult<Linkedin> findByUserId(int userId) {
		return linkedinService.findByUserId(userId);
	}

}
