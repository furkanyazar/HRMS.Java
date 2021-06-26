package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.ActivationEmployerService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;

@RestController
@RequestMapping("/api/activationemployers")
@CrossOrigin
public class ActivationEmployersController {

    private ActivationEmployerService activationEmployerService;

    @Autowired
    public ActivationEmployersController(ActivationEmployerService activationEmployerService) {
        super();
        this.activationEmployerService = activationEmployerService;
    }

    @GetMapping("/getisactivated")
    public DataResult<List<ActivationEmployer>> getIsActivated(Boolean isActivated) {
        return activationEmployerService.findByIsActivated(isActivated);
    }

    @GetMapping("findbyforlogin")
    public DataResult<ActivationEmployer> findByIsActivatedAndUser_EmailAndUser_Password(Boolean isActivated,
            String email, String password) {
                return activationEmployerService.findByIsActivatedAndUser_EmailAndUser_Password(isActivated, email, password);
    }

}
