package com.blood_donar.bloodconnect.dto;

public record AuthResponse(
        String message,
        String token,
        Long userId,
        String fullName,
        String email,
        String role
) {}