package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.EmployerService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.Employer;
import furkanyazar.hrms.entities.concretes.Update;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return employerService.add(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}
	
	@GetMapping("/findbyemail")
	public DataResult<List<Employer>> findByEmail(String email) {
		return employerService.findByEmail(email);
	}

	@GetMapping("/findbyid")
	public DataResult<Employer> getById(int id) {
		return employerService.getById(id);
	}

	@PostMapping("/setIsActivated")
	public Result setIsActivated(Boolean isActivated, int id) {
		return employerService.setIsActivated(new ActivationEmployer(), new Employer(), isActivated, id);
	}

	@GetMapping("/findbyemailandpassword")
	public DataResult<Employer> findByEmailAndPassword(String email, String password) {
		return employerService.findByEmailAndPassword(email, password);
	}

	@PostMapping("/edit")
	public Result edit(@RequestBody Update update, int id) {
		return employerService.edit(update, id);
	}

}
