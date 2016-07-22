package de.japkit.examples.freebuilder;


import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.InnerClass;
import de.japkit.metaannotations.Var;
import de.japkit.metaannotations.classselectors.SrcType;

@RuntimeMetadata
public class FreeBuilderTemplate {
	
	@Var(fun=SrcType.class)
	interface Interfaze {}; 

	@Field(src = "#{src.properties}", srcVar = "p",
			getter = @Getter(commentExpr="the value that will be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."))
		private SrcType $srcElementName$;
	
	@InnerClass
	static final class Value implements Interfaze {
		@Field(src = "#{src.properties}", srcVar = "p", getter = @Getter())
			private SrcType $srcElementName$;
	}
}
