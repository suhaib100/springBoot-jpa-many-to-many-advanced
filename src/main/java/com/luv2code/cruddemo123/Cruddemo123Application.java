package com.luv2code.cruddemo123;

import com.luv2code.cruddemo123.dao.AppDao;
import com.luv2code.cruddemo123.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Cruddemo123Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo123Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO){
		return runner -> {

		//	createCourseAndStudents(appDAO);

		//	findCourseAndStudents(appDAO);


		//	findStudentAndCourses(appDAO);

		//	addMoreCoursesForStudent(appDAO);

		//	deleteCourse(appDAO);

		deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDao appDAO) {

	int theId = 1;
		System.out.println("deleting student id : "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("done");

	}

	private void addMoreCoursesForStudent(AppDao appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		Course course1 = new Course("Rubik cube - how to speed cube");
		Course course2 = new Course("ataria 2600 - game development");

		tempStudent.addCourse(course1);
		tempStudent.addCourse(course2);

		System.out.println("updating  student : "+tempStudent);
		System.out.println("associated courses : "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("done");



	}

	private void findStudentAndCourses(AppDao appDAO) {
		int theId = 1;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded students : "+ tempStudent);
		System.out.println("courses :  "+tempStudent.getCourses());
		System.out.println("done");
	}

	private void findCourseAndStudents(AppDao appDAO) {
		int theId=10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Loaded courses : "+tempCourse);
		System.out.println("Students : "+ tempCourse.getStudents());
		System.out.println("done");


	}

	private void createCourseAndStudents(AppDao appDAO) {

		Course tempCourse = new Course("pacman - how to score  one million points");
		Student tempStudent1 = new Student("john","doe","john@luv2code");
		Student tempStudent2 = new Student("mary","public","mary@luv2code");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("saving the course : "+tempCourse);
		System.out.println("associated courses :  "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("done");

	}

	private void deleteCourseAndReviews(AppDao appDAO) {
		int theId=10;
		System.out.println("deleting course id : "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void retrieveCourseAndReviews(AppDao appDAO) {

		int theId=10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("done");



	}

	private void createCourseAndReviews(AppDao appDAO) {

		Course tempCourse = new Course("pacman - how to score one million points...");
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("cool course ... loved it well !"));
		tempCourse.addReview(new Review("dumb course ...  not loved it!"));

		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);

		System.out.println("done ! ");

	}

	private void deleteCourse(AppDao appDAO) {
		int theId=10;
		System.out.println("deleting course id : "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void updateCourse(AppDao appDAO) {
		int theId=10;
		System.out.println("finding course id : "+theId);
		Course tempCourse=  appDAO.findCourseById(theId);
		System.out.println("updating course id : "+ theId);
		tempCourse.setTitle("enjoy the simple things ");
		appDAO.update(tempCourse);
		System.out.println("done..");


	}

	private void updateInstructor(AppDao appDAO) {
		int 	theId=1;

		System.out.println("finding instructor id : "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("updating instructor : "+theId);
		tempInstructor.setLastName("tester");
		appDAO.update(tempInstructor);
		System.out.println("done");


	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDAO) {
		int 	theId=1;

		System.out.println("finding instructor id : "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor : "+tempInstructor);


		System.out.println("the associated courses : "+ tempInstructor.getCourses());
		System.out.println("done");

	}

	private void findCoursesForInstructor(AppDao appDAO) {

		int 	theId=1;

		System.out.println("finding instructor id : "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor : "+tempInstructor);

		System.out.println("finding courses for instructor id : "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses : "+ tempInstructor.getCourses());
		System.out.println("done");

	}

	private void findInstructorWithCourses(AppDao appDAO) {

	int 	theId=1;

		System.out.println("finding instructor id : "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the associated courses : "+tempInstructor.getCourses());
		System.out.println("done");


	}

	private void createInstructorWithCourses(AppDao appDAO) {
		Instructor tempInstructor =
				new Instructor("susan","public","susan@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com","vedio games");



		tempInstructor.setInstructorDetail(tempInstructorDetail);


		Course t1 = new Course("Air Guitar - the ultimate guide");

		Course t2 = new Course("The pinball master class");
		tempInstructor.addCourse(t1);
		tempInstructor.addCourse(t2);
		System.out.println("saving instructor : "+tempInstructor);
		System.out.println("the courses : " + tempInstructor.getCourses() );
		appDAO.save(tempInstructor);
		System.out.println("done");
	}

	private void deleteInstructorDetail(AppDao appDAO) {

		int theId=3;
		System.out.println("Deleting Instructor datail id : "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done");






	}

	private void findInstructorDetail(AppDao appDAO) {
		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail : "+ tempInstructorDetail);
		System.out.println("associated instructor : "+tempInstructorDetail.getInstructor());
		System.out.println("done");



	}

	private void deleteInstructor(AppDao appDAO) {
		int theId=1;
		System.out.println("deleting instructor id : "+ theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDao appDAO) {
		int theId=2;
		System.out.println("finding instructor id : "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor : "+ tempInstructor);
		System.out.println("the associated instructor detail : "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDAO) {
		/*
		Instructor tempInstructor =
				new Instructor("chad","darby","darby@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code !!!");

		*/

		Instructor tempInstructor =
				new Instructor("madhu","patel","madhu@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","guitar");



		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor : "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("save");

	}
}
