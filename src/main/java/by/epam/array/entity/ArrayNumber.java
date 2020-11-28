package by.epam.array.entity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayNumber implements Iterable<Integer>{

    private int[] sequence;
    private int size = 0;

    public ArrayNumber(int size){
        this.size = size;
    }

    public ArrayNumber(int... sequence){
        this.sequence = sequence;
        this.size = sequence.length;
    }


    public Iterator<Integer> iterator() {
        return Arrays.stream(this.sequence).iterator();
    }

    public int getSize(){
        return this.size;
    }

    public int get(int index){
        return this.sequence[index];
    }

    public void set(int index, int value){
        this.sequence[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("ArrayNumber{");
        string.append(Arrays.toString(sequence));
        string.append(", ");
        string.append("size = ");
        string.append(this.size);
        string.append("}");
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayNumber integers = (ArrayNumber) o;
        return size == integers.size &&
                Arrays.equals(sequence, integers.sequence);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(sequence);
        return result;
    }
}
