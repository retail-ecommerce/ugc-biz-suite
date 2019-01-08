
package com.doublechaintech.ugc.product;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.BaseEntity;


import com.doublechaintech.ugc.Message;
import com.doublechaintech.ugc.SmartList;
import com.doublechaintech.ugc.MultipleAccessKey;

import com.doublechaintech.ugc.UgcUserContext;
//import com.doublechaintech.ugc.BaseManagerImpl;
import com.doublechaintech.ugc.UgcCheckerManager;
import com.doublechaintech.ugc.CustomUgcCheckerManager;

import com.doublechaintech.ugc.review.Review;
import com.doublechaintech.ugc.rating.Rating;
import com.doublechaintech.ugc.platform.Platform;
import com.doublechaintech.ugc.blog.Blog;

import com.doublechaintech.ugc.platform.CandidatePlatform;

import com.doublechaintech.ugc.product.Product;
import com.doublechaintech.ugc.profile.Profile;






public class ProductManagerImpl extends CustomUgcCheckerManager implements ProductManager {
	
	private static final String SERVICE_TYPE = "Product";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductManagerException(message);

	}
	
	

 	protected Product saveProduct(UgcUserContext userContext, Product product, String [] tokensExpr) throws Exception{	
 		//return getProductDAO().save(product, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProduct(userContext, product, tokens);
 	}
 	
 	protected Product saveProductDetail(UgcUserContext userContext, Product product) throws Exception{	

 		
 		return saveProduct(userContext, product, allTokens());
 	}
 	
 	public Product loadProduct(UgcUserContext userContext, String productId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	
 	 public Product searchProduct(UgcUserContext userContext, String productId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	

 	protected Product present(UgcUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		Product  productToPresent = userContext.getDAOGroup().getProductDAO().present(product, tokens);
		
		List<BaseEntity> entityListToNaming = productToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductDAO().alias(entityListToNaming);
		
		return  productToPresent;
		
		
	}
 
 	
 	
 	public Product loadProductDetail(UgcUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, allTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	
 	public Object view(UgcUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, viewTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	protected Product saveProduct(UgcUserContext userContext, Product product, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductDAO().save(product, tokens);
 	}
 	protected Product loadProduct(UgcUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 
 		return userContext.getDAOGroup().getProductDAO().load(productId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UgcUserContext userContext, Product product, Map<String, Object> tokens){
		super.addActions(userContext, product, tokens);
		
		addAction(userContext, product, tokens,"@create","createProduct","createProduct/","main","primary");
		addAction(userContext, product, tokens,"@update","updateProduct","updateProduct/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"@copy","cloneProduct","cloneProduct/"+product.getId()+"/","main","primary");
		
		addAction(userContext, product, tokens,"product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.addRating","addRating","addRating/"+product.getId()+"/","ratingList","primary");
		addAction(userContext, product, tokens,"product.removeRating","removeRating","removeRating/"+product.getId()+"/","ratingList","primary");
		addAction(userContext, product, tokens,"product.updateRating","updateRating","updateRating/"+product.getId()+"/","ratingList","primary");
		addAction(userContext, product, tokens,"product.copyRatingFrom","copyRatingFrom","copyRatingFrom/"+product.getId()+"/","ratingList","primary");
		addAction(userContext, product, tokens,"product.addReview","addReview","addReview/"+product.getId()+"/","reviewList","primary");
		addAction(userContext, product, tokens,"product.removeReview","removeReview","removeReview/"+product.getId()+"/","reviewList","primary");
		addAction(userContext, product, tokens,"product.updateReview","updateReview","updateReview/"+product.getId()+"/","reviewList","primary");
		addAction(userContext, product, tokens,"product.copyReviewFrom","copyReviewFrom","copyReviewFrom/"+product.getId()+"/","reviewList","primary");
		addAction(userContext, product, tokens,"product.addBlog","addBlog","addBlog/"+product.getId()+"/","blogList","primary");
		addAction(userContext, product, tokens,"product.removeBlog","removeBlog","removeBlog/"+product.getId()+"/","blogList","primary");
		addAction(userContext, product, tokens,"product.updateBlog","updateBlog","updateBlog/"+product.getId()+"/","blogList","primary");
		addAction(userContext, product, tokens,"product.copyBlogFrom","copyBlogFrom","copyBlogFrom/"+product.getId()+"/","blogList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UgcUserContext userContext, Product product, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Product createProduct(UgcUserContext userContext,String name, String platformId, BigDecimal avarageScore) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProduct(name);
		userContext.getChecker().checkAvarageScoreOfProduct(avarageScore);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);


		Product product=createNewProduct();	

		product.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		product.setPlatform(platform);
		
		
		product.setAvarageScore(avarageScore);

		product = saveProduct(userContext, product, emptyOptions());
		
		onNewInstanceCreated(userContext, product);
		return product;

		
	}
	protected Product createNewProduct() 
	{
		
		return new Product();		
	}
	
	protected void checkParamsForUpdatingProduct(UgcUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct( productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}		

		
		if(Product.AVARAGE_SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkAvarageScoreOfProduct(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
		
	}
	
	
	
	public Product clone(UgcUserContext userContext, String fromProductId) throws Exception{
		
		return userContext.getDAOGroup().getProductDAO().clone(fromProductId, this.allTokens());
	}
	
	public Product internalSaveProduct(UgcUserContext userContext, Product product) throws Exception 
	{
		return internalSaveProduct(userContext, product, allTokens());

	}
	public Product internalSaveProduct(UgcUserContext userContext, Product product, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			
			product = saveProduct(userContext, product, options);
			return product;
			
		}

	}
	
	public Product updateProduct(UgcUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	
	public Product updateProductProperty(UgcUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductTokens tokens(){
		return ProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRatingListWith("id","desc")
		.sortReviewListWith("id","desc")
		.sortBlogListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(UgcUserContext userContext, String productId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherPlatform(UgcUserContext userContext, String productId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, productId,anotherPlatformId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			product.updatePlatform(platform);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(UgcUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UgcUserContext userContext, String productId, int productVersion) throws Exception {
		//deleteInternal(userContext, productId, productVersion);		
	}
	protected void deleteInternal(UgcUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		userContext.getDAOGroup().getProductDAO().delete(productId, productVersion);
	}
	
	public Product forgetByAll(UgcUserContext userContext, String productId, int productVersion) throws Exception {
		return forgetByAllInternal(userContext, productId, productVersion);		
	}
	protected Product forgetByAllInternal(UgcUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductDAO().disconnectFromAll(productId, productVersion);
	}
	

	
	public int deleteAll(UgcUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UgcUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductDAO().deleteAll();
	}


	//disconnect Product with user in Rating
	protected Product breakWithRatingByUser(UgcUserContext userContext, String productId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Product product = loadProduct(userContext, productId, allTokens());

			synchronized(product){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProductDAO().planToRemoveRatingListWithUser(product, userId, this.emptyOptions());

				product = saveProduct(userContext, product, tokens().withRatingList().done());
				return product;
			}
	}
	//disconnect Product with user in Review
	protected Product breakWithReviewByUser(UgcUserContext userContext, String productId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Product product = loadProduct(userContext, productId, allTokens());

			synchronized(product){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProductDAO().planToRemoveReviewListWithUser(product, userId, this.emptyOptions());

				product = saveProduct(userContext, product, tokens().withReviewList().done());
				return product;
			}
	}
	//disconnect Product with user in Blog
	protected Product breakWithBlogByUser(UgcUserContext userContext, String productId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Product product = loadProduct(userContext, productId, allTokens());

			synchronized(product){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProductDAO().planToRemoveBlogListWithUser(product, userId, this.emptyOptions());

				product = saveProduct(userContext, product, tokens().withBlogList().done());
				return product;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRating(UgcUserContext userContext, String productId, String userId, int score,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkUserIdOfRating(userId);
		
		userContext.getChecker().checkScoreOfRating(score);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addRating(UgcUserContext userContext, String productId, String userId, int score, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRating(userContext,productId,userId, score,tokensExpr);
		
		Rating rating = createRating(userContext,userId, score);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addRating( rating );		
			product = saveProduct(userContext, product, tokens().withRatingList().done());
			
			userContext.getManagerGroup().getRatingManager().onNewInstanceCreated(userContext, rating);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRatingProperties(UgcUserContext userContext, String productId,String id,int score,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfRating(id);
		
		userContext.getChecker().checkScoreOfRating( score);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateRatingProperties(UgcUserContext userContext, String productId, String id,int score, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRatingProperties(userContext,productId,id,score,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRatingListList()
				.searchRatingListWith(Rating.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getRatingList().isEmpty()){
			throw new ProductManagerException("Rating is NOT FOUND with id: '"+id+"'");
		}
		
		Rating item = productToUpdate.getRatingList().first();
		
		item.updateScore( score );

		
		//checkParamsForAddingRating(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withRatingList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Rating createRating(UgcUserContext userContext, String userId, int score) throws Exception{

		Rating rating = new Rating();
		
		
		Profile  user = new Profile();
		user.setId(userId);		
		rating.setUser(user);		
		rating.setScore(score);		
		rating.setUpdateTime(userContext.now());
	
		
		return rating;
	
		
	}
	
	protected Rating createIndexedRating(String id, int version){

		Rating rating = new Rating();
		rating.setId(id);
		rating.setVersion(version);
		return rating;			
		
	}
	
	protected void checkParamsForRemovingRatingList(UgcUserContext userContext, String productId, 
			String ratingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String ratingId: ratingIds){
			userContext.getChecker().checkIdOfRating(ratingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeRatingList(UgcUserContext userContext, String productId, 
			String ratingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRatingList(userContext, productId,  ratingIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveRatingList(product, ratingIds, allTokens());
				product = saveProduct(userContext, product, tokens().withRatingList().done());
				deleteRelationListInGraph(userContext, product.getRatingList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRating(UgcUserContext userContext, String productId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeRating(UgcUserContext userContext, String productId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRating(userContext,productId, ratingId, ratingVersion,tokensExpr);
		
		Rating rating = createIndexedRating(ratingId, ratingVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeRating( rating );		
			product = saveProduct(userContext, product, tokens().withRatingList().done());
			deleteRelationInGraph(userContext, rating);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRating(UgcUserContext userContext, String productId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copyRatingFrom(UgcUserContext userContext, String productId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRating(userContext,productId, ratingId, ratingVersion,tokensExpr);
		
		Rating rating = createIndexedRating(ratingId, ratingVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			rating.updateUpdateTime(userContext.now());
			
			product.copyRatingFrom( rating );		
			product = saveProduct(userContext, product, tokens().withRatingList().done());
			
			userContext.getManagerGroup().getRatingManager().onNewInstanceCreated(userContext, (Rating)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRating(UgcUserContext userContext, String productId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		

		if(Rating.SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkScoreOfRating(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateRating(UgcUserContext userContext, String productId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRating(userContext, productId, ratingId, ratingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRatingList().searchRatingListWith(Rating.ID_PROPERTY, "eq", ratingId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeRating( rating );	
			//make changes to AcceleraterAccount.
			Rating ratingIndex = createIndexedRating(ratingId, ratingVersion);
		
			Rating rating = product.findTheRating(ratingIndex);
			if(rating == null){
				throw new ProductManagerException(rating+" is NOT FOUND" );
			}
			
			rating.changeProperty(property, newValueExpr);
			rating.updateUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().withRatingList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingReview(UgcUserContext userContext, String productId, String title, String content, String userId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkTitleOfReview(title);
		
		userContext.getChecker().checkContentOfReview(content);
		
		userContext.getChecker().checkUserIdOfReview(userId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addReview(UgcUserContext userContext, String productId, String title, String content, String userId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReview(userContext,productId,title, content, userId,tokensExpr);
		
		Review review = createReview(userContext,title, content, userId);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addReview( review );		
			product = saveProduct(userContext, product, tokens().withReviewList().done());
			
			userContext.getManagerGroup().getReviewManager().onNewInstanceCreated(userContext, review);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingReviewProperties(UgcUserContext userContext, String productId,String id,String title,String content,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfReview(id);
		
		userContext.getChecker().checkTitleOfReview( title);
		userContext.getChecker().checkContentOfReview( content);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateReviewProperties(UgcUserContext userContext, String productId, String id,String title,String content, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingReviewProperties(userContext,productId,id,title,content,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withReviewListList()
				.searchReviewListWith(Review.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getReviewList().isEmpty()){
			throw new ProductManagerException("Review is NOT FOUND with id: '"+id+"'");
		}
		
		Review item = productToUpdate.getReviewList().first();
		
		item.updateTitle( title );
		item.updateContent( content );

		
		//checkParamsForAddingReview(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withReviewList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Review createReview(UgcUserContext userContext, String title, String content, String userId) throws Exception{

		Review review = new Review();
		
		
		review.setTitle(title);		
		review.setContent(content);		
		Profile  user = new Profile();
		user.setId(userId);		
		review.setUser(user);		
		review.setUpdateTime(userContext.now());
	
		
		return review;
	
		
	}
	
	protected Review createIndexedReview(String id, int version){

		Review review = new Review();
		review.setId(id);
		review.setVersion(version);
		return review;			
		
	}
	
	protected void checkParamsForRemovingReviewList(UgcUserContext userContext, String productId, 
			String reviewIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String reviewId: reviewIds){
			userContext.getChecker().checkIdOfReview(reviewId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeReviewList(UgcUserContext userContext, String productId, 
			String reviewIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingReviewList(userContext, productId,  reviewIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveReviewList(product, reviewIds, allTokens());
				product = saveProduct(userContext, product, tokens().withReviewList().done());
				deleteRelationListInGraph(userContext, product.getReviewList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingReview(UgcUserContext userContext, String productId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeReview(UgcUserContext userContext, String productId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReview(userContext,productId, reviewId, reviewVersion,tokensExpr);
		
		Review review = createIndexedReview(reviewId, reviewVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeReview( review );		
			product = saveProduct(userContext, product, tokens().withReviewList().done());
			deleteRelationInGraph(userContext, review);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingReview(UgcUserContext userContext, String productId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copyReviewFrom(UgcUserContext userContext, String productId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReview(userContext,productId, reviewId, reviewVersion,tokensExpr);
		
		Review review = createIndexedReview(reviewId, reviewVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			review.updateUpdateTime(userContext.now());
			
			product.copyReviewFrom( review );		
			product = saveProduct(userContext, product, tokens().withReviewList().done());
			
			userContext.getManagerGroup().getReviewManager().onNewInstanceCreated(userContext, (Review)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingReview(UgcUserContext userContext, String productId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		

		if(Review.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfReview(parseString(newValueExpr));
		}
		
		if(Review.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfReview(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateReview(UgcUserContext userContext, String productId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReview(userContext, productId, reviewId, reviewVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withReviewList().searchReviewListWith(Review.ID_PROPERTY, "eq", reviewId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeReview( review );	
			//make changes to AcceleraterAccount.
			Review reviewIndex = createIndexedReview(reviewId, reviewVersion);
		
			Review review = product.findTheReview(reviewIndex);
			if(review == null){
				throw new ProductManagerException(review+" is NOT FOUND" );
			}
			
			review.changeProperty(property, newValueExpr);
			review.updateUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().withReviewList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingBlog(UgcUserContext userContext, String productId, String title, String content, String userId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkTitleOfBlog(title);
		
		userContext.getChecker().checkContentOfBlog(content);
		
		userContext.getChecker().checkUserIdOfBlog(userId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addBlog(UgcUserContext userContext, String productId, String title, String content, String userId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBlog(userContext,productId,title, content, userId,tokensExpr);
		
		Blog blog = createBlog(userContext,title, content, userId);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addBlog( blog );		
			product = saveProduct(userContext, product, tokens().withBlogList().done());
			
			userContext.getManagerGroup().getBlogManager().onNewInstanceCreated(userContext, blog);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBlogProperties(UgcUserContext userContext, String productId,String id,String title,String content,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfBlog(id);
		
		userContext.getChecker().checkTitleOfBlog( title);
		userContext.getChecker().checkContentOfBlog( content);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateBlogProperties(UgcUserContext userContext, String productId, String id,String title,String content, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBlogProperties(userContext,productId,id,title,content,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBlogListList()
				.searchBlogListWith(Blog.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getBlogList().isEmpty()){
			throw new ProductManagerException("Blog is NOT FOUND with id: '"+id+"'");
		}
		
		Blog item = productToUpdate.getBlogList().first();
		
		item.updateTitle( title );
		item.updateContent( content );

		
		//checkParamsForAddingBlog(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withBlogList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Blog createBlog(UgcUserContext userContext, String title, String content, String userId) throws Exception{

		Blog blog = new Blog();
		
		
		blog.setTitle(title);		
		blog.setContent(content);		
		Profile  user = new Profile();
		user.setId(userId);		
		blog.setUser(user);		
		blog.setUpdateTime(userContext.now());
	
		
		return blog;
	
		
	}
	
	protected Blog createIndexedBlog(String id, int version){

		Blog blog = new Blog();
		blog.setId(id);
		blog.setVersion(version);
		return blog;			
		
	}
	
	protected void checkParamsForRemovingBlogList(UgcUserContext userContext, String productId, 
			String blogIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String blogId: blogIds){
			userContext.getChecker().checkIdOfBlog(blogId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeBlogList(UgcUserContext userContext, String productId, 
			String blogIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBlogList(userContext, productId,  blogIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveBlogList(product, blogIds, allTokens());
				product = saveProduct(userContext, product, tokens().withBlogList().done());
				deleteRelationListInGraph(userContext, product.getBlogList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBlog(UgcUserContext userContext, String productId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeBlog(UgcUserContext userContext, String productId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBlog(userContext,productId, blogId, blogVersion,tokensExpr);
		
		Blog blog = createIndexedBlog(blogId, blogVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeBlog( blog );		
			product = saveProduct(userContext, product, tokens().withBlogList().done());
			deleteRelationInGraph(userContext, blog);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBlog(UgcUserContext userContext, String productId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copyBlogFrom(UgcUserContext userContext, String productId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBlog(userContext,productId, blogId, blogVersion,tokensExpr);
		
		Blog blog = createIndexedBlog(blogId, blogVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			blog.updateUpdateTime(userContext.now());
			
			product.copyBlogFrom( blog );		
			product = saveProduct(userContext, product, tokens().withBlogList().done());
			
			userContext.getManagerGroup().getBlogManager().onNewInstanceCreated(userContext, (Blog)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBlog(UgcUserContext userContext, String productId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		

		if(Blog.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfBlog(parseString(newValueExpr));
		}
		
		if(Blog.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfBlog(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateBlog(UgcUserContext userContext, String productId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBlog(userContext, productId, blogId, blogVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBlogList().searchBlogListWith(Blog.ID_PROPERTY, "eq", blogId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeBlog( blog );	
			//make changes to AcceleraterAccount.
			Blog blogIndex = createIndexedBlog(blogId, blogVersion);
		
			Blog blog = product.findTheBlog(blogIndex);
			if(blog == null){
				throw new ProductManagerException(blog+" is NOT FOUND" );
			}
			
			blog.changeProperty(property, newValueExpr);
			blog.updateUpdateTime(userContext.now());
			product = saveProduct(userContext, product, tokens().withBlogList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UgcUserContext userContext, Product newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


