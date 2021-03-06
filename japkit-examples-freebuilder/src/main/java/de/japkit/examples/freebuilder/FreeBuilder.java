package de.japkit.examples.freebuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import de.japkit.metaannotations.Trigger;

@Trigger(template = FreeBuilderTemplate.class)
@Target(ElementType.TYPE)
public @interface FreeBuilder {
	boolean shadow() default false;
}
