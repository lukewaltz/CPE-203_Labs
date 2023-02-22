
package part2;

import org.junit.jupiter.api.Test;
import part1.CourseGrade;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{


    //This test is just to get you started.


   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals("Aakash", testApplicant.getName());
   }

   @Test
   public void testGetName2() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Shaw", grades);
      assertEquals("Shaw", testApplicant.getName());
   }

   @Test
   public void testGetName3() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Rish", grades);
      assertEquals("Rish", testApplicant.getName());
   }

   @Test
   public void testGetGrades() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testGetGrades2() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 90),
              new CourseGrade("Data Structures", 90),
              new CourseGrade("Algorithms", 90),
              new CourseGrade("Computer Organization", 90),
              new CourseGrade("Operating Systems", 90),
              new CourseGrade("Non-CS", 90)
      );
      Applicant testApplicant = new Applicant("Aayush", grades);
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testGetGrades3() {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 0),
              new CourseGrade("Data Structures", 0),
              new CourseGrade("Algorithms", 0),
              new CourseGrade("Computer Organization", 0),
              new CourseGrade("Operating Systems", 0),
              new CourseGrade("Non-CS", 0)
      );
      Applicant testApplicant = new Applicant("Luke", grades);
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testGetGradeFor() {
      CourseGrade expect = new  CourseGrade("Intro to CS", 100);
      List<CourseGrade> grades = Arrays.asList(
              expect,
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals(expect, testApplicant.getGradeFor("Intro to CS"));
   }

   @Test
   public void testGetGradeFor1() {
      List<CourseGrade> grades = Arrays.asList(
              new  CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      CourseGrade expect = new  CourseGrade("Intro to CS", 98);
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertNotEquals(expect, testApplicant.getGradeFor("Intro to CS"));
   }

   @Test
   public void testGetTimeEmployed0()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades, 5);
      assertEquals(5, testApplicant.getTimeEmployed());
   }

   @Test
   public void testGetTimeEmployed1()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades, 5);
      assertEquals(5, testApplicant.getTimeEmployed());
   }

   @Test
   public void testGetTimeEmployed2()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Luke", grades, 0);
      assertEquals(0, testApplicant.getTimeEmployed());
   }

   @Test
   public void testGetTimeEmployed3()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Shaw", grades, 2);
      assertEquals(2, testApplicant.getTimeEmployed());
   }

/*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */

   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, Applicant.class.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue(expectedMethodNames.size()+1 >= publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}

