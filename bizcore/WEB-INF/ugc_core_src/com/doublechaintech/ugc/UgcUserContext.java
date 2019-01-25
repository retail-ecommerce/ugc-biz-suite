package com.doublechaintech.ugc;

public interface UgcUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(UgcChecker checker);
	UgcChecker getChecker();
	
	void saveAccessInfo(String beanName, String methodName, Object[] parameters);
	void addFootprint(FootprintProducer helper) throws Exception;
	Object getPreviousViewPage() throws Exception;
	Object getLastViewPage() throws Exception;
	Object goback() throws Exception;
}

