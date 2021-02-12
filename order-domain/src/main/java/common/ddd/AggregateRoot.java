package common.ddd;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * 聚合根
 *
 * @author jigang
 */
@Documented
@Retention(SOURCE)
@Target(TYPE)
public @interface AggregateRoot {
}
