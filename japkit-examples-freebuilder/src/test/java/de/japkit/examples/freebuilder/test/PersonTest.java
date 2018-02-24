package de.japkit.examples.freebuilder.test;

import java.util.List;

import de.japkit.examples.freebuilder.test.AddressBuilder.Value;

public class PersonTest {
	
	private PersonBuilder p;
	
	@SuppressWarnings("unused")
	public void syntacticalTest(){
		
		String[] stringArray = p.getStringArray();
		p.arrayMatcherStringArray();
		p.singleValueNotPrimitiveMatcherStringArray();
		p.notCollectionMatcherStringArray();
		
		String[] stringArrayWithTypeAnnotation = p.getStringArrayWithTypeAnnotation();
		p.arrayMatcherStringArrayWithTypeAnnotation();
		p.singleValueNotPrimitiveMatcherStringArrayWithTypeAnnotation();
		p.notCollectionMatcherStringArrayWithTypeAnnotation();
		
		int[] intArray = p.getIntArray();
		p.arrayMatcherIntArray();
		p.singleValuePrimitiveMatcherIntArray();
		p.notCollectionMatcherIntArray();
		
		int intWithTypeAnnotation = p.getIntWithTypeAnnotation();	
		p.primitiveMatcherIntegerWithTypeAnnotation();
		p.singleValuePrimitiveMatcherIntWithTypeAnnotation();
		p.notCollectionMatcherIntWithTypeAnnotation();
		
		Integer integerWithTypeAnnotation = p.getIntegerWithTypeAnnotation();
		p.primitiveMatcherIntWithTypeAnnotation();
		p.singleValuePrimitiveMatcherIntegerWithTypeAnnotation();
		p.notCollectionMatcherIntegerWithTypeAnnotation();
		
		List<String> stringList = p.getStringList();
		p.collectionMatcherStringList();
		p.singleValueNotPrimitiveMatcherStringList();
		
		Number number = p.getWildcardExtendsNumberList().get(0);
		p.collectionMatcherWildcardExtendsNumberList();
		
		Value addressGenerated = p.getAddressGenerated();
		p.notCollectionMatcherAddressGenerated();
		p.singleValueNotPrimitiveMatcherAddressGenerated();
		
		p.getAddressGeneratedList();
		p.collectionMatcherAddressGeneratedList();
		p.singleValueNotPrimitiveMatcherAddressGeneratedList();
		
		
	}

}
