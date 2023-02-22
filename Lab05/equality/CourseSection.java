package equality;

import java.time.LocalTime;
import java.util.Objects;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public boolean equals(Object o) {
      if (o == null){return false;}
      if (o instanceof CourseSection casted) {
         return this.prefix != null && casted.prefix != null && (this.prefix.equals(casted.prefix))
                 && (this.enrollment == casted.enrollment)
                 && this.startTime != null && casted.startTime != null && (this.startTime.equals(casted.startTime))
                 && this.endTime != null && casted.endTime != null && (this.endTime.equals(casted.endTime));
      }
      return false;
   }

   public int hashCode(){
      return 31 + this.prefix.hashCode() + this.enrollment + this.number.hashCode() + this.startTime.hashCode() + this.endTime.hashCode();
   }

   // additional likely methods not defined since they are not needed for testing
}
