package com.naumen.task.Service;

import com.naumen.task.entity.User;

import java.util.List;

public interface UserService {

    List<User> updateUsersFromExternalService(Long departmentId);


}
