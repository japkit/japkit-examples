package de.japkit.examples.freebuilder.test;

public class PersonTest {
	
	private PersonBuilder p;
	
	@SuppressWarnings("unused")
	public void syntacticalTest(){
		
		String[] stringArray = p.getStringArray();
		
		String[] stringArrayWithTypeAnnotation = p.getStringArrayWithTypeAnnotation();
		
		int[] intArray = p.getIntArray();
		
		int intWithTypeAnnotation = p.getIntWithTypeAnnotation();	
		p.primitiveMatcherIntegerWithTypeAnnotation();
		
		Integer integerWithTypeAnnotation = p.getIntegerWithTypeAnnotation();
		p.primitiveMatcherIntWithTypeAnnotation();
		
		Number number = p.getWildcardExtendsNumberList().get(0);
	}

}
