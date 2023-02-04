package com.jun.comfig;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Bojack
 * @date : Created in 15:46 2022.11.02
 * 交给Spring管理一个bean，这个Bean为MybatisPlus的一个拦截器，拦截器负责管理分页相关操作
 */

@Configuration
public class MPConfiig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
