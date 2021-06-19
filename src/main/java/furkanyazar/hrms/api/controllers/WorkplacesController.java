package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.WorkplaceService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.entities.concretes.Workplace;

@RestController
@RequestMapping("/api/workplaces")
@CrossOrigin
public class WorkplacesController {

    private WorkplaceService workplaceService;

    @Autowired
    public WorkplacesController(WorkplaceService workplaceService) {
        super();
        this.workplaceService = workplaceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Workplace>> getAll() {
        return workplaceService.getAll();
    }
    
}
