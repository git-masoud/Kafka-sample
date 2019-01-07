import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import de.qimia.kafka.customserializer.MyObject;

public class ProducerApp {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"localhost:19092,localhost:29092,localhost:39092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer",
				"de.qimia.kafka.customserializer.MyObjectSerializer");

		Producer<Integer, MyObject> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++) {
			MyObject myObject = new MyObject();
			myObject.setName("Name" + i * (Math.random() * 6));
			myObject.setId(i);
			producer.send(new ProducerRecord<Integer, MyObject>("Adipic", i, myObject));
		}

		producer.close();
		System.out.println("finish");
	}
}
//