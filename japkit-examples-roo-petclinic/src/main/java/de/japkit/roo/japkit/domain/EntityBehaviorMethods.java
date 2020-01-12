package de.japkit.roo.japkit.domain;

import static de.japkit.roo.japkit.domain.AnnotationPackages.JSR303;
import static de.japkit.roo.japkit.domain.AnnotationPackages.SPRING_FORMAT;

import javax.lang.model.element.Modifier;

import de.japkit.functions.SrcType;
import de.japkit.metaannotations.Annotation;
import de.japkit.metaannotations.CodeFragment;
import de.japkit.metaannotations.Constructor;
import de.japkit.metaannotations.Function;
import de.japkit.metaannotations.Matcher;
import de.japkit.metaannotations.Method;
import de.japkit.metaannotations.Param;
import de.japkit.metaannotations.Template;
import de.japkit.metaannotations.Var;

@Template(
	vars = {
		@Var(name = "superconstructors", expr = "#{genClass.superclass.asElement.declaredConstructors}"),
		@Var(name = "entityName", expr = "#{genClass.simpleName}") },
	libraries = DomainLibrary.class)
public abstract class EntityBehaviorMethods {

	@CodeFragment(iterator = "#{src}", code = "#{src.setter.simpleName}(#{src.simpleName});", indentAfterLinebreak = false)
	static class assignments {
	}

	/**
	 * Default constructor for JPA. //TODO: Make protected as soon as
	 * controllers support that.
	 */
	@Constructor()
	public EntityBehaviorMethods() {
	};

	// /**
	// * @japkit.bodyCode <pre>
	// * <code>
	// * #{super.code()}#{assignments.code()}
	// * </code>
	// * </pre>
	// */
	// @Constructor(src="superconstructors",
	// srcFilter="#{!src.parameters.isEmpty() || superconstructors.size()==1}",
	// vars = {
	//
	// @Var(name = "super", code = @CodeFragment(beforeIteratorCode="super(",
	// afterIteratorCode=");", iterator="#{src.parameters}" , separator = ", ",
	// linebreak=false, code="#{src.simpleName}") ),
	// @Var(name = "assignments", code = @CodeFragment(iterator =
	// "#{genClass.declaredFields}", code =
	// "set#{src.simpleName.toFirstUpper}(#{src.simpleName});"))
	// }
	//
	// )

	@Matcher(src = "#{genClass}", modifiersNot = Modifier.ABSTRACT)
	class genClassNotAbstract {
	};

	/**
	 */
	@Constructor(
		condFun = genClassNotAbstract.class,
		vars = @Var(name = "cmdPropertiesWhiteList", expr = "#{createCommandProperties}"),
		bodyCode = "#{assignments(cmdProperties())}")
	public EntityBehaviorMethods(@Param(
		srcFun = cmdProperties.class,
		annotations = @Annotation(copyAnnotationsFromPackages = { JSR303, SPRING_FORMAT })) SrcType $srcElementName$) {

	}

	@Method(
		condFun = genClassNotAbstract.class,
		vars = @Var(name = "cmdPropertiesWhiteList", expr = "#{updateCommandProperties}"),
		bodyCode = "#{assignments(cmdProperties())}")
	public void update$entityName$(@Param(
		srcFun = cmdProperties.class,
		annotations = @Annotation(copyAnnotationsFromPackages = { JSR303, SPRING_FORMAT })) SrcType $srcElementName$) {
	}

	@Function(
		expr = "#{genClass.properties}",
		filter = "#{(cmdPropertiesWhiteList.isEmpty() || cmdPropertiesWhiteList.contains(name.toString())) && !(isId() || isVersion())}")
	class cmdProperties {
	}

}
