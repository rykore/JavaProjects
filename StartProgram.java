public class StartProgram {

    static public Path[] paths;
    public static void main(String[] args) {
        CampusMapperFrontend cmapFrontend = new CampusMapperFrontend();
        cmapFrontend.runCommandLoop();
    }
}
