import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

public class Check_URL_Main
{
    public static void main()
    {
        int core = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(core);

        System.out.println("\n\nNo of your processor core : " + core + "\n");

        try (InputStream input = new FileInputStream("src/main/resources/system.properties"))
        {
            Properties prop = new Properties();

            if (input == null)
            {
                System.out.println("Sorry, unable to find system.properties");
                return;
            }

            prop.load(input);

            List<String> myURLArrayList = Files.readAllLines(Paths.get(prop.getProperty("fullPath")));
            List<String> ValidURLlist = new ArrayList<>();

            System.out.println("\n-------- Valid link --------\n");

            for (String url : myURLArrayList)
            {
                Future<String> ValidURL = service.submit(new Connect(url));

                if (!ValidURL.get().equals("0"))
                {
                    ValidURLlist.add(ValidURL.get());
                }
            }

            service.shutdown();

            try
            {
                if (!service.awaitTermination(60, TimeUnit.SECONDS))
                {
                    service.shutdownNow();

                    if (!service.awaitTermination(60, TimeUnit.SECONDS))
                    {
                        System.err.println("Process not terminated!");
                    }
                }
            }

            catch (InterruptedException e)
            {
                service.shutdownNow();
                Thread.currentThread().interrupt();
            }

            Table t = new Table(ValidURLlist);
            t.table();
            List<Data>list = t.getPlayerList();

            System.out.println("\n\n------- No of Player -------");
            Player_No pc1 = new Player_No(list);
            pc1.player();

            System.out.println("\n\n-------- Statistics --------\n");
            Statistics stat = new Statistics(list);
            stat.displayStatistics();

            System.out.println("\n\n----- Player from Kedah -----\n");
            Kedah_Player kp = new Kedah_Player(list);
            kp.Player();

            System.out.println("\n\n-------- Top 3 player -------\n");
            Top_3 t3 = new Top_3(list);
            t3.top3();

            System.out.println("\n\n------- Winning point -------\n");
            Winning_Point wp = new Winning_Point(list);
            wp.count();

            System.out.println("\n\n------- Player result -------\n");
            Result r = new Result(list);
            r.Result();

        }

        catch (IOException | InterruptedException | ExecutionException ex)
        {
            ex.printStackTrace();
        }
    }
}
