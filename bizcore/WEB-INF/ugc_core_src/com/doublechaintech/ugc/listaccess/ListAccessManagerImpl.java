
package com.doublechaintech.ugc.listaccess;

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

import com.doublechaintech.ugc.userapp.UserApp;

import com.doublechaintech.ugc.userapp.CandidateUserApp;







public class ListAccessManagerImpl extends CustomUgcCheckerManager implements ListAccessManager {
	
	private static final String SERVICE_TYPE = "ListAccess";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ListAccessManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ListAccessManagerException(message);

	}
	
	

 	protected ListAccess saveListAccess(UgcUserContext userContext, ListAccess listAccess, String [] tokensExpr) throws Exception{	
 		//return getListAccessDAO().save(listAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveListAccess(userContext, listAccess, tokens);
 	}
 	
 	protected ListAccess saveListAccessDetail(UgcUserContext userContext, ListAccess listAccess) throws Exception{	

 		
 		return saveListAccess(userContext, listAccess, allTokens());
 	}
 	
 	public ListAccess loadListAccess(UgcUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ListAccessManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}
 	
 	
 	 public ListAccess searchListAccess(UgcUserContext userContext, String listAccessId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ListAccessManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}
 	
 	

 	protected ListAccess present(UgcUserContext userContext, ListAccess listAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,listAccess,tokens);
		
		
		ListAccess  listAccessToPresent = userContext.getDAOGroup().getListAccessDAO().present(listAccess, tokens);
		
		List<BaseEntity> entityListToNaming = listAccessToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getListAccessDAO().alias(entityListToNaming);
		
		return  listAccessToPresent;
		
		
	}
 
 	
 	
 	public ListAccess loadListAccessDetail(UgcUserContext userContext, String listAccessId) throws Exception{	
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, allTokens());
 		return present(userContext,listAccess, allTokens());
		
 	}
 	
 	public Object view(UgcUserContext userContext, String listAccessId) throws Exception{	
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, viewTokens());
 		return present(userContext,listAccess, allTokens());
		
 	}
 	protected ListAccess saveListAccess(UgcUserContext userContext, ListAccess listAccess, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getListAccessDAO().save(listAccess, tokens);
 	}
 	protected ListAccess loadListAccess(UgcUserContext userContext, String listAccessId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().throwExceptionIfHasErrors( ListAccessManagerException.class);

 
 		return userContext.getDAOGroup().getListAccessDAO().load(listAccessId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UgcUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){
		super.addActions(userContext, listAccess, tokens);
		
		addAction(userContext, listAccess, tokens,"@create","createListAccess","createListAccess/","main","primary");
		addAction(userContext, listAccess, tokens,"@update","updateListAccess","updateListAccess/"+listAccess.getId()+"/","main","primary");
		addAction(userContext, listAccess, tokens,"@copy","cloneListAccess","cloneListAccess/"+listAccess.getId()+"/","main","primary");
		
		addAction(userContext, listAccess, tokens,"list_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+listAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UgcUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ListAccess createListAccess(UgcUserContext userContext,String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfListAccess(name);
		userContext.getChecker().checkInternalNameOfListAccess(internalName);
		userContext.getChecker().checkReadPermissionOfListAccess(readPermission);
		userContext.getChecker().checkCreatePermissionOfListAccess(createPermission);
		userContext.getChecker().checkDeletePermissionOfListAccess(deletePermission);
		userContext.getChecker().checkUpdatePermissionOfListAccess(updatePermission);
		userContext.getChecker().checkExecutionPermissionOfListAccess(executionPermission);
	
		userContext.getChecker().throwExceptionIfHasErrors(ListAccessManagerException.class);


		ListAccess listAccess=createNewListAccess();	

		listAccess.setName(name);
		listAccess.setInternalName(internalName);
		listAccess.setReadPermission(readPermission);
		listAccess.setCreatePermission(createPermission);
		listAccess.setDeletePermission(deletePermission);
		listAccess.setUpdatePermission(updatePermission);
		listAccess.setExecutionPermission(executionPermission);
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		listAccess.setApp(app);
		
		

		listAccess = saveListAccess(userContext, listAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, listAccess);
		return listAccess;

		
	}
	protected ListAccess createNewListAccess() 
	{
		
		return new ListAccess();		
	}
	
	protected void checkParamsForUpdatingListAccess(UgcUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfListAccess(listAccessId);
		userContext.getChecker().checkVersionOfListAccess( listAccessVersion);
		

		if(ListAccess.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfListAccess(parseString(newValueExpr));
		}
		if(ListAccess.INTERNAL_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalNameOfListAccess(parseString(newValueExpr));
		}
		if(ListAccess.READ_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkReadPermissionOfListAccess(parseBoolean(newValueExpr));
		}
		if(ListAccess.CREATE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCreatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		if(ListAccess.DELETE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkDeletePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		if(ListAccess.UPDATE_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkUpdatePermissionOfListAccess(parseBoolean(newValueExpr));
		}
		if(ListAccess.EXECUTION_PERMISSION_PROPERTY.equals(property)){
			userContext.getChecker().checkExecutionPermissionOfListAccess(parseBoolean(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ListAccessManagerException.class);
	
		
	}
	
	
	
	public ListAccess clone(UgcUserContext userContext, String fromListAccessId) throws Exception{
		
		return userContext.getDAOGroup().getListAccessDAO().clone(fromListAccessId, this.allTokens());
	}
	
	public ListAccess internalSaveListAccess(UgcUserContext userContext, ListAccess listAccess) throws Exception 
	{
		return internalSaveListAccess(userContext, listAccess, allTokens());

	}
	public ListAccess internalSaveListAccess(UgcUserContext userContext, ListAccess listAccess, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(listAccess){ 
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			
			
			listAccess = saveListAccess(userContext, listAccess, options);
			return listAccess;
			
		}

	}
	
	public ListAccess updateListAccess(UgcUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);
		
		
		
		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){ 
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			
			listAccess.changeProperty(property, newValueExpr);
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}
	
	public ListAccess updateListAccessProperty(UgcUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);
		
		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){ 
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			
			listAccess.changeProperty(property, newValueExpr);
			
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ListAccessTokens tokens(){
		return ListAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ListAccessTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ListAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(UgcUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfListAccess(listAccessId);
 		userContext.getChecker().checkIdOfUserApp(anotherAppId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ListAccessManagerException.class);
 		
 	}
 	public ListAccess transferToAnotherApp(UgcUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, listAccessId,anotherAppId);
 
		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());	
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			listAccess.updateApp(app);		
			listAccess = saveListAccess(userContext, listAccess, emptyOptions());
			
			return present(userContext,listAccess, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserApp requestCandidateApp(UgcUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userContext.getDAOGroup().getUserAppDAO().requestCandidateUserAppForListAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserApp loadUserApp(UgcUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserAppDAO().load(newAppId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UgcUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		//deleteInternal(userContext, listAccessId, listAccessVersion);		
	}
	protected void deleteInternal(UgcUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{
			
		userContext.getDAOGroup().getListAccessDAO().delete(listAccessId, listAccessVersion);
	}
	
	public ListAccess forgetByAll(UgcUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, listAccessId, listAccessVersion);		
	}
	protected ListAccess forgetByAllInternal(UgcUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{
			
		return userContext.getDAOGroup().getListAccessDAO().disconnectFromAll(listAccessId, listAccessVersion);
	}
	

	
	public int deleteAll(UgcUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ListAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UgcUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getListAccessDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UgcUserContext userContext, ListAccess newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


