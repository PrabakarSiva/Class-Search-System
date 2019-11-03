import java.io.IOException;
import javax.swing.JFrame;

public class ClassRegistrationTest 
{
	public static void main(String[] args) throws IOException
	{
		ClassRegistration hi = new ClassRegistration();
		hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hi.setSize(1000, 800);
		hi.setVisible(true);
	}
}