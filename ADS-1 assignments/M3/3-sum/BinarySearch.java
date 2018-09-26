class BinarySearch {
    /**
     * binary search method.
     *
     * @param      array  The array
     * @param      key      integer
     *
     * @return result
     */
    public int binarySearch(final int[] array, final int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}