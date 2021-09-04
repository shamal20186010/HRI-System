/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shamal Wassana
 */
public class LoginModelTest {

    public LoginModelTest() {
    }

    /**
     * Test of isLogin method, of class LoginModel.
     */
    @Test
    public void testIsLogin() {
        System.out.println("isLogin");
        String username = "shamal";
        String password = "1234";
        LoginModel instance = new LoginModel();
        int expResult = 2;
        int result = instance.isLogin(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthorizer method, of class LoginModel.
     */
    @Test
    public void testGetAuthorizer() {
        System.out.println("getAuthorizer");
        int id = 2;
        LoginModel instance = new LoginModel();
        int expResult = 1;
        int result = instance.getAuthorizer(id);
        assertEquals(expResult, result);
    }

}
