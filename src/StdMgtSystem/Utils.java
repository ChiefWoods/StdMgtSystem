package StdMgtSystem;

import java.util.ArrayList;

public class Utils {
    public static <T> void sortList(ArrayList<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        mergeSort(list, 0, list.size() - 1);
    }
    
    private static <T> void mergeSort(ArrayList<T> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    
    private static <T> void merge(ArrayList<T> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        ArrayList<T> leftArr = new ArrayList<>(n1);
        ArrayList<T> rightArr = new ArrayList<>(n2);
        
        for (int i = 0; i < n1; ++i) {
            leftArr.add(list.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightArr.add(list.get(mid + 1 + j));
        }
        
        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr.get(i).toString().compareToIgnoreCase(rightArr.get(j).toString()) <= 0) {
                list.set(k, leftArr.get(i));
                i++;
            } else {
                list.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            list.set(k, leftArr.get(i));
            i++;
            k++;
        }
        
        while (j < n2) {
            list.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }

    public static <T> boolean searchElement(ArrayList<T> list, String name) {
        sortList(list);
        return binarySearch(list, name, 0, list.size() - 1);
    }
    
    private static <T> boolean binarySearch(ArrayList<T> list, String name, int low, int high) {
        if (low > high) {
            return false;
        }
        
        int mid = low + (high - low) / 2;
        String midEle = list.get(mid).toString();
        int comparison = midEle.compareToIgnoreCase(name);
        
        if (comparison == 0) {
            return true;
        }
        
        if (comparison > 0) {
            return binarySearch(list, name, low, mid - 1);
        } else {
            return binarySearch(list, name, mid + 1, high);
        }
    }
}