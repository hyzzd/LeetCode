class Main {
    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
            return;
        }
        // Move (n-1) disks from fromRod to auxRod
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        // Move last disk from fromRod to toRod
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        // Move (n-1) disks from auxRod to toRod
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String args[]) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}