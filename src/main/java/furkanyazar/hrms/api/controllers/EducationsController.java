package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.EducationService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return educationService.add(education);
	}
	
	@GetMapping("/findByUserIdOrderByEndingDateDesc")
	public DataResult<List<Education>> findByUserIdOrderByEndingDateDesc(int userId) {
		return educationService.findByUserIdOrderByEndingDateDesc(userId);
	}

	@GetMapping("/findByUserId")
	public DataResult<List<Education>> findByUserId(int userId) {
		return educationService.findByUserId(userId);
	}

	@PostMapping("/remove")
	public Result remove(int id) {
		return educationService.remove(id);
	}
	
}
