
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import de.qimia.kafka.customserializer.MyObject;


public class ConsumerApp {
public static void main(String[] args) {
	Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:19092,localhost:29092,localhost:39092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
    props.put("value.deserializer", "de.qimia.kafka.customserializer.MyObjectDeserializer");
    KafkaConsumer<Integer, MyObject> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Arrays.asList("Adipic"));
    System.out.println("Waiting for messages...");
    while (true) {
        ConsumerRecords<Integer, MyObject> records = consumer.poll(999999);
        for (ConsumerRecord<Integer, MyObject> record : records)
            System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), "id: "+record.value().getId()+" ,  "+record.value().getName());
    }
}
}
