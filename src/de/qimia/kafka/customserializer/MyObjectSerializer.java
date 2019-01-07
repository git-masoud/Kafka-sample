package de.qimia.kafka.customserializer;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MyObjectSerializer implements Serializer<MyObject> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, MyObject data) {
		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 serializedBytes = objectMapper.writeValueAsString(data).getBytes();
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return serializedBytes;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
