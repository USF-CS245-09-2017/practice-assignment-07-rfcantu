public class LinkedList<T> implements List<T> {

    Node head;
    int size;

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public void add(T item)
    {
        if (head == null) // if the list is empty
        {
            Node newNode = new Node(item);
            head = newNode;
            size++;
        }

        else {
            Node curr = head;
            while (curr.getNext() != null) { // get to the end of the list
                curr = curr.getNext();
            }

            Node node = new Node(item); // set the node
            node.setNext(node); // add a link so the new node can continue linking
            this.size++;
        }
    }

    public void add(int position, T item)
    {
        if (position == 0) // if it wants to add at the head
        {
            Node node = new Node(item);
            node.setNext(head); // set the head as next
            head = node;
            size++;
        }
        else
        {
            size++;
            Node curr = head;
            for (int i = 0; i < position - 1; i++)
            {
                curr = curr.getNext(); // get to the desired link in the list
            }
            Node node = new Node(item);
            node.setNext(curr.getNext()); // link it in the list
            curr.setNext(node);
        }
    }

    public T get(int position)
    {
        Node curr = head;
        for (int i = 0; i < position; i++)
        {
            curr = curr.getNext(); // get to the desired spot
        }

        return (T)curr.getData(); // return it
    }

    public T remove(int position)
    {
        if (position == 0) // if deleting the head
        {
            Node curr = head; // store the head
            head = head.getNext(); // the head is now set
            this.size--;
            return (T)curr.getData(); // return the head
        }

        else
        {
            Node prev = head;
            for (int i = 0; i < position - 1; i++)
            {
                prev = prev.getNext(); // go to the desired position
            }

            Node curr = prev.getNext(); // store the link
            prev.setNext(curr.getNext()); // delete the link
            size--;
            return (T)curr.next; // return the deleted link
        }
    }

    public int size()
    {
        return this.size;
    }
}