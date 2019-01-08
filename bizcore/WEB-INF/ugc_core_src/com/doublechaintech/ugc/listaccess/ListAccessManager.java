
package com.doublechaintech.ugc.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface ListAccessManager{

		

	public ListAccess createListAccess(UgcUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception;	
	public ListAccess updateListAccess(UgcUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(UgcUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(UgcUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(UgcUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;
	
	public ListAccess transferToAnotherApp(UgcUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


