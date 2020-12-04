package kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @author: nj
 * @date: 2020-11-12 20:40
 * @version: 0.0.1
 */
public class kafkaTest {


    public static void main(String[] args) {

//        ProducerConfig producerConfig  = new ProducerConfig(null);

//        ProducerConfig.LINGER_MS_CONFIG;

        Properties properties = new Properties();
        properties.put("bootstrap.servers","web162:9092");
        properties.put("acks", "all");
        properties.put("retries",3);
        //16*1024
        properties.put("batch.size", 16384);
        //等待时间
        properties.put("linger.ms",1);
        //缓冲区大小
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        //发送数据
//        for (int i = 0; i < 20 ; i++) {
//            producer.send(new ProducerRecord<>("test1", "aaaaaaa"+i));
//        }

        for (int i = 0; i < 20; i++) {
            producer.send(new ProducerRecord<>("test1", "bbbb"+i),
                    (RecordMetadata recordMetadata, Exception e) ->
                {
                    if(e == null){
                        System.out.println("partition:"+ recordMetadata.partition() + "    offset:" + recordMetadata.offset());
                    }else{
                        e.printStackTrace();
                    }
                }
            );
        }
        //关闭数据源
        producer.close();
    }
}










