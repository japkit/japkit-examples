package de.japkit.examples.freebuilder;

import java.util.Objects;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.CodeFragment;
import de.japkit.metaannotations.Constructor;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.InnerClass;
import de.japkit.metaannotations.Method;
import de.japkit.metaannotations.Setter;
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
			getter = @Getter(commentExpr = "the value that will be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."),
			setter = @Setter(chain=true, commentExpr = "the value to be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."))
	private SrcType $srcElementName$;

	@InnerClass
	static final class Value implements Interfaze {
		@Field(src = "#{src.properties}",
				srcVar = "p",
				getter = @Getter())
		private final SrcType $srcElementName$ = null;

		@CodeFragment(code = "this.#{src.name} = builder.#{src.name};")
		static class assignment {
		}

		@Constructor(bodyIterator = "#{src.properties}",
				bodyCode = "#{assignment()}")
		private Value(Builder builder) {

		}

		@CodeFragment(imports = Objects.class,
				iterator = "#{src.properties}",
				code = "Objects.equals(#{src.name}, other.#{src.name})",
				separator = " && ",
				indentAfterLinebreak = true)
		class allPropertiesAreEqual {
		}

		/**
		 * @japkit.bodyCode
		 * 
		 * <pre>
		 * if (!(obj instanceof Value)) {
		 * 	return false;
		 * }
		 * Value other = (Value) obj;
		 * return #{allPropertiesAreEqual.code()};
		 * </pre>
		 */
		@Method()
		@Override
		public boolean equals(Object obj) {
			return true;
		}

		@Method(imports = Objects.class,
				bodyBeforeIteratorCode = "return Objects.hash(",
				bodyIterator = "#{src.properties}",
				bodyCode = "#{src.name}",
				bodySeparator = ", ",
				bodyLinebreak = false,
				bodyAfterIteratorCode = ");")
		@Override
		public int hashCode() {
			return 0;
		}
		
		@Method(bodyBeforeIteratorCode = "return \"#{interfaze.simpleName} {",
				bodyIterator = "#{src.properties}",
				bodyCode = "#{src.name}=\" + #{src.name} + \"",
				bodySeparator = ", ",
				bodyLinebreak = false,
				bodyAfterIteratorCode = "}\";")
		@Override
		public String toString() {
			return "";
		}
	}

}
