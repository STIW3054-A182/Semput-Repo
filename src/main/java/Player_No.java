
import java.util.List;

public class Player_No
{
    private List <Data> list;

    public Player_No(List <Data> list)
    {
        this.list = list;
    }

    public void player()
    {
        int total = 0;
        System.out.println("");
        System.out.println("|------------------------------------------------------------|");
        System.out.println("|                      Category                      | Total |");
        System.out.println("|------------------------------------------------------------|");

        for(Data plist: list)
        {
            System.out.printf("| %-50s | %5s |\n",plist.getCat().get(1),plist.getName().size());
            total += plist.getName().size();
        }

        System.out.println("|------------------------------------------------------------|");
        System.out.printf("| %-50s | %5s |\n", "TOTAL",total);
        System.out.println("|------------------------------------------------------------|");
    }
}

