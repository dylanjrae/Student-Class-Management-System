

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {

	EntryView entryView;
	LogInView logInView;
	MainView mainView;

	
	public GUIController(EntryView entryView, LogInView logInView, MainView mainview)
	{
		setEntryView(entryView);
		this.entryView.addStudentButtonListener(new addStudentButtonListener());
		this.entryView.addAdminButtonListener(new addAdminButtonListener());
		
		setLogInView(logInView);
		this.logInView.addCancelButtonListener(new addCancelButtonListener());
		this.logInView.addLogInButtonListener(new addLogInButtonListener());
	
		
		setMainView(mainview);
		this.mainView.addSearchButtonListener(new addSearchButtonListener());
		this.mainView.addAddCourseButtonListener(new addAddCourseButtonListener());
		this.mainView.addRemoveCourseButtonListener(new addRemoveCourseButtonListener());
		this.mainView.addViewAllCoursesButtonListener(new addViewAllCoursesButtonListener());
		this.mainView.addViewAllStudentCoursesButtonListener(new addViewAllStudentCoursesButtonListener());
		this.mainView.addQuitButtonListener(new addQuitButtonListener());
		
	}


	
	public class addSearchButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Search!");
		}
	}
	
	public class addAddCourseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("add course!!");
		}
	}
	
	public class addRemoveCourseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("remove course!!");
		}
	}
	
	public class addViewAllCoursesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("view all course!!");
		}
	}
	
	public class addViewAllStudentCoursesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("view all student course!!");
		}
	}
	
	public class addQuitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Quit");
			System.exit(1);
		}
	}
	
	public class addLogInButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("login");
			//System.out.println(logInView.getUsernameField().getText().toString());
			//get: logInView.getUsernameField().getText().toString()
			//check to make sure it matches in database
			if(logInView.getUsernameField().getText().toString().contentEquals("11")) {
				logInView.displayLogInSuccess();
				mainView.setVisible(true);
				logInView.setVisible(false);
			}
			else
				logInView.displayLogInError();
		}
	}
	
	public class addCancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			logInView.setVisible(false);
			entryView.setVisible(true);
			System.out.println("cancel");
		}
	}
	
	
	public class addStudentButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//mainView.setUserType('s');	
			System.out.println("STUDENT");
			entryView.setVisible(false);
			logInView.setVisible(true);
				
				 //false means student mode turned on
		}
	}
	
	public class addAdminButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//mainView.setUserType('a');
			System.out.println("ADMIN");
			entryView.setVisible(false);
			logInView.setVisible(true);
		}
	}
	
	public void setEntryView(EntryView entryView) {
		this.entryView = entryView;
	}


	public void setLogInView(LogInView logInView) {
		this.logInView = logInView;
	}


	public void setMainView(MainView mainview) {
		this.mainView = mainview;
	}
	
	
}