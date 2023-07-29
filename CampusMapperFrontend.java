// --== CS400 File Header Information ==--
// Name: Karam Dilip Gursahani
// Email: kdgursahani@wisc.edu
// Team: EB
// TA: Sujitha Perumal
// Lecturer:  Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class implements the frontend for the campus visitor walktime guide
 *
 * @author karam
 *
 */
public class CampusMapperFrontend implements ICampusMapperFrontend {
    static Scanner scanInput = null;
    private boolean hasRun = false;


    /**
     * This method runs the command loop for the frontend of the application.
     */
    @Override
    public void runCommandLoop() {
        scanInput = new Scanner(System.in);
        int nextPrompt;
        boolean exit = false;
        while(exit != true) {
            displayMainMenu();
            nextPrompt = scanInput.nextInt();

            switch (nextPrompt) {
                case 1:
                    displayShortestPath();
                    break;
                case 2:
                    displayAllPaths();
                    break;
                case 3:
                    displayFewestDoorsPath();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
            }
            hasRun = true;
        }
    }

    @Override
    /**
     * This method displays the main menu of the application
     */
    public void displayMainMenu() {
        if (hasRun == false) {
            System.out.print("Welcome to the Campus Visiter Walktime Guide!\r\n"
                    + "\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\r\n");
        }
        System.out.println("Find path(s) from the CS building: ");
        System.out.println("1) Shortest Path\n2) All Paths \n3) Fewest Doors \n4) Exit");

    }

    @Override
    /**
     * This method displays the shortest path the user could take when prompted
     */
    public void displayShortestPath() {

        scanInput = new Scanner(System.in);
        int nextPrompt;

        System.out.println("Please select one of the following locations as end Locations:");
        System.out.println("1) Dejope \n2) Babcock Drive \n3) Waters hall \n4) Helen C White \n5) Memorial Union " +
                "\n6) Bascom Hall \n7) Mechanical Engineering \n8) Randall at Engineering \n9) Grainger Hall \n" +
                "10) Chazen Museum \n11) Engineering Drive \n12) Union South \n13) Nick \n14) Camp Randall");

        nextPrompt = scanInput.nextInt();

        switch (nextPrompt) {
            case 1:
                displayShortestPathHelper("Dejope");
                break;
            case 2:
                displayShortestPathHelper("BabcockDrive");
                break;
            case 3:
                displayShortestPathHelper("Waters");
                break;
            case 4:
                displayShortestPathHelper("HelenCWhite");
                break;
            case 5:
                displayShortestPathHelper("MemU");
                break;
            case 6:
                displayShortestPathHelper("BascomHall");
                break;
            case 7:
                displayShortestPathHelper("MechanicalEngineering");
                break;
            case 8:
                displayShortestPathHelper("RandallEnginering");
                break;
            case 9:
                displayShortestPathHelper("Grainger");
                break;
            case 10:
                displayShortestPathHelper("Chazen");
                break;
            case 11:
                displayShortestPathHelper("EngineeringDrive");
                break;
            case 12:
                displayShortestPathHelper("UnionSouth");
                break;
            case 13:
                displayShortestPathHelper("Nick");
                break;
            case 14:
                displayShortestPathHelper("CampRandall");
                break;
        }

    }

    /**
     * This method is a helper method for the Display Shortest Path method above to find the shortest path
     * to the end location
     * TODO: need to fix this
     */
    public void displayShortestPathHelper(String endLocation) {
        Dijkstra<String, Integer> tempDjk = new Dijkstra<>();
        double totalTime = tempDjk.getTravelTime(endLocation);
        String path = "";
        String[] pathArr = tempDjk.makePath(endLocation);
        for (int i = 0; i < pathArr.length; ++i) {
            if(i == pathArr.length - 1) {
                path = path + pathArr[i];
            }
            else {
                path = path + pathArr[i] + " - ";
            }
        }
        System.out.println("The shortest path is " + path);
        System.out.println("The time taken to reach " + endLocation + " is "
                + totalTime + " minutes");
    }

    @Override
    /**
     * This method displays all paths the user could take when prompted to do so
     */
    public void displayAllPaths() {

        String result = "";
        SortPaths all = new SortPaths();
        Path[] allPaths = all.sort(DataGen.genPaths());
        for (Path p : allPaths) {
            LinkedList dataSeq = p.getPath();
            for (Object o : dataSeq) {
                if (dataSeq.get(dataSeq.size() - 1) == o) {
                    result += (String) o;
                } else {
                    result += (String) o;
                    result += " - ";
                }
            }
            result += " | " + (int)p.getCost() + " minutes\n";
        }
        System.out.println("These are the paths you could take with the time required to traverse them: " + result);
    }

    @Override
    /**
     * This method displays the path with the fewest doors the user could take when
     * prompted to do so.
     */
    public void displayFewestDoorsPath() {
        String result = "";
        SortPaths dummySort = new SortPaths();
        LinkedList path = dummySort.fewestDoors(DataGen.genPaths()).getPath();
        for (Object o : path) {
            if (path.get(path.size() - 1) == o) {
                result += (String) o;
            } else {
                result += (String) o;
                result += " - ";
            }
        }
        System.out.println("The path with the fewest doors is " + result);

    }
}
