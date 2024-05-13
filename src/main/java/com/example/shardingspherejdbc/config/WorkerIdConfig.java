package com.example.shardingspherejdbc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class WorkerIdConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerIdConfig.class);

    static {
        try {
            InetAddress address = InetAddress.getLocalHost();
            // IP地址byte[]数组形式，这个byte数组的长度是4，数组0~3下标对应的值分别是192，168，1，108
            byte[] ipAddressByteArray = address.getAddress();
            // workerId取ip地址后十位
            long workerId = ((ipAddressByteArray[ipAddressByteArray.length - 2] & 0x03) << 8) + (ipAddressByteArray[ipAddressByteArray.length - 1] & 0xFF);
            LOGGER.info("当前机器 workerId: {}", workerId);
            System.setProperty("workerId", String.valueOf(workerId));
        } catch (Exception e) {
            LOGGER.error("worker id failed:{}", e.getMessage(), e);
        }
    }
}
