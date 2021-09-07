package main.java.com.epam.homework.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE) // classes + interfaces
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {

    boolean lazyLoad() default false;
}
