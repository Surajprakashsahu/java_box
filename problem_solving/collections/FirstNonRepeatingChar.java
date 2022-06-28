package com.samples.problemsolving.collections;

/**
 * PROBLEM STATEMENT:
 * 1. Find first non repeating character in array.
 * 2. Array cannot be iterated more than once.
 * 3. Can use java 8 features.
 */

import java.util.Iterator;
import java.util.LinkedHashMap;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		
		// First non repeating char is at 0th index.
		char res = solve("xskjdflkmsjdflkjslfv");
		
		System.out.println("res1: "+ res);
		
		// First non repeating char is at 7th index.
		res = solve("skjdflkmsjdflkjslfv");
		
		System.out.println("res2: "+ res);
		
		// First non repeating char is at last index.
		res = solve("skjdflksjdflkjslfv");
		
		System.out.println("res3: "+ res);

	}
	
	public static char solve(String s) {
		char res = 0;
		
		// LinkedHashMap preserves the order input added. 
		// Which can help us to pick first non repeating character if we save frequency. 
		LinkedHashMap<Character, Integer> fmap = new LinkedHashMap<>();
		
		// Create frequency LinkedHashMap of characters.
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch)+1);
			}else {
				fmap.put(ch, 1);
			}
		}
		
		// Get Iterator bcz we can.
		Iterator<Character> i = fmap.keySet().iterator();
		
		// Check for first character with frequency 1 and save the result and break.
		while(i.hasNext()) {
			char ch = i.next();
			int val = fmap.get(ch);
			if(val == 1){
				res = ch;
				break;
			}
		}
		
		return res;
	}

}
