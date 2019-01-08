
package com.doublechaintech.ugc.product;
//import com.doublechaintech.ugc.EntityNotFoundException;
import com.doublechaintech.ugc.UgcException;
import com.doublechaintech.ugc.Message;
import java.util.List;

public class ProductManagerException extends UgcException {
	private static final long serialVersionUID = 1L;
	public ProductManagerException(String string) {
		super(string);
	}
	public ProductManagerException(Message message) {
		super(message);
	}
	public ProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


