import java.lang.reflect.Array;

/* this part is as comment similar to comments in Python
CPE/CSC 203 Lab00
Name: Luke Waltz

Section: 07

*/
public class Lab00 {
    public static void main(String[] arguments) {

        //declaring and initializing some variables

        int x = 5;

        String y = "hello";

        float z = 9.8f;

        //printing the variables

        System.out.println("x: " + x + " y: "+ y + " z: " + z);

        //a list (make an array)

        int[] nums = {3, 6, -1, 2};

        for (int i = 0; i < nums.length; i++){
          System.out.println(nums[i]);
        }

        //call a function

        int numFound = char_count(y, 'l');

        System.out.println("Found: " + numFound);

        //counting for loop

        for (int i = 0; i < 11; i++){
            System.out.print(i+" ");
        }
    }

    //function counts the given character in the given string
    //string string --> int
    public static int char_count(String s, char c){

        int count = 0;

        for (int j = 0; j < s.length(); j++){
            if (s.charAt(j) == c){
                count++;
            }
        }
        return count;
    }
}