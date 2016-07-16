package de.japkit.examples.freebuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.lang.model.element.Modifier;

import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.Trigger;


@Trigger
@Target(ElementType.TYPE)
@Clazz(nameSuffixToRemove = "", nameSuffixToAppend = "Builder", modifiers = { Modifier.PUBLIC}, templates = { })
public @interface FreeBuilder {
	boolean shadow() default false;
}
