package de.japkit.roo.japkit.domain;

import de.japkit.metaannotations.Trigger;
import de.japkit.roo.japkit.Layers;

@Trigger(layer = Layers.ENTITIES, template = JapkitEntityTemplate.class)
public @interface JapkitEntity {
	// Modifier[] modifier() default {};

	boolean shadow() default false;

	boolean customBehavior() default false;

	String[] createCommandProperties() default {};

	String[] updateCommandProperties() default {};

}
