package Framework;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import cucumber.api.Scenario;
public class Loggers {

    protected static PrintWriter outputfile;
    static Scenario sc;
    private static ThreadLocal<Loggers> LoggerThread = new ThreadLocal<Loggers>();
	public static void set(Loggers helper)
	{
		LoggerThread.set(helper);
	 
	}
	public static Loggers get()
	{
	 return LoggerThread.get();
	}
    public    Loggers() throws FileNotFoundException {
		String logFilePath = System.getProperty("user.dir")+ "\\test-output\\TestLogs\\Tests"+"_" + new SimpleDateFormat("MM.dd_HH.mm").format(new Date())+".txt";
		outputfile = new PrintWriter(new File(logFilePath));
		
    }
    //To do
	public void INFO(String log) throws FileNotFoundException {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		int LineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String MethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println(new SimpleDateFormat("MM.dd_HH.mm").format(new Date()) + " [INFO] " +MethodName + ":" + LineNum + "]" + " - " + log);
	    outputfile.println(log);
	    outputfile.flush();
	}

	public void ERROR(String log) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		int LineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String MethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String ClasName = Thread.currentThread().getStackTrace()[2].getClassName();
		System.out.println(new SimpleDateFormat("MM.dd_HH.mm").format(new Date()) + " [ERROR] " +MethodName + ":" + LineNum + "]"
				+ " - " + log);
	}

}