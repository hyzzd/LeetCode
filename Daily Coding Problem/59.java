class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/*
 * File A change File B change Action
 * 
 * Created (checksum P) Created (checksum P) Nothing Created (checksum P)
 * Created (checksum Q) Merge Deleted No change Delete Deleted Deleted Nothing
 * No change No change Nothing Modified No change Use file A Modified Modified
 * Merge
 * 
 * Time X Time Y Change Does not exist Exists Created Exists Does not exist
 * Deleted Checksum P Checksum P Nothing Checksum P Checksum Q Modified
 */

// https://pdos.csail.mit.edu/papers/lbfs:sosp01/lbfs.pdf