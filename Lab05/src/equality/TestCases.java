package equality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

public class TestCases
{
   @Test
   public void testExercise1()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertTrue(one.equals(two));
      assertTrue(two.equals(one));
   }

   @Test
   public void testExercise2()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(1, 10), LocalTime.of(2, 0));

      assertFalse(one.equals(two));
      assertFalse(two.equals(one));
   }

   @Test
   public void testExercise3()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertEquals(one.hashCode(), two.hashCode());
   }

   @Test
   public void testExercise4()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
         LocalTime.of(9, 10), LocalTime.of(10, 0));

      assertNotEquals(one.hashCode(), two.hashCode());
   }

   @Test
   public void testStudent1()
   {
      CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      CourseSection two = new CourseSection("CPE", "133", 34,
              LocalTime.of(11, 10), LocalTime.of(12, 0));
      ArrayList<CourseSection> courseList = new ArrayList<CourseSection>();
      courseList.add(one);
      courseList.add(two);

      Student Luke = new Student("Waltz", "Luke", 19,
              courseList);
      Student Rish = new Student("Gupta", "Rishi", 19,
              courseList);

      assertFalse(Luke.equals(Rish));
      assertFalse(Rish.equals(Luke));
   }


   @Test
   public void testStudent2()
   {
      CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      CourseSection two = new CourseSection("CPE", "133", 34,
              LocalTime.of(11, 10), LocalTime.of(12, 0));
      ArrayList<CourseSection> courseList = new ArrayList<CourseSection>();
      courseList.add(one);
      courseList.add(two);

      Student Luke1 = new Student("Waltz", "Luke", 19,
              courseList);
      Student Luke2 = new Student("Waltz", "Luke", 19,
              courseList);

      assertTrue(Luke1.equals(Luke2));
      assertTrue(Luke2.equals(Luke1));
   }
}
