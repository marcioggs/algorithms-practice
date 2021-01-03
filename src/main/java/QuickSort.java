public class QuickSort {

    public void quickSort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int partitionIndex = partition(array, low, high);

        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[getPivot(array, low, high)];

        int maxLowerInd = low - 1;

        for (int i = low; i <= high; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++maxLowerInd);
            }
        }
        return maxLowerInd;
    }

    public int getPivot(int[] array, int low, int high) {
        // TODO: Test with pivot index best of tree
        return high;
    }

    public void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
