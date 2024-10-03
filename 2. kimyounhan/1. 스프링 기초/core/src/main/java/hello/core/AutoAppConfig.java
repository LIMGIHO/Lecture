package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan(basePackages = { "hello.core", "" }, basePackageClasses =
// AutoAppConfig.class, // AutoAppConfig클래스의 패키지
// // 위치(hello.core) ->
// // Default
// excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
// Configuration.class))
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}

// @Configuration
// @ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes
// = Configuration.class))
// public class AutoAppConfig {

// }
