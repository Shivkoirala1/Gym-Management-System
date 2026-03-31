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