package de.japkit.examples.freebuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.functions.SrcType;
import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.CodeFragment;
import de.japkit.metaannotations.Constructor;
import de.japkit.metaannotations.DefaultCase;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.InnerClass;
import de.japkit.metaannotations.Matcher;
import de.japkit.metaannotations.Method;
import de.japkit.metaannotations.Setter;
import de.japkit.metaannotations.Switch;
import de.japkit.metaannotations.TypeCategory;
import de.japkit.metaannotations.Var;
import de.japkit.metaannotations.classselectors.GeneratedClass;

/**
 * The builder implementation for the value object #{voInterface.simpleName}.
 *
 */
@RuntimeMetadata
@Clazz(nameSuffixToAppend = "Builder")
public class FreeBuilderTemplate {

	@Var(fun = SrcType.class)
	interface VoInterface {
	};
	
	

	@Var(fun = GeneratedClass.class)
	class Builder {
	};

	/**
	 * #{src.asType().toString()} 
	 * #{src.singleValueType.toString()} 
	 */
	@Field(src = "#{properties}", 
			srcVar = "p",
			getter = @Getter(commentExpr = "the value that will be returned by {@link #{voInterface.simpleName}##{p.getter.name}()}."),
			setter = @Setter(chain = true,
					commentExpr = "the value to be returned by {@link #{voInterface.simpleName}##{p.getter.name}()}."))
	private SrcType $name$;
	
	@Matcher(typeCategory=TypeCategory.PRIMITIVE)
	class PrimitiveMatcher{}
	
	@Method(src = "#{properties}", srcFilterFun = PrimitiveMatcher.class)
	void primitiveMatcher$name$(){};
	
	@Matcher(singleValueTypeCategory=TypeCategory.PRIMITIVE)
	class SingleValuePrimitiveMatcher{}
	
	@Method(src = "#{properties}", srcFilterFun = SingleValuePrimitiveMatcher.class)
	void singleValuePrimitiveMatcher$name$(){};
	
	@Matcher(singleValueTypeCategoryNot=TypeCategory.PRIMITIVE)
	class SingleValueNotPrimitiveMatcher{}
	
	@Method(src = "#{properties}", srcFilterFun = SingleValueNotPrimitiveMatcher.class)
	void singleValueNotPrimitiveMatcher$name$(){};
	
	@Matcher(typeCategory=TypeCategory.ARRAY)
	class ArrayMatcher{}

	@Method(src = "#{properties}", srcFilterFun = ArrayMatcher.class)
	void arrayMatcher$name$(){};
	
	@Matcher(typeCategory=TypeCategory.COLLECTION)
	class CollectionMatcher{}
	
	@Method(src = "#{properties}", srcFilterFun = CollectionMatcher.class)
	void collectionMatcher$name$(){};
	
	@Matcher(typeCategoryNot=TypeCategory.COLLECTION)
	class NotCollectionMatcher{}
	
	@Method(src = "#{properties}", srcFilterFun = NotCollectionMatcher.class)
	void notCollectionMatcher$name$(){};
	
	/**
	 *  The implementation of the value object #{voInterface.simpleName}.
	 *
	 */
	@InnerClass
	static final class Value implements VoInterface {
		@Field(src = "#{properties}",
				srcVar = "p",
				getter = @Getter())
		private final SrcType $name$ = null;

		@Matcher(type = Date.class)
		public @interface isDate {
		}

		@Matcher(type = List.class)
		public @interface isList {
		}

		@Matcher(type = Set.class)
		public @interface isSet {
		}

		@Switch
		static class defensiveCopyFragment {
			@isDate
			@CodeFragment(imports = Date.class,
					code = "new Date(#{surrounded}.getTime())")
			String copyDate;

			@isList
			@CodeFragment(imports = { ArrayList.class, Collections.class },
					code = "Collections.unmodifiableList(new ArrayList<>(#{surrounded}))")
			String copyList;

			@isSet
			@CodeFragment(imports = { HashSet.class, Collections.class },
					code = "Collections.unmodifiableSet(new HashSet<>(#{surrounded}))")
			String copySet;
			
			@DefaultCase
			@CodeFragment(code="#{surrounded}")
			String dflt;
		}

		@CodeFragment(code = "builder.#{name}",
				surroundingFragments = "defensiveCopyFragment")
		static class rhs {
		}

		@CodeFragment(code = "this.#{name} = #{rhs()};")
		static class assignment {
		}

		@Constructor(bodyIterator = "#{properties}",
				bodyCode = "#{assignment()}")
		private Value(Builder builder) {

		}

		/**
		 * <ul>
		 * <li>japkit.bodyBeforeIteratorCode
		 * 
		 * <pre>
		 * if (!(obj instanceof Value)) {
		 * 	return false;
		 * }
		 * Value other = (Value) obj;
		 * return
		 * </pre>
		 *  
		 * <li>japkit.bodyCode Objects.equals(#{name}, other.#{name})
		 * <li>japkit.bodyAfterIteratorCode ;
		 * </ul>
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
		 * @japkit.bodyBeforeIteratorCode return "#{voInterface.simpleName} {"+
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
