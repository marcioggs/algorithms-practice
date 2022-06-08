package sort;

class QuickSort {

  public void quickSort(int[] array, int low, int high) {

    if (low >= high) {
      return;
    }

    int partitionIndex = this.partition(array, low, high);

    this.quickSort(array, low, partitionIndex - 1);
    this.quickSort(array, partitionIndex + 1, high);
  }

  private int partition(int[] array, int low, int high) {
    int pivot = array[this.getPivot(array, low, high)];

    int maxLowerInd = low - 1;

    for (int i = low; i <= high; i++) {
      if (array[i] <= pivot) {
        this.swap(array, i, ++maxLowerInd);
      }
    }
    return maxLowerInd;
  }

  private int getPivot(int[] array, int low, int high) {
    // TODO: Test with pivot index best of tree
    return high;
  }

  private void swap(int[] array, int ind1, int ind2) {
    int temp = array[ind1];
    array[ind1] = array[ind2];
    array[ind2] = temp;
  }
}
