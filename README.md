# gemini-framework

```
├─boot-framework
│  ├─boot-core      boot核心    已完成
│  ├─boot-web       web         已完成
│  ├─boot-mybatis   orm         已完成
│  └─boot-reids     cache       已完成
│  └─boot-quartz    timer       已完成
│  └─boot-mail      mail        已完成
│  └─boot-activity  workflow    已完成
│  └─boot-sms       message     已完成
│  └─boot-swagger   interface   已完成
├─cloud-framework
│  ├─cloud-core     cloud核心   已完成
│  │  ├─依赖boot-core
│  │  ├─依赖eureka-client
│  ├─cloud-service  cloud服务   已完成
│  │  ├─依赖boot-web
│  │  ├─依赖boot-mybatis
│  │  ├─依赖boot-redis
│  │  ├─依赖cloud-apollo
│  │  ├─依赖cloud-turbine
│  │  ├─依赖cloud-zipkin
│  ├─cloud-facade   cloud门面   已完成
│  │  ├─依赖openFeign
│  ├─cloud-eureka   服务注册中心  已完成
│  ├─cloud-apollo   配置中心      已完成
│  ├─cloud-turbine  服务监控      已完成
│  │  ├─依赖boot-core
│  ├─cloud-zipkin   服务跟踪      已完成       已弃用，改为docker启动
│  │  ├─依赖boot-core
│  ├─cloud-gateway  服务网关      已完成
│  │  ├─依赖boot-core
│  ├─cloud-admin    admin服务     已完成
│  │  ├─依赖boot-core
│  ├─cloud-oauth2   鉴权中心      已完成
│  │  ├─依赖boot-core
│  ├─cloud-mq       消息队列      已完成
│  ├─cloud-es       es储存        已完成
```
