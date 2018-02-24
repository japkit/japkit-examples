package de.japkit.examples.freebuilder.test;

public class PersonTest {
	
	private Person p;
	
	@SuppressWarnings("unused")
	public void syntacticalTest(){
		
		String[] stringArray = p.getStringArray();
		
		String[] stringArrayWithTypeAnnotation = p.getStringArrayWithTypeAnnotation();
		
		int[] intArray = p.getIntArray();
		
		int intWithTypeAnnotation = p.getIntWithTypeAnnotation();
	}

}
