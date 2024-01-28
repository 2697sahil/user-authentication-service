package com.theSahil.userauthenticationservice.utils;

import com.theSahil.userauthenticationservice.model.SignupRequest;
import com.theSahil.userauthenticationservice.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User signupReqToUser(SignupRequest signupRequest);
}
