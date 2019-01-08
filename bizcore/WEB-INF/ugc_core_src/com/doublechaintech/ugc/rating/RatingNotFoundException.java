
package com.doublechaintech.ugc.rating;
import com.doublechaintech.ugc.EntityNotFoundException;
public class RatingNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public RatingNotFoundException(String string) {
		super(string);
	}

}

