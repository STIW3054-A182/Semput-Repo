import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Set_Path
{
    static Scanner scan = new Scanner(System.in);

    public static void main()
    {
        System.out.print("Enter path of your URL.txt file : ");
        String path = scan.nextLine();
        System.out.println("\n");

        try (OutputStream output = new FileOutputStream("src/main/resources/path.properties"))
        {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("path", path);

            // save properties to project root folder
            prop.store(output, null);

            System.out.println("The properties file is created and consist of the path of your file\n");
            System.out.println("This is the data from the properties file :");
            System.out.println(prop);
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }
}