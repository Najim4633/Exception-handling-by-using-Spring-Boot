package com.jsp.restapiwithvalidation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.restapiwithvalidation.entity.Bottle;

public interface BottleDao extends JpaRepository<Bottle, Integer> {

}
