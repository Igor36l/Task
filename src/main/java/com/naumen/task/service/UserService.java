package com.naumen.task.service;

import com.naumen.task.entity.User;

import java.util.List;

public interface UserService {

    List<User> updateUsersFromExternalService(Long departmentId);


}
