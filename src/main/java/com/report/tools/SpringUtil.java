package com.report.tools;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static final String xmlPath="classpath:spring/ApplicationContext.xml";
	
	private static ClassPathXmlApplicationContext context;
	
	@SuppressWarnings("resource")
	public static Object getBean(String beanName) {
		if(context==null) {
			context=new ClassPathXmlApplicationContext(xmlPath);
		}
		return context.getBean(beanName);
	}
	
	public static void close() {
		if(context!=null) {
			context.close();
		}
	}
}
