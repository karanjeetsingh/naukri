package com.iq.patternmatch;

class IsaMatch {
	boolean isMatch(String str, String pass) {
		char[] strarr = str.toCharArray();
		char[] pstring = str.toCharArray();
		int i = 0,j = 0;

		while(j < pstring.length) {
			System.out.println("i = " +i);
			System.out.println("j = " +j);
			if(pstring[j] != '*' || pstring[j] !='?' ) {
				if(pstring[j] != strarr[i])
					return false;
			i++;
			j++;
			continue;
			}
			
			if(pstring[j] == '?') {
				i++;
				j++;
				continue;
			}
			
			if(j + 1 == pstring.length ) {
				return true;
			}
			
			char newchar = pstring[j+1];
			while(strarr[i] != newchar && i < (strarr.length - 1 )) {
				i++;
			}
		}
		if( i != strarr.length)
			return false;
		else
			return true;
	}
}

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * @author kanwal
 *
 */
public class PatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsaMatch obj = new IsaMatch();
		System.out.println(obj.isMatch("test", "?*"));

	}

}
