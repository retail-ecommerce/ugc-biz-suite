
package com.doublechaintech.ugc.rating;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface RatingManager{

		

	public Rating createRating(UgcUserContext userContext, String userId, String productId, int score) throws Exception;	
	public Rating updateRating(UgcUserContext userContext,String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Rating loadRating(UgcUserContext userContext, String ratingId, String [] tokensExpr) throws Exception;
	public Rating internalSaveRating(UgcUserContext userContext, Rating rating) throws Exception;
	public Rating internalSaveRating(UgcUserContext userContext, Rating rating,Map<String,Object>option) throws Exception;
	
	public Rating transferToAnotherUser(UgcUserContext userContext, String ratingId, String anotherUserId)  throws Exception;
 	public Rating transferToAnotherProduct(UgcUserContext userContext, String ratingId, String anotherProductId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String ratingId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Rating newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


