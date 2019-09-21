package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import Framework.Loggers;

public class UtilityHelper {
	
	private static ThreadLocal<UtilityHelper> HelpersThread = new ThreadLocal<UtilityHelper>();
	static Properties prop = new Properties();
	static String propfilepath = "config/config.properties";
	public static void set(UtilityHelper helper)
	{
		HelpersThread.set(helper);
	 
	}
	public static UtilityHelper get()
	{
	 return HelpersThread.get();
	}
	
	public String ConfigReader(String str) throws IOException {
		InputStream ip = new FileInputStream(
				"config/config.properties");
		prop.load(ip);
		String str1 = prop.getProperty(str);
		return str1;
	}

	public void ConfigWriter(String propName, String propValue) {

        File file = new File(propfilepath);

        try {
            if (file.createNewFile()) {
                Loggers.get().INFO("File: " + propfilepath + " is created");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Properties props = null;
        try {
            FileInputStream in = new FileInputStream(propfilepath);
            props = new Properties();
            props.load(in);
            in.close();
        } catch (Exception e) {

        }
        try {
            FileOutputStream out = new FileOutputStream(propfilepath);
            props.setProperty(propName, propValue);
            props.store(out, null);
            out.close();
        } catch (Exception e) {
        }
    }

	
	

}
