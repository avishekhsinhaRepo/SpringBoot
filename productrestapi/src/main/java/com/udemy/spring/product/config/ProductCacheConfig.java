package com.udemy.spring.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

@Configuration
public class ProductCacheConfig {

	/*@Bean
	public Config cacheConfig() {
		return new Config().setInstanceName("hazle-instance")
				.addMapConfig(new MapConfig().
						setName("product-cache").
						setTimeToLiveSeconds(3000).
						setEvictionConfig(EvictionPolicy.LFU));
	}*/

}
