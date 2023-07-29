public class DataGen {

    public static Path[] paths = new Path[15];

    public static Path[] genPaths() {

        final String CS = "CSBuilding";

        paths[0] = Dijkstra.genMap.dijkstrasShortestPath(CS, "CSBuilding");
        paths[1] = Dijkstra.genMap.dijkstrasShortestPath(CS, "Dejope");
        paths[2] = Dijkstra.genMap.dijkstrasShortestPath(CS, "BabcockDrive");
        paths[3] = Dijkstra.genMap.dijkstrasShortestPath(CS, "Waters");
        paths[4] = Dijkstra.genMap.dijkstrasShortestPath(CS, "HelenCWhite");
        paths[5] = Dijkstra.genMap.dijkstrasShortestPath(CS, "MemU");
        paths[6] = Dijkstra.genMap.dijkstrasShortestPath(CS, "BascomHall");
        paths[7] = Dijkstra.genMap.dijkstrasShortestPath(CS, "MechanicalEngineering");
        paths[8] = Dijkstra.genMap.dijkstrasShortestPath(CS, "RandallEnginering");
        paths[9] = Dijkstra.genMap.dijkstrasShortestPath(CS, "Grainger");
        paths[10] = Dijkstra.genMap.dijkstrasShortestPath(CS, "Chazen");
        paths[11] = Dijkstra.genMap.dijkstrasShortestPath(CS, "EngineeringDrive");
        paths[12] = Dijkstra.genMap.dijkstrasShortestPath(CS, "UnionSouth");
        paths[13] = Dijkstra.genMap.dijkstrasShortestPath(CS, "Nick");
        paths[14] = Dijkstra.genMap.dijkstrasShortestPath(CS, "CampRandall");

        return paths;
    }

}
