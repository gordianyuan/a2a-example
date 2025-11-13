package com.alibaba.cloud.ai.example.a2a.client;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.ai.AiFactory;
import com.alibaba.nacos.api.ai.AiService;
import com.alibaba.nacos.api.ai.model.a2a.AgentCard;
import io.a2a.A2A;
import io.a2a.client.A2AClient;
import io.a2a.spec.Message;
import io.a2a.spec.MessageSendParams;
import io.a2a.spec.SendMessageResponse;

import java.util.Properties;

public class A2AClientTest {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, "localhost:8848");
        properties.setProperty(PropertyKeyConst.USERNAME, "nacos");
        properties.setProperty(PropertyKeyConst.PASSWORD, "nacos");

        AiService aiService = AiFactory.createAiService(properties);

        try {
            String agentName = "SAA Agent";
            AgentCard result = aiService.getAgentCard(agentName);
            A2AClient a2aClient = new A2AClient(result.getUrl());

            Message message = A2A.toUserMessage("how much is 10 USD in INR?"); // the message ID will be automatically generated for you
            MessageSendParams params = new MessageSendParams.Builder()
                    .message(message)
                    .build();
            SendMessageResponse response = a2aClient.sendMessage(params);
            System.out.println("Message sent with ID: " + response.getId());
            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
