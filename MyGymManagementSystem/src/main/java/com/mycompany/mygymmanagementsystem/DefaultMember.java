/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

import java.io.Serializable;

public class DefaultMember implements Serializable {
    private String membershipNumber;
    private String memberName;
    private MembershipDate startMembershipDate;

    public DefaultMember(String membershipNumber, String memberName, MembershipDate startMembershipDate) {
        this.membershipNumber = membershipNumber;
        this.memberName = memberName;
        this.startMembershipDate = startMembershipDate;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public MembershipDate getStartMembershipDate() {
        return startMembershipDate;
    }
}








