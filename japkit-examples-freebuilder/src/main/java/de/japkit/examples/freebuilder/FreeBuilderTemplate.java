package de.japkit.examples.freebuilder;

import java.util.Objects;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.Clazz;
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
@Clazz(nameSuffixToAppend = "Builder")
public class FreeBuilderTemplate {

	@Var(fun = SrcType.class)
	interface Interfaze {
	};

	@Var(fun = GeneratedClass.class)
	class Builder {
	};

	@Field(src = "#{properties}",
			srcVar = "p",
			getter = @Getter(commentExpr = "the value that will be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."),
			setter = @Setter(chain = true,
					commentExpr = "the value to be returned by {@link #{interfaze.simpleName}##{p.getter.simpleName}()}."))
	private SrcType $srcElementName$;

	@InnerClass
	static final class Value implements Interfaze {
		@Field(src = "#{properties}",
				srcVar = "p",
				getter = @Getter())
		private final SrcType $srcElementName$ = null;

		@CodeFragment(code = "this.#{name} = builder.#{name};")
		static class assignment {
		}

		@Constructor(bodyIterator = "#{properties}",
				bodyCode = "#{assignment()}")
		private Value(Builder builder) {

		}

		/**
		 * @japkit.bodyBeforeIteratorCode
		 * 
		 * <pre>
		 * if (!(obj instanceof Value)) {
		 * 	return false;
		 * }
		 * Value other = (Value) obj;
		 * return
		 * </pre>
		 * 
		 * @japkit.bodyCode Objects.equals(#{name}, other.#{name})
		 * @japkit.bodyAfterIteratorCode ;
		 */
		@Method(imports = Objects.class,
				bodyIterator = "#{properties}",
				bodySeparator = " && ",
				bodyIndentAfterLinebreak = true)
		@Override
		public boolean equals(Object obj) {
			return true;
		}

		@Method(imports = Objects.class,
				bodyBeforeIteratorCode = "return Objects.hash(",
				bodyIterator = "#{properties}",
				bodyCode = "#{name}",
				bodySeparator = ", ",
				bodyLinebreak = false,
				bodyAfterIteratorCode = ");")
		@Override
		public int hashCode() {
			return 0;
		}

		/**
		 * @japkit.bodyBeforeIteratorCode return "#{interfaze.simpleName} {"+
		 * @japkit.bodyCode "#{name}=" + #{name} +
		 * @japkit.bodySeparator ", " +
		 * @japkit.bodyAfterIteratorCode "}";
		 */
		@Method(bodyIterator = "#{properties}",
				bodyIndentAfterLinebreak = true)
		@Override
		public String toString() {
			return "";
		}
	}

}
