//-== CS400 Project 2 File Header ==-
// Red Team: Sam Katerov
// Blue Team: Ayden Visser
// Lecture: 003 @ 2:25pm

public interface IntRBTFrontend {
    /**
     * This method starts the command loop for the frontend, and will terminate when the user exits 
     * the app.
     */
    public void runCommandLoop();

    /**
     * Displays the main menu
     */
    public void displayMainMenu();

    /**
     * Search through RBT by last name
     *
     * @param name The name to lookup by
     */
    public void NameLookup(String name);

    /**
     * Search through RBT by CID
     *
     * @param cid The CID to lookup by
     */
    public void CIDLookup(int cid);
}