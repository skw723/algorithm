
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {4, 7, 8, 1, 5, 6, 2, 3, 9};
        bubbleSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static void bubbleSort(int[] data) {
        int count = data.length;

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
