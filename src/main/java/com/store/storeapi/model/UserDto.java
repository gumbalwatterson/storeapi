package com.store.storeapi.model;

import lombok.Builder;

@Builder
public record UserDto(String firstName, String lastName, String address, String country, String email,
                      String phoneNumber,
                      String password) {
}
