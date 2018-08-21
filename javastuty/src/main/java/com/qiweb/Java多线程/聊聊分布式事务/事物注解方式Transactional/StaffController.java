package com.qiweb.Java多线程.聊聊分布式事务.事物注解方式Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController { 
 @Autowired
 StaffService staffService; 
 
 //测试回滚情况 
 @RequestMapping("/rollback") 
 public Staff rollback(Staff staff) { 
 return staffService.saveStaffWithRollBack(staff); 
 } 
 
 //测试不回滚情况 
 @RequestMapping("/notrollback") 
 public Staff noRollBack(Staff staff) { 
 return staffService.saveStaffWithoutRollBack(staff); 
 } 
} 