package furkanyazar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.UserService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/findbyidandpassword")
    public DataResult<User> findByIdAndPassword(int id, String password) {
        return userService.findByIdAndPassword(id, password);
    }

    @PostMapping("/setnewpassword")
    public Result setNewAdminPassword(String oldPassword, String newPassword, int id) {
        return userService.setNewPassword(new User(), oldPassword, newPassword, id);
    }
    
}
