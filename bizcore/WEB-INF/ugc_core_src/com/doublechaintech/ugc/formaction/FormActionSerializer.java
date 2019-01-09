package com.doublechaintech.ugc.formaction;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.ugc.UgcObjectPlainCustomSerializer;
public class FormActionSerializer extends UgcObjectPlainCustomSerializer<FormAction>{

	@Override
	public void serialize(FormAction formAction, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formAction, provider);
		
	}
}










