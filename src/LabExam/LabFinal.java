package LabExam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * To complete this Lab Final, go to each of these three classes and
 * complete the TODO's within
 *
 * DO NOT alter this file in any way nor any of the other methods
 * provided in the three classes (aside from those with TODO's)
 * DO NOT leave in any extra print statements in your code
 *
 * You may add helper functions in any of the three classes if you
 * wish.
 *
 * When you are ready, raise your hand. One of us will come to you to
 * grade your exam. You only get one chance to have your exam graded.
 * Grading will be done silently, after which you will be dismissed
 * from class so that others can concentrate on completing this exam.
 * If time is called and you are still working on your exam, you will
 * be asked to stop typing and stand next to your machine.
 *
 * Grading:
 * 		2 out of 3 correct: 	88%
 * 		1 correct:		        76%
 * 		ALL correct:		    100%
 *
 * 		Only one problem may be submitted for partial credit. For
 * 		example, if you have 1 complete but 2 partially complete, let
 * 		us know which one you want to submit for partial credit. Your
 * 		grade will be between 76 and 88%.
 */

public class LabFinal {

    /**
     * The main method to run and test the methods you write.
     */

    @Test
    public void question1() {
        // Question 1
        String[] data1 = new String[3];
        data1[0] = "323";
        data1[1] = "-";
        data1[2] = "3233";

        CountNumbers count = new CountNumbers();
        Assert.assertTrue(count.countNum(data1) == 2);

        String[] data2 = new String[5];
        data2[0] = "1";
        data2[1] = "-2";
        data2[2] = "000";
        data2[3] = "0333";
        data2[4] = "xxx";

        Assert.assertTrue(count.countNum(data2) == 4);

        try {
            String[] data3 = new String[3];
            data3[0] = "";
            data3[1] = null;
            data3[2] = "123";
            count.countNum(data3);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }


    @Test
    public void question2() {
        // Question 2
        StreamProblem labexam = new StreamProblem();
        ArrayList<String> before1 = LoadArrayListFromVarList("x", "xex", "e");
        ArrayList<String> before2 = LoadArrayListFromVarList("", "xxxx", "axxa");
        ArrayList<String> before3 = LoadArrayListFromVarList("axbc", "x", "xx");
        ArrayList<String> before4 = LoadArrayListFromVarList("abc", "x", "bcxxx");
        ArrayList<String> before5 = LoadArrayListFromVarList("axbcx");
        ArrayList<String> before6 = LoadArrayListFromVarList("axbc", "", "bcx");
        ArrayList<String> before7 = LoadArrayListFromVarList("");

        ArrayList<String> after1 = LoadArrayListFromVarList("xex");
        ArrayList<String> after2 = LoadArrayListFromVarList("xxxx", "axxa");
        ArrayList<String> after3 = LoadArrayListFromVarList("xx");
        ArrayList<String> after4 = LoadArrayListFromVarList();
        ArrayList<String> after5 = LoadArrayListFromVarList("axbcx");
        ArrayList<String> after6 = LoadArrayListFromVarList();
        ArrayList<String> after7 = LoadArrayListFromVarList();

        ArrayList<String> list1 = labexam.streamQuestion(before1);
        assertTrue(isTwoArrayListsWithSameValues(after1, list1));

        ArrayList<String> list2 = labexam.streamQuestion(before2);
        assertTrue(isTwoArrayListsWithSameValues(after2, list2));

        ArrayList<String> list3 = labexam.streamQuestion(before3);
        assertTrue(isTwoArrayListsWithSameValues(after3, list3));

        ArrayList<String> list4 = labexam.streamQuestion(before4);
        assertTrue(isTwoArrayListsWithSameValues(after4, list4));

        ArrayList<String> list5 = labexam.streamQuestion(before5);
        assertTrue(isTwoArrayListsWithSameValues(after5, list5));

        ArrayList<String> list6 = labexam.streamQuestion(before6);
        assertTrue(isTwoArrayListsWithSameValues(after6, list6));

        ArrayList<String> list7 = labexam.streamQuestion(before7);
        assertTrue(isTwoArrayListsWithSameValues(after7, list7));
    }


    @Test(expected = IllegalArgumentException.class)
    public void question3() {
        // Question 3
        MyLinkedList linkedList = new MyLinkedList(false);
        linkedList.delALL("pie");

        Assert.assertTrue(linkedList.toString().equals("donut iceCream iceCream pair donut"));
        linkedList.delALL("donut");

        Assert.assertTrue(linkedList.toString().equals("iceCream iceCream pair"));

        linkedList.delALL("iceCream");

        Assert.assertTrue(linkedList.toString().equals("pair"));

        try {
            linkedList.delALL("popsicle");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        linkedList.delALL("pair");
        linkedList.delALL("pair");
    }

    /*******************************************************************************************************************
     *  Helper methods....
     *
     */
    private boolean isTwoArrayListsWithSameValues(ArrayList<String>
                                                          list1, ArrayList<String> list2) {
        //null checking
        if (list1 == null && list2 == null)
            return true;
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null))
            return false;
        if (list1.size() != list2.size())
            return false;
        for (Object itemList1 : list1)
            if (!list2.contains(itemList1)) {
                return false;
            }
        return true;
    }

    private ArrayList<String> LoadArrayListFromVarList(String ... list) {
        ArrayList<String> returnList = new ArrayList<String>();
        for (String s: list)
            returnList.add(s);

        return returnList;
    }
}