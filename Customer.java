public class Customer
{
    private String CustName;
    private String CustIC;
    private String CustNumber;
    private String CustEmail;
    private String CustStreet;
    private String CustCity;
    private int CustZipCode;
    private String CustState;
    private int VehicleCode;
    private int count;
    
    public Customer()
    {
         CustName = null;
         CustIC = null;
         CustNumber = null;
         CustEmail = null;
         CustStreet = null;
         CustCity = null;
         CustZipCode = 0;
         CustState = null;
         VehicleCode = 0;
    }
    
    public Customer(String cn, String IC, String cnb, String ce, String cs,String c,int zc,String s, int vc)
    {
        this.CustName = cn;
        this.CustIC = IC;
        this.CustNumber = cnb;
        this.CustEmail = ce;
        this.CustStreet = cs;
        this.CustCity = c;
        this.CustZipCode = zc;
        this.CustState = s;
        this.VehicleCode = vc;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    public String getCustName()
    {
        return CustName;
    }
    public String getCustIC()
    {
        return CustIC;
    }
    public String getCustNumber()
    {
        return CustNumber;
    }
    public String getCustEmail()
    {
        return CustEmail;
    }
    public String getCustStreet()
    {
        return CustStreet;
    }
    public String getCustCity()
    {
        return CustCity;
    }
    public int getCustZip()
    {
        return CustZipCode;
    }
    public String getCustState()
    {
        return CustState;
    }
    public int getVehicleCode()
    {
        return VehicleCode;
    }
    public int getCount()
    {
        return count;
    }
    
    
    public String toString() 
    {
        return ("Name : " + CustName + "\nIdentification Number : " + CustIC + "\nTelephone Number : " + CustNumber+ "\nEmail : " + CustEmail + "\nAddress Line 1 : " + CustStreet + "\nCity : " + CustCity +  "\nZip Code : " + CustZipCode + "\nState : " + CustState + "\nVehicle Code : " + VehicleCode);
    }
}
