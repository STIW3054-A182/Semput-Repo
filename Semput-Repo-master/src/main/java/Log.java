
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Log extends Thread
{
    private Date date = new Date();

    public void Log(String url) throws IOException
    {
        FileWriter write = new FileWriter("src/main/resources/Invalid.log",true);
        write.write(date + "\n");
        write.write("Link does not exist!\n");
        write.write(url);
        write.write("\n\n");
        write.close();
    }

    public void Log2(String url) throws IOException
    {
        FileWriter write = new FileWriter("src/main/resources/Invalid.log",true);
        write.write(date + "\n");
        write.write("Execution more than 1 minute, process terminated!\n");
        write.write(url);
        write.write("\n\n");
        write.close();
    }
}
