
package com.doublechaintech.ugc.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface ObjectAccessManager{

		

	public ObjectAccess createObjectAccess(UgcUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(UgcUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(UgcUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(UgcUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(UgcUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(UgcUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


