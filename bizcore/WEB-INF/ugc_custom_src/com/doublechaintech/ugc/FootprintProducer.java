package com.doublechaintech.ugc;

public interface FootprintProducer {

	boolean canReplaceFootPrint(Footprint fp, Footprint item);
	boolean clearTop();
	String getBeanName();
}


