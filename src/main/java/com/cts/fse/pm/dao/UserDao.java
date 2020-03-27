package com.cts.fse.pm.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.pm.entity.User;

public interface UserDao extends JpaRepository<User, Long>{


}
