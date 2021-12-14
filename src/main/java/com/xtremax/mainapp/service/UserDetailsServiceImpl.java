//package com.xtremax.mainapp.service;
//
//import com.xtremax.mainapp.model.Role;
//import com.xtremax.mainapp.model.User;
//import com.xtremax.mainapp.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//  @Autowired
//  private UserRepository repository;
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//   User user = repository.findByUsername(username);
////
////    if(user == null) {
////      throw new UsernameNotFoundException("User not found.");
////    }
////
////    if(user.getRoles() == null || user.getRoles().isEmpty()) {
////      throw new UsernameNotFoundException("User not authorized.");
////    }
////
////    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
////    for (Role role : user.getRoles()) {
////      System.out.println("current user: " + user.getUsername());
////      System.out.println("role >" + role.getLabel());
////      grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
////    }
//    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//    return new org.springframework.security.core.userdetails.User(
//        user.getUsername(), user.getPassword(), grantedAuthorities);
//  }
//}
