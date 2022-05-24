package strings;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Improve for a list now [bat,cat,rat,art] - > return [cat],[bat],[rat,art]
		String s1 ="aacc";		
		String s2 = "aacc";
		String res = anagram2string(s1,s2);
		System.out.println(res);
	}
	
	
	public static String anagram2string(String s1, String s2) {
		
     int[] counter = new int[26];
		
		if(s1.length()!=s2.length()) {
			return "Not an Anagram";
		}
		
		for (int i = 0;i<s1.length()-1;i++) {
			counter[s1.charAt(i)-'a']++;
		}

		
		for (int j = 0;j<s2.length()-1;j++) {
			counter[s2.charAt(j) -'a']--;
			for (int i : counter) {
				//System.out.println(i);
				if(i<0) {
					return "Not a Anagram";
				}
			}
		}
		
		
		return "Anagram";
	}

}
