package LabExamPractice;

import org.junit.Assert;
import org.junit.Test;

/**
 *
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
 * be asked to stop typing and stand next to your machine. Continuing
 * to type will be considered cheating at that point, which will result
 * in you getting a 0 on this exam.
 *
 * Grading:
 * 		3 correct   	100%
 * 		2 correct:		84%
 *          1 correct:        75%
 *
 * 		Only one problem may be submitted for partial credit. For
 * 		example, if you have 1 complete but 2 partially complete, let
 * 		us know which one you want to submit for partial credit. Your
 * 		grade will be between 75 and 81%.
 *
 *
 */
public class LabFinal {

    /**
     * The main method to run and test the methods you write.
     */

    @Test
    public void inOrderTest() {
        // Question 1
        Numbers numbers = new Numbers();
        String[] str1 = {"aa10", "ddd2000", "000htg0030000"};
        String[] str2 = {"1", "2a", "3", "-4", "-3a", "-2", "-1"};
        String[] str3 = {"1", "1s", "2"};
        String[] str4 = {"50", "40", "3", "40", "5"};
        String[] str5 = {"2", "-1", "sdf2", "-10", "s"};
        String[] str6 = {"1", "2", "1"};
        String[] str7 = {"1", "s", "1"};
        String[] str8 = {"300", "20000", "a1"};

        Assert.assertTrue(numbers.inOrderQuestion(str1));
        Assert.assertTrue(numbers.inOrderQuestion(str2));
        Assert.assertTrue(numbers.inOrderQuestion(str3));
        Assert.assertFalse(numbers.inOrderQuestion(str4));
        Assert.assertTrue(numbers.inOrderQuestion(str5));
        Assert.assertFalse(numbers.inOrderQuestion(str6));
        Assert.assertTrue(numbers.inOrderQuestion(str7));
        Assert.assertFalse(numbers.inOrderQuestion(str8));
    }


    @Test
    public void question2() {
        // Question 2
        Recursion recursion = new Recursion();
        Assert.assertEquals("abc", recursion.parenBit("xyz(abc)123"));
        Assert.assertEquals("hello", recursion.parenBit("x(hello)"));
        Assert.assertEquals("xy", recursion.parenBit("(xy)1"));
        Assert.assertEquals("", recursion.parenBit("()"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void question3() {
        // Question 3
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.delALL("pie");

        Assert.assertTrue(linkedList.toString().equals("Forward: donut iceCream iceCream pair donut \n" +
                "Backward: donut pair iceCream iceCream donut "));
        linkedList.delALL("donut");

        Assert.assertTrue(linkedList.toString().equals("Forward: iceCream iceCream pair \n" +
                "Backward: pair iceCream iceCream "));

        linkedList.delALL("iceCream");

        Assert.assertTrue(linkedList.toString().equals("Forward: pair \n" +
                "Backward: pair "));

        try {
            linkedList.delALL("popsicle");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        linkedList.delALL("pair");
        linkedList.delALL("pair");

        /*

        ---------Linked List TestExtra --------
        Forward: donut iceCream popsicle pie
        Backward: pie popsicle iceCream donut


         */

    }

    @Test
    public void testDel3rd() {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.del3rd();
        Assert.assertTrue(linkedList.toString().equals("Forward: donut pie iceCream pair \n" +
                "Backward: pair iceCream pie donut "));

        linkedList.del3rd();
        Assert.assertTrue(linkedList.toString().equals("Forward: donut pie pair \n" +
                "Backward: pair pie donut "));

        linkedList.del3rd();
        Assert.assertTrue(linkedList.toString().equals("Forward: donut pie \n" +
                "Backward: pie donut "));

        linkedList.del3rd();
        Assert.assertTrue(linkedList.toString().equals("Forward: donut pie \n" +
                "Backward: pie donut "));

    }

    @Test
    public void testAddEveryOther() {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addEvery2("2");
        Assert.assertTrue(linkedList.toString().equals("Forward: donut pie 2 iceCream iceCream 2 pair donut 2 \n" +
                "Backward: 2 donut pair 2 iceCream iceCream 2 pie donut "));
    }
}
