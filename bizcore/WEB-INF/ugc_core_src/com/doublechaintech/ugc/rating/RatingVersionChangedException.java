
package com.doublechaintech.ugc.rating;
import com.doublechaintech.ugc.EntityNotFoundException;

public class RatingVersionChangedException extends RatingManagerException {
	private static final long serialVersionUID = 1L;
	public RatingVersionChangedException(String string) {
		super(string);
	}


}


