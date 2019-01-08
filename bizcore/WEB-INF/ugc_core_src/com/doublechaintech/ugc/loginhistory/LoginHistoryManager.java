
package com.doublechaintech.ugc.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface LoginHistoryManager{

		

	public LoginHistory createLoginHistory(UgcUserContext userContext, String fromIp, String description, String secUserId) throws Exception;	
	public LoginHistory updateLoginHistory(UgcUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(UgcUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(UgcUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(UgcUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;
	
	public LoginHistory transferToAnotherSecUser(UgcUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


