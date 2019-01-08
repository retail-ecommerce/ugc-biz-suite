
package com.doublechaintech.ugc.profile;
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


public interface ProfileDAO{

	
	public Profile load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Profile> profileList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Profile present(Profile profile,Map<String,Object> options) throws Exception;
	public Profile clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Profile save(Profile profile,Map<String,Object> options);
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options);
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProfileWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String profileId, int version) throws Exception;
	public Profile disconnectFromAll(String profileId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RatingDAO getRatingDAO();
		
	public ReviewDAO getReviewDAO();
		
	public BlogDAO getBlogDAO();
		
	
 	public SmartList<Profile> requestCandidateProfileForRating(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForReview(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Profile> requestCandidateProfileForBlog(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Profile planToRemoveRatingList(Profile profile, String ratingIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with product in Rating
	public Profile planToRemoveRatingListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception;
	public int countRatingListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveReviewList(Profile profile, String reviewIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with product in Review
	public Profile planToRemoveReviewListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception;
	public int countReviewListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception;
	
	public Profile planToRemoveBlogList(Profile profile, String blogIds[], Map<String,Object> options)throws Exception;


	//disconnect Profile with product in Blog
	public Profile planToRemoveBlogListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception;
	public int countBlogListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Profile> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, Map<String,Object> options);
 	public int countProfileByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options);

 
 }


