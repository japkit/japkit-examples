package de.japkit.roo.japkit.web;

import de.japkit.metaannotations.Template;
import de.japkit.metaannotations.TemplateCall;

@Template
public class ControllerTemplate {

	@TemplateCall
	ControllerMembers controllerMembers;

	@TemplateCall
	ControllerMembersJpaRepository controllerMembersJpaRepository;

	@TemplateCall
	ControllerFormatterMembers controllerFormatterMembers;
}
