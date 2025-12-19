package com.jsp.restapiwithvalidation.service;

import java.util.List;

import com.jsp.restapiwithvalidation.entity.Bottle;

public interface BottleService {
	Bottle storeBottle(Bottle Bottle);
	Bottle findBottleById(int id);
	List<Bottle> findAllBottles();
	void deleteBottleById(int id);
	Bottle updateBottleByID(int id, Bottle bottle);
	Bottle patchBottleByColor(int id,String color);
}
