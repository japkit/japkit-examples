package de.japkit.examples.freebuilder;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.CodeFragment;
import de.japkit.metaannotations.Constructor;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.InnerClass;
import de.japkit.metaannotations.Var;
import de.japkit.metaannotations.classselectors.GeneratedClass;
import de.japkit.metaannotations.classselectors.SrcType;

@RuntimeMetadata
public class FreeBuilderTemplate {

	@Var(fun = SrcType.class)
	interface Interfaze {
	};
	
	@Var(fun = GeneratedClass.class)
	class Builder {
	};

	@Field(src = "#{src.properties}",
			srcVar = "p",
			getter = @Getter(commentExpr = "the value that will be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."))
	private SrcType $srcElementName$;

	@InnerClass
	static final class Value implements Interfaze {
		@Field(src = "#{src.properties}",
				srcVar = "p",
				getter = @Getter())
		private final SrcType $srcElementName$ = null;
		
		@CodeFragment(code = "#{src}")
		static class rhs{}
				
		@CodeFragment(vars = @Var(name="param", expr ="builder.#{src.simpleName}"),
				code = "this.#{src.simpleName} = #{rhs(param)};")
		static class assignment{}
		
		@Constructor(bodyIterator = "#{src.properties}", bodyCode = "#{assignment()}")
		private Value(Builder builder) {
			
		}
	}
}
