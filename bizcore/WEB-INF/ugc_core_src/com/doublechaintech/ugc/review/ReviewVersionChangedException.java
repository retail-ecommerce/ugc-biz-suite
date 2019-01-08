
package com.doublechaintech.ugc.review;
import com.doublechaintech.ugc.EntityNotFoundException;

public class ReviewVersionChangedException extends ReviewManagerException {
	private static final long serialVersionUID = 1L;
	public ReviewVersionChangedException(String string) {
		super(string);
	}


}


