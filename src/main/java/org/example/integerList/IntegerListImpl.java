package org.example.integerList;

import org.example.exeptions.ExceptionOfListNumber;
import org.example.exeptions.IntegerListIsFull;
import org.example.exeptions.NoNeedInteger;

public class IntegerListImpl implements IntegerList {
    private Integer[] arrayInteger;
    int size = 6;
    int counter = 0;

    public IntegerListImpl() {
        arrayInteger = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        if(item == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        }
        for (int i = 0; i <= size-1; i++) {
            if (arrayInteger[counter] == null) {
                arrayInteger[counter] = item;
                counter++;
            } else {
                throw new IntegerListIsFull();
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(item == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        arrayInteger [index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if(item == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        arrayInteger [index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i <= size-1; i++) {
            if (arrayInteger[counter] == item) {
                arrayInteger[counter] = null;
                counter++;} else {
            throw new NoNeedInteger();
            }
            }

        return item;
    }

    @Override
    public Integer[] remove(int index) {
        if(arrayInteger[index] == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        Integer [] remove = new Integer[]{arrayInteger[index]};
        arrayInteger[index]=null;
        return remove;
    }

    @Override
    public boolean contains(Integer item) {
    Integer[] storageCopy = toArray();
    sort(storageCopy);
    return binarySearch(storageCopy,item);
    }

    @Override
    public int indexOf(Integer item) {
        if(item == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        }
        for (int i = 0; i <= size-1; i++) {
            if (arrayInteger[counter] == item) {
                return 1;
            } counter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if(item == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        }
        for (int i = size; i >= 0; i--) {
            if (arrayInteger[counter] == item) {
                return 1;
            } counter--;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if(arrayInteger[index] == null){
            throw new ExceptionOfListNumber.IntegerIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        return arrayInteger[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (arrayInteger.length == otherList.size()) {
            for (int i = 0; i <= size-1; i++) {
                for (int j = 0; j <= otherList.size() - 1; j++) {
                    if (arrayInteger[i] == otherList[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public int size() {
        return arrayInteger.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i <= size-1; i++) {
            if (arrayInteger[i]==null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= size - 1; i++) {
            arrayInteger[i]=null;
        }
    }

    @Override
    public Integer[] toArray() {
        Integer [] Integer = new Integer[size];
        for (int i = 0; i <= size - 1; i++) {
            arrayInteger[i]= Integer[i];
        }
        return Integer;
    }

    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer Item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Item == arr[mid]) {
                return true;
            }

            if (Item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
