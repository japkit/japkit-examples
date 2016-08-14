package de.japkit.examples.freebuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.Case;
import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.CodeFragment;
import de.japkit.metaannotations.Constructor;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Function;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.InnerClass;
import de.japkit.metaannotations.Matcher;
import de.japkit.metaannotations.Method;
import de.japkit.metaannotations.Setter;
import de.japkit.metaannotations.Switch;
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
	private SrcType $name$;

	@InnerClass
	static final class Value implements Interfaze {
		@Field(src = "#{properties}",
				srcVar = "p",
				getter = @Getter())
		private final SrcType $name$ = null;

		@Matcher(type = Date.class)
		public @interface isDate{}
		
		@Matcher(type = List.class)
		public @interface isList{}
		
		@Matcher(type = Set.class)
		public @interface isSet{}
		
		
		@Switch
		static class defensiveCopyFragment {
			@isDate
			@CodeFragment(imports = Date.class, code = "new Date(#{surrounded}.getTime())")
			String copyDate;
			
			@isList
			@CodeFragment(imports = {ArrayList.class, Collections.class}, code = "Collections.unmodifiableList(new ArrayList<>(#{surrounded}))")
			String copyList;
			
			@isSet
			@CodeFragment(imports = {HashSet.class, Collections.class}, code = "Collections.unmodifiableSet(new HashSet<>(#{surrounded}))")
			String copySet;
		}
		
		@CodeFragment(code = "builder.#{name}", surroundingFragments = "defensiveCopyFragment")
		static class rhs{}
		
	
		@CodeFragment(code = "this.#{name} = #{rhs()};")
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
