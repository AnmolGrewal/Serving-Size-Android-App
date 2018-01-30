package assignment1.anmol.servingsizecalculator.test;

import org.junit.Test;

import assignment1.anmol.servingsizecalculator.Pot;

import static org.junit.Assert.*;

/**
 * Created by anmol on 2018-01-29.
 * 100% Code Coverage Achieved! for Pot Class with 8 Tests
 */
public class PotTest {

    @Test
    public void testConstructor() throws Exception {
        Pot hey = new Pot("test1", 5);
        assertEquals(5, hey.getWeightInG());
        assertEquals("test1", hey.getName());
    }

    @Test
    public void getWeightInG() throws Exception {
        Pot hey = new Pot("test1", 5);
        assertEquals(5, hey.getWeightInG());
    }

    @Test
    public void setWeightInG() throws Exception {
        Pot hey = new Pot("test1", 10);
        hey.setWeightInG(5);
        assertEquals(5, hey.getWeightInG());
    }

    @Test
    public void getName() throws Exception {
        Pot hey = new Pot("test1", 5);
        assertEquals("test1", hey.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setWeightBelowZero() throws Exception {
        Pot hey = new Pot("test1", 10);
        hey.setWeightInG(-5);
    }

    @Test
    public void setNameNormal() throws Exception {
        Pot hey = new Pot("test1", 5);
        String normal = "normal";
        hey.setName(normal);
        assertEquals(normal, hey.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNameZeroLength() throws Exception {
        Pot hey = new Pot("test1", 5);
        hey.setName("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNameNull() throws Exception {
        Pot hey = new Pot("test1", 5);
        hey.setName(null);
    }
}