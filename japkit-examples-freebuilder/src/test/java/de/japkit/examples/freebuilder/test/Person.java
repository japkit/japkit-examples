package de.japkit.examples.freebuilder.test;

import de.japkit.examples.freebuilder.FreeBuilder;

@FreeBuilder
public interface Person {
	/** Returns the person's full (English) name. */
	String getName();

	/** Returns the person's age in years, rounded down. */
	int getAge();

	/** Builder of {@link Person} instances. */
	class Builder extends PersonBuilder {
	}
}
