public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\nRealtime Programming Project");
        System.out.println("----------------------------\n");

        try
        {
            Set_Path.main();
            Check_URL_Main.main();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
