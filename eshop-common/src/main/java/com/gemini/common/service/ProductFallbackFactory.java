package com.gemini.common.service;//package com.gemini.common.service;
//
//import com.gemini.common.entity.Product;
//import feign.hystrix.FallbackFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component // 不要忘记添加，不要忘记添加
//public class ProductFallbackFactory implements FallbackFactory<ProductFeign>
//{
//	protected Logger logger = LoggerFactory.getLogger(getClass());
//	@Override
//	public ProductFeign create(Throwable throwable)
//	{
//		return new ProductFeign() {
//			@Override
//			public Product get(Integer id) {
//				logger.error("进入回退方法，异常："+throwable);
//				return new Product().setId(id).setName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
//			}
//
//		};
//		//lambda
////		return id -> new Product().setId(id).setName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
//	}
//}
