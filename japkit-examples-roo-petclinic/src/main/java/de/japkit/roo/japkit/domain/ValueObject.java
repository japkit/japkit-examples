package de.japkit.roo.japkit.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import de.japkit.metaannotations.Trigger;
import de.japkit.roo.japkit.Layers;

@Trigger(layer = Layers.VALUE_OBJECTS, template = ValueObjectTemplate.class)
@Target(ElementType.TYPE)
public @interface ValueObject {
	boolean shadow() default false;

	boolean customBehavior() default false;

}
