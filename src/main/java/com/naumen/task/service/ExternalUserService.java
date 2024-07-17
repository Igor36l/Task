package com.naumen.task.service;

import com.naumen.task.dto.UserDto;

public interface ExternalUserService {
    UserDto getUserByLogin(String login);
}
