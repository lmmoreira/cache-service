package org.cacheservice.aop;

import org.cacheservice.annotation.ClearCache;
import org.cacheservice.manager.CacheServiceManager;

public aspect CacheServiceDelInterceptor {

	CacheServiceManager cacheManager = new CacheServiceManager();
	
	pointcut handlers (ClearCache annotation):  
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
	
	Object around(ClearCache annotation) : handlers(annotation)  {
		
		String scope = annotation.scope();
		String[] name = annotation.name();
		
		if((name == null) || ((name.length == 1) && (name[0].isEmpty()))){
			cacheManager.delCacheItem(scope);
		}
			
		for(String nameItem : name){
			cacheManager.delCacheItem(scope, nameItem);
		}
			
		return proceed(annotation);
		
	}

}
