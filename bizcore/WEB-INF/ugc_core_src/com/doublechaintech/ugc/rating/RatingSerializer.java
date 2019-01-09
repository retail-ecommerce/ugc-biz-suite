package com.doublechaintech.ugc.rating;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.ugc.UgcObjectPlainCustomSerializer;
public class RatingSerializer extends UgcObjectPlainCustomSerializer<Rating>{

	@Override
	public void serialize(Rating rating, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, rating, provider);
		
	}
}


