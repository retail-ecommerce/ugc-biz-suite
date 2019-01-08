package com.doublechaintech.ugc;


import com.doublechaintech.ugc.platform.PlatformManager;

import com.doublechaintech.ugc.product.ProductManager;

import com.doublechaintech.ugc.profile.ProfileManager;

import com.doublechaintech.ugc.rating.RatingManager;

import com.doublechaintech.ugc.review.ReviewManager;

import com.doublechaintech.ugc.blog.BlogManager;

import com.doublechaintech.ugc.userdomain.UserDomainManager;

import com.doublechaintech.ugc.userwhitelist.UserWhiteListManager;

import com.doublechaintech.ugc.secuser.SecUserManager;

import com.doublechaintech.ugc.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.ugc.userapp.UserAppManager;

import com.doublechaintech.ugc.listaccess.ListAccessManager;

import com.doublechaintech.ugc.objectaccess.ObjectAccessManager;

import com.doublechaintech.ugc.loginhistory.LoginHistoryManager;

import com.doublechaintech.ugc.genericform.GenericFormManager;

import com.doublechaintech.ugc.formmessage.FormMessageManager;

import com.doublechaintech.ugc.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.ugc.formfield.FormFieldManager;

import com.doublechaintech.ugc.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected ProductManager productManager;

	protected ProfileManager profileManager;

	protected RatingManager ratingManager;

	protected ReviewManager reviewManager;

	protected BlogManager blogManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public ProductManager getProductManager(){
		return this.productManager;
	}
	public void setProductManager(ProductManager manager){
		this.productManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public RatingManager getRatingManager(){
		return this.ratingManager;
	}
	public void setRatingManager(RatingManager manager){
		this.ratingManager = manager;
	}


	public ReviewManager getReviewManager(){
		return this.reviewManager;
	}
	public void setReviewManager(ReviewManager manager){
		this.reviewManager = manager;
	}


	public BlogManager getBlogManager(){
		return this.blogManager;
	}
	public void setBlogManager(BlogManager manager){
		this.blogManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









