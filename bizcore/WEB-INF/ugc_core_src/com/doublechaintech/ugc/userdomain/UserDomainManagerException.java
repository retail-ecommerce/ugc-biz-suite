
package com.doublechaintech.ugc.userdomain;
//import com.doublechaintech.ugc.EntityNotFoundException;
import com.doublechaintech.ugc.UgcException;
import com.doublechaintech.ugc.Message;
import java.util.List;

public class UserDomainManagerException extends UgcException {
	private static final long serialVersionUID = 1L;
	public UserDomainManagerException(String string) {
		super(string);
	}
	public UserDomainManagerException(Message message) {
		super(message);
	}
	public UserDomainManagerException(List<Message> messageList) {
		super(messageList);
	}

}


