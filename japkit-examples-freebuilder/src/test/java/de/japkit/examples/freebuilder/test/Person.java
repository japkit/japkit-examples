package de.japkit.examples.freebuilder.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import de.japkit.examples.freebuilder.FreeBuilder;

@FreeBuilder
public interface Person {

	/** Returns the person's full (English) name. */
	@NotNull
	String getName();

	/** Returns the person's age in years, rounded down. */
	int getAge();

	List<String> getTelephoneNumbers();

	Set<String> getNicknames();

	String[] getStringArray();

	@NotNull
	String[] getStringArrayWithTypeAnnotation();

	@NotNull
	int getIntWithTypeAnnotation();

	@NotNull
	Integer getIntegerWithTypeAnnotation();

	int[] getIntArray();

	List<String> getStringList();

	@NotNull
	List<String> getStringListWithTypeAnnotation();

	@NotNull
	List<? extends Number> getWildcardExtendsNumberList();

	Address getAddress();

	@NotNull
	Address getAddressWithTypeAnnotation();

	List<Address> getAddressList();

	List<? extends Address> getWildcardAddressList();

	AddressBuilder.Value getAddressGenerated();

	@NotNull
	AddressBuilder.Value getAddressGeneratedWithTypeAnnotation();

	List<AddressBuilder.Value> getAddressGeneratedList();

	Map<String, String> getStringMap();

	@NotNull
	Map<String, String> getStringMapWithTypeAnnotation();

	Map<String, AddressBuilder.Value> getAddressGeneratedMap();

	@NotNull
	Map<String, AddressBuilder.Value> getAddressGeneratedMapWithTypeAnnotation();

	@NotNull
	SomeAnnotatedClass getSomeAnnotatedClassWithTypeAnnotation();

	@NotNull
	List<SomeAnnotatedClass> getSomeAnnotatedClassWithTypeAnnotationList();

	List<SomeAnnotatedClass> getSomeAnnotatedClassList();

	/** Builder of {@link Person} instances. */
	class Builder extends PersonBuilder {
	}
}
