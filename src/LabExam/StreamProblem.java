package LabExam;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 Write a method that uses a stream to find all occurrences
    of words in the nums list that contain an even number of x's.
    You must use a Stream to solve the problem.

For example:
    streamQuestion ("", "xxxx", "axxa") returns "xxxx", "axxa"
    streamQuestion ("axbc", "x", "xx") returns "xx"
    streamQuestion ("axbc", "", "bcx") returns ()
 */

public class StreamProblem {
    public boolean evenX(String s) {
        int count = 0;

        if (s.equals(""))
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                count++;
            }
        }

        if (count % 2 == 0 && count != 0)
            return true;

        return false;
    }

    public ArrayList<String> streamQuestion(ArrayList<String> nums) {
        return (ArrayList<String>) nums.stream()
                .filter(n -> evenX(n))
                .collect(Collectors.toList());
    }
}
