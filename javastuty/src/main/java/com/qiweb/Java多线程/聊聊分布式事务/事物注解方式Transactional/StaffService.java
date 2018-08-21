package com.qiweb.Java多线程.聊聊分布式事务.事物注解方式Transactional;

public interface StaffService {
 public Staff saveStaffWithRollBack(Staff staff);//回滚 
 public Staff saveStaffWithoutRollBack(Staff staff);//不回滚 
} 