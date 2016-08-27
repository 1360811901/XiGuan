package com.fei.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisC {

	private static JedisPool jedisPool;

	static {
		JedisPoolConfig jedisPoolConfig = initPoolConfig();
		// 构造连接池
		jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
	}

	/**
	 * initPoolConfig <br>
	 * ------------------------------<br>
	 * 
	 * @return
	 */
	private static JedisPoolConfig initPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 控制一个pool最多有多少个可用的的jedis实例
		jedisPoolConfig.setMaxTotal(1000);
		// 最大能够保持空闲状态的对象数
		jedisPoolConfig.setMaxIdle(300);
		// 超时时间
		jedisPoolConfig.setMaxWaitMillis(1000);
		// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
		jedisPoolConfig.setTestOnBorrow(true);
		// 在还会给pool时，是否提前进行validate操作
		jedisPoolConfig.setTestOnReturn(true);
		return jedisPoolConfig;
	}

	public void StringSet(String key) {
		Jedis jedis = null;
		// 从池中获取一个jedis 实例
		try{
			jedis = jedisPool.getResource();
			jedis.set(key, "1");
			// userId 的存在时间比token 的生存时间少一小时
			jedis.expire(key, 601200);
		}finally {
			if (jedis != null)
				jedis.close();
		}
	}
	
	public String StringGet(String key){
		Jedis jedis = null;
		String value = "";
		// 从池中获取一个jedis 实例
		try{
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		}finally {
			if (jedis != null)
				jedis.close();
		}
		return value;
	}
	/**
	 * 设置有效期为一周
	 * @param token
	 * @param hash
	 */
	public void hashSet(String token, Map<String, String> hash) {
		Jedis jedis = null;
		// 从池中获取一个jedis实例
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(token, hash);
			// 设置token 的过期时间是一周
			jedis.expire(token, 604800);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}
	
	public void hashSetForEver(String token, Map<String, String> hash) {
		Jedis jedis = null;
		// 从池中获取一个jedis实例
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(token, hash);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public Map<String, String> hashGet(String token) {
		Jedis jedis = null;
		Map<String, String> hash = null;
		try {
			jedis = jedisPool.getResource();
			hash = jedis.hgetAll(token);
		} finally {
			if (jedis != null)
				jedis.close();
		}

		return hash;
	}

	public boolean exitToken(String token) {
		boolean flag = false;
		Jedis jedis = null;
		// 从池中获取一个jedis实例
		try {
			jedis = jedisPool.getResource();
			flag = jedis.exists(token);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return flag;
	}
	
	public void del(String key){
		Jedis jedis = null;
		// 从池中获取一个jedis 实例
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}
}
