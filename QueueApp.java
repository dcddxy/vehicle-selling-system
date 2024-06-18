import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;


public class QueueApp
{
    private static final Logger logger = Logger.getLogger(QueueApp.class.getName());
    public static void main(String args[])
    {
        try
        {
            Scanner scan = new Scanner(System.in);
            LinkList automotiveList = new LinkList();
            ArrayList<Integer> vehicleCodes = new ArrayList();
            Queue Q =new Queue();
            Queue tempQueue = new Queue ();
            String inputFile = "automotiveList.txt";
                
            
            try (FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr))
                {
            
                    StringTokenizer st;
                    String line = br.readLine();
                
                    while (line != null) {
                        Automotive A = new Automotive();
                        st = new StringTokenizer(line, ";");
                
                        try {
                            int code = Integer.parseInt(st.nextToken());
                            String vt = st.nextToken();
                            String vb = st.nextToken();
                            String mn = st.nextToken();
                            int yl = Integer.parseInt(st.nextToken());
                            double c = Double.parseDouble(st.nextToken());
                            String ft = st.nextToken();
                            String ds = st.nextToken();
                            String ts = st.nextToken();
                            char t = ts.charAt(0);
                            String co = st.nextToken();
                            char vc = co.charAt(0);
                            double p = Double.parseDouble(st.nextToken());
                
                            // Store in object
                            A.setAutomotive(code, vt, vb, mn, yl, c, ft, ds, t, vc, p);
                            automotiveList.insertAtBack(A);
                            // Insert at front
                            Q.enqueue(A);
                        } catch (NumberFormatException | NoSuchElementException e) {
                            // Handle the exception (e.g., print an error message)
                            System.err.println("Error parsing line: " + line);
                        }
                        line = br.readLine();
                    }
                    br.close();
                    fr.close();
            }
            // Display the list
            System.out.println("List of Vehicles:");
            Queue display = new Queue();
            //Object data = Q.getFront();
            System.out.println("======================================================================================================================================="
            + "===========================================================================================================");
            System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|"
            ,"CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
            System.out.println("======================================================================================================================================="
            + "===========================================================================================================");
            if (!Q.isEmpty())
            {
                automotiveList.sortCode();//sort list by vehicle code
                automotiveList.traverse();//traverse and print automotive list
            }
            System.out.println("======================================================================================================================================="
            + "===========================================================================================================");
            if(Q.isEmpty())
            {
                System.out.println("The Q Queue Is Empty");
            }
            else
            {
                System.out.println("The Q Queue Is Not Empty");
            }
            System.out.println("The Size of Automotive List : " + Q.size() + "\n");
            String custInput = "CustomerList.txt";
            
            FileReader fr2 = new FileReader(custInput);
            BufferedReader br2 = new BufferedReader (fr2);
            StringTokenizer st2;
            String line2 = br2.readLine();
            
            int totalCarsBought = 0; // Declare and initialize totalCarsBought
            Customer C = null; // Declare the Customer object outside the loop
            Queue Q2 = new Queue();
            String Answer = JOptionPane.showInputDialog("Do You Want To Buy a Vehicle?(Yes/No)");
            while (Answer != null && Answer.equalsIgnoreCase("Yes"))
            {
               if (line2 != null)
               { // Check if line2 is not null before tokenizing
                    st2 = new StringTokenizer(line2, ";");
                    String cn = st2.hasMoreTokens() ? st2.nextToken() : "";
                    String ic = st2.hasMoreTokens() ? st2.nextToken() : "";
                    String tn = st2.hasMoreTokens() ? st2.nextToken() : "";
                    String ce = st2.hasMoreTokens() ? st2.nextToken() : "";
                    String cs = st2.hasMoreTokens() ? st2.nextToken() : "";
                    String c = st2.hasMoreTokens() ? st2.nextToken() : "";
                    int z = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : 0;
                    String s = st2.hasMoreTokens() ? st2.nextToken() : "";
                    boolean validInput = false;
                    int searchCode = 0;
                    int vc = 0;
                    while (true) {
                        try {
                             while (!validInput) {
                            // Prompt user for input
                            searchCode = Integer.parseInt(JOptionPane.showInputDialog("Enter A Vehicle Code : "));
                            // Check if the vehicle code exists in the list
                            boolean found = false;
                            try (FileReader fr = new FileReader(inputFile);
                                 BufferedReader br = new BufferedReader(fr))
                            {
                                StringTokenizer st;
                                String line = br.readLine();
                                while (line != null) {
                                    Automotive A = new Automotive();
                                    st = new StringTokenizer(line, ";");
                
                                    try {
                                        int code = Integer.parseInt(st.nextToken());
                
                                        if (code == searchCode) {
                                            // Vehicle code found
                                            found = true;
                                            System.out.println("Vehicle code " + searchCode + " found in the list." + "\n");
                                            validInput = true; // Set flag to exit the loop
                                            break;
                                        }
                
                                    } catch (NumberFormatException | NoSuchElementException e) {
                                        System.err.println("Error parsing line: " + line);
                                    }
                                    line = br.readLine();
                                }
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            // Display the result
                            if (!found)
                            {
                                System.out.println("Vehicle code " + searchCode + " not found in the list. Please try again." + "\n");
                            }
                        }
                        vc = searchCode;
                        // Validate that the vehicle code is within an acceptable range
                        if (vc >= 1)
                        {
                            break;  // Exit the loop if the input is valid
                        }
                        else
                        {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Vehicle Code (❁´◡`❁).", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        } catch (NumberFormatException e) {
                            // Show an error message for non-numeric input
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric Vehicle Code (❁´◡`❁).", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    line2 = br2.readLine();  // Read the next line for the next iteration
                    if (vc == 1)
                    {
                        line2 = ";" + vc + "\n";
                    }
                    else
                    {
                        line2 = cn + ";" + ic + ";" + tn + ";" + ce + ";" + cs + ";" + c + ";" + z + ";" + s + ";" + vc;
                    }

                    // Write the modified line back to the file
                    try (FileWriter fw2 = new FileWriter("CustomerList.txt", true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter out2 = new PrintWriter(bw2))
                    {
                        out2.println(line2);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                        // Handle the exception
                    }
            
                    C = new Customer(cn, ic, tn, ce, cs, c, z, s, vc);
                    Q2.enqueue(C);
                    System.out.println("Enqueued customer: " + C + "\n");
                    
                    // Increment totalCarsBought for each purchased car
                    if( vc != 0)
                    {
                       totalCarsBought++; 
                    }
                    
                    Queue S = new Queue();
                    int K = C.getVehicleCode();
                    Object data = Q.getFront();
                    if (data != null)
                    {
                        Automotive firstVehicle = (Automotive) data;
                        if (firstVehicle.getCode() == K)
                        {
                            // Dequeue the first vehicle
                            Automotive soldVehicle = (Automotive) Q.dequeue();
                            S.enqueue(soldVehicle);
                            System.out.println("Vehicle with code " + K + " has been sold." + "\n");
                            // Remove the sold vehicle from the automotiveList
                            automotiveList.deleteVehicle(K);
                            // Save the updated automotiveList to "automotiveList.txt"
                            saveAutomotiveListToFile(automotiveList, "automotiveList.txt");
                        }
                        else
                        {
                            // Temporary queue to store vehicles while searching for the target vehicle
                            boolean found = false;
                    
                            // Dequeue and enqueue vehicles until the target vehicle is found
                            while (data != null)
                            {
                                Automotive currentVehicle = (Automotive) data;
                                if (currentVehicle.getCode() == K)
                                {
                                    found = true;
                                    System.out.println("Vehicle with code " + K + " has been sold." + "\n");
                                    // Remove the sold vehicle from the automotiveList
                                    automotiveList.deleteVehicle(K);
                                    // Save the updated automotiveList to "automotiveList.txt"
                                    saveAutomotiveListToFile(automotiveList, "automotiveList.txt");
                                }
                                else
                                {
                                    tempQueue.enqueue(currentVehicle);
                                }
                                data = Q.dequeue();
                            }
                    
                            // Re-enqueue the remaining vehicles back to the original queue
                            while (!tempQueue.isEmpty())
                            {
                                Q.enqueue(tempQueue.dequeue());
                            }
                    
                            // If the target vehicle is not found
                            if (!found)
                            {
                                System.out.println("Vehicle with code " + K + " not found." + "\n");
                            }
                        }
                        // Save the sold vehicles to "SoldVehicles.txt"
                        saveSoldVehiclesToFile(S, "SoldVehicles.txt");
                        vehicleCodes.add(C.getVehicleCode());
                        line2 = br2.readLine();
                        Answer = JOptionPane.showInputDialog("Do You Want To Buy More Vehicles?(Yes/No)" + "\n");
                    }
                    else
                    {
                        System.out.println("No vehicles in the queue." + "\n");
                    }
               }
               else if (Answer == null)
               {
                   // Exit the program
                   System.exit(0);
               }
               else 
               {
                    System.out.println("No data in CustomerList.txt" + "\n");
                    break; // Exit the loop if there is no more data in the file
               }
            }
            if (Answer == null) {
                System.out.println("Come Again Next Time! :)" + "\n");
                // Exit the program
                System.exit(0);
            }
            
            // Check if the answer is not "Yes"
            if (!Answer.equalsIgnoreCase("Yes")) {
                System.out.println("Come Again Next Time! :)" + "\n");
            }
            // Successful purchase, now generate the receipt using the last purchased customer
            Customer lastPurchasedCustomer = null;

            // Get the last customer from Q2
            Object lastCustomerData = Q2.getEnd();
            if (lastCustomerData instanceof Customer)
            {
                lastPurchasedCustomer = (Customer) lastCustomerData;
            }
           
            if (lastPurchasedCustomer != null)
            {
                System.out.println("Last purchased customer: " + lastPurchasedCustomer);
                ReceiptApp.generateReceipt(lastPurchasedCustomer, vehicleCodes, totalCarsBought);
            }
            else
            {
                System.out.println("No customer data available for generating the receipt." + "\n");
            }
            System.out.println("Thank You For Buying With Us! Come Again :)");
            br2.close();
            fr2.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found :"+e.getMessage());
            e.printStackTrace();
        }
        catch (NoSuchElementException ei)
        {
            System.out.println("Problem No such element:" +ei.getMessage());
            System.out.println("Problem: No such element");
            logger.severe("NoSuchElementException occurred: " + ei.getMessage());
            ei.printStackTrace();
        }
        catch (IOException ioe)
        {
            System.out.println("Problem IO : "+ioe.getMessage());
        }  
    }
    // Function to save the automotiveList to a file
    private static void saveAutomotiveListToFile(LinkList automotiveList, String fileName)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            Object data = automotiveList.getFirst();
            while (data != null) {
                Automotive A = (Automotive) data;
                writer.println(A.getCode() + ";" + A.getVehicle() + ";" + A.getBrand() + ";" +
                                A.getName() + ";" + A.getYearLaunched() + ";" + A.getCC() + ";" +
                                A.getFuel() + ";" + A.getDesign() + ";" + A.getTinted() + ";" +
                                A.getCondition() + ";" + A.getPrice());
    
                // Move to the next element in the list
                data = automotiveList.getNext();
                // Check if the next element is null to avoid a NullPointerException
                if (data == null)
                {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void saveSoldVehiclesToFile(Queue soldVehiclesQueue, String fileName)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true)))
        {
            // Loop through the sold vehicles in the queue
            Object soldVehicleData = soldVehiclesQueue.getFront();
            while (!soldVehiclesQueue.isEmpty())
            {
                Automotive soldVehicle = (Automotive) soldVehiclesQueue.dequeue();
                //Convert price to 2 decimal points
                DecimalFormat df = new DecimalFormat ("0.00");
                String formattedPrice = df.format(soldVehicle.getPrice());
                writer.println(soldVehicle.getCode() + ";" +
                                soldVehicle.getVehicle() + ";" +
                                soldVehicle.getBrand() + ";" +
                                soldVehicle.getName() + ";" +
                                soldVehicle.getYearLaunched() + ";" +
                                soldVehicle.getCC() + ";" +
                                soldVehicle.getFuel() + ";" +
                                soldVehicle.getDesign() + ";" +
                                soldVehicle.getTinted() + ";" +
                                soldVehicle.getCondition() + ";" +
                                formattedPrice);
                // Check if the next element is null to avoid a NullPointerException
                if (soldVehicleData == null) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

