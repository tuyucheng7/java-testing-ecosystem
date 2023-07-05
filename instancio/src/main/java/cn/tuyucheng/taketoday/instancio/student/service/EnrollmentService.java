package cn.tuyucheng.taketoday.instancio.student.service;

import cn.tuyucheng.taketoday.instancio.student.model.Course;
import cn.tuyucheng.taketoday.instancio.student.model.Grade;
import cn.tuyucheng.taketoday.instancio.student.model.Student;

import java.util.Collection;

public class EnrollmentService {

   private CourseService courseService;

   public boolean enrollStudent(Student student, Course course) {
      Collection<Grade> grades = student.getCourseGrades().values();
      if (grades.contains(Grade.F)) {
         throw new EnrollmentException(String.format("Student %s has at least 1 failed course", student.getId()));
      }
      // process enrollment...
      return true;
   }

   public boolean enrollStudent(Student student, String courseCode) {
      Course course = courseService.getByCode(courseCode);
      if (course == null) {
         throw new EnrollmentException("Course not found: " + courseCode);
      }
      return enrollStudent(student, course);
   }
}