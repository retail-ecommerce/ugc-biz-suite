
package com.doublechaintech.ugc.blog;
//import com.doublechaintech.ugc.EntityNotFoundException;
import com.doublechaintech.ugc.UgcException;
import com.doublechaintech.ugc.Message;
import java.util.List;

public class BlogManagerException extends UgcException {
	private static final long serialVersionUID = 1L;
	public BlogManagerException(String string) {
		super(string);
	}
	public BlogManagerException(Message message) {
		super(message);
	}
	public BlogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


