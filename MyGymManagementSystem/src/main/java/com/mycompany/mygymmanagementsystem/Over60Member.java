/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

public class Over60Member extends DefaultMember {
    private int age;

    public Over60Member(String membershipNumber, String memberName, MembershipDate startMembershipDate, int age) {
        super(membershipNumber, memberName, startMembershipDate);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}








