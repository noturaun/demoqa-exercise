package tests;
import org.junit.jupiter.api.Test;

import java.util.*;

import com.github.javafaker.Faker;


import static Utils.CodingTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    Faker faker = new Faker();

    @Test
    void testStringFormat() {
        int row = 1;
        int col = 2;
        String path = String.format("//div[@class='rt-tbody']//div[@class='rt-tr-group'][%s]//div[@class='rt-td'][%s]",row,col);

        System.out.println(path);
        assertTrue(path.matches("(?i).*div\\[@class='rt-td'\\]\\[2\\].*"));
    }

    @Test
    void bulkInput(){
        int num = 3;
        List<Map<String, String>> dataList = new LinkedList<>();
//        Map<String,String> data = new HashMap<>();
        for (var i = 0; i < num; i++){
            Map<String, String> data = new HashMap<>();
            data.put("firstName", faker.name().firstName());
            data.put("lastName", faker.name().lastName());
            data.put("email", faker.internet().emailAddress());
            data.put("age", faker.number().digits(2));
            data.put("salary", faker.number().digits(5));
            data.put("dept", faker.company().name());
            dataList.add(data);
        }
        for (var data : dataList) {
            System.out.println(data);
        }
    }

    @Test
    void testBus() {
        int[] familyMembers = new int[]{1,2,4,3,4};
        System.out.println(howManyBus(5,familyMembers));
    }


    @Test
    void testPalindrom() {
        assertTrue(isPalindrom("a"));
        assertTrue(isPalindrom("aba"));
        assertTrue(isPalindrom("kodok"));
        assertTrue(isPalindrom(""));
        assertTrue(isPalindrom("abababa"));

        assertFalse(isPalindrom("abc"));
        assertFalse(isPalindrom("abbb"));
        assertFalse(isPalindrom("tahu"));
//        isPalindrom("aba");
    }

    @Test
    void testFizzBuzz() {
        fizzBuzz(25);
    }

    @Test
    void testTwoSum() {
        int[] arr = {1, 4, 5};
        int[] arr1 = {7,6,8,3,4,5};
        twoSum(arr, 5);

        assertArrayEquals(new int[] {0,2}, twoSum(arr1,15));
    }

    @Test
    void testPalindromeNum() {
        assertTrue(palindromeNum(122221));
    }

    @Test
    void testRomanToInt() {
        assertEquals(2020, romanToInt("MMXX"));
    }

    @Test
    void testInput() {
        var input = new Scanner(System.in);
        var q = input.nextLine();
        System.out.println(q);
    }

    @Test
    void testLongestCommonPrefix() {
        String[] input = {"test", "teseract", "tersier", "terima"};
        assertEquals("te", longestCommonPrefix(input));
    }

    @Test
    void testSearchInsert() {
        int[] nums = {1,3,4,5,6};
        int x = searchInsert(nums, 2);
        System.out.println(nums.length);
        System.out.println(x);
        String p = "AGRAGAWEGWE ggweg";
        p.trim().toLowerCase();
        System.out.println(p);
    }


    @Test
    void testVaccinationCode() {
        checkVaccine("ACH100138215");
    }

    @Test
    void testprintFirst() {
        printFirst("Sample Case");
    }
}
