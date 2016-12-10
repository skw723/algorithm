
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {9, 1, 7, 3, 2, 5, 4, 6, 8};
        quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        /*
        * left: -> 방향으로 가면서 처음 만나는 pivot보다 큰 수
        * right: <- 방향으로 가면서 처음 만나는 pivot보다 작은 수
        * */
        int pivot = end;
        int left = start;
        int right = end;

        // left > right 인 경우는 작은수, 큰수 순서로 정상
        while (left < right) {
            /*
            * pivot보다 큰 수를 찾기 위해 pivot이 크면 -> 방향 이동
            * 큰 수가 없는 경우 end에서 종료 (pivot == end)
            * */
            while (data[pivot] > data[left]) {
                left++;
            }

            /*
            * pivot보다 작은 수를 찾기 위해 pivot이 작으면 <- 방향으로 이동
            * right가 -로 가지 못하게 하기 위해  > 0 조건 추가
            * */
            while (right > 0 && data[pivot] <= data[right]) {
                right--;
            }

            // left < right 이면 pivot보다 큰 수가 작은수보다 앞에 있으므로 자리를 바꿔줌
            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }

        /*
        * left: -> 방향에서 처음만나는 pivot보다 큰 수와 pivot을 교환
        * pivot보다 큰 수가 없는 경우 pivot == left
        * */
        int temp = data[pivot];
        data[pivot] = data[left];
        data[left] = temp;

        /*
        * start ~ right: pivot보다 작은 수들
        * left + 1 ~ end: 위의 swap을 통해 left에 pivot이 있으므로 이 조건은 pivot보다 큰 수들
        * */
        quickSort(data, start, right);
        quickSort(data, left + 1, end);
    }
}
