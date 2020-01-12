package de.japkit.roo.japkit.application;

import de.japkit.metaannotations.Trigger;
import de.japkit.roo.japkit.Layers;

@Trigger(layer = Layers.APPLICATION, template = ApplicationServiceTemplate.class)
public @interface ApplicationService {

	boolean shadow() default false;

	Class<?>[] aggregateRoots() default {};

	Class<?>[] customBehaviorFor() default {};
}
