package com.fei.design2;

import java.util.Map;

import com.fei.feithrows.ParamsException;
import com.fei.redis.RedisC;
import com.fei.tools.FinalString;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * 返回一个符合java bean 规范的 params 对象
 * 
 * @author jdf
 *
 */
public class ParamsFactory {

	@SuppressWarnings("unchecked")
	public <T extends Params> T createParam(ParamsString ps, ServletParams sp, Class<T> cl) throws Exception {
		// 定义一个参数params
		Params params = null;
		String[] str = ps.getNeedKeys();
		Map<String, String[]> slv = sp.getParms();
		try {
			// 生成一个对象
			params = (T) Class.forName(cl.getName()).newInstance();
			// 判断参数是否缺失
			SingletonTools singletonTools = SingletonTools.getSingleInstance();
			boolean a = singletonTools.matchKeys(str, slv);
			if (!a)
				throw new ParamsException("params key is not correct>>>>",601);
			// 如果参数key 值是完整的,判断access_token 是否正确，userId 是否正确
			String access_token = slv.get(FinalString.ACCESS_TOKEN)[0];
			RedisC redisc = new RedisC();
			// 判断access_token 在redis 中是否存在
			boolean b = redisc.exitToken(access_token);
			if (!b)
				throw new ParamsException("params access_token is not valid , please login in>>>>",602);
			// 判断userId 和 redis 中保存的是否相等
			Map<String, String> hash = redisc.hashGet(access_token);
			String userId_hash = hash.get(FinalString.USERNAME);
			String userId = slv.get(FinalString.USERNAME)[0];
			boolean c = userId_hash.equals(userId);
			if (!c)
				throw new ParamsException("userId is error>>>>",603);
			//  组装 Params,直接将一个map转换成bean
			BeanInfo beanInfo = Introspector.getBeanInfo(cl); // 能开始组装params ，说明userId is ok
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if (propertyDescriptors != null && propertyDescriptors.length > 0) {
				String propertyName = null; // javaBean 属性名
				Object propertyValue = null; // javaBean 属性值
				for (PropertyDescriptor pd : propertyDescriptors) {
					propertyName = pd.getName();
					if (slv.containsKey(propertyName)) {
						propertyValue = slv.get(propertyName)[0];
						pd.getWriteMethod().invoke(params, propertyValue);
					}
				}
			}
			// 私有params 自检
			boolean d = params.matchPrivateParams();
			if (!d)
				throw new ParamsException("private params is not valid>>>>",604);

		} catch (Exception e) {
			throw e;
		}
		return (T) params;
	}

}
