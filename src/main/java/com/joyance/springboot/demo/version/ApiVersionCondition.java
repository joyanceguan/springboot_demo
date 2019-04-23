package com.joyance.springboot.demo.version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition>{

	// 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
 
    private int apiVersion;
    
    // 保存所有接口的最大版本号
    private static int maxVersion = 1;
 
    public ApiVersionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }
 
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(other.getApiVersion());
    }
 
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if(m.find()){
            Integer version = Integer.valueOf(m.group(1));
            System.out.println(version+"=========="+request.getRequestURI()+"===="+this.apiVersion);
            if(version >= this.apiVersion)
            {
            	System.out.println(version+"-------"+this.apiVersion);
                return this;
            }
        }
        return null;
    }
 
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
    	System.out.println(other.getApiVersion()+"++++++++"+request.getRequestURI()+"+++++"+this.apiVersion);
        return other.getApiVersion() - this.apiVersion;
    }
 
    public int getApiVersion() {
        return apiVersion;
    }
    
    public static void setMaxVersion(int maxVersion) {
    	ApiVersionCondition.maxVersion = maxVersion;
    }

}
