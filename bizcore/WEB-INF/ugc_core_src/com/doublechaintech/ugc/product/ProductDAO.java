
package com.doublechaintech.ugc.product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;
import com.doublechaintech.ugc.MultipleAccessKey;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.rating.RatingDAO;
import com.doublechaintech.ugc.platform.PlatformDAO;
import com.doublechaintech.ugc.review.ReviewDAO;
import com.doublechaintech.ugc.blog.BlogDAO;


public interface ProductDAO{

	
	public Product load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Product> productList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Product present(Product product,Map<String,Object> options) throws Exception;
	public Product clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Product save(Product product,Map<String,Object> options);
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> findProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String productId, int version) throws Exception;
	public Product disconnectFromAll(String productId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RatingDAO getRatingDAO();
		
	public ReviewDAO getReviewDAO();
		
	public BlogDAO getBlogDAO();
		
	
 	public SmartList<Product> requestCandidateProductForRating(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Product> requestCandidateProductForReview(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Product> requestCandidateProductForBlog(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Product planToRemoveRatingList(Product product, String ratingIds[], Map<String,Object> options)throws Exception;


	//disconnect Product with user in Rating
	public Product planToRemoveRatingListWithUser(Product product, String userId, Map<String,Object> options)throws Exception;
	public int countRatingListWithUser(String productId, String userId, Map<String,Object> options)throws Exception;
	
	public Product planToRemoveReviewList(Product product, String reviewIds[], Map<String,Object> options)throws Exception;


	//disconnect Product with user in Review
	public Product planToRemoveReviewListWithUser(Product product, String userId, Map<String,Object> options)throws Exception;
	public int countReviewListWithUser(String productId, String userId, Map<String,Object> options)throws Exception;
	
	public Product planToRemoveBlogList(Product product, String blogIds[], Map<String,Object> options)throws Exception;


	//disconnect Product with user in Blog
	public Product planToRemoveBlogListWithUser(Product product, String userId, Map<String,Object> options)throws Exception;
	public int countBlogListWithUser(String productId, String userId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Product> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Product> findProductByPlatform(String platformId, Map<String,Object> options);
 	public int countProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByPlatform(SmartList<Product> resultList, String platformId, Map<String,Object> options);

 
 }


