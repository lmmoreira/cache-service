package org.cacheservice.domain;

import java.util.Vector;

public class CacheService {

	private Vector<CacheServiceItem> cache;
	
	public CacheService() {
		super();
		this.cache = new Vector<CacheServiceItem>();
	}

	public Vector<CacheServiceItem> getCache() {
		return cache;
	}

	public void setCache(Vector<CacheServiceItem> cache) {
		this.cache = cache;
	}
	
}
