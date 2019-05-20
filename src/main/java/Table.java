

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Table
{
    List <String> ValidURLList;
    List <Data> list = new ArrayList<>();
    String cat;

    public Table(List <String> ValidURLList)
    {
        this.ValidURLList = ValidURLList;
    }

    public void table() throws IOException
    {
        for (int x = 0; x < ValidURLList.size(); x++)
        {
            int count = 0;
            boolean valid = false;

            Data data = new Data();
            Document doc = Jsoup.connect(ValidURLList.get(x)).get();
            Elements tab = doc.select("table.CRs1 tr");
            valid = tab.hasText();
            Elements tab2 = doc.select("div.defaultDialog h2");

            for (Element row1 : tab2)
            {
                Elements tds1 = row1.getElementsMatchingText("\\d{4}?");
                if (tds1.hasText())
                {
                    cat = tds1.text();
                }
            }

            if (valid)
            {
                tab.remove(0);

                for (Element row : tab)
                {
                    data.setRK(row.select("td:nth-child(1)").text());//
                    data.setSno(row.select("td:nth-child(2)").text());
                    data.setName(row.select(" td:nth-child(4)").text());
                    data.setRtg( row.select("td.CRr").text());
                    data.setState(row.select("td:nth-child(7)").text());
                    data.setPts(row.select("td:nth-child(8)").text().replace(",","."));
                    data.setCat(cat);
                    count++;
                }
            }

            if (valid)
            {
                list.add(data);
            }

            else
            {
                Log logFile = new Log();
                logFile.Log(ValidURLList.get(x));
            }
        }
    }

    public List <Data> getPlayerList()
    {
        return list;
    }
}

