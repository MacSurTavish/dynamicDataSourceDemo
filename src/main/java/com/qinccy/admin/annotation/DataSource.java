package com.qinccy.admin.annotation;

import com.qinccy.admin.provider.DynamicDataSourceProvider;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {
    String dataSourceName() default DynamicDataSourceProvider.DEFAULT_DATASOURCE;

    @AliasFor("dataSourceName")
    String value() default DynamicDataSourceProvider.DEFAULT_DATASOURCE;
}
