import java.util.BitSet;

class Main {
    private BitSet bits;

    public Main(String bits) {
        this.bits = fromString(bits);
    }

    private BitSet getBitSet() {
        return bits;
    }

    private void setBitSet(BitSet bitSet) {
        bits = bitSet;
    }

    public Main and(Main bitarray) {
        BitSet bits1 = this.getBitSet();
        BitSet bits2 = bitarray.getBitSet();

        bits1.and(bits2);
        this.setBitSet(bits1);
        return this;
    }

    public Main or(Main bitarray) {
        BitSet bits1 = this.getBitSet();
        BitSet bits2 = bitarray.getBitSet();
        bits1.or(bits2);
        this.setBitSet(bits1);
        return this;
    }

    private BitSet fromString(String bit) {
        return BitSet.valueOf(new long[] { Long.parseLong(bit, 2) });
    }

    public String toString() {
        return Long.toString(bits.toLongArray()[0], 2);
    }

    public static void main(String... arg) {
        Main array1 = new Main("1010");
        Main array2 = new Main("1001");
        Main array3 = new Main("1100");

        System.out.println("The Main Are");
        System.out.println("First :" + array1);
        System.out.println("Second :" + array2);
        System.out.println("Third : " + array3);

        System.out.println("First AND Second");
        System.out.println(array1.and(array2));

        System.out.println("Second OR Third");
        System.out.println(array2.or(array3));
    }
}