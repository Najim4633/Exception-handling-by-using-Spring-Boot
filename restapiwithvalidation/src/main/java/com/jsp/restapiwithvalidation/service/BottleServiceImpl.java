package com.jsp.restapiwithvalidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.restapiwithvalidation.entity.Bottle;
import com.jsp.restapiwithvalidation.exception.NoResourseFoundException;
import com.jsp.restapiwithvalidation.exception.ResourseAlreadyExist;
import com.jsp.restapiwithvalidation.repo.BottleDao;

@Service
public class BottleServiceImpl implements BottleService {

	@Autowired
	BottleDao dao;
	public BottleServiceImpl() {
	}
	@Override
	public Bottle storeBottle(Bottle bottle) {
		if(dao.findById(bottle.getId()).isPresent()) throw new ResourseAlreadyExist("This id already present");
		return dao.save(bottle);
	}
	@Override
	public Bottle findBottleById(int id) {
		
		Optional<Bottle> byId = dao.findById(id);
		if(byId.isPresent()) return byId.get();
		else throw new NoResourseFoundException(id+" id not found in Bottle");
	}
	@Override
	public List<Bottle> findAllBottles() {
		if(dao.findAll().isEmpty()) throw new NoResourseFoundException( " No data is Present to display");
		return dao.findAll();
	}
	@Override
	public void deleteBottleById(int id) {
		if(!dao.existsById(id)) throw new NoResourseFoundException(id+ " id is not present to delete");
		else dao.deleteById(id);
	}
	@Override
	public Bottle updateBottleByID(int id, Bottle bottle) {
		if(!dao.existsById(id)) throw new NoResourseFoundException(id+" id is not present to update");
		
		Bottle bottle2 = dao.findById(id).get();
		bottle2.setColor(bottle.getColor());
		bottle2.setPrice(bottle.getPrice());
		return dao.save(bottle2) ;
	}
	@Override
	public Bottle patchBottleByColor(int id, String color) {
		if(!dao.existsById(id)) throw new NoResourseFoundException(id+" id is not present to patch");
		Bottle bottle = dao.findById(id).get();
		bottle.setColor(color);
		return dao.save(bottle);
	}

}
