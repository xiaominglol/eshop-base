package com.gemini.common.service;//package com.gemini.common.service;
//
//import com.gemini.common.entity.Product;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * @Service只是为了@Autowired不报错，实际上已经加载了，IDEA错误提示
// */
//@Service
//@FeignClient(value = "GEMINI-PRODUCT-PROVIDER",/*configuration = FeignLogConfiguration.class, */fallbackFactory= ProductFallbackFactory.class)
//public interface ProductFeign {
//    //@GetMapping(value = "/product/get/{id}")
//    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
//    Product get(@PathVariable("id") Integer id);
//}
