package com.xtremax.security.service;

import com.xtremax.security.model.Role;
import com.xtremax.security.model.User;
import com.xtremax.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByUsername(username);

    if(user == null) {
      throw new UsernameNotFoundException("User not found.");
    }

    if(user.getRoles() == null || user.getRoles().isEmpty()) {
      throw new UsernameNotFoundException("User not authorized.");
    }

    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    for (Role role : user.getRoles()) {
      System.out.println("current user: " + user.getUsername());
      System.out.println("role >" + role.getLabel());
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
    }

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}
