
package com.doublechaintech.ugc.rating;
//import com.doublechaintech.ugc.EntityNotFoundException;
import com.doublechaintech.ugc.UgcException;
import com.doublechaintech.ugc.Message;
import java.util.List;

public class RatingManagerException extends UgcException {
	private static final long serialVersionUID = 1L;
	public RatingManagerException(String string) {
		super(string);
	}
	public RatingManagerException(Message message) {
		super(message);
	}
	public RatingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


