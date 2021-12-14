package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.User;
import com.xtremax.mainapp.repository.UserRepository;
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
