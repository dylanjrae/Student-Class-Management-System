package Client;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainView extends JFrame {

	private JButton searchButton = new JButton ("Search Catalogue Courses");
	private JButton addCourseButton = new JButton ("Add Course to Student Courses");
	private JButton removeCourseButton = new JButton ("Remove Course from Student Course");
	private JButton viewAllCoursesButton  = new JButton ("View all Courses");
	private JButton viewAllStudentCoursesButton  = new JButton ("View all Courses Taken by a Student");
//	private JButton createCourseButton = new JButton("Create a New Course");
	private JButton quitButton = new JButton ("Quit");
	
	private JTextArea myText;
	//char userType;
	
	public MainView() {
		
		super("Main Menu");
		setSize(1250, 250);
		setLayout(new BorderLayout());
		
		//North
		JPanel north = new JPanel();
		north.add(new JLabel("Welcome to the Main Menu. Please select from the options below."));
		add("North", north);
		
		//Center
		JPanel south = new JPanel();
		south.add(searchButton);
		south.add(addCourseButton);
		south.add(removeCourseButton);
		south.add(viewAllCoursesButton);
		south.add(viewAllStudentCoursesButton);
		south.add(quitButton);

		add("South", south);
		
		//South
		//JPanel south = new JPanel();
		myText = new JTextArea();
		add("Center", new JScrollPane(myText));
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Displays option pane to gather course name and course number.
	 * @return The user input as a string for course name and number
	 */
	public String searchInputDisplay() {
		UIManager.put("OptionPane.cancelButtonText", "Return to Main Window"); // add cancel button
		UIManager.put("OptionPane.okButtonText", "Search"); //add ok button
		JTextField courseName = new JTextField(10); //Width of text field
		JTextField courseNum = new JTextField(10);
		Object[] inputFile = {"Enter the Course Name", courseName, "Enter the Course Number", courseNum,};
		int option = JOptionPane.showConfirmDialog(null,  inputFile, "Course Search", JOptionPane.OK_CANCEL_OPTION); //Brings up dialog titled input with input file displayed
		//if the fields are not null then proceed
		if (option == JOptionPane.OK_OPTION && !courseName.getText().toString().contentEquals("") && !courseNum.getText().toString().contentEquals("")) {
			String cName = courseName.getText().toString();
			String cNum = courseNum.getText().toString();
			String stringOut = cName + cNum;
			return stringOut;
		}
		else if (option ==JOptionPane.CANCEL_OPTION) {
			return null;
		}
		else {
			UIManager.put("OptionPane.okButtonText", "Ok");
			JOptionPane.showMessageDialog(null, "Search Invalid. Please Try Again.");
			return null;
		}
	}
	
	/**
	 * Displays the String in(course search info) in an option pane
	 * @param in the course info to be printed. New lines should be represented by \0
	 */
	public void searchOutputDisplay(String in) {
		//in.replace("\0", "\n");
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Course Info: " + in);
	}
	
	public String addCourseDisplay() {
		UIManager.put("OptionPane.cancelButtonText", "Return to Main Window"); // add cancel button
		UIManager.put("OptionPane.okButtonText", "Add Course"); //add ok button
		JTextField studentId = new JTextField(10);
		JTextField courseName = new JTextField(10);
		JTextField courseNum = new JTextField(10);
		JTextField courseSection = new JTextField(10); 
		Object[] inputFile = {"Enter the Student ID", studentId, "Enter the Course Name", courseName, "Enter the Course Number", courseNum, "Enter the Course Section Number", courseSection};
		int option = JOptionPane.showConfirmDialog(null,  inputFile, "Add Course", JOptionPane.OK_CANCEL_OPTION); //Brings up dialog titled input with input file displayed
		//if the fields are not null then proceed
		if (option == JOptionPane.OK_OPTION && !studentId.getText().contentEquals("") && !courseName.getText().contentEquals("") && !courseNum.getText().contentEquals("") && !courseSection.getText().contentEquals("")) {
			String id = studentId.getText().toString();
			String cName = courseName.getText().toString();
			String cNum = courseNum.getText().toString();
			String cSec = courseSection.getText().toString();
			String stringOut = id + cName + cNum + cSec;
			//System.out.println("You have the string: "+ stringOut + " ready to send");
			return stringOut;
		}
		return null;
	}
	
	public void addCourseSuccess(String in) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, in);
	}
	
//	public void addCourseFailure() {
//		UIManager.put("OptionPane.okButtonText", "Ok");
//		JOptionPane.showMessageDialog(null, "Course Adding Failed. Please Try Again.");
//	}
	
	public String removeCourseDisplay() {
		UIManager.put("OptionPane.cancelButtonText", "Return to Main Window"); // add cancel button
		UIManager.put("OptionPane.okButtonText", "Remove Course"); //add ok button
		JTextField studentId = new JTextField(10);
		JTextField courseName = new JTextField(10);
		JTextField courseNum = new JTextField(10);
		JTextField courseSection = new JTextField(10); 
		Object[] inputFile = {"Enter the Student ID", studentId, "Enter the Course Name", courseName, "Enter the Course Number", courseNum, "Enter the Course Section Number", courseSection};
		int option = JOptionPane.showConfirmDialog(null,  inputFile, "Remove Course", JOptionPane.OK_CANCEL_OPTION); //Brings up dialog titled input with input file displayed
		//if the fields are not null then proceed
		if (option == JOptionPane.OK_OPTION && !studentId.getText().contentEquals("") && !courseName.getText().contentEquals("") && !courseNum.getText().contentEquals("") && !courseSection.getText().contentEquals("")) {
			String id = studentId.getText().toString();
			String cName = courseName.getText().toString();
			String cNum = courseNum.getText().toString();
			String cSec = courseNum.getText().toString();
			String stringOut = id + cName + cNum + cSec;
			System.out.println("You have the string: "+ stringOut + " ready to send");
			return stringOut;
		}
		return null;
	}
	
	public void removeCourseSuccess(String in) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, in);
	}
	
	public void removeCourseFailure() {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Course Removal Failed. Please Try Again.");
	}
	
	public void displayAllCourses(String text) {
		myText.setText(text);
	}
	
	public String viewStudentCoursesDisplay() {
		UIManager.put("OptionPane.cancelButtonText", "Return to Main Window"); // add cancel button
		UIManager.put("OptionPane.okButtonText", "View Students Courses"); //add ok button
		JTextField studentId = new JTextField(10);
	
		Object[] inputFile = {"Enter the Student ID", studentId};
		int option = JOptionPane.showConfirmDialog(null,  inputFile, "View Students Courses", JOptionPane.OK_CANCEL_OPTION); //Brings up dialog titled input with input file displayed
		//if the fields are not null then proceed
		if (option == JOptionPane.OK_OPTION && !studentId.getText().contentEquals("")) {
			String id = studentId.getText().toString();
			String stringOut = id;
			System.out.println("You have the string: "+ stringOut + " ready to send");
			return stringOut;
		}
		return null;
	}
	
	public void viewStudentCoursesResult(String s) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Student Course Info: " + s);
	}
	
	public void addSearchButtonListener(ActionListener listenForStudentButton) {
		searchButton.addActionListener(listenForStudentButton);
	}
	
	public void addAddCourseButtonListener(ActionListener listenForStudentButton) {
		addCourseButton.addActionListener(listenForStudentButton);
	}
	
	public void addRemoveCourseButtonListener(ActionListener listenForStudentButton) {
		removeCourseButton.addActionListener(listenForStudentButton);
	}
	
	public void addViewAllCoursesButtonListener(ActionListener listenForStudentButton) {
		viewAllCoursesButton.addActionListener(listenForStudentButton);
	}
	
	public void addViewAllStudentCoursesButtonListener(ActionListener listenForStudentButton) {
		viewAllStudentCoursesButton.addActionListener(listenForStudentButton);
	}
	
	public void addQuitButtonListener(ActionListener listenForStudentButton) {
		quitButton.addActionListener(listenForStudentButton);
	}
	
//	public void setUserType(char b) {
//	System.out.println("User type is: "+ userType);
//	this.userType = b;
//	System.out.println("User type is: "+ userType);
//
	
}
