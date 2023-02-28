package com.investec.assessment.controllers;

import com.investec.assessment.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IUserManagerService;
import validations.UserModelValidator;

@RestController
@RequestMapping("/api/userManager")
public class UserManagerController {

  @Autowired
  private IUserManagerService userManagerService;

  @GetMapping("/getAll")
  public List<UserModel> retrieveUserModel(){

    return userManagerService.getAllUser("MK");

  }

}
