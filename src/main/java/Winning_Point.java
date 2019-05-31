
import java.util.HashMap;
import java.util.List;

public class Winning_Point
{
    List<Data> data;
    HashMap<String, HashMap<String,Double>> MainMap = new HashMap<>();

    public Winning_Point (List<Data> data)
    {
        this.data = data;
    }

    public void count()
    {
        for(Data pldata : data)
        {
            for (int x = 0; x < pldata.getState().size();x++)
            {
                String State = pldata.getState().get(x).trim();
                String Cat = pldata.getCat().get(x).trim();
                Double Pts = Double.parseDouble(pldata.getPts().get(x).trim());
                HashMap<String,Double> SubMap = new HashMap<>();

                if (MainMap.get(State) == null)
                {
                    SubMap.put(Cat, Pts);
                    MainMap.put(State, SubMap);
                }

                else if (MainMap.get(State).get(Cat) == null)
                {
                    SubMap = MainMap.get(State);
                    SubMap.put(Cat, Pts);
                    MainMap.put(State, SubMap);
                }

                else
                {
                    SubMap = MainMap.get(State);
                    Double Count = SubMap.get(Cat) + Pts;
                    SubMap.put(Cat, Count);
                    MainMap.put(State, SubMap);
                }
            }
        }
        display(MainMap);
    }

    public void display(HashMap<String,HashMap<String,Double>> Map)
    {
        double Total = 0;
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("| State         | Category                                           |  Total   |");
        System.out.println("|-------------------------------------------------------------------------------|");

        for (HashMap.Entry<String,HashMap<String,Double>> entry1 : MainMap.entrySet())
        {
            double total = 0;

            for (HashMap.Entry<String,Double> entry2 : entry1.getValue().entrySet())
            {
                System.out.printf("| %-14s| %-50s | %-8s |\n", entry1.getKey(),entry2.getKey(),entry2.getValue());
                total += entry2.getValue();
            }

            System.out.printf("| %-14s| %-50s | %-8s |\n", "","TOTAL",total);
            System.out.println("|-------------------------------------------------------------------------------|");
            Total += total;
        }

        System.out.printf("| %-14s| %-50s | %-8s |\n", "GRAND TOTAL","",Total);
        System.out.println("|-------------------------------------------------------------------------------|");
    }
}
