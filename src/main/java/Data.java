
import java.util.ArrayList;
import java.util.List;

public class Data
{
    private List <String>aRK = new ArrayList<>();
    private List <String>aSno = new ArrayList<>();
    private List <String>aName = new ArrayList<>();
    private List <String>aRtg = new ArrayList<>();
    private List <String>aState = new ArrayList<>();
    private List <String>aPts = new ArrayList<>();
    private List <String>aCat = new ArrayList<>();

    public List<String> getRK()
    {
        return aRK;
    }

    public List<String> getSno()
    {
        return aSno;
    }

    public List<String> getName()
    {
        return aName;
    }

    public List<String> getRtg()
    {
        return aRtg;
    }

    public List<String> getState()
    {
        return aState;
    }

    public List<String> getPts()
    {
        return aPts;
    }

    public List<String> getCat()
    {
        return aCat;
    }

    public void setRK(String RK)
    {
        aRK.add(RK);
    }

    public void setSno(String Sno)
    {
        aSno.add(Sno);
    }

    public void setName(String Name)
    {
        aName.add(Name);
    }

    public void setRtg(String Rtg)
    {
        aRtg.add(Rtg);
    }

    public void setState(String State)
    {
        aState.add(State);
    }

    public void setPts(String Pts)
    {
        aPts.add(Pts);
    }

    public void setCat(String Cat)
    {
        aCat.add(Cat);
    }
}
