
package com.doublechaintech.ugc.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(UgcUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(UgcUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(UgcUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(UgcUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(UgcUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(UgcUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(UgcUserContext userContext, String platformId, String name, BigDecimal avarageScore ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProduct(UgcUserContext userContext, String platformId, String name, BigDecimal avarageScore , String [] tokensExpr)  throws Exception;
	public  Platform removeProduct(UgcUserContext userContext, String platformId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProduct(UgcUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(UgcUserContext userContext, String platformId, String name, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(UgcUserContext userContext, String platformId, String name, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(UgcUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(UgcUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


