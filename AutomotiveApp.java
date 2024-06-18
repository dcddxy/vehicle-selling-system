import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AutomotiveApp
{
    //main program
    public static void main(String args[]) throws IOException,IOException,IOException
    {
        try
        {
            LinkList StaffList = new LinkList();

            // Open the file in append mode
            FileWriter file1 = new FileWriter("StaffList.txt", true);
            BufferedWriter bw1 = new BufferedWriter(file1);
            PrintWriter out1 = new PrintWriter(bw1);

            Staff S = new Staff();
            JFrame frame = new JFrame();
            String staffPass = null;
            boolean staffFound = false;
            Scanner staffScanner = null;
            String Q1 = JOptionPane.showInputDialog("Are You a Staff?(Yes/No)");
            if(Q1.equalsIgnoreCase("Yes") || Q1.equalsIgnoreCase("yes"))
            {
                JOptionPane.showMessageDialog(frame,"Log in As Staff");
                boolean retryAuthentication = true;
                while (retryAuthentication) {
                    String enteredID = JOptionPane.showInputDialog("Enter Staff ID: ");
                    String enteredPass = getPasswordInput("Enter Password");
                
                    // Traverse the staff list to find the corresponding staff
                    staffScanner = new Scanner(new File("StaffList.txt"));
                    staffScanner.useDelimiter("\n");
                
                    while (staffScanner.hasNext()) {
                        String staffInfo = staffScanner.next();
                        StringTokenizer st = new StringTokenizer(staffInfo, ";");
                        String staffName = st.nextToken();
                        String staffID = st.nextToken();
                        staffPass = st.nextToken();
                        if (!enteredID.equalsIgnoreCase(staffID) && !enteredPass.equals(staffPass))
                        {
                            // Staff ID doesn't exist
                            int option = JOptionPane.showOptionDialog(
                                    null,
                                    "Staff ID and Password don't exist. Do you want to try again?",
                                    "Invalid Staff ID",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    null,
                                    null
                            );
                            if (option != JOptionPane.YES_OPTION) 
                            {
                                // Exit the program or take appropriate action
                                System.exit(0);
                            }
                            break;
                        }
                        else if (enteredID.equalsIgnoreCase(staffID)) {
                            staffFound = true;
                
                            // Check if the password is correct
                            if (enteredPass.equals(staffPass)) {
                                JOptionPane.showMessageDialog(frame, "Password Correct!(^o^)");
                                retryAuthentication = false; // Exit the loop
                                break; // exit the loop once staff is found
                            } 
                            else if (!enteredPass.equals(staffPass))
                            {
                                // Password is incorrect
                                int option = JOptionPane.showOptionDialog(
                                        null,
                                        "Password is incorrect. Do you want to try again?",
                                        "Invalid Password",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        null,
                                        null
                                );
                                if (option != JOptionPane.YES_OPTION) {
                                    // Exit the program or take appropriate action
                                    System.exit(0);
                                }
                                // Otherwise, loop again to retry entering ID and password
                                break; // exit the inner loop to retry entering password
                            }
                        }
                        else
                        {
                            // Staff ID is incorrect
                            int option = JOptionPane.showOptionDialog(
                                        null,
                                        "Staff ID is incorrect. Do you want to try again?",
                                        "Invalid Password",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        null,
                                        null
                            );
                            if (option != JOptionPane.YES_OPTION) {
                                // Exit the program or take appropriate action
                                System.exit(0);
                            }
                            break;
                        }
                    }
                
                    // Close the scanner after finishing the inner loop
                    staffScanner.close();
                }
            
                if(staffFound)
                {    
                    String Q2 = JOptionPane.showInputDialog("Adding new Staff?(Yes/No)");
                        
                    if(Q2.equalsIgnoreCase("Yes") || Q2.equalsIgnoreCase("yes"))
                    {
                        do {
                            String n = JOptionPane.showInputDialog("Enter Name : ");
                            String ID = JOptionPane.showInputDialog("Enter Staff ID : ");
                            String ps = JOptionPane.showInputDialog("Enter Password : ");
                            String nb = JOptionPane.showInputDialog("Enter Phone Number : ");
                            int number = Integer.parseInt(nb);
                            String e = JOptionPane.showInputDialog("Enter Email : ");
                            String a = JOptionPane.showInputDialog("Enter Address Line 1 : ");
                            String z = JOptionPane.showInputDialog("Enter Zip Code : ");
                            int zip = Integer.parseInt(z);
                            String c = JOptionPane.showInputDialog("Enter City : ");
                            String s = JOptionPane.showInputDialog("Enter State : ");
                            String p = JOptionPane.showInputDialog("Enter Position : ");
                            String t = JOptionPane.showInputDialog("Enter Job Type(Full-Time/Part-Time/Intern : ");
                            
                            
                            S = new Staff(n, ID, ps, number, e, a, zip, c, s, p, t);
                            StaffList.insertAtBack(S);
    
                            // Write staff details to "StaffList.txt"
                            out1.println("\n"+S.getName() + ";" + S.getID() + ";" + S.getPass() + ";" + S.getNumber() + ";" + S.getEmail() + ";" + S.getAddress() + ";" + S.getZip() + ";" + S.getCity() + ";" 
                            + S.getState() + ";" + S.getPosition() + ";" + S.getType() + "\n");
                            
                            // Prompt to ask if the user wants to add more new staff members
                            int addMoreStaff = JOptionPane.showConfirmDialog(null, "Do you want to add more staff members?", "Add More", JOptionPane.YES_NO_OPTION);
                            if (addMoreStaff == JOptionPane.YES_OPTION) {
                                n = JOptionPane.showInputDialog("Enter Name : ");
                                ID = JOptionPane.showInputDialog("Enter Staff ID : ");
                                ps = JOptionPane.showInputDialog("Enter Password : ");
                                nb = JOptionPane.showInputDialog("Enter Phone Number : ");
                                number = Integer.parseInt(nb);
                                e = JOptionPane.showInputDialog("Enter Email : ");
                                a = JOptionPane.showInputDialog("Enter Address Line 1 : ");
                                z = JOptionPane.showInputDialog("Enter Zip Code : ");
                                zip = Integer.parseInt(z);
                                c = JOptionPane.showInputDialog("Enter City : ");
                                s = JOptionPane.showInputDialog("Enter State : ");
                                p = JOptionPane.showInputDialog("Enter Position : ");
                                t = JOptionPane.showInputDialog("Enter Job Type(Full-Time/Part-Time/Intern : ");
                                
                                
                                S = new Staff(n, ID, ps, number, e, a, zip, c, s, p, t);
                                StaffList.insertAtBack(S);
        
                                // Write staff details to "StaffList.txt"
                                out1.println(S.getName() + ";" + S.getID() + ";" + S.getPass() + ";" + S.getNumber() + ";" + S.getEmail() + ";" + S.getAddress() + ";" + S.getZip() + ";" + S.getCity() + ";" 
                                + S.getState() + ";" + S.getPosition() + ";" + S.getType() + "\n");
                                // Prompt to ask if the user wants to add more new staff members
                                addMoreStaff = JOptionPane.showConfirmDialog(null, "Do you want to add more staff members?", "Add More", JOptionPane.YES_NO_OPTION);
                                
                            }
                            else
                            {
                                    break; // Exit the loop if the user doesn't want to add more
                            }
                        } while (true);
                    }
                    else if(Q2.equalsIgnoreCase("No") || Q2.equalsIgnoreCase("no"))
                    {
                                Scanner scan = new Scanner(System.in);
                                LinkList automotiveList = new LinkList();
                                String inputFile = "automotiveList.txt";
                                
                                scan.useDelimiter("\n");
                                FileReader fr = new FileReader(inputFile);
                                BufferedReader br = new BufferedReader (fr);
                                StringTokenizer st;
                                String line = br.readLine();
                                while(line != null)
                                {
                                    Automotive A = new Automotive();
                                    st = new StringTokenizer(line,";");
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

                                    //store in object
                                    A.setAutomotive (code,vt,vb,mn,yl,c,ft,ds,t,vc,p);
                                    
                                    
                                    //insert at front
                                    automotiveList.insertAtFront(A); 
                                    
                                    line = br.readLine();
                                } 
                                // Display the list
                                System.out.println("List of Vehicles:");
                                System.out.println("==================================================================================================================================================================================================================================================");
                                System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
                                System.out.println("==================================================================================================================================================================================================================================================");
                                if (!automotiveList.isEmpty())
                                {
                                    automotiveList.sortCode();//sort list by vehicle code
                                    automotiveList.traverse();//traverse and print automotive list
                                }
                                System.out.println("==================================================================================================================================================================================================================================================");
                                
                                SwingUtilities.invokeLater(() -> 
                                {
                                    try
                                    {
                                        createAndShowAddEntryGUI(automotiveList);
                                    }
                                    catch (IOException ioe)
                                    {
                                        ioe.printStackTrace();
                                    }
                                });
                                // Count nodes and display the result
                                int numberOfNodes = automotiveList.countNodes();
                                System.out.println("Number of vehicles: " + numberOfNodes);
                                
                                if(!automotiveList.isEmpty())
                                {
                                    System.out.println("List is not empty");
                                }
                                else
                                {
                                    System.out.println("List is not empty");
                                }
                                // Sort the list
                                System.out.println("\nList sorted by year:");
                                System.out.println("==================================================================================================================================================================================================================================================");
                                System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
                                System.out.println("==================================================================================================================================================================================================================================================");
                                automotiveList.sortList();
                                automotiveList.traverse();
                                System.out.println("==================================================================================================================================================================================================================================================");
                                // Ask for the vehicle code to update condition
                                int vehicleCode = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Vehicle Code to Update Condition:"));
                                // Search for the vehicle in the linked list
                                Automotive vehicleToUpdate = automotiveList.findVehicleByCode(vehicleCode);
                        
                                if (vehicleToUpdate != null) 
                                {
                                    // Display a colored JOptionPane for updating the condition
                                    String[] options = {"Prime", "Maintenance", "Defect"};
                                    int choice = JOptionPane.showOptionDialog(
                                            null,
                                            "Choose the new condition for Vehicle Code " + vehicleCode + ":",
                                            "Update Condition",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[0]
                                    );
                                    // Map the user's choice to the corresponding condition
                                    char newCondition = ' '; // default value
                                    if (choice == 0) 
                                    {
                                        newCondition = 'P';
                                    } else if (choice == 1) 
                                    {
                                        newCondition = 'M';
                                    } else if (choice == 2) 
                                    {
                                        newCondition = 'D';
                                    }
                                    // Update the condition for the selected vehicle in the linked list
                                    automotiveList.updateVehicleCondition(vehicleCode, newCondition);
                                    // Update the automotiveList.txt file
                                    saveAutomotiveListToFile(automotiveList, "automotiveList.txt");
                                    // Update the condition for the selected vehicle in the linked list
                                    vehicleToUpdate.setCondition(newCondition);
                                    System.out.println("List After Updated Condition : " + vehicleCode);
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    automotiveList.traverse();
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                } 
                                else 
                                {
                                    JOptionPane.showMessageDialog(null, "Vehicle with code " + vehicleCode + " not found.");
                                }
                                            
                                //Remove vehicle by code
                                int code = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle Code You want to remove : "));
                                if (vehicleToUpdate != null)
                                {
                                    System.out.println("Remove Vehicle : " + code);
                                    // Display initial list
                                    System.out.println("Initial List Before Remove Vehicle : " + code);
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));                
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    automotiveList.traverse();
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    automotiveList.deleteVehicle(code);
                                    saveAutomotiveListToFile(automotiveList, "automotiveList.txt");
                                    //Display List After Removing Vehicle
                                    System.out.println("\nList after removing Vehicle: " + code);
                                    Object removedData = automotiveList.getFirst();
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                    while (removedData != null)
                                    {
                                        Automotive A = (Automotive) removedData;
                                        A.printReport();
                                        removedData = automotiveList.getNext();
                                    }
                                    System.out.println("==================================================================================================================================================================================================================================================");
                                
                                } 
                                else 
                                {
                                    JOptionPane.showMessageDialog(null, "Vehicle with code " + vehicleCode + " not found.");
                                }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Incorrect Password(-_-) Please Try Again<3");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Are You a Customer? Please go to QUEUE Program!(^_^)");
            }
            out1.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("File Not Found :"+e.getMessage());
            e.printStackTrace();
        }
        catch (NoSuchElementException ei)
        {
            System.out.println("Problem No such element:" +ei.getMessage());
        }
        catch (IOException ioe)
        {
            System.out.println("Problem IO : "+ioe.getMessage());
        }
    }       
    
        private static String getPasswordInput(String prompt) {
        JPasswordField passwordField = new JPasswordField();
        int action = JOptionPane.showOptionDialog(null, passwordField, prompt,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (action == JOptionPane.OK_OPTION) {
            char[] password = passwordField.getPassword();
            return new String(password);
        } else {
            return ""; // User canceled the input
        }
    }
    
    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private static JTextField createInputField(String labelText, String promptText) 
    {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
        JLabel label = new JLabel(labelText + ": ");
        JTextField textField = new JTextField(15);
        
        // Set the prompt text
        textField.setToolTipText(promptText);
    
        inputPanel.add(label);
        inputPanel.add(textField);
    
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
        // Return the JTextField directly
        return textField;
    }
    //Enter new vehicle
    private static void createAndShowAddEntryGUI(LinkList automotiveList) throws IOException 
    {
        JFrame frame = new JFrame("Automotive Entry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a panel with a BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add components to the panel
        panel.add(createLabel("Enter details for the new automotive entry:"));
        JTextField codeTextField = createInputField("Vehicle Code", "Enter Vehicle Code");
        panel.add(codeTextField);
        JTextField vehicleTypeTextField = createInputField("Vehicle Type", "Enter Vehicle Type");
        panel.add(vehicleTypeTextField);
        JTextField brandTextField = createInputField("Brand", "Enter Brand");
        panel.add(brandTextField);
        JTextField modelNameTextField = createInputField("Model Name", "Enter Model Name");
        panel.add(modelNameTextField);
        JTextField yearLaunchedTextField = createInputField("Year Launched", "Enter Year Launched");
        panel.add(yearLaunchedTextField);
        JTextField capacityTextField = createInputField("Capacity (CC)", "Enter Capacity");
        panel.add(capacityTextField);
        JTextField fuelTypeTextField = createInputField("Fuel Type", "Enter Fuel Type");
        panel.add(fuelTypeTextField);
        JTextField designStyleTextField = createInputField("Design Style", "Enter Design Style");
        panel.add(designStyleTextField);
        JTextField tintedTextField = createInputField("Tinted (Yes/No)", "Enter Tinted");
        panel.add(tintedTextField);
        JTextField conditionTextField = createInputField("Condition (P/M/D)", "Enter Condition");
        panel.add(conditionTextField);
        JTextField priceTextField = createInputField("Price", "Enter Price");
        panel.add(priceTextField);
    
        JButton addButton = new JButton("Add Entry");
        addButton.addActionListener(e -> {
            // Retrieve values from input fields and create an Automotive entry
            int code = Integer.parseInt(getTextFieldValue(codeTextField));
            String vt = getTextFieldValue(vehicleTypeTextField);
            String vb = getTextFieldValue(brandTextField);
            String mn = getTextFieldValue(modelNameTextField);
            int yl = Integer.parseInt(getTextFieldValue(yearLaunchedTextField));
            double c = Double.parseDouble(getTextFieldValue(capacityTextField));
            String ft = getTextFieldValue(fuelTypeTextField);
            String ds = getTextFieldValue(designStyleTextField);
            char t = getTextFieldValue(tintedTextField).charAt(0);
            char vc = getTextFieldValue(conditionTextField).charAt(0);
            double p = Double.parseDouble(getTextFieldValue(priceTextField));
    
            // Create an Automotive object and set its attributes
            Automotive newAutomotive = new Automotive();
            newAutomotive.setAutomotive(code, vt, vb, mn, yl, c, ft, ds, t, vc, p);
    
            // Insert the entry into the linked list 
            automotiveList.insertAtFront(newAutomotive);
            // Save the new entry to the file
            saveEntryToFile(newAutomotive, "AutomotiveList.txt");
            
            System.out.println("\nNew Entry Details:");
            System.out.println("==================================================================================================================================================================================================================================================");
            System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
            System.out.println("==================================================================================================================================================================================================================================================");
            newAutomotive.printReport();
            System.out.println("==================================================================================================================================================================================================================================================");
            // Display a success message
            JOptionPane.showMessageDialog(null, "New entry added successfully!");
            
            // Display the list after adding a new entry
            System.out.println("Updated List of Vehicles:");
            Object data = automotiveList.getFirst();
            System.out.println("==================================================================================================================================================================================================================================================");
            System.out.println(String.format("|%-10s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-25s|%-15s|%-15s|%-15s|","CODE","VEHICLE TYPE","BRAND","MODEL NAME","YEAR LAUNCHED","CAPACITY(CC)","FUEL TYPE","DESIGN COLOUR","TINTED","CONDITION","PRICE(RM)"));
            System.out.println("==================================================================================================================================================================================================================================================");
            while (data != null) {
                Automotive A = (Automotive) data;
                A.printReport();
                data = automotiveList.getNext();
            }
            System.out.println("==================================================================================================================================================================================================================================================");
        
            int numberOfNodes = automotiveList.countNodes();
            System.out.println("Number of vehicles: " + numberOfNodes);
        });

        panel.add(addButton);
    
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //To save new entry vehicles to automotiveList file
    private static void saveEntryToFile(Automotive automotive, String fileName) 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(String.format("%d;%s;%s;%s;%d;%.2f;%s;%s;%c;%c;%.2f",
                    automotive.getCode(), automotive.getVehicle(), automotive.getBrand(),
                    automotive.getName(), automotive.getYearLaunched(), automotive.getCC(),
                    automotive.getFuel(), automotive.getDesign(), automotive.getTinted(),
                    automotive.getCondition(), automotive.getPrice()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //To save new vehicle list to automotiveList file
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
    
    private static String getTextFieldValue(JTextField textField) 
    {
        return textField.getText();
    }   
}        

               
    

                
    
               
