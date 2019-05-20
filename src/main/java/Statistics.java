
import java.util.List;

public class Statistics
{
    //String[] AllState = {"KUALA LUMPUR", "PUTRAJAYA", "JOHOR", "KEDAH", "PERAK", "PULAU PINANG", "SELANGOR", "SABAH", "SARAWAK", "N.SEMBILAN", "PERLIS", "KELANTAN", "TERENGANU", "PAHANG", "MELAKA"};
    String[] AllState = {"PERAK", "PULAU PINANG", "N.SEMBILAN", "SELANGOR", "SABAH","KUALA LUMPUR", "PUTRAJAYA", "JOHOR", "KEDAH", "SARAWAK",  "PERLIS", "KELANTAN", "TERENGANU", "PAHANG", "MELAKA"};


    private List<Data> list;

    public Statistics(List<Data> list)
    {
        this.list = list;
    }

    public void displayStatistics()
    {
        int GrandTotal = 0;

        for (int z = 0; z < AllState.length; z++)
        {
            int total = 0;

            System.out.printf("| %-15s | %-50s |%-5s|\n", "----------------", "----------------------------------------------------", "------");
            System.out.printf("| %-15s  | %-50s   |%-5s |\n", "State", "Category", "Total");
            System.out.printf("| %-15s | %-50s |%-5s|\n", "----------------", "----------------------------------------------------", "------");

            for (Data plist : list)
            {
                int totalbyCAt = 0;

                for (int x = 0; x < plist.getRK().size(); x++)
                {
                    if ((AllState[z]).equals(plist.getState().get(x)))
                    {
                        totalbyCAt++;
                    }
                }
                total += totalbyCAt;

                System.out.printf("| %-15s  |  %-50s  | %d\t |\n", AllState[z], plist.getCat().get(1), totalbyCAt);
            }

            GrandTotal += total;
            System.out.printf("| %-15s  |  %-50s  | %d\t |\n", " ", "Total", total);
        }

        System.out.println("|--------------------------------------------------------------------------------|");
        System.out.printf("| %-15s  |  %-50s  | %d  |\n", "Grand Total", "", GrandTotal);
        System.out.printf("|--------------------------------------------------------------------------------|");
        System.out.println();
    }
}
