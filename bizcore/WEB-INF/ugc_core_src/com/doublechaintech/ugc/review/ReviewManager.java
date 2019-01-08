
package com.doublechaintech.ugc.review;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface ReviewManager{

		

	public Review createReview(UgcUserContext userContext, String title, String content, String userId, String productId) throws Exception;	
	public Review updateReview(UgcUserContext userContext,String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Review loadReview(UgcUserContext userContext, String reviewId, String [] tokensExpr) throws Exception;
	public Review internalSaveReview(UgcUserContext userContext, Review review) throws Exception;
	public Review internalSaveReview(UgcUserContext userContext, Review review,Map<String,Object>option) throws Exception;
	
	public Review transferToAnotherUser(UgcUserContext userContext, String reviewId, String anotherUserId)  throws Exception;
 	public Review transferToAnotherProduct(UgcUserContext userContext, String reviewId, String anotherProductId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String reviewId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Review newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


