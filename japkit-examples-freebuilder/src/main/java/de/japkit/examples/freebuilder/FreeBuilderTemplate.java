package de.japkit.examples.freebuilder;


import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.Var;
import de.japkit.metaannotations.classselectors.SrcType;

@RuntimeMetadata
public class FreeBuilderTemplate {
	
	@Var()
	class interfaze {}; 

	@Field(src = "#{src.properties}", srcVar = "p",
			getter = @Getter(commentExpr="the value that will be returned by {@link #{interfaze.asType().simpleName}##{p.getter.simpleName}()}."))
		private SrcType $srcElementName$;
}
