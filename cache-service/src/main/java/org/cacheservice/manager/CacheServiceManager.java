package org.cacheservice.manager;

import java.util.ArrayList;
import java.util.List;

import org.cacheservice.context.ContextManager;
import org.cacheservice.domain.CacheService;
import org.cacheservice.domain.CacheServiceItem;
import org.cacheservice.utils.ServiceLocator;

public class CacheServiceManager {

	public Object getCachedItem(CacheServiceItem forCacheItem) {
		
		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		CacheService cacheService = contextManager.getCacheService();
		
		for(CacheServiceItem item : cacheService.getCache()){
		
			if(forCacheItem.equals(item)){
				return item.getValue();
			}
			
		}
		
		return null;
		
	}
	
	public void addCacheItem(CacheServiceItem forCacheItem){
		
		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		CacheService cacheService = contextManager.getCacheService();
		
		CacheServiceItem item = new CacheServiceItem();
		item.setName(forCacheItem.getName());
		item.setScope(forCacheItem.getScope());
		item.setValue(forCacheItem.getValue());
		
		cacheService.getCache().add(item);
		
	}
	
	public void delCacheItem(String scope){
		
		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		CacheService cacheService = contextManager.getCacheService();
		
		List<CacheServiceItem> itens = new ArrayList<CacheServiceItem>(cacheService.getCache());
		
		for(CacheServiceItem item : itens){

			if(item.getScope().equals(scope)) {
				cacheService.getCache().remove(item);
			}
			
		}
		
	}
	
	public void delCacheItem(String scope, String name){
		
		ContextManager contextManager = (ContextManager) ServiceLocator.getServiceImplementation(ContextManager.class);

		CacheService cacheService = contextManager.getCacheService();
		
		List<CacheServiceItem> itens = new ArrayList<CacheServiceItem>(cacheService.getCache());
		
		for(CacheServiceItem item : itens){

			if((item.getScope().equals(scope)) && (item.getName().equals(name))){
				cacheService.getCache().remove(item);
			}
			
		}
		
	}
	
}
