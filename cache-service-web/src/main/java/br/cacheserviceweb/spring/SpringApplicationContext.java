package br.cacheserviceweb.spring;

import org.cacheservice.context.ContextManager;
import org.cacheservice.domain.CacheService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware, ContextManager{

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }

    public Object getBean(Class<?> beanType) {
	return CONTEXT.getBean(beanType);
    }

	@Override
	public CacheService getCacheService() {
		return (CacheService) this.getBean(CacheService.class);
	}
	
}