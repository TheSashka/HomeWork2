package collections;

import java.util.Map;
import java.util.Objects;

public class HashMap<K,V>
{
    private int size;
    private int capacity;
    private int modificationCount;
    private Node<K,V>[] nodes = new Node[capacity];

    static class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            hash = hashCode();
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
        public void setKey(K key)
        {
            this.key = key;
        }
        public void setNext(Node<K,V> next)
        {
            this.next = next;
        }
        public Node<K,V> getNext()
        {
            return next;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Node) {
                Node<?,?> e = (Node<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    public HashMap()
    {

    }

    public HashMap(int capacity)
    {
        this.capacity = capacity;
    }


    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public V get(Object key)
    {
        if(key == null)
        {
            if(nodes[0] == null)
            {
                return null;
            }
            return nodes[0].getValue();
        }

        int numBacket = Math.abs(key.hashCode()) % capacity;

        if(nodes[numBacket] == null)
        {
            return null;
        }
        else
        {
            Node<K,V> entry = nodes[numBacket];
            while (true)
            {
                if(entry.getKey().equals(key))
                {
                    return entry.getValue();
                }

                if(entry.getNext() == null)
                {
                    return null;
                }

                entry = entry.getNext();
            }
        }

    }

    public V put(K key, V value)
    {
        if(key == null)
        {
            if(nodes[0] == null)
            {
                nodes[0] = new Node<K, V>(null, value);
                size++;
            }
            else
            {
                nodes[0].setValue(value);
            }
        }

        return value;
    }


    public void remove(Object key)
    {
        if(key == null)
        {
            if(nodes[0] != null)
            {
                modificationCount++;
                size--;

                if(nodes[0].getNext() != null)
                {
                    nodes[0] = nodes[0].getNext();
                }
            }
            return;
        }

        int numBacket = Math.abs(key.hashCode()) % capacity;

        if(nodes[numBacket].getNext() != null)
        {
            Node<K,V> prev = nodes[numBacket];
            Node<K,V> entry = nodes[numBacket].getNext();
            Node<K,V> next = entry.getNext();

            while (true)
            {
                if(entry.getKey().equals(key))
                {
                    modificationCount++;
                    size--;

                    prev.setNext(next);
                    return;
                }

                if(next == null)
                {
                    return;
                }

                prev = entry;
                entry = next;
                next = next.getNext();
            }
        }

    }

    public void clear() {
        nodes = new Node[capacity];
    }
}
