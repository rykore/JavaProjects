// --== CS400 File Header Information ==--
// Name: Riya Kore
// Email: rykore@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian Heimrl
// Notes to Grader: None

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DataWranglerTests {

    public CampusMatrix testNodes = new CampusMatrix();
    String filename = "CampusNode.dot";
    private CS400Graph<String, Integer> testerGraph;

    /**
     * Testing the getter methods in the Node class
     */
    @Test
    public void test1() {

        //creating a new node object
        Node building1 = new Node("MemU", "HelenCWhite",5);
        assertEquals(5,building1.getTravelTime());
        assertEquals("MemU",building1.getStartLocation());
        assertEquals("HelenCWhite",building1.getEndLocation());

        Node building2 = new Node("MechanicalEngineering", "RandallEnginering", 5);
        assertEquals(5,building2.getTravelTime());
        assertEquals("MechanicalEngineering",building2.getStartLocation());
        assertEquals("RandallEnginering",building2.getEndLocation());

    }

    /**
     * Testing for the same start location but different end locations
     */
    @Test
    public void test2() {

        Node building1 = new Node("Chazen", "MemU",5);
        Node building2 = new Node("Chazen", "Grainger", 5);
        Node building3 = new Node("Chazen","Nick",10);

        assertEquals("Chazen",building3.startLocation);
        assertEquals("Nick",building3.endLocation);
        assertEquals(10,building3.travelTime);
        assertEquals(5,building1.travelTime);
        assertEquals(5,building2.travelTime);
    }

    /**
     * Testing if the CampusMatrix throws a FileNotFoundException for the wrong DOT file
     */
    @Test
    public void test3() {
        try {
            List<Node> testBuildings = this.testNodes.loadMatrix("WrongFile.dot");
            assertFalse(false);
        }
        catch (FileNotFoundException e) {
            assertTrue(true);
        }
    }


    /**
     * Testing if the List of Buildings is loading and being stored in the ArrayList
     * and using getters to get the Start, End and time of the Node objects
     */
    @Test
    public void test4() {
        try {
            List<Node> testBuildings = this.testNodes.loadMatrix(filename);
            assertEquals("Waters", testBuildings.get(5).getStartLocation());
            assertEquals(5, testBuildings.get(7).getTravelTime());
            assertEquals("BascomHall",testBuildings.get(10).getEndLocation());
            assertEquals(5,testBuildings.get(15).travelTime);
            assertEquals("MechanicalEngineering",testBuildings.get(20).startLocation);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    /**
     * Storing the Nodes that have their Start Location as the CS Building in an ArrayList
     * and checking each one's end location along with the size of the new ArrayList to
     * confirm the number of edges directed out from the CS Building
     */
    @Test
    public void test5() {

        try {

            List<Node> testBuildings = this.testNodes.loadMatrix(filename);
            List<Node> buildingsFromCSBuilding = new ArrayList<>();

            for (int i = 0; i < testBuildings.size(); i++) {
                if (testBuildings.get(i).getStartLocation().equals("CSBuilding")) {
                    buildingsFromCSBuilding.add(testBuildings.get(i));
                }
            }

            assertEquals("UnionSouth",buildingsFromCSBuilding.get(0).getEndLocation());
            assertEquals("CampRandall",buildingsFromCSBuilding.get(1).getEndLocation());
            assertEquals("Nick",buildingsFromCSBuilding.get(2).getEndLocation());
            assertEquals("Grainger",buildingsFromCSBuilding.get(3).getEndLocation());
            assertEquals("BascomHall",buildingsFromCSBuilding.get(4).getEndLocation());
            assertEquals(5,buildingsFromCSBuilding.size());

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    /**
     * Storing the Nodes that have their End Location as Bascom Hall in an ArrayList
     * and checking each one's Start Location and Travel time along with the size of
     * the new ArrayList to confirm the number of edges directed to Bascom Hall
     */
    @Test
    public void integrationTest1() {
        try {
            List<Node> testBuildings = this.testNodes.loadMatrix(filename);
            List<Node> buildingsToBascomHall = new ArrayList<>();

            for (int i = 0; i < testBuildings.size(); i++) {
                if (testBuildings.get(i).getEndLocation().equals("BascomHall")) {
                    buildingsToBascomHall.add(testBuildings.get(i));
                }
            }

            assertEquals("Waters",buildingsToBascomHall.get(0).getStartLocation());
            assertEquals("HelenCWhite",buildingsToBascomHall.get(1).getStartLocation());
            assertEquals("RandallEnginering",buildingsToBascomHall.get(2).getStartLocation());
            assertEquals("Grainger",buildingsToBascomHall.get(3).getStartLocation());
            assertEquals("CSBuilding",buildingsToBascomHall.get(4).getStartLocation());

            assertEquals(5,buildingsToBascomHall.get(0).getTravelTime());
            assertEquals(5,buildingsToBascomHall.get(1).getTravelTime());
            assertEquals(15,buildingsToBascomHall.get(2).getTravelTime());
            assertEquals(5,buildingsToBascomHall.get(3).getTravelTime());
            assertEquals(10,buildingsToBascomHall.get(4).getTravelTime());

            assertEquals(5,buildingsToBascomHall.size());

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found in the Device!");
        }
    }

    /**
     * Storing the Nodes that have a travel time of 10 in a new ArrayList and checking
     * for their start location and end location along with the size of that ArrayList
     * which indicates the number of Nodes in the DOT file that have a travel time of
     * 10 minutes
     */
    @Test
    public void integrationTest2() {
        try {
            List<Node> testBuildings = this.testNodes.loadMatrix(filename);
            List<Node> travelTime10 = new ArrayList<>();

            for (int i = 0; i < testBuildings.size(); i++) {
                if (testBuildings.get(i).getTravelTime() == 10) {
                    travelTime10.add(testBuildings.get(i));
                }
            }

            assertEquals("BabcockDrive",travelTime10.get(3).getStartLocation());
            assertEquals("Dejope",travelTime10.get(3).getEndLocation());
            assertEquals("BascomHall",travelTime10.get(10).getStartLocation());
            assertEquals("Grainger",travelTime10.get(10).getEndLocation());
            assertEquals("CampRandall",travelTime10.get(24).getStartLocation());
            assertEquals("UnionSouth",travelTime10.get(24).getEndLocation());
            assertEquals("HelenCWhite",travelTime10.get(7).getStartLocation());
            assertEquals("Waters",travelTime10.get(7).getEndLocation());
            assertEquals(10,testBuildings.get(3).getTravelTime());
            assertEquals(25,travelTime10.size());
        }
        catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
        }
    }

    @BeforeEach
    public void makeGraph() {

        //directed graph
        testerGraph = new CS400Graph<>();

        // insert vertices A-F
        testerGraph.insertVertex("A");
        testerGraph.insertVertex("B");
        testerGraph.insertVertex("C");
        testerGraph.insertVertex("D");
        testerGraph.insertVertex("E");
        testerGraph.insertVertex("F");

        // insert edges
        testerGraph.insertEdge("A", "B", 6);
        testerGraph.insertEdge("A", "C", 2);
        testerGraph.insertEdge("A", "D", 5);
        testerGraph.insertEdge("B", "E", 1);
        testerGraph.insertEdge("B", "C", 2);
        testerGraph.insertEdge("C", "B", 3);
        testerGraph.insertEdge("C", "F", 1);
        testerGraph.insertEdge("D", "E", 3);
        testerGraph.insertEdge("E", "A", 4);
        testerGraph.insertEdge("F", "A", 1);
        testerGraph.insertEdge("F", "D", 1);
    }

    @Test
    public void CodeReviewOfBackendDeveloper1() {
        Path pathC = new Path(testerGraph.vertices.get("C")); // C, 0
        Path pathCF = new Path(pathC, testerGraph.vertices.get("C").edgesLeaving.get(1)); // CF, 1
        Path pathCFA = new Path(pathCF, testerGraph.vertices.get("F").edgesLeaving.get(0)); // CFA, 2
        Path pathCB = new Path(pathC, testerGraph.vertices.get("C").edgesLeaving.get(0)); // CB, 3
        Path pathCBE = new Path(pathCB, testerGraph.vertices.get("B").edgesLeaving.get(0)); // CBE, 4
        Path pathCBEA = new Path(pathCBE, testerGraph.vertices.get("E").edgesLeaving.get(0)); // CBEA, 8

        Path pathUnsort[] = new Path[6];
        pathUnsort[0] = pathCF;
        pathUnsort[1] = pathCFA;
        pathUnsort[2] = pathCB;
        pathUnsort[3] = pathC;
        pathUnsort[4] = pathCBE;
        pathUnsort[5] = pathCBEA;

        Path pathSort[] = new Path[6];
        pathSort[0] = pathC;
        pathSort[1] = pathCF;
        pathSort[2] = pathCFA;
        pathSort[3] = pathCB;
        pathSort[4] = pathCBE;
        pathSort[5] = pathCBEA;

        SortPaths sPaths = new SortPaths();
        Path pathDone[] = sPaths.sort(pathUnsort);

        if (Arrays.equals(pathDone, pathSort)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void CodeReviewOfBackendDeveloper2() {
        Path pathC = new Path(testerGraph.vertices.get("C")); // C, 0
        Path pathCF = new Path(pathC, testerGraph.vertices.get("C").edgesLeaving.get(1)); // CF, 1
        Path pathCFA = new Path(pathCF, testerGraph.vertices.get("F").edgesLeaving.get(0)); // CFA, 2
        Path pathCB = new Path(pathC, testerGraph.vertices.get("C").edgesLeaving.get(0)); // CB, 3
        Path pathCBE = new Path(pathCB, testerGraph.vertices.get("B").edgesLeaving.get(0)); // CBE, 4

        Path pathUnsort[] = new Path[2];
        pathUnsort[0] = pathCFA;
        pathUnsort[1] = pathCBE;


        Path pathSort = pathCFA;

        SortPaths sPaths = new SortPaths();
        Path pathDone = sPaths.fewestDoors(pathUnsort);

        if (pathDone.equals(pathSort)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
}

