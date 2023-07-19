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
            grow(arrayInteger);
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
                    if (arrayInteger[i].equals(otherList[j])) {
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
    public boolean isEmpty(Integer[] arrayInteger) {
        for (int i = 0; i <= size-1; i++) {
            if (this.arrayInteger[i]==null) {
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

    private void sort(Integer[] arrayInteger) {
        if (arrayInteger.length < 2) {
            return;
        }
        Integer mid = arrayInteger.length/2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arrayInteger.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arrayInteger [i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arrayInteger [mid =i];
        }
        sort(left);
        sort(right);
        merge(arrayInteger,left,right);
    }
    public static void merge(Integer[] arrayInteger, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arrayInteger[mainP++] = left[leftP++];
            } else {
                arrayInteger[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arrayInteger[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arrayInteger[mainP++] = right[rightP++];
        }
    }

    private boolean binarySearch(Integer[] arrayInteger, Integer Item) {
        int min = 0;
        int max = arrayInteger.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Item == arrayInteger[mid]) {
                return true;
            }

            if (Item < arrayInteger[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private Integer[] grow(Integer[] arrayInteger) {
        if (isEmpty(arrayInteger) == false) {
            System.arraycopy(arrayInteger,0,arrayInteger[(int) (1.5*size)],0,arrayInteger.length);
        }
        return arrayInteger;
    }
}
