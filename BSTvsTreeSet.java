import java.util.*;

public class BSTvsTreeSet {
    static class BSTNode {
        int val;
        BSTNode left, right;
        BSTNode(int val) { this.val = val; }
    }
    
    static class BST {
    BSTNode root;

    void insert(int val) {
        BSTNode newNode = new BSTNode(val);
        if (root == null) {
            root = newNode;
            return;
        }

        BSTNode current = root;
        BSTNode parent = null;

        while (current != null) {
            parent = current;
            if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            } else {
                // Giá trị đã tồn tại, không chèn
                return;
            }
        }

        if (val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
}

    // Store n and arr for all methods to use the same data
    static int n;
    static int[] arr;

    public static void Inserting_Rand(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; // Sequential input to avoid random input advantage
            System.out.println("\nSequential array generated.\n");
        }

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== INSERTION PERFORMANCE TABLE (RANDOMIZED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
        }

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // BST timing
            BST bst = new BST();
            long start = System.nanoTime();
            for (int x : list) bst.insert(x);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet timing
            TreeSet<Integer> treeSet = new TreeSet<>();
            start = System.nanoTime();
            for (int x : list) treeSet.add(x);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r"); // Move cursor to start of line
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" "); // Overwrite with spaces
            System.out.print("\r"); // Move cursor to start again

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF INSERTION TABLE ===\n");
    }

    public static void Inserting_Sorted(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; // Sequential input to avoid random input advantage
            System.out.println("\nSequential array generated.\n");
        }

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== INSERTION PERFORMANCE TABLE (SORTED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
        }
        

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);

            // BST timing
            BST bst = new BST();
            long start = System.nanoTime();
            for (int x : list) bst.insert(x);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet timing
            TreeSet<Integer> treeSet = new TreeSet<>();
            start = System.nanoTime();
            for (int x : list) treeSet.add(x);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r"); // Move cursor to start of line
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" "); // Overwrite with spaces
            System.out.print("\r"); // Move cursor to start again

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF INSERTION TABLE ===\n");
    }

    public static void Finding_Sorted(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; // Sequential input to avoid random input advantage
        }

        // Prepare search targets (randomly pick 100 elements from arr, or all if n < 100)
        int numSearches = Math.min(100, n);
        int[] searchTargets = new int[numSearches];
        List<Integer> arrList = new ArrayList<>();
        for (int x : arr) arrList.add(x);
        Collections.shuffle(arrList);
        for (int i = 0; i < numSearches; i++) searchTargets[i] = arrList.get(i);

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== SEARCH/FIND PERFORMANCE TABLE (SORTED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            for (int x : searchTargets) bstFind(bst.root, x);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
            for (int x : searchTargets) treeSet.contains(x);
        }

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);

            // BST build
            BST bst = new BST();
            for (int x : list) bst.insert(x);

            // BST timing (finding)
            long start = System.nanoTime();
            for (int x : searchTargets) bstFind(bst.root, x);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet build
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);

            // TreeSet timing (finding)
            start = System.nanoTime();
            for (int x : searchTargets) treeSet.contains(x);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r");
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" ");
            System.out.print("\r");

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF SEARCH/FIND TABLE ===\n");
    }

    public static void Finding_Rand(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; // Sequential input to avoid random input advantage
            System.out.println("\nSequential array generated.\n");
        }

        // Prepare search targets (randomly pick 100 elements from arr, or all if n < 100)
        int numSearches = Math.min(100, n);
        int[] searchTargets = new int[numSearches];
        List<Integer> arrList = new ArrayList<>();
        for (int x : arr) arrList.add(x);
        Collections.shuffle(arrList);
        for (int i = 0; i < numSearches; i++) searchTargets[i] = arrList.get(i);

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== SEARCH/FIND PERFORMANCE TABLE (RANDOMIZED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            for (int x : searchTargets) bstFind(bst.root, x);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
            for (int x : searchTargets) treeSet.contains(x);
        }

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // BST build
            BST bst = new BST();
            for (int x : list) bst.insert(x);

            // BST timing (finding)
            long start = System.nanoTime();
            for (int x : searchTargets) bstFind(bst.root, x);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet build
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);

            // TreeSet timing (finding)
            start = System.nanoTime();
            for (int x : searchTargets) treeSet.contains(x);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r");
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" ");
            System.out.print("\r");

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF SEARCH/FIND TABLE ===\n");
    }

    // Helper method for BST search
    static boolean bstFind(BSTNode node, int val) {
        while (node != null) {
            if (val == node.val) return true;
            if (val < node.val) node = node.left;
            else node = node.right;
        }
        return false;
    }

    public static void Deleting_Sorted(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; // Sequential input to avoid random input advantage
            System.out.println("\nSequential array generated.\n");
        }

        // Pick a random element to delete (or the first if n==0)
        int deleteTarget = arr[(int)(Math.random() * arr.length)];

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== DELETION PERFORMANCE TABLE (RANDOMIZED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            bst.root = bstDelete(bst.root, deleteTarget);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
            treeSet.remove(deleteTarget);
        }

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);


            // BST build
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            // TreeSet build
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);

            // BST timing (deleting)
            long start = System.nanoTime();
            bst.root = bstDelete(bst.root, deleteTarget);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet timing (deleting)
            start = System.nanoTime();
            treeSet.remove(deleteTarget);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r");
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" ");
            System.out.print("\r");

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF DELETION TABLE ===\n");
    }

    public static void Deleting_Rand(String[] args) {
        if (arr == null) {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i; 
            System.out.println("\nSequential array generated.\n");
        }

        // Pick a random element to delete (or the first if n==0)
        int deleteTarget = arr[(int)(Math.random() * arr.length)];

        double[] bstTimes = new double[30];
        double[] treeSetTimes = new double[30];

        String sep = "+=================+=================+====================+";
        String header = "|   Run Number    |  BST (ms)       | TreeSet (ms)       |";

        System.out.println("\n=== DELETION PERFORMANCE TABLE (RANDOMIZED) ===");
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);

        // Warm-up phase
        for (int warmUp = 0; warmUp < 3; warmUp++) {
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // Warm-up BST
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            bst.root = bstDelete(bst.root, deleteTarget);

            // Warm-up TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);
            treeSet.remove(deleteTarget);
        }

        for (int run = 0; run < 30; run++) {
            String runningMsg = String.format("Running attempt #%d, please wait...", run + 1);
            System.out.print(runningMsg);

            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            Collections.shuffle(list);

            // BST build
            BST bst = new BST();
            for (int x : list) bst.insert(x);
            // TreeSet build
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : list) treeSet.add(x);

            // BST timing (deleting)
            long start = System.nanoTime();
            bst.root = bstDelete(bst.root, deleteTarget);
            long end = System.nanoTime();
            bstTimes[run] = (end - start) / 1_000_000.0;

            // TreeSet timing (deleting)
            start = System.nanoTime();
            treeSet.remove(deleteTarget);
            end = System.nanoTime();
            treeSetTimes[run] = (end - start) / 1_000_000.0;

            // Clear the "Running attempt..." line
            System.out.print("\r");
            for (int i = 0; i < runningMsg.length(); i++) System.out.print(" ");
            System.out.print("\r");

            System.out.printf("| %-15d | %-15.4f | %-18.4f |\n", run + 1, bstTimes[run], treeSetTimes[run]);
        }

        System.out.println(sep);

        double bstSum = 0, treeSetSum = 0;
        for (int i = 0; i < 30; i++) {
            bstSum += bstTimes[i];
            treeSetSum += treeSetTimes[i];
        }
        System.out.printf("| %-15s | %-15.4f | %-18.4f |\n", "Average", bstSum / 30, treeSetSum / 30);
        System.out.println(sep);
        System.out.println("=== END OF DELETION TABLE ===\n");
    }

    static BSTNode bstDelete(BSTNode root, int val) {
    BSTNode parent = null;
    BSTNode current = root;
    
    // Find the node to delete and its parent
    while (current != null && current.val != val) {
        parent = current;
        if (val < current.val) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    
    if (current == null) return root; // Node not found
    
    // Case 1: Node has two children
    if (current.left != null && current.right != null) {
        // Find successor and its parent
        BSTNode succParent = current;
        BSTNode succ = current.right;
        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }
        current.val = succ.val;
        // Delete successor (which has at most one right child)
        if (succParent == current) {
            succParent.right = succ.right;
        } else {
            succParent.left = succ.right;
        }
    } else {
        // Case 2: Node has one or zero children
        BSTNode child = (current.left != null) ? current.left : current.right;
        
        if (parent == null) {
            return child; // Deleting root
        }
        
        if (current == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
    return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();
        sc.close();
        long startTime = System.nanoTime();
        Inserting_Rand(args);
        Inserting_Sorted(args);
        Finding_Rand(args);
        Finding_Sorted(args);
        Deleting_Rand(args);
        Deleting_Sorted(args);
        long endTime = System.nanoTime();

        long durationNs = endTime - startTime;
        double totalSeconds = (double) durationNs / 1_000_000_000.0;
        long totalCeilingSeconds = (long) Math.ceil(totalSeconds); // Làm tròn LÊN nếu có mili giây
        long hours = totalCeilingSeconds / 3600;
        long remainingSeconds = totalCeilingSeconds % 3600;
        long minutes = remainingSeconds / 60;
        long seconds = remainingSeconds % 60;

        System.out.printf("Total runtime: %02d:%02d:%02d%n", hours, minutes, seconds);

    }
}
