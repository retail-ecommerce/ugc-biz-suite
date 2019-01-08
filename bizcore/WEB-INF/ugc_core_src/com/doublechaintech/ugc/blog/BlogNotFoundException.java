
package com.doublechaintech.ugc.blog;
import com.doublechaintech.ugc.EntityNotFoundException;
public class BlogNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public BlogNotFoundException(String string) {
		super(string);
	}

}

