// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NONE

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides tests to check the correct implementation of the Dijkstra, Parser and Node classes.
 * @author Smit Vasani
 */
public class AlgorithmEngineerTests {
    private Dijkstra<Node,Integer> madisonMap = new Dijkstra<>();

    /**
     * Checks if the expected array with the locations in correct order is returned when tested on a short
     * & direct path.
     */
    @Test
    public void test1() {
        String [] expected = new String[]{"CSBuilding", "UnionSouth"};

        assertTrue(Arrays.equals(expected, madisonMap.makePath("UnionSouth")));
    }

    /**
     * Checks if the expected array with the locations in correct order is returned when tested on an indirect path.
     */
    @Test
    public void test2() {
        String [] expected = new String[] {"CSBuilding", "BascomHall", "HelenCWhite"};
        assertTrue(Arrays.equals(expected, madisonMap.makePath("HelenCWhite")));
    }

    /**
     * Checks if the Node class' functions return the expected value.
     */
    @Test
    public void test3() {
        Node n1 = new Node("Lucky", "Lark", 5);
        Node n2 = new Node("Pres", "Lucky", 2);
        Node n3 = new Node("Brooks", "Lark", 6);

        assertEquals("Lark", n1.getEndLocation());
        assertEquals("Pres", n2.getStartLocation());
        assertEquals(6, n3.getTravelTime());

    }

    /**
     * Checks if the correct distance is returned when the endpoint is far and involves a longer indirect path.
     */
    @Test
    public void test4() {
        String [] expectedPath = new String[]
                {"CSBuilding", "CampRandall", "EngineeringDrive", "MechanicalEngineering", "BabcockDrive","Dejope"};
        assertTrue(Arrays.equals(expectedPath, madisonMap.makePath("Dejope")));
        int expected = 35;
        assertEquals(expected, madisonMap.getTravelTime("Dejope"));
    }

    /**
     * Checks if the correct distance is returned when the endpoint is near and involves an indirect path.
     */
    @Test
    public void test5() {
        int expected = 15;
        assertEquals(expected, madisonMap.getTravelTime("Chazen"));
    }

    /**
     * Tests the correct interaction of codes from different roles to get the shortest path form CS Building to
     * Waters residence hall.
     */
    @Test
    public void integrationTest1() {
        String [] expectedPath = new String[] {"CSBuilding", "BascomHall", "Waters"};
        assertTrue(Arrays.equals(expectedPath, madisonMap.makePath("Waters")));
    }
    /**
     * Tests the correct interaction of codes from different roles to get the minimum time required to get from
     * CS Building to Engineering Drive.
     */
    @Test
    public void integrationTest2() {
        int expectedTime = 10;
        assertEquals(expectedTime, madisonMap.getTravelTime("EngineeringDrive"));
    }

    /**
     * Checks the correct implementation of CampusMatrix class written by the Data Wrangler
     * @throws FileNotFoundException
     */
    @Test
    public void AETestsDW1() throws FileNotFoundException {
        CampusMatrix cmTemp = new CampusMatrix();
        List<Node> checkList = cmTemp.loadMatrix("CampusNode.dot");
        assertFalse(checkList.isEmpty());
    }

    /**
     * Checks the correct implementation of the Node class written by Data Wrangler
     */
    @Test
    public void AETestsDW2() {
        Node checkNode = new Node("ScienceHall", "MemU", 2);
        assertEquals("ScienceHall", checkNode.getStartLocation());
        assertEquals("MemU", checkNode.getEndLocation());
        assertEquals(2, checkNode.getTravelTime());
    }
}

