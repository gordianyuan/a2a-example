package com.alibaba.cloud.ai.example.a2a.client;

import com.alibaba.cloud.ai.a2a.registry.nacos.discovery.NacosAgentCardProvider;
import com.alibaba.cloud.ai.graph.agent.BaseAgent;
import com.alibaba.cloud.ai.graph.agent.a2a.A2aRemoteAgent;
import com.alibaba.cloud.ai.graph.exception.GraphStateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HostAgentConfiguration {

    @Bean
    public BaseAgent saaAgent(NacosAgentCardProvider agentCardProvider) throws GraphStateException {
        return A2aRemoteAgent.builder()
                .agentCardProvider(agentCardProvider)
                .name("SAA Agent")
                .description("SAA Agent")
                .build();
    }

}
