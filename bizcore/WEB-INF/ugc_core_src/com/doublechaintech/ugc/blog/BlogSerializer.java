package com.doublechaintech.ugc.blog;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.ugc.UgcObjectPlainCustomSerializer;
public class BlogSerializer extends UgcObjectPlainCustomSerializer<Blog>{

	@Override
	public void serialize(Blog blog, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, blog, provider);
		
	}
}


