package de.qimia.kafka.customserializer;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MyObjectDeserializer implements Deserializer<MyObject>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MyObject deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		 MyObject adiject = null;
		 try {
			 adiject = mapper.readValue(data, MyObject.class);
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }
		 return adiject;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
