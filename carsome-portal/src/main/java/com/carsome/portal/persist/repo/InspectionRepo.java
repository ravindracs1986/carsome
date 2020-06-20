package com.carsome.portal.persist.repo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carsome.portal.core.GenericRepository;
import com.carsome.portal.persist.entity.Inspection;




@Repository
@RepositoryDefinition(domainClass=Inspection.class, idClass=Integer.class)
@Scope("prototype")
@Qualifier("inspectionRepo")
public interface InspectionRepo extends GenericRepository<Inspection> {

	@Query("select inspection from Inspection inspection where inspection.slotDate = :slotDate")
	public List<Inspection> findbyslotDate(@Param("slotDate") Date slotDate);
	
	
}
