import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Check_URL_Main
{
    public static void main()
    {
        String read;
        int i=1;
        long start = System.currentTimeMillis();
        int core = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(core);

        System.out.println("\n\nNo of your processor core : " +core);

        try (InputStream input = new FileInputStream("src/main/resources/path.properties"))
        {
            Properties prop = new Properties();

            if (input == null)
            {
                System.out.println("Sorry, unable to find path.properties");
                return;
            }

            prop.load(input);
            BufferedReader check = new BufferedReader(new FileReader(prop.getProperty("path")));

            while ((read = check.readLine()) != null)
            {
                Thread myThread = new Thread(new Check_URL(read), "Thread" + i);
                service.execute(myThread);
                i++;
            }

            check.close();
            service.shutdown();

            /*while (!service.isTerminated()) {
            }*/

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        long end = System.currentTimeMillis();
        long executeTime = end - start;
        System.out.println("Execution time in milliseconds: " + executeTime);
    }
}
