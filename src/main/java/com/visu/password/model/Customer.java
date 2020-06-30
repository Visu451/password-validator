package com.visu.password.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "userid")
  private String userid;
  @Column(name = "password")
  private String password;

  protected Customer() {}

  public Customer(String userid, String password) {
    this.userid = userid;
    this.password = password;
  }
  
  public Long getId() {
	return id;
  }
  
  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userid=" + userid + ", password=" + password + "]";
	}
  
  
}
