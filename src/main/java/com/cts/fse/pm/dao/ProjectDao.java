package com.cts.fse.pm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.pm.entity.Project;

public interface ProjectDao extends JpaRepository<Project, Long>{

}
