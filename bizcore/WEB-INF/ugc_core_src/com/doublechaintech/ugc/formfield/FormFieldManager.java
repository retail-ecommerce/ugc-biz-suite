
package com.doublechaintech.ugc.formfield;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.UgcUserContext;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;

public interface FormFieldManager{

		

	public FormField createFormField(UgcUserContext userContext, String label, String localeKey, String parameterName, String type, String formId, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception;	
	public FormField updateFormField(UgcUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormField loadFormField(UgcUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception;
	public FormField internalSaveFormField(UgcUserContext userContext, FormField formField) throws Exception;
	public FormField internalSaveFormField(UgcUserContext userContext, FormField formField,Map<String,Object>option) throws Exception;
	
	public FormField transferToAnotherForm(UgcUserContext userContext, String formFieldId, String anotherFormId)  throws Exception;
 

	public void delete(UgcUserContext userContext, String formFieldId, int version) throws Exception;
	public int deleteAll(UgcUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UgcUserContext userContext, FormField newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


