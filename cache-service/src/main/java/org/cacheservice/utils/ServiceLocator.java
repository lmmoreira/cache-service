package org.cacheservice.utils;

import java.util.ServiceLoader;

public class ServiceLocator {

	public static <E> E getServiceImplementation(Class<E> interf) {

		ServiceLoader<E> loader = ServiceLoader.load(interf);
		
		E item = null;
		
		for (E service : loader) {
            item = service;
        }
		
		return item;
		
	}

}
