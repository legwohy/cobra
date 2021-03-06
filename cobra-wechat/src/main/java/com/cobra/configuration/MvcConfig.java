package com.cobra.configuration;

import com.cobra.interceptor.AccessLimitInterceptor;
import com.cobra.interceptor.WechatInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry)
    {
        interceptorRegistry.addInterceptor(wechatInterceptor())
                        .addPathPatterns("/wechat/*");

        interceptorRegistry.addInterceptor(accessInterceptor())
                        .addPathPatterns("/apiLimit");

    }

    @Bean
    public WechatInterceptor wechatInterceptor(){
        return new WechatInterceptor();
    }

    @Bean
    public AccessLimitInterceptor accessInterceptor(){
        return new AccessLimitInterceptor();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer)
    {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer)
    {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer)
    {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer)
    {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry)
    {

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry)
    {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry)
    {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry)
    {
        // 默认跳转主页
        viewControllerRegistry.addViewController("/").setViewName("index");

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry)
    {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list)
    {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list)
    {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list)
    {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list)
    {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list)
    {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list)
    {

    }

    @Override
    public Validator getValidator()
    {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver()
    {
        return null;
    }
}
