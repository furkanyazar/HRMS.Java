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
import furkanyazar.hrms.business.abstracts.UpdateService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Update;

@RestController
@RequestMapping("/api/updates")
@CrossOrigin
public class UpdatesController {

    private UpdateService updateService;
    private EmployerService employerService;

    @Autowired
    public UpdatesController(UpdateService updateService, EmployerService employerService) {
        super();
        this.updateService = updateService;
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Result add(int userId, @RequestBody Update update) {
        update.setUser(employerService.getById(userId).getData());
        return updateService.add(update);
    }

    @GetMapping("/getall")
    public DataResult<List<Update>> getAll() {
        return updateService.getAll();
    }

    @GetMapping("/findbyuserid")
    public DataResult<Update> findByUserId(int userId) {
        return updateService.findByUserId(userId);
    }

    @PostMapping("/edit")
    public Result edit(int userId) {
        return updateService.update(userId);
    }
    
}
