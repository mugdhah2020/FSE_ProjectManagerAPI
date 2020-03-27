package com.cts.fse.pm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.pm.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long>{

}
