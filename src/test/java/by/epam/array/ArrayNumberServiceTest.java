package by.epam.array;

import by.epam.array.entity.ArrayNumber;
import by.epam.array.service.ArrayNumberService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayNumberServiceTest {

    ArrayNumber array = new ArrayNumber(5, 8, 7, 4, 1, 4, 0);
    ArrayNumberService service = new ArrayNumberService();

    @Test
    public void findBinTest(){
        int actual = service.findBin(array, 4);
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findMaxItemTest(){
        int actual = 8;
        int expected = service.findMaxItem(array);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findMinItem(){
        int actual = 0;
        int expected = service.findMinItem(array);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortBubbleTest(){
        ArrayNumber actual = service.sortBubble(array);
        ArrayNumber expected = new ArrayNumber(0, 1, 4, 4, 5, 7, 8);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void quickSortTest(){
        ArrayNumber actual = service.quickSort(array, 0, array.getSize()-1);
        ArrayNumber expected = new ArrayNumber(0, 1, 4, 4, 5, 7, 8);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortShell(){
        ArrayNumber actual = service.sortShell(array);
        ArrayNumber expected = new ArrayNumber(0, 1, 4, 4, 5, 7, 8);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getPrimitiveNumbersTest(){
        ArrayNumber actual = service.getPrimitiveNumbers(array);
        ArrayNumber expected = new ArrayNumber(5, 7);
        Assert.assertEquals(actual, expected);
    }
}
