package by.epam.array.service;

import by.epam.array.entity.ArrayNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayNumberFillService {


    private static final Logger logger = LogManager.getLogger(ArrayNumberFillService.class);

    public ArrayNumber fillFromFile(String fileName) throws FileNotFoundException {
        List<Integer> array = new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    array.add(num);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            logger.info("file not found");
        } catch (IOException e) {
            logger.info("file input error occurred");
        }

        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        ArrayNumber numberArray = new ArrayNumber(array.size());
        logger.info("Read numbers from file: " + numberArray.toString() + " in the NumberArray");
        return numberArray;
    }

    public ArrayNumber fillRandom(int size, int min, int max){
        ArrayNumber arrayNumber = new ArrayNumber(size);
        Random random = new Random();
        for (int i = 0; i < arrayNumber.getSize(); i++){
            arrayNumber.set(i, random.nextInt(max + 1 - min) - min);
        }
        logger.info("array filled by random: " + arrayNumber);
        return arrayNumber;
    }

}
