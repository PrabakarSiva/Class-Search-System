import java.io.IOException;
import javax.swing.JFrame;

public class ClassSearchTest 
{
	public static void main(String[] args) throws IOException
	{
		ClassSearch hi = new ClassSearch();
		hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hi.setSize(1000, 800);
		hi.setVisible(true);
	}
}