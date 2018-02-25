package de.japkit.examples.freebuilder.test;

import java.util.List;
import java.util.Map;

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
		
		List<String> stringListWithTypeAnnotation = p.getStringListWithTypeAnnotation();
		p.collectionMatcherStringListWithTypeAnnotation();
		p.singleValueNotPrimitiveMatcherStringListWithTypeAnnotation();
		
		Number number = p.getWildcardExtendsNumberList().get(0);
		p.collectionMatcherWildcardExtendsNumberList();
		
		Value addressGenerated = p.getAddressGenerated();
		p.notCollectionMatcherAddressGenerated();
		p.singleValueNotPrimitiveMatcherAddressGenerated();
		
		List<Value> addressGeneratedList = p.getAddressGeneratedList();
		p.collectionMatcherAddressGeneratedList();
		p.singleValueNotPrimitiveMatcherAddressGeneratedList();
		
		Value addressGeneratedWithTypeAnnotation = p.getAddressGeneratedWithTypeAnnotation();
		p.notCollectionMatcherAddressGeneratedWithTypeAnnotation();
		p.singleValueNotPrimitiveMatcherAddressGeneratedWithTypeAnnotation();
		
		
		Map<String, String> stringMap = p.getStringMap();
		p.notCollectionMatcherStringMap();
		p.singleValueNotPrimitiveMatcherStringMap();
		p.mapMatcherStringMap();
		
		Map<String, String> stringMapWithTypeAnnotation = p.getStringMapWithTypeAnnotation();
		p.notCollectionMatcherStringMapWithTypeAnnotation();
		p.mapMatcherStringMapWithTypeAnnotation();
		
		Map<String, Value> addressGeneratedMap = p.getAddressGeneratedMap();
		p.notCollectionMatcherAddressGeneratedMap();
		p.singleValueNotPrimitiveMatcherAddressGeneratedMap();
		p.mapMatcherAddressGeneratedMap();
		
		
		Map<String, Value> addressGeneratedMapWithTypeAnnotation = p.getAddressGeneratedMapWithTypeAnnotation();
		p.notCollectionMatcherAddressGeneratedMapWithTypeAnnotation();
		p.singleValueNotPrimitiveMatcherAddressGeneratedMapWithTypeAnnotation();
		p.mapMatcherAddressGeneratedMapWithTypeAnnotation();
	}

}
