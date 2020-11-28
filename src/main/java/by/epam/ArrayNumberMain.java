package by.epam;

import by.epam.array.entity.ArrayNumber;
import by.epam.array.service.ArrayNumberService;

public class ArrayNumberMain {

    public static void main (String[] args){
        ArrayNumber arrayNumber = new ArrayNumber(7, 5, 4, 8, 0, 4, 9);
        ArrayNumberService service = new ArrayNumberService();
        arrayNumber = service.sortShell(arrayNumber);
        System.out.println(arrayNumber);
        System.out.println(service.findBin(arrayNumber, 4));
        System.out.println(784/100);
    }
}
