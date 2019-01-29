
package com.doublechaintech.ugc.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(UgcUserContext userContext, String name, String mobile, String platformId) throws Exception;	
	public Profile updateProfile(UgcUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(UgcUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(UgcUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(UgcUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(UgcUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RatingManager getRatingManager(UgcUserContext userContext, String profileId, String productId, int score ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRating(UgcUserContext userContext, String profileId, String productId, int score , String [] tokensExpr)  throws Exception;
	public  Profile removeRating(UgcUserContext userContext, String profileId, String ratingId, int ratingVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRating(UgcUserContext userContext, String profileId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReviewManager getReviewManager(UgcUserContext userContext, String profileId, String title, String content, String productId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addReview(UgcUserContext userContext, String profileId, String title, String content, String productId , String [] tokensExpr)  throws Exception;
	public  Profile removeReview(UgcUserContext userContext, String profileId, String reviewId, int reviewVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateReview(UgcUserContext userContext, String profileId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BlogManager getBlogManager(UgcUserContext userContext, String profileId, String title, String content, String productId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addBlog(UgcUserContext userContext, String profileId, String title, String content, String productId , String [] tokensExpr)  throws Exception;
	public  Profile removeBlog(UgcUserContext userContext, String profileId, String blogId, int blogVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateBlog(UgcUserContext userContext, String profileId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


