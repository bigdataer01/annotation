package net.bigdataer.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuxuecheng on 2017/6/22.
 *
 * @58corp
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface VersionCheckAnnotation {
    int major_version() default 1;
    int minor_version() default 0;
}
