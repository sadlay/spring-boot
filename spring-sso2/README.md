# jwt-sso
springboot+jwt(jjwt)实现单点登录,使用2个客户端,1个服务端演示.
# jwt-springboot-sso
* jwt+springboot实现的单点登录
# Single Sign On (SSO) Example with JSON Web Token (JWT), Spring Boot - Authentication Service

# theory
jwt以username和自定义的key,加以加密算法获得.
jwt从服务器端生成,保存到游览器的cookie中.
cookie以setDomain实现跨域.

# How Jwt and sso works?
通过在springboot工程中注册一个jwt过滤器,所有请求必须经过它的处理,判断jwt中是否合法,不合法重定向到login服务器
,合法则不需要再次登录
# What you'll need
- JDK 1.7+
- Maven 3+

# Stack
- Java
- Spring Boot
- FreeMarker

# Run
- Run jwt-sso-server: `mvn spring-boot:run`
- Run jwt-sso-client1: `mvn spring-boot:run -Dserver.port=8180`
- Run jwt-sso-client2: `mvn spring-boot:run -Dserver.port=8280`