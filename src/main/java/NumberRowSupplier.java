public class NumberRowSupplier {

    public final int[] getFinalArray() {
        return new int[]{1, 2, 3};
    }

    public static int[] getStaticArray() {
        return new int[]{4, 5, 6};
    }

    private int[] getPrivateArray() {
        return new int[]{7, 8, 9};
    }
}
