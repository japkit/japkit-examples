package de.japkit.examples.freebuilder.test;

import java.util.List;
import java.util.Set;

import de.japkit.examples.freebuilder.FreeBuilder;

@FreeBuilder
public interface Person {
	/** Returns the person's full (English) name. */
	String getName();

	/** Returns the person's age in years, rounded down. */
	int getAge();
	
	List<String> getTelephoneNumbers();
	
	Set<String> getNicknames();

	/** Builder of {@link Person} instances. */
	class Builder extends PersonBuilder {
	}
}
