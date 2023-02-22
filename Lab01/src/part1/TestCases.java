package part1;

import java.util.*;

import org.junit.jupiter.api.Test;
import part2.Applicant;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant02()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()
   {
      /* TO DO: Write one more valid test case. - done */

      assertFalse(SimpleIf.analyzeApplicant(92, 99));
   }
   @Test
   public void testAnalyzeApplicant4()
   {
      assertTrue(SimpleIf.analyzeApplicant(90, 15));
   }

   @Test
   public void testAnalyzeApplicant5()
   {
      assertFalse(SimpleIf.analyzeApplicant(90, 99));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      /* TO DO: Write one more valid test case. - done */

      assertEquals(SimpleIf.maxAverage(89.9, 90), 90, DELTA);
   }
   @Test
   public void testMaxAverage4() {
      assertEquals(SimpleIf.maxAverage(96, 89), 96, DELTA);
   }

   @Test
   public void testMaxAverage5() {
      assertEquals(SimpleIf.maxAverage(9, 11), 11, DELTA);
   }

   @Test
   public void testAnalyzeApplicant2_1()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant luke = new Applicant("Luke", grades, 5);
      assertTrue(SimpleIf.analyzeApplicant2(luke));
   }

   @Test
   public void testAnalyzeApplicant2_2()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant shaw = new Applicant("Shaw", grades, 2);
      assertFalse(SimpleIf.analyzeApplicant2(shaw));
   }

   @Test
   public void testAnalyzeApplicant2_3()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant rish = new Applicant("Rish", grades, 1000);
      assertTrue(SimpleIf.analyzeApplicant2(rish));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {
      /* TO DO: Write one more valid test case to make sure that
         this function is not just returning 7. - done */

      assertEquals(10, SimpleLoop.sum(1, 4));
   }

   @Test
   public void testSimpleLoop4()
   {
      assertEquals(30, SimpleLoop.sum(6, 9));
   }

   @Test
   public void testSimpleLoop5()
   {
      assertEquals(24, SimpleLoop.sum(7, 9));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. - done */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      /* TO DO: Add a new test case. - done */

      assertArrayEquals(
           new boolean[] {false, false, false, true, true, false},
              SimpleArray.applicantAcceptable(new int[] {82, 83, 84, 85, 90, 75}, 84)
      );
   }

   @Test
   public void testSimpleArray4()
   {
      assertArrayEquals(
              new boolean[] {false, false, true, true},
              SimpleArray.applicantAcceptable(new int[] {80, 83, 98, 94}, 92));
   }

   @Test
   public void testSimpleArray5()
   {
      assertArrayEquals(
              new boolean[] {true, true, true, true},
              SimpleArray.applicantAcceptable(new int[] {98, 98, 98, 94}, 92));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
         new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Boolean> expected = Arrays.asList(false, false, true, true, false, false);

      /* TO DO: Add a new test case. - done */
      List<Integer> input = Arrays.asList(80, 85, 89, 92, 76, 81);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 88));
   }

   @Test
   public void testSimpleList3(){
      List<Boolean> expected = Arrays.asList(false, false, false, false, false, false);

      List<Integer> input = Arrays.asList(0, 0, 0, 0, 0, 0);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 80));
   }

   @Test
   public void testSimpleList4(){
      List<Boolean> expected = Arrays.asList(true, true, true, true, true, true);

      List<Integer> input = Arrays.asList(100, 100, 90, 90, 100, 150);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 80));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 92, 84, 88}));
   }

   @Test
   public void testFourOver85_3()
   {
      /* TO DO: Write a valid test case where the expected result is false. - done */
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {85, 80, 85, 75, 80, 92}));
   }

   @Test
   public void testFourOver85_4()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {80, 84, 90, 90, 84, 81}));
   }

   @Test
   public void testFourOver85_5()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {100, 100, 90, 90, 100, 90}));
   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2()
   {
      /* TO DO: Write another valid test case. */

      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
              Arrays.asList(
                      new CourseGrade("CPE 123", 90),
                      new CourseGrade("CPE 101", 91),
                      new CourseGrade("CPE 202", 92),
                      new CourseGrade("CPE 203", 100),
                      new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
              Arrays.asList(
                      new CourseGrade("CPE 101", 87),
                      new CourseGrade("CPE 202", 90),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 225", 100)));
      courseListsByStudent.put("Zoe",
              Arrays.asList(
                      new CourseGrade("CPE 123", 100),
                      new CourseGrade("CPE 203", 92),
                      new CourseGrade("CPE 471", 85),
                      new CourseGrade("CPE 473", 100),
                      new CourseGrade("CPE 476", 90),
                      new CourseGrade("CPE 572", 91)));

      List<String> expected = Arrays.asList("Julie", "Paul");

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 86)));
   }

   @Test
   public void testExampleMap3()
   {
      /* TO DO: Write another valid test case. - done */

      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
              Arrays.asList(
                      new CourseGrade("CPE 123", 90),
                      new CourseGrade("CPE 101", 91),
                      new CourseGrade("CPE 202", 92),
                      new CourseGrade("CPE 203", 100),
                      new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
              Arrays.asList(
                      new CourseGrade("CPE 101", 87),
                      new CourseGrade("CPE 202", 90),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 225", 100)));
      courseListsByStudent.put("Zoe",
              Arrays.asList(
                      new CourseGrade("CPE 123", 100),
                      new CourseGrade("CPE 203", 92),
                      new CourseGrade("CPE 471", 87),
                      new CourseGrade("CPE 473", 100),
                      new CourseGrade("CPE 476", 90),
                      new CourseGrade("CPE 572", 91)));

      List<String> expected = Arrays.asList("Julie", "Paul", "Zoe");

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 86)));
   }

   @Test
   public void testExampleMap4()
   {
      /* TO DO: Write another valid test case. - done */

      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
              Arrays.asList(
                      new CourseGrade("CPE 123", 0),
                      new CourseGrade("CPE 101", 1),
                      new CourseGrade("CPE 202", 28),
                      new CourseGrade("CPE 203", 10),
                      new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
              Arrays.asList(
                      new CourseGrade("CPE 101", 87),
                      new CourseGrade("CPE 202", 90),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 225", 100)));
      courseListsByStudent.put("Zoe",
              Arrays.asList(
                      new CourseGrade("CPE 123", 100),
                      new CourseGrade("CPE 203", 92),
                      new CourseGrade("CPE 471", 87),
                      new CourseGrade("CPE 473", 100),
                      new CourseGrade("CPE 476", 90),
                      new CourseGrade("CPE 572", 91)));

      List<String> expected = Arrays.asList("Paul", "Zoe");

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 70)));
   }

}
