package HackerRank;
/*
For this exercise, keep in mind the following definitions:

A term is either an initials or word.
initials = 1 character
words = 2+ characters (no dots allowed)
A valid name is a name written in one of the following ways:

H. Wells
H. G. Wells
Herbert G. Wells
Herbert George Wells
The following names are invalid:

Herbert or Wells (single names not allowed)
H Wells or H. G Wells (initials must end with dot)
h. Wells or H. wells or h. g. Wells (incorrect capitalization)
H. George Wells (middle name expanded, while first still left as initial)
H. G. W. (last name is not a word)
Herb. G. Wells (dot only allowed after initial, not word)
Rules
Both initials and words must be capitalized.
Initials must end with a dot.
A name must be either 2 or 3 terms long.
If the name is 3 words long, you can expand the first and middle name or expand the first name only. You cannot keep the first name as an initial and expand the middle name only.
The last name must be a word (not an initial).
Your task is to write a function that determines whether a name is valid or not. Return true if the name is valid, false otherwise.

Examples
validName("H. Wells") ➞ true

validName("H. G. Wells") ➞ true

validName("Herbert G. Wells") ➞ true

validName("Herbert") ➞ false
// Must be 2 or 3 words

validName("h. Wells") ➞ false
// Incorrect capitalization

validName("H Wells") ➞ false
// Missing dot after initial

validName("H. George Wells") ➞ false
// Cannot have: initial first name + word middle name

validName("H. George W.") ➞ false
// Last name cannot be initial

validName("Herb. George Wells") ➞ false
// Words cannot end with a dot (only initials can)
 */
public class CheckNamesInitials
{
	private static boolean checkValidNames(String str)
	{
		String[] words = str.split(" +");
		
		if(words.length < 2)
			return false;
		
		if(words.length == 3 && words[0].contains(".") && !words[1].contains("."))
			return false;
		
		if(words[words.length-1].contains("."))
			return false;
		
		for(String word : words)
		{
			if(word.length() < 3 && !word.contains("."))
				return false;
			
			if(!Character.isUpperCase(word.charAt(0)))
				return false;
			
			if(word.contains(".") && word.length() != 2)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(checkValidNames("Kajal Desai"));
//		System.out.println("H. G. Wells: "+checkValidNames("H. G. Wells"));
//		System.out.println("Herbert G. Wells: "+checkValidNames("Herbert G. Wells"));
//		System.out.println("Herbert George Wells: "+checkValidNames("Herbert George Wells"));
//		
//		System.out.println("");
//		
//		System.out.println("Herbert: "+checkValidNames("Herbert"));
//		System.out.println("H. G Wells: "+checkValidNames("H. G Wells"));
//		System.out.println("h. g. Wells: "+checkValidNames("h. g. Wells"));
//		System.out.println("H. George Wells: "+checkValidNames("H. George Wells"));
//		System.out.println("H. G. W. "+checkValidNames("H. G. W."));
//		System.out.println("Herb. G. Wells "+checkValidNames("Herb. G. Wells"));
	}
}
