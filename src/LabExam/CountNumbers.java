package LabExam;

public class CountNumbers {

    /**
     * Given a String array, count the number of integers in
     * the array.  YOu may assume the String contain no spaces
     * Throw an IllegalArgumentException if you encounter a null string
     *
     * For example:
     * CountNum ("123", "3a45", "abc", "", "456") returns 2
     * CountNum ("123", "3a45", null, "", "456") throws IllegalArgumentException
     * CountNum ("0123", "345", "", "000") returns 3
     */

//    public boolean isAllDigits(String s) {
//        for (int i = 0; i < s.length(); i++)
//            if (!Character.isDigit(s.charAt(i)))
//                return false;
//            if (s.equals(""))
//                return false;
//        return true;
//    }

    public int countNum(String[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
//            if (data[i] == null)
//                throw new IllegalArgumentException();
//            if (isAllDigits(data[i]))
//                count++;
//            else if (!data[i].equals("") && isAllDigits(data[i].substring(1))) {
//                count++;
//            }
            try {
                Integer.parseInt(data[i]);
                count++;
            } catch (Exception e) {

            }
        }

        return count;
    }
}
