package com.vuluu.project.service.template;

import com.vuluu.project.dto.request.authen.RegisterModel;
import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.request.forupdate.URequestUser;
import com.vuluu.project.dto.request.forupdate.UUserPermission;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.entities.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {

  /**
   * get all user in system
   *
   * @return  List<LResponseUser>
   */
  List<LResponseUser> getAll();
  /**
   * Create new user
   *
   * @param user
   */
  void createUser(User user);

  /**
   * Login to syllabus system
   *
   * @param email
   * @param password
   * @param response
   * @return DResponseUser
   */
  DResponseUser login(String email, String password, HttpServletResponse response);

  /**
   * Register new account
   *
   * @param registerModel
   * @return DResponseUser
   */
  DResponseUser registerUser(RegisterModel registerModel);

  /**
   * Create a new user by admin
   *
   * @param cRequestUser
   * @param request
   * @return DResponseUser
   */
  DResponseUser createUser(CRequestUser cRequestUser, HttpServletRequest request);

  /**
   * update user info
   *
   * @param uRequestUser
   * @param request
   * @return DResponseUser
   */
  DResponseUser updateUserInfo(URequestUser uRequestUser, HttpServletRequest request);

  /**
   * update user permission in system
   * @param userPermission
   * @return DResponseUser
   */
  DResponseUser updateUserUserPermission(UUserPermission userPermission);
}
