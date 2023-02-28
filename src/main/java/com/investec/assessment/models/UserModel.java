package com.investec.assessment.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserModel implements Serializable {
  private String firstName;
  private String lastName;
  private String mobileNumber;
  private String idNumber;
  private String physicalAddress;


}
