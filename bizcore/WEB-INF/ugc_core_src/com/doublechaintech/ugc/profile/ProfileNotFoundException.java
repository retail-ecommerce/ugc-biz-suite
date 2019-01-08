
package com.doublechaintech.ugc.profile;
import com.doublechaintech.ugc.EntityNotFoundException;
public class ProfileNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProfileNotFoundException(String string) {
		super(string);
	}

}

