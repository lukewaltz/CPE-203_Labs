package part2;

import part1.CourseGrade;

import java.util.List;

public class Applicant {

    //attributes - instance variables
    private String name;
    private List<CourseGrade> grades;

    private int timeEmployed;
    //years

    //Constructors
    public Applicant(String name, List<CourseGrade> grades)
    {
        this.name = name;
        this.grades = grades;
    }

    public Applicant(String name, List<CourseGrade> grades, int timeEmployed)
    {
        this.name = name;
        this.grades = grades;
        this.timeEmployed = timeEmployed;
    }

    //getters - accessors
    public String getName()
    {
        return this.name;
    }

    public List<CourseGrade> getGrades()
    {
        return this.grades;
    }

    public CourseGrade getGradeFor(String course)
    {
        for (CourseGrade grade : grades){
            if (grade.getCourseName().equals(course)){
                return grade;
            }
        }
        return null;
    }

    public int getTimeEmployed()
    {
        return this.timeEmployed;
    }

}

