package com.training.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hazelcast.core.Hazelcast.newHazelcastInstance;
import static java.util.Arrays.asList;

public class HazelcastClusteringTester {

    public void run() {
        HazelcastInstance ins1 =
                newHazelcastInstance(createConfig("instance1", "192.168.0.5", 10010));
        HazelcastInstance ins2 =
                newHazelcastInstance(createConfig("instance2", "192.168.0.5", 10011));
    }

    @SuppressWarnings({"SameParameterValue", "ArraysAsListWithZeroOrOneArgument"})
    private Config createConfig(String instanceName, String ip, int port) {
        Config config = new Config();
        NetworkConfig networkConfig = config.getNetworkConfig();
        JoinConfig joinConfig = networkConfig.getJoin();

        config.setInstanceName(instanceName);

        networkConfig.setPort(port);
        networkConfig.setPortAutoIncrement(false);

        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true);

//        joinConfig.getTcpIpConfig().setMembers(asList("192.168.0.5:10010", "192.168.0.5:10011"));
        joinConfig.getTcpIpConfig().setMembers(asList("192.168.0.5"));

//        joinConfig.getTcpIpConfig().addMember("192.168.0.5:10010");
//        joinConfig.getTcpIpConfig().addMember("192.168.0.5:10011");

        return config;
    }
}
