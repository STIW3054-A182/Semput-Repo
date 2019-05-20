import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Set_Path
{
    static Scanner scan = new Scanner(System.in);

    public static void main()
    {
        System.out.print("Enter path of your URL.txt file : ");
        String path = scan.nextLine();
        System.out.println("\n");

        try (OutputStream output = new FileOutputStream("src/main/resources/system.properties"))
        {
            Properties prop = new Properties();
            prop.setProperty("fullPath", path);

            Pattern findPath = Pattern.compile("\\w.*\\\\");
            Matcher textPath = findPath.matcher(path);
            if (textPath.find())
            {
                prop.setProperty("path", textPath.group());
            }

            Pattern findTextName = Pattern.compile("\\w*.(txt)");
            Matcher textName = findTextName.matcher(path);
            if (textName.find())
            {
                prop.setProperty("fileName", textName.group());
            }

            prop.setProperty("state", "KEDAH");
            prop.setProperty("top", "3");
            prop.setProperty("player", "Rosli Iman Hasif");

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