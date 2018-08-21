package com.qiweb.Java多线程.聊聊分布式事务.事物注解方式Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
 
} 