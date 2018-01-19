package test.zero.address.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import test.zero.address.TestBasic;

/**
 * 
 * @date 2018年1月19日 下午11:48:25
 * @author zero
 */
public class SpringDataRedisTest extends TestBasic {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Test
	public void testSet() {
		String key = "spring.data.redis.key";
		String value = "SpringDataRedisValue";
		redisTemplate.opsForValue().set(key, value);
		String getValue = redisTemplate.opsForValue().get(key);
		Assert.assertEquals("get value should equals to setted value", value, getValue);
	}
	
}
