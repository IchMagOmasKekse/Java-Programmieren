package me.xxfreakdevxx.de.game;

import java.util.ArrayList;
import java.util.Random;

public class CodeGenerator {
	
	/* ID-Listen
	 * Dienen dazu, dass es keine doppelten IDs gibt */
	
	private static ArrayList<String> entityIds = new ArrayList<String>();
	
	static Random random = new Random();
	
	//Generiert eine Code der jeden Entity spezifisch zugewiesen wird
	
	public static String generateEntityId() {
		String code = "";
		code = "";
		int blockNumbers = 15;
		int blocks = 10;
		for(int a = 1; a != blocks+1; a++) {
			String s = "";
			for(int i = 0; i != blockNumbers; i++) {
				s += random.nextInt(10);
			}
			code=code+s;
			if(a != blocks) code=code+"-";
		}
		while(entityIds.contains(code)) {
			code = generateEntityId();
		}
		entityIds.add(code);
		return code;
	}
	
}
