package com.steven.cns.minio.spring.boot.starter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: steven
 * @date: 2023/7/7 01:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(EnableCnsMinIOImportSelector.class)
public @interface EnableCnsMinIOAutoConfig {
}
