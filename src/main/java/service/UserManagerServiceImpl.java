package service;

import com.investec.assessment.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserManagerServiceImpl implements IUserManagerService{

  @Override
  public List<UserModel> getAllUser(String searchParam) {
    List<UserModel> userModelList = new ArrayList<>();

    UserModel userModel = new UserModel(
        "MK",
        "Khanyile",
        "081 12345 55",
        "9912125640089",
        "74 Glover RD Johannesburg");

    userModelList.add(userModel);

    return userModelList;
  }

  @Override
  public List<UserModel> addUser(UserModel userModel) {
    return null;
  }
}
