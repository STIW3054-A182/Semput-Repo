import java.net.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Check_URL implements Runnable
{
    String link;

    public Check_URL(String link)
    {
        this.link=link;
    }

    public void run()
    {
        try
        {
            if(valid(link))
            {
                if (valid2(link))
                {
                    System.out.println("\n"+Thread.currentThread().getName()+"\n Valid Link: "+link+"\n Show Data");
                }
                else
                {
                    System.out.println("\n"+Thread.currentThread().getName()+"\n Valid Link: "+link+"\n No Data");
                }
            }
            else
            {
                System.out.println("\n"+Thread.currentThread().getName() +"\n Invalid Link: "+link);
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean valid(String url) throws MalformedURLException, IOException
    {
        try
        {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection checkURL= (HttpURLConnection) new URL(url).openConnection();
            checkURL.setRequestMethod("HEAD");
            checkURL.connect();
            return (checkURL.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean valid2(String url)
    {
        Document doc = null;

        try
        {
            doc = Jsoup.connect(url).get();

            if (doc.select("table.CRs1 tr").isEmpty())
            {
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}