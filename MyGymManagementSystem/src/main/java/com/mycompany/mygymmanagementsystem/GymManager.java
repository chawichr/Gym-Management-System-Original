/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

public interface GymManager {
    void addMember(DefaultMember member);
    void deleteMember(String membershipNumber); 
    void printMembers();
    void sortMembers();
    void saveMembers();
    void loadMembers();
    void openGUI(); 
}






