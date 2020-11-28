package by.epam.array.service;

import by.epam.array.entity.ArrayNumber;

public class ArrayNumberService {

    private boolean isPrimitiveNumber(int number){
        for (int i=2; i<number; i++){
            if (number%i == 0){
                return false;
            }
            if ((i==number) || (i>Math.sqrt(number))){
                return true;
            }
        }
        return false;
    }

    private boolean isFibonnachiNumber(int number){
        double sqr1 = 5 * Math.pow(number, 2) - 4;
        double sqr2 = 5 * Math.pow(number, 2) + 4;
        return sqr1 % 1 == 0 || sqr2 % 1 == 0;
    }

    private boolean isUniqueNumber(int number){
        if (number < 100 || number > 999){
            return false;
        }
        int[] numerals = new int[3];
        numerals[0] = number / 100;
        numerals[1] = (number / 10) % 10;
        numerals[2] = number % 10;
        for (int i = 0; i < 3; i++){
            for (int j = i + 1; j < 3; j++){
                if (numerals[i] == numerals[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int findBin(ArrayNumber arrayNumber, int value){
        int low = 0;
        int high = arrayNumber.getSize() - 1;
        int m = (low + high) / 2;
        while (arrayNumber.get(m) != value){
            if (arrayNumber.get(m) > value){
                m--;
            }
            if (arrayNumber.get(m) < value){
                m++;
            }
        }
        return m;
    }

    public int findMaxItem(ArrayNumber arrayNumber){
        int maxValue = arrayNumber.get(0);
        for (int item : arrayNumber){
            if (item > maxValue){
                maxValue = item;
            }
        }
        return maxValue;
    }

    public int findMinItem(ArrayNumber arrayNumber){
        int minValue = arrayNumber.get(0);
        for (int item : arrayNumber){
            if (item < minValue){
                minValue = item;
            }
        }
        return minValue;
    }

    public ArrayNumber sortBubble(ArrayNumber arrayNumber){
        for (int i = 0; i < arrayNumber.getSize(); i++){
            for (int k = i+1; k < arrayNumber.getSize(); k++){
                if (arrayNumber.get(k) > arrayNumber.get(i)){
                    int temp = arrayNumber.get(k);
                    arrayNumber.set(k, arrayNumber.get(i));
                    arrayNumber.set(i, temp);
                }
            }
        }
        return arrayNumber;
    }

    public ArrayNumber quickSort(ArrayNumber arrayNumber, int low, int high){
        if (arrayNumber.getSize() == 0){
            return null;
        }
        if (low > high){
            return null;
        }
        int middle = (low + high) / 2;
        int pivot = arrayNumber.get(middle);
        int i = low;
        int j = high;
        while (i <= j) {
            while (arrayNumber.get(i) < pivot) {
                i++;
            }
            while (arrayNumber.get(j) > pivot) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = arrayNumber.get(i);
                arrayNumber.set(i, arrayNumber.get(j));
                arrayNumber.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j){
            arrayNumber = this.quickSort(arrayNumber, low, j);
        }
        if (high > i){
            arrayNumber = this.quickSort(arrayNumber, i, high);
        }
        return arrayNumber;
    }

    public ArrayNumber sortShell(ArrayNumber arrayNumber){
        for (int i = 0; i < arrayNumber.getSize(); i++){
            int minValue = arrayNumber.get(i);
            int minIndex = i;
            for (int j = i + 1; j < arrayNumber.getSize(); j++){
                if (arrayNumber.get(j) < minValue){
                    minValue = arrayNumber.get(j);
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int temp = arrayNumber.get(i);
                arrayNumber.set(i, arrayNumber.get(minIndex));
                arrayNumber.set(minIndex, temp);
            }
        }
        return arrayNumber;
    }

    public ArrayNumber getPrimitiveNumbers(ArrayNumber arrayNumber){
        int count = 0;
        for (int value : arrayNumber){
            if (this.isPrimitiveNumber(value)){
                count++;
            }
        }
        if (count > 0){
            ArrayNumber result = new ArrayNumber(count);
            for (int i = 0; i < result.getSize(); i++){
                for (int j = 0; j < arrayNumber.getSize(); j++){
                    if (this.isPrimitiveNumber(arrayNumber.get(j))){
                        result.set(i, arrayNumber.get(j));
                    }
                }
            }
            return result;
        }
        return null;
    }

    public ArrayNumber getFibonnachiNumbers(ArrayNumber arrayNumber){
        int count = 0;
        for (int value : arrayNumber){
            if (this.isFibonnachiNumber(value)){
                count++;
            }
        }
        ArrayNumber result = new ArrayNumber(count);
        for (int i = 0; i < result.getSize(); i++){
            for (int j = 0; j < arrayNumber.getSize(); j++){
                if (this.isFibonnachiNumber(arrayNumber.get(j))){
                    result.set(i, arrayNumber.get(j));
                }
            }
        }
        return result;
    }

    public ArrayNumber transformUniqueNumbers(ArrayNumber arrayNumber){
        int count = 0;
        for (int value : arrayNumber){
            if (this.isUniqueNumber(value)){
                count++;
            }
        }
        ArrayNumber result = new ArrayNumber(count);
        for (int i = 0; i < result.getSize(); i++){
            for (int j = 0; j < arrayNumber.getSize(); j++){
                if (this.isPrimitiveNumber(arrayNumber.get(i))){
                    result.set(i, arrayNumber.get(j));
                }
            }
        }
        return result;
    }

}
