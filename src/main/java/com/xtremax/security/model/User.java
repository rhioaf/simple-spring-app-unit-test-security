package com.xtremax.security.model;


import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ")
  @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQUENCE", allocationSize = 1)
  private Long id;

  @Column(name = "USERNAME")
  @NotNull
  private String username;

  @Column(name = "PASSWORD")
  @NotNull
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE",
      joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
  private Set<Role> roles;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
