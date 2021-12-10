package com.xtremax.security.service;

import com.xtremax.security.model.User;
import com.xtremax.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository repository;

  @Override
  public User findUsername(String username) {
    return repository.findByUsername(username);
  }
}
