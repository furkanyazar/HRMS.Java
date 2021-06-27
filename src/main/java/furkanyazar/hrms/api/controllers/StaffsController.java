package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.StaffService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staffs")
@CrossOrigin
public class StaffsController {
	
	private StaffService staffService;

	@Autowired
	public StaffsController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Staff staff) {
		return staffService.add(staff);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Staff>> getAll() {
		return staffService.getAll();
	}

	@GetMapping("/findbyemailandpassword")
	public DataResult<Staff> findByEmail(String email, String password) {
		return staffService.findByEmailAndPassword(email, password);
	}

	@GetMapping("/findbyuserid")
	public DataResult<Staff> findByUserId(int id) {
		return staffService.findById(id);
	}

	@PostMapping("/edit")
	public Result edit(@RequestBody Staff staff, int id) {
		return staffService.edit(staff, id);
	}

}
