package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.KnownLanguageService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.KnownLanguage;

@RestController
@RequestMapping("/api/knownlanguages")
@CrossOrigin
public class KnownLanguagesController {
	
	private KnownLanguageService knownLanguageService;

	@Autowired
	public KnownLanguagesController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody KnownLanguage knownLanguage) {
		return knownLanguageService.add(knownLanguage);
	}

	@GetMapping("/findByUserId")
	public DataResult<List<KnownLanguage>> findByUserId(int userId) {
		return knownLanguageService.findByUserId(userId);
	}

}
