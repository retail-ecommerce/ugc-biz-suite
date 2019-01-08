
package com.doublechaintech.ugc.blog;
import com.doublechaintech.ugc.EntityNotFoundException;

public class BlogVersionChangedException extends BlogManagerException {
	private static final long serialVersionUID = 1L;
	public BlogVersionChangedException(String string) {
		super(string);
	}


}


