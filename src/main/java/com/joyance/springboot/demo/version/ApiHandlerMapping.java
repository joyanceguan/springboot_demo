package com.joyance.springboot.demo.version;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class ApiHandlerMapping extends RequestMappingHandlerMapping {

    private int latestVersion = 1;

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
    	ApiVersionCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && condition.getApiVersion() > latestVersion) {
        	ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
    	ApiVersionCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && condition.getApiVersion() > latestVersion) {
        	ApiVersionCondition.setMaxVersion(condition.getApiVersion());
        }
        return condition;
    }

    private ApiVersionCondition buildFrom(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
    }
}
