package furkanyazar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.CoverLetterService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
@CrossOrigin
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	/*
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return coverLetterService.add(coverLetter);
	}*/

	@GetMapping("/findByUserId")
	public DataResult<CoverLetter> findByUserId(int userId) {
		return coverLetterService.findByUserId(userId);
	}
	
}
