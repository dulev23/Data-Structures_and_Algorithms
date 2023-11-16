package Aud4;

public class MergeSort { //Divide and Conquer algorithm
    private void merge(int[] array, int l, int middle, int r) {
        int[] tmp = new int[100]; //temp store sorted elems
        int k = 0, i = l, j = middle + 1;
        int numElems = r - l + 1;

        while ((i <= middle) && (j <= r)) {
            if (array[i] < array[j]) {
                tmp[k] = array[i];
                i++;
            } else {
                tmp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            tmp[k] = array[i];
            i++;
            k++;
        }

        while (j <= r) {
            tmp[k] = array[j];
            j++;
            k++;
        }

        for (k = 0; k < numElems; k++) {
            array[l + k] = tmp[k];
        }
    }

    private void mergeSort(int[] array, int l, int r) {
        if (l == r) return;

        int middle = (l + r) / 2;
        mergeSort(array, l, middle);
        mergeSort(array, middle + 1, r);
        merge(array, l, middle, r);
    }

    public static void main(String[] args) {
        int array[] = {1, 7, 8, 4, 5, 6, 2, 2, 8, -6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, 10);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
