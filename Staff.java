public class Staff
{
    private String Sname;
    private String SID;
    private String Spassword;
    private int Snumber;
    private String Semail;
    private String Saddress;
    private String Scity;
    private int Szip;
    private String Sstate;
    private String Sposition;
    private String Stype;//Full-time,Part-time,Intern
    
    public Staff()
    {
        Sname = null;
        SID = null;
        Spassword = null;
        Snumber = 0;
        Semail = null;
        Saddress = null;
        Szip = 0;
        Scity = null;
        Sstate = null;
        Sposition = null;
        Stype = null;
    }
    
    public Staff(String n,String ID,String p,int nb,String e,String a,int z,String c,String s,String ps,String t)
    {
        this.Sname = n;
        this.SID = ID;
        this.Spassword = p;
        this.Snumber = nb;
        this.Semail = e;
        this.Saddress = a;
        this.Szip = z;
        this.Scity = c;
        this.Sstate = s;
        this.Sposition = ps;
        this.Stype = t;
    }
    
    public String getName()
    {
        return Sname;
    }
    
    public String getID()
    {
        return SID;
    }
    
    public String getPass()
    {
        return Spassword;
    }
    
    public int getNumber()
    {
        return Snumber;
    }
    
    public String getEmail()
    {
        return Semail;
    }
    
    public String getAddress()
    {
        return Saddress;
    }
    
    public int getZip()
    {
        return Szip;
    }
    
    public String getCity()
    {
        return Scity;
    }
    
    public String getState()
    {
        return Sstate;
    }
    
    public String getPosition()
    {
        return Sposition;
    }
    
    public String getType()
    {
        return Stype;
    }
    
    public void printReport()
    {
        System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|",Sname,SID,Spassword,Snumber,Semail,Saddress,Scity,Szip,Sstate,Sposition,Stype));
    }
}