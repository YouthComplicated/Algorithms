package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.Arrays;
import java.util.List;

/**
 * 有序发送
 */
public class SeqProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("example_group_name");
        producer.setNamesrvAddr("mq-server2:9876;mq-server1:9876");
        producer.setSendMsgTimeout(8000);
        //Launch the instance.
        producer.start();

//        String[] message1 = new String[] {"1TagA", "1TagB", "1TagC", "1TagD", "1TagE"};
//        String[] message2 = new String[] {"#Tag", "#TagB", "#TagC", "#TagD", "#TagE"};

        List<String> list = Arrays.asList("1TagA", "1TagB", "1TagC", "1TagD", "1TagE", "#Tag", "#TagB", "#TagC", "#TagD", "#TagE");

        for (int i = 0; i < list.size(); i++) {

            Message message = new Message("Seq", "Tag1", list.get(i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            /**
             * 选择哪个队列, 某个broker 保证队列有序
             */
            producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    String temp = String.valueOf(arg);
                    if(temp.startsWith("1")){
                        return mqs.get(0);
                    }else{
                        return mqs.get(1);
                    }
                }
            }, message);
        }
    }
}