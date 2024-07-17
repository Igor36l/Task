package com.naumen.task.dto;

import java.time.LocalDate;

public record UserDto(
        String login,
        String fullName,
        String phoneNumber,
        String email,
        LocalDate birthDay
) {
}
