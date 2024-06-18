import javax.swing.*;
import java.text.DecimalFormat;

public class Automotive
{
    private int vCode;
    private String vehicleType;//car,van,bus...
    private String vehicleBrand;//optima,toyota.perodua..
    private String modelName;//GT86,CB350RS...
    private int yearLaunched;//1998,1999....
    private double cc;//1000,2000,1500...
    private String fuelType;//ron97,diesel,ron95
    private String designStyle;//white,black,blue...
    private char tinted;//Yes/No
    private char condition;//Prime/Maintenance/Defect
    private double price;
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    //default constructor
    public Automotive()
    {
        vCode = 0;
        vehicleType = " ";
        vehicleBrand = " ";
        modelName = " ";
        yearLaunched = 0;
        cc = -1;
        fuelType = " ";
        designStyle = " ";
        tinted = ' ';
        condition = ' ';
        price = 0;
    }
    //copy constructor
    public Automotive (int vCode, String vehicleType, String vehicleBrand, String modelName, int yearLaunched, double cc, String fuelType, String designStyle, char tinted, char condition, double price) 
     {
        this.vCode = vCode;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.modelName = modelName;
        this.yearLaunched = yearLaunched;
        this.cc = cc;
        this.fuelType = fuelType;
        this.designStyle = designStyle;
        this.tinted = tinted;
        this.condition = condition;
        this.price = price;
    }
    //setter
    public void setAutomotive(int vc, String vt,  String vb, String mn, int yl, double c, String ft, String ds, char ts, char co, double p)
     {
        vCode = vc;
        vehicleType = vt;
        vehicleBrand = vb;
        modelName = mn;
        yearLaunched = yl;
        cc = c;
        fuelType = ft;
        designStyle = ds;
        tinted = ts;
        condition = co;
        price = p;
    }
    public void setCondition(char newCondition)
    {
        condition = newCondition;
    }
    public void setCode(int code)
    {
        vCode = code;
    }
    //getter  
    public int getCode()
    {
        return vCode;
    }
    public String getVehicle()    
    {
        return vehicleType;
    }
    public String getBrand()
    {
        return vehicleBrand;
    }
    public String getName()
    {
        return modelName;
    }
    public int getYearLaunched()
    {
        return yearLaunched;
    }
    public double getCC()
    {
        return cc;
    }
    public String getFuel()
    {
        return fuelType;
    }
    public String getDesign()
    {
        return designStyle;
    }
    public char getTinted()
    {
        return tinted;
    }
    public char getCondition()
    {
        return condition;
    }
    public double getPrice()
    {
        return price;    
    }
    public void printReport()
    {
        String vc = " ";
        if(vc == "Prime")
            condition = 'P';
        else if(vc == "Maintenance")
            condition = 'M';
        else if(vc == "Defect")
            condition = 'D';
            
        System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|",vCode, vehicleType, vehicleBrand, modelName, yearLaunched, cc, fuelType, designStyle, tinted, condition, df.format(price)));   
    }
}   









