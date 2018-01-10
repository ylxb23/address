package com.zero.address.app.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 连接池配置
 * @date 2018年1月10日 下午5:20:20
 * @author zero
 */
@Configuration
@ConfigurationProperties(prefix = "datasource.druid")
public class DruidConfigure {

}