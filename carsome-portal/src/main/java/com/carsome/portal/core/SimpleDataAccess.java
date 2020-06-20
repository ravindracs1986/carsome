
package com.carsome.portal.core;

import java.util.List;


public interface SimpleDataAccess<S extends AbstractEntity> {

	public <T extends AbstractEntity>S create(final S s);
	
	public <T extends AbstractEntity>S update(final S s);
	
	public <T extends AbstractEntity>S find(final Integer id);
	
	public <T extends AbstractEntity>List<S> findAll() ;
	
	public boolean delete(final Integer id);
	
}
