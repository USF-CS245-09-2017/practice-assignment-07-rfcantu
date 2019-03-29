import java.util.*;
import java.lang.*;

public class ArrayList<T> implements List<T> {

    int capacity = 10;
    int size = 0;
    Object[] arrList;

    public ArrayList()
    {
        arrList = new Object[capacity];
    }

    public void add(T item)
    {
        if (arrList.length == size) // if we hit the limit
        {
            doubleSize();
        }
        arrList[size++] = item;
    }

    public void add(int position, T item)
    {
        if (arrList.length == size) // if we hit the limit
        {
            doubleSize();
        }
        for (int i = size; i > position; i--)
        {
            arrList[i] = arrList[i - 1]; // get to the desire position while also moving everything over
        }
        arrList[position] = item; // insert the new item
        size++;
    }

    public T get(int position)
    {
        return (T)arrList[position];
    }

    public T remove(int position)
    {
        T temp = (T)arrList[position]; // store the element to be deleted
        for (int i = 0; i < size - 1; i++)
        {
            arrList[i] = arrList[i + 1]; // move everything in the array over
        }
        size--;
        return temp; // return the deleted element
    }

    public int size()
    {
        return this.size;
    }

    public void doubleSize()
    {
        T[] temp = (T[]) new Object[arrList.length * 2];
        for (int i = 0; i < arrList.length; i++)
        {
            temp[i] = (T)arrList[i];
        }
        arrList = temp;
    }

}