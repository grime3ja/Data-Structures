/**
 * @author Jacob Grimes
 * @version 12 / 18 / 2020 This class is meant to do the same operations as the
 *          LinkedList class
 */
public class GenericLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs a default StringLinkedList
     */
    public GenericLinkedList() {

        head = null;
        tail = null;
        size = 0;

    }

    /**
     * Constructs a StringLinkedList with all the values in the other 
     * StringLinkedList
     * @param other the other StringLinkedList
     */
    public GenericLinkedList(GenericLinkedList<E> other) {

        addAll(other);

    }

//    /**
//     * this returns the node at the given index
//     * @param index the given index
//     */
//    private Node getNode(int index) {
//
//        Node temp = head;
//        while (temp.next != null) {
//
//            temp = temp.next;
//
//        }
//        return temp;
//
//    }

    /**
     * @return the size
     * this returns the size of the StringLinkedList
     */
    public int size() {

        return size;

    }

    /**
     * @return true if it is empty and false otherwise
     * this returns whether or not the StringLinkedList is empty
     */
    public boolean isEmpty() {

        return size == 0;

    }

    /**
     * this clears the StringLinkedList
     */
    public void clear() {

        size = 0;

    }

    /**
     * this adds a given element to the end of StringLinkedList
     * @param element the element
     * @return true
     */
    public boolean add(E element) {

        add(size, element);
        return true;

    }

    /**
     * this adds a given element to the end of StringLinkedList
     * @param element the element
     * @return true
     */
    public boolean offer(E element) {

        add(size, element);
        return true;

    }

    /**
     * this adds a given element to the beginning of StringLinkedList
     * @param element the element
     * @return true
     */
    public boolean offerFirst(E element) {

        add(0, element);
        return true;

    }

    /**
     * this adds a given element to the end of StringLinkedList
     * @param element the element
     * @return true
     */
    public boolean offerLast(E element) {

        add(size, element);
        return true;

    }

    /**
     * this adds a given element to the beginning of StringLinkedList
     * @param element the element
     */
    public void addFirst(E element) {

        add(0, element);

    }

    /**
     * this adds a given element to the end of StringLinkedList
     * @param element the element
     */
    public void addLast(E element) {

        add(element);

    }

    /**
     * this removes the first element in a StringLinkedList
     * @return the String that gets removed
     */
    public String remove() {

        String s = head.data;
        remove(0);
        return s;

    }

    /**
     * this removes a given element of a StringLinkedList
     * @param other the element being removed
     * @return true
     */
    public boolean remove(Object other) {

        int index = indexOf(other);
        if (index == -1) {

            return false;

        }
        remove(index);
        return true;

    }

    /**
     * this adds a given element to the given index of StringLinkedList
     * @param element the element
     * @param index the index
     */
    public void add(int index, E element) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();

        }
        else {

            if (index == 0) {

                head = new Node(element, head);
                if (size == 0) {

                    tail = head;

                }

            }
            else if (index == size) {

                Node n = tail;
                tail = new Node(element);
                n.next = tail;

            }
            else {

                Node temp = head;
                for (int i = 1; i < index; i++) {

                    temp = temp.next;

                }
                temp.next = new Node(element, temp.next);

            }
            size++;

        }

    }

    /**
     * this removes an element at a given index of a  StringLinkedList
     * @param index the index
     * @return the element being removed
     */
    public E remove(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();

        }
        Object s = get(index);
        Node temp = head;
        for (int i = 0; i < size - 1; i++) {

            if (i >= index) {

                temp.data = temp.next.data;

            }
            temp = temp.next;

        }
        size--;
        return (E)s;

    }

    /**
     * this removes the first element of the StringLinkedList
     * @return the element at the first index
     */
    public E removeFirst() {

        if (head != null) {

            Object s = head.data;
            remove();
            return (E)s;

        }
        throw new IllegalArgumentException();

    }

    /**
     * this removes the last elemnt of a StringLinkedList
     * @return the element being removed
     */
    public E removeLast() {

        if (tail != null) {

            Object s = tail.data;
            remove(tail.data);
            return (E)s;

        }
        throw new IllegalArgumentException();

    }

    /**
     * this returns the head element
     * @return the head node
     */
    public E element() {

        if (head != null) {

            return (E)head.data;

        }
        throw new IllegalArgumentException();

    }

    /**
     * this takes a look at the head element
     * @return the head node
     */
    public E peek() {

        if (head != null) {

            return (E)head.data;

        }
        return null;

    }

    /**
     * this takes a look at the head element
     * @return the head node
     */
    public E peekFirst() {

        if (head != null) {

            return (E)head.data;

        }
        return null;

    }

    /**
     * this takes a look at the tail element
     * @return the tail node
     */
    public E peekLast() {

        if (tail != null) {

            return (E)tail.data;

        }
        return null;

    }

    /**
     * this removes the head element
     * @return the head node
     */
    public E poll() {

        if (!isEmpty()) {

            Object s = head.data;
            remove(head.data);
            return (E)s;

        }
        return null;

    }

    /**
     * this removes the head element
     * @return the head node
     */
    public E pollFirst() {

        if (!isEmpty()) {

            Object s = head.data;
            poll();
            return (E)s;

        }
        return null;

    }

    /**
     * this removes the tail element
     * @return the tail node
     */
    public E pollLast() {

        if (!isEmpty()) {

            Object s = tail.data;
            remove(tail.data);
            return (E)s;

        }
        return null;

    }

    /**
     * this adds to the head element
     * @param element the element that is being added
     */
    public void push(E element) {

        add(0, element);

    }

    /**
     * @return the head value
     * this removes the head element
     */
    public E pop() {

        Object s = head.data;
        remove();
        return (E)s;

    }

    /**
     * this retrieves the node at the given index
     * @return the element at the index
     * @param index the index
     */
    public E get(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();

        } 
        else {

            Node temp = head;
            for (int i = 0; i < index; i++) {

                temp = temp.next;

            }
            return (E)temp.data;

        }

    }

    /**
     * this retrieves the first element of the StringLinkedList
     * @return the head node
     */
    public E getFirst() {

        return (E)head.data;

    }

    /**
     * this retrieves the last element of the StringLinkedList
     * @return the tail node
     */
    public E getLast() {

        return (E)tail.data;

    }

    /**
     * this replaces the element at a given index with the given element
     * @param index the given index
     * @param element the given element
     * @return the replaced element
     */
    public E set(int index, E element) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();

        }
        else {

            Node temp = head;
            for (int i = 0; i < index; i++) {

                temp = temp.next;

            }
            E s = temp.data;
            temp.data = element;
            return s;

        }

    }

    /**
     * this decides if two objects are equal to each other
     * @param other the other object
     * @return true if the two elements are equal
     */
    public boolean equals(Object other) {

        if (this == other) {

            return true;

        }
        if (other instanceof GenericLinkedList) {

            GenericLinkedList o = (GenericLinkedList)other;
            if (o.size > size || size > o.size()) {

                return false;

            }
            Node temp = head;
            Node oTemp = o.head;
            for (int i = 0; i < size; i++) {

                if (!(temp.data.equals(oTemp.data))) {

                    return false;

                }
                temp = temp.next;
                oTemp = oTemp.next;

            }
            return true;
        }
        return false;

    }

    /**
     * this sets a StringLinkedList equal to an array
     * @return the array
     */
    public Object[] toArray() {

        Object[] other = new Object[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {

            other[i] = temp.data;
            temp = temp.next;

        }
        return other;

    }

    /**
     * this decides if one element is inside of the StringLinkedList
     * @param other the object that is looked for in the StringLinkedList
     * @return true if the StringLinkedList contains the given object
     */
    public boolean contains(Object other) {

        return indexOf(other) != -1;

    }

    /**
     * this finds the index of the given element
     * @param other the element that is being looked for
     * @return the index that the element is at. negative 1 if it is not found
     */
    public int indexOf(Object other) {

        Node temp = head;
        for (int i = 0; i < size; i++) {

            if (temp.data.equals(other)) {

                return i;

            }
            temp = temp.next;

        }
        return -1;

    }

    /**
     * this finds the last index of a given object
     * @param other the element
     * @return the last index of an object of a StringLinkedList
     */
    public int lastIndexOf(Object other) {

        Node temp = head;
        int index = -1;
        for (int i = 0; i < size; i++) {

            if (temp.data.equals(other)) {

                index = i;

            }
            temp = temp.next;

        }
        return index;

    }

    /**
     * this prints the StringLinkedList
     * @return the StringLinkedList
     */
    public String toString() {

        Node temp = head;
        String s = "[";
        for (int i = 0; i < size; i++) {

            s += temp.data;
            temp = temp.next;
            if (i < size - 1) {

                s += ", ";

            }

        }
        s += "]";
        return s;

    }

    /**
     * this adds all values of a given StringLinkedList to the original one
     * @param sarr the given StringLinkedList
     * @return true if the given StringLinkedList is not empty
     */
    public boolean addAll(GenericLinkedList<E> sarr) {

        if (sarr.isEmpty()) {

            return false;

        }
        else if (head == null) {

            if (sarr.head != null) {

                Node temp = head;
                for (int i = 0; i < sarr.size(); i++) {

                    temp.data = (E)sarr.get(i);
                    temp = temp.next;

                }

            }
            else {

                throw new IllegalArgumentException();

            }

        }
        tail.next = sarr.head;
        size += sarr.size();
        return true;

    }

    /**
     * this adds a StringLinkedList to the original StringLinkedList at a given
     * index
     * @param index the given index
     * @param sarr the given StringLinkedList
     * @return true if the given index is in bounds and the given 
     * StringArrayList is not empty
     */
    public boolean addAll(int index, GenericLinkedList<E> sarr) {

        if (sarr.isEmpty()) {

            return false;

        }
        else if (head == null) {

            if (sarr.head != null) {

                Node temp = head;
                for (int i = 0; i < sarr.size(); i++) {

                    temp.data = (E)sarr.get(i);
                    temp = temp.next;

                }

            }
            else {

                throw new IllegalArgumentException();

            }

        }
        else if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();

        }
        Node temp = head;
        for (int i = index; i < sarr.size(); i++) {

            temp.data = (E)sarr.get(i);
            temp = temp.next;

        }
        size += sarr.size;
        return true;

    }

    /**
     * this removes all elements that are inside of the given StringLinkedList
     * @param sarr the given StringLinkedList
     * @return true if the given StringLinkedList is not empty
     */
    public boolean removeAll(GenericLinkedList<E> sarr) {

        if (sarr.isEmpty()) {

            return false;

        }
        Node temp = head;
        for (int i = 0; i < sarr.size(); i++) {

            if (sarr.contains(temp.data)) {

                sarr.remove(temp.data);

            }
            temp = temp.next;

        }
        return true;

    }

    /**
     * this does a substring of the StringLinkedList from a given start to end
     * @param start the start of the substring
     * @param end the end of the the substring
     * @return the substring
     */
    public GenericLinkedList<E> subList(int start, int end) {

        if (start < 0 || end > size) {

            throw new IndexOutOfBoundsException();

        }
        GenericLinkedList<E> sarr = new GenericLinkedList<E>();
        Node temp = head;
        for (int i = start; i < end; i++) {

            sarr.add(temp.data);
            temp = temp.next;

        }
        return sarr;

    }

    /**
     * @author Jacob Grimes
     * @version 12 / 18 / 2020
     * this is used to make nodes in the StringLinkedList class
     */
    class Node {

        private Object data;
        private Node next;

        /**
         * this constructs a default node
         * @param data the data
         */
        public Node(Object data) {

            this(data, null);

        }

        /**
         * this constructs a node with a next node
         * @param data the data
         * @param next the element
         */
        public Node(Object data, Node next) {

            this.data = data;
            this.next = next;

        }
    }

}