package de.japkit.roo.japkit.domain;

import static de.japkit.roo.japkit.domain.AnnotationPackages.JPA;
import static de.japkit.roo.japkit.domain.AnnotationPackages.JSR303;
import static de.japkit.roo.japkit.domain.AnnotationPackages.SPRING_FORMAT;

import javax.lang.model.element.Modifier;
import javax.persistence.Entity;

import de.japkit.functions.SrcType;
import de.japkit.metaannotations.Annotation;
import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.Setter;
import de.japkit.metaannotations.TemplateCall;

@Clazz(nameSuffixToRemove = "Def", nameSuffixToAppend = "", modifiersFromSrc = true, customBehaviorCond = "#{customBehavior}")
@Entity
public class JapkitEntityTemplate extends JapkitEntitySuperclassSelector {

	@TemplateCall
	IdAndVersion idAndVersion;

	@Field(
		src = "#{src.declaredFields}",
		getter = @Getter,
		setter = @Setter(modifiers = Modifier.PROTECTED),
		annotations = @Annotation(copyAnnotationsFromPackages = { JPA, JSR303, SPRING_FORMAT }))
	private SrcType $name$;

	@TemplateCall
	PropertyRefsTemplate propertyRefs;

	@TemplateCall
	ToString toString;

	@TemplateCall
	EntityBehaviorMethods behaviorMethods;

}
