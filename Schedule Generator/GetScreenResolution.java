public class GetScreenResolution {
	static int getScreenWidth()
	{
		return java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	}
	
	static int getScreenHeight()
	{
		return java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	}
}
