class Main {
    int[] memory = new int[1024]; // enough for 512 nodes
    int free; // pointer to free list

    int insert(int head, int data) throws Exception {
        int node = alloc();
        memory[node] = head; // normal link here (xored with zero)
        memory[node + 1] = data;
        memory[head] ^= node; // old head gets a xor-link
        return node; // return new head
    }

    void init() {
        // put nodes in free list
        free = 2;
        for (int i = 2; i < memory.length - 2; i += 2)
            memory[i] = i + 2;
    }

    int alloc() throws Exception {
        if (free == 0)
            throw new Exception(); // throw a better one
        int res = free;
        free = memory[free];
        return res;
    }

    void free(int ptr) {
        memory[ptr] = free;
        free = ptr;
    }
}