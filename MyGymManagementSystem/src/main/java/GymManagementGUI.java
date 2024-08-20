/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List; 
import java.util.*;

public class GymManagementGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> filterComboBox;
    private JTextField searchField;
    private MyGymManager gymManager;

    public GymManagementGUI(MyGymManager gymManager) {
        this.gymManager = gymManager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gym Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Start Date", "Type"}, 0);
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        filterComboBox = new JComboBox<>(new String[]{"All", "Default Member", "Student Member", "Over 60 Member"});
        controlPanel.add(filterComboBox);

        searchField = new JTextField(20);
        controlPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        controlPanel.add(searchButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        loadMembersToTable();

        frame.setVisible(true); 
    }

    private void loadMembersToTable() {
        tableModel.setRowCount(0);
        List<DefaultMember> members = gymManager.getMembers();
        for (DefaultMember member : members) {
            MembershipDate startDate = member.getStartMembershipDate();
            Calendar calendar = startDate.toCalendar();
            tableModel.addRow(new Object[]{member.getMembershipNumber(), member.getMemberName(),
                    String.format("%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)),
                    member.getClass().getSimpleName()});
        }
    }
}






