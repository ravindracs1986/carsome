
package com.carsome.portal.core;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MessageSource messageSource;

	protected String getCurrUserId(HttpServletRequest request) {
		return String.valueOf(request.getAttribute("currUserId"));
	}

	public static <K, V> List<SortedMap<K, V>> splitMap(final SortedMap<K, V> map, final int size) {
		List<K> keys = new ArrayList<>(map.keySet());
		List<SortedMap<K, V>> parts = new ArrayList<>();
		final int listSize = map.size();
		for (int i = 0; i < listSize; i += size) {
			if (i + size < listSize) {
				parts.add(map.subMap(keys.get(i), keys.get(i + size)));
			} else {
				parts.add(map.tailMap(keys.get(i)));
			}
		}
		return parts;
	}

}