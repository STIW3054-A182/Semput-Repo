import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class Connect implements Callable<String>
{
    private String url;
    private long start, end, execute;

    Connect(String url)
    {
        this.url = url;
    }

    private boolean checkURL(String url)
    {
        try
        {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setRequestMethod("HEAD");
            return (connection.getResponseCode() == HttpURLConnection.HTTP_OK);
        }

        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public String call() throws Exception
    {
        start = System.currentTimeMillis();

        if (checkURL(url))
        {
            end = System.currentTimeMillis();
            execute = end - start;

            if (execute > 60000)
            {
                System.out.println("Execution more than 1 minute, process terminated.");
                Log log = new Log();
                log.Log2(url);
                System.exit(0);
            }

            else
            {
                System.out.println(Thread.currentThread().getName() + "\nLink : " + url + "\n");
            }
        }
        else
        {
            try
            {
                Log log = new Log();
                log.Log("Link : " + url);
                url = "0";
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return url;
    }
}

