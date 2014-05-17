package org.cacheservice.aop;

import org.cacheservice.annotation.Cache;
import org.cacheservice.domain.CacheServiceItem;
import org.cacheservice.manager.CacheServiceManager;

public aspect CacheServiceAddInterceptor {

	CacheServiceManager cacheManager = new CacheServiceManager();
	
	pointcut handlers (Cache annotation):  
						   within(!org.cacheservice..*) &&
						   within(!sun..*) &&	
						   within(!java..*) &&
						   within(!javax..*) &&
						   within(!org.apache..*) &&
						   within(!net.sf.cglib..*) &&
						   within(!org.ajax4jsf..*) &&
						   within(!org.richfaces..*) &&
						   within(!com.sun..*) &&
						   within(!org.springframework..*) && 
						   execution(* *(..)) && @annotation(annotation);
	
	Object around(Cache annotation) : handlers(annotation)  {
		
		CacheServiceItem item = new CacheServiceItem();
		item.setName(annotation.name());
		item.setScope(annotation.scope());
		
		Object value = cacheManager.getCachedItem(item);
		
		if(value == null){

			value = proceed(annotation);
			
			item.setValue(value);
			
			cacheManager.addCacheItem(item);
			
		}
			
		return value;
		
	}

}
