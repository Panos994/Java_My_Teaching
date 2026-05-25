package org.example;

import com.github.dockerjava.api.model.Link;
import com.sun.source.tree.Tree;
import javafx.beans.binding.StringBinding;
import org.apache.commons.lang3.Range;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.text.CollationKey;
import java.util.LinkedList;
import java.util.Iterator;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Node
{
    int data;
    Node next;

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    Node() {}
}
public class Matrices {

    private static final int CUTOFF = 10;

    static String[] letters = {
            "         ###  ### ###  # #   ##### ###   #  ##     ###  ",
            "         ###  ### ###  # #  #  #  ## #  #  #  #    ###  ",
            "         ###   #   # ########  #   ### #    ##      #   ",
            "          #            # #   #####    #    ###     #    ",
            "                     #######   #  #  # ####   # #       ",
            "         ###           # #  #  #  # #  # ##    #        ",
            "         ###           # #   ##### #   ### #### #       ",
            "   ##    ##                                            #",
            "  #        #   #   #    #                             # ",
            " #          #   # #     #                            #  ",
            " #          # ####### #####   ###   #####           #   ",
            " #          #   # #     #     ###           ###    #    ",
            "  #        #   #   #    #      #            ###   #     ",
            "   ##    ##                   #             ###  #      ",
            "  ###     #    #####  ##### #      ####### ##### #######",
            " #   #   ##   #     ##     ##    # #      #     ##    # ",
            "#     # # #         #      ##    # #      #          #  ",
            "#     #   #    #####  ##### #    # ###### ######    #   ",
            "#     #   #   #            ########      ##     #  #    ",
            " #   #    #   #      #     #     # #     ##     #  #    ",
            "  ###   ##### ####### #####      #  #####  #####   #    ",
            " #####  #####    #     ###      #           #     ##### ",
            "#     ##     #  ###    ###     #             #   #     #",
            "#     ##     #   #            #     #####     #        #",
            " #####  ######         ###   #                 #     ## ",
            "#     #      #   #     ###    #     #####     #     #   ",
            "#     ##     #  ###     #      #             #          ",
            " #####  #####    #     #        #           #       #   ",
            " #####    #   ######  ##### ###### ############## ##### ",
            "#     #  # #  #     ##     ##     ##      #      #     #",
            "# ### # #   # #     ##      #     ##      #      #      ",
            "# # # ##     ####### #      #     ######  #####  #  ####",
            "# #### ########     ##      #     ##      #      #     #",
            "#      #     ##     ##     ##     ##      #      #     #",
            " ##### #     #######  ##### ###### ########       ##### ",
            "#     #  ###        ##    # #      #     ##     ########",
            "#     #   #         ##   #  #      ##   ####    ##     #",
            "#     #   #         ##  #   #      # # # ## #   ##     #",
            "#######   #         ####    #      #  #  ##  #  ##     #",
            "#     #   #   #     ##  #   #      #     ##   # ##     #",
            "#     #   #   #     ##   #  #      #     ##    ###     #",
            "#     #  ###   ##### #    # ########     ##     ########",
            "######  ##### ######  ##### ########     ##     ##     #",
            "#     ##     ##     ##     #   #   #     ##     ##  #  #",
            "#     ##     ##     ##         #   #     ##     ##  #  #",
            "###### #     #######  #####    #   #     ##     ##  #  #",
            "#      #   # ##   #        #   #   #     # #   # #  #  #",
            "#      #    # #    # #     #   #   #     #  # #  #  #  #",
            "#       #### ##     # #####    #    #####    #    ## ## ",
            "#     ##     ######## ##### #       #####    #          ",
            " #   #  #   #      #  #      #          #   # #         ",
            "  # #    # #      #   #       #         #  #   #        ",
            "   #      #      #    #        #        #               ",
            "  # #     #     #     #         #       #               ",
            " #   #    #    #      #          #      #               ",
            "#     #   #   ####### #####       # #####        #######",
            "  ###                                                   ",
            "  ###     ##   #####   ####  #####  ###### ######  #### ",
            "   #     #  #  #    # #    # #    # #      #      #    #",
            "        ###### #    # #      #    # #      #      #  ###",
            "    #   #    # #####  #      #    # #####  #####  #     ",
            "        #    # #    # #    # #    # #      #      #    #",
            "        #    # #####   ####  #####  ###### #       #### ",
            "                                                        ",
            " #    #    #        # #    # #      #    # #    #  #### ",
            " #    #    #        # #   #  #      ##  ## ##   # #    #",
            " ######    #        # ####   #      # ## # # #  # #    #",
            " #    #    #        # #  #   #      #    # #  # # #    #",
            " #    #    #   #    # #   #  #      #    # #   ## #    #",
            " #    #    #    ####  #    # ###### #    # #    #  #### ",
            "                                                        ",
            " #####   ####  #####   ####   ##### #    # #    # #    #",
            " #    # #    # #    # #         #   #    # #    # #    #",
            " #    # #    # #    #  ####     #   #    # #    # #    #",
            " #####  #  # # #####       #    #   #    # #    # # ## #",
            " #      #   #  #   #  #    #    #   #    #  #  #  ##  ##",
            " #       ### # #    #  ####     #    ####    ##   #    #",
            "                       ###     #     ###   ##    # # # #",
            " #    #  #   # ###### #        #        # #  #  # # # # ",
            "  #  #    # #      #  #        #        #     ## # # # #",
            "   ##      #      #  ##                 ##        # # # ",
            "   ##      #     #    #        #        #        # # # #",
            "  #  #     #    #     #        #        #         # # # ",
            " #    #    #   ######  ###     #     ###         # # # #"
    };

    public static void main(String[] args) {

//        int[] arr = {6,1,3,0};
//        String[]  s = {"Java", "Python", "C#", "Javascript", "PHP"};
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i + 1; j<arr.length;j++){
//                if(arr[i] > arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//            System.out.println(arr[i]);
//        }
//        Arrays.sort(s);
//        System.out.println(Arrays.toString(s));
        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 4, 6};
        System.out.println(sumOfArray(arr));

        printDashes();

        System.out.println(containsValue(arr, 4));

        System.out.println(checkIndex(arr, 5));

        System.out.println(removeElement(arr, 5));

        Integer[] arr2 = {5, 4, 3};
        System.out.println(removeWithList(arr2, 3));

        int[] source = {5, 4, 3};
        int[] destination = new int[arr2.length];
        copyArrayByIteration(source, destination);

        Integer[] arrayForInsertion = {10, 20, 30, 40};
        System.out.println(insertElement(arrayForInsertion, 7, 1));


        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Orange");
        myList.add("Grapefruit");
        myList.add("Watermellon");
        iterateList(myList);


        int[] data = {15, 3, 99, 0, 72, 45, 1};
        System.out.print("Δεδομένα: ");
        printArray(data);
        int[] minMaxResult = findMinMax(data);
        if (minMaxResult != null) {
            // Σημείωση: Επιστρέφει {Max, Min}
            System.out.println("Μέγιστη τιμή (Max): " + minMaxResult[0]);
            System.out.println("Ελάχιστη τιμή (Min): " + minMaxResult[1]);
        } else {
            System.out.println("Ο πίνακας είναι κενός.");
        }


        int[] revArr = {0, 56, 47, 56, 0};
        reverseArray(revArr);
        printArray(revArr);

        findDuplicates(revArr);


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list);
        insertToList(list);
        System.out.println(list);


        int[] jj = {0, 3, 5, 101, 4};
        int[] ii = {3, 64, 46, 101, 0, 9};
        commonElements(jj, ii);


        ArrayList<Integer> myList25 = new ArrayList<>();
        retrieveElement(myList25);

        ArrayList<Integer> myList26 = new ArrayList<>();
        //removeThirdElement(myList26);

        System.out.println();
        searchElement(myList26, 2000);

        System.out.println();
        ArrayList<Integer> myList27 = new ArrayList<>();
        sort(myList27);

        System.out.println();
        ArrayList<Integer> myList28 = new ArrayList<>();
        sortLamba(myList28);

        int[] arr345 = {0, 5, 6, 7, 8, 7};
        int[] uniqueArray = removeDuplicates(arr345);
        System.out.println(Arrays.toString(uniqueArray));

        System.out.println();
        int[] largest = {34, 67, 45, 8, 13, 2};
        secondLargerst(largest);

        System.out.println();
        int[] smallest = {34, 67, 45, 8, 13, 2};
        secondSmallest(smallest);

        System.out.println();
        int[] size1 = {34, 67, 45, 8, 13, 2};
        int[] size2 = {34, 67, 45, 8, 13, 2};
        int[] sumArr = addTwoArrays(size1, size2);
        System.out.println(Arrays.toString(sumArr));

        System.out.println();
        int[] arr234 = {1, 3, 45, 6, 77};
        System.out.println(converstArrayToList(arr234));


        System.out.println();
        ArrayList<Integer> myListRt = new ArrayList<>();
        myListRt.add(5);
        myListRt.add(6);
        myListRt.add(7);
        myListRt.add(5);
        convertListToArray(myListRt);


        System.out.println();
        int[] arr23 = {0, 40, 5, 2, 56, 6, 50};
        findPairsSum(arr23, 45);

        System.out.println();
        String words = "6 words is a 5words words";
        System.out.println(eliminateAWord(words));

        System.out.println();
        int[] arr31 = {0, 1, 2};
        int[] arr32 = {0, 2, 3};
        int[] arr35 = {0, 1, 2};
        int[] arr33 = {2, 3, 4, 5};
        equalsArrays(arr31, arr35);

        System.out.println("\n");
        ArrayList<String> brands = new ArrayList<>();
        brands.add("Puma");
        brands.add("adidas");
        brands.add("Nike");
        brands.add("NorthFace");
        shuffleList(brands);


        System.out.println();
        int[] ar20 = {5, 3, 4};
        int[] ar21 = {5, 3, 4, 6};
        testEqualArrays(ar20, ar21);

        System.out.println();
        int[] ar23 = {1, 2, 3, 4, 6, 7};
        findMissingNumber(ar23);


        System.out.println();
        System.out.println();
        int[] arr236 = {1, 2, 56, 4};
        int[] arr237 = {1, 2, 56, 6};
        int[] arr238 = {1, 2, 56, 7};
        commonElementsInThreeArrays(arr236, arr237, arr238);


        System.out.println("\n");
        ArrayList<Integer> listr = new ArrayList<>();
        listr.add(5);
        listr.add(45);
        listr.add(90);
        reverseList(listr);


        System.out.println("\n");
        int[] ar2344 = {0, 0, 1, 3, 0, 2, 0, 4};
        moveAllZeroes(ar2344);

        System.out.println("\n");
        int[] ar2345 = {2, 4, 1, 3, 6, 2, 1, 4};
        countEvenOrOddNumbers(ar2345);


        System.out.println("\n");
        List<Integer> subList = new ArrayList<>();
        subList.add(4);
        subList.add(5);
        subList.add(3);
        subList.add(67);
        subList.add(43);
        subList(subList);

        System.out.println("\n");
        int[] ar222 = {2, 45, 6, 88, 22, 3};
        maxMinValuesDifference(ar222);

        System.out.println("\n");
        int[] arr2223 = {2, 45, 6, 88, 22, 3};
        excludeMinMaxAvg(arr2223);

        System.out.println("\n");
        ArrayList<Integer> l23 = new ArrayList<>();
        ArrayList<Integer> l24 = new ArrayList<>();
        l23.add(6);
        l23.add(56);
        l23.add(90);
        l24.add(6);
        l24.add(88);
        l24.add(9);
        compareTwoLists(l23, l24);

        System.out.println("\n");
        List<Integer> lswap = new ArrayList<>();
        lswap.add(3);
        lswap.add(5);
        lswap.add(6);
        lswap.add(88);
        lswap.add(9);
        swapList(lswap);

        System.out.println("\n");
        int[] arr344 = {0, -1, 4, 5, 6, 9};
        excludeZeroesAndMinusOnes(arr344);

        System.out.println("\n");
        checkForZeroesAndOnes(arr344);

        System.out.println("\n");
        int[] arr3456 = {9, 10, 10, 5, 6, 9};
        checkSumOfTensEqualsThirty(arr3456);

        System.out.println("\n");
        int[] arr3458 = {77, 65, 65, 65};
        int item = 65;
        int item1 = 77;
        checkSixtyFiveAndSeventyFive(arr3458, item, item1);


        System.out.println("\n");
        int[] arrDupl = {77, 77, 65, 65, 8, 9, 5};
        System.out.println("\nThe new length of the array is: " + removeDuplicatesArray(arrDupl));


        System.out.println("\n");
        List<Integer> l20 = new ArrayList<>();
        l20.add(3);
        l20.add(5);
        l20.add(6);
        l20.add(88);
        l20.add(9);
        List<Integer> l21 = new ArrayList<>();
        l21.add(3);
        l21.add(5);
        l21.add(56);
        l21.add(666);
        l21.add(5);
        joinLists(l20, l21);


        System.out.println("\n");
        int[] arl2 = {49, 1, 3, 200, 2, 4, 70, 5};
        System.out.println(findLongestConsecutiveSequence(arl2));

        System.out.println("\n");
        int[] arrTarget = {1, 2, 4, 5, 6};
        int targetItem = 6;
        targetSum(arrTarget, targetItem);


        System.out.println("\n");
        List<Integer> initialList = new ArrayList<>();
        initialList.add(3);
        initialList.add(5);
        initialList.add(6);
        initialList.add(88);
        initialList.add(9);
        List<Integer> clonedList = new ArrayList<>();
        cloneLists(initialList, clonedList);

        //or quicker
        System.out.println("\n" + "-----------");
        List<Integer> cloned = createClone(initialList);
        System.out.println(cloned);

        System.out.println("\n");
        int[] arrTriplet = {1, -2, 0, 5, -1, -4};
        int sumOfTriplets = sc.nextInt();
        findTripletsSum(arrTriplet, sumOfTriplets);


        System.out.println("\n");
        List<Integer> clearList = new ArrayList<>();
        clearList.add(3);
        clearList.add(5);
        clearList.add(6);
        clearList.add(88);
        clearList.add(9);
        clearList(clearList);

        System.out.println("\n");
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        int[][] result1 = getAntiDiagonals(matrix1);
        printResult(result1);

        System.out.println("\n");
        int[] arrMajor = {5, 2, 7, 7, 7};
        findMajorityElement(arrMajor);

        System.out.println("\n");
        int[] leaderElements = {11, 6, 3, 8, 5};
        printLeaderElements(leaderElements);


        System.out.println("\n");
        List<Integer> emptyList = new ArrayList<>();
        emptyList(emptyList);

        System.out.println("\n");
        int[] arrCloseToZero = {1, 2, -2, 4, -5, 3, 34};
        pairSumClosestToZero(arrCloseToZero);
        pairSumCloseToZero(arrCloseToZero);

        System.out.println("\n");
        int[] secondSmallAndSmallest = {5, 4, 56, 1, 2};
        findSmallestAndSecondSmallest(secondSmallAndSmallest);

        System.out.println("\n");
        ArrayList<Integer> trimListCapa = new ArrayList<>();
        trimListCapa.add(3);
        trimListCapa.add(5);
        trimListCapa.add(6);
        trimListCapa.add(88);
        trimListCapa.add(9);
        trimListCapacity(trimListCapa);


        System.out.println("\n");
        ArrayList<Integer> incresCapList = new ArrayList<>();
        incresCapList.add(3);
        incresCapList.add(5);
        incresCapList.add(6);
        incresCapList.add(88);
        incresCapList.add(9);
        System.out.println("Original list:" + incresCapList);
        increaseListCapacity(incresCapList);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        incresCapList.add(9);
        System.out.println("increase capacity list:" + incresCapList);

        System.out.println("\n");
        List<Integer> secondElement = new ArrayList<>();
        secondElement.add(89);
        secondElement.add(45);
        secondElement.add(55);
        secondElement.add(56);
        secondElement.add(78);
        replaceSecondElement(secondElement);

        System.out.println("\n");
        List<Integer> elementPosition = new ArrayList<>();
        elementPosition.add(89);
        elementPosition.add(45);
        elementPosition.add(55);
        elementPosition.add(56);
        elementPosition.add(78);
        printElementsPosition(elementPosition);

        System.out.println("\n");
        int[] arrZeOne = {1, 1, 0, 1, 0, 0, 1};
        separateZeroesAndOnes(arrZeOne);
        System.out.println("\n");
        //separateZeroesAndOnes2(arrZeOne); //better complexity

        System.out.println("\n");
        int target = 45;
        int[] arr4Elements = {45, 20, 10, 8, 7, 15, 13, 11, 6};
        sumFourElementsToTarget(arr4Elements, target);

        System.out.println("\n");
        int[] rotaArray = {10, 20, 30, 40, 50, 60};
        System.out.println("Πριν την περιστροφή: " + Arrays.toString(rotaArray)); // [10, 20, 30, 40, 50, 60]
        rotateArray(rotaArray);
        System.out.println("Μετά τη δεξιά περιστροφή: " + Arrays.toString(rotaArray)); // [60, 10, 20, 30, 40, 50]

        System.out.println("\n");
        int[] rotatArray = {10, 20, 30, 40, 50, 60};
        pairSumOfRotatedArr(rotatArray, 50);

        System.out.println("\n");
        List<String> listStr = new ArrayList<>();
        listStr.add("Pinakio");
        listStr.add("Ekthema");
        listStr.add("Secretary");
        appendElementInTheEndOfTheList(listStr);

        System.out.println("\n");
        int[] rotaFour = {40, 50, 10, 20, 30};
        System.out.println("count rotaions: " + rotationCountSortArray(rotaFour));

        System.out.println("\n");
        int[] arrangeNeg = {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
        arrangeNegBeforePos(arrangeNeg);

        System.out.println("\n");
        int[] arrngePos = {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
        System.out.println("Αρχικός πίνακας: " + Arrays.toString(arrngePos));
        arrangePosBeforeNeg(arrngePos);
        System.out.println("Τελικός πίνακας:  " + Arrays.toString(arrngePos));

        System.out.println("\n");
        List<String> listStrForEach = new ArrayList<>();
        listStrForEach.add("month");
        listStrForEach.add("day");
        listStrForEach.add("hour");
        iterateElement(listStrForEach);

        System.out.println("\n");
        int[] minMaxElementssort = {6, 32, 45, 3, 1, 50};
        System.out.println(Arrays.toString(minMaxElementssort));
        int[] result;
        result = sortWithAlternateMaxMinValue(minMaxElementssort);
        System.out.println(Arrays.toString(result));

        System.out.println("\n");
        int[] separateZeroesAndR = {1, 0, 0, 1, 0, 1, 1, 0};
        separateZeroesAndRight(separateZeroesAndR);
        //or
        System.out.println("\n");
        int[] result2;
        result2 = separateZeroesAndRight2(separateZeroesAndR);
        System.out.println(Arrays.toString(result2));


        System.out.println("\n");
        int[] separateResultEvenOddsNums = {5, 66, 3, 44, 2, 1, 0, 3};
        int[] separateResultEvenOdds;
        separateResultEvenOdds = separateEvenOddNums(separateResultEvenOddsNums);
        System.out.println(Arrays.toString(separateResultEvenOdds));

        System.out.println("\n");
        List<Integer> listIterations = new ArrayList<>();
        listIterations.add(0);
        listIterations.add(2);
        listIterations.add(34);
        listIterations.add(4);
        listIterations.add(56);
        iterateElementsSpecificPosition(listIterations);

        System.out.println("\n");
        int[] replaceElementWithGreatestN = {1, 3, 4, 7, 8};
        replaceElementWithGreatestNext(replaceElementWithGreatestN);

        System.out.println("\n");
        int[] numsTest1 = {1, 2, -2, 3, 4, 5, 6};
        System.out.println(findSubarraySumZero(numsTest1));

        System.out.println("\n");
        LinkedList<Integer> listRev = new LinkedList<>();
        listRev.add(0);
        listRev.add(2);
        listRev.add(34);
        listRev.add(4);
        listRev.add(56);
        reverseListIteration(listRev);

        System.out.println("\n");
        LinkedList<Integer> specifc = new LinkedList<>();
        specifc.add(0);
        specifc.add(2);
        specifc.add(34);
        specifc.add(4);
        specifc.add(56);
        specificIndexList(specifc);

        System.out.println("\n");
        int[] nums3 = {1, 2, -2, 3, 4, 5, 6};
        System.out.println("\nOriginal array: " + Arrays.toString(nums3));
        printSubarraySumZero(nums3);

        System.out.println("\n");
        int b_nums[] = {0, 1, 1, 0, 1, 1, 0, 1, 0, 0};
        System.out.println("Original array: " + Arrays.toString(b_nums));
        // Sort the binary numbers in the array.
        sortBinaryArray(b_nums);
        System.out.println("After sorting: " + Arrays.toString(b_nums));

        System.out.println("\n");
        LinkedList<Integer> specifcLastFirst = new LinkedList<>();
        specifcLastFirst.add(0);
        specifcLastFirst.add(2);
        specifcLastFirst.add(34);
        specifcLastFirst.add(4);
        specifcLastFirst.add(56);
        specificIndexListLastFirst(specifcLastFirst);

        System.out.println("\n");
        int[] A = {1, 5, 6, 7, 8, 10};
        int[] B = {2, 4, 9};
        int p = A.length;
        int q = B.length;
        // Print the original arrays.
        System.out.println("Original Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
        // Merge the sorted arrays A and B.
        merge_sorted_arrays(A, p, B, q);
        // Print the sorted arrays A and B after merging.
        System.out.println("\nSorted Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));


        System.out.println("\n");
        int[] Al = {2, 3, 5, 7, -7, 5, 8, -5};
        maxProduct(Al);

        System.out.println("\n");
        int[] shuf = {1, 2, 3, 4, 5, 6};
        shuffleArray(shuf);

        System.out.println("\n");
        LinkedList<Integer> offerF = new LinkedList<>();
        offerF.add(0);
        offerF.add(2);
        offerF.add(34);
        offerF.add(4);
        offerF.add(56);
        offerFirstMethod(offerF);

        System.out.println("\n");
        LinkedList<String> testForTwoMethods = new LinkedList<>();
        testForTwoMethods.add("Potato1");
        testForTwoMethods.add("Potato2");
        testForTwoMethods.add("Potato3");
        testForTwoMethods.add("Potato4");
        testForTwoMethods.add("Potato5");
        offerLastMethod(testForTwoMethods);
        insertSpecified(testForTwoMethods);

        System.out.println("\n");
        int[] arrangeArr = {1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14};
        printArray(rearrangeArrayWithSecondElement(arrangeArr));

        System.out.println("\n");
        int[] equiliArrTest = {-7, 1, 5, 2, -4, 3, 0};
        equilibriumArr(equiliArrTest);


        System.out.println("\n");
        LinkedList<String> floccurence = new LinkedList<>();
        floccurence.add("Potato5");
        floccurence.add("Potato14");
        floccurence.add("Potato67");
        floccurence.add("Potato666");
        floccurence.add("Potato590");
        firstAndLastOccurence(floccurence);

        System.out.println("\n");
        displayElementsAndPositions(floccurence);

        System.out.println("\n");
        int[] replacePro = {1, 2, 3, 4, 5, 6, 7};
        printArray(replaceElementWithProdOfOthers(replacePro));

        System.out.println("\n");
        LinkedList<String> listTest = new LinkedList<>();
        listTest.add("Ban");
        listTest.add("Report");
        listTest.add("Block");
        listTest.add("warning");
        removeElement(listTest);

        System.out.println("\n");
        removeFirstAndLastElement(listTest);

        System.out.println("\n");
        int[] maxDiffArr = {2, 3, 1, 7, 9, 5, 11, 3, 5};
        findMaxDifferenceInTwoElements(maxDiffArr);

        System.out.println("\n");
        int[] findSubArrLarSum = {1, 2, -3, -4, 0, 6, 7, 8, 9};
        findSubArrayWithLargerSumOfArray(findSubArrLarSum);
        System.out.println("\n");
        LinkedList<Integer> lireall = new LinkedList<>();
        lireall.add(7);
        lireall.add(8);
        lireall.add(12);
        lireall.add(567);
        removeAllElements(lireall);

        System.out.println("\n");
        LinkedList<Integer> lirealll = new LinkedList<>();
        lirealll.add(7);
        lirealll.add(8);
        lirealll.add(12);
        lirealll.add(567);
        swapElementsList(lirealll);

        System.out.println("\n");
        int[] numsTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] res = findMinSubarraySum(numsTest, 4);
        System.out.println(Arrays.toString(res));

        System.out.println("\n");
        LinkedList<Integer> shflio = new LinkedList<>();
        shflio.add(7);
        shflio.add(8);
        shflio.add(12);
        shflio.add(567);
        shuffleList(shflio);

        System.out.println("\n");
        LinkedList<Integer> joinList0 = new LinkedList<>();
        joinList0.add(7);
        joinList0.add(8);
        joinList0.add(12);
        joinList0.add(567);
        LinkedList<Integer> joinList1 = new LinkedList<>();
        joinList1.add(7);
        joinList1.add(7);
        joinList1.add(7);
        joinList1.add(0);
        joinTwoLists(joinList0, joinList1);


        System.out.println("\n");
        int[] numsLi = {1, 2, 3, 0, 4, 6};
        findLargestNumFromAListOfNonNegatives(numsLi);

        System.out.println("\n");
        LinkedList<Integer> listInitial = new LinkedList<>();
        listInitial.add(8);
        listInitial.add(8);
        listInitial.add(8);
        listInitial.add(0);
        LinkedList<Integer> listToCopy = new LinkedList<>();
        listToCopy.add(7);
        listToCopy.add(7);
        listToCopy.add(7);
        listToCopy.add(0);
        copyLists(listInitial, listToCopy);
        //or
        copyLists2(listInitial, listToCopy);

        System.out.println("\n");
        retrieveFirstElement(listInitial);

        System.out.println("\n");
        int[] conArrS = {1, 2, 3, 0, 4, 6};
        System.out.println(Arrays.toString(findUnsortedSubarray(conArrS)));

        System.out.println("\n");
        int[] cArrTwoEl = {3, 5, 6, 9, 8, 7};
        sortArrTwoElementsOutOfPlace(cArrTwoEl);

        System.out.println("\n");
        int[] tripletsSum = {1, 6, 3, 0, 8, 4, 1, 7};
        int targ = 7;
        findTripletsSumOfTarget(tripletsSum, targ);

        System.out.println("\n");
        LinkedList<Integer> test3Methods = new LinkedList<>();
        test3Methods.add(5);
        test3Methods.add(12);
        test3Methods.add(55);
        test3Methods.add(66);
        test3Methods.add(77);
        retrieveAndNotRemoveFElement(test3Methods);
        retrieveAndNotRemoveLElement(test3Methods);
        checkElementExistance(test3Methods);

        System.out.println("\n");
        int[] largestGap = {1, 2, 9, 0, 4, 6};
        findLargestGapBetweenSortedElements(largestGap);

        System.out.println("\n");
        LinkedList<Integer> convertLinked = new LinkedList<>();
        convertLinked.add(5);
        convertLinked.add(12);
        convertLinked.add(55);
        convertLinked.add(66);
        convertLinked.add(77);
        convertLinkedToArrayList(convertLinked);

        System.out.println("\n");
        LinkedList<String> compareList1 = new LinkedList<>();
        compareList1.add("Μανιτάρια");
        compareList1.add("Ντομάτες");
        compareList1.add("Πατάτες");
        compareList1.add("Φασολάκια");
        compareList1.add("Φακές");
        LinkedList<String> compareList2 = new LinkedList<>();
        compareList2.add("Μανιτάρια");
        compareList2.add("Ντομάτες");
        compareList2.add("Ψάρι");
        compareList2.add("Κοτόπουλο");
        compareList2.add("Παγωτό");
        compareLists(compareList1, compareList2);

        System.out.println("\n");
        int[] consList = {1, 2, 5, 5, 4, 3, 6};
        System.out.println(test(consList));

        System.out.println("\n");
        LinkedList<String> isEmptL = new LinkedList<>();
        isEmptL.add("Μανιτάρια");
        isEmptL.add("Ντομάτες");
        isEmptL.add("Πατάτες");
        isEmptL.add("Φασολάκια");
        isEmptL.add("Φακές");
        isEmptL.clear();
        boolean ress = checkListIsEmpty(isEmptL);
        System.out.println(ress);

        System.out.println("\n");
        LinkedList<String> repl = new LinkedList<>();
        repl.add("Μανιτάρια");
        repl.add("Ντομάτες");
        repl.add("Πατάτες");
        repl.add("Φασολάκια");
        repl.add("Φακές");
        replaceElementList(repl);

        System.out.println("\n");
        int[] negPosAlt = {1, -2, 5, -4, 3, -6};
        System.out.println(checkArrayIfAlternatesBetweensPositivesNegatives(negPosAlt));

        System.out.println("\n");
        int[] testNegDom = {1, -2, -5, -4, 3, -6};
        System.out.println("check negative Dominance: " + checkNegativeDominance(testNegDom));

        System.out.println("\n");
        String[] strArra = {"p", "r", "s", "t"};
        System.out.println(Arrays.toString(strArra));
        String result35 = findMissingLetterInConsecutiveLetters(strArra);
        System.out.printf("\nMissing letter in the said array: " + result35);

        System.out.println("\n");
        HashSet<Integer> setHashh = new HashSet<>();
        setHashh.add(67);
        setHashh.add(345);
        setHashh.add(43456);
        iterateHash(setHashh);

        System.out.println("\n");
        int[] arrSe = {23, 5, 67, 20, 3, 30, 79, 3, 70, 2};
        sortArray(arrSe);

        System.out.println("\n");
        int[] arrDe = {23, 5, 67, 20, 3, 30, 79, 3, 70, 2};
        sortArrayDesc(arrDe);

        System.out.println("\n");
        HashSet<Integer> set45 = new HashSet<>();
        set45.add(5);
        set45.add(67);
        set45.add(78);
        getHash(set45);

        System.out.println("\n");
        int[] teSum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sumOfArr(teSum);

        System.out.println("\n");
        avgOfArr(teSum);

        System.out.println("\n");
        int[] ar45 = new int[5];
        storeElemArray(ar45);

        System.out.println("\n");
        HashSet<Integer> set456 = new HashSet<>();
        set456.add(5);
        set456.add(67);
        set456.add(78);
        clearHash(set456);

        System.out.println("\n");
        int[] ar46 = new int[5];
        arrayUserInput(ar46);

        System.out.println("\n");
        int[] terSum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sumArr(terSum);

        System.out.println("\n");
        int[] rever = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        readReverse(rever);

        System.out.println("\n");
        HashSet<Integer> setEmp = new HashSet<>();
        setEmp.add(45);
        setEmp.add(456);
        checkEmptiness(setEmp);

        System.out.println("\n");
        int[] cubic = {1, 2, 3, 4, 5};
        cubicArray(cubic);

        System.out.println("\n");
        int[] maxMinim = {23, 4, 32, 5, 75};
        maxMinA(maxMinim);

        System.out.println("\n");
        HashSet<Integer> setEmp1 = new HashSet<>();
        setEmp1.add(45);
        setEmp1.add(456);
        cloneHash(setEmp1);

        System.out.println("\n");
        int[] arrayNodd = {23, 45, 67, 34, 78};
        oddNums(arrayNodd);
        evenNums(arrayNodd);
        oddSumNums(arrayNodd);
        evenSumNums(arrayNodd);

        System.out.println("\n");
        HashSet<Integer> setArr = new HashSet<>();
        setArr.add(5);
        setArr.add(67);
        setArr.add(78);
        convertHashToArr(setArr);

        System.out.println("\n");
        int[] arCu = {1, 2, 3, 4, 5};
        cubicSum(arCu);

        System.out.println("\n");
        int[] arCop = {5, 6, 7, 8, 8};
        copyArr(arCop);

        HashSet<Integer> set3 = new HashSet<>();
        set3.add(5);
        set3.add(99);
        set3.add(102);
        convertHashToTree(set3);

        System.out.println("\n");
        HashSet<Integer> set36 = new HashSet<>();
        set36.add(5);
        set36.add(6);
        set36.add(1);
        set36.add(67);
        set36.add(102);
        findLessThan7ElementsInTreeSet(set36);

        System.out.println("\n");
        HashSet<Integer> set37 = new HashSet<>();
        set37.add(5);
        set37.add(6);
        set37.add(1);
        set37.add(67);
        set37.add(102);
        compareHash(set37);

        System.out.println("\n");
        int[] test1 = {0, 1, 2, 3, 4};
        int[] test2 = {4, 5, 6, 7, 7};
        mergeIntoA3rdArray(test1, test2);

        System.out.println("\n");
        HashSet<Integer> set5678 = new HashSet<>();
        set5678.add(5);
        set5678.add(99);
        set5678.add(51);
        set5678.add(101);
        set5678.add(57);
        set5678.add(995);
        retainCommonElements(set5678);

        System.out.println("\n");
        removeAllFromHash(set5678);

        System.out.println("\n");
        int[] numTest = {-1, 4, 55, -4, 555};
        positiveNums(numTest);
        System.out.println();
        negativeNums(numTest);

        System.out.println("\n");
        int[] numSumPosNeg = {-2, 56, -3, 5, 100};
        positiveSumNums(numSumPosNeg);
        negativeSumNums(numSumPosNeg);

        System.out.println("\n");
        treeSet();
        IterTreeSet();

        System.out.println("\n");
        int[] searchLinear = {-2, 56, -3, 5, 100};
        System.out.println(searchArray(searchLinear, 56));

        System.out.println("\n");
        int[] deleteDupl = {-2, 4, 4, 5, 5};
        System.out.println(deleteDuplicates(deleteDupl, 5));

        System.out.println("\n");
        addElemeTree();

        System.out.println("\n");
        int[] arruni = {10, 20, 40, 20, 10};
        printUnique(arruni);

        System.out.println("\n");
        int[] secSm = {10, 20, 5, 2, 30};
        findSecondSmaller(secSm);
        System.out.println(findSecondSmaller2(secSm));

        System.out.println("\n");
        TreeSet<String> tSet = new TreeSet<String>();
        tSet.add("Red");
        tSet.add("Green");
        tSet.add("Black");
        tSet.add("Pink");
        tSet.add("orange");
        reverseOrderTreeSet(tSet);

        System.out.println("\n");
        TreeSet<Integer> set5678Tree = new TreeSet<>();
        set5678Tree.add(5);
        set5678Tree.add(99);
        set5678Tree.add(51);
        set5678Tree.add(101);
        set5678Tree.add(57);
        set5678Tree.add(995);
        getFirstAndLastTreeElems(set5678Tree);
        cloneTree(set5678Tree);

        System.out.println("\n");
        int[] firsta = {1, 2, 3, 4, 5};
        int[] senondb = {6, 7, 8, 9, 10};
        identifyEvenElemInTwoArrs(firsta, senondb);

        System.out.println("\n");
        int[] firstc = {1, 2, 3, 4, 5};
        int[] senondd = {6, 7, 8, 9, 10};
        identifyOddElemInTwoArrs(firstc, senondd);

        System.out.println("\n");
        int[] firstA = {10, 20, 30, 40, 50};
        int[] secondA = {10, 30, 60, 50, 70};
        findCommon(firstA, secondA);

        System.out.println("\n");
        TreeSet<Integer> set45678 = new TreeSet<>();
        set45678.add(56);
        set45678.add(99);
        sizeTree(set45678);

        System.out.println("\n");
        int[] for2nd = {6, 3, 78, 1, 5};
        System.out.println(find2ndLargest(for2nd));

        System.out.println("\n");
        int[] mis = {1, 2, 4, 5, 6, 7};
        missingNum(mis);

        System.out.println("\n");
        TreeSet<Integer> set123 = new TreeSet<>();
        set123.add(5);
        set123.add(56);
        compareTrees(set123);

        System.out.println("\n");
        int i = 0;
        int j = 0;
        int t = 0;
        int a[] = {2, 65, 23, 13, 18, 30, 46, 17, 52, 78};
        quickSort(a, 0, a.length - 1);
        System.out.println("Sorted Array in Ascending Order ..");
        i = 0;
        while (i < 10) {
            System.out.print(a[i] + " ");
            i = i + 1;
        }

        System.out.println("\n");
        int aaaPin[] = {2, 65, 23, 13, 18, 30, 46, 17, 52, 78};
        bubbleSort(aaaPin);

        System.out.println("\n");
        TreeSet<Integer> tres = new TreeSet<>();
        tres.add(88);
        tres.add(99);
        tres.add(7);
        tres.add(1);
        tres.add(4);
        elemsLessThanSeven(tres);

        System.out.println("\n");
        int[] bs = {2, 3, 4, 15, 40};
        int n = bs.length;
        int x = 15;
        int resultBs = binaryS(bs, 0, n - 1, x);
        if (resultBs == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index: " + resultBs);


        System.out.println("\n");
        TreeSet<Integer> tr = new TreeSet<>();
        tr.add(30);
        tr.add(23);
        tr.add(67);
        tr.add(46);
        ceilingElem(tr);

        System.out.println("\n");
        int[] testLinear = {3, 5, 6, 7, 99};
        System.out.println(linearS(testLinear, 99));

        System.out.println("\n");
        int[] arrZer = {1, 0, 45, 34, 0, 67, 2, 0, 6, 67, 45, 2, 0, 10};
        movingAllZeroesAtEnd(arrZer);

        System.out.println("\n");
        TreeSet<Integer> tretre = new TreeSet<>();
        tretre.add(56);
        tretre.add(89);
        tretre.add(54);
        flourElem(tretre);

        System.out.println("\n");
        int rows = 2;
        int cols = 3;
        int[][] arr2D = new int[rows][cols];
        for (i = 0; i < arr2D.length; i++) {
            for (j = 0; j < arr2D[i].length; j++) {
                arr2D[0][0] = 1;
                arr2D[0][1] = 2;
                arr2D[0][2] = 3;
                arr2D[1][0] = 4;
                arr2D[1][1] = 5;
                arr2D[1][2] = 6;
            }
        }
        print2DArr(arr2D);

        System.out.println("\n");
        TreeSet<Integer> trH = new TreeSet<>();
        trH.add(56);
        trH.add(45);
        trH.add(99);
        System.out.println(higherElem(trH));
        System.out.println(lowerElem(trH));

        System.out.println("\n");
        int[] occA = {5, 10, 10, 7, 5, 90};
        occurencesOfNumber(occA);
        occurencesOfSpecificNumber(occA, 5);

        System.out.println("\n");
        List<Integer> lOcc = new ArrayList<>();
        lOcc.add(5);
        lOcc.add(5);
        lOcc.add(5);
        lOcc.add(10);
        occOfSpecNumList(lOcc, 5);

        System.out.println("\n");
        List<Integer> lisOcc = new ArrayList<>();
        lisOcc.add(5);
        lisOcc.add(99);
        lisOcc.add(99);
        lisOcc.add(101);
        occHashMap(lisOcc);

        System.out.println("\n");
        int[] rev2 = {6, 7, 8, 9, 0};
        reverseArray2(rev2);

        System.out.println("\n");
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(99);
        set.add(4);
        pollFirst(set);

        System.out.println("\n");
        Integer[] arrI = {5, 6, 7, 8, 9};
        reverseArrUsingList(arrI);

        System.out.println("\n");
        int[] maxArr2 = {34, 5, 6, 100};
        findLargerstArrElem2(maxArr2);

        System.out.println("\n");
        TreeSet<Integer> tsTr = new TreeSet<>();
        tsTr.add(56);
        tsTr.add(6);
        tsTr.add(5);
        tsTr.add(569);
        Integer el = 5;
        pollLast(tsTr);
        removeElemeTs(tsTr, el);

        System.out.println("\n");
        List<Integer> list2 = new ArrayList<>();
        list2.add(14);
        list2.add(67);
        list2.add(89);
        findLargerstElemL(list2);

        System.out.println("\n");
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Number", 99);
        map2.put("Number", 101);
        map2.put("Number", 202);
        findLargerstElemMap(map2);

        System.out.println("\n");
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Red");
        queue.add("Yellow");
        queue.add("Green");
        System.out.println(queue);

        System.out.println("\n");
        int[] arr232 = {5, 6, 7, 8};
        averageArrays(arr232);

        List<Integer> li90 = new ArrayList<>();
        li90.add(9);
        li90.add(91);
        averageArraysL(li90);

        System.out.println("\n");
        HashMap<String, Integer> map9 = new HashMap<>();
        map9.put("num->", 9);
        map9.put("num->", 11);
        avgMap(map9);

        System.out.println("\n");
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(5);
        pq1.add(99);
        pq1.add(89);
        iterateTs(pq1);

        System.out.println("\n");
        elementWise();
        elementWishList();
        elementWiseMap();

        System.out.println("\n");
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        queue2.add(991);
        queue2.add(8);
        addPriorityQtoOtherPQ(queue2);
        insertToPq(queue2, 5);

        System.out.println("\n");
        int[] arrLarge3 = {45, 7, 8, 1};
        System.out.println(findSecondLargest(arrLarge3));

        System.out.println("\n");
        List<Integer> llll = new ArrayList<>();
        llll.add(56);
        llll.add(90);
        llll.add(101);
        llll.add(1);
        System.out.println(findSecondLrgL(llll));

        System.out.println("\n");
        int[] arrSum7 = {5, 77, 8, 1};
        sumArrayElements(arrSum7);

        System.out.println("\n");
        PriorityQueue<Integer> pqClear = new PriorityQueue<>();
        pqClear.add(6);
        pqClear.add(9);
        clearPq(pqClear);

        System.out.println("\n");
        List<Integer> l2000 = new ArrayList<>();
        l2000.add(5);
        l2000.add(6);
        sumElemList(l2000);

        System.out.println("\n");
        HashMap<String, Integer> mapSum = new HashMap<>();
        mapSum.put("Number", 5);
        mapSum.put("Number2", 6);
        sumMapElments(mapSum);

        System.out.println("\n");
        PriorityQueue<Integer> per = new PriorityQueue<>();
        per.add(1);
        per.add(2);
        countPq(per);

        System.out.println("\n");
        int[] arr111 = {1, 2, 3};
        int[] arr222 = {1, 2, 3};
        sumOfTwoArraysElementWise(arr111, arr222);

        System.out.println("\n");
        List<Integer> test12 = new ArrayList<>();
        test12.add(1);
        test12.add(2);
        List<Integer> test14 = new ArrayList<>();
        test14.add(2);
        test14.add(3);
        sumOfTwoArraysElementWiseL(test12, test14);

        System.out.println("\n");
        PriorityQueue<Integer> pq22 = new PriorityQueue<>();
        pq22.add(1);
        pq22.add(2);
        PriorityQueue<Integer> pq33 = new PriorityQueue<>();
        pq33.add(1);
        pq33.add(2);
        comparePq(pq22, pq33);

        System.out.println("\n");
        HashMap<String, Integer> mapSum1 = new HashMap<>();
        HashMap<String, Integer> mapSum2 = new HashMap<>();
        mapSum1.put("A", 10);
        mapSum1.put("B", 5); // Κοινό κλειδί
        mapSum2.put("B", 20); // Κοινό κλειδί
        mapSum2.put("C", 30);
        System.out.println(sumOfTwoArraysElementWiseM(mapSum1, mapSum2));

        System.out.println("\n");
        PriorityQueue<Integer> pqFirst = new PriorityQueue<>();
        pqFirst.add(2);
        pqFirst.add(23);
        pqFirst.add(211);
        peekFirst(pqFirst);

        System.out.println("\n");
        int[] arrAsx = {1, 2, 0, 4};
        System.out.println(isArrAsc(arrAsx));

        System.out.println("\n");
        List<Integer> lAsx = new ArrayList<>();
        lAsx.add(2);
        lAsx.add(3);
        lAsx.add(5);
        System.out.println(isArrListAsc(lAsx));

        System.out.println("\n");
        Map<Integer, Integer> unsortedKeyMap = new HashMap<>();
        unsortedKeyMap.put(30, 300);
        unsortedKeyMap.put(10, 100);
        unsortedKeyMap.put(20, 200);
        System.out.println(isArrMapValueAsc(unsortedKeyMap));
        Map<Integer, Integer> breakingMap = new TreeMap<>();
        breakingMap.put(50, 1);
        breakingMap.put(40, 2); // 50 > 40: FAIL!
        breakingMap.put(60, 3);
        System.out.println(isArrMapValueAsc(breakingMap));

        System.out.println("\n");
        PriorityQueue<Integer> pqollFirst = new PriorityQueue<>();
        pqollFirst.add(2);
        pqollFirst.add(23);
        pqollFirst.add(211);
        System.out.println(pqollFirst);
        pollFirst(pqollFirst);
        System.out.println(pqollFirst);

        System.out.println("\n");
        int[] isEarr = {2, 6, 8};
        System.out.println(isEvenArray(isEarr));

        System.out.println("\n");
        List<Integer> l2 = new ArrayList<>();
        l2.add(6);
        l2.add(7);
        System.out.println(isListEven(l2));

        System.out.println("\n");
        PriorityQueue<Integer> pqConvert = new PriorityQueue<>();
        pqConvert.add(2);
        pqConvert.add(99);
        convertPq(pqConvert);

        System.out.println("\n");
        PriorityQueue<Integer> pqConvertstr = new PriorityQueue<>();
        pqConvertstr.add(2);
        pqConvertstr.add(99);
        convertPqStr(pqConvertstr);

        System.out.println("\n");
        int n89 = 4;
        int xCostOfCoupon = 2;
        int yReduceCost = 5;
        int[] prices = {1, 5, 10, 45};
        System.out.println(checkCoupon(n89, xCostOfCoupon, yReduceCost, prices));

        System.out.println("\n");
        PriorityQueue<Integer> pwepq = new PriorityQueue<>(10, Collections.reverseOrder());
        pwepq.add(90);
        pwepq.add(98);
        pwepq.add(87);
        pwepq.add(101);
        convertPqMax(pwepq);

        System.out.println("\n");
        HashMap<Integer, Integer> mapp = new HashMap<>();
        mapp.put(1, 2);
        mapp.put(2, 4);
        hsMap(mapp);
        countKeyValMappings(mapp);

        System.out.println("\n");
        int[] arrR = {1, 2, 3, 4, 5};
        reverseOrderArr(arrR);

        System.out.println("\n");
        int[] arrEven = {22, 37, 55, 4, 1, 18};
        evenNumsInArr(arrEven);

        System.out.println("\n");
        int[] posNegArr = {-1, -90, 88, 7};
        posAndNegNums(posNegArr);

        System.out.println("\n");
        HashMap<Integer, Integer> map2000 = new HashMap<>();
        HashMap<Integer, Integer> map2001 = new HashMap<>();
        map2000.put(1, 2);
        copyMappings(map2000, map2001);

        //System.out.println("\n");
        System.out.print("Πάτα έναν αριθμό για να ξεκινήσεις: ");
        int choice = sc.nextInt();
        // 2. Η ΚΡΙΣΙΜΗ ΓΡΑΜΜΗ: Καθαρίζει το '\n' που έμεινε από το nextInt()
        sc.nextLine();
        System.out.print("Enter text: ");
        // 3. Τώρα θα σταματήσει κανονικά για να γράψεις
        String text = sc.nextLine();
        bannerMimicUnix(text);

        System.out.println("\n");
        int[] arrSb = {4, 2, 45, 1, 2};
        bubblesort(arrSb);

        System.out.println("\n");
        HashMap<Integer, Integer> map2002 = new HashMap<>();
        map2002.put(1, 2);
        removeMappings(map2002);

        System.out.println("\n");
        int[][] arr2Dim = new int[2][10];
        arr2D(arr2Dim);

        System.out.println("\n");
        char[][] ch2D = new char[20][70];
        arrChar2D(ch2D);

        System.out.println("\n");
        HashMap<Integer, Integer> mapEmpty = new HashMap<>();
        //mapEmpty.put(5,6);
        System.out.println(mapIsEmpty(mapEmpty));

        System.out.println("\n");
        int[] sort1000 = {45, 6, 34, 1};
        String[] sort10001 = {"React", "C", "Spring boot", "Java"};
        sortNumeric(sort1000);
        sortStringArr(sort10001);

        System.out.println("\n");
        HashMap<Integer, Integer> mapOneM = new HashMap<>();
        HashMap<Integer, Integer> mapOneMclone = new HashMap<>();
        mapOneM.put(2, 3);
        mapOneM.put(3, 5);
        shallowCopy(mapOneM, mapOneMclone);

        System.out.println("\n");
        int[] arrsV2 = {2, 4, 5, 6};
        sumValArr(arrsV2);
        printDashes2();

        System.out.println("\n");
        HashMap<Integer, Integer> mapKey = new HashMap<>();
        mapKey.put(1, 2);
        keyExists(mapKey);

        System.out.println("\n");
        int[] arrV2Avg = {1, 2, 3};
        arrayMeanV2(arrV2Avg);

        System.out.println("\n");
        findValueArr(arrV2Avg, 2);

        System.out.println("\n");
        System.out.println(valueExists(mapKey));

        System.out.println("\n");
        int[] arridx = {1, 2, 3};
        findidx(arridx, 2);

        System.out.println("\n");
        removeElem(arridx, 2);

        System.out.println("\n");
        int[] arridx2 = {1, 2, 3};
        int[] copidx = copyArrayV2(arridx2);
        System.out.println(Arrays.toString(copidx));

        System.out.println("\n");
        getSetViewMapEnty(mapKey);

        System.out.println("\n");
        int[] arrTest = {1, 2, 3, 4};
        insertElement(arrTest, 678);

        System.out.println("\n");
        findMinAndMax(arrTest);

        System.out.println("\n");
        getValByKeyMap(mapKey);

        System.out.println("\n");
        int[] arrR2 = {1, 2, 3, 4, 5, 6};
        reverseArr(arrR2);

        System.out.println("\n");
        int[] arrR3 = {1, 1, 23, 4, 5};
        findDupli(arrR3);

        HashMap<Integer, Integer> mapKeySetGet = new HashMap<>();
        mapKeySetGet.put(11, 22);
        mapKeySetGet.put(12, 23);
        mapKeySetGet.put(13, 24);
        getSetKeysFromMap(mapKeySetGet);

        System.out.println("\n");
        String[] arrSt1 = {"Anna", "Watson", "Lucky", "Luke"};
        String[] arrSt2 = {"Ben", "Jeniffer", "Lucky", "Bean"};
        findCommonElems(arrSt1, arrSt2);

        System.out.println("\n");
        int[] arrInt1 = {1, 2, 3, 4};
        int[] arrInt2 = {4, 3, 7, 8};
        findCommonElemsInt(arrInt1, arrInt2);

        System.out.println("\n");
        HashMap<Integer, String> mapStIn = new HashMap<>();
        mapStIn.put(1, "One");
        mapStIn.put(2, "Sec");
        mapStIn.put(3, "please");
        getCollectionsFromValues(mapStIn);

        System.out.println("\n");
        int[] arrrmd = {1, 1, 2, 3};
        removeDupl(arrrmd);

        System.out.println("\n");
        int[] arrSeV2 = {1, 7, 8, 2};
        System.out.println(findSecLarv2(arrSeV2));

        System.out.println("\n");
        TreeMap<Integer, Integer> mapTree = new TreeMap<>();
        mapTree.put(1, 2);
        mapTree.put(2, 4);
        associateValueWithKey(mapTree);

        System.out.println("\n");
        int[] arr122 = {45, 6, 7, 2, 2};
        System.out.println(findSecSmallv2(arr122));
        System.out.println(findSecSmallBubbleS(arr122));
        int[] arr125 = {45, 6, 7, 2, 2};
        int[] arr224 = {44, 5, 6, 1, 1,};
        add2Matrices(arr125, arr224);

        System.out.println("\n");
        TreeMap<Integer, Integer> mapTree1 = new TreeMap<>();
        mapTree1.put(1, 2);
        mapTree1.put(2, 4);
        copyTreeMapToAnotherTreeMap(mapTree1);

        System.out.println("\n");
        Integer[] arrAsList = {22, 3, 4, 5};
        convertArrToList(arrAsList);

        System.out.println("\n");
        List<Integer> listToArr = new ArrayList<>();
        listToArr.add(3);
        listToArr.add(90);
        listToArr.add(89);
        convertListToArr(listToArr);

        System.out.println("\n");
        TreeMap<Integer, Integer> mapSearchKey = new TreeMap<>();
        mapSearchKey.put(1, 2);
        mapSearchKey.put(3, 45);
        mapSearchKey.put(4, 1);
        searchKeyInTreeMap(mapSearchKey);

        System.out.println("\n");
        int[] arrPairS = {4, 5, 6, 7, 8};
        int specSum = 15;
        findPairSum(arrPairS, specSum);

        System.out.println("\n");
        int[] arrFirst = {1, 23, 3};
        int[] arrSecond = {1, 23, 3};
        System.out.println("Equality of arrs " + testEqualityOfArrs(arrFirst, arrSecond));

        System.out.println("\n");
        searchValueInTreeMap(mapSearchKey);

        System.out.println("\n");
        int[] arrMi = {1, 2, 4};
        int n1 = 4;
        System.out.println(findMissingN(arrMi, n1));

        System.out.println("\n");
        int[] arrFirst1 = {1, 2, 3, 4};
        int[] arrSec2 = {1, 2, 3, 5};
        int[] arrThird3 = {2, 3, 4, 5};
        findCommElement3Arrs(arrFirst1, arrSec2, arrThird3);

        System.out.println("\n");
        getAllKeysFromTree(mapSearchKey);

        System.out.println("\n");
        int[] arrZeroMv = {1, 2, 3, 4, 5, 0, 66, 5, 0, 1};
        moveZeroesOnTheRight(arrZeroMv);

        System.out.println("\n");
        findEvOddNums(arrZeroMv);

        System.out.println("\n");
        TreeMap<String, Integer> mpT = new TreeMap<>();
        mpT.put("Clear", 5);
        mpT.put("Crystal", 11);
        deleteAllElem(mpT);

        System.out.println("\n");
        int[] lasDiff = {0, 2, 3, 1, 4};
        System.out.println(larAndSmallDiff(lasDiff));

        System.out.println("\n");
        int[] avgExLAndS = {1, 2, 3, 4, 5, 6};
        avgExceptLargeAndSmallestVals(avgExLAndS);

        System.out.println("\n");
        TreeMap<Integer, Integer> sortMap = new TreeMap<>();
        sortMap.put(1, 2);
        sortMap.put(3, 45);
        sortMap.put(4, 1);
        sortTreeMapComparator(sortMap);

        System.out.println("\n");
        int[] arrZo = {9, 9, 10, 11};
        System.out.println(findNonZeroesAndOnes(arrZo));

        System.out.println("\n");
        int[] arrXo = {10, 10, 10, 2, 50};
        System.out.println(tenSum(arrXo));

        System.out.println("\n");
        getGreatestAndLeastKey(sortMap);

        System.out.println("\n");
        int[] arrSel = {1, 2, 3, 75, 65};
        System.out.println(containSpecElements(arrSel));

        System.out.println("\n");
        int[] arrDl = {1, 2, 3, 3, 4, 4, 5};
        int[] res1 = rempDupl2(arrDl);
        System.out.println(Arrays.toString(res1));

        System.out.println("\n");
        getFandLkey(sortMap);

        System.out.println("\n");
        int[] checkConsLen = {49, 1, 3, 200, 2, 4, 70, 5};
        System.out.println(consecutiveLength(checkConsLen));

        System.out.println("\n");
        int[] arrSum2L = {1, 2, 3, 4, 5};
        int targetV2 = 5;
        sumTwoElem(arrSum2L, targetV2);

        System.out.println("\n");
        TreeMap<Integer, Integer> treMv2 = new TreeMap<>();
        treMv2.put(1, 3);
        treMv2.put(2, 4);
        treMv2.put(5, 7);
        treMv2.put(7, 9);
        reverseViewOfMapKeys(treMv2);

        System.out.println("\n");
        int[] nmMatch = {1, -2, 0, 5, -1, -4};
        int target2 = 2;
        uniqueTripletsSum(nmMatch, target2);

        System.out.println("\n");
        int[][] matrix = {
                {1, 2, 5, 6, 7},
                {3, 4, 5, 6, 7},
                {11, 2, 3, 1, 2}
        };
        antiDiagonals(matrix);

        System.out.println("\n");
        getMapFloorKey(treMv2);

        System.out.println("\n");
        int[] arrMaj = {1, 2, 1, 2, 2, 2, 1, 2};
        majorityOfDuplicates(arrMaj);

        System.out.println("\n");
        int[] leader = {16, 17, 4, 3, 5, 2};
        printLeaders(leader);

        System.out.println("\n");
        getFloorKey(treMv2);

        System.out.println("\n");
        int[] arrTest40 = {34, 5, 6, 2, 3, 2, 0, 9};
        findSumClosestToZero(arrTest40);
        smallestAnd2ndSmallest(arrTest40);

        System.out.println("\n");
        getHeadMapWithKeysLessThanGivenKey(treMv2);

        System.out.println("\n");
        int[] arrSegg01 = {1, 0, 1, 0, 0, 1, 0, 1};
        seggregateZerosAndOnesv3(arrSegg01);

        System.out.println("\n");
        int[] s4elem = {1, 2, 3, 4, 5, 6, 8};
        find4ElemsForSumv2(s4elem, 10);

        System.out.println("\n");
        getHeadMapWithOptionalInclusiveKey(treMv2);

        System.out.println("\n");
        int[] arrTriangle = {1, 2, 3, 4, 5};
        possibleTriangles(arrTriangle);
        possibleTrianglesv2(arrTriangle);

        System.out.println("\n");
        int[] arrCy = {3, 4, 5, 6, 7, 8};
        cyclicallyRotate(arrCy);

        System.out.println("\n");
        getHigherKeyTreeMap(treMv2);

        System.out.println("\n");
        int[] arrCh = {1, 2, 4, 5, 6, 10, 11};
        checkPair(arrCh, 9);

        System.out.println("\n");
        System.out.println("Ο πίνακας περιστράφηκε: " + findRotationCount(arrCh) + " φορες");

        System.out.println("\n");
        getLowerKeyTreeMap(treMv2);

        System.out.println("\n");
        getNavigableSetViewKeys(treMv2);

        System.out.println("\n");
        int[] arrTestNegPos = {3, 55, 6, -1, 3, -7};
        int[] arrTestPosNeg = {-2, -34, 56, -4, -66};
        arrangeNegativeBeforePositivesv2(arrTestNegPos);
        arrangePositiveBeforeNegativesv2(arrTestPosNeg);

        System.out.println("\n");
        pollFirstEntry(treMv2);

        System.out.println("\n");
        int[] arrMinAndArr = {1, 56, 7, 78, 1};
        int[] zerOne = {1, 1, 0, 0, 0, 1, 1, 0};
        arrange0and1v2(zerOne);
        int[] testArraki = arrangeMaxAndMinInOrderOneByOne(arrMinAndArr);
        System.out.println(Arrays.toString(testArraki));

        System.out.println("\n");
        pollLastEntry(treMv2);

        System.out.println("\n");
        int[] evenOddsFirstSecond = {1, 3, 2, 4, 5};
        arrangeEvenAndOdds(evenOddsFirstSecond);

        System.out.println("\n");
        getSubMapFromKeyToExclusiveKey(treMv2);

        System.out.println("\n");
        int[] arrGreRightEl = {5, 1, 3, 2, 7, 11};
        replaceWithRightGreatestElement(arrGreRightEl);

        System.out.println("\n");
        getSubMapFromKeyToKey(treMv2);

        System.out.println("\n");
        getTailMapFromInclusiveKey(treMv2);

        System.out.println("\n");
        int[] arrPairS2 = {10, 10, 25, 50};
        findPairSumv2(arrPairS2, 20);
        findParSv2(arrPairS2, 20);

        System.out.println("\n");
        getTailMapFromExclusiveKey(treMv2);

        System.out.println("\n");
        int[] arrSumZero = {1, 1, 1}; //ΑΥΤΟ ΠΧ θα επιστρεψει false
        System.out.println(findSubarraryWith0Sum(arrSumZero));

        System.out.println("\n");
        getMappingWithCeilingKey(treMv2);

        System.out.println("\n");
        int[] arrBinaryTest = {1, 0, 1, 1, 0, 1, 1, 0};
        sortBinaryArrInLinearTimev2(arrBinaryTest);

        System.out.println("\n");
        getCeilingWithTreeMap(treMv2);

        System.out.println("\n");
        int[] arrTM = {5, 6, -5, 5, 3, 5, 3, -2, 0};
        findMaxLengthSubArrayHavingGivenSum(arrTM, 8);

        System.out.println("\n");
        int[] arrTt = {0, 0, 1, 0, 1, 0, 0};
        findMaxSubArrHavingAnEqualNumberTo0or1(arrTt);

        System.out.println("\n");
        List<Integer> listEven = new ArrayList<>();
        evenNumsList(listEven);

        System.out.println("\n");
        int[] arrProdMax = {4, 55, 6, 66, 1};
        findMaxProductOf2Integers(arrProdMax);

        System.out.println("\n");
        System.out.println(factorialWithList(5));

        System.out.println("\n");
        int[] sor0120 = {2, 0, 1, 2, 1, 0};
        sort012(sor0120);

        System.out.println("\n");
        compareNums();

        System.out.println("\n");
        int[] xx = {1, 5, 9, 0, 0, 0}; // 3 στοιχεία, 3 κενά
        int[] y = {2, 4, 8};
        mergeTwoArrsGivenConstraints(xx, y, 3, 3);
        System.out.println(Arrays.toString(xx));

        System.out.println("\n");
        int[] findEq = {-7, 1, 5, 2, -4, 3, 0};
        findEquilibriumArr(findEq);

        System.out.println("\n");
        System.out.println(leapYear(2014));

        System.out.println("\n");
        int[] arrBoyer = {2, 2, 2, 1, 2};
        boyerMooreMajority(arrBoyer);

        System.out.println("\n");
        int[] zeroesMove = {0, 5, 0, 6, 7, 8, 9};
        moveAllZeroesAtTheEnd(zeroesMove);

        System.out.println("\n");
        fibonacciSeries(10);

        System.out.println("\n");
        int[] kadaneArr = {-2, 1, -3, 4};
        maxSumSubArrayProblem(kadaneArr);

        System.out.println("\n");
        int[] oneSwap = {3, 8, 7, 6, 10};
        sortArrInOneSwapWithTwoElemsSwapped(oneSwap);

        System.out.println("\n");
        int num = 12321;
        System.out.println(isPalindrome(num));
        System.out.println(isPalindromev2(num));

        System.out.println("\n");
        Set<Integer> setTest = new HashSet<>();
        set.add(-5);
        set.add(-4);
        set.add(1);
        maxSubset(setTest);

        System.out.println("\n");
        int[] arrFindDiffK = {1, 5, 3};
        int k = 2;
        findDiffKv2(arrFindDiffK, k);

        System.out.println("\n");
        generatePrimeNumsBetween1AndGivenNum(20);

        System.out.println("\n");
        int[] arrTy = {3, 9, 9, 6};
        minDistV2(arrTy, 3, 6);

        System.out.println("\n");
        pyramidOfStars();

        System.out.println("\n");
        pyramidStarsNestedFors();

        System.out.println("\n");
        int[] arrTy2 = {1, 5, 8, 9};
        find2NumsWithMaxSumFormedByArrayDigits(arrTy2);

        System.out.println("\n");
        pyramidStarsReversed();

        System.out.println("\n");
        int[] arrMinIds = {5, 8, 5, 8};
        System.out.println(findMinIndexOfRepeatingElement(arrMinIds));

        System.out.println("\n");
        nestedSwitchTest();

        System.out.println("\n");
        int[] minPairAbs = {5, 6, 4, 1, 2, 6};
        findPairWithMinAbsSumInArr(minPairAbs);

        System.out.println("\n");
        int[] arrOccIdx = {1, 2, 3, 3, 3, 4};
        findIdxOfMaximumOccuringElemWithEqualProb(arrOccIdx);

        System.out.println("\n");
        int[] arr1Test1 = {1, 2, 3, 4};
        int[] arr2Test2 = {2, 3, 4, 5};
        add2ArraysToAnewArr(arr1Test1, arr2Test2);

        System.out.println("\n");
        printPattern(6);
        printSimplePyramidNums(6);

        System.out.println("\n");
        int[] arrSumEq = {1, 2, 3, 1, 2, 3};
        System.out.println(isIndexDividesArrayIntoTwoNonEmptySubArraysWithEqualSum(arrSumEq));

        System.out.println("\n");
        int[] arrrminMaxAgain = {1, 23, 4, 5};
        findMinAndMax2(arrrminMaxAgain);

        System.out.println("\n");
        int[] arrTe8 = {1, 2, 3, 4, 5, 6, 6};
        findDuplicatesInkRange(arrTe8, 10);

        System.out.println("\n");
        readInputsSmallerLargestVals();

        System.out.println("\n");
        int[] testArr111 = {1, 2, 3, 44};
        System.out.println(findIdxOfElementSatisfiesGivenConstraintsv2(testArr111));

        System.out.println("\n");
        int[] arrRotateAll = {1, 2, 3, 4, 5};
        rotateArrAll(arrRotateAll);

        System.out.println("\n");
        int[] leftRotate = {1, 2, 3, 4, 5};
        leftRotatedArr(leftRotate);

        System.out.println("\n");
        int[] rightRotate = {1, 2, 3, 4, 5};
        rightRotatedArr(rightRotate, 3);

        System.out.println("\n");
        gradesMessage("A");

        System.out.println("\n");
        randomGeneratedNums();

        System.out.println("\n");
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(8, 9));
        activities.add(new Activity(5, 9));
        List<Activity> selectedActivities = selectActivities(activities);
        for (Activity activity : selectedActivities) {
            System.out.println("Selected activity: Start = " + activity.getStartTime() + ", End = " + activity.getEndTime());
        }

        System.out.println("\n");
        int digits = 15;
        sumProdOfSigits(digits);

        System.out.println("\n");
        int[] arrTriplCaramel = {5, 3, 4, 2, 1};
        System.out.println(countTripletsFormInversionArr(arrTriplCaramel)); //O(n^3)

        System.out.println("\n");
        //sumAllIntegersDivisibleBy7InRange();

        int[] arrTriT = {12, -7, -3, 4, -1, 0, 5, -6};
        System.out.println("Before segregation:");
        segregateInLinearTime(arrTriT);
        System.out.println("After segregation: " + Arrays.toString(arrTriT));

        System.out.println("\n");
        concatString("Hello PL/SQL and Java and Spring and SOAP and REST");

        System.out.println("\n");
        int[] arrSeenElem = {5, 5, 6, 7, 1};
        findDuplicatesInLimitedRangeArray(arrSeenElem);

        System.out.println("\n");
//        System.out.println("Enter a number to display its multiplication table:");
//        int numTable = sc.nextInt();
//        System.out.println("Multiplication table for " + numTable + ":");
//        for(i = 1; i <= 10; i++){
//            System.out.println(numTable + " x " + i + " = " + (numTable * i)   );
//        }

        System.out.println("\n");
        int[] arrToBeSwapped = {1, 2, 3, 4, 5};
        swapValues(arrToBeSwapped);
        System.out.println(Arrays.toString(arrToBeSwapped));

        System.out.println("\n");
        convertDaysIntoMonths();

        System.out.println("\n");
        int[] countingSArr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array: " + Arrays.toString(countingSArr));
        countingSort(countingSArr);

        System.out.println("\n");
        printInvertTriangle();
        printInvertTrv2();

        System.out.println("\n");
        int[] arrQuickSortPartition = {3, -2, -1, 5, 0, -3, 2, 1};
        int partitionIndex = partition(arrQuickSortPartition);
        System.out.println("Partition index: " + partitionIndex);
        System.out.println("Partitioned array: ");
        for (int num1 : arrQuickSortPartition) {
            System.out.print(num1 + " ");
        }

        System.out.println("\n");
        System.out.println(isArmstrong(153));

        System.out.println("\n");
        int[][] a2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        inPlaceRotateMatrixBy90DegreesClockWise(a2D);
        printMatrix(a2D);

        System.out.println("\n");
        int[][] a2D2 = {
                {-3, -2, -1},
                {-2, -1, 0},
                {1, 2, 3}
        };
        System.out.println(countNegativeElementsPresentInSortedMatrixInLinearT(a2D2));

        System.out.println("\n");
        harmonicSeries();

        System.out.println("\n");
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {6, 5, 1, 2},
                {7, 6, 5, 1}
        };
        if (toepLitz(matrix)) {
            System.out.println("The matrix is a Toeplitz matrix.");
        } else {
            System.out.println("The matrix is not a Toeplitz matrix.");
        }
        printMatrix(matrix2);

        System.out.println("\n");
        int[] conOddEven = {2, 4, 6, 1, 3, 5, 8, 10};
        averageConsecutiveOddsEvenNums(conOddEven);

        System.out.println("\n");
        pascalTriangle(5);

        System.out.println("\n");
        displayTrianglePatternt(10);

        System.out.println("\n");
        String s45 = "Hey";
        String s56 = "Tim";
        System.out.println(checkStringsCanCircularlyRotating(s45, s56));

        System.out.println("\n");
        System.out.println("Excel columns to which Number is: " + titleToNumber("AB"));

        System.out.println("\n");
        String[] arrStr = {"ab", "cd"};
        int[] indexes = new int[arrStr.length]; // Αρχικοί δείκτες στο 0
        findAllInterLeavingOfGivenStrings(arrStr, indexes, "");

        System.out.println("\n");
        removeOccurencesOfABandCInAString("XABYCZAB");

        System.out.println("\n");
        runLengthCompressionAlgoright("AAAABBBCCDAA");

        System.out.println("\n");
        System.out.println(isPalindromev3("noon"));

        System.out.println("\n");
        String roman = "MCMIV";
        int number = convertRomanToInt(roman);
        System.out.println("Roman " + roman + " = " + number);

        System.out.println("\n");
        removeAdjacentDuplCharactersFromAString("aabbccadf");

        System.out.println("\n");
        System.out.println(determineStringIsSubsequenceOfAnotherString("abc", "ahbgdc")); // true
        System.out.println(determineStringIsSubsequenceOfAnotherString("axc", "ahbgdc")); // false

        System.out.println("\n");
        System.out.println(reverseString("geeks for geeks"));
        System.out.println(reverseStringRecursive("geeks for geeks"));

        System.out.println("\n");
        String ban = "banana";
        System.out.println(checkAStringForRepeatedSubstring(ban));

        System.out.println("\n");
        String st1 = "abcdef";
        String st2 = "def";
        findDifferenceBetweenTwoStrings(st1, st2);

        System.out.println("\n");
        String str111 = "listen";
        String str222 = "silent";
        System.out.println(isAnagramOrNot(str111, str222));

        System.out.println("\n");
        int[] arr2026 = {1, 44, 55, 222, 333, 4, 555};
        findElementsInArrayThatAreGreaterThanAllElemsToTheirRight(arr2026);

        System.out.println("\n");
        String moon = "moon";
        System.out.println(reverseStrWithoutRecursion(moon));
        System.out.println(reverseStrWithRecursion(moon));

        System.out.println("\n");
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = newNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//
//        System.out.println("Level order traversal:");
//        levelOrderTraversal(root);

        System.out.println("\n");
        int[] arrTeLf = {1, 2, 1, 3, 4, 5, 6, 7, 7, 8, 7};
        findFirstLastOccurrenceOfANumberInSortedArrV2(arrTeLf, 7);

        System.out.println("\n");
        int[] arrBin1s = {0, 0, 0, 1, 1, 1, 1};
        System.out.println(find1sInBinarySortedArr(arrBin1s));

        System.out.println("\n");
        System.out.println(powerFunc(2, 3));

        System.out.println("\n");
        int[] test1Arr = {1, 2, 3, 4, 5, 6, 7};
        int target22 = 4;
        int floor = findFloor(test1Arr, 0, test1Arr.length - 1, target22, Integer.MIN_VALUE);
        int ceil = findCeil(test1Arr, 0, test1Arr.length - 1, target22, Integer.MAX_VALUE);
        System.out.println("Floor: " + (floor == Integer.MIN_VALUE ? "No floor" : floor));
        System.out.println("Ceil: " + (ceil == Integer.MAX_VALUE ? "No ceil" : ceil));

        System.out.println("\n");
        int[] arrDuplS = {1, 1, 2, 3, 4, 4, 5, 5, 6};
        findFreqOfEachElementInSortedArrContainDupl(arrDuplS);

        System.out.println("\n");
        int[] arrBF = {0, 4, 8, 9, 15, 16, 25, 26};
        int sqrt = findSqRootOfNumUsingBinS(25);
        System.out.println(sqrt);

        System.out.println("\n");
        String[] arrStry = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(lcpProb(arrStry));

        System.out.println("\n");
        int[] arrExp = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(expSearch(arrExp, 5));

        System.out.println("\n");
        int[] arra = {2, 5, 7, 10, 14, 18, 23, 31, 44};
        ArrayReader r = new ArrayReader(arra);

        System.out.println(unboundedBinarySearch(r, 14)); // 4
        System.out.println(unboundedBinarySearch(r, 6));  // -1
        System.out.println(unboundedBinarySearch(r, 44)); // 8

        System.out.println("\n");
        int[] aefinter = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target222 = 70;

        int idx = interpolationSearch(aefinter, target222);
        System.out.println("Index: " + idx); // 6

        System.out.println("\n Recursive fib Programming");
        System.out.println(fibv22(10));
        System.out.println(fibMemoMap(10));

        System.out.println("\n");
        int M = 3, N = 3;
        int[][] matrix3 = new int[M][N]; // αν έχει εμπόδια π.χ. νέο πίνακα
        System.out.println("Total paths: " + countPaths(matrix3));

        System.out.println("\n");
        int n3 = 3;
        List<String> ans = generate(n3);
        for (String s : ans) System.out.println(s);

        System.out.println("\n");
        int[] x1 = {5, 3, 4, 6, 3};
        int[] y2 = {8, 4, 3, 5, 10};
        System.out.println(finMaxProfitCanBeEarnedByConditionallySellingStocks(x1, y2, x1.length - 1));

        System.out.println("\n");
        int n11 = 11;
        System.out.println(fibV4(n11)); //recursive
        System.out.println(fibIterative(n11)); //iterative

        System.out.println("\n");
        int[] arr3454 = {1, 3, 2, 4, 3, 5};
        longestAlternatingSubarrayProb(arr3454);
        // Output: Longest alternating subarray length is: 6

        int n56 = 6;
        List<List<Integer>> graph = new ArrayList<>();
        int[] arrival = new int[n56];
        int[] departure = new int[n56];
        boolean[] visited = new boolean[n56];
        for (int i56 = 0; i56 < n56; i56++) {
            graph.add(new ArrayList<>());
        }
        // Παράδειγμα συνδέσεων (edges)
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(2).add(5);
        graph.get(5).add(2);
        for (int i56 = 0; i56 < n; i56++) {
            if (!visited[i56]) {
                getArrivalAndDepartureTimeOfVerticesDFS(graph, i56, visited, arrival, departure);
            }
        }
        //print the time
        for (int i56 = 0; i56 < n; i56++) {
            System.out.println("Vertex " + i56 + ": Arrival " + arrival[i56] + ", Departure " + departure[i56]);
        }

        System.out.println("\n");
        int[][] cost = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        boolean[][] reach = transitiveClosureOfGraphFloydWarshall(cost, cost.length);
        printReach(reach);

        System.out.println("\n");
        int n67 = 5;
        List<List<Integer>> g = new ArrayList<>();
        for (int i3 = 0; i3 < n67; i3++) g.add(new ArrayList<>());
        // Παράδειγμα directed edges
        // 0->1, 1->2, 2->0 (κύκλος)
        g.get(0).add(1);
        g.get(1).add(2);
        g.get(2).add(0);
        // 2->3, 3->4, 4->2 (δεύτερος κύκλος που συνδέεται με τον πρώτο μέσω 2)
        g.get(2).add(3);
        g.get(3).add(4);
        g.get(4).add(2);
        System.out.println(isGraphStronglyConnected(g, n67)); // true

        System.out.println("Thank you");

        System.out.println("\n");
        int n677 = sc.nextInt();

        long[][] dist = new long[n677][n677];

        // Input: weights matrix, -1 means no edge (except diagonal)
        for (int i677 = 0; i677 < n677; i677++) {
            for (int j67 = 0; j67 < n677; j67++) {
                long w = sc.nextLong();
                if (i677 == j67) dist[i677][j67] = 0;
                else if (w == -1) dist[i677][j67] = INF;
                else dist[i677][j67] = w;
            }
        }

        floydWarshall(dist);

        // Print result: use -1 for unreachable
        for (int i677 = 0; i677 < n677; i677++) {
            for (int j67 = 0; j67 < n677; j67++) {
                if (dist[i677][j67] >= INF / 2) System.out.print(-1);
                else System.out.print(dist[i677][j67]);
                if (j67 + 1 < n677) System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("-".repeat(150));
        List<String[]> tickets = List.of(
                new String[]{"SFO", "LAX"},
                new String[]{"JFK", "SFO"},
                new String[]{"LAX", "SEA"}
        );

        System.out.println(findItenaryFromListOfDepartAndArrivalAirports(tickets)); // [JFK, SFO, LAX, SEA]

        String separator = "-".repeat(150);
        System.out.println(separator);
        int[] a56 = { 50, 30, 40, 10, 5, 20, 35 }; // max-heap example
        convertMaxToMinHeap(a56);
        System.out.println(Arrays.toString(a56));

        System.out.println(separator);
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCostToConnect(ropes)); // 29

        System.out.println(separator);
        int[] arr3000 = {20, 15, 26, 2, 98, 6};
        System.out.println(Arrays.toString(replaceRank(arr3000))); // [4, 3, 5, 1, 6, 2]

        int[] arr2500 = {100, 100, 50, 50, 50, 200};
        System.out.println(Arrays.toString(replaceRank(arr2500))); // [2, 2, 1, 1, 1, 3]

        System.out.println(separator);
        int[] keys = {1, 2, 3, 4};
        // points to the head node of the linked list
        Node head = null;
        // construct a linked list
        for (int i555 = keys.length - 1; i555 >= 0; i555--) {
            head = new Node(keys[i555], head);
        }
        // copy linked list
        Node copy = copyList(head);
        // print duplicate linked list
        printList(copy);
        System.out.println(separator);
        LinkedList<String> str = new LinkedList<>(List.of("Hello", "World", "Java", "Programming"));
        LinkedList<String> copStr = cloneLinkedList(str);
        System.out.println("Original LinkedList: " + str);
        System.out.println("Cloned LinkedList: " + copStr);

    }


    public static String eliminateAWord(String words) {
        if (words == null || words.isEmpty()) {
            return words;
        }
        int lastSpaceIndex = words.lastIndexOf(' ');
        if (lastSpaceIndex == -1) {
            return "";
        } else {
            return words.substring(0, lastSpaceIndex).trim();
        }
    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void printDashes() {
        final int GRID_SIZE = 10;

        char[][] grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '-';
            }
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean containsValue(int[] arr, int item) {
        for (int i : arr) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> checkIndex(int[] arr, int item) {
        List<Integer> indexes = new ArrayList<>();
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                indexes.add(i);
            }

        }
        return indexes;
    }

    public static int[] removeElement(int[] arr, int item) {
        // 1. Βρίσκουμε τον δείκτη του στοιχείου
        int indexToRemove = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                indexToRemove = i;
                break; // Βρήκαμε την πρώτη εμφάνιση, σταματάμε
            }
        }

        // Αν το στοιχείο δεν βρέθηκε, επιστρέφουμε τον αρχικό πίνακα
        if (indexToRemove == -1) {
            System.out.println("Item " + item + " not found. Returning original array.");
            return arr;
        }

        // 2. Δημιουργούμε έναν νέο πίνακα με μέγεθος -1
        int[] newArr = new int[arr.length - 1];
        int newArrIndex = 0;

        // 3. Αντιγράφουμε τα στοιχεία
        for (int i = 0; i < arr.length; i++) {
            // Αν ο τρέχων δείκτης ΔΕΝ είναι ο δείκτης προς αφαίρεση
            if (i != indexToRemove) {
                newArr[newArrIndex] = arr[i];
                newArrIndex++;
            }
            // Αν ο i είναι ο indexToRemove, απλώς τον παραλείπουμε.
        }

        // ΕΚΤΥΠΩΣΗ του νέου πίνακα (όπως ζητήθηκε)
        System.out.print("Removed item " + item + " at index " + indexToRemove + ". New array: ");
        printArray(newArr);

        return newArr;
    }

    private static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("}");
    }

    public static List<Integer> removeWithList(Integer[] arr, Integer item) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(arr));
        myList.remove(item);
        return myList;
    }


    public static void copyArrayByIteration(int[] arr1, int[] arr2) {
        // ΠΡΟΣΟΧΗ: Θα αντιγράψει μόνο μέχρι το μήκος του μικρότερου πίνακα.
        // Για σωστή αντιγραφή, οι πίνακες πρέπει να έχουν το ίδιο μήκος.
        int copyLength = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < copyLength; i++) {
            // Η αντιγραφή είναι απλή αντιστοίχιση: θέση i σε θέση i
            arr2[i] = arr1[i];
        }
        System.out.print("Array copied successfully. Destination array is now: ");
        printArray(arr2);
    }

    public static List<Integer> insertElement(Integer[] arr, Integer item, int index) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        if (index < 0 || index >= list.size()) {
            System.err.println("Error: Index " + index + " is out of bounds for insertion (size is " + list.size() + "). Returning original list.");
            return list;
        }
        list.add(index, item);
        System.out.println("Inserted " + item + " at index " + index + ". New List size: " + list.size());
        return list;
    }

    public static void iterateList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    public static int[] findMinMax(int[] arr) {
        // Έλεγχος για κενό ή null πίνακα
        if (arr == null || arr.length == 0) {
            return null;
        }
        // Αρχικοποίηση min και max με το πρώτο στοιχείο
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            // Έλεγχος για μέγιστη τιμή
            if (current > max) {
                max = current;
            }

            // Έλεγχος για ελάχιστη τιμή
            if (current < min) { // Χρησιμοποιεί ξεχωριστό IF, το οποίο είναι ελαφρώς πιο ασφαλές
                min = current;
            }
        }
        return new int[]{max, min};
    }

    public static void reverseArray(int[] arr) {

        int start = 0; //2 Pointers approach
        int end = arr.length - 1;
        for (start = 0; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void findDuplicates(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && (i != j)) {
                    System.out.println("Duplicate element: " + arr[j]);
                }
            }
        }
    }

    public static void equalsArrays(int[] arr1, int[] arr2) {
        boolean equalsOrNot = true;
//        if(Arrays.equals(arr1, arr2)){
//            System.out.println("Arrays are equal: " + "\n");
//        }else{
//            System.out.println("Arrays are not equal");
//        }
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    equalsOrNot = false;
                }
            }
        } else {
            equalsOrNot = false;
        }

        if (equalsOrNot) {
            System.out.println("Arrays are equal ");
        } else {
            System.out.println("Arrays r not equal! ");
        }

        System.out.println("Arrays1:" + Arrays.toString(arr1));
        System.out.println("Arrays2:" + Arrays.toString(arr2));
    }

    public static void insertToList(List<Integer> list) {
        list.remove(1);
        list.add(1, 5);
    }

    public static void commonElements(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println(arr2[j]);
                }

            }
        }
    }

    public static void retrieveElement(List<Integer> list) {
        list.add(5);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(2000);

        Integer retrieveElement = list.get(0);
        System.out.println(retrieveElement);

        list.set(0, 191);
        System.out.println(list);

    }

    public static int[] removeDuplicates(int[] arr) {

        int no_unique_elements = arr.length;
        for (int i = 0; i < no_unique_elements; i++) {
            for (int j = i + 1; j < no_unique_elements; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = arr[no_unique_elements - 1];
                    no_unique_elements--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(arr, no_unique_elements);
    }

    public static void secondLargerst(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr[arr.length - 2]);
    }

    public static int secondLargest2(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Ο πίνακας πρεπει να εχει τουλαχιστον 2 στοιχεία");
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > largest) {
                secondLargest = largest;
                largest = secondLargest;
            } else if (element > secondLargest && element != largest) {
                secondLargest = element;
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void secondSmallest(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr[1]);
    }

    public static int[] addTwoArrays(int[] arr, int[] arr2) {
        int[] sumArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sumArray[i] = arr[i] + arr2[i];
        }
        return sumArray;
    }

    public static List<Integer> converstArrayToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void convertListToArray(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        for (int element : arr) {
            System.out.print("\t" + element);
        }
    }

    public static void findPairsSum(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == item) {
                    System.out.println(arr[i] + " and " + arr[j]);
                }
            }
        }
    }

    public static void removeThirdElement(List<Integer> list) {
        list.add(5);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(2000);

        list.remove(2);
        System.out.println(list);
    }

    public static void searchElement(List<Integer> list, Integer item) {
        list.add(5);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(2000);
        for (Integer element : list) {
            if (element.equals(item)) {
                System.out.println(item);
            }
        }
    }

    public static void sort(List<Integer> list) {
        list.add(5);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(2000);
        list.sort(null);
        System.out.println(list);
    }

    public static void sortLamba(List<Integer> list) {
        list.add(5);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(2000);
        list.sort((a, b) -> Integer.compare(a, b));
        System.out.println(list);
    }

    public static void shuffleList(List<String> list) {
        System.out.println("Before shuffling my list: " + list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    public static void testEqualArrays(int[] arr1, int[] arr2) {
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    public static void findMissingNumber(int[] arr) {
        int total_num = 7;
        //arithmetic sum formula
        int expected_num_sum = total_num * ((total_num + 1) / 2);
        int num_sum = 0;
        for (int i : arr) {
            // Add each element to the 'num_sum' variable.
            num_sum += i;
        }
        System.out.print(expected_num_sum - num_sum);
    }

    public static void commonElementsInThreeArrays(int[] arr1, int[] arr2, int[] arr3) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr3.length; k++) {
                    if (arr1[i] == arr2[j] && arr1[i] == arr3[k] && arr2[j] == arr1[i] && arr2[j] == arr3[k] && arr3[k] == arr1[i] && arr3[k] == arr2[j]) {
                        System.out.println(arr3[k]);
                    }
                }
            }
        }
    }

    public static void reverseList(List<Integer> list) {
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }


    public static void moveAllZeroes(int[] arr) {
//      int[] ar2344 = {0,0,1,3,0,2,0,4};
        int i = 0;
        System.out.print("\nOriginal array: \n");
        for (int j = 0, l = arr.length; j < l; ) {
            if (arr[j] == 0)
                j++;
            else {
                // Swap the non-zero element with the first available zero.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        // Fill the remaining positions with zeros.
        while (i < arr.length)
            arr[i++] = 0;

        // Print the array after moving zeros to the end.
        System.out.print("\nAfter moving 0's to the end of the array: \n");
        for (int n : arr)
            System.out.print(n + "  ");
        System.out.print("\n");
    }

    public static void countEvenOrOddNumbers(int[] arr) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sumEven++;

            } else if (arr[i] % 2 != 0) {
                sumOdd++;

            }
        }
        System.out.println(sumEven);
        System.out.println(sumOdd);
    }


    public static void subList(List<Integer> list) {
        System.out.println("Original list: " + list);
        System.out.println();
        List<Integer> subl = list.subList(1, 3);  //στην sublist δεν συμπεριλαμβανεται το toIndex (δηλαδη εδω το 67 αρα θα ειναι 5,3)
        System.out.println("Sublist:" + subl);
    }

    public static void maxMinValuesDifference(int[] arr) {
        if (arr.length < 1) {
            System.out.println("Array's length should be at least 1: ");
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Difference of largerst and smallert value in the array is: " + (max - min));
    }

    public static void excludeMinMaxAvg(int[] arr) {
        if (arr.length < 1) {
            System.out.println("Array's length should be at least 1: ");
        }
        int max = arr[0];
        int min = arr[0];
        int avg = arr[0];
        int sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }

            sum = sum + arr[i];
            avg = (sum - max - min) / (arr.length - 2);
        }
        System.out.println("Average of the array with exclusion of max and min value is: " + avg);
    }
    //{2,45,6,88,22,3} = avg --> 19

    public static void compareTwoLists(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> l3 = new ArrayList<>();
        for (Integer num : l1) {
            l3.add(l2.contains(num) ? 1 : 0);
        }
        System.out.println("Lists are equal (1) or not (0) --> " + l3);
    }

    public static void swapList(List<Integer> list) {
        System.out.println(list);
        Collections.swap(list, 0, 3);
        System.out.println(list);
    }

    public static void excludeZeroesAndMinusOnes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 || arr[i] == -1) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }

    public static void checkForZeroesAndOnes(int[] arr) {
        boolean notFound = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 || arr[i] == -1) {
                notFound = false;
            }
        }
        System.out.println("0 and -1 is not found: " + notFound);
    }


    public static void checkSumOfTensEqualsThirty(int[] arr) {
        boolean equal = false;
        int sum = 0;
        int count10 = 0;
        int howMuch10s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 10) {
                howMuch10s++;
                count10 = arr[i];
                sum += count10;
                if (sum == 30) {
                    equal = true;
                }
            }
        }
        System.out.println("10s are: " + howMuch10s);
        System.out.println("Sum equals: " + sum);
        System.out.println("10s in the array has exactly the sum of 30: " + equal);
    }

    public static void checkSixtyFiveAndSeventyFive(int[] arr, int item1, int item2) {
        boolean found = true;
        for (int num : arr) {
            boolean r = num != item1 && num != item2;
            if (r) {
                found = false;
            }
        }
        System.out.println(found);
    }

    public static int removeDuplicatesArray(int[] nums) {
        int index = 1;
        // Iterate through the array, starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is different from the previous element.
            if (nums[i] != nums[index - 1])
                // If different, update the element at the current index.
                nums[index++] = nums[i];
        }
        // Return the new length of the array.
        return index;
    }

    public static void joinLists(List<Integer> l1, List<Integer> l2) {
        System.out.println("Origianal lists--> l1: " + l1 + " l2: " + l2);
        List<Integer> concatenatedList = new ArrayList<>();
        concatenatedList.addAll(l1);
        concatenatedList.addAll(l2);
        System.out.println(concatenatedList);
    }


    public static int findLongestConsecutiveSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            // Αγνοούμε τα διπλότυπα
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Έλεγχος για διαδοχικό αριθμό
            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                // Η ακολουθία έσπασε, αποθηκεύουμε το max και κάνουμε reset
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }

        // Τελικός έλεγχος για την τελευταία ακολουθία
        return Math.max(longestStreak, currentStreak);
    }
//Sample array: [49, 1, 3, 200, 2, 4, 70, 5]
    //()->  [1, 2, 3, 4, 5], therefore the program will return its length 5.

    public static void targetSum(int[] arr, int target) {
        System.out.println("Target is: " + target);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (target == (arr[i] + arr[j])) {
                    System.out.println("Indexes are: " + i + " " + j + " and their values are: " + arr[i] + " + " + arr[j]);
                }
            }
        }
    }

    public static void cloneLists(List<Integer> list, List<Integer> cloneList) {
        System.out.println("Initial List: " + list);
        for (Integer elements : list) {
            cloneList.add(elements);
        }
        System.out.println("Cloned list from initial: " + cloneList);
    }

    //or quicker
    public static <T> List<T> createClone(List<T> list) {
        // Ο πιο απλός και συνηθισμένος τρόπος: χρήση του copy constructor.
        return new ArrayList<>(list);
    }


    public static void findTripletsSum(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (number == arr[i] + arr[j] + arr[k]) {
                        System.out.println("Indexes are: " + i + " " + j + " " + k + " and the values are: " + arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }

    public static void clearList(List<Integer> list) {
        System.out.println("Original list: " + list);

        list.clear();
        System.out.println("Cleared list: " + list);

    }


    public static int[][] getAntiDiagonals(int[][] matrix) {
        // Έλεγχος για κενό ή μη τετραγωνικό πίνακα (απλοποιημένος)
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int n = matrix.length;
        // Ο συνολικός αριθμός των αντιδιαγωνίων σε έναν πίνακα n x n είναι 2*n - 1.
        int numDiagonals = 2 * n - 1;
        int[][] result = new int[numDiagonals][];
        // Ο βρόχος διατρέχει κάθε πιθανό άθροισμα δεικτών (από 0 έως 2*n - 2).
        // Κάθε άθροισμα αντιστοιχεί σε μια μοναδική αντιδιαγώνιο.
        for (int sum = 0; sum < numDiagonals; sum++) {
            // --- Στάδιο 1: Μέτρημα του μεγέθους της τρέχουσας αντιδιαγωνίου ---
            int count = 0;
            for (int row = 0; row < n; row++) {
                int col = sum - row; // Υπολογίζουμε τη στήλη με βάση το άθροισμα και τη σειρά
                // Ελέγχουμε αν οι υπολογισμένοι δείκτες (row, col) είναι εντός των ορίων του πίνακα
                if (col >= 0 && col < n) {
                    count++;
                }
            }
            // --- Στάδιο 2: Δημιουργία και γέμισμα του πίνακα για την αντιδιαγώνιο ---
            int[] antiDiagonal = new int[count];
            int index = 0; // Δείκτης για τον πίνακα antiDiagonal
            for (int row = 0; row < n; row++) {
                int col = sum - row;
                // Αν οι δείκτες είναι έγκυροι, προσθέτουμε το στοιχείο στον πίνακά μας
                if (col >= 0 && col < n) {
                    antiDiagonal[index] = matrix[row][col];
                    index++;
                }
            }
            // Τοποθετούμε την έτοιμη αντιδιαγώνιο στον τελικό πίνακα αποτελεσμάτων
            result[sum] = antiDiagonal;
        }
        return result;
    }

    /**
     * Βοηθητική μέθοδος για την εκτύπωση του πίνακα των αντιδιαγωνίων με ωραία μορφοποίηση.
     */
    public static void printResult(int[][] result) {
        System.out.println("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("  " + Arrays.toString(result[i]));
            if (i < result.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }


    public static void findMajorityElement(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int candidate = arr[n / 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }
        if (count > n / 2) {
            System.out.println("The majority element is: " + candidate);
        } else {
            System.out.println("No majority element found");
        }
    }

    public static void printLeaderElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    break;
                }
            }
            if (j == n) {
                System.out.println(arr[i] + " ");
            }

        }
    }

    public static void emptyList(List<Integer> list) {
        boolean empty = false;
        if (list.isEmpty()) {
            empty = true;
            System.out.println(empty);
        } else {
            empty = false;
            System.out.println(empty);
        }
    }


    /*
     int[] arrCloseToZero = {1,2,-2,4,-5, 3,34}; --> sort: {-5,-2,1,2,3,4,34
     pairSumClosestToZero (arrCloseToZero);
     */

    public static void pairSumCloseToZero(int[] arr) {  //λαθος γιατι λεει closest to zero οχι equals to zero
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];

                if (sum == 0) {
                    System.out.println("Two elements whose sum is minimum: " + arr[i] + arr[j]);
                }
            }


        }

    }

    public static void pairSumClosestToZero(int[] arr) {
        int size = arr.length;
        int l, r, min_sum, sum, min_l_num, min_r_num;

        // Check if the array has less than 2 elements.
        if (size < 2) {
            System.out.println("Invalid Input");
            return;
        }

        // Initialize variables to track the indices and minimum sum.
        min_l_num = 0;
        min_r_num = 1;
        min_sum = arr[0] + arr[1];

        // Nested loops to find the pair with the minimum sum.
        for (l = 0; l < size - 1; l++) {
            for (r = l + 1; r < size; r++) {
                sum = arr[l] + arr[r];

                // Update min_sum and indices if a smaller sum is found.
                if (Math.abs(min_sum) > Math.abs(sum)) {
                    min_sum = sum;
                    min_l_num = l;
                    min_r_num = r;
                }
            }
        }

        // Print the two elements whose sum is minimum.
        System.out.println("Two elements whose sum is minimum are " +
                arr[min_l_num] + " and " + arr[min_r_num]);
    }


    public static void findSmallestAndSecondSmallest(int[] arr) {
        Arrays.sort(arr);
        int smallest = arr[0];
        System.out.println("Smallest number in the array: " + smallest);
        //System.out.println("Second Smallest number in the array: " + arr[1]);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smallest) {
                System.out.println("Second Smallest number in the array: " + arr[i]);
                break;
            }

        }
    }

    public static void trimListCapacity(ArrayList<Integer> list) {
        list.trimToSize();
        System.out.println(list);
    }

    public static void increaseListCapacity(ArrayList<Integer> list) {
        list.ensureCapacity(10);
        System.out.println(list);
    }

    public static void replaceSecondElement(List<Integer> list) {
        list.set(1, 666);
        System.out.println("Updated 2nd element and print new list:" + list);
    }

    public static void printElementsPosition(List<Integer> list) {
        int elements = list.size();
        for (int i = 0; i < elements; i++) {
            System.out.println(list.get(i));
        }
    }


    public static void separateZeroesAndOnes(int[] arr) { //Ο(nlogn) time complexity
        Arrays.sort(arr);
        System.out.println("Zeroes on the left and ones on the right:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.asList(arr[i]));
        }
    }

    //or
    public static void separateZeroesAndOnes2(int[] arr) {    //Ο(N) time complexity
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {  //οσο οι δυο δείκτες δεν εχουν συναντηθει συνέχισε   δηλαδη ο left (που ειναι η αρχή του πίνακα πρέπει να πάει στο τέλος του πίνακα που ειναι το arr.lengtg - 1 που εχω αναθέσει στο right)
            while (arr[left] == 0 && left < right) {   //ουσιαστικά στο 1ο while -- οσο εχουμε 0 προχωράμε. Οταν βρεθει 1 το πάμε προς τα δεξιά με το left++
                left++;
            }
            while (arr[right] == 1 && left < right) {  //ουσιαστικά στο 2ο while -- οσο εχουμε 1 προχωράμε. Οταν βρεθει 0 το πάμε προς τα αριστερά με το right++
                right--;
            }
            if (left < right) {  //μετά για αυτά που βρήκα 1 δηλαδη τα αριστερα (left++ που κάναμε πριν) θα του αναθέσω να έιναι 0
                // Swap 0 and 1 and increment left and decrement right.  //για αυτά που βρήκα 0 δηλαδη τα δεξιά (right-- που κάναμε πριν) θα του αναθέσω να έιναι 1
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        System.out.println("Array after segregation is : " + Arrays.toString(arr));
    }


    public static void sumFourElementsToTarget(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int z = k + 1; z < arr.length; z++) {
                        sum = arr[i] + arr[j] + arr[k] + arr[z];
                        if (sum == target) {
                            System.out.println("elements that sums to our target: " + "The target: " + target + " Elements: " + arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[z]);
                        }
                    }
                }
            }
        }
    }

    public static void rotateArray(int[] arr) {
        int n = arr[arr.length - 1];
        int i = 0;
        for (i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = n; // n ειναι το τελευταίο element
    }

    public static void pairSumOfRotatedArr(int[] arr, int speficiedSum) {
        int n = arr[arr.length - 1];
        int sum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = n;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == speficiedSum) {
                    System.out.println("The specified sum is: " + speficiedSum + " and Values of the pair of the specified sum are" + arr[i] + " " + arr[j] + " and the sum is: " + sum);
                }
            }

        }
    }


    public static void appendElementInTheEndOfTheList(List<String> list) {
        System.out.println(list);
    }

    public static void arrangeNegBeforePos(int[] arr) {

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arr[i]);
        }
    }

    public static void arrangePosBeforeNeg(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            //Βρες τον πρώτο αρνητικό αριθμό από αριστερά   ... μετα βρες τον 2ο και κλπ κλπ
            if (arr[left] >= 0 && left < right) {
                left++;
            } //Βρες τον πρώτο θετικό αριθμό από δεξιά   ... μετα βρες τον 2ο και κλπ κλπ
            if (arr[right] < 0 && left < right) {
                right--;
            }
            //Αν ο αριστερός δείκτης είναι ακόμα πριν τον δεξιό, κάνε αντιμετάθεση
            if (left < right) {
                //Αντιμετάθεση (swap)
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Προχώρα και τους δύο δείκτες για την επόμενη επανάληψη
                left++;
                right--;
            }

        }
    }

    public static void iterateElement(List<String> list) {
        for (String elements : list) {
            System.out.print("\t" + elements);
        }
    }

    /* bubblesort loops and logic
             for(int i = 0; i < arr.length - 1; i++){ //bubblesort for sorting
                for(int j = 0; j < arr.length - i - 1; j++){
                    if(arr[i] > arr[j+1]){
                        int temp = arr[i];
                        arr[i] = arr[j + 1];
                        arr[j+1] = temp;
                    }
                }
              }
     */
    public static int rotationCountSortArray(int[] arr) {
        //rotation
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int minElement = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    public static int[] sortWithAlternateMaxMinValue(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        int[] sorted = java.util.Arrays.copyOf(arr, n);
        java.util.Arrays.sort(sorted);
        int[] result = new int[n];
        int left = 0;        // index of smallest remaining
        int right = n - 1;   // index of largest remaining
        int idx = 0;
        boolean takeMax = true;
        while (left <= right) {
            if (takeMax) {
                result[idx++] = sorted[right--];
            } else {
                result[idx++] = sorted[left++];
            }
            takeMax = !takeMax;
        }
        return result;
    }

    public static void separateZeroesAndRight(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //or
    public static int[] separateZeroesAndRight2(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++; //εδω με το count μετα κάτω θα ορισεις το length στο πινακα που θα μπουν τα 0
            }
        }
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }
        for (int i = count; i < n; i++) {
            arr[i] = 1;

        }
        return arr;
    }

    public static int[] separateEvenOddNums(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr; // No separation needed for null or tiny arrays
        }

        // Initialize two pointers: 'left' starts at the beginning, 'right' at the end.
        int left = 0;
        int right = arr.length - 1;

        // Loop as long as the pointers haven't crossed
        while (left < right) {
            // 1. Move 'left' pointer forward to find an ODD number (which belongs on the right side)
            // The condition (arr[left] % 2 == 0) means it's an even number.
            // If it's even, it's already in the correct (left) partition, so we move on.
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }

            // 2. Move 'right' pointer backward to find an EVEN number (which belongs on the left side)
            // The condition (arr[right] % 2 != 0) means it's an odd number.
            // If it's odd, it's already in the correct (right) partition, so we move on.
            while (left < right && arr[right] % 2 == 1) { // Same as % 2 == 0
                right--;
            }

            // 3. If the pointers haven't crossed, we've found an odd number on the left (arr[left])
            // and an even number on the right (arr[right]). We must SWAP them.
            if (left < right) {
                // Perform the swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Move both pointers inward after the swap
                left++;
                right--;
            }
        }
        return arr;
    }

    public static void iterateElementsSpecificPosition(List<Integer> list) {
        Iterator p = list.listIterator(2); //specify index
        while (p.hasNext()) {
            System.out.print(p.next());
        }
    }

    public static void replaceElementWithGreatestNext(int[] arr) {
        // 1. Αρχικοποιούμε το μέγιστο στοιχείο που έχουμε βρει μέχρι στιγμής
        //    (ξεκινώντας από το άκρο δεξιά) σε -1, όπως απαιτείται για
        //    το τελευταίο στοιχείο.
        int max_so_far = -1;
        int n = arr.length;

        // 2. Διασχίζουμε τον πίνακα από το τέλος προς την αρχή.
        for (int i = n - 1; i >= 0; i--) {
            // 3. Αποθηκεύουμε την τρέχουσα (αρχική) τιμή του arr[i]
            //    πριν την αντικαταστήσουμε.
            int current_original_element = arr[i];

            // 4. Αντικαθιστούμε το arr[i] με το 'max_so_far'.
            //    Το 'max_so_far' αυτή τη στιγμή περιέχει το μέγιστο
            //    όλων των στοιχείων στη δεξιά πλευρά του i.
            arr[i] = max_so_far;

            // 5. Ενημερώνουμε το 'max_so_far' αν η αρχική τιμή του τρέχοντος
            //    στοιχείου (current_original_element) είναι μεγαλύτερη από
            //    το τρέχον μέγιστο. Αυτή η ενημερωμένη τιμή θα χρησιμοποιηθεί
            //    για το επόμενο στοιχείο (i-1).
            if (current_original_element > max_so_far) {
                max_so_far = current_original_element;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static Boolean findSubarraySumZero(int[] nums) {
        // Create a HashSet to store the cumulative sum of elements.
        Set set = new HashSet<>();
        set.add(0);
        int suba_sum = 0;

        // Iterate through the elements of the array.
        for (int i = 0; i < nums.length; i++) {
            suba_sum += nums[i];

            // If the cumulative sum already exists in the set, return true.
            if (set.contains(suba_sum)) {
                return true;
            }

            // Add the cumulative sum to the set.
            set.add(suba_sum);
        }

        // If no subarray with a sum of zero is found, return false.
        return false;
    }

    public static void reverseListIteration(List<Integer> list) {
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    //or
//    public static void reverseListIteration2(){
//        List<Integer> list = new LinkedList<>();
//
//        list.add(5);
//        list.add(7);
//        list.add(88);
//        list.add(3);
//        list.add(1);
//        System.out.println(list);
//
//        Iterator it = list.descendingIterator();
//    while (it.hasNext()) {
//        System.out.println(it.next());
//    }
//    }
    public static void specificIndexList(LinkedList<Integer> list) {
        System.out.println(list);
        list.set(2, 116);
        System.out.println(list);
    }


    public static void printSubarraySumZero(int[] A) {
        // Create a list to store elements of subarrays.
        List<Integer> llist = new ArrayList<Integer>();

        // Iterate through the array.
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            llist.removeAll(llist);

            // Nested loop to find subarrays starting from index i.
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                llist.add(A[j]);

                // If the sum of the subarray is zero, print it.
                if (sum == 0) {
                    System.out.println("Sub-arrays with 0 sum: " + llist.toString());
                }
            }
        }
    }

    public static void sortBinaryArray(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                arr[k++] = 0;
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[k++] = 1;
        }
    }

    public static void specificIndexListLastFirst(LinkedList<Integer> list) {
        System.out.println(list);
        list.set(0, 116);
        list.set(list.size() - 1, 120);

        System.out.println(list);
        list.addFirst(2000);
        list.addLast(2001);
        System.out.println(list);
    }

    public static void merge_sorted_arrays(int[] A, int p, int[] B, int q) {
        // Loop through the first array.
        for (int i = 0; i < p; i++) {
            if (A[i] > B[0]) {
                // Swap elements if the current element in A is greater than the first element in B.
                int temp = A[i];
                A[i] = B[0];
                B[0] = temp;

                // Store the first element from B.
                int first_arr = B[0];
                int k;

                // Move elements in B to the right to insert first_arr in the correct position.
                for (k = 1; k < q && B[k] < first_arr; k++) {
                    B[k - 1] = B[k];
                }

                // Insert first_arr in the correct position in B.
                B[k - 1] = first_arr;
            }
        }
    }

    public static void maxProduct(int[] A) {
        int maxProd = 0;
        int maxI = 0, maxJ = 0;
        int i = 0, j = i + 1;
        for (i = 0; i < A.length; i++) {
            for (j = i + 1; j < A.length; j++) {
                int prod = A[i] * A[j];
                if (maxProd < prod) {
                    maxProd = prod;
                    maxI = i;
                    maxJ = j;
                }

            }

        }
        System.out.println(maxProd + " with Pair (" + A[maxI] + "," + A[maxJ] + ")");
    }

    public static void shuffleArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i >= 1; i--) {
            int shuffle = random.nextInt(i + 1);
            swapElements(arr, i, shuffle);

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swapElements(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void offerFirstMethod(LinkedList<Integer> list) {
        System.out.println(list);
        list.offerFirst(3005);
        System.out.println(list);
    }

    public static void offerLastMethod(LinkedList<String> list) {
        System.out.println(list);
        list.offerLast("Test");
        System.out.println(list);
    }

    public static void insertSpecified(LinkedList<String> list) {
        System.out.println(list);
        list.set(1, "Test2");
        list.set(2, "Test3");
        System.out.println(list);
    }


    public static int[] rearrangeArrayWithSecondElement(int[] arr) {
        Arrays.sort(arr);
        int[] resultArray = new int[arr.length];

        int largeIndex = 0, smallIndex = arr.length - 1;
        for (int i = 1; i < resultArray.length; i += 2) {
            resultArray[i] = arr[smallIndex];
            smallIndex--;
        }

        for (int j = 0; j < resultArray.length; j += 2) {
            resultArray[j] = arr[largeIndex];
            largeIndex++;
        }

        return resultArray;
    }

    public static void equilibriumArr(int[] arr) {
        long totalSum = 0;
        for (int element : arr) {
            totalSum += element;
        }
        long leftSum = 0;

// Ο βρόχος ελέγχει κάθε δείκτη i ως πιθανό σημείο ισορροπίας
        for (int i = 0; i < arr.length; i++) {

            // 1. Υπολογισμός του RightSum:
            // rightSum = totalSum - (άθροισμα αριστερών στοιχείων) - (το τρέχον στοιχείο)
            long rightSum = totalSum - leftSum - arr[i];

            // 2. Έλεγχος της Συνθήκης Ισορροπίας
            if (leftSum == rightSum) {
                // Τι πρέπει να γράψεις: Εάν ισχύει, ο i είναι δείκτης ισορροπίας
                System.out.println("Equilibrium index found at: " + i);
            }

            // 3. Ενημέρωση του LeftSum για την επόμενη επανάληψη
            // Το τρέχον στοιχείο (arr[i]) θα γίνει μέρος του "αριστερού αθροίσματος"
            // για τον επόμενο δείκτη (i+1).
            leftSum += arr[i];
        }
    }

    public static void firstAndLastOccurence(LinkedList<String> list) {
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

    }

    public static void displayElementsAndPositions(LinkedList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " -- " + i);
        }
    }

    public static void print(Integer result) {
        System.out.println(result);
    }

    public static int[] replaceElementWithProdOfOthers(int[] nums) {

        int n = nums.length;
        int[] left_element = new int[n];
        int[] right_element = new int[n];
        // Calculate left products.
        left_element[0] = 1;
        for (int i = 1; i < n; i++) {
            left_element[i] = nums[i - 1] * left_element[i - 1];
        }

        // Calculate right products.
        right_element[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right_element[j] = nums[j + 1] * right_element[j + 1];
        }

        // Calculate the product of every other element.
        for (int i = 0; i < n; i++) {
            nums[i] = left_element[i] * right_element[i];
        }

        // Return the modified array.
        return nums;
    }

    public static void printList(LinkedList<String> list) {
        System.out.println(list);
    }

    public static void removeElement(LinkedList<String> list) {
        printList(list);
        list.remove(list.get(0));
        printList(list);
    }

    public static void removeFirstAndLastElement(LinkedList<String> list) {
        printList(list);
        list.remove(list.getFirst());
        list.remove(list.getLast());
        printList(list);
    }

    public static void removeAllElements(LinkedList<Integer> list) {
        System.out.println(list);
        list.removeAll(list);
        System.out.println(list);
    }

    public static void swapElementsList(LinkedList<Integer> list) {
        System.out.println(list);
        Collections.swap(list, 0, 2);
        System.out.println(list);
    }

    public static void joinTwoLists(LinkedList<Integer> list, LinkedList<Integer> list1) {
        System.out.println(list);
        System.out.println(list1);
        LinkedList<Integer> joinLists = new LinkedList<>();
        joinLists.addAll(list);
        joinLists.addAll(list1);
        System.out.println(joinLists);

    }

    public static void shuffleList(LinkedList<Integer> list) {
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println("After shuffling: " + list);

    }

    public static void copyLists(LinkedList<Integer> list, LinkedList<Integer> list2) {
        System.out.println(list);
        System.out.println(list2);
        list2 = list;
        System.out.println(list2);
    }

    //or
    public static void copyLists2(LinkedList<Integer> list, LinkedList<Integer> list2) {
        System.out.println(list);
        System.out.println(list2);
        list2 = (LinkedList) list.clone();
        System.out.println(list2);
    }

    public static void retrieveFirstElement(LinkedList<Integer> list) {
        System.out.println(list);
        list.pop();
        System.out.println(list);
    }

    public static void retrieveAndNotRemoveFElement(LinkedList<Integer> list) {
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
    }

    public static void retrieveAndNotRemoveLElement(LinkedList<Integer> list) {
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

    public static void checkElementExistance(LinkedList<Integer> list) {
        System.out.println(list);
        if (list.contains(55)) {
            System.out.println("it is present the element");
        }
    }

    public static void convertLinkedToArrayList(LinkedList<Integer> list) {
        List<Integer> arrList = new ArrayList<>(list);
        for (Integer elements : arrList) {
            System.out.println(elements);
        }
    }

    public static void compareLists(LinkedList<String> list1, LinkedList<String> list2) {
        LinkedList<String> list3 = new LinkedList<>();
        for (String elements : list1) {
            list3.add(list2.contains(elements) ? "Yes" : "No");
            System.out.println(list3);
        }
    }

    public static boolean checkListIsEmpty(LinkedList<String> list) {
        boolean isEmpt = true;
        if (list.isEmpty()) {
            isEmpt = true;
        } else {
            isEmpt = false;
        }
        return isEmpt;
    }

    public static void replaceElementList(LinkedList<String> list) {
        System.out.println("Initial list: " + list);
        Collections.replaceAll(list, "Μανιτάρια", "Μανταρίνια");  //or we can just set ---> list.set(0, "Μανταρίνια");
        System.out.println(list);
    }

    public static void findMaxDifferenceInTwoElements(int[] arr) {
        int maxDiff = arr[1] - arr[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentDiff = arr[j] - arr[i];
                if (currentDiff > maxDiff) {
                    maxDiff = currentDiff;
                }
            }
        }
        print(maxDiff);
    }

    public static void findSubArrayWithLargerSumOfArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currentSubarraySum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSubarraySum += arr[j];
                if (currentSubarraySum > max) {
                    max = currentSubarraySum;
                }
            }
        }
        print(max);
    }

    public static int[] findMinSubarraySum(int[] nums, int k) {
        // Initialize variables to track the subarray sum and its minimum.
        int subArrSum = 0;
        int minSubArr = Integer.MAX_VALUE;
        int last = 0;
        int[] result = new int[3]; // Store the result [start, end, min sum].
        // Iterate through the 'nums' array.
        for (int i = 0; i < nums.length; i++) {
            subArrSum += nums[i];
            // Check if the subarray size 'k' is reached.
            if (i + 1 >= k) {
                // Update the minimum subarray sum and its endpoint.
                if (minSubArr > subArrSum) {
                    minSubArr = subArrSum;
                    last = i;
                }
                // Remove the contribution of the first element in the subarray.
                subArrSum -= nums[i + 1 - k];
            }
        }
        // Store the results in the 'result' array.
        result[0] = last - k + 1; // Start index of the minimum subarray.
        result[1] = last; // End index of the minimum subarray.
        result[2] = minSubArr; // Minimum subarray sum.
        return result;
    }

    public static void findLargestNumFromAListOfNonNegatives(int[] nums) {
        Arrays.asList(nums);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i]);
        }
    }

    public static int[] findUnsortedSubarray(int[] nums) {
        // Initialize an array to store the result, where result[0] represents the start index and result[1] represents the end index.
        int[] result = new int[2];
        // Get the length of the input array.
        int n = nums.length;
        // Initialize variables for the start and end indices and for finding the minimum and maximum values.
        int start = -1;
        int end = -2;
        int min = nums[n - 1];
        int max = nums[0];
        // Traverse the array to find the subarray that needs sorting.
        for (int i = 1; i < n; i++) {
            // Update the maximum and minimum values.
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            // Check if the current element is less than the maximum value.
            if (nums[i] < max) {
                end = i;
            }
            // Check if the current element is greater than the minimum value.
            if (nums[n - 1 - i] > min) {
                start = n - 1 - i;
            }
        }
        // Update the result array with the start and end indices of the subarray to be sorted.
        result[0] = start;
        result[1] = end;
        // Return the result.
        return result;
    }

    private static void sortArrTwoElementsOutOfPlace(int[] cArrTwoEl) {
        Arrays.sort(cArrTwoEl);
        System.out.println(Arrays.toString(cArrTwoEl));
    }

    public static void findTripletsSumOfTarget(int[] nums, int target) {
        int sum = 0;
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        found = true;
                        System.out.println("Triplets of sum" + target + " Is found with: (" + nums[i] + " and " + nums[j] + " and " + nums[k] + ")");
                    } else {
                        found = false;
                    }
                }
            }
        }
    }

    public static void findLargestGapBetweenSortedElements(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int maxDiff = 0;
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            maxDiff = Math.abs(Math.max(arr[i + 1] - arr[i], max));
        }
        System.out.println("Largest gap bewtween 2 elements in sorted array is: " + maxDiff);
    }

    public static boolean test(int[] nums) {
        // Sort the 'nums' array in ascending order.
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if the current number and the next number are consecutive.
            if (nums[i] + 1 != nums[i + 1])
                return false;
        }
        return true;
    }

    public static boolean checkArrayIfAlternatesBetweensPositivesNegatives(int[] arr) {
        for (int elements : arr) {
            if (elements == 0) {
                return false;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > 0 && arr[i] > 0) {
                return false;
            } else if (arr[i - 1] < 0 && arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNegativeDominance(int[] arr) {
        int negativeCounter = 0;
        int positiveCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeCounter++;
            }
            if (arr[i] >= 0) {
                positiveCounter++;
            }
        }
        if (negativeCounter > positiveCounter) {
            return true;
        }
        return false;
    }

    public static void appendElement(HashSet<Integer> set) {
        set.add(5);
        set.add(66);
        set.add(67);
        System.out.println(set);
    }

    public static String findMissingLetterInConsecutiveLetters(String[] strArra) {
        int c = strArra[0].charAt(0) + 1;//ουσιαστικά εδω λαμβανει την πρωτη συμβολοσειρα του πινακα και παιρνει πχ το απο το {"a,"b","c"... το α!
        for (int i = 1; i < strArra.length; i++, c++) {
            if (strArra[i].charAt(0) != c) {
                return String.valueOf((char) c);
            }
        }
        // Return an empty string if no letter is missing.
        return "";
    }

    public static void iterateHash(HashSet<Integer> set) {
        Iterator<Integer> p = set.iterator();
        while (p.hasNext()) {
            System.out.println(p.next());
        }
    }

    public static void getHash(HashSet<Integer> set) {
        System.out.println(set.size());
    }

    public static void clearHash(HashSet<Integer> set) {
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }

    public static boolean checkEmptiness(HashSet<Integer> set) {
        if (set.isEmpty()) {
            System.out.println("it is empty");
            return true;
        }
        System.out.println("it is not empty");
        return false;
    }

    public static void cloneHash(HashSet<Integer> set) {
        System.out.println(set);
        HashSet<Integer> set2 = new HashSet<>();
        set2 = (HashSet) set.clone();
        System.out.println("Cloned from set: " + set2);
    }

    public static void convertHashToArr(HashSet<Integer> set) {
        System.out.println(set);
        Integer[] newArr = new Integer[set.size()];
        set.toArray(newArr);
        System.out.println("Arr elements: ");
        for (Integer elements : newArr) {
            System.out.println(elements);
        }
    }

    public static void convertHashToTree(HashSet<Integer> set) {
        System.out.println(set);
        Set<Integer> treeSet = new TreeSet<>(set);
        for (Integer elements : treeSet) {
            System.out.println(elements);
        }
    }

    public static void findLessThan7ElementsInTreeSet(HashSet<Integer> set) {
        for (Integer elements : set) {
            if (elements < 7) {
                System.out.println(elements);
            }
        }
    }

    public static void compareHash(HashSet<Integer> set) {
        HashSet<Integer> setC = new HashSet<>();
        setC.add(5);
        setC.add(67);
        setC.add(1);
        setC.add(2);
        for (Integer elementsSame : set) {
            if (setC.contains(elementsSame)) {
                System.out.println(elementsSame);
            }
            //or
            /*
            System.out.println(setC.contains(elementsSame) : "Yes" : "No");
             */
        }
    }

    public static void retainCommonElements(HashSet<Integer> set) {
        HashSet<Integer> compareSet = new HashSet<>();
        compareSet.add(1);
        compareSet.add(55);
        compareSet.add(99);
        compareSet.add(101);
        System.out.println(set.retainAll(compareSet)); //true output or false
        System.out.println(set);
    }

    public static void removeAllFromHash(HashSet<Integer> set) {
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }

    //treeset:
    public static void treeSet() {
        TreeSet<String> tres = new TreeSet<>();
        tres.add("Yellow");
        tres.add("Black");
        tres.add("Green");
        tres.add("Reddd");

        System.out.println(tres);
    }

    public static void IterTreeSet() {
        TreeSet<String> tres = new TreeSet<>();
        tres.add("Yellow");
        tres.add("Black");
        tres.add("Green");
        tres.add("Reddd");
        for (String elem : tres) {
            System.out.println(tres);
        }

    }

    public static void addElemeTree() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(5);
        set.add(66);
        set.add(6);
    }

    public static void reverseOrderTreeSet(TreeSet<String> treeSet) {
        for (String elem : treeSet.descendingSet()) {
            System.out.println(elem);
        }
        //or
//        Iterator it = t_set.descendingIterator();
//        // Print list elements in reverse order
//        System.out.println("Elements in Reverse Order:");
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

    }

    public static void getFirstAndLastTreeElems(TreeSet<Integer> set) {
        System.out.println("first element is: " + set.first() + " last element is: " + set.last());
    }

    public static void cloneTree(TreeSet<Integer> set) {
        TreeSet<Integer> setClones = (TreeSet<Integer>) set.clone();
        System.out.println(set);
        System.out.println("Clone of set: " + setClones);
    }

    public static void sizeTree(TreeSet<Integer> set) {
        System.out.println(set.size());
    }

    public static void compareTrees(TreeSet<Integer> tree) {
        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(5);
        set1.add(56);
        for (Integer elems : tree) {
            System.out.println(set1.contains(elems) ? "Yes" : "No");
        }
    }

    public static void elemsLessThanSeven(TreeSet<Integer> tre) {
        for (Integer elements : tre) {
            if (elements < 7) {
                System.out.println(elements);
            }
        }
    }

    public static void ceilingElem(TreeSet<Integer> set) {
        System.out.println(set.ceiling(45));

    }

    public static void flourElem(TreeSet<Integer> set) {
        System.out.println(set.floor(45));

    }

    public static int higherElem(TreeSet<Integer> tre) {
        tre.higher(56);
        return tre.higher(56);
    }

    public static int lowerElem(TreeSet<Integer> tre) {
        tre.lower(56);
        return tre.lower(56);
    }

    public static void pollFirst(TreeSet<Integer> tr) {
        tr.pollFirst();
        System.out.println(tr);
    }

    public static void pollLast(TreeSet<Integer> ts) {
        ts.pollLast();
        System.out.println(ts);
    }

    public static void removeElemeTs(TreeSet<Integer> ts, Integer elem) {
        System.out.println(ts);
        ts.remove(elem);
        System.out.println(ts);
    }

    public static void iterateTs(PriorityQueue<Integer> pq) {
        for (Integer elements : pq) {
            System.out.println(elements);
        }
    }

    public static void addPriorityQtoOtherPQ(PriorityQueue<Integer> pq) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(5);
        pq1.add(99);
        pq.addAll(pq1);
        System.out.println(pq1);
    }

    public static void insertToPq(PriorityQueue<Integer> pq, Integer element) {
        pq.add(element);
        System.out.println(pq);
    }

    public static void clearPq(PriorityQueue<Integer> pq) {
        System.out.println(pq);
        pq.clear();
        System.out.println(pq);
    }

    public static void countPq(PriorityQueue<Integer> pq) {
        int count = 0;
        for (Integer elemtns : pq) {
            count++;
        }
        System.out.println("Total Priority Queue elements are: " + count);
    }

    public static void comparePq(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2) {
        for (Integer elements : p1) {
            System.out.println(p2.contains(elements) ? "Yes" : "No");
        }
    }

    public static void peekFirst(PriorityQueue<Integer> p1) {

        System.out.println(p1.peek());
    }

    public static void pollFirst(PriorityQueue<Integer> p1) {

        System.out.println(p1.poll());
    }

    public static void convertPq(PriorityQueue<Integer> pq33) {
        System.out.println(pq33);
        List<Integer> pql = new ArrayList<>(pq33);
        System.out.println(pql);
    }

    public static void convertPqStr(PriorityQueue<Integer> pq33) {
        System.out.println(pq33);
        pq33.toString();
        System.out.println(pq33);
    }

    public static void convertPqMax(PriorityQueue<Integer> pq34) {
        System.out.println(pq34);

        System.out.println("Maximum PQ");
        Integer value = null;
        while ((value = pq34.poll()) != null) {
            System.out.println(value + " ");
            System.out.println("\n");
        }

    }

    public static void hsMap(HashMap<Integer, Integer> map) {
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());

        }
    }

    public static void countKeyValMappings(HashMap<Integer, Integer> map) {
        System.out.println(map.size());
    }

    public static void copyMappings(HashMap<Integer, Integer> map, HashMap<Integer, Integer> map2) {
        map2.putAll(map);
        System.out.println(map2);
    }

    public static void removeMappings(HashMap<Integer, Integer> map) {
        map.clear();
        System.out.println(map);
    }

    public static boolean mapIsEmpty(HashMap<Integer, Integer> map) {
        if (!map.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void shallowCopy(HashMap<Integer, Integer> map, HashMap<Integer, Integer> cloned) {
        cloned = (HashMap) map.clone();
        System.out.println(cloned);
    }

    public static boolean keyExists(HashMap<Integer, Integer> map) {
        if (!map.containsKey(1)) {
            System.out.println("no");
            return false;
        }
        System.out.println(map.get(1));
        return true;
    }

    public static boolean valueExists(HashMap<Integer, Integer> map) {
        if (!map.containsValue(2)) {
            System.out.println("no");
            return false;
        }
        //System.out.println(map.get(2));
        return true;
    }

    public static void getSetViewMapEnty(HashMap<Integer, Integer> map) {
        Set set = map.entrySet();
        System.out.println("Set values " + set);
    }

    public static void getValByKeyMap(HashMap<Integer, Integer> map) {
        Integer vl = map.get(1);
        System.out.println("The value for key is: " + vl);
    }

    public static void getSetKeysFromMap(HashMap<Integer, Integer> map) {
        Set keyset = map.keySet();
        System.out.println("key set values are: " + keyset);
    }

    public static void getCollectionsFromValues(HashMap<Integer, String> map) {
        System.out.println(map.values());
    }


    //TreeMap
    public static void associateValueWithKey(TreeMap<Integer, Integer> treeMap) {
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println("Key is: " + entry.getKey() + " and value is: " + entry.getValue());
        }
    }

    public static void copyTreeMapToAnotherTreeMap(TreeMap<Integer, Integer> treeMap) {
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        map2.putAll(treeMap);
        System.out.println(treeMap);
        System.out.println(map2);
    }

    public static void searchKeyInTreeMap(TreeMap<Integer, Integer> map) {
        System.out.println("---> " + map.containsKey(1));
        System.out.println("I found key 1 in TreeMap");
    }

    public static void searchValueInTreeMap(TreeMap<Integer, Integer> map) {
        System.out.println("---> " + map.containsValue(1));
        System.out.println("I found VALUE 1 in TreeMap");
    }

    public static void getAllKeysFromTree(TreeMap<Integer, Integer> mapt) {

        for (Map.Entry<Integer, Integer> elemKeys : mapt.entrySet()) {
            System.out.println(elemKeys.getKey());
        }
    }

    public static void deleteAllElem(TreeMap<String, Integer> mp) {
        mp.clear();
        System.out.println(mp);
    }

    public static void sortTreeMapComparator(TreeMap<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());
        for (Integer key : list) {
            System.out.println("Key " + key + " Value " + map.get(key));
        }
    }

    public static void getGreatestAndLeastKey(TreeMap<Integer, Integer> map) {
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());

    }

    public static void getFandLkey(TreeMap<Integer, Integer> map) {
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

    }

    public static void reverseViewOfMapKeys(TreeMap<Integer, Integer> map) {
        System.out.println("Original treemap content: " + map + " \n");
        System.out.println("Reverse order of view map keys" + map.descendingKeySet());

    }

    public static void getMapFloorKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.floorEntry(10));
    }

    public static void getFloorKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.floorKey(10));
    }

    public static void getHeadMapWithKeysLessThanGivenKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.headMap(10));
    }

    public static void getHeadMapWithOptionalInclusiveKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.headMap(10, true));
    }

    public static void getHigherKeyTreeMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.higherKey(4));
    }

    public static void getLowerKeyTreeMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Value check for 10: " + treeMap.lowerKey(4));
    }

    public static void getNavigableSetViewKeys(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.navigableKeySet());
    }

    public static void pollFirstEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.pollFirstEntry());
    }

    public static void pollLastEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.pollLastEntry());
    }

    public static void getSubMapFromKeyToExclusiveKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.subMap(5, 10));
    }

    public static void getSubMapFromKeyToKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.subMap(5, true, 10, true));
    }

    public static void getTailMapFromInclusiveKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Orginal TreeMap content: " + treeMap.tailMap(5));
    }

    public static void getTailMapFromExclusiveKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("------->: " + treeMap.tailMap(5, false));
    }

    public static void getMappingWithCeilingKey(TreeMap<Integer, Integer> treeMap) {
        System.out.println("------->: " + treeMap.ceilingEntry(5));
    }

    public static void getCeilingWithTreeMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("------->: " + treeMap.ceilingKey(5));
    }

    //TODO: 2nd set of collections exercises:
    public static void evenNumsList(List<Integer> evenList) {
        for (Integer nums : evenList) {
            if (nums % 2 == 0) {
                System.out.println(nums);
            }
        }
        //or με συναρτησιακο προγραμματισμο
//        evenList.stream().
//                filter(n-> n%2==0).
//                forEach(System.out::println);
    }

    //factorial of a number
    public static int factorialN(int num) { //apodotikos tropos
        if (num == 0) return 1;

        return num * factorialN(num - 1);
    }

    //argos tropos me List
    public static long factorialWithList(int n) {
        if (n == 0) return 1;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        long res = 1;
        for (Integer num : numbers) {
            res *= num; //δηλαδη αν το n = με 5 ουσιαστικα κανεις add 1,2,3,4,5 Και μετα στην for loop εδω 1*2*3*4*5
        }
        return res;
    }

    //comparing two numbers using else if
    public static void compareNums() {
        int a = 10;
        int b = 25;

        int res = Integer.compare(a, b);
        if (res < 0) {
            System.out.println(a + " is smaller than " + b);
        } else if (res > 0) {
            System.out.println(a + " is greater than " + b);
        } else {
            System.out.println("numbers are equal");

        }
    }

    //leap year with MAP
    public static boolean leapYear(int year) {
        LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();
        map.put(400, true);
        map.put(100, false);
        map.put(4, true);


        for (Map.Entry<Integer, Boolean> rule : map.entrySet()) {
            if (year % rule.getKey() == 0) {
                return rule.getValue();
            }
        }
        return false;
    }

    public static void fibonacciSeries(int n) {
        List<Integer> list = new ArrayList<>();
        if (n <= 0) return;
        list.add(0);
        if (n == 1) {
            System.out.println(list);
            return;
        }
        list.add(1);
        for (int i = 2; i < n; i++) {
            int element = list.get(i - 1);
            int element2 = list.get(i - 2);
            int result = element + element2;
            list.add(result);
        }
        System.out.println("Fibonacci series: " + list);
    }

    public static boolean isPalindrome(int num) { // easier way
        String s = String.valueOf(num);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromev2(int num) { // math way χωρις μετατροπη σε String
        if (num < 0) {
            return false;
        }

        int original = num; //εδω ειναι το 12321
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10; //εστω 12321 ==> παιρνει πχ αρχικα το 1, μετα παιρνει το 2
            reversed = (reversed * 10) + digit; // ===> 0 * 10 + 1 = 1, μετα λεει 1 * 10 + 2 = 12
            num /= 10; //αφαιρει το 1 παει στο επομενο στο 2..., μετα αφαιρει και το 2 παει στο 3... και κλπ κλπ
        }
        return original == reversed;
    }

    public static void generatePrimeNumsBetween1AndGivenNum(int limit) {
        System.out.println("Prime numbers up to " + limit + ":");
        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;
            // Έλεγχος αν ο num διαιρείται από το 2 έως τη ρίζα του
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; // Βρήκαμε διαιρέτη, άρα δεν είναι πρώτος
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num + " ");
            }
        }
    }

    public static void pyramidOfStars() {
        String star = "*";
        for (int i = 0; i < 10; i++) {
            System.out.printf(star.repeat(i) + "\n");
        }
    }

    public static void pyramidStarsNestedFors() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pyramidStarsReversed() {
        for (int i = 10; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void nestedSwitchTest() {
        int option = 2;
        int subOption = 1;
        int increase = 0;
        int salary = 500;
        for (int i = 0; i < 5; i++) {
            salary++;
        }
        switch (option) {
            case 1:
                System.out.println("This is case 1");
                break;
            case 2:
                System.out.println("This is case 2");
                switch (subOption) {
                    case 1:
                        if (salary > 500) {
                            increase++;
                        }
                        System.out.println(increase);
                        break;
                    case 2:
                        System.out.println("This is sub 2");
                        break;
                    default:
                        System.out.println("not valid option");
                        break;
                }
                break;
            default:
                System.out.println("not valid 1st option");
                break;
        }
    }

    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");

        // Base case: το 0! και το 1! ισούται με 1
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }

    public static void findMinAndMax2(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Maximum in the array: " + max + " Minimun in the array " + min);
    }

    private static void readInputsSmallerLargestVals() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give a number: ");
        if (sc.hasNextFloat()) {
            float num = sc.nextFloat();

            int ceilVal = (int) Math.ceil(num);
            int floorVal = (int) Math.floor(num);

            System.out.println("\nResults for: " + num);
            System.out.println(" -> Small Integer not less than the number: " + ceilVal);
            System.out.println("Given number: " + num);
            System.out.println("-> Largerst Integer not greater than the number: " + floorVal);

        } else {
            System.out.println("Invalid input. Please enter a valid float!");
        }
        //sc.close();
    }

    public static void randomGeneratedNums() {
        Random rand = new Random();
        int[] storedRandomVals = new int[5];
        for (int i = 0; i < 5; i++) {
            int randomNum = rand.nextInt(1, 100) + 1;
            storedRandomVals[i] = randomNum;
        }
        System.out.println(Arrays.toString(storedRandomVals));
    }

    public static void gradesMessage(String grade) {
        switch (grade) {
            case "A":
                System.out.println("Outstanding");
                break;
            case "B":
                System.out.println("Good");
                break;
            case "C":
                System.out.println("Average");
                break;
            case "D":
                System.out.println("Below Average");
                break;
            default:
                System.out.println("Invalid grade");
                break;
        }
    }

    public static void sumProdOfSigits(int num) {
        int sum = 0;
        int prod = 1;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            prod *= digit;
            num /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Product of digits: " + prod);
    }

    public static void sumAllIntegersDivisibleBy7InRange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lower bound (>= 0): ");
        int lower = sc.nextInt();
        System.out.println("Enter upper bound (> lower): ");
        int upper = sc.nextInt();

        int sum = 0;
        for (int i = lower + 1; i < upper; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum is " + sum);
    }

    public static void concatString(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].concat("!");
            result += words[i] + " ";
        }
        System.out.println(Arrays.toString(words));
    }

    private static int[] swapValues(int arr[]) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;
    }

    public static void convertDaysIntoMonths() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give your days to convert them into months:");
        int days = scanner.nextInt();
        double mon = days / 30.0;
        int remainingDays = days % 30;
        System.out.println("Days are equal in months --> " + String.format("%.02f", mon) + " and remaining days are: " + remainingDays);
    }

    public static void printInvertTriangle() { //with while loop
        int rows = 5;
        int i = rows;
        while (i >= 1) {
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i--;
        }
    }

    public static void printInvertTrv2() { //with for loop
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static boolean isArmstrong(int num) {
        String num1 = String.valueOf(num);
        int numDigits = num1.length();
        int sum = 0;
        int originalNum = num;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            sum += Math.pow(digit, numDigits);
        }
        if (sum == originalNum) {
            return true;
        }
        return false;
    }

    public static void harmonicSeries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give your n: ");
        int nums = sc.nextInt();
        System.out.println();
        double sum = 0.0;
        for (int i = 1; i <= nums; i++) {
            sum += 1.0 / i;
        }
        System.out.printf("Sum of harmonic series: %.04f \n ", sum);
    }

    public static void averageConsecutiveOddsEvenNums(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Empty array");
            return;
        }
        int sum = 0;
        int count = 0;
        boolean isEvenSequence = (arr[0] % 2 == 0);

        for (int i = 0; i < arr.length; i++) {
            boolean currentIsEven = (arr[i] % 2 == 0);
            if (currentIsEven == isEvenSequence) {
                // Συνεχίζουμε την ίδια ακολουθία
                sum += arr[i];
                count++;
            } else {
                // Τέλος προηγούμενης ακολουθίας, υπολογίζουμε μέσο όρο
                double average = (double) sum / count;
                System.out.printf("Average of consecutive %s numbers are : %.2f%n", isEvenSequence ? "even" : "odd", average);

                // Ξεκινάμε νέα ακολουθία
                sum = arr[i]; // ξεκινάει δηλαδή από το πρώτο στοιχείο που ξεκινάει η ακολουθία
                count = 1; //το count ξεκινάει απο το 1 (το πρώτο στοιχείο δηλαδή)
                isEvenSequence = currentIsEven; //και αδειάζουμε (reset) το sum και το count για την νέα ακολουθία
            }
        }

        // Υπολογισμός μέσου όρου για την τελευταία ακολουθία
        double average = (double) sum / count;
        System.out.printf("Average of consecutive %s numbers: %.2f%n", isEvenSequence ? " even " : "odd", average);
    }

    public static void displayTrianglePatternt(int n) {
        int num = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }
    }


    /// ////////>>>>>>>new set of exercises with Arrays >>>>>>>>>/////////////
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void sortArrayDesc(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void sumOfArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }

    public static void avgOfArr(int[] arr) {
        int sum = 0;
        double avg = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            avg = sum / arr.length;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(avg);
    }

    public static void storeElemArray(int[] arr) {
        arr[0] = 5;
        arr[1] = 6;
        arr[2] = 7;
        arr[3] = 678;
        arr[4] = 987;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void arrayUserInput(int[] arr) {
        Scanner sc = new Scanner(System.in);
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public static void readReverse(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void cubicArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((int) Math.pow(arr[i], 3));
        }
    }

    public static void maxMinA(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max element is: " + max);
        System.out.println("Min element is: " + min);
    }

    public static void oddNums(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 1) {
                System.out.println("Odd arr elements: " + num[i]);
            }
        }
    }

    public static void evenNums(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println("Even arr elements: " + num[i]);
            }
        }
    }

    public static void oddSumNums(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 1) {
                sum += num[i];
                System.out.println("sum odd arr elements: " + sum);
            }
        }
    }

    public static void evenSumNums(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                sum += num[i];
                System.out.println("sum even elements: " + sum);
            }
        }
    }

    public static void cubicSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.pow(arr[i], 3);
        }
        System.out.println(sum);
    }

    public static void copyArr(int[] arr) {
        int[] copiedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copiedArr[i] = arr[i];
        }
        System.out.println(Arrays.toString(copiedArr));
    }

    public static void mergeIntoA3rdArray(int[] arr, int[] arr2) {
        int newLength = arr.length + arr2.length;
        int[] arr3 = new int[newLength];
        for (int i = 0; i < arr.length; i++) {
            arr3[i] = arr[i];
        }
        for (int i = arr.length, j = 0; i < newLength; i++, j++) {

            arr3[i] = arr2[j];
        }
        System.out.println(Arrays.toString(arr3));
    }

    public static void positiveNums(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                System.out.print(num[i]);
            }
        }
    }

    public static void negativeNums(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) {
                System.out.print(num[i]);
            }
        }
    }

    public static void positiveSumNums(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                sum += num[i];
            }
        }
        System.out.print(sum);
    }

    public static void negativeSumNums(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) {
                sum += num[i];
            }
        }
        System.out.print(sum);
    }

    public static int searchArray(int[] arr, int x) {
        //Linear search
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }// or binary search

    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;


            if (arr[mid] > x)

                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;

    }

    //simpler binSearch
    public static int biSearchv2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // arr{1,2,3,4,5} ==> 1 + (5 - 1) / 2 ===> 1 + 4 / 2 = 2.5 ==> 3
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return right = mid - 1;
            } else if (arr[mid] < target) {
                return left = mid + 1;
            }
        }
        return -1;
    }

    public static int deleteDuplicates(int[] nums, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                temp[j++] = nums[i];
            }
        }
        temp[j++] = nums[n - 1];
        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }
        return j;
    }

    public static void printUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void findSecondSmaller(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }

    //or with sort (selection sort)
    public static int findSecondSmaller2(int[] arr) {
        int t;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }

        }
        return arr[1];
    }

    public static void identifyEvenElemInTwoArrs(int[] first, int[] second) {
        int[] third = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first[i] % 2 == 0) {
                third[i] = first[i];
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i] % 2 == 0) {
                third[i] = second[i];
            }
        }
        System.out.println(Arrays.toString(third));
    }

    public static void identifyOddElemInTwoArrs(int[] first, int[] second) {
        int[] third = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first[i] % 2 == 1) {
                third[i] = first[i];
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i] % 2 == 1) {
                third[i] = second[i];
            }
        }
        System.out.println(Arrays.toString(third));
    }

    public static void findCommon(int[] first, int[] second) {
        int[] third = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    //third[i] = first[i] + second[i];
                    //System.out.println(first[i]);
                    third[i] = second[j];
                    //System.out.print("Common Elements are: " + "{" + second[j] + "}");
                }
            }
        }
        System.out.println(Arrays.toString(third));
    }

    public static int find2ndLargest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr[arr.length - 2];
    }

    public static void missingNum(int[] arr) {
        Arrays.sort(arr);
        int d = 0;
        int miss = 0;
        int min = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            d = arr[i + 1] - arr[i];
            if (min > d) {
                min = d;
            }

        }
        d = min;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > d) {
                miss = arr[i] + d;
                break;
            }
        }
        System.out.println(miss);
    }

    //quicksort
    public static void quickSort(int[] arr, int firstIndex, int lastIndex) {
        int pivot = 0;
        int temp = 0;
        int i, j = 0;
        if (firstIndex < lastIndex) {
            pivot = firstIndex;
            i = firstIndex;
            j = lastIndex;

            while (i < j) {

                while (arr[i] <= arr[pivot] && i < lastIndex) {
                    i = i + 1; //ξεκιναει απο την αρχη και παει προς το τελος (ψαχνει να βρει το πρωτο στοιχειο που ειναι μεγαλυτερο απο το Pivot. Αυτο το στοιχειο βρικσεται σε λαθος θεση
                }
                while (arr[j] > arr[pivot]) { //κινειται απο το τελος προς την αρχη
                    j = j - 1;
                }
                if (i < j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            temp = arr[pivot];
            arr[pivot] = arr[j];
            arr[j] = temp;

            quickSort(arr, firstIndex, j - 1);
            quickSort(arr, j + 1, lastIndex);
        }
    }

    public static void bubbleSort(int[] arr) {  //descending order
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i]);
        }

    }

    public static void bubbleSortAsc(int[] arr) {  //ascending order
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSortDesc(int[] arr) { //descending
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSortAsc(int[] arr) { //ascending
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int binaryS(int[] arr, int l, int r, int x) {
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1; // No element found
    }

    public static int linearS(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                x = i;
                break;
            }
        }
        return x;
    }

    public static void movingAllZeroesAtEnd(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void print2DArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Εκτυπώνει την αρχική αγκύλη "[" στην ίδια γραμμή
            System.out.print("[");

            for (int j = 0; j < arr[i].length; j++) {
                // 1. Εκτυπώνει το στοιχείο
                System.out.print(arr[i][j]);

                // 2. Εκτυπώνει κόμμα και κενό ΜΟΝΟ αν ΔΕΝ είναι το τελευταίο στοιχείο της γραμμής
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }

            // 3. Εκτυπώνει την τελική αγκύλη "]"
            System.out.print("]");

            // 4. Ελέγχει αν είναι η τελευταία γραμμή.
            // Αν ΔΕΝ είναι η τελευταία γραμμή, προσθέτει κόμμα και ΑΛΛΑΖΕΙ γραμμή.
            if (i < arr.length - 1) {
                System.out.println(", ");
            } else {
                // Αν είναι η τελευταία γραμμή, απλά αλλάζει γραμμή για το τέλος της εκτύπωσης
                System.out.println();
            }
        }
    }

    /// ////////>>>>>>>new set2 of exercises with Arrays >>>>>>>>>/////////////
    public static void occurencesOfNumber(int[] arr) {

        // 1. Εξωτερικός βρόχος: Επιλέγει έναν αριθμό για καταμέτρηση (το "υποψήφιο" στοιχείο)
        for (int i = 0; i < arr.length; i++) {

            // --- Έλεγχος για διπλομέτρηση (Το βασικό βήμα) ---
            // Ελέγχουμε αν το arr[i] έχει ήδη εμφανιστεί σε προηγούμενη θέση (j < i)
            boolean alreadyCounted = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    alreadyCounted = true;
                    break; // Αν βρεθεί, σταματάμε τον έλεγχο
                }
            }

            // Αν έχει ήδη μετρηθεί σε προηγούμενο βήμα, το αγνοούμε και προχωράμε στο επόμενο i
            if (alreadyCounted) {
                continue;
            }

            // 2. Εσωτερικός βρόχος: Μετράει τις συνολικές εμφανίσεις του arr[i] σε όλο τον πίνακα
            int currentCount = 1; // Ξεκινάμε με 1, καθώς μετράμε τον εαυτό του (arr[i])

            // Ξεκινάμε από το i + 1 για να αποφύγουμε να μετράμε ξανά το arr[i]
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] == arr[k]) {
                    currentCount++;
                }
            }
            // 3. Εκτύπωση αποτελέσματος: Εκτυπώνουμε μόνο αν ο αριθμός εμφανίστηκε περισσότερες από μία φορά
            if (currentCount > 1) {
                System.out.println(currentCount + " φορές φάνηκε το " + arr[i]);
            }
        }
    }

    public static void occurencesOfSpecificNumber(int[] arr, int x) {
        int countOcc = 0;
        int numOfOcc = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                numOfOcc = arr[i];
                countOcc++;
            }
        }
        System.out.println("Number of occurences: " + countOcc + " of number " + numOfOcc);
    }

    public static void occOfSpecNumList(List<Integer> list, Integer num) {
        Integer countOcc = 0;
        Integer numOfOcc = 0;
        for (Integer element : list) {
            if (element.equals(num)) {
                numOfOcc = element;
                countOcc++;
            }
        }
        System.out.println("Number of occurences: " + countOcc + " of number " + numOfOcc);
    }

    public static void occHashMap(List<Integer> numbers) {
        // 1. Δημιουργία χάρτη (Τοποθετούμε εδώ τα αποτελέσματα)
        HashMap<Integer, Integer> map = new HashMap<>();
        // 2. Διάτρεξη της ΛΙΣΤΑΣ των αριθμών (όχι του χάρτη)
        for (Integer number : numbers) {

            // 3. Παίρνουμε τον τρέχοντα μετρητή του αριθμού
            Integer count = map.get(number);

            if (count == null) {
                // Ο αριθμός ΔΕΝ υπάρχει ακόμα (1η εμφάνιση)
                map.put(number, 1);
            } else {
                // Ο αριθμός ΥΠΑΡΧΕΙ, αυξάνουμε τον μετρητή
                map.put(number, count + 1);
            }
        }
        // 4. (Προαιρετικό) Εκτύπωση αποτελεσμάτων
        System.out.println("Occurrences: " + map);
    }

    public static void reverseArray2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void reverseArrUsingList(Integer[] arr) {
        List<Integer> l = Arrays.asList(arr);
        Collections.reverse(l);
        System.out.println(l);
    }

    private static void findLargerstArrElem2(int[] maxArr2) {
        int max = 0;
        for (int i = 0; i < maxArr2.length; i++) {
            if (max < maxArr2[i]) {
                max = maxArr2[i];
            }
        }
        System.out.println(max);
    }

    private static void findLargerstElemL(List<Integer> list) {
        int max = 0;
        for (Integer element : list) {
            if (max < element) {
                max = element;
            }
        }

        System.out.println(max);
    }

    private static void findLargerstElemMap(HashMap<String, Integer> map2) {
        int max = Collections.max(map2.values());
        System.out.println(max);
    }

    public static void averageArrays(int[] arr) {
        int sum = 0;
        float avg = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum / arr.length;
        System.out.println(avg);
    }

    public static void averageArraysL(List<Integer> l) {
        int sum = 0;
        float avg = 0;
        for (Integer nums : l) {
            sum += nums;
        }
        avg = sum / l.size();
        System.out.println(avg);
    }

    public static void avgMap(HashMap<String, Integer> map2) {
        Integer sum = 0;
        Double avg = 0.0;
        for (Integer elem : map2.values()) {
            sum += elem;
        }
        avg = (double) sum / map2.size();
        System.out.println(avg);
    }

    public static void elementWise() {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        System.out.println("give arrays 1 and 2 size: ");
        size = sc.nextInt();
        int[] arr1 = new int[size]; //
        int[] arr2 = new int[size]; //
        int[] product = new int[size];
        System.out.println("Enter " + size + " elements for Array 1:");
        for (int i = 0; i < size; i++) {
            System.out.print("Array 1 - Element " + (i + 1) + ": ");
            arr1[i] = sc.nextInt(); //  Διάβασμα τιμής
        }
        //
        System.out.println("Enter " + size + " elements for Array 2:");
        for (int i = 0; i < size; i++) {
            System.out.print("Array 2 - Element " + (i + 1) + ": ");
            arr2[i] = sc.nextInt(); //  Διάβασμα τιμής
        }
        for (int i = 0; i < size; i++) {
            product[i] = arr1[i] * arr2[i];
        }
        System.out.println(Arrays.toString(product));
        //sc.close();
    }

    public static void elementWishList() {
        Scanner sc = new Scanner(System.in);
        int size = 0;

        System.out.println("Δώσε το μέγεθος της 1ης και της 2ης λίστας: ");
        size = sc.nextInt();

        // Οι λίστες αρχικά είναι άδειες (size = 0). Θα χρησιμοποιήσουμε το .add()
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Η λίστα αποτελέσματος. Δεν χρειάζεται να την αρχικοποιήσουμε με μέγεθος.
        List<Integer> list3Product = new ArrayList<>();

        // --- ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΣΤΗ LISTA 1 ---
        System.out.println("Εισαγωγή " + size + " στοιχείων για τη λίστα 1:");
        // Χρησιμοποιούμε κλασικό for-loop για να επαναλάβουμε size φορές
        for (int i = 0; i < size; i++) {
            System.out.print("Λίστα 1 - Στοιχείο " + (i + 1) + ": ");
            int elem = sc.nextInt(); // Διάβασμα τιμής
            list1.add(elem); // <-- ΣΩΣΤΟ: Προσθήκη του στοιχείου στη λίστα
        }

        // --- ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΣΤΗ LISTA 2 ---
        System.out.println("Εισαγωγή " + size + " στοιχείων για τη λίστα 2:");
        // Χρησιμοποιούμε κλασικό for-loop για να επαναλάβουμε size φορές
        for (int i = 0; i < size; i++) {
            System.out.print("Λίστα 2 - Στοιχείο " + (i + 1) + ": ");
            int elem = sc.nextInt(); // Διάβασμα τιμής
            list2.add(elem); // <-- ΣΩΣΤΟ: Προσθήκη του στοιχείου στη λίστα
        }

        // --- ΥΠΟΛΟΓΙΣΜΟΣ ΠΟΛΛΑΠΛΑΣΙΑΣΜΟΥ ΚΑΤΑ ΣΤΟΙΧΕΙΟ ---
        // Χρησιμοποιούμε κλασικό for-loop με δείκτη για πρόσβαση στα στοιχεία
        for (int i = 0; i < size; i++) {
            // Παίρνουμε το i-οστό στοιχείο από κάθε λίστα
            int product = list1.get(i) * list2.get(i);
            // Προσθέτουμε το αποτέλεσμα στη λίστα αποτελεσμάτων
            list3Product.add(product); // <-- ΣΩΣΤΟ: Προσθήκη του αποτελέσματος
        }

        // --- ΕΚΤΥΠΩΣΗ ---
        System.out.println("Λίστα 1: " + list1);
        System.out.println("Λίστα 2: " + list2);
        System.out.println("Αποτέλεσμα Πολλαπλασιασμού: " + list3Product);

        //sc.close();
    }

    public static void elementWiseMap() {
        Scanner sc = new Scanner(System.in);
        int size = 0;

        // Καλούμε τον Scanner μόνο μία φορά και δεν τον κλείνουμε

        try {
            System.out.println("Δώσε το πλήθος των ζευγών (Key-Value) για τους Χάρτες: ");
            size = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Λάθος είσοδος. Πρέπει να δώσεις ακέραιο.");
            // sc.close(); // Δεν το κλείνουμε
            return;
        }

        // Δημιουργία των HashMaps
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3Product = new HashMap<>(); // Ο χάρτης αποτελέσματος

        // --- ΒΟΗΘΗΤΙΚΟΣ ΠΙΝΑΚΑΣ ΓΙΑ ΤΑ ΚΛΕΙΔΙΑ ---
        // Χρειάζεται για να κρατήσουμε τα κλειδιά με τη σειρά που εισήχθησαν
        // και να εγγυηθούμε ότι θα υπάρχουν και στους δύο χάρτες.
        String[] keys = new String[size];

        // --- ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΣΤΟΝ MAP 1 ---
        System.out.println("\n--- Εισαγωγή " + size + " ζευγών για τον Map 1 ---");
        // Καταναλώνουμε το newline μετά το nextInt()
        sc.nextLine();

        for (int i = 0; i < size; i++) {
            System.out.print("Map 1 - Κλειδί " + (i + 1) + " (π.χ. 'A'): ");
            String key = sc.nextLine();

            System.out.print("Map 1 - Τιμή " + (i + 1) + " (ακέραιος): ");
            int value = sc.nextInt();
            sc.nextLine(); // Καταναλώνουμε το newline

            map1.put(key, value); // <-- ΣΩΣΤΟ: Βάζουμε Key και Value
            keys[i] = key; // Αποθηκεύουμε το κλειδί
        }

        // --- ΕΙΣΑΓΩΓΗ ΣΤΟΙΧΕΙΩΝ ΣΤΟΝ MAP 2 ---
        System.out.println("\n--- Εισαγωγή " + size + " ζευγών για τον Map 2 ---");
        for (int i = 0; i < size; i++) {
            // Για ευκολία, ζητάμε την τιμή με το ίδιο κλειδί που δόθηκε πριν.
            String key = keys[i];

            System.out.print("Map 2 - Τιμή για το Κλειδί '" + key + "': ");
            int value = sc.nextInt();
            sc.nextLine(); // Καταναλώνουμε το newline

            map2.put(key, value); // <-- ΣΩΣΤΟ: Βάζουμε Key και Value
        }

        // --- ΥΠΟΛΟΓΙΣΜΟΣ ΠΟΛΛΑΠΛΑΣΙΑΣΜΟΥ ΚΑΤΑ ΚΛΕΙΔΙ ---
        // Επαναλαμβάνουμε μόνο τα κλειδιά του map1 (τα οποία ξέρουμε ότι υπάρχουν και στο map2)
        for (String key : map1.keySet()) {
            // Παίρνουμε τις τιμές με βάση το κοινό ΚΛΕΙΔΙ
            Integer value1 = map1.get(key);
            Integer value2 = map2.get(key);

            // Έλεγχος για null values (αν τα κλειδιά ήταν διαφορετικά)
            if (value1 != null && value2 != null) {
                int product = value1 * value2;
                // Αποθηκεύουμε το αποτέλεσμα στον map3 με το ίδιο κλειδί
                map3Product.put(key, product);
            }
        }

        // --- ΕΚΤΥΠΩΣΗ ---
        System.out.println("\n--- Αποτελέσματα ---");
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Αποτέλεσμα Πολλαπλασιασμού (Map 3): " + map3Product);

        // sc.close(); // Δεν το κλείνουμε
    }

    public static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static int findSecondLrgL(List<Integer> l) {
        Collections.sort(l);
        return l.get(l.size() - 2);
    }

    public static void sumArrayElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("The sum of array elements are: " + sum);
    }

    public static void sumElemList(List<Integer> list) {
        int sum = 0;
        for (Integer elements : list) {
            sum += elements;
        }
        System.out.println("Sum of list elements:" + sum);
    }

    public static void sumMapElments(HashMap<String, Integer> map) {
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        System.out.println("Sum of map integer values:" + sum);
    }

    public static void sumOfTwoArraysElementWise(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }

    public static void sumOfTwoArraysElementWiseL(List<Integer> l1, List<Integer> l2) {
        Integer sum = 0;
        List<Integer> l3 = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            sum = l1.get(i) + l2.get(i);
            l3.add(sum);
        }
        System.out.println(l3);
    }

    public static HashMap<String, Integer> sumOfTwoArraysElementWiseM(
            HashMap<String, Integer> map1,
            HashMap<String, Integer> map2) {
        HashMap<String, Integer> mapResult = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value1 = entry.getValue();
            if (map2.containsKey(key)) {
                Integer value2 = map2.get(key);

                int sum = value1 + value2;
                mapResult.put(key, sum);
            }
        }
        return mapResult;
    }

    public static boolean isArrAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArrListAsc(List<Integer> lAsx) {
        for (int i = 0; i < lAsx.size() - 1; i++) {
            if (lAsx.get(i) > lAsx.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArrMapValueAsc(Map<Integer, Integer> map) {
        if (map.size() <= 1) {
            return true; // Ένα Map με 0 ή 1 στοιχείο θεωρείται ταξινομημένο.
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        Integer previousKey = iterator.next().getKey();
        while (iterator.hasNext()) {
            Integer currentKey = iterator.next().getKey();
            if (previousKey > currentKey) {
                return false;
            }
            previousKey = currentKey; //μετα το κάνω αυτό για να πάω στο επόμενο κλειδι του πινακα στην λουπα και να κανω την σύγκριση αν previousKey > currentKey
        }
        return true;
    }

    public static boolean isEvenArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isListEven(List<Integer> list) {
        for (Integer elem : list) {
            if (elem % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    /// /////// codeChef arrays exercices ///////////
    public static String checkCoupon(int n, int x, int y, int[] prices) {
        long save = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] >= y) {
                save += y;
            } else {
                save += prices[i];
            }
        }
        if (save > x) {
            return "COUPON";
        } else {
            return "NO COUPON";
        }
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0; // Μετράμε πόσα "σπασίματα" (αναστροφές) υπάρχουν.

        // Ο βρόχος τρέχει από 0 έως n-1.
        // Ελέγχουμε το ζεύγος (nums[i], nums[(i+1) % n])
        // Όταν i = n-1, ελέγχουμε το ζεύγος (nums[n-1], nums[0]),
        // το οποίο είναι το σημείο της περιστροφής.
        for (int i = 0; i < n; i++) {
            // Η σύγκριση γίνεται μεταξύ του τρέχοντος στοιχείου και του επόμενου (κυκλικά)
            if (nums[i] > nums[(i + 1) % n]) {  // ---> ελεγχω πχ αν εγινε περιστροφη σε εναν ηδη ταξινομημενο πινακα πχ {1,2,3,5,4} εδω θα ηταν count = 1 λόγω του 5 και 4 που περιστράφηκαν
                count++; // Βρήκαμε ένα "σπάσιμο" της ταξινόμησης.
            }
        }

        // Αν ο πίνακας ήταν αρχικά ταξινομημένος, ο αριθμός των σπασιμάτων πρέπει να είναι:
        // 0 (Αν k=0, δηλαδή είναι ήδη ταξινομημένος)
        // 1 (Αν k>0, δηλαδή έχει περιστραφεί μία φορά)
        return count <= 1;
    }

    //Cost of Groceries exercice
    public int compute(int n, int x, int[] a, int[] b) {
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= x) {
                totalCost += b[i];
            }

        }
        return totalCost;
    }

    public static void reverseOrderArr(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void searchArrayOfInt(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("item exists: " + arr[i]);
            }
        }

    }

    //or
    // Η  μέθοδος βελτιωμένη
    public static void searchArrayOfInt2(int[] arr, int target) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                found = true;
                break; // Σταματάμε μόλις το βρούμε
            }
        }

        if (found) {
            System.out.println("The number " + target + " exists in the array.");
        } else {
            System.out.println("The number " + target + " does NOT exist in the array.");
        }
    }

    public static void evenNumsInArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print("Even nums are: " + arr[i]);
            }
        }
    }

    public static void posAndNegNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.print("Positive nums are: " + arr[i]);
            } else if (arr[i] < 0) {
                System.out.println("Negative nums are: " + arr[i]);
            }
        }
    }

    public static void bannerMimicUnix(String text) {
        int[] asciiCodes = new int[text.length()];

        // Μετατροπή κειμένου σε κωδικούς ASCII
        for (int i = 0; i < text.length(); i++) {
            asciiCodes[i] = (int) text.charAt(i);
        }

        int letterSize = 7;
        int asciiNum = 32;
        int letterCount = 0;
        int counter = 0;
        int lineCount = 0;
        boolean letterFound = false;

        String[] result = new String[letterSize];
        // Αρχικοποίηση του πίνακα result με κενά strings για να αποφύγουμε το "null"
        for (int k = 0; k < result.length; k++) result[k] = "";

        for (int i = 0; i < asciiCodes.length; i++) {
            for (int row = 0; row < letters.length; row++) {

                // Reset για κάθε χαρακτήρα
                if (letterCount == 8) {
                    row += letterSize - 1;
                    letterCount = 0;
                    counter = 0;
                }

                while ((!letterFound) && (letterCount < 8)) {
                    if (asciiCodes[i] == asciiNum)
                        letterFound = true;
                    else {
                        asciiNum++;
                        counter += letterSize;
                        letterCount++;
                    }
                }

                if ((letterFound) && (lineCount < 7)) {
                    // Προσθήκη του segment του γράμματος στη σωστή γραμμή
                    result[lineCount] += letters[row].substring(counter, counter + letterSize);
                    lineCount++;
                }
            }

            // Reset μεταβλητών για τον επόμενο χαρακτήρα του 'text'
            counter = 0;
            lineCount = 0;
            letterCount = 0;
            asciiNum = 32;
            letterFound = false;
        }

        // Εκτύπωση του τελικού banner
        for (String line : result) {
            System.out.println(line);
        }
    }

    public static void bubblesort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        System.out.println("sorted array: " + Arrays.toString(arr));
    }

    public static void arr2D(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        int scores = 0;
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Σειρά " + (i + 1) + ", Θέση " + (j + 1) + ": ");
                arr[i][j] = sc.nextInt();
                if (i == 0) {
                    sum1 += arr[i][j];
                } else {
                    sum2 += arr[i][j];
                }
            }
        }
        System.out.println("\n--- Ο ΠΙΝΑΚΑΣ SCORE ---");
        for (int i = 0; i < 2; i++) {
            System.out.print("Row " + (i + 1) + ": | "); // Αρχή γραμμής
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t"); // \t για ομοιόμορφες αποστάσεις (Tab)
            }
            System.out.println("|");
        }

        System.out.println("Mean group1: " + sum1 / 5);
        System.out.println("Mean group2: " + sum2 / 5);
        ;
    }

    public static void arrChar2D(char[][] arr) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 70; j++) {
                System.out.print('X' + "\t");
            }
            System.out.println("|");
        }
    }

    public static void sortNumeric(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortStringArr(String[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sumValArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public static void printDashes2() {
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '-';
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void arrayMeanV2(int[] arr) {
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            avg = sum / arr.length;
        }
        System.out.println(avg);
    }

    public static void findValueArr(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void findidx(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                System.out.println("index is " + i + " and the element is the number: " + arr[i]);
            }
        }
    }

    public static void removeElem(int[] arr, int elem) {
        elem = 2;
        int[] removedElemArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != elem) {
                removedElemArr[j] = arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(removedElemArr));
    }

    //or more modern way to do it:
    /*
    public static void removeElem(int[] arr, int elem){
        elem = 2;
        int[] removedElemArr = new int[arr.length - 1];
        int[] removedElemArr = Arrays.stream(arr)
                     .filter(val -> val != elem)
                     .toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(removedElemArr));
    }
     */
    public static int[] copyArrayV2(int[] source) {
        // 1. Δημιουργούμε ένα νέο array με το ίδιο μήκος
        int[] destination = new int[source.length];

        // 2. Iteration (Επανάληψη)
        for (int i = 0; i < source.length; i++) {
            // ΔΕΞΙΑ είναι η πηγή, ΑΡΙΣΤΕΡΑ ο προορισμός
            destination[i] = source[i];
        }

        return destination;
    }

    public static void insertElement(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            arr[2] = elem;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void findMinAndMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[j] < min) {
                min = arr[j];
            }
            j++;
        }
        System.out.println("Max is: " + max + " and min is: " + min);
    }

    public static void reverseArr(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void findDupli(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate values are:" + arr[j]);
                }
            }
        }
    }

    public static void findCommonElems(String[] arr1, String[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    System.out.println("Common elements are: " + arr2[i]);
                    //break;
                }
            }

        }
    }

    public static void findCommonElemsInt(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println("Common elements are: " + arr2[i]);
                    //break;  ΓΙΑ ΝΑ ΤΣΕΚΑΡΩ ΓΙΑ ΔΙΠΛΟΤΥΠΑ αν θελω βαζω break
                }
            }
        }
    }

    public static void removeDupl(int[] arr) {
        // Το Set κρατάει μόνο μοναδικές τιμές
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        System.out.println("unique elements: " + set);

    }

    public static int findSecLarv2(int[] arr) {    //selection sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr[arr.length - 2];
    }

    public static int findSecSmallv2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) { //selection sort
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[2];
    }

    public static int findSecSmallBubbleS(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  //bubblesort
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[2];
    }

    public static void add2Matrices(int[] arr, int[] arr2) {
        if (arr.length != arr2.length) {
            System.out.println("Σφάλμα: Οι πίνακες πρέπει να έχουν το ίδιο μέγεθος!");
            return;
        }
        int n = arr.length;
        int[] added = new int[n];
        for (int i = 0; i < n; i++) {
            added[i] = arr[i] + arr2[i];
        }
        System.out.println(Arrays.toString(added));
    }

    public static void convertArrToList(Integer[] arr) {
        System.out.println("Option1 as array printing: " + Arrays.toString(arr));
        System.out.println("Option 2 print as list: " + Arrays.asList(arr));
    }

    public static void convertListToArr(List<Integer> list) {
        //Integer[] arr = list.toArray(new Integer[list.size()]);
        Integer[] arr = list.toArray(new Integer[0]); //πιο μοντέρνα συνταξη
        System.out.println(Arrays.toString(arr));
    }

    public static void findPairSum(int[] arr, int specSum) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.print(" Pairs in the array of specific sum are: " + arr[i]);
            if (sum == specSum) {
                break;
            }
        }
    }

    public static boolean testEqualityOfArrs(int[] arr, int[] arr2) {
        // 1. Έλεγχος αν δείχνουν στην ίδια θέση μνήμης
        if (arr == arr2) return true;

        // 2. Έλεγχος αν κάποιος είναι null ή έχουν διαφορετικό μήκος
        if (arr == null || arr2 == null || arr.length != arr2.length) {
            System.out.println("Arrays are not equal (different size or null)");
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                System.out.println("Arrays are not equal");
                return false;
            }
        }
        return true;
    }

    public static int findMissingN(int[] arr, int n) {
        // 1. Το άθροισμα που ΘΑ ΕΠΡΕΠΕ να έχουμε για n=4:
        // Τύπος: (n * (n + 1)) / 2  =>  (4 * 5) / 2 = 10     --> int expectedSum = (n * (n-1)) / 2;
        int expectedSum = (n * (n + 1)) / 2;

        // 2. Το άθροισμα που ΕΧΟΥΜΕ στον πίνακα {1, 2, 4}:
        // 1 + 2 + 4 = 7
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // 3. Η διαφορά: 10 - 7 = 3
        return expectedSum - actualSum;
    }

    public static void findCommElement3Arrs(int[] arr1, int[] arr2, int[] arr3) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.println(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        System.out.println();
    }

    public static void moveZeroesOnTheRight(int[] arr) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroFoundAt++] = arr[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void findEvOddNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print("Odd numbers are: " + arr[i]);
            } else {
                System.out.println("Even numbers are: " + arr[i]);
            }
        }
    }

    public static int larAndSmallDiff(int[] arr) {
        if (arr.length < 1) {
            return -1;
        }
        int max = 0;
        int min = 0;
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min;
    }

    public static void avgExceptLargeAndSmallestVals(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Ο πίνακας πρέπει να έχει τουλάχιστον 3 στοιχεία.");
            return;
        }
        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int newSum = sum - (max + min);
        // Διαιρούμε με το πλήθος των υπόλοιπων στοιχείων (length - 2)
        // Κάνουμε (double) για να μην χάσουμε τα δεκαδικά
        double avg = (double) newSum / (arr.length - 2);
        System.out.println("Max: " + max + ", Min: " + min);
        System.out.println("Average (excluding max/min): " + avg);
    }

    public static boolean findNonZeroesAndOnes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 || arr[i] == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean tenSum(int[] arr) {
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == 10){
//                sum+=arr[i];
//            }
//
//            if(sum == 30){
//                return true;
//            }
//
//        }
//        return false;
        int sum = 0;

        // 1. Πρώτα διατρέχουμε όλο τον πίνακα και αθροίζουμε τα 10ρια
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 10) {
                sum += 10;
            }
        }

        // 2. Μόνο αφού τελειώσει το loop, ελέγχουμε αν το σύνολο είναι 30
        return sum == 30;
    }

    public static boolean containSpecElements(int[] arr) {
        int spec1 = 65, spec2 = 75;
        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == spec1) {
                found1 = true;
            }
            if (arr[i] == spec2) {
                found2 = true;
            }
        }
        // Επιστρέφει true μόνο αν βρέθηκαν και τα δύο
        return found1 && found2;
    }

    //επιστροφη μηκους πινακα
    public static int remoDupl(int[] arr, int[] newArr) {
        if (arr.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            // Αν βρούμε ένα στοιχείο που είναι διαφορετικό από το τρέχον μοναδικό
            if (arr[j] != arr[i]) {
                i++;           // Προχωράμε στη επόμενη θέση
                arr[i] = arr[j]; // Τοποθετούμε εκεί το νέο μοναδικό στοιχείο
            }
        }
        // Το νέο μήκος είναι το i + 1 (γιατί ο πίνακας ξεκινάει από το 0)
        return i + 1;
    }

    //επιστροφη νεου πινακα χωρις διπλοτυπα
    public static int[] rempDupl2(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        // 1. Βρίσκουμε πρώτα πόσα είναι τα μοναδικά στοιχεία
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
        }
        // 2. Φτιάχνουμε τον νέο πίνακα με το σωστό μέγεθος
        int[] newArr = new int[count];
        newArr[0] = arr[0]; // Το πρώτο στοιχείο είναι πάντα μοναδικό
        int index = 1; //ξεκινάω απο το 1ο Index αφου ειπαμε απο πανω οτι το πρωτο στοιχειο ειναι παντα μοναδικο

        // 3. Γεμίζουμε τον νέο πίνακα
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                newArr[index] = arr[i + 1];
                index++;
            }

        }

        return newArr;
    }

    public static int consecutiveLength(int[] arr) {
        if (arr.length == 0) return 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // BUBBLE Sort Συγκρίνουμε γειτονικά στοιχεία
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int maxLen = 1;     // Η μεγαλύτερη ακολουθία που βρήκαμε
        int currentLen = 1; // Η τρέχουσα ακολουθία που μετράμε

        for (int i = 0; i < arr.length - 1; i++) {
            // Αν το επόμενο είναι ακριβώς +1 από το τρέχον (π.χ. 1 και 2)
            if (arr[i + 1] == arr[i] + 1) {
                currentLen++;
            }
            // Αν είναι ίδια (π.χ. 2 και 2), τα αγνοούμε και συνεχίζουμε
            else if (arr[i + 1] == arr[i]) {
                continue;
            } else { // Αν διακοπεί η σειρά, μηδενίζουμε τον τρέχοντα μετρητή
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
            }
        }
        // Επιστρέφουμε το μέγιστο ανάμεσα στο τελευταίο currentLen και το maxLen
        return Math.max(maxLen, currentLen);
    }

    public static void sumTwoElem(int[] arr, int target) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair found " + arr[i] + " - " + arr[j] + " = " + target);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No pair found that sums this target --> " + target);
        }
    }

    public static void uniqueTripletsSum(int[] arr, int target) {
        // 1. Ταξινομούμε το array για να ικανοποιείται εύκολα το x <= y <= z
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // Ελέγχουμε αν το άθροισμα της συγκεκριμένης τριάδας ισούται με το target
                    if (arr[i] + arr[j] + arr[k] == target) {
                        System.out.println("[" + arr[i] + ", " + arr[j] + ", " + arr[k] + "]");
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("no triplet much the target");
        }
    }

    public static void antiDiagonals(int[][] arr) {
        int n = arr.length;
        //πρεπει να βρω ολες τις αντιδιαγωνιους οχι μονο την δευτερεουσα διαγωνιο
        int numDiagonals = 2 * n - 1;
        // Δημιουργούμε μια λίστα από λίστες για να αποθηκεύσουμε το αποτέλεσμα
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numDiagonals; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalIndex = i + j;
                result.get(diagonalIndex).add(arr[i][j]);
            }
        }
        System.out.println(result);
    }

    public static void majorityOfDuplicates(int[] arr) {
        int n = arr.length;
        int majorityElem = 0;
        int majorElem = 0;

        for (int i = 0; i < arr.length; i++) { //ΚΑΚΙΑ ΠΡΑΚΤΙΚΗ ΟΜΩς με brute force -- δες το απο κατω παραδειγμα (πιο αποδοτικο)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate --> " + arr[j]);
                    majorityElem++;
                    if (majorityElem > n / 2) {
                        majorElem = arr[j];
                    }
                }
            }

        }
        System.out.println("Majority Element is the : " + majorElem);
    }

    //or με Boyer-Moore Voting Algorithm.
    public static void majorityOfDuplicatesv2(int[] arr) {
        int n = arr.length;
        int candidate = 0;
        int count = 0;

        // 1ο Βήμα: Εύρεση υποψηφίου (Boyer-Moore Voting)
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 2ο Βήμα: Επαλήθευση (γιατί ο αλγόριθμος επιστρέφει πάντα κάτι)
        int finalCount = 0;
        for (int num : arr) {
            if (num == candidate) {
                finalCount++;
            }
        }

        if (finalCount > n / 2) {
            System.out.println("Majority element is --> " + candidate);
        } else {
            System.out.println("No majority element found.");
        }
    }

    public static void printLeaders(int[] arr) {
        int n = arr.length;
        if (n == 0) return;
        // Το τελευταίο στοιχείο είναι πάντα leader
        int currentMax = arr[n - 1]; //πχ {1,2,3,4,5,7} το 7 ειναι leader αφου δεν υπαρχει αλλο δεξια του
        //μετα σαρωνω απο τα δεξια προς τα αριστερα -- επισης n-2 επειδη ξεκιναω απο το προτελευταιο μετα αφου απο πανω το ειδα το τελευταιο
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
                System.out.println("Leader: " + currentMax);
            }
        }
        System.out.println("Leader: " + currentMax);
    }

    public static void findSumClosestToZero(int[] arr) { //Μια πιο αποδοτική προσέγγιση ($O(n \log n)$)
        if (arr.length < 2) return;

        int minSum = arr[0] + arr[1];
        int elem1 = arr[0];
        int elem2 = arr[1];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                // Αν η απόλυτη τιμή του τρέχοντος αθροίσματος είναι μικρότερη
                // από την απόλυτη τιμή του minSum, έχουμε βρει νέο "καλύτερο" ζευγάρι
                if (Math.abs(currentSum) < Math.abs(minSum)) {
                    minSum = currentSum;
                    elem1 = arr[i];
                    elem2 = arr[j];

                }
            }
        }
        System.out.println("Sum elements closest to zero" + elem1 + " and " + elem2);
    }

    public static void smallestAnd2ndSmallest(int[] arr) {
        if (arr.length < 2) return;
        boolean foundSmallest = true;
        boolean found2ndSmallest = true;
        for (int i = 0; i < arr.length; i++) {  //αρχικα σορτάρω
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Smallest is: " + arr[0] + "\n");
        System.out.println("Smallest is: " + arr[1]);
    }

    public static void seggregateZerosAndOnes(int[] arr) {
        Arrays.sort(arr); //Arrays.sort() έχει πολυπλοκότητα $O(n \log n)$
        System.out.println(Arrays.toString(arr));
    }

    //οr v2 σε γραμμικο χρονο O(n)
    public static void seggregateZerosAndOnesv2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    //οr v3 σε (πιο κομψο με 2 pointers) γραμμικο χρονο O(n)
    public static void seggregateZerosAndOnesv3(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] == 0 && left < right) {
                left++;
            }
            while (arr[right] == 1 && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void find4ElemsForSum(int[] arr, int elem) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  //πολυπλοκότητα O(n^4).
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int z = k + 1; z < arr.length; z++) {
                        sum = arr[i] + arr[j] + arr[k] + arr[z];
                        if (sum == elem) {
                            System.out.println("the 4 elements that sums to " + elem + " is " + arr[i] + " |" + arr[j] + " |" + arr[k] + " |" + arr[z]);

                        }
                    }
                }
            }
        }
    }

    //οr v2 Βελτιωμένη Λύση O(n^3)
    public static void find4ElemsForSumv2(int[] arr, int target) {
        // 1. Ταξινομούμε τον πίνακα από τον μικρότερο στον μεγαλύτερο.
        // Αυτό είναι το κλειδί για να ξέρουμε αν πρέπει να αυξήσουμε ή να μειώσουμε το άθροισμα.
        Arrays.sort(arr);
        int n = arr.length;

        //  Πρώτος βρόχος: Διαλέγει τον 1ο αριθμό (i)
        //Ο δείκτης i είναι ο πρώτος από τους τέσσερις. Μετά από αυτόν, πρέπει οπωσδήποτε να υπάρχουν τουλάχιστον άλλοι 3 αριθμοί για να συμπληρωθεί η τετράδα (j, left, right).
        for (int i = 0; i < n - 3; i++) {
            // Δεύτερος βρόχος: Διαλέγει τον 2ο αριθμό (j)
            //Ο δείκτης j είναι ο δεύτερος αριθμός. Μετά από αυτόν, πρέπει να υπάρχουν τουλάχιστον άλλοι 2 αριθμοί (left και right).
            for (int j = i + 1; j < n - 2; j++) {
                // Ορίζουμε τον "αριστερό" δείκτη αμέσως μετά τον j
                int left = j + 1;
                // Ορίζουμε τον "δεξί" δείκτη στο τέρμα του πίνακα
                int right = n - 1;

                // Όσο οι δύο δείκτες δεν έχουν συναντηθεί στη μέση
                while (left < right) {
                    // Υπολογίζουμε το άθροισμα των 4 θέσεων που δείχνουμε τώρα
                    int currentSum = arr[i] + arr[j] + arr[left] + arr[right];
                    // ΠΕΡΙΠΤΩΣΗ Α: Βρήκαμε το target!
                    if (currentSum == target) {
                        System.out.println("Found: " + arr[i] + ", " + arr[j] +
                                ", " + arr[left] + ", " + arr[right]);
                        // Μετακινούμε και τους δύο για να βρούμε τον επόμενο πιθανό συνδυασμό
                        left++;
                        right--;

                    } else if (currentSum < target) {  // ΠΕΡΙΠΤΩΣΗ Β: Το άθροισμα είναι μικρότερο από αυτό που θέλουμε
                        // Αφού ο πίνακας είναι ταξινομημένος, για να μεγαλώσει το άθροισμα
                        // πρέπει να πάμε τον αριστερό δείκτη σε μεγαλύτερο νούμερο (δεξιά)
                        left++;
                    } else { // ΠΕΡΙΠΤΩΣΗ Γ: Το άθροισμα είναι μεγαλύτερο από αυτό που θέλουμε
                        // Για να μικρύνει το άθροισμα, πάμε τον δεξί δείκτη
                        // σε μικρότερο νούμερο (προς τα αριστερά)
                        right--;
                    }
                }
            }
        }
    }

    public static void possibleTriangles(int[] arr) {  // brute force O(n^3)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k] && arr[i] + arr[k] > arr[j] && arr[j] + arr[k] > arr[i]) {
                        System.out.println("combination of possible triangles are: " + arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }

    //Ταξινόμηση + Δύο Δείκτες O(n^2)
    public static int possibleTrianglesv2(int[] arr) {


//        for(int i = 0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                if(arr[i] > arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);
        // 2. Το i είναι η μεγαλύτερη πλευρά (c)
        // Ξεκινάμε από το τέλος προς την αρχή
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            // 3. Χρήση δύο δεικτών για τις πλευρές a και b
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // Αν arr[left] + arr[right] > arr[i], τότε επειδή το array είναι
                    // ταξινομημένο, και όλα τα στοιχεία από το 'left' μέχρι το 'right-1'
                    // θα ικανοποιούν τη συνθήκη αν προστεθούν στο arr[right].
                    count += (right - left);

                    // Μετακινούμε το right αριστερά για να βρούμε τον επόμενο συνδυασμό
                    right--;
                } else {
                    // Το άθροισμα είναι μικρό, χρειαζόμαστε μεγαλύτερο 'left'
                    left++;
                }
            }
        }
        return count;
    }

    public static void cyclicallyRotate(int[] arr) {
        if (arr.length <= 1) return; // Αν το array είναι άδειο ή έχει 1 στοιχείο
        int i = 0;

        int n = arr.length - 1;
        int lastElement = arr[n - 1];
        for (i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];

        }
        arr[0] = lastElement;
        System.out.println(Arrays.toString(arr));
    }

    public static void pairSpecificSum(int[] arr, int targetSum) { // it is already sorted and rotated the array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (targetSum == sum) {
                    System.out.println("Pair of sum is: " + arr[i] + " and " + arr[j]);
                    return;
                }
            }
        }
        System.out.println("No pair found");
    }

    //or pairSpecificSum --> findPairOptimized O(n) with two pointers      //ΞΑΝΑ:
    public static boolean findPairOptimized(int[] arr, int targetSum) {
        int n = arr.length;
        int i;
        // 1. Βρες το σημείο περιστροφής (το μεγαλύτερο στοιχείο)
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) break;
        }

        int low = (i + 1) % n; // Ο δείκτης του μικρότερου στοιχείου  //βαζουμε το %n για να μην σκαει ArrayIndexOutOfBounds
        int high = i;          // Ο δείκτης του μεγαλύτερου στοιχείου

        while (low != high) {
            if (arr[low] + arr[high] == targetSum) return true;

            if (arr[low] + arr[high] < targetSum)
                low = (low + 1) % n; // Κινήσου προς μεγαλύτερες τιμές  //%n χρηση επειδη πχ αν ο πινακας ειναι 0,1,2,3,4 και κανω low + 1 ==> 4 + 1 = 5 θα σκασει ενω αν ειναι (4 + 1) % 5 = 5 % 5 = 0 και μας γυρναει αυτοματα στην αρχη
            else
                high = (n + high - 1) % n; // Κινήσου προς μικρότερες τιμές  // εδω μας παει στο τελευταιο στοιχειο αυτοματα (με ιδιο πινακα με πανω που εχω πχ  0,1,2,3,4 ===> θα ειναι (5 + 0 -1) % 5 δηλαδη 4 % 5 = 4 που ειναι το τελευταιο στοιχειο
        }
        return false;
    }    //ΞΑΝΑ:

    //or with binary search and then use it in checkPair version 3 of this exercise:
    public static int findPivot(int[] arr, int low, int high) {
        if (high < low) return -1;
        if (high == low) return low;

        int mid = low + (high - low) / 2;

        // Περίπτωση 1: Το mid είναι το pivot
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;

        // Περίπτωση 2: Το mid-1 είναι το pivot
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid - 1;

        // Απόφαση: Ποιο μισό θα ψάξουμε;
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1); // Ψάξε αριστερά
        } else {
            return findPivot(arr, mid + 1, high); // Ψάξε δεξιά
        }
    }

    // +     //ΞΑΝΑ:
    public static void checkPair(int[] arr, int target) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        // Αν pivot == -1, ο πίνακας δεν είναι rotated, είναι απλά sorted
        int low = (pivot + 1) % n;
        int high = (pivot == -1) ? n - 1 : pivot;

        boolean found = false;
        while (low != high) {
            int currentSum = arr[low] + arr[high];

            if (currentSum == target) {
                System.out.println("Βρέθηκε ζευγάρι: " + arr[low] + " + " + arr[high] + " = " + target);
                found = true;
                break;
            }

            if (currentSum < target) {
                low = (low + 1) % n;
            } else {
                high = (n + high - 1) % n;
            }
        }

        if (!found) System.out.println("Δεν βρέθηκε ζευγάρι με αυτό το άθροισμα.");
    }

    /// /////////////////////// //ΞΑΝΑ:
    public static int findRotationCount(int[] arr) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        // Αν pivot = -1, ο πίνακας δεν έχει περιστραφεί
        // Αν βρέθηκε pivot, η περιστροφή είναι η θέση του αμέσως επόμενου (μικρότερου) στοιχείου
        return pivot + 1;
    }

    public static void arrangeNegativeBeforePositives(int[] arr) { // μη αποδοτιο Ο(nlogn) λογω ταξινομησης
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void arrangeNegativeBeforePositivesv2(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {

            if (arr[right] >= 0) {
                right--;
            } else if (arr[left] < 0) {
                left++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void arrangePositiveBeforeNegativesv2(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {

            if (arr[right] < 0) {
                right--;
            } else if (arr[left] >= 0) {
                left++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] arrangeMaxAndMinInOrderOneByOne(int[] arr) {
        int[] setMaxMinOneByOne = new int[arr.length];
        Arrays.sort(arr);
        // {4,1,3,78,2}
        //--> {1,2,3,4,78}
        //Goal ===>{78,1,4,2,3}
        int left = 0, right = arr.length - 1;  // Δείκτης στο μικρότερο στοιχείο και δείκτης από μεγαλύτερο στοιχείο
        boolean flag = true; // Flag για να εναλλάσσουμε max και min -->  true για Max, false για Min

        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                // i=0: παίρνει arr[4]=78, μετά το right γίνεται 3
                // i=2: παίρνει arr[3]=4, μετά το right γίνεται 2
                // i=4: παίρνει arr[2]=3, μετά το right γίνεται 1
                setMaxMinOneByOne[i] = arr[right--];
            } else {
                // i=1: παίρνει arr[0]=1, μετά το left γίνεται 1
                // i=3: παίρνει arr[1]=2, μετά το left γίνεται 2
                setMaxMinOneByOne[i] = arr[left++];  //
            }

            /* Οπτικοποίηση βημάτων για το {1, 2, 3, 4, 78}:    και βαζω στοιχεια στον αδειο πινακα
               i=0 (flag=T): setMaxMinOneByOne[0] = 78 (Max), right=3, left=0, result={78, 0, 0, 0, 0}
               i=1 (flag=F): setMaxMinOneByOne[1] = 1  (Min), right=3, left=1, result={78, 1, 0, 0, 0}
               i=2 (flag=T): setMaxMinOneByOne[2] = 4  (Max2), right=2, left=1, result={78, 1, 4, 0, 0}
               i=3 (flag=F): setMaxMinOneByOne[3] = 2  (Min2), right=2, left=2, result={78, 1, 4, 2, 0}
               i=4 (flag=T): setMaxMinOneByOne[4] = 3  (Max3), right=1, left=2, result={78, 1, 4, 2, 3}
            */

            flag = !flag; // Αντιστροφή για την επόμενη επανάληψη

        }
        return setMaxMinOneByOne;
    }

    public static void arrange0and1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++)
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        System.out.println(Arrays.toString(arr));
    }

    // με 2 pointers
    public static void arrange0and1v2(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {

            // Προχώρα τον αριστερό δείκτη όσο βρίσκεις 0
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Προχώρα τον δεξιό δείκτη όσο βρίσκεις 1
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // Αν ο left είναι ακόμα μικρότερος από τον right,
            // σημαίνει ότι βρήκαμε 1 αριστερά και 0 δεξιά, οπότε κάνουμε swap
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //
    public static void arrangeEvenAndOdds(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }
            while (arr[right] % 2 != 0 && left < right) {
                right--;
            }

            // 3. Αν το left είναι ακόμα μικρότερο από το right,
            // σημαίνει ότι βρήκαμε έναν μονό αριστερά και έναν ζυγό δεξιά.
            // Τους κάνουμε ανταλλαγή (Swap).
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("Even first and odd second: " + Arrays.toString(arr));
    }

    public static void replaceWithRightGreatestElement(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        // 1. Το τελευταίο στοιχείο δεν έχει τίποτα δεξιά του.  -----> Η "παγίδα" της λέξης Μέγιστο
        //Το maxFromRight = arr[n-1] δεν σημαίνει ότι το τελευταίο στοιχείο είναι το μεγαλύτερο του πίνακα. Σημαίνει: "Ξεκινάω από το τέλος, άρα το μόνο νούμερο που ξέρω μέχρι στιγμής είναι αυτό, οπότε για μένα αυτό είναι το μέγιστο προς το παρόν".
        // Συνήθως σε αυτή την άσκηση το αντικαθιστούμε με -1.
        int maxFromRight = arr[n - 1];
        arr[n - 1] = -1;
        // 2. Ξεκινάμε από το προτελευταίο στοιχείο και πάμε προς τα αριστερά
        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i]; // Κρατάμε την τρέχουσα τιμή πριν την αντικαταστήσουμε

            arr[i] = maxFromRight; // Αντικαθιστούμε το τρέχον στοιχείο με το μέγιστο που βρήκαμε στα δεξιά

            // Ενημερώνουμε το μέγιστο για το επόμενο (αριστερό) στοιχείο
            if (temp > maxFromRight) {
                maxFromRight = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void findPairSumv2(int[] arr, int target) { //brute force προσεγγιση
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == target) {
                    System.out.println("First element " + arr[i] + " second element " + arr[j] + " of the pair");
                }
            }
        }
    }

    //ειδαλλως O(n) προσεγγιση με Set (hashSet)
    public static void findPairSV2(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found " + num + " and " + complement);
            }
            seen.add(num);
        }
    }

    //ειδαλλως O(nlogn) προσεγγιση - sortαρω και 2 δεικτες
    public static void findParSv2(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                System.out.println("Pair found " + arr[left] + " " + arr[right]);
                left++;
                right--;
            } else if (currentSum < target) {
                left++; //δηλαδη χρειαζομαι μεγαλυτερο αθροισμα
            } else {
                right--; //ειδαλλως χρειαζομαι μικροτερο αθροισμα
            }
        }
    }

    public static boolean findSubarraryWith0Sum(int[] arr) {
        // Χρησιμοποιούμε Set για να αποθηκεύουμε τα αθροίσματα που συναντάμε
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 1. Αν το άθροισμα γίνει 0, βρήκαμε subarray από την αρχή
            // 2. Αν το sum υπάρχει ήδη στο Set, βρήκαμε subarray στη μέση
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }
        return false;
    }

    public static void sortBinaryArrInLinearTime(int[] arr) {  //binary array μονο 0 και 1 δηλαδη ---> Η μέθοδος "Count zeros" (Η πιο απλή)
        int countZeros = 0;

        // 1ο πέρασμα: Μέτρημα
        for (int num : arr) {
            if (num == 0) countZeros++;
        }
        // 2ο πέρασμα: Γέμισμα
        for (int i = 0; i < arr.length; i++) {
            if (i < countZeros) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //Η μέθοδος "Two Pointers" (Η πιο αποδοτική) v2
    public static void sortBinaryArrInLinearTimev2(int[] arr) {   //binary array μονο 0 και 1 δηλαδη

        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            }
            // Αν βρήκαμε 1 αριστερά και 0 δεξιά, κάνε swap!
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void findMaxLengthSubArrayHavingGivenSum(int[] arr, int givenSum) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int currSum = 0;
        int maxLen = 0;
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (map.containsKey(currSum - givenSum)) {
                int currentLen = i - map.get(currSum - givenSum);

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    endIndex = i;
                }

            }
            // Only add the sum if it doesn't exist to maintain the earliest index
            map.putIfAbsent(currSum, i);
        }
        if (endIndex != -1) {
            System.out.println("Maximum length: " + maxLen);
            System.out.println("Subarray: [" + (endIndex - maxLen + 1) + ", " + endIndex + "]");
        } else {
            System.out.println("No subarray found with sum " + givenSum);
        }

    }

    public static void findMaxSubArrHavingAnEqualNumberTo0or1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int curSum = 0;
        int maxLen = 0;
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            curSum += (arr[i] == 0) ? -1 : 1;
            if (map.containsKey(curSum)) {
                // If this sum has been seen before, there is a subarray with sum 0
                int currentLen = i - map.get(curSum);
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    endIndex = i;
                }
            } else {
                // Store only the first occurrence of the sum
                map.put(curSum, i);
            }
        }
        if (endIndex != -1) {
            int startIdx = endIndex - maxLen + 1;
            System.out.println("Largest subarray found [" + startIdx + " ," + endIndex);
            System.out.println("Max length is:" + maxLen);

        } else {
            System.out.println("No such subarray exists");
        }
    }

    public static void findMaxProductOf2Integers(int[] arr) {
        if (arr.length < 2) return;
        long maxProd = Long.MIN_VALUE;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                long currentProd = (long) arr[i] * arr[j];
                if (currentProd > maxProd) {
                    maxProd = currentProd;
                    num1 = arr[i];
                    num2 = arr[j];

                }
            }
        }
        System.out.println("the two integers of max product is: " + num1 + " and " + num2);
        System.out.println("Max product is: " + maxProd);
    }

    //Sort an array of 0’s, 1’s, and 2’s (Dutch National Flag Problem)
    public void selectionSort(int[] arr) { //to sosto einai kato gia ato Dutch National Flag (O(n)) -- ο selections sort einai O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Array: " + Arrays.toString(arr));

    }

    //or
    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid); //an einai 0 στελνω αριστερα
                    low++;
                    mid++;
                    break;
                case 1:  //αν ειναι 1 το αφηνω στη μεση
                    mid++;
                    break;
                case 2: //αν ειναι 2 το στελνω δεξια
                    swap(arr, mid, high);
                    high--;
                    //εδω δεν αυξαωα Mid γιατι πρεπει να ελεγξω το στοιχειο που ηρθε δεξια
                    break;
            }
            ;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void inPlaceMergeArrs(int[] arr1, int m, int[] arr2, int n) { //πολυπλοκότητα είναι O(m + n)
        int i = m - 1;      // Δείκτης για το τέλος των στοιχείων του arr1
        int j = n - 1;      // Δείκτης για το τέλος του arr2
        int k = m + n - 1;  // Δείκτης για την τελευταία θέση του arr1 (συνολικό μέγεθος)
        // Όσο υπάρχουν στοιχεία και στους δύο πίνακες
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--]; // Βάζουμε το μεγαλύτερο στο τέλος
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // Αν περίσσεψαν στοιχεία στον arr2 (πρέπει να μπουν στην αρχή)
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    public static void mergeTwoArrsGivenConstraints(int[] x, int[] y, int m, int n) {
        // m = αριθμός πραγματικών στοιχείων στο x
        // n = αριθμός στοιχείων στο y

        int i = m - 1; // Τελευταίο "καλό" στοιχείο του x
        int j = n - 1; // Τελευταίο στοιχείο του y
        int k = x.length - 1; // Η τελευταία-τελευταία θέση του x (η άδεια)
        while (i >= 0 && j >= 0) {
            if (x[i] > y[i]) {
                x[k] = x[i];
                i--;
            } else {
                x[k] = y[j];
                j--;
            }
            k--;
        }// Αν περίσσεψαν στοιχεία στο y, τα βάζουμε μπροστά
        while (j >= 0) {
            x[k] = y[j];
            j--;
            k--;
        }
    }

    public static void findEquilibriumArr(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;
        for (int x : arr) {
            totalSum += x;
        }
        // 2. Διατρέχουμε τον πίνακα και ελέγχουμε την ισορροπία
        for (int i = 0; i < arr.length; i++) {
            // Το rightSum προκύπτει αφαιρώντας το leftSum και το τρέχον στοιχείο
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                System.out.println("Equilibrium Index found at: " + i + " (Value: " + arr[i] + ")");
            }

            // 3. Ενημερώνουμε το leftSum για την επόμενη επανάληψη
            leftSum += arr[i];
        }
    }

    public static void boyerMooreMajority(int[] arr) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println("Winner Majority element is : " + candidate);
    }

    public static void moveAllZeroesAtTheEnd(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void maxSumSubArrayProblem(int[] arr) { //Kadane’s Algorithm
        // Ξεκινάμε με το πρώτο στοιχείο ως βάση
        int maxSoFar = arr[0];
        int currentSum = arr[0];
        // Ξεκινάμε από το δεύτερο στοιχείο (index 1)
        for (int i = 1; i < arr.length; i++) {

        /* ΑΠΟΦΑΣΗ: Θα προσθέσω τον τρέχοντα αριθμό στο υπάρχον άθροισμα;
           Ή μήπως ο τρέχων αριθμός είναι μεγαλύτερος από όλο το προηγούμενο άθροισμα;
        */
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // Ενημερώνουμε το παγκόσμιο μέγιστο αν βρήκαμε κάτι καλύτερο
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        System.out.println("Max sub array sum is: " + maxSoFar);
    }

    public static void sortArrInOneSwapWithTwoElemsSwapped(int[] arr) {
        int n = arr.length;
//        //bubblesort
//        for(int i = 0; i < n - 1; i++){
//            for(int j = 0; j < n - 1 - i; j++){
//                if(arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
        int first = -1, second = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (first == -1) {
                    first = i;
                }
                second = i + 1;
            }
        }
        if (first != -1 && second != -1) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void maxSubset(Set<Integer> set1) {
        if (set1.isEmpty()) return;
        if (set1.size() == 1) {
            System.out.println("Maximum product subset = " + set1.iterator().next());
            return;
        }
        Integer maxNegative = Integer.MIN_VALUE;
        Integer prod = 1;
        boolean hasPositive = false;
        boolean hasZero = set1.contains(0);
        int totalNegs = 0;
        int countNonZero = 0;
        for (Integer num : set1) {
            if (num == 0) continue;
            countNonZero++;

            if (num < 0) {
                totalNegs++;
                if (num > maxNegative) {
                    maxNegative = num;
                }
            }

            prod *= num;
        }
        if (countNonZero == 0 || (countNonZero == 1 && totalNegs == 1 && hasZero)) {
            System.out.println("Maximum product subset = 0");
            return;
        }

        if (totalNegs % 2 != 0) {
            prod /= maxNegative;
        }
        System.out.println("Maximum product subset = " + prod);
    }

    public static void findDiffK(int[] arr, int k) { //brute force τροποσ O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    System.out.println("K diff found with this elements: " + arr[i] + " ," + arr[j]);
                } else {
                    System.out.println("K diff not found!");
                }
            }
        }
    }

    public static void findDiffKv2(int[] arr, int k) { //Η πιο γρήγορη - O(n)
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr) set1.add(num);
        for (int num : arr) {
            if (set1.contains(num + k)) { //ψαχνω y-x = k αν το σκεφτψ σαν εξισωση κανω εδω k+x = y γιαυτο το κανω ετσι με προσθεση
                System.out.println(num + " και " + (num + k));
            }
        }
    }

    public static void minDiffBetweenIndexOf2GivenElems(int[] arr, int x, int y) { //O(n^2) τρόπος
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // Ελέγχουμε αν το ένα στοιχείο είναι το x και το άλλο το y
                if (arr[i] == x && arr[j] == y || arr[i] == y && arr[j] == x) {
                    int diff = Math.abs(i - j);//υπολογίζουμε τη διαφορά των θέσεων
                    if (diff < min) {
                        min = diff;
                    }

                }
            }
        }
        System.out.println("Min difference: " + (min == Integer.MAX_VALUE ? " Not found" : min));
    }

    public static int minDistV2(int[] arr, int x, int y) { //O(n) τρόπος
        int minDist = Integer.MAX_VALUE;
        int prevIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x || arr[i] == y) {
                if (prevIdx != -1 && arr[i] != arr[prevIdx]) {
                    minDist = Math.min(minDist, i - prevIdx);
                }
            }
            prevIdx = i;
        }
        return minDist;
    }

    public static boolean isPartitionArrIntoSubArrs(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int runningSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (runningSum == target) {
                return true;
            }
        }
        return false;
    }

    //or v2
    public static boolean isPartitionWithTwoPointers(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftSum = 0;
        int rightSum = 0;

        while (left <= right) {
            if (leftSum <= rightSum) {
                leftSum += arr[left++];
            } else {
                rightSum += arr[right--];
            }
        }
        return leftSum == rightSum;
    }

    public static void find2NumsWithMaxSumFormedByArrayDigits(int[] arr) {
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        // 2. Ξεκινάμε από το τέλος του πίνακα (μεγαλύτερα ψηφία)
        // και τα μοιράζουμε εναλλάξ
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }
        long n1 = Long.parseLong(num1.toString());
        long n2 = Long.parseLong(num2.toString());
        System.out.println("First number " + n1);
        System.out.println("Second number " + n2);
        System.out.println("Max sum " + (n1 + n2));
    }

    public static int findMinIndexOfRepeatingElement(int[] arr) {
        int min = -1;
        Set<Integer> set1 = new HashSet<>();
        // Διαβάζουμε από δεξιά προς τα αριστερά
        for (int i = arr.length - 1; i >= 0; i--) { // Αν το Set περιέχει ήδη τον αριθμό, σημαίνει ότι τον ξαναβρήκαμε
            // καθώς πηγαίνουμε προς τα αριστερά. Άρα αυτό το i είναι ένα υποψήφιο min index.
            if (set1.contains(arr[i])) {
                min = i;
            } else {
                set1.add(arr[i]); // Αν δεν υπάρχει, τον προσθέτουμε για τις επόμενες συγκρίσεις
            }
        }
        return min;
    }

    public static void findPairWithMinAbsSumInArr(int[] arr) {
        if (arr.length < 2) return;
        int sum = 0;
        int element1 = 0;
        int element2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = Math.abs(arr[i] + arr[j]);
                if (sum < min) {
                    min = sum;
                    element1 = arr[i];
                    element2 = arr[j];
                }

            }
        }
        System.out.println("Minimum sum --> " + min + " and the pair is -->  " + element1 + " and --> " + element2);
    }

    public static void findPairWithMinAbsSumInArr2(int[] arr) {
        if (arr.length < 2) return;

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int element1 = 0, element2 = 0;

        while (left <= right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                element1 = arr[left];
                element2 = arr[right];
            }

            //  Πώς να μετακινήσουμε τους δείκτες
            if (sum > 0) {
                right--; // Το άθροισμα είναι μεγάλο, μείωσε τη δεξιά πλευρά
            } else if (sum < 0) {
                left++;  // Το άθροισμα είναι πολύ αρνητικό, αύξησε την αριστερή πλευρά
            } else {
                break; // Βρήκαμε άθροισμα 0, το απόλυτο ελάχιστο!
            }
        }
        System.out.println("Best pair: " + element1 + " , " + element2);
        System.out.println("Minimum absolute sum: " + Math.abs(minSum));
    }

    public static void findIdxOfMaximumOccuringElemWithEqualProb(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int num : arr) {
            int freq = map.getOrDefault(num, 0) + 1;
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }
        int maxElement = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxElement = entry.getKey();
                break;
            }
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxElement) {
                indices.add(i);
            }
        }
        if (indices.isEmpty()) {
            System.out.println("No elements found to pick from.");
            return; // Σταματάμε τη μέθοδο για να μη σκάσει η Random
        }
        Random rand = new Random();
        int randomIdx = indices.get(rand.nextInt(indices.size()));
        System.out.println("Max element: " + maxElement + " (appears " + maxFreq + " times)");
        System.out.println("Possible indices: " + indices);
        System.out.println("Randomly chosen index: " + randomIdx);
    }

    public static void add2ArraysToAnewArr(int[] arr1, int[] arr2) {
        // 1. Δημιουργούμε τον πίνακα με το συνολικό μέγεθος
        int[] arr3 = new int[arr1.length + arr2.length];
        int currentPos = 0; // Ο μετρητής για τον arr3

        // 2. Προσθέτουμε τα στοιχεία του πρώτου πίνακα
        for (int i = 0; i < arr1.length; i++) {
            arr3[currentPos] = arr1[i];
            currentPos++;
        }

        // 3. Προσθέτουμε τα στοιχεία του δεύτερου πίνακα
        for (int i = 0; i < arr2.length; i++) {
            arr3[currentPos] = arr2[i];
            currentPos++;
        }

        System.out.println("New merged array: " + Arrays.toString(arr3));
    }

    public static void printSimplePyramidNums(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printPattern(int n) { //https://www.geeksforgeeks.org/java/java-program-to-print-pascals-triangle/  -- here I got a lof help in this article (I was a bit confused)
        List<List<Integer>> triangle = new ArrayList<>(); //I want to add the row list inside another list
        //ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int num = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(num);
                }
                System.out.print(row.get(j) + " ");
            }
            triangle.add(row);
            System.out.println();
        }
    }

    private static boolean isIndexDividesArrayIntoTwoNonEmptySubArraysWithEqualSum(int[] arr) {
        if (arr == null || arr.length < 2) return false;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;
            if (rightSum == leftSum) {
                System.out.println("Dividing index found at: " + i);
                System.out.println("Left sum = Right sum " + leftSum);
                return true;
            }
        }
        System.out.println("No such index exists.");
        return false;
    }

    private static void findDuplicatesInkRange(int[] arr, int k) {
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (window.contains(arr[i])) {
                System.out.println("Duplicate found: " + arr[i] + " at index " + i);
            }
            window.add(arr[i]);
            if (window.size() > k) {
                // Αν το παράθυρο ξεπεράσει το μέγεθος k, αφαιρούμε το πιο παλιό στοιχείο
                window.remove(arr[i - k]);
            }
        }
    }

    public static int findIdxOfElementSatisfiesGivenConstraints(int[] arr) { //φέρνει το 1ο αφου εβαλα break με αυτα τα constraints
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] > 0 && arr[i] <= 45) {
                System.out.println("Index of element that satisfies the constraints: ");
                return i;
            }
        }
        return -1;
    }

    public static int findIdxOfElementSatisfiesGivenConstraintsv2(int[] arr) { //φέρνει το tελευταιο αφου εβαλα break με αυτα τα constraints
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] > 0 && arr[i] <= 45) {
                lastIndex = i;
            }
        }
        if (lastIndex != -1) {
            System.out.println("Index of element that satisfies the constraints: ");
        }
        return lastIndex;
    }

    public static void rotateArrAll(int[] arr) {
        System.out.println("initial array: " + Arrays.toString(arr));

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        System.out.println("after left rotation array: " + Arrays.toString(arr));
    }

    public static void leftRotatedArr(int[] arr) {
        System.out.println("initial array: " + Arrays.toString(arr));
        if (arr.length == 0) return;
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
        System.out.println("after left rotation array: " + Arrays.toString(arr));
    }

    public static void rightRotatedArr(int[] arr, int times) {
        System.out.println("initial array: " + Arrays.toString(arr));
        if (arr.length == 0) return;
        times = times % arr.length; // Αν ο αριθμός των περιστροφών είναι μεγαλύτερος από το μήκος του πίνακα, μπορούμε να το μειώσουμε
        for (int t = 0; t < times; t++) {
            int last = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
        }
        System.out.println("after right rotation array: " + Arrays.toString(arr));
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(Activity::getEndTime));

        List<Activity> selected = new ArrayList<>();
        if (activities.isEmpty()) {
            return selected;
        }
        selected.add(activities.get(0));
        int lastEndTime = activities.get(0).getEndTime();
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getStartTime() >= lastEndTime) {
                selected.add(activities.get(i));
                lastEndTime = activities.get(i).getEndTime();
            }
        }
        return selected;
    }

    public static int countTripletsFormInversionArr(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] > arr[j] && arr[j] > arr[k]) {
                        count++;
                    }

                }
            }
        }
        return count;
    }

    public static void segregateInLinearTime(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] < 0 && left < right) {
                left++;
            }
            while (arr[right] >= 0 && left < right) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }


        }
    }

    public static void findDuplicatesInLimitedRangeArray(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        System.out.println("Duplicates elements in the array are: " + duplicates);
    }

    public static void insertionSort(int[] arr) { //if array is already sorted O(n) if not O(n^2)
        for (int i = 1; i < arr.length; i++) { //starts from the second element index 1
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { //moving elements that are greater than key to one position ahead of their current position
                arr[j + 1] = arr[j]; //shifting the element to the right
                j--; //moving to the next element on the left
            }
            arr[j + 1] = key; //inserting the key in its correct position in the sorted subarray
        }
    }

    public static void selectionSortv5(int[] arr) {
        for (int i = 00; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortv6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) { //divide and conquer approach O(nlogn)
        if (arr.length < 2) return; //base case
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid); //copies the specified range of the specified array (here I adding the array, the from index, and the to index)
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); //second half of the array here
        mergeSort(left); //recursive call for the left half
        mergeSort(right); //recursive call for the right half
        merge(arr, left, right); //merging the sorted halves
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0; //i for left array, j for right array, k for merged array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++]; //if the current element in the left array is smaller than or equal to the current element in the right array, we add it to the merged array and move to the next element in the left array
            } else {
                arr[k++] = right[j++]; //if the current element in the right array is smaller than the current element in the left array, we add it to the merged array and move to the next element in the right array
            }
        }
        while (i < left.length) { //if there are remaining elements in the left array, we add them to the merged array
            arr[k++] = left[i++];
        }
        while (j < right.length) { //if there are remaining elements in the right array, we add them to the merged array
            arr[k++] = right[j++];
        }
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        // Find the maximum value in the array
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        // Create count array to store the count of each unique value
        int[] count = new int[max + 1];
        // Count the occurrences of each value
        for (int num : arr) {
            count[num]++;
        }
        // Modify count array by adding previous counts (cumulative count)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Output array to store sorted elements
        int[] output = new int[arr.length];
        // Build the output array by placing elements at their correct positions
        // Iterate from right to left to make the sort stable
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        // Copy the sorted elements back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr) {
        int i = -1;
        int pivot = 0; // Θα χρησιμοποιήσουμε το 0 ως pivot για διαχωρισμό

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Ανταλλαγή arr[i] με arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i; // Επιστρέφει το index του τελευταίου στοιχείου <= pivot
    }

    //optimizing quicksort
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int low, int high) {
        if (high - low + 1 <= CUTOFF) {
            insertionSort(arr, low, high);
            return;
        }
        int pivot = medianOfThree(arr, low, high);
        int i = low, j = high - 1;
        while (true) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] > pivot) {
            }
            if (i < j) {
                swapv2(arr, i, j);
            } else {
                break;
            }
        }
        swapv2(arr, i, high - 1); // Restore pivot
        quickSort2(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        swap(arr, mid, high - 1);
        return arr[high - 1];
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swapv2(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // end of quicksort optimization

    /*1 2 3
      4 5 6
      7 8 9 */
    //should become like that:
    /* 7 4 1
       8 5 2
       9 6 3
    */

    public static void inPlaceRotateMatrixBy90DegreesClockWise(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            int left = 0, right = a.length - 1;
            while (left < right) {
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;
                left++;
                right--;
            }

        }
        //System.out.println(Arrays.deepToString(a));
    }

    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int countNegativeElementsPresentInSortedMatrixInLinearT(int[][] arr) { //O(n) και εστω Κάθε γραμμή είναι ταξινομημένη σε αύξουσα σειρά (από μικρότερο σε μεγαλύτερο).  και Κάθε στήλη είναι επίσης ταξινομημένη σε αύξουσα σειρά.
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (arr[row][col] < 0) {
                // Όλα τα στοιχεία κάτω από αυτό στη στήλη είναι αρνητικά
                count += (n - row);
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Matrix is this one again: ");
        printMatrix(arr);
        System.out.println("Count of Negative ELEMENTS ARE: " + count);
        return count;
    }

    public static boolean toepLitz(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int factorialv2(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");

        // Base case: το 0! και το 1! ισούται με 1
        if (n <= 1) return 1;

        return n * factorialv2(n - 1);
    }

    public static void pascalTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + factorialv2(i) / (factorialv2(j) * factorialv2(i - j)));
            }
            System.out.println();
        }
    }

    public static void findPerimeterOfIsland(int[][] arr) {
        int n = arr.length;
        int perimeter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    if (i == 0 || arr[i - 1][j] == 0) {
                        perimeter++;
                    }
                    if (i == n - 1 || arr[i + 1][j] == 0) {
                        perimeter++;
                    }
                    if (j == 0 || arr[i][j - 1] == 0) {
                        perimeter++;
                    }
                    if (j == arr[i].length - 1 || arr[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        System.out.println("Perimeter of island is: " + perimeter);
    }

    public static boolean checkStringsCanCircularlyRotating(String s1, String s2) {
        if (s1.length() != s2.length()) {
            System.out.println("Strings are not circularly rotated!");
            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i); //παιρνω γραμμα στην θεση i
            int value = c - 'A' + 1; //και ουσιαστικα οι χαρακτηρες μεσα στο int value ειναι σε ASCII αρα εστω c = AB ειναι στ πρωτη επαναληψη 65 - 65 + 1 = 1 και μετα στην επόμενη επαναληψη 66 - 65 + 1 = 2
            res = res * 26 + value; //και εδω πολλαπλασιαζω το αποτελεσμα με το 26 για να μετακινηθω στην επομενη θεση και προσθετω την τιμη του τρεχοντος γραμματος
        }
        return res;
    }

    // Find all interleaving of given strings
    public static void findAllInterLeavingOfGivenStrings(String[] arrStr, int[] indexes, String currentResult) {
        boolean allFinished = true;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] < arrStr[i].length()) {
                allFinished = false;
                break;
            }
        }
        if (allFinished) {
            System.out.println(currentResult);
            return;
        }
        for (int i = 0; i < arrStr.length; i++) {
            if (indexes[i] < arrStr[i].length()) {
                char c = arrStr[i].charAt(indexes[i]);
                indexes[i]++;
                findAllInterLeavingOfGivenStrings(arrStr, indexes, currentResult + c);
                indexes[i]--;
            }
        }
    }

    public static void removeOccurencesOfABandCInAString(String myString) {
//        String res = myString.replaceAll("AB", "").replaceAll("C", "");
//        System.out.println(res);
        //or
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < myString.length()) {
            if (i + 1 < myString.length() && myString.charAt(i) == 'A' && myString.charAt(i + 1) == 'B') {
                i += 2;//παραλειψη του ΑΒ
            } else if (myString.charAt(i) == 'C') {
                i++;//παραλειψη του C
            } else {
                sb.append(myString.charAt(i));
                i++;
            }
        }
        System.out.println(sb.toString());
    }

    public static String runLengthCompressionAlgoright(String input) { //RLE run length endoding
        if (input == null || input.isEmpty()) {
            return "";
        }
        int counterOfChar = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                counterOfChar++;
            } else {
                sb.append(input.charAt(i)).append(counterOfChar);
                counterOfChar = 1;
            }
        }
        // Πρόσθεση του τελευταίου χαρακτήρα και του μετρητή του
        sb.append(input.charAt(input.length() - 1)).append(counterOfChar);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static boolean isPalindromev3(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }

    public static int convertRomanToInt(String romanStr) {
        int res = 0;
        Map<Character, Integer> romanMap = createRomanMap();
        for (int i = 0; i < romanStr.length(); i++) {
            int currentVal = romanMap.get(romanStr.charAt(i));
            int nextVal = 0;
            if (i + 1 < romanStr.length()) {
                nextVal = romanMap.get(romanStr.charAt(i + 1));
            }
            if (currentVal < nextVal) {
                res -= currentVal;
            } else {
                res += currentVal;
            }
        }
        return res;
    }

    private static Map<Character, Integer> createRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }

    public static void removeAdjacentDuplCharactersFromAString(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        char prevC = input.charAt(0);
        sb.append(prevC);
        for (int i = 1; i < input.length(); i++) {
            char currentC = input.charAt(i);
            while (currentC != prevC) {
                sb.append(currentC);
                prevC = currentC;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean determineStringIsSubsequenceOfAnotherString(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //with recursion
    public static String reverseStringRecursive(String str) {
        if (str.isEmpty())
            return str;
        return reverseStringRecursive(str.substring(1)) + str.charAt(0); //-->geeks for geeks ==> eeks for geeks (παιρνω το g και το προσθετει στο τελος
    } //substring(1) παιρνει το string χωρις τον 1ο χαρακτηρα -- και γινεται αυτο μεχρι να γινει κενο το string -- στο τελος το επιστρεφει reversed


    public static boolean checkAStringForRepeatedSubstring(String str) {
        Set<String> visited = new HashSet<>();
        for (int length = 1; length <= str.length() - 1; length++) {
            for (int start = 0; start <= str.length() - length; start++) {
                String substring = str.substring(start, start + length);
                if (visited.contains(substring)) {
                    return true;
                } else {
                    visited.add(substring);
                }
            }
            visited.clear(); // Καθαρίζουμε το set για substrings άλλου μήκους
        }
        return false;
    }

    public static void findDifferenceBetweenTwoStrings(String str1, String str2) {
        StringBuilder diff = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (str2.indexOf(c) == -1) { // αν ο χαρακτήρας δεν υπάρχει στο str2
                diff.append(c);
            }
        }
        System.out.println("Difference between two strings is: " + diff.toString());
    }

    private static boolean isAnagramOrNot(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    //bit hacks 1  (bit manipulations problems)
    //Το τελευταίο bit ενός αριθμού δείχνει αν είναι ζυγός ή περιττός.
    //Αν το τελευταίο bit είναι 0 → ζυγός, είναι 1 → περιττός.
    public static boolean isEvenBit(int n) {
        return (n & 1) == 0; //αν το τελευταίο bit είναι 0 τότε είναι άρτιος αριθμός
    }

    public static boolean isOddBit(int n) {
        return (n & 1) == 1;
    }

    //Αν το XOR των δύο αριθμών έχει το πιο σημαντικό bit (sign bit) 1, τότε έχουν αντίθετα πρόσημα.
    public static boolean haveOppositeSigns(int x, int y) {
        return (x ^ y) < 0;
    }

    //Μπορείς να προσθέσεις 1 χρησιμοποιώντας bitwise πράξεις, αλλά πιο απλά:
    public static int addOne(int n) {
        int m = 1;
        while ((n & m) != 0) {
            n = n ^ m;
            m <<= 1;
        }
        n = n ^ m;
        return n;
    }

    //Ανταλλαγή δύο αριθμών χωρίς τρίτη μεταβλητή
    //Ιδέα:
    //Χρησιμοποιείς XOR για να ανταλλάξεις τιμές.
    public static void swapBits(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    /// /////////
    public static int hammingDistanceCalc(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count = count + (xor & 1);
            xor = xor >>= 1;
        }
        return count;
    }

    //or
    public static int hammingDistanceCalc2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    /// /BIT HACKS 2:
    //bit hacks 2  (bit manipulations problems)
    //Playing with k'th bit
    //Τι είναι το k'th bit;  Κάθε ακέραιος αριθμός αποθηκεύεται στη μνήμη ως μια σειρά από bits (0 ή 1).
    //Τα bits αριθμούνται από το 0 (το λιγότερο σημαντικό bit, το δεξιότερο) προς τα αριστερά.
    //Το k'th bit σημαίνει το bit στη θέση k (ξεκινώντας από 0).  πχ Ο αριθμός 13 σε δυαδική μορφή είναι: ειναι 0000 1101 (Το 0'ο bit (το πιο δεξί) είναι 1.
    //Το 1'ο bit είναι 0, Το 2'ο bit είναι 1, Το 3'ο bit είναι 1, κλπ.
    //Τι σημαίνει "παίζω με το k'th bit --> ΠΧ Έλεγχος αν το k'th bit είναι 0 ή 1, Θέτω το k'th bit σε 1, Καθαρίζω (σβήνω) το k'th bit σε 0,
    //Αλλάζω (toggle) το k'th bit από 0 σε 1 από 1 σε 0
    public boolean isKthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    int setKthBit(int n, int k) {
        return n | (1 << k);
    }

    int clearKthBit(int n, int k) {
        return n & ~(1 << k);
    }

    //4. Αλλάζω (toggle) το k'th bit
    int toggleKthBit(int n, int k) {
        return n ^ (1 << k);
    }

    //etc etc here https://www.techiedelight.com/data-structures-and-algorithms-problems/ (search CTRL + F ==> Bit Hacks)
    // ---------------------------------------------------------------------------------------------------------------------------------

    public static void findElementsInArrayThatAreGreaterThanAllElemsToTheirRight(int[] arr) {
        int maxRight = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
                res.add(arr[i]);
            }
        }
        Collections.reverse(res);
        System.out.println("Elements that are greater than all elements to their right: " + res);
    }

    public static String reverseStrWithoutRecursion(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //with recursion
    public static String reverseStrWithRecursion(String str) { //I have same exercises above
        if (str.isEmpty()) return str;
        return reverseStrWithRecursion(str.substring(1)) + str.charAt(0);
    }

    //level order traversal in a binary tree
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public class BinaryTree {
        public static void levelOrderTraversal(TreeNode root) { //level order traversal in a binary tree
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.println(current.val + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    //377.
    public static int findNumberOfRotationsInCircularlySortedArr(int[] arr) { //array is sorted already
        if (arr.length < 2) return 0;  //γραμμικη αναζητηση
        int smallestElementIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[smallestElementIndex]) {
                smallestElementIndex = i;
            }
        }
        return smallestElementIndex;
    }

    //or with binary search
    public static int findNumberOfRotationsInCircularlySortedArrV2(int[] arr) {
        if (arr.length < 2) return 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //1 + (5-1)/2 = 3 (2.5)
            if (arr[mid] > arr[right]) {
                right = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void findFirstLastOccurenceOfANumberInSortedArr(int[] arr, int x) { //with streams
        OptionalInt firstIdx = IntStream.range(0, arr.length).filter(i -> arr[i] == x).findFirst();
        OptionalInt lastIdx = IntStream.range(0, arr.length).filter(i -> arr[i] == x).reduce((first, last) -> last);
        System.out.println("First occurence of " + x + " is at index: " + firstIdx);
        System.out.println("Last occurence of " + x + " is at index: " + lastIdx);
    }

    //or with binary search
    public static int findFirstOccurrence(int[] arr, int x) {
        if (arr.length < 2) {
            return -1;
        }
        int res = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                res = mid;
                right = mid - 1; // ψάχνουμε αριστερά για πρώτη εμφάνιση
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static int findLastOccurrence(int[] arr, int x) {
        if (arr.length < 2) {
            return -1;
        }
        int res = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                res = mid;
                left = mid + 1; // ψάχνουμε δεξιά για τελευταία εμφάνιση
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void findFirstLastOccurrenceOfANumberInSortedArrV2(int[] arr, int x) {
        int first = findFirstOccurrence(arr, x);
        int last = findLastOccurrence(arr, x);
        System.out.println("First occurence of " + x + " is at index: " + first);
        System.out.println("Last occurence of " + x + " is at index: " + last);
    }

    public static void countOccurencesOfANumber(int[] arr, int x) { //in a sorted Array
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        System.out.println("Number of occurences of this number: " + count);
    }

    public static void findFlourAndCeilNumInSortedArr(int[] arr) {
        double ceiNum = Integer.MIN_VALUE;
        double floorNum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ceiNum = Math.ceil(arr[i]);
            } else {
                floorNum = Math.floor(arr[i]);
            }
        }
        System.out.println("Ceil number is: " + ceiNum);
        System.out.println("Floor number is: " + floorNum);
    }

    public static int find1sInBinarySortedArr(int[] arr) { //bin search way
        int left = 0, right = arr.length - 1;
        int firstOneIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 1) {
                firstOneIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (firstOneIdx == 1) ? 0 : (arr.length - firstOneIdx);
    }

    public static double powerFunc(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;

    }

    //nonrecursive solution
    public static int[] findFloodAndCeilNumInSortedArr(int[] arr, int target) {
        int ceilNum = Integer.MAX_VALUE;
        int floorNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target && arr[i] >= floorNum) {
                floorNum = arr[i];
            }
            if (arr[i] >= target && arr[i] < ceilNum) {
                ceilNum = arr[i];
            }
        }
        return new int[]{floorNum, ceilNum};
    }

    //    public static int bis(int[] arr, int left, int right, int targ) {
//        if (left > right) return -1;
//
//        int mid = left + (right - left) / 2;
//        if (arr[mid] == targ) {
//            return mid;
//        } else if (arr[mid] > targ) {
//            return bis(arr, left, mid - 1, targ);
//        } else {
//            return bis(arr, right, mid + 1, targ);
//
//        }
//    }
    //recursive solution
    public static int findFloor(int[] arr, int left, int right, int targ, int floor) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == targ) {
            return mid;
        } else if (arr[mid] > targ) {
            return findFloor(arr, left, mid - 1, targ, floor);
        } else {
            return findFloor(arr, right, mid + 1, targ, arr[mid]);

        }
    }

    public static int findCeil(int[] arr, int left, int right, int targ, int ceil) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == targ) {
            return mid;
        } else if (arr[mid] < targ) {
            return findCeil(arr, left, mid + 1, targ, ceil);
        } else {
            return findCeil(arr, right, mid - 1, targ, arr[mid]);
        }
    }

    public static void findFreqOfEachElementInSortedArrContainDupl(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.println("Element " + arr[i - 1] + " has duplicate count: " + count);
                count = 1;
            }

        }
        System.out.println("Element " + arr[arr.length - 1] + " has duplicate count: " + count);
    }

    public static int findSqRootOfNumUsingBinS(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (target == 0 || target == 1) return target;
        int left = 0, right = target;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; //
            long sq = (long) mid * mid; //για αποφυγη Overflow
            if (sq == target) {
                return mid;
            } else if (sq < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static String lcpProb(String[] arr) {
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int minLen = Math.min(first.length(), last.length());
        int i = 0;
        while (i < minLen && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }

    public static int expSearch(int[] arr, int target) { //exponential search
        Arrays.sort(arr);
        int n = arr.length;
        if (n == 0) return -1;
        if (arr[0] == target) return 0;
        int i = 1;
        while (i < n && arr[i] < target) {
            i *= 2;
        }
        int left = i / 2;
        int right = Math.min(i, n - 1);
        return biS(arr, left, right, target);
    }

    public static int biS(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return right = mid - 1;
            } else {
                return left = mid + 1;
            }
        }
        return -1;
    }

    static class ArrayReader {
        private final int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        int get(int index) {
            if (index < 0 || index >= arr.length) return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public static int unboundedBinarySearch(ArrayReader reader, int target) { //hypothesis is ordered
        if (reader.get(0) == target) {
            return 0;
        }
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int[] arr, int target) { //ordered array
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (arr[high] == arr[low]) { // avoid division by zero
                return (arr[low] == target) ? low : -1;
            }
            long numerator = (long) (target - arr[low]) * (high - low);
            long denominator = (arr[high] - arr[low]);
            int pos = (int) (low + numerator / denominator);
            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;

    }

    //recursive prog
    public static int fibv22(int n) {
        if (n <= 1) {
            return n;
        }
        return fibv22(n - 1) + fibv22(n - 2);
    }

    //dynamic programming Fibonacci
    static Map<Integer, Integer> memo = new java.util.HashMap<>();

    public static int fibMemoMap(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int val = fibMemoMap(n - 1) + fibMemoMap(n - 2);
        memo.put(n, val);
        return val;
    }

    //count all paths in a matrix from first cell until last cell - Αναδρομική Λύση με Memoization
    public static int countPaths(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, m, n, memo);
    }

    private static int dfs(int i, int j, int m, int n, int[][] memo) {
        if (i >= m || j >= n) return 0;

        if (i == m - 1 && j == n - 1) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = dfs(i + 1, j, m, n, memo) + dfs(i, j + 1, m, n, memo);
        return memo[i][j];
    }

    // or  Dynamic Programming (Bottom-Up)
    public static int countPathsDP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // Γέμισε το τελευταίο κελί με 1
        dp[m - 1][n - 1] = 1;
        // Γέμισε την τελευταία γραμμή και στήλη
        for (int i = m - 2; i >= 0; i--) dp[i][n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) dp[m - 1][j] = 1;
        // Βρες τα υπόλοιπα cells
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }


    // Find all n-digit binary numbers without any consecutive 1’s
    public static List<String> generate(int n) {
        // Λίστα που θα περιέχει ΟΛΑ τα έγκυρα δυαδικά strings μήκους n
        List<String> res = new ArrayList<>();

        // Χρησιμοποιούμε StringBuilder για να χτίζουμε το τρέχον string σταδιακά (πιο αποδοτικό από String)
        StringBuilder sb = new StringBuilder();

        // Ξεκινάμε DFS/Backtracking:
        // pos = 0  -> είμαστε στην αρχή (δεν έχουμε βάλει κανένα ψηφίο)
        // prev = 0 -> θεωρούμε ότι "το προηγούμενο" δεν ήταν 1 (άρα επιτρέπεται να βάλουμε 1 στην αρχή)
        dfs2(0, 0, n, sb, res);

        // Επιστρέφουμε όλα τα valid strings που βρέθηκαν
        return res;
    }

    public static void dfs2(int pos, int prev, int n, StringBuilder sb, List<String> res) {
        // pos  = πόσα bits έχουμε ήδη τοποθετήσει στο sb (τρέχουσα θέση/βάθος recursion)
        // prev = τι βάλαμε ακριβώς πριν:
        //        0 αν το προηγούμενο bit ήταν '0'
        //        1 αν το προηγούμενο bit ήταν '1'
        // n    = συνολικό μήκος που πρέπει να έχει κάθε binary number
        // sb   = το τρέχον binary string που χτίζουμε
        // res  = η λίστα αποτελεσμάτων (ό,τι ολοκληρώνουμε, το προσθέτουμε εδώ)

        // ΒΑΣΗ αναδρομής: αν έχουμε βάλει ήδη n bits, τότε το sb έχει μήκος n
        if (pos == n) {
            // Το τρέχον sb είναι έγκυρο (γιατί δεν επιτρέψαμε ποτέ να μπει "11")
            // το μετατρέπουμε σε String και το αποθηκεύουμε
            res.add(sb.toString());
            return; // σταματάμε αυτό το branch
        }

        // --- Επιλογή 1: να βάλουμε '0' ---
        // Το '0' επιτρέπεται ΠΑΝΤΑ (δεν δημιουργεί ποτέ consecutive 1s)
        sb.append('0');                 // βάζουμε το '0' στο τέλος του sb
        dfs2(pos + 1, 0, n, sb, res);   // προχωράμε στην επόμενη θέση, και prev γίνεται 0
        sb.deleteCharAt(sb.length() - 1); // BACKTRACK: αφαιρούμε το τελευταίο char για να δοκιμάσουμε άλλη επιλογή

        // --- Επιλογή 2: να βάλουμε '1' ---
        // Το '1' επιτρέπεται ΜΟΝΟ αν το προηγούμενο bit ΔΕΝ ήταν 1
        // Δηλαδή: αν prev == 0
        if (prev == 0) {
            sb.append('1');                 // βάζουμε '1'
            dfs2(pos + 1, 1, n, sb, res);   // προχωράμε, και prev γίνεται 1 (γιατί μόλις βάλαμε 1)
            sb.deleteCharAt(sb.length() - 1); // BACKTRACK: αφαιρούμε το '1'
        }

        // Αν prev == 1, ΔΕΝ βάζουμε '1', γιατί θα δημιουργούσαμε "11" (διαδοχικούς άσσους)
    }

    //Find maximum profit that can be earned by conditionally selling stocks
    public static int finMaxProfitCanBeEarnedByConditionallySellingStocks(int[] a, int[] b, int n) {
        if (n < 0) return 0;

        int profit = 0;

        profit = Integer.max(profit, a[n] + finMaxProfitCanBeEarnedByConditionallySellingStocks(a, b, n - 1));

        profit = Integer.max(profit, b[n] + finMaxProfitCanBeEarnedByConditionallySellingStocks(a, b, n - 2));

        return profit;
    }

    //Program to find n’th Fibonacci number
    //recursion simple fibo algo
    public static int fibV4(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        return fibV4(n - 1) + fibV4(n - 2);
    }

    //for nth fibonacci we choose the iterative method --> O(n) time complexity, O(1) memory
    public static BigInteger fibIterative(int n) {
        if (n == 1) return BigInteger.ONE;
        if (n == 0) return BigInteger.ZERO;

        BigInteger a = BigInteger.ZERO; //F(0)
        BigInteger b = BigInteger.ONE; //F(1)

        for (int i = 2; i <= n; i++) {
            BigInteger c = a.add(b); //F(i)
            a = b;
            b = c;
        }
        return b; //F(n)
    }

    public static void longestAlternatingSubarrayProb(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Longest alternating subarray length is: " + arr.length);
            return;
        }
        int maxLength = 1;
        int currentLength = 2;

        for (int i = 2; i < arr.length; i++) { //Ξεκινάμε από 2 γιατί θέλουμε να ελέγξουμε arr[i-2]. Διατρέχουμε τον πίνακα μία φορά: O(n), Δεν χρειάζεται επιπλέον χώρος εκτός από μερικές μεταβλητές: O(1)
            if ((arr[i] > arr[i - 1] && arr[i - 1] < arr[i - 2]) || (arr[i] < arr[i - 1] && arr[i - 1] > arr[i - 2])) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 2;  // Ξεκινά νέο ζεύγος εναλλαγής
            }
        }
        maxLength = Math.max(maxLength, currentLength); // για την περίπτωση που το longest subarray τελειώνει στο τέλος του array (  Αν καταλήξει το max στο τέλος)
        System.out.println("Longest alternating subarray length is: " + maxLength);
    }

    // Arrival and departure time of vertices in DFS
    static int time = 0;

    public static void getArrivalAndDepartureTimeOfVerticesDFS(List<List<Integer>> graph, int v, boolean[] visited, int[] arrival, int[] departure) {
        visited[v] = true;
        arrival[v] = ++time;
        for (int u : graph.get(v)) {
            if (!visited[u]) {
                getArrivalAndDepartureTimeOfVerticesDFS(graph, u, visited, arrival, departure);
            }
        }
        departure[v] = ++time;
    }

    // Transitive closure of a graph with floyd warshall algorithm
    // cost[i][j] == 1 means there is a direct edge i -> j
    public static boolean[][] transitiveClosureOfGraphFloydWarshall(int[][] cost, int n) {
        boolean[][] reach = new boolean[n][n];
        // 1) init reachability from adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reach[i][j] = (cost[i][j] == 1);
            }
            // optional but typical: each node reaches itself
            reach[i][i] = true;
        }
        // 2) Floyd–Warshall for transitive closure:
        // if i can reach k and k can reach j => i can reach j
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                // small optimization: if i can't reach k, no need to try j
                if (!reach[i][k]) continue;

                for (int j = 0; j < n; j++) {
                    if (reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }
        return reach;
    }

    public static void printReach(boolean[][] reach) {
        for (int i = 0; i < reach.length; i++) {
            for (int j = 0; j < reach[i].length; j++) {
                System.out.print((reach[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    //Check if a graph is strongly connected or not -------------------------------------------
    public static boolean isGraphStronglyConnected(List<List<Integer>> graph, int n) {
        if (n == 0) return true;
        // 1) Traverse original graph from 0
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        if (!allVisited(visited)) return false;

        // 2) Build reversed graph
        List<List<Integer>> reversed = reverseGraph(graph, n);

        // 3) Traverse reversed graph from 0
        Arrays.fill(visited, false);
        dfs(reversed, 0, visited);
        return allVisited(visited);
    }

    // ----- DFS -----
    private static void dfs(List<List<Integer>> g, int start, boolean[] visited) {
        visited[start] = true;
        for (int nei : g.get(start)) {
            if (!visited[nei]) dfs(g, nei, visited);
        }
    }

    // ----- BFS (αντί για DFS, ίδιο concept) -----
    private static void bfs(List<List<Integer>> g, int start, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // Reverse adjacency list for directed graph
    private static List<List<Integer>> reverseGraph(List<List<Integer>> graph, int n) {
        List<List<Integer>> rev = new ArrayList<>(n);
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());

        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                rev.get(v).add(u); // reverse edge u -> v becomes v -> u
            }
        }
        return rev;
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean b : visited) if (!b) return false;
        return true;
    }


    //All-Pairs Shortest Paths – Floyd Warshall Algorithm
    static final long INF = (long) 1e15;  //this should be at the beginning of the class
    public static void floydWarshall(long[][] dist){
        int n = dist.length;
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                // μικρή βελτιστοποίηση: αν i->k δεν υπάρχει, μην προσπαθείς
                if(dist[i][k] == INF) continue;;
                for(int j = 0; j < n; j++){
                    if(dist[k][j] == INF) continue;
                    long candidate = dist[i][k] + dist[k][j];
                    if(candidate < dist[i][j]){
                        dist[i][j] = candidate;
                    }
                }


            }
        }
    }

    //Find itinerary from the given list of departure and arrival airports
    public static List<String> findItenaryFromListOfDepartAndArrivalAirports(List<String[]> tickets){
        Map<String, String> nextByFrom = new HashMap<>();
        Set<String> arrivals = new HashSet<>();
        for(String[] t : tickets){
            String from = t[0];
            String to = t[1];
            nextByFrom.put(from, to);
            arrivals.add(to);
        }

        String start = null;
        for(String from : nextByFrom.keySet()){
            if(!arrivals.contains(from)){
               start = from;
               break;
            }
        }
        if(start == null){
            throw new IllegalArgumentException("No valid start airport found.");
        }
        List<String> route = new ArrayList<>();
        String cur = start;
        route.add(cur);
        while(nextByFrom.containsKey(cur)){
            cur = nextByFrom.get(cur);
            route.add(cur);
        }
        return route;
    }


    //Convert max heap to min heap in linear time
    public static void convertMaxToMinHeap(int[] a) {
        int n = a.length;
        // build min-heap bottom-up
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(a, n, i);
        }
    }

    private static void minHeapify(int[] a, int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < n && a[left] < a[smallest]) {
                smallest = left;
            }
            if (right < n && a[right] < a[smallest]) {
                smallest = right;
            }

            if (smallest == i) break;

            int tmp = a[i];
            a[i] = a[smallest];
            a[smallest] = tmp;

            i = smallest; // συνεχίζουμε προς τα κάτω
        }
    }

    //  Connect n ropes with minimal cost
    public static long minCostToConnect(int[] ropes){
        if(ropes.length <=1 || ropes == null) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int r : ropes){
            pq.add((long) r);
        }
        int totalCost = 0;

        while(pq.size() >1){
            long a = pq.poll();  // smallest
            long b = pq.poll(); //second smallest
            long merged = a + b;

            totalCost += merged;
            pq.add(merged);
        }
        return totalCost;
    }

    //Replace each array element by its corresponding rank
    public static int[] replaceRank(int[] arr) {
        int n = arr.length;

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank);
                rank++;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }

    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Function takes a linked list and returns its complete copy
    public static Node copyList(Node head)
    {
        Node current = head;    // used to iterate over the original list
        Node newList = null;    // head of the new list
        Node tail = null;       // point to the last node in a new list

        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new Node(current.data, null);
                tail = newList;
            }
            else {
                tail.next = new Node();
                tail = tail.next;
                tail.data = current.data;
                tail.next = null;
            }
            current = current.next;
        }

        return newList;
    }

//    public static LinkedList<String> cloneLinkedList(LinkedList<String> initial){
//        LinkedList<String> cloned = new LinkedList<>();
//        cloned = (LinkedList<String>) initial.clone();
//        return cloned;
//    }
    public static LinkedList<String> cloneLinkedList(LinkedList<String> initial) {
        return (LinkedList<String>) initial.clone();
    }

    public static void deleteLinkedList(LinkedList<String> initial){
        if(initial.isEmpty()){
            throw new IllegalArgumentException("List is already empty");
        }
        initial.clear();
    }

}























