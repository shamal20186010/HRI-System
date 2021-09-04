/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.UserDetailsDTO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shamal Wassana
 */
public class RegistrationModelTest {
    
    public RegistrationModelTest() {
    }
    
    /**
     * Test of getEpf method, of class RegistrationModel.
     */
    @Test
    public void testGetEpf() {
        System.out.println("getEpf");
        RegistrationModel instance = new RegistrationModel();
        String expResult = "";
        String result = instance.getEpf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEpf method, of class RegistrationModel.
     */
    @Test
    public void testSetEpf() {
        System.out.println("setEpf");
        String epf = "";
        RegistrationModel instance = new RegistrationModel();
        instance.setEpf(epf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class RegistrationModel.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        UserDetailsDTO userDTO = null;
        RegistrationModel instance = new RegistrationModel();
        String expResult = "";
        String result = instance.register(userDTO);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEPFNo method, of class RegistrationModel.
     */
    @Test
    public void testGetLastEPFNo() throws Exception {
        System.out.println("getLastEPFNo");
        RegistrationModel instance = new RegistrationModel();
        int expResult = 0;
        int result = instance.getLastEPFNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lodeTableEmp method, of class RegistrationModel.
     */
    @Test
    public void testLodeTableEmp() {
        System.out.println("lodeTableEmp");
        String nic = "";
        DefaultTableModel empTableModel = null;
        RegistrationModel instance = new RegistrationModel();
        TableModel expResult = null;
        TableModel result = instance.lodeTableEmp(nic, empTableModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
