package com.qiweb.Java多线程.聊聊分布式事务.事物注解方式Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Staff { 
 @Id
 @GeneratedValue
 private Long id; 
 private String name; 
 private Integer age; 
 private String address;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public Staff() {
 super(); 
 } 
 
 public Staff(Long id, String name, Integer age, String address) { 
 super(); 
 this.id = id; 
 this.name = name; 
 this.age = age; 
 this.address = address; 
 } 
 //省略get、set方法 
} 