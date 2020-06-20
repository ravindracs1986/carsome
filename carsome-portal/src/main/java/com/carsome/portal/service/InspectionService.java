package com.carsome.portal.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsome.portal.core.GenericRepository;
import com.carsome.portal.persist.entity.Inspection;
import com.carsome.portal.persist.repo.InspectionRepo;



@Service("inspectionService")
@Scope("prototype")
@Qualifier("inspectionService")
@Transactional
public class InspectionService extends com.carsome.portal.core.AbstractService<Inspection,Integer>{

	
	@Autowired InspectionRepo inspectionRepo;
	
	@Override
	public GenericRepository<Inspection> primaryDao() {
		return inspectionRepo;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<Inspection> findbyslotDate(Date slotDate){
		List<Inspection> blogDetails= inspectionRepo.findbyslotDate(slotDate);
		return blogDetails;
	}
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Inspection createInspectionSlot(Inspection inspection) {
		return inspectionRepo.saveAndFlush(inspection);
	}
	
	

}
