package tests;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.github.javafaker.Faker;


import static Utils.CodingTest.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
