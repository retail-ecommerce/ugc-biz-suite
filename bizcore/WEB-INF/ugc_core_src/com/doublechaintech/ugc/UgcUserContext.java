package com.doublechaintech.ugc;

public interface UgcUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(UgcChecker checker);
	UgcChecker getChecker();
}

