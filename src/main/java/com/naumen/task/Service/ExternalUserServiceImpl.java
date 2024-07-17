package com.naumen.task.Service;

import com.naumen.task.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalUserServiceImpl implements ExternalUserService{

    private final RestClient restClient;

    public ExternalUserServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    public UserDto getUserByLogin(String login) {
        ResponseEntity<UserDto> response = restClient.get()
                .uri("/user/{login}", login)
                .retrieve()
                .toEntity(UserDto.class);
        return response.getBody();
    }
}
