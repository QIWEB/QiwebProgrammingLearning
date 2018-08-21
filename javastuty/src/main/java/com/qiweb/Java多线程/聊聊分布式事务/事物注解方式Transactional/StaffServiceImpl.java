package com.qiweb.Java多线程.聊聊分布式事务.事物注解方式Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StaffServiceImpl implements StaffService { 
 
 @Autowired
 StaffRepository staffRepository; //可以直接注入我们的RersonRepository的Bean。 
 
 @Override 
 //使用@Transactional注解的rollbackFor属性，指定特定异常时，数据回滚。 
 @Transactional(rollbackFor = {IllegalArgumentException.class})
 public Staff saveStaffWithRollBack(Staff staff) { 
 Staff s = staffRepository.save(staff); 
 if (staff.getName().equals("张三")) { 
  throw new IllegalArgumentException("张三已经存在了，rollback"); 
 } 
 return s; 
 } 
 
 @Override 
 public Staff saveStaffWithoutRollBack(Staff staff) { 
 Staff s = staffRepository.save(staff); 
 if (staff.getName().equals("张三")) { 
  throw new IllegalArgumentException("张三已经存在了，数据不回滚"); 
 } 
 return s; 
 } 
} 