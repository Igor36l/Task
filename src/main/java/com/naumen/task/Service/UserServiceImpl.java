package com.naumen.task.Service;

import com.naumen.task.Dto.UserDto;
import com.naumen.task.Repository.UserRepository;
import com.naumen.task.entity.User;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ExternalUserService externalUserService;

    public UserServiceImpl(UserRepository userRepository, ExternalUserService externalUserService) {
        this.userRepository = userRepository;
        this.externalUserService = externalUserService;
    }

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public List<User> updateUsersFromExternalService(Long departmentId) {
        List<User> usersToUpdate = userRepository.findByDepartmentIdAndUpdateDateBefore(
                departmentId, LocalDateTime.now().minusDays(30));

        List<User> updatedUsers = new ArrayList<>();
        for (User user : usersToUpdate) {
            try {
                UserDto userDto = externalUserService.getUserByLogin(user.getLogin());
                user.setFullName(userDto.fullName());
                user.setEmail(userDto.email());
                user.setUpdateDate(LocalDateTime.now());
                userRepository.save(user);
                updatedUsers.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return updatedUsers;
    }

}
