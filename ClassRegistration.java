import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ClassRegistration extends JFrame
{	
	//initializing variables needed
	private JLabel institution;
	private JLabel term;
	private JLabel subject;
	private JLabel courseNum;
	private JLabel instructor;
	private JLabel keyword;
	private JTextField institutionField;
	private JTextField termField;
	private JTextField subjectField;
	private	JTextField courseNumField;
	private JTextField instructorField;
	private JTextField keywordField;
	private JButton submitBtn;
	private JButton clrBtn;
	private JComboBox optionBox;
	private DrawPanel dp;
	private JScrollPane jsp;

	//initializing arrays to hold information
	private static final String[] options = {"begins with", "contains", "is exactly"};
	private static final String[] professors = new String[23];
	
	private static final String[] classNum = new String[23];
	
	private static final String[] roomNum = new String[23];
	
	private static final String[] classTime = new String[23];
	
	private static final String[] meetingDays = new String[23];
	
	private static final String[] classNames = new String[23];

	private ArrayList<Integer> results = new ArrayList<Integer>();
	
	//initializing values used for painting (displaying classes)
	int startX = 50;
	int startY = 50;
	int spacing = 70;
	
	//initializing JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    static final String DATABASE_URL = "jdbc:mysql://localhost/courseData";
	
	public ClassRegistration() 
	{
		super("Class Search");
		setLayout(null);
		
		//initializing components
		institution = new JLabel("Institution:");
		institution.setLocation(100,10);
		institution.setSize(150,30);
		add(institution);
		
		term = new JLabel("Term:");
		term.setLocation(100,40);
		term.setSize(150,30);
		add(term);
		
		subject = new JLabel("Subject:");
		subject.setLocation(100,70);
		subject.setSize(150,30);
		add(subject);
		
		courseNum = new JLabel("Course Number: ");
		courseNum.setLocation(100,100);
		courseNum.setSize(150,30);
		add(courseNum);
		
		instructor = new JLabel("Instructor: ");
		instructor.setLocation(100,130);
		instructor.setSize(150,30);
		add(instructor);
		
		keyword = new JLabel("Keyword: ");
		keyword.setLocation(100,160);
		keyword.setSize(150,30);
		add(keyword);
		
		institutionField = new JTextField("Cal Poly Pomona");
		institutionField.setEditable(false);
		institutionField.setLocation(230,10);
		institutionField.setSize(100,30);
		add(institutionField);
		
		termField = new JTextField("Summer Semester 2019");
		termField.setEditable(false);
		termField.setLocation(230,40);
		termField.setSize(160,30);
		add(termField);
		
		subjectField = new JTextField("Electrical & Computer Engr");
		subjectField.setEditable(false);
		subjectField.setLocation(230,70);
		subjectField.setSize(160,30);
		add(subjectField);
		
		courseNumField = new JTextField(" ");
		courseNumField.setLocation(230,100);
		courseNumField.setSize(100,30);
		add(courseNumField);
		
		instructorField = new JTextField(" ");
		instructorField.setLocation(330,130);
		instructorField.setSize(100,30);
		add(instructorField);
		
		keywordField = new JTextField(" ");
		keywordField.setLocation(230,160);
		keywordField.setSize(100,30);
		add(keywordField);
		
		clrBtn = new JButton("Clear");
		clrBtn.setLocation(100,250);
		clrBtn.setSize(115,30);
		add(clrBtn);
		
		submitBtn = new JButton("Submit");
		submitBtn.setLocation(215,250);
		submitBtn.setSize(115,30);
		add(submitBtn);
		
		optionBox = new JComboBox(options);
		optionBox.setLocation(230,130);
		optionBox.setSize(100,30);
		add(optionBox);
		
		ButtonHandler handler = new ButtonHandler();
		clrBtn.addActionListener(handler);
		submitBtn.addActionListener(handler);
		
		dp = new DrawPanel();
		jsp = new JScrollPane(dp);
		jsp.setLocation(100, 350);
		jsp.setSize(750, 400);
		
		Connection connection = null; // manages connection
		Statement statement = null; // query statement

		// connect to database courseData and query database
		try 
		{
			Class.forName( JDBC_DRIVER ); // load database driver class

			// establish connection to database
			connection = DriverManager.getConnection( DATABASE_URL,"root","");       
	          
			// create Statement for querying database
			statement = connection.createStatement();
	          
			// query database
			ResultSet resultSet = statement.executeQuery( 
			//    "SELECT data FROM courses table" );
					"SELECT * FROM courses" );
	          
			// process query results
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			int j = 0;
			
			while ( resultSet.next() ) 
			{
				for ( int i = 2; i <= numberOfColumns; i++ )
				{
					if (i == 2)
						professors[j] = resultSet.getString( i );
					else if (i == 3)
						classNum[j] = resultSet.getString( i );
					else if (i == 4)
						roomNum[j] = resultSet.getString( i );
					else if (i == 5)
						classTime[j] = resultSet.getString( i );
					else if (i == 6)
						meetingDays[j] = resultSet.getString( i );
					else if (i == 7)
						classNames[j] = resultSet.getString( i );
				}
				
				j++;
			} // end while
		}  // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
			System.exit( 1 );
		} // end catch
		catch ( ClassNotFoundException classNotFound ) 
		{
			classNotFound.printStackTrace();            
			System.exit( 1 );
		} // end catch
		finally // ensure statement and connection are closed properly
		{                                                             
			try                                                        
			{                                                          
				statement.close();                                      
				connection.close();                                     
			} // end try                                               
			catch ( Exception exception )                        
			{                                                          
				exception.printStackTrace();                                     
				System.exit( 1 );                                       
			} // end catch                                             
		} // end finally    
	}
	
	//used to space each element of a certain array to be a certain length to align the display by columns
	public void space(int input, String[] array, int spaceLen) {
		while (array[input].length() != spaceLen)
		{
			array[input] = array[input].concat(" ");
		}
	}

	private class ButtonHandler implements ActionListener
	{
		//variables used to get input from textfields
		String course;
		String instructor;
		String keyword;
		
		public void actionPerformed(ActionEvent event) {
			results.clear(); //clears the previous information each time as parameters for the search might be different
			if (event.getActionCommand() == "Submit") {
				course = courseNumField.getText().trim();	//trim gets rid of leading and trailing spaces
				instructor = instructorField.getText().trim();
				keyword = keywordField.getText().trim();
				if (course.matches("^\\d{4}|\\d{4}+L|^$") && instructor.matches("[a-zA-Z -]+|^$") && keyword.matches("[a-zA-Z]+|^$")) //regex to make sure input is valid
				{
					for (int i =0; i < classNum.length; i++) {
						if (classNum[i].contains(course)) {
							if (optionBox.getSelectedItem() == "begins with")
							{
								if (professors[i].toLowerCase().startsWith(instructor.toLowerCase())) {
									if (classNames[i].toLowerCase().contains(keyword.toLowerCase())) {
										results.add(i);
									}
								}
							}
							else if (optionBox.getSelectedItem() == "contains")
							{
								if (professors[i].toLowerCase().contains(instructor.toLowerCase())) {
									if (classNames[i].toLowerCase().contains(keyword.toLowerCase())) {
										results.add(i);
									}
								}
							}
							else if (optionBox.getSelectedItem() == "is exactly")
							{
								if (professors[i].toLowerCase().trim().equals(instructor.toLowerCase())) {
									if (classNames[i].toLowerCase().trim().contains(keyword.toLowerCase())) {
										results.add(i);
									}
								}
							}
						}
					}
					if (results.size() == 0)
					{
						JOptionPane.showMessageDialog(null, "No results were found. Please try again.");
						courseNumField.setText("");
						instructorField.setText("");
						keywordField.setText("");
						results.clear();
						repaint();
						remove(jsp);
					}
					else
					{
						//used to paint and display search results
						int dimX = 500;
						int dimY = (results.size() - 1) * 75;
						add(jsp);
						Dimension d = new Dimension(dimX, dimY);
						dp.setMinimumSize(d);
						dp.setMaximumSize(d);
						dp.setPreferredSize(d); 
						for (int i = 0; i < results.size(); i++)
						{
							space(results.get(i), professors, 25);
							space(results.get(i), roomNum, 10);
							space(results.get(i), classTime, 25);
						}
						repaint();
						jsp.setViewportView(dp);
					}
				}
				
				else	//displays error message based on which input is invalid
				{
					if (!course.matches("^\\d{4}|\\d{4}+L|^$")) {
						JOptionPane.showMessageDialog( null, "Course field only allows 4 digits or 4 digits + L for lab classes.");
						courseNumField.setText("");
					}
					if (!instructor.matches("[a-zA-Z -]+|^$")) {
						JOptionPane.showMessageDialog( null, "Instructor field only allows letters, spaces, and '-'.");
						instructorField.setText("");
					}
					if (!keyword.matches("[a-zA-Z]+|^$")) {
						JOptionPane.showMessageDialog( null, "Keyword field only allows letters.");
						keywordField.setText("");
					}
				}
			}
			
			else if (event.getActionCommand() == "Clear") {
				courseNumField.setText("");
				instructorField.setText("");
				keywordField.setText("");
				results.clear();
				repaint();
				remove(jsp);
			}
		}
	}

	public class DrawPanel extends JPanel{

	    @Override
	    protected void paintComponent(Graphics g) {
	    	int height = g.getFontMetrics().getHeight();
	        super.paintComponent(g);
	        for (int i = 0; i < results.size(); i++)
			{
	        	Color aColor = new Color (0x3556AF);	//color for 1st row
				g.setColor(aColor);
				g.fillRect(startX-5, startY+(i*spacing)-height+3, 650, height);	//rectangle used for first row
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier New",Font.PLAIN, 12));
				g.drawString("ECE "+classNum[results.get(i)] + " " + classNames[results.get(i)], startX, startY+(i*spacing));	//display class title and name
				Color bColor = new Color (0xB3BEDC);	//color for 2nd row
				g.setColor(bColor);
				g.fillRect(startX-5, startY+(i*spacing+15)-height+3, 650, height); //location, height, and width are changed for each row and also depends on how many total results need to be displayed
				g.setColor(Color.BLACK);
				g.drawString("Instructor               "+ "Room      " + "Days & Times             " + "Meeting Dates", startX, startY+(i*spacing)+15);	//display labels for the row below
				g.setColor(Color.WHITE);
				g.fillRect(startX-5, startY+(i*spacing+30)-height+3, 650, height);
				g.setColor(Color.BLACK);
				g.drawString(professors[results.get(i)] + roomNum[results.get(i)] + classTime[results.get(i)] + meetingDays[results.get(i)], startX, startY+(i*spacing)+30);	//display class information
			}
	    }
	}
}