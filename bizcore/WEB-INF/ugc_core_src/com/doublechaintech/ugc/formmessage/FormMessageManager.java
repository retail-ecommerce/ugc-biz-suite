
package com.doublechaintech.ugc.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(UgcUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(UgcUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(UgcUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(UgcUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(UgcUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(UgcUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


