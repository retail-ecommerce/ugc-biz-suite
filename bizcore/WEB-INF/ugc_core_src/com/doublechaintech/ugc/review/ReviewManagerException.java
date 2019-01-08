
package com.doublechaintech.ugc.review;
//import com.doublechaintech.ugc.EntityNotFoundException;
import com.doublechaintech.ugc.UgcException;
import com.doublechaintech.ugc.Message;
import java.util.List;

public class ReviewManagerException extends UgcException {
	private static final long serialVersionUID = 1L;
	public ReviewManagerException(String string) {
		super(string);
	}
	public ReviewManagerException(Message message) {
		super(message);
	}
	public ReviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


