package kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author: nj
 * @date: 2020-11-12 23:29
 * @version: 0.0.1
 */
public class MyProducerInterceptor implements ProducerInterceptor<String, String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        //技术
    }

    @Override
    public void close() {
        //打印数
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}