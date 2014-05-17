package br.cacheservice.app;

import org.cacheservice.context.ContextManager;
import org.cacheservice.domain.CacheService;

public class ContextManagerImpl implements ContextManager {
	
	static CacheService cacheService = new CacheService();

	public CacheService getCacheService() {
		return cacheService;
	}

}
