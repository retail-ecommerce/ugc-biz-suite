
package com.doublechaintech.ugc.review;
import com.doublechaintech.ugc.EntityNotFoundException;
public class ReviewNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ReviewNotFoundException(String string) {
		super(string);
	}

}

