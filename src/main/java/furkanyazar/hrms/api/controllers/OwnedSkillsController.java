package furkanyazar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.OwnedSkillService;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.OwnedSkill;

@RestController
@RequestMapping("/api/ownedskills")
public class OwnedSkillsController {
	
	private OwnedSkillService ownedSkillService;

	@Autowired
	public OwnedSkillsController(OwnedSkillService ownedSkillService) {
		super();
		this.ownedSkillService = ownedSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody OwnedSkill ownedSkill) {
		return ownedSkillService.add(ownedSkill);
	}

}
