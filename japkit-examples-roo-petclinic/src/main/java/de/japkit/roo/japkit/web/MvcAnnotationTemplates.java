package de.japkit.roo.japkit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.japkit.annotationtemplates.AnnotationTemplates;

@AnnotationTemplates(targetAnnotations = {RequestMapping.class, Controller.class})
public class MvcAnnotationTemplates {
	
	
}
