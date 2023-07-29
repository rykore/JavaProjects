import java.util.LinkedList;

public class SortPaths implements ISortPaths {

    /**
     * This sorts with bubbles to sort the path by fastest travel time
     *
     * @param unsorted The array we are sorting
     * @return The sorted array of paths
     */
    @Override
    public Path[] sort(Path[] unsorted) {
        Path[] sorted = new Path[unsorted.length];
        System.arraycopy(unsorted, 0, sorted, 0, unsorted.length);
        int n = sorted.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j].getCost() > sorted[j + 1].getCost()) {
                    // swap arr[j+1] and arr[j]
                    Path temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    @Override
    public Path shortestPath(Path[] unsorted) {
        LinkedList<Path> paths = new LinkedList<>();
        paths.add(unsorted[0]);
        for (Path p : unsorted) {
            if (paths.get(0).getCost() > p.getCost()) {
                paths.add(0, p);
            }
        }
        return paths.get(0);
    }

    @Override
    public Path fewestDoors(Path[] unsorted) {
        // In case of same number of doors we take the fastest path
        Path sort[] = sort(unsorted);

        LinkedList<Path> paths = new LinkedList<>();
        paths.add(sort[0]);
        for (Path p : sort) {
            if (paths.get(0).getPath().size() > p.getPath().size()) {
                paths.add(0, p);
            }
        }
        return paths.get(0);
    }

}
