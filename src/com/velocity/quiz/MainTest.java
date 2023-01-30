package com.velocity.quiz;

public class MainTest {

	public static void main(String[] args) throws Exception{
      
		QuizApp qa = new QuizApp();
		Student st = new Student();
		
		qa.getUserDetails();
		try {
		qa.getStatement();
		qa.selectService(st);
		qa.attemptQuiz(st);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
