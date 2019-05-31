
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Result
{
    String line;
    private List<Data> list;
    Properties prop = new Properties();

    Result (List<Data> list)
    {
        this.list = list;
    }

    public void Result()
    {
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| Rk   |  SNo  |  Name                                       | Rtg  | Club/City        | Pts  | Category                                           |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------|");

        for (Data plist: list)
        {
            for (int x = plist.getRK().size()-1; x>0; x--)
            {
                if ((plist.getName().get(x).equals(Name())))
                {
                    System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |\n",plist.getRK().get(x), plist.getSno().get(x), plist.getName().get(x), plist.getRtg().get(x), plist.getState().get(x), plist.getPts().get(x), plist.getCat().get(x));
                }
            }
        }

        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------|");    }


    public String Name()
    {
        try (InputStream input = new FileInputStream("src/main/resources/system.properties"))
        {
            prop.load(input);
            line = prop.getProperty("player");
        }

        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return line;
    }
}


