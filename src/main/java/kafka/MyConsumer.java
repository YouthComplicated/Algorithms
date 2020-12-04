package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * @author: nj
 * @date: 2020-11-12 22:24
 * @version: 0.0.1
 */
public class MyConsumer {

    /**
     * 消费两种 同步和异步 基本上都是异步
     * @param args
     */
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "web162:9092");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);


        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        //消费者组
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "CountryCounter1");

        //重置消费的offset, 换消费者组
        /**
         * 如何重新消费消息， 换一个消费者组并且将加上这个参数
         */
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        //1.创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        //2.定位
        consumer.subscribe(Arrays.asList("test1", "test0"));

        consumer.subscribe(Arrays.asList("test1", "test0"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

            }
        });

        while (true){
            ConsumerRecords<String, String> poll = consumer.poll(100);
            for (ConsumerRecord<String, String> e : poll){
                System.out.println("key:" + e.key() + "   value:" + e.value());
            }

            //offset 手动提交
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {

                }
            });
        }



    }

}