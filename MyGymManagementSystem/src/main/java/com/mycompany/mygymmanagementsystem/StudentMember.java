/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

public class StudentMember extends DefaultMember {
    private String schoolName;

    public StudentMember(String membershipNumber, String memberName, MembershipDate startMembershipDate, String schoolName) {
        super(membershipNumber, memberName, startMembershipDate);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}






