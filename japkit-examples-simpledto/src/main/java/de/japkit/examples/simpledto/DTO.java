package de.japkit.examples.simpledto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import de.japkit.metaannotations.Trigger;

@Trigger(template = DTOTemplate.class)
@Target(ElementType.TYPE)
public @interface DTO {
	boolean shadow() default false;
}
