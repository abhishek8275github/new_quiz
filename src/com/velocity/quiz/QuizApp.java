package com.velocity.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class QuizApp  implements QzInterface {

	Connection con = null;
	Statement st = null;
	ResultSet rs=null;
	Student student = new Student();
	Scanner sc = new Scanner(System.in);

	// to get user details
	public Student getUserDetails() {
		System.out.print("Enter your First Name :: ");
		student.setfName(sc.nextLine());
		System.out.print("Enter your Last Name :: ");
		student.setlName(sc.nextLine());
		System.out.print("Enter your Mobile Number :: ");
		student.setMobileNumber(sc.nextLong());
		return student;
	}

	// get connection and statement object
	public Statement getStatement() {
		Connector conect = new Connector();
		con = conect.dbConnection();


		try {
			st = con.createStatement();
			//st.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return st;

	}

	// select services from the list
	public void selectService(Student details) {
		System.out.printf("\nTo Attempt Quiz  ::Enter->1 %nTo Get Result ::Enter->2 %nTo Get Merit List  ::Enter->3 %nTo Exit From Quiz ::Enter->4 %n ");
		int service = sc.nextInt();
		switch (service) {

		case 1:
			checkEntry(details);
			break;
		case 2:
			displayResult(details);
			break;
		case 3:
			getMeritList();
			break;
		case 4:
			System.exit(0);

		default:
			break;
		}		
	}

	// restrict student to give exam only once
	public Student checkEntry(Student details){
		getStatement();
		// check whether table is empty or not
		String SqlQueryCheck = "select exists(select 1 from quiz.students);";
		int empty = 0;
		try {
			 rs = st.executeQuery(SqlQueryCheck);
			while (rs.next()) {
				empty = rs.getInt(1);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		switch (empty) {
		case 0:
			attemptQuiz(details);
			break;
		// check whether Quiz attempted or not
		case 1:
			int attempted = 0;
			String sqlQueryStudentEntry = "select exists(select firstname,lastname from quiz.students where firstName='"
					+ details.getfName() + "' and lastname='" + details.getlName() + "');";
			try {
				 rs = st.executeQuery(sqlQueryStudentEntry);
				while (rs.next()) {
					attempted = rs.getInt(1);
				}
				switch (attempted) {
				case 0:
					attemptQuiz(details);
					break;
				case 1:
					System.out.println("You have already attempted Quiz");
					displayResult(details);
					break;
				default:
					break;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		default:
			break;
		}

		return student;

	}

	// give test and save data to database
	public Student attemptQuiz(Student details){
		int count = 0;
		getStatement();
		// iterate over all questions

		try {
			for (int i = 1; i <= 10; i++) {
				String sqlQuery = "select qno,question,option_1,option_2,option_3,option_4 from quiz.questionbanks "
						+ "where qno=" + i;
				 rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					System.out.printf("Q" + rs.getInt(1) + "]" + rs.getString(2) + "%n%n1-> " + rs.getString(3) + "%n2-> "
							+ rs.getString(4) + "%n3-> " + rs.getString(5) + "%n4-> " + rs.getString(6) + "%n");

				}
				// To restrict input to option availability
				int ans = 0;
				while (true) {
					System.out.print("Enter Your (option 1,2,3 and 4) Answer :: ");
					ans = sc.nextInt();
					if (ans > 0 && ans < 5){
						break;
					}
				 }		
				//}
				// check answer given by student with the right answer
				System.out.println("\n");
				String input = "select option_" + ans + " from quiz.questionbanks where qno=" + i; //option_1,option_2,...
				rs = st.executeQuery(input);
				String option = null;
				while (rs.next()) {

					option = rs.getString(1);
				}

				String sql = "select answer from quiz.questionbanks" + " where qno=" + i;
				rs = st.executeQuery(sql);
				String check = null;
				while (rs.next()) {
					check = rs.getString(1);
				}
				if (check.equals(option)) {
					count++;
				}
			}
			// calculate grade and save to database
			String fname = student.getfName();
			String lname = student.getlName();
			String grade = null;

			if (count >= 8) {
				grade = "A";
			} else if (count >= 6 && count <= 7) {
				grade = "B";
			} else if (count == 5) {
				grade = "C";
			} else {
				grade = "Fail";
			}
			String sqlQuery = "insert into students(firstname,lastname,score,grade)" + " values(" + "'" + fname + "'" + "," + "'"
					+ lname + "'" + "," + count + "," + "'" + grade + "'" + ")";

			st.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// display marks
	//	displayResult(details);
		selectService(details);
		return student;


	}

	@Override

	public void displayResult(Student details) {

		System.out.println("Result of " + student.getfName() + " " + student.getlName());
		getStatement();
		String sqlQuery =  "select concat(firstname,' ',lastname) as 'Full_Name',score,grade \r\n" + "from quiz.students\r\n"
				+ "where firstname='" + student.getfName() + "' && lastname='" + student.getlName() + "';";
		try {
			 rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				System.out.println("Name of Student::" + rs.getString(1) + "\r\n" + "Marks Obtained::"
						+ rs.getInt(2) + "\t" + "Grade::" + rs.getString(3));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		selectService(details);
	}

	// to display all students based on rank
	@Override
	public void getMeritList() {
		getStatement();
		String sqlQuery = "select rank() over (order by score desc) as 'Rank' ,\r\n"
				+ "concat(firstname,' ',lastname) as 'Student Name',score,grade\r\n"
				+ "from quiz.students order by score desc\r\n" + "; ";
		System.out.println("Rank\t Name Of Student\t MarksObtained\t Grade");
		try {
			 rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				System.out.printf(rs.getInt(1) + "\t " + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t "
						+ rs.getString(4) + "%n");
			}
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		selectService(student);
	}

	// to close resources
	public void closeResource() {
		try {
			st.close();
			con.close();
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void particularRecord() {

	}

}
