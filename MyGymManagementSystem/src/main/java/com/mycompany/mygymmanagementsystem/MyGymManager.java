/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

import java.io.*;
import java.util.*;
import java.awt.EventQueue;

public class MyGymManager implements GymManager {
    private List<DefaultMember> members = new ArrayList<>();

    @Override
    public void addMember(DefaultMember member) {
        members.add(member);
        System.out.println("Member added. Total members: " + members.size());
    }

    @Override
    public void deleteMember(String membershipNumber) {
        DefaultMember memberToRemove = null;
        for (DefaultMember member : members) {
            if (member.getMembershipNumber().equals(membershipNumber)) {
                memberToRemove = member;
                break;
            }
        }

        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Member deleted. Remaining spaces: " + (100 - members.size()));
            System.out.println("Deleted member type: " + memberToRemove.getClass().getSimpleName());
        } else {
            System.out.println("Member not found.");
        }
    }

    @Override
    public void printMembers() {
        for (DefaultMember member : members) {
            System.out.println("ID: " + member.getMembershipNumber() + ", Name: " + member.getMemberName() +
                    ", Start Date: " + member.getStartMembershipDate().getDay() + "/" +
                    member.getStartMembershipDate().getMonth() + "/" + member.getStartMembershipDate().getYear() +
                    ", Type: " + member.getClass().getSimpleName());
        }
    }

    @Override
    public void sortMembers() {
        Collections.sort(members, Comparator.comparing(DefaultMember::getMemberName));
        System.out.println("Members sorted by name.");
    }

    @Override
    public void saveMembers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.dat"))) {
            oos.writeObject(members);
            System.out.println("Members saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    @Override
    public void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.dat"))) {
            members = (ArrayList<DefaultMember>) ois.readObject();
            System.out.println("Members loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved members file found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading members: " + e.getMessage());
        }
    }

    public List<DefaultMember> getMembers() {
        return members;
    }

    @Override
    public void openGUI() {
        EventQueue.invokeLater(() -> {
            GymManagementGUI gui = new GymManagementGUI(this);
        });
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nGym Management System Menu:");
            System.out.println("1. Add a new member");
            System.out.println("2. Delete a member");
            System.out.println("3. Print the list of members");
            System.out.println("4. Sort members by name");
            System.out.println("5. Save members to file");
            System.out.println("6. Open GUI");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewMember(scanner);
                    break;
                case 2:
                    System.out.print("Enter membership number to delete: ");
                    String membershipNumberToDelete = scanner.next(); // Use next() instead of nextInt()
                    deleteMember(membershipNumberToDelete);
                    break;
                case 3:
                    printMembers();
                    break;
                case 4:
                    sortMembers();
                    break;
                case 5:
                    saveMembers();
                    break;
                case 6:
                    openGUI();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);
    }

    private void addNewMember(Scanner scanner) {
        if (members.size() >= 100) {
            System.out.println("No available spaces.");
            return;
        }

        System.out.println("Select type of member to add:");
        System.out.println("1. Default Member");
        System.out.println("2. Student Member");
        System.out.println("3. Over 60 Member");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter membership number: ");
        String membershipNumber = scanner.next(); // Use String type
        scanner.nextLine(); // consume newline
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter start date (dd mm yyyy): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        MembershipDate startDate = new MembershipDate(day, month, year);

        DefaultMember member = null;
        switch (type) {
            case 1:
                member = new DefaultMember(membershipNumber, memberName, startDate);
                break;
            case 2:
                System.out.print("Enter school name: ");
                scanner.nextLine(); // consume newline
                String schoolName = scanner.nextLine();
                member = new StudentMember(membershipNumber, memberName, startDate, schoolName);
                break;
            case 3:
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                member = new Over60Member(membershipNumber, memberName, startDate, age);
                break;
            default:
                System.out.println("Invalid member type.");
                return;
        }

        addMember(member);
    }
}

















          








