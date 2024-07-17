package com.naumen.task.Service;

import com.naumen.task.Dto.UserDto;

public interface ExternalUserService {
    UserDto getUserByLogin(String login);
}
