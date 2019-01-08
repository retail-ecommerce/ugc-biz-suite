
package com.doublechaintech.ugc.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.ugc.BaseEntity;
import com.doublechaintech.ugc.SmartList;
import com.doublechaintech.ugc.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.ugc.product.Product;
import com.doublechaintech.ugc.profile.Profile;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String CURRENT_VERSION_PROPERTY       = "currentVersion"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_LIST                             = "productList"       ;
	public static final String PROFILE_LIST                             = "profileList"       ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mIntroduction       ;
	protected		String              	mCurrentVersion     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Product>  	mProductList        ;
	protected		SmartList<Profile>  	mProfileList        ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String introduction, String currentVersion)
	{
		setName(name);
		setIntroduction(introduction);
		setCurrentVersion(currentVersion);

		this.mProductList = new SmartList<Product>();
		this.mProfileList = new SmartList<Profile>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(CURRENT_VERSION_PROPERTY.equals(property)){
			changeCurrentVersionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCurrentVersionProperty(String newValueExpr){
		String oldValue = getCurrentVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCurrentVersion(newValue);
		this.onChangeProperty(CURRENT_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Platform updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	
	
	public void setCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
	}
	public String getCurrentVersion(){
		return this.mCurrentVersion;
	}
	public Platform updateCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
			this.mProductList.setListInternalName (PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductList;	
	}
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setPlatform(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setPlatform(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setPlatform(this);
		}
		getProductList().addAll(productList);
	}
	
	public  Product removeProduct(Product productIndex){
		
		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);        
        // product.clearPlatform(); //disconnect with Platform
        product.clearFromAll(); //disconnect with Platform
		
		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return product;
        
	
	}
	//断舍离
	public  void breakWithProduct(Product product){
		
		if(product == null){
			return;
		}
		product.setPlatform(null);
		//getProductList().remove();
	
	}
	
	public  boolean hasProduct(Product product){
	
		return getProductList().contains(product);
  
	}
	
	public void copyProductFrom(Product product) {

		Product productInList = findTheProduct(product);
		Product newProduct = new Product();
		productInList.copyTo(newProduct);
		newProduct.setVersion(0);//will trigger copy
		getProductList().add(newProduct);
		addItemToFlexiableObject(COPIED_CHILD, newProduct);
	}
	
	public  Product findTheProduct(Product product){
		
		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductList(){
		getProductList().clear();
	}
	
	
	


	public  SmartList<Profile> getProfileList(){
		if(this.mProfileList == null){
			this.mProfileList = new SmartList<Profile>();
			this.mProfileList.setListInternalName (PROFILE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProfileList;	
	}
	public  void setProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}

		this.mProfileList = profileList;
		this.mProfileList.setListInternalName (PROFILE_LIST );
		
	}
	
	public  void addProfile(Profile profile){
		profile.setPlatform(this);
		getProfileList().add(profile);
	}
	public  void addProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}
		getProfileList().addAll(profileList);
	}
	
	public  Profile removeProfile(Profile profileIndex){
		
		int index = getProfileList().indexOf(profileIndex);
        if(index < 0){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Profile profile = getProfileList().get(index);        
        // profile.clearPlatform(); //disconnect with Platform
        profile.clearFromAll(); //disconnect with Platform
		
		boolean result = getProfileList().planToRemove(profile);
        if(!result){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return profile;
        
	
	}
	//断舍离
	public  void breakWithProfile(Profile profile){
		
		if(profile == null){
			return;
		}
		profile.setPlatform(null);
		//getProfileList().remove();
	
	}
	
	public  boolean hasProfile(Profile profile){
	
		return getProfileList().contains(profile);
  
	}
	
	public void copyProfileFrom(Profile profile) {

		Profile profileInList = findTheProfile(profile);
		Profile newProfile = new Profile();
		profileInList.copyTo(newProfile);
		newProfile.setVersion(0);//will trigger copy
		getProfileList().add(newProfile);
		addItemToFlexiableObject(COPIED_CHILD, newProfile);
	}
	
	public  Profile findTheProfile(Profile profile){
		
		int index =  getProfileList().indexOf(profile);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Profile("+profile.getId()+") with version='"+profile.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProfileList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProfileList(){
		getProfileList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductList(), internalType);
		collectFromList(this, entityList, getProfileList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getProductList());
		listOfList.add( getProfileList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, CURRENT_VERSION_PROPERTY, getCurrentVersion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROFILE_LIST, getProfileList());
		if(!getProfileList().isEmpty()){
			appendKeyValuePair(result, "profileCount", getProfileList().getTotalCount());
			appendKeyValuePair(result, "profileCurrentPageNumber", getProfileList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIntroduction(getIntroduction());
			dest.setCurrentVersion(getCurrentVersion());
			dest.setVersion(getVersion());
			dest.setProductList(getProductList());
			dest.setProfileList(getProfileList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tcurrentVersion='"+getCurrentVersion()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

