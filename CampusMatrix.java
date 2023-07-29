// --== CS400 File Header Information ==--
// Name: Riya Kore
// Email: rykore@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian Heimrl
// Notes to Grader: None

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.List;

public class CampusMatrix implements ICampusMatrix {

    /**
     * This method will load an Adjacency List of the Nodes that will
     * be loaded from the DOT file
     *
     * @param filename path of the DOT file
     * @return An Adjacency List of the Nodes in the DOT file
     * @throws FileNotFoundException if the file we are searching for could not be found
     */
    public List<Node> loadMatrix(String filename) throws FileNotFoundException {

        File buildingGraph = new File(filename);
        List<Node> buildingData = new ArrayList<>();

        String startLocation;
        String endLocation;
        int time;

        Scanner scnr;

        try {

            scnr = new Scanner(buildingGraph);
            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                if (line.equals("}")) {
                    break;
                } else if (line.startsWith("digraph")) {
                    continue;
                }

                String[] parseNodes = line.split(" ");

                startLocation = parseNodes[4];
                endLocation = parseNodes[6];
                time = Integer.parseInt(parseNodes[9]);

                Node buildingInfo = new Node(startLocation, endLocation, time);

                buildingData.add(buildingInfo);
            }


        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        return buildingData;
    }
}

