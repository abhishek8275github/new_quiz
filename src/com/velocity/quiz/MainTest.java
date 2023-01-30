package com.velocity.quiz;

public class MainTest {

	public static void main(String[] args){
	      
		QuizApp qa = new QuizApp();
		Student st = new Student();
		
		
		try {
			qa.getUserDetails();
			qa.selectService(st);
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
