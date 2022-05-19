package com.tds.modules.service;

import com.tds.modules.domain.User;



public interface UserLoginService {
    User findByUsername(String username);
}
