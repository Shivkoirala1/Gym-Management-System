import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * GymGui is the main GUI class for the Hamro Gym Biratnagar 03 managing.
 * this class provides a user interface for entering and managing gym member
 * details,
 * including personal information and membership plans.
 * 
 * This class uses Swing components to create a form with two panels:
 * - Panel 1: Member's basic personal details
 * - Panel 2: Membership and plan-related details also contains buttons
 * 
 * It also initializes an ArrayList to store gym members.
 * 
 * Author: [Damaru Ballav Koirala]
 * Date: [2025/04/12s]
 */

// List to store gym members
public class GymGui {
        private ArrayList<GymMember> gymMembers = new ArrayList<>();

        /**
         * Constructs the GUI window for the Hamro Gym Management System.
         * adding different label text field and buttons are done here.
         */

        public GymGui() {
                // Create a new JFrame instance inside the constructor

                JFrame frame = new JFrame("Hamro Gym Biratnagar-03");
                frame.setSize(1020, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);

                // Panel 1: Basic Member Details
                JPanel panel1 = new JPanel();
                panel1.setBounds(15, 20, 450, 550); // x, y, width, height
                panel1.setLayout(null);

                // UI Components for Panel 1
                JLabel Label = new JLabel("ID:");
                Label.setBounds(10, 20, 100, 25);
                JTextField tField1 = new JTextField();
                tField1.setBounds(120, 20, 200, 25);

                JLabel Label2 = new JLabel("Name:");
                Label2.setBounds(10, 60, 100, 25);
                JTextField tField2 = new JTextField();
                tField2.setBounds(120, 60, 200, 25);

                JLabel Label3 = new JLabel("Location:");
                Label3.setBounds(10, 100, 100, 25);
                JTextField tField3 = new JTextField();
                tField3.setBounds(120, 100, 200, 25);

                JLabel Label4 = new JLabel("Phone:");
                Label4.setBounds(10, 140, 100, 25);
                JTextField tField4 = new JTextField();
                tField4.setBounds(120, 140, 200, 25);

                JLabel Label5 = new JLabel("Email:");
                Label5.setBounds(10, 180, 100, 25);
                JTextField tField5 = new JTextField();
                tField5.setBounds(120, 180, 200, 25);

                JLabel genderLabel = new JLabel("Gender:");
                genderLabel.setBounds(10, 220, 100, 25);

                JRadioButton maleRadioButton = new JRadioButton("Male");
                maleRadioButton.setBounds(120, 220, 70, 25);
                JRadioButton femaleRadioButton = new JRadioButton("Female");
                femaleRadioButton.setBounds(200, 220, 100, 25);

                // Group radio buttons together
                ButtonGroup genderGroup = new ButtonGroup();
                genderGroup.add(maleRadioButton);
                genderGroup.add(femaleRadioButton);

                JLabel dobLabel = new JLabel("DOB:");
                dobLabel.setBounds(10, 260, 100, 25);

                JComboBox<String> dobYearComboBox = new JComboBox<>(
                                new String[] { "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017",
                                                "2016",
                                                "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007",
                                                "2006",
                                                "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997",
                                                "1996",
                                                "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987",
                                                "1986",
                                                "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977",
                                                "1976",
                                                "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967",
                                                "1966",
                                                "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957",
                                                "1956",
                                                "1955", "1954", "1953", "1952", "1951", "1950"
                                });
                dobYearComboBox.setBounds(120, 260, 60, 25);

                JComboBox<String> dobMonthComboBox = new JComboBox<>(
                                new String[] { "Month", "January", "February", "March",
                                                "April", "May", "June", "July", "August", "September", "October",
                                                "November", "December" });
                dobMonthComboBox.setBounds(190, 260, 60, 25);

                JComboBox<String> dobDayComboBox = new JComboBox<>(
                                new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                                                "14",
                                                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                                                "27", "28", "29", "30", "31", "32"
                                });
                dobDayComboBox.setBounds(260, 260, 60, 25);

                JLabel startLabel = new JLabel("Start Date:");
                startLabel.setBounds(10, 300, 100, 25);

                JComboBox<String> startYear = new JComboBox<>(
                                new String[] { "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017",
                                                "2016",
                                                "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007",
                                                "2006",
                                                "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997",
                                                "1996",
                                                "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987",
                                                "1986",
                                                "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977",
                                                "1976",
                                                "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967",
                                                "1966",
                                                "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957",
                                                "1956",
                                                "1955", "1954", "1953", "1952", "1951", "1950"
                                });
                startYear.setBounds(120, 300, 60, 25);

                JComboBox<String> startMonth = new JComboBox<>(new String[] { "Month", "January", "February", "March",
                                "April",
                                "May", "June", "July", "August", "September", "October", "November", "December" });
                startMonth.setBounds(190, 300, 60, 25);

                JComboBox<String> startDate = new JComboBox<>(
                                new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                                                "14",
                                                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                                                "27", "28", "29", "30", "31", "32"
                                });
                startDate.setBounds(260, 300, 60, 25);

                // Save to File Button
                JButton saveToFileBtn = new JButton("Save to File");
                saveToFileBtn.setBounds(10, 340, 200, 30);

                saveToFileBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("gym_members.txt"))) {
                                        for (GymMember member : gymMembers) {
                                                writer.write("ID: " + member.getId() + "\n");
                                                writer.write("Name: " + member.getName() + "\n");
                                                writer.write("Location: " + member.getLocation() + "\n");
                                                writer.write("Phone: " + member.getPhone() + "\n");
                                                writer.write("Email: " + member.getEmail() + "\n");
                                                writer.write("Gender: " + member.getGender() + "\n");
                                                writer.write("DOB: " + member.getDOB() + "\n");
                                                writer.write("Start Date: " + member.getMembershipStartDate() + "\n");
                                                writer.write("Attendance: " + member.getAttendance() + "\n");
                                                writer.write("Loyalty Points: " + member.getLoyaltyPoints() + "\n");
                                                writer.write("Active Status: "
                                                                + (member.isActiveStatus() ? "Active" : "Inactive")
                                                                + "\n");

                                                // Check if member is regular or premium
                                                if (member instanceof RegularMember) {
                                                        RegularMember r = (RegularMember) member;
                                                        writer.write("Referral Source: " + r.getReferralSource()
                                                                        + "\n");
                                                        writer.write("Plan: " + r.getPlan() + "\n");
                                                        writer.write("Price: " + r.getPrice() + "\n");
                                                        writer.write("Type: Regular Member\n");
                                                } else if (member instanceof PremiumMember) {
                                                        PremiumMember p = (PremiumMember) member;
                                                        writer.write("Trainer Name: " + p.getPersonalTrainer() + "\n");
                                                        writer.write("Discount: " + p.getDiscountAmount() + "%\n");
                                                        writer.write("Price: " + p.getPremiumCharge() + "\n");
                                                        writer.write("Type: Premium Member\n");
                                                }
                                                writer.write("------------------------\n");
                                        }
                                        JOptionPane.showMessageDialog(frame,
                                                        "Data successfully saved to gym_members.txt!", "Success",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(),
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                        System.err.println("Error saving file: " + ex.getMessage());
                                }
                        }
                });

                // Read from File Button
                JButton readFromFileBtn = new JButton("Read from File");
                readFromFileBtn.setBounds(220, 340, 200, 30);
                readFromFileBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                StringBuilder fileContent = new StringBuilder();

                                try (BufferedReader reader = new BufferedReader(new FileReader("gym_members.txt"))) {
                                        String line;
                                        while ((line = reader.readLine()) != null) {
                                                fileContent.append(line).append("\n");
                                        }

                                        // Display file content

                                        JTextArea textArea = new JTextArea(fileContent.toString());
                                        textArea.setEditable(false);
                                        JScrollPane scrollPane = new JScrollPane(textArea);
                                        scrollPane.setPreferredSize(new Dimension(500, 400));
                                        JOptionPane.showMessageDialog(frame, scrollPane, "Gym Members Data",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(),
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                        System.err.println("Error reading file: " + ex.getMessage());
                                }
                        }
                });

                // Revert Premium Member Button
                JButton revertPremiumMemberBtn = new JButton("Revert Premium Member");
                revertPremiumMemberBtn.setBounds(10, 380, 200, 30);
                revertPremiumMemberBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(frame, "Enter Premium Member ID:",
                                                "Revert Premium Member", JOptionPane.QUESTION_MESSAGE);

                                // Validate user input
                                if (input == null || input.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Please enter a valid Member ID.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                try {
                                        int memberId = Integer.parseInt(input); // Convert ID safely

                                        // Validate removal reason
                                        String removalReason = JOptionPane.showInputDialog(frame,
                                                        "Enter Removal Reason:", "Revert Premium Member",
                                                        JOptionPane.QUESTION_MESSAGE);
                                        if (removalReason == null || removalReason.trim().isEmpty()) {
                                                JOptionPane.showMessageDialog(frame, "Removal reason cannot be empty.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        // Search for the premium member
                                        PremiumMember foundMember = null;
                                        for (GymMember member : gymMembers) {
                                                if (member.getId() == memberId && member instanceof PremiumMember) {
                                                        foundMember = (PremiumMember) member;
                                                        break;
                                                }
                                        }

                                        // Handle member not found
                                        if (foundMember == null) {
                                                throw new IllegalArgumentException("Premium Member ID not found.");
                                        }

                                        // Revert member status
                                        foundMember.revertPremiumMember(removalReason);

                                        // Show success message
                                        JOptionPane.showMessageDialog(frame,
                                                        "Premium Member successfully reverted for Member ID: "
                                                                        + memberId,
                                                        "Reversion Complete", JOptionPane.INFORMATION_MESSAGE);

                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(frame, "Member ID must be a number.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                } catch (IllegalArgumentException ex) {
                                        System.err.println("Error: " + ex.getMessage()); // Logs error for debugging
                                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });

                // Calculate Discount Button
                JButton calculateDiscountBtn = new JButton("Calculate Discount");
                calculateDiscountBtn.setBounds(220, 380, 200, 30);
                calculateDiscountBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(frame, "Enter Premium Member ID:",
                                                "Calculate Discount", JOptionPane.QUESTION_MESSAGE);

                                // Validate user input
                                if (input == null || input.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Please enter a valid Member ID.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                try {
                                        int memberId = Integer.parseInt(input); // Convert ID safely

                                        // Search for the premium member
                                        PremiumMember foundMember = null;
                                        for (GymMember member : gymMembers) {
                                                if (member.getId() == memberId && member instanceof PremiumMember) {
                                                        foundMember = (PremiumMember) member;
                                                        break;
                                                }
                                        }

                                        // Handle member not found
                                        if (foundMember == null) {
                                                throw new IllegalArgumentException("Premium Member ID not found.");
                                        }

                                        // Check if full payment has been made
                                        if (!foundMember.isFullPayment()) {
                                                JOptionPane.showMessageDialog(frame,
                                                                "Full payment required before calculating discount.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        // Calculate discount
                                        String discountAmount = foundMember.calculateDiscount();
                                        JOptionPane.showMessageDialog(frame,
                                                        "Discount successfully applied! You saved: $" + discountAmount,
                                                        "Discount Calculation", JOptionPane.INFORMATION_MESSAGE);

                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(frame, "Member ID must be a number.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                } catch (IllegalArgumentException ex) {
                                        System.err.println("Error: " + ex.getMessage()); // Logs error for debugging
                                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });

                // Upgrade Plan Button
                JButton upgradePlanBtn = new JButton("Upgrade Plan");
                upgradePlanBtn.setBounds(10, 420, 200, 30);
                upgradePlanBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(frame, "Enter Regular Member ID:",
                                                "Upgrade Plan", JOptionPane.QUESTION_MESSAGE);

                                // Validate user input
                                if (input == null || input.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Please enter a valid Member ID.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                try {
                                        int memberId = Integer.parseInt(input); // Convert ID safely

                                        // Search for the regular member
                                        RegularMember foundMember = null;
                                        for (GymMember member : gymMembers) {
                                                if (member.getId() == memberId && member instanceof RegularMember) {
                                                        foundMember = (RegularMember) member;
                                                        break;
                                                }
                                        }

                                        // Handle member not found
                                        if (foundMember == null) {
                                                throw new IllegalArgumentException("Regular Member ID not found.");
                                        }

                                        // Check if member is eligible for upgrade
                                        if (!foundMember.isEligibleForUpgrade()) {
                                                JOptionPane.showMessageDialog(frame,
                                                                "Not eligible for plan upgrade. Attendance limit not reached.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        // Prompt user to select a new plan
                                        String[] planOptions = { "Standard", "Deluxe" };
                                        String selectedPlan = (String) JOptionPane.showInputDialog(frame,
                                                        "Select new plan:", "Upgrade Plan",
                                                        JOptionPane.QUESTION_MESSAGE, null, planOptions,
                                                        planOptions[0]);

                                        // Validate plan selection
                                        if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                                                JOptionPane.showMessageDialog(frame, "Invalid plan selection.", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        // Upgrade the plan
                                        String result = foundMember.upgradePlan(selectedPlan);
                                        JOptionPane.showMessageDialog(frame, result, "Upgrade Result",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(frame, "Member ID must be a number.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                } catch (IllegalArgumentException ex) {
                                        System.err.println("Error: " + ex.getMessage()); // Logs error for debugging
                                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });

                // Pay Due Amount Button
                JButton payDueAmountBtn = new JButton("Pay Due Amount");
                payDueAmountBtn.setBounds(220, 420, 200, 30);
                payDueAmountBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String input = JOptionPane.showInputDialog(frame, "Enter Premium Member ID:",
                                                "Pay Due Amount", JOptionPane.QUESTION_MESSAGE);

                                // Validate user input
                                if (input == null || input.trim().isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Please enter a valid Member ID.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                try {
                                        int memberId = Integer.parseInt(input); // Convert ID safely

                                        // Search for the premium member
                                        PremiumMember foundMember = null;
                                        for (GymMember member : gymMembers) {
                                                if (member.getId() == memberId && member instanceof PremiumMember) {
                                                        foundMember = (PremiumMember) member;
                                                        break;
                                                }
                                        }

                                        // Handle member not found
                                        if (foundMember == null) {
                                                throw new IllegalArgumentException("Premium Member ID not found.");
                                        }

                                        // Ask user for payment amount
                                        String amountInput = JOptionPane.showInputDialog(frame, "Enter amount to pay:",
                                                        "Pay Due Amount", JOptionPane.QUESTION_MESSAGE);
                                        if (amountInput == null || amountInput.trim().isEmpty()) {
                                                JOptionPane.showMessageDialog(frame, "Payment amount cannot be empty.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        double amount = Double.parseDouble(amountInput);
                                        if (amount <= 0) {
                                                JOptionPane.showMessageDialog(frame, "Payment amount must be positive.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }

                                        // Pay due amount
                                        String result = foundMember.payDueAmount(amount);
                                        JOptionPane.showMessageDialog(frame, result, "Payment Result",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Member ID and payment amount must be numbers.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                } catch (IllegalArgumentException ex) {
                                        System.err.println("Error: " + ex.getMessage()); // Logs error for debugging
                                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });

                // Add components to panel 1
                panel1.add(Label);
                panel1.add(tField1);
                panel1.add(Label2);
                panel1.add(tField2);
                panel1.add(Label3);
                panel1.add(tField3);
                panel1.add(Label4);
                panel1.add(tField4);
                panel1.add(Label5);
                panel1.add(tField5);
                panel1.add(genderLabel);
                panel1.add(maleRadioButton);
                panel1.add(femaleRadioButton);
                panel1.add(dobLabel);
                panel1.add(dobYearComboBox);
                panel1.add(dobMonthComboBox);
                panel1.add(dobDayComboBox);
                panel1.add(startLabel);
                panel1.add(startYear);
                panel1.add(startMonth);
                panel1.add(startDate);
                panel1.add(saveToFileBtn);
                panel1.add(readFromFileBtn);
                panel1.add(revertPremiumMemberBtn);
                panel1.add(calculateDiscountBtn);
                panel1.add(upgradePlanBtn);
                panel1.add(payDueAmountBtn);


                
                // Panel 2: Membership & Plan Details
                JPanel panel2 = new JPanel();
                panel2.setBounds(480, 20, 620, 550);
                panel2.setLayout(null);

                // UI Components for Panel 2
                JLabel referralLabel = new JLabel("Referral Source:");
                referralLabel.setBounds(10, 20, 100, 25);
                JTextField referralField = new JTextField();
                referralField.setBounds(120, 20, 200, 25);

                JLabel paidAmountLabel = new JLabel("Paid Amount:");
                paidAmountLabel.setBounds(10, 60, 100, 25);
                JTextField paidAmountField = new JTextField();
                paidAmountField.setBounds(120, 60, 200, 25);

                JLabel removalReasonLabel = new JLabel("Removal Reason:");
                removalReasonLabel.setBounds(10, 100, 100, 25);
                JTextField removalReasonField = new JTextField();
                removalReasonField.setBounds(120, 100, 200, 25);

                JLabel trainerLabel = new JLabel("Trainer Name:");
                trainerLabel.setBounds(10, 140, 100, 25);
                JTextField trainerNameField = new JTextField();
                trainerNameField.setBounds(120, 140, 200, 25);

                JLabel planLabel = new JLabel("Plan:");
                planLabel.setBounds(10, 180, 100, 25);

                JComboBox<String> planComboBox = new JComboBox<>(new String[] { "Basic", "Standard", "Deluxe" });
                planComboBox.setBounds(120, 180, 200, 25);

                // Non-editable fields
                JLabel regularPriceLabel = new JLabel("Regular Price:");
                regularPriceLabel.setBounds(10, 220, 100, 25);
                JTextField regularPriceField = new JTextField("6500");
                regularPriceField.setBounds(120, 220, 200, 25);
                regularPriceField.setEditable(false);

                JLabel premiumPriceLabel = new JLabel("Premium Price:");
                premiumPriceLabel.setBounds(10, 260, 100, 25);
                JTextField premiumPriceField = new JTextField("50000");
                premiumPriceField.setBounds(120, 260, 200, 25);
                premiumPriceField.setEditable(false);

                JLabel discountLabel = new JLabel("Discount:");
                discountLabel.setBounds(10, 300, 100, 25);
                JTextField discountField = new JTextField("10%");
                discountField.setBounds(120, 300, 200, 25);
                discountField.setEditable(false);

                
                /**
                 * Button to add a regular gym member.
                 * takes input like name, phone, email and adds as a regular gym member.
                 * also sees exceptions, shows messages and perform taks.
                 */

                

                JButton regularBtn = new JButton("Add Regular Member");
                regularBtn.setBounds(10, 340, 200, 30);

                regularBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {

                                        String idText = tField1.getText().trim();

                                        if (idText.isEmpty()) {
                                                throw new IllegalArgumentException("ID is mandatory.");
                                        }

                                        int aMemberId;
                                        try {
                                                aMemberId = Integer.parseInt(idText);
                                        } catch (NumberFormatException ex) {
                                                throw new IllegalArgumentException("ID must be a number");
                                        }

                                        for (GymMember member : gymMembers) {
                                                if (member.getId() == aMemberId) {
                                                        throw new IllegalArgumentException(
                                                                        "ID you entered already exists");
                                                }
                                        }

                                        String name = tField2.getText().trim();
                                        if (name.isEmpty()) {
                                                throw new IllegalArgumentException("Name cannot be empty.");
                                        }

                                        // Validate that the name contains only letters and spaces
                                        if (!name.matches("[A-Za-z ]+")) {
                                                throw new IllegalArgumentException(
                                                                "Invalid Name: Please Enter a valid Name");
   
