package rocketmq.transaction;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;


/**
 *
 * 同步发送
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        TransactionMQProducer producer = new
                TransactionMQProducer("aaa");
        // Specify name server addresses.
        producer.setNamesrvAddr("mq-server2:9876;mq-server1:9876");
        producer.setSendMsgTimeout(8000);

        //事务监听
        TransactionListener listener = new TransactionListener() {

            //执行本地事务
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                return null;
            }

            //消息事务状态
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                return null;
            }
        };

        producer.setTransactionListener(listener);
        //Launch the instance.
        producer.start();


        String[] msgs = {"TagA", "TagB", "TagC"};

        for (String str : msgs) {
            Message msg = new Message("TransTopic" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ " + str).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );

            TransactionSendResult result = producer.sendMessageInTransaction(msg, null);

            System.out.printf("%s%n", result);

            TimeUnit.SECONDS.sleep(1);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}