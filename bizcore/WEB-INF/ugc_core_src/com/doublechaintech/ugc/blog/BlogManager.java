
package com.doublechaintech.ugc.blog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface BlogManager{

		

	public Blog createBlog(UgcUserContext userContext, String title, String content, String userId, String productId) throws Exception;	
	public Blog updateBlog(UgcUserContext userContext,String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Blog loadBlog(UgcUserContext userContext, String blogId, String [] tokensExpr) throws Exception;
	public Blog internalSaveBlog(UgcUserContext userContext, Blog blog) throws Exception;
	public Blog internalSaveBlog(UgcUserContext userContext, Blog blog,Map<String,Object>option) throws Exception;
	
	public Blog transferToAnotherUser(UgcUserContext userContext, String blogId, String anotherUserId)  throws Exception;
 	public Blog transferToAnotherProduct(UgcUserContext userContext, String blogId, String anotherProductId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String blogId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Blog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


