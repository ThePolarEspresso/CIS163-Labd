package LabExamPractice;

public class Recursion {
    /**
     * Given a string that contains a single pair of parenthesis,
     * compute recursively a new string made or their contents,
     * so "xyz(abc)123" yields "abc".
     * <p>
     * Assume the input string always contains pair of parenthesis
     * <p>
     * <p>
     * parenBit("xyz(abc)123") → "abc"
     * parenBit("x(hello)") → "hello"
     * parenBit("(xy)1") → "xy"
     * parenBit("()") → ""
     */
    public String parenBit(String str) {
        // TODO: Write a recursive function to complete this method
        //
        // Note: The code below is simply a placeholder to allow the
        // code to compile and run.'
        if (str.length() < 3)
            return str;


        return null;
    }
}





/***********************************************************************
 public String parenBit(String str) {

 //
 // Note: The code below is simply a placeholder to allow the
 // code to compile and run.

 if (str.equals("")) return str;
 if (str.charAt(0) == '(') {

 if (str.charAt(str.length() - 1) == ')')
 return str.substring(1,str.length()-1);
 else
 return parenBit(str.substring(0, str.length() - 1));
 } else
 return parenBit(str.substring(1));
 }
*/