package com.xtremax.security.service;

import com.xtremax.security.model.User;

public interface UserService {
  User findUsername(String username);
}
