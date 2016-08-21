package collections;

import java.util.Collection;


public class ArrayList<T>
{
    private final int CAPACITY = 10;
    private int size = 0;
    private Object [] items;

    public ArrayList()
    {
        items = new Object[CAPACITY];
    }

    public ArrayList(Collection<? extends T> c)
    {
        addAll(c);
    }

    public ArrayList(int capacity)
    {
        if(capacity > 0)
        {
            items = new Object[capacity];
        }
        else if(capacity == 0)
        {
            items = new Object[0];
        }
        else {
            throw new IllegalArgumentException("Illegal argument: " + capacity);
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public int indexOf(Object o)
    {
        if(o == null)
        {
            for(int i = 0; i < size; i++)
            {
                if(items[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for(int i = 0; i < size; i++)
            {
                if(items[i].equals(o))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o)
    {
        if(o == null)
        {
            for(int i = size; i > 0; i--)
            {
                if(items[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for(int i = size; i > 0; i--)
            {
                if(items[i].equals(o))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public T get(int index)
    {
        if(index >= size || index < 0)
        {
            throw new IllegalArgumentException("Illegal argument: " + index);
        }
        return (T) items[index];
    }

    public T set(int index, T item)
    {
        if(index >= 0 || index < 0)
        {
            throw new IllegalArgumentException("Illegal argument:" + index);
        }
        items[index] = item;
        return item;
    }

    public void add(T item)
    {
        items[size] = item;
        size++;
        if(size == items.length)
        {
            Object [] temp = items;
            items = new Object[size+CAPACITY];
            for(int i = 0; i < temp.length; i++)
            {
                items[i] = temp[i];
            }
        }
    }

    public T remove(int index)
    {
        if(index >= size || index < 0)
        {
            throw new IllegalArgumentException("Illegal argument:" + index);
        }
        Object temp = items[index];
        for(int i = index; i < size-1; i++)
        {
            items[i] = items[i+1];
        }
        size--;
        return (T)temp;
    }

    public boolean remove(Object o)
    {
        if(o == null)
        {
            for (int i = 0; i < size; i++)
            {
                if(items[i] == null)
                {
                    remove(i);
                    return true;
                }
            }
        }
        else
        {
            for (int i = 0; i < size; i++)
            {
                if(items[i].equals(o))
                {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void clear()
    {
        items = new Object[0];
        size = 0;
    }

    public void addAll(Collection<? extends T> collection)
    {
        if(collection != null)
        {
            items = new Object[collection.size()];
            items = collection.toArray();
            size = collection.size();
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(15);
        arrayList.add(25);
        arrayList.add(35);
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());
        System.out.println(arrayList.indexOf(15));
        arrayList.remove(3);
        System.out.println(arrayList.get(2));
    }
}
