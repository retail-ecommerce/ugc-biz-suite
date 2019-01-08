
package com.doublechaintech.ugc.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface ProductManager{

		

	public Product createProduct(UgcUserContext userContext, String name, String platformId, BigDecimal avarageScore) throws Exception;	
	public Product updateProduct(UgcUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(UgcUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(UgcUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(UgcUserContext userContext, Product product,Map<String,Object>option) throws Exception;
	
	public Product transferToAnotherPlatform(UgcUserContext userContext, String productId, String anotherPlatformId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RatingManager getRatingManager(UgcUserContext userContext, String productId, String userId, int score ,String [] tokensExpr)  throws Exception;
	
	public  Product addRating(UgcUserContext userContext, String productId, String userId, int score , String [] tokensExpr)  throws Exception;
	public  Product removeRating(UgcUserContext userContext, String productId, String ratingId, int ratingVersion,String [] tokensExpr)  throws Exception;
	public  Product updateRating(UgcUserContext userContext, String productId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReviewManager getReviewManager(UgcUserContext userContext, String productId, String title, String content, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Product addReview(UgcUserContext userContext, String productId, String title, String content, String userId , String [] tokensExpr)  throws Exception;
	public  Product removeReview(UgcUserContext userContext, String productId, String reviewId, int reviewVersion,String [] tokensExpr)  throws Exception;
	public  Product updateReview(UgcUserContext userContext, String productId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BlogManager getBlogManager(UgcUserContext userContext, String productId, String title, String content, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Product addBlog(UgcUserContext userContext, String productId, String title, String content, String userId , String [] tokensExpr)  throws Exception;
	public  Product removeBlog(UgcUserContext userContext, String productId, String blogId, int blogVersion,String [] tokensExpr)  throws Exception;
	public  Product updateBlog(UgcUserContext userContext, String productId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


