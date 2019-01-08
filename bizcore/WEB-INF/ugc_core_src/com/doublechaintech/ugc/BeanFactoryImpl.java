
package com.doublechaintech.ugc;
import java.util.Map;

import com.doublechaintech.ugc.platform.Platform;
import com.doublechaintech.ugc.product.Product;
import com.doublechaintech.ugc.profile.Profile;
import com.doublechaintech.ugc.rating.Rating;
import com.doublechaintech.ugc.review.Review;
import com.doublechaintech.ugc.blog.Blog;
import com.doublechaintech.ugc.userdomain.UserDomain;
import com.doublechaintech.ugc.userwhitelist.UserWhiteList;
import com.doublechaintech.ugc.secuser.SecUser;
import com.doublechaintech.ugc.secuserblocking.SecUserBlocking;
import com.doublechaintech.ugc.userapp.UserApp;
import com.doublechaintech.ugc.listaccess.ListAccess;
import com.doublechaintech.ugc.objectaccess.ObjectAccess;
import com.doublechaintech.ugc.loginhistory.LoginHistory;
import com.doublechaintech.ugc.genericform.GenericForm;
import com.doublechaintech.ugc.formmessage.FormMessage;
import com.doublechaintech.ugc.formfieldmessage.FormFieldMessage;
import com.doublechaintech.ugc.formfield.FormField;
import com.doublechaintech.ugc.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public Rating createRating(Map<String,Object> options){
		return new Rating();
	}


	public Review createReview(Map<String,Object> options){
		return new Review();
	}


	public Blog createBlog(Map<String,Object> options){
		return new Blog();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










