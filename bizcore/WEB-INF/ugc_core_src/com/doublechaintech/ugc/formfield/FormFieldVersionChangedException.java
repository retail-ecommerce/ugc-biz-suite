
package com.doublechaintech.ugc.formfield;
import com.doublechaintech.ugc.EntityNotFoundException;

public class FormFieldVersionChangedException extends FormFieldManagerException {
	private static final long serialVersionUID = 1L;
	public FormFieldVersionChangedException(String string) {
		super(string);
	}


}


