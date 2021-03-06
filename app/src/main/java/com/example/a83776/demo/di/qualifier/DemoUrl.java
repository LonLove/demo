package com.example.a83776.demo.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * description:
 * author: GaoJie
 * created at: 2018/6/20 14:47
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoUrl {
}
