/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mygymmanagementsystem;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rankychawich
 */
public class MyGymManagerTest {
    
    public MyGymManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMember method, of class MyGymManager.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        MembershipDate date = new MembershipDate(1, 1, 2020);
        DefaultMember member = new DefaultMember(1, "Alice Smith", date);
        MyGymManager instance = new MyGymManager();
        instance.addMember(member);
        assertEquals(1, instance.getMembers().size());
    }

    /**
     * Test of deleteMember method, of class MyGymManager.
     */
    @Test
    public void testDeleteMember() {
        System.out.println("deleteMember");
        MembershipDate date = new MembershipDate(1, 1, 2020);
        DefaultMember member = new DefaultMember(1, "Alice Smith", date);
        MyGymManager instance = new MyGymManager();
        instance.addMember(member);
        instance.deleteMember(1);
        assertEquals(0, instance.getMembers().size());
    }

    /**
     * Test of printMembers method, of class MyGymManager.
     */
    @Test
    public void testPrintMembers() {
        System.out.println("printMembers");
        MyGymManager instance = new MyGymManager();
        instance.printMembers();
        // Additional validation can be done by capturing the console output
    }

    /**
     * Test of sortMembers method, of class MyGymManager.
     */
    @Test
    public void testSortMembers() {
        System.out.println("sortMembers");
        MembershipDate date = new MembershipDate(1, 1, 2020);
        DefaultMember member1 = new DefaultMember(1, "Charlie", date);
        DefaultMember member2 = new DefaultMember(2, "Alice", date);
        DefaultMember member3 = new DefaultMember(3, "Bob", date);
        
        MyGymManager instance = new MyGymManager();
        instance.addMember(member1);
        instance.addMember(member2);
        instance.addMember(member3);
        instance.sortMembers();
        
        List<DefaultMember> members = instance.getMembers();
        assertEquals("Alice", members.get(0).getMemberName());
        assertEquals("Bob", members.get(1).getMemberName());
        assertEquals("Charlie", members.get(2).getMemberName());
    }

    /**
     * Test of saveMembers method, of class MyGymManager.
     */
    @Test
    public void testSaveMembers() {
        System.out.println("saveMembers");
        MyGymManager instance = new MyGymManager();
        MembershipDate date = new MembershipDate(1, 1, 2020);
        DefaultMember member = new DefaultMember(1, "Alice Smith", date);
        instance.addMember(member);
        instance.saveMembers();
        // Validation can be done by checking the file contents
    }

    /**
     * Test of loadMembers method, of class MyGymManager.
     */
    @Test
    public void testLoadMembers() {
        System.out.println("loadMembers");
        MyGymManager instance = new MyGymManager();
        instance.loadMembers();
        // Validation can be done by checking the loaded members
    }

    /**
     * Test of getMembers method, of class MyGymManager.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        MyGymManager instance = new MyGymManager();
        MembershipDate date = new MembershipDate(1, 1, 2020);
        DefaultMember member = new DefaultMember(1, "Alice Smith", date);
        instance.addMember(member);
        List<DefaultMember> result = instance.getMembers();
        assertEquals(1, result.size());
    }
}









