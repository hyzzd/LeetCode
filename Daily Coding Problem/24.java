class Main {
    class Node {
        int val;
        Node left, right, parent;
        boolean isLocked = false;
        int count = 0;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.isLocked = false;
            this.count = 0;
        }

        public boolean canLock() {
            if (this.count > 0)
                return false;

            Node curr = this.parent;
            while (curr != null) {
                if (curr.isLocked) {
                    return false;
                }

                curr = curr.parent;
            }

            return true;
        }

        public boolean isLocked() {
            return this.isLocked;
        }

        public boolean lock() {
            if (this.canLock()) {
                this.isLocked = true;

                Node curr = this.parent;
                while (curr != null) {
                    curr.count += 1;
                    curr = curr.parent;
                }

                return true;
            } else {
                return false;
            }
        }

        public boolean unlock() {
            if (this.canLock()) {
                this.isLocked = false;

                Node curr = this.parent;
                while (curr != null) {
                    curr.count -= 1;
                    curr = curr.parent;
                }

                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}