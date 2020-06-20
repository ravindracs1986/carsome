package com.carsome.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsome.portal.core.GenericRepository;
import com.carsome.portal.persist.entity.SubsorContacts;
import com.carsome.portal.persist.repo.SuborContactRepo;



@Service("suborContactService")
@Scope("prototype")
@Qualifier("suborContactService")
@Transactional
public class SuborContactService extends com.carsome.portal.core.AbstractService<SubsorContacts,Integer>{

	
	@Autowired SuborContactRepo suborContactRepo;
	@Override
	public GenericRepository<SubsorContacts> primaryDao() {
		return suborContactRepo;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<SubsorContacts> getSubsorContacts(String email){
		List<SubsorContacts> usr= suborContactRepo.getSubsorContacts(email);
		return usr;
	}

}
