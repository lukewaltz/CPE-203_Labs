package equality;

import java.util.List;
import java.util.Objects;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   public int hashCode(){
      return Objects.hash(surname, givenName, age, currentCourses);
   }

   public boolean equals(Object o) {
      if (o instanceof Student casted) {
         return Objects.equals(this.surname, casted.surname)
                 && Objects.equals(this.givenName, casted.givenName)
                 && Objects.equals(this.age, casted.age)
                 && Objects.equals(this.currentCourses, casted.currentCourses);
      }
      return false;
   }


}
