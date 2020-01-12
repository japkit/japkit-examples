package de.japkit.roo.japkit.domain;

import de.japkit.metaannotations.classselectors.ClassSelector;

@ClassSelector(expr = "#{annotatedClass.superclass}", requiredTriggerAnnotation = JapkitEntity.class) class JapkitEntitySuperclassSelector {
}