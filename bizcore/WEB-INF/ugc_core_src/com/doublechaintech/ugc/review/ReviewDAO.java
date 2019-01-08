
package com.doublechaintech.ugc.review;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;
import com.doublechaintech.ugc.MultipleAccessKey;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.product.ProductDAO;
import com.doublechaintech.ugc.profile.ProfileDAO;


public interface ReviewDAO{

	
	public Review load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Review> reviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Review present(Review review,Map<String,Object> options) throws Exception;
	public Review clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Review save(Review review,Map<String,Object> options);
	public SmartList<Review> saveReviewList(SmartList<Review> reviewList,Map<String,Object> options);
	public SmartList<Review> removeReviewList(SmartList<Review> reviewList,Map<String,Object> options);
	public SmartList<Review> findReviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countReviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countReviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String reviewId, int version) throws Exception;
	public Review disconnectFromAll(String reviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Review> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Review> findReviewByUser(String profileId, Map<String,Object> options);
 	public int countReviewByUser(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countReviewByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<Review> findReviewByUser(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeReviewByUser(SmartList<Review> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Review> findReviewByProduct(String productId, Map<String,Object> options);
 	public int countReviewByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countReviewByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Review> findReviewByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeReviewByProduct(SmartList<Review> resultList, String productId, Map<String,Object> options);

 
 }


