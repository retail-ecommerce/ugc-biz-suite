
package com.doublechaintech.ugc.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;
import com.doublechaintech.ugc.MultipleAccessKey;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.product.ProductDAO;
import com.doublechaintech.ugc.profile.ProfileDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	public ProfileDAO getProfileDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForProduct(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProfile(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


