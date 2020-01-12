package de.japkit.roo.japkit.web;

import static de.japkit.metaannotations.TemplateLang.GSTRING_TEMPLATE;

import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.ResourceLocation;
import de.japkit.metaannotations.ResourceTemplate;
import de.japkit.metaannotations.TemplateCall;
import de.japkit.metaannotations.Trigger;
import de.japkit.metaannotations.Var;
import de.japkit.roo.japkit.Layers;

@Trigger(
	layer = Layers.WEB_APP,
	libraries = WebScaffoldLibrary.class,
	vars = { @Var(name = "controllers", ifEmpty = true, expr = "#{findAllControllers()}") })
@ResourceTemplate.List({
	@ResourceTemplate(
		templateLang = GSTRING_TEMPLATE,
		templateName = "application.jspx",
		pathExpr = "i18n",
		nameExpr = "application.properties",
		location = ResourceLocation.WEBINF),
	@ResourceTemplate(
		templateLang = GSTRING_TEMPLATE,
		templateName = "menu.jspx",
		pathExpr = "views",
		location = ResourceLocation.WEBINF) })
@Clazz(templates = @TemplateCall(JapkitWebApplicationTemplate.class))
public @interface JapkitWebApplication {
	boolean shadow() default false;

	Class<?>[] controllers() default {};
}
