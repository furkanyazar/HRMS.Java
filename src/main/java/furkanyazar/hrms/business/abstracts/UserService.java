package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.User;

public interface UserService {

    DataResult<User> findByIdAndPassword(int id, String password);

    Result setNewPassword(User user, String oldPassword, String newPassword, int id);

}
