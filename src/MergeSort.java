
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {3, 1, 2, 7, 5, 4};
        mergeSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static void mergeSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        // data를 2부분으로 분할
        int mid = (end - start) / 2 + start;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);

        int left = start;
        int right = mid + 1;

        int[] tempData = new int[data.length];
        int index = start;
        // left~mid, mid + 1 ~ right 2부분을 병합
        while (left <= mid && right <= end) {
            if (data[left] > data[right]) {
                tempData[index++] = data[right++];
            } else {
                tempData[index++] = data[left++];
            }
        }

        // left부분이 남아있는 경우
        if (left <= mid) {
            for (int i = left; i <= mid; i++) {
                tempData[index++] = data[i];
            }
        }

        // right부분이 남아있는 경우
        if (right <= end) {
            for (int i = right; i <= end; i++) {
                tempData[index++] = data[i];
            }
        }

        // 병합한 부분 start ~ end 를 data에 반영
        for (int i = start; i <= end; i++) {
            data[i] = tempData[i];
        }
    }
}
