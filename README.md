# spring cors
>spring 针对 跨域调用的解决方案

[点击查看官方文档](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework)

## 服务端设置
```java
// @CrossOrigin里面的value必须是 协议（http/https）：ip(或者域名)：port
@CrossOrigin("http://127.0.0.1")
@RestController
@RequestMapping("/api")
public class RestDemoController {
    @RequestMapping("/hello")
    public Map demo(){
        Map map = new HashMap();
        map.put("message",1000);
        map.put("code",200);
        return map;
    }

}
```
## 客户端调用
```javascript
$.ajax({
            url:'http://localhost:8080/api/hello',
            type:'get',
            dataType:'json',
            success:function(data){
                alert(data);
            }
        })
        
```
## CrossOrigin定义

```java
//注释在方法和接口、类、枚举、注解上
@Target({ElementType.METHOD, ElementType.TYPE})
//运行时有效（即运行时保留）
@Retention(RetentionPolicy.RUNTIME)
//描述其它类型的annotation应该被作为被标注的程序成员的公共API
@Documented
public @interface CrossOrigin {
    String[] DEFAULT_ORIGINS = new String[]{"*"};
    String[] DEFAULT_ALLOWED_HEADERS = new String[]{"*"};
    boolean DEFAULT_ALLOW_CREDENTIALS = true;
    long DEFAULT_MAX_AGE = 1800L;

    @AliasFor("origins")
    String[] value() default {};

    //制定当前资源可以访问的来源
    //“*”是指所有来源都是允许的。
    //如果不确定，所有来源都是允许的。
    @AliasFor("value")
    String[] origins() default {};

    String[] allowedHeaders() default {};

   //此属性控制 Access-Control-Expose-Headers的值。
  //  未定义，使用空暴露的头列表。
    String[] exposedHeaders() default {};

    //可以访问方法的类型 e.g. "{RequestMethod.GET, RequestMethod.POST}".
    //默认所有方法可行
    RequestMethod[] methods() default {};
    //浏览器是否应该包括与请求的域名被注释相关的cookies。
    //设置为“false”，如果这种饼干应该不包括在内。空字符串（“”）是指不确定。 “true”是指飞行前的响应将包括头接入控制允许的凭据=真。
    //如果不确定，证书是允许的。
    String allowCredentials() default "";

    //为pre-flight 反应的缓存持续时间的最长期限（以秒为单位）。
    //此属性控制 Access-Control-Max-Age header 的值。
    //此设置一个合理的值，可以减少浏览器所需的pre-flight 的请求/响应交互的数量。负值意味着不确定的。
    //如果不确定，最大年龄设置为1800秒（即30分钟）
    long maxAge() default -1L;
}
```
## https内的http请求解决方案
配置hosts
```
127.0.0.1 www.foo.com
```
https://blog.csdn.net/u013076044/article/details/84261762