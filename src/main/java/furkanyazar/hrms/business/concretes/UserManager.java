package furkanyazar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanyazar.hrms.business.abstracts.UserService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.core.utilities.results.SuccessDataResult;
import furkanyazar.hrms.dataAccess.abstracts.UserDao;
import furkanyazar.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> findByIdAndPassword(int id, String password) {
        return new SuccessDataResult<User>(userDao.findByIdAndPassword(id, password));
    }

    @Override
    public Result setNewPassword(User user, String oldPassword, String newPassword, int id) {
        try {
            user = findByIdAndPassword(id, oldPassword).getData();
            user.setPassword(newPassword);
            userDao.save(user);
            return new Result(true, "Şifre değiştirildi");
        } catch (Exception e) {
            return new Result(false, "Eski şifre hatalı");
        }
    }

}
