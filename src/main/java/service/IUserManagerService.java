package service;

import com.investec.assessment.models.UserModel;
import java.util.List;

public interface IUserManagerService {

  List<UserModel> getAllUser(String searchParam);

  List<UserModel> addUser(UserModel userModel);

}
