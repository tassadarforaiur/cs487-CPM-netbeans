/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Cpt.Bl'Ands
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({javaapplication1.JUnitEventTest.class, javaapplication1.JUnitSearchTest.class, javaapplication1.JUnitAccountTest.class, javaapplication1.JavaApplication1Test.class, javaapplication1.NewJPanelTest.class})
public class Javaapplication1Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
