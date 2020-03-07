package repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Grade;

public class MockGradeFactory {

	 public static List<Grade> getMockGrades() {
	       
	       List<Grade> grades = new ArrayList<>();
	 
	       Grade g1 = new Grade();
	       g1.setDate(new Date());
	       g1.setDetails("Der Student weisst alles.");
	       g1.setGrade("A");
	       g1.setLanguage("Deutsch");
	       grades.add(g1);
	       
	       Grade g2 = new Grade();
	       g2.setDate(new Date());
	       g2.setDetails("El esudiante sabe como se habla con mujeres del America del Sud.");
	       g2.setGrade("A");
	       g2.setLanguage("Espannol");
	       grades.add(g2);
	       
	       Grade g3 = new Grade();
	       g3.setDate(new Date());
	       g3.setDetails("Hong Kong Ching Chong");
	       g3.setGrade("A");
	       g3.setLanguage("M. Chinese");
	       grades.add(g3);
	      
	      return grades;

	   }
}
