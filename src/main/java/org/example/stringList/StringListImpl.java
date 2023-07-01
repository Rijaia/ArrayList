package org.example.stringList;

import org.example.exeptions.ExceptionOfListNumber;
import org.example.exeptions.NoNeedString;

import org.example.exeptions.StringIsNull;
import org.example.exeptions.StringListIsFull;

public class StringListImpl implements StringList{
    private String[] arrayString;
    int size = 6;
    int counter = 0;

    public StringListImpl() {
        arrayString = new String[size];
    }

    @Override
    public String add(String item) {
        if(item == null){
            throw new StringIsNull();
        }
        for (int i = 0; i <= size-1; i++) {
            if (arrayString[counter] == null) {
                arrayString[counter] = item;
                counter++;
            } else {
                throw new StringListIsFull();
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        if(item == null){
            throw new StringIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        arrayString [index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if(item == null){
            throw new StringIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        arrayString [index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i <= size-1; i++) {
            if (arrayString[counter] == item) {
                arrayString[counter] = null;
                counter++;} else {
            throw new NoNeedString();
            }
            }

        return item;
    }

    @Override
    public String[] remove(int index) {
        if(arrayString[index] == null){
            throw new StringIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        String [] remove = new String[]{arrayString[index]};
        arrayString[index]=null;
        return remove;
    }

    @Override
    public boolean contains(String item) {
        if(item == null){
            throw new StringIsNull();
        }
        for (int i = 0; i <= size-1; i++) {
            if (arrayString[counter] == item) {
                return true;
            } counter++;
    }
    return false;}

    @Override
    public int indexOf(String item) {
        if(item == null){
            throw new StringIsNull();
        }
        for (int i = 0; i <= size-1; i++) {
            if (arrayString[counter] == item) {
                return 1;
            } counter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if(item == null){
            throw new StringIsNull();
        }
        for (int i = size; i >= 0; i--) {
            if (arrayString[counter] == item) {
                return 1;
            } counter--;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if(arrayString[index] == null){
            throw new StringIsNull();
        } if (index > size) {
            throw new ExceptionOfListNumber();
        }
        return arrayString[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (arrayString.length == otherList.size()) {
            for (int i = 0; i <= size-1; i++) {
                for (int j = 0; j <= otherList.size() - 1; j++) {
                    if (otherList[j] = arrayString[i]) {

                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public int size() {
        return arrayString.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i <= size-1; i++) {
            if (arrayString[i]==null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= size - 1; i++) {
            arrayString[i]=null;
        }
    }

    @Override
    public String[] toArray() {
        String [] string = new String[size];
        for (int i = 0; i <= size - 1; i++) {
            arrayString[i]= string[i];
        }
        return string;
    }
}
