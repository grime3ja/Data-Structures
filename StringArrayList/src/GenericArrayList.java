/**
 * 
 * @author Jacob Grimes
 * @version 10 / 24 / 2020 This class is meant to do the same operations as the
 *          ArrayList class
 * @param <E> The type of ArrayList
 */
public class GenericArrayList<E> {

    private int size;
	private Object[] arr;

	/**
	 * sets the default value of the StringArrayList
	 */
	public GenericArrayList() {

		size = 0;
		arr = new Object[8];

	}

	/**
	 * 
	 * makes a new StringArrayList that copies all 
	 * the values of the original array
	 * to a new one
	 * 
	 * @param newArr the new ArrayList
	 */
	public GenericArrayList(GenericArrayList<E> newArr) {

		arr = new Object[newArr.size()];
		addAll(newArr);

	}

	/**
	 * 
	 * sets the length of background array to its size, then sets the size to 0
	 * 
	 * @param size the size of the array
	 */
	public GenericArrayList(int size) {

		arr = new Object[size];
		this.size = 0;

	}

	/**
	 * This makes sure that the array has enough space in it before adding more
	 */
	public void ensureCapacity() {

		if (size > arr.length) {

			Object[] sarr = new Object
			[Math.max(arr.length * 2, arr.length + 8)];
			for (int i = 0; i < arr.length; i++) {

				sarr[i] = arr[i];

			}
			arr = sarr;

		}

	}

	/**
	 * this returns the size of the StringArrayList
	 * 
	 * @return the size of the StringArrayList
	 */
	public int size() {

		return size;

	}

	/**
	 * this sees if the StringArrayList has no values
	 * 
	 * @return true if the size is 0 and false otherwise
	 */
	public boolean isEmpty() {

		return size == 0;

	}

	/**
	 * this adds a value to the StringArrayList
	 * 
	 * @param s the value being added
	 * @return true if something got added
	 */
	public boolean add(E s) {

		add(size, s);
		return true;

	}

	/**
	 * this gets the value at a given index
	 * 
	 * @param index the index that is being searched
	 * @return the value that is at the given index
	 */
	public E get(int index) {

		if (index >= 0 && index < size) {

			return (E)arr[index];

		}
		throw new IndexOutOfBoundsException();

	}

	/**
	 * this adds a value at an index
	 * 
	 * @param index the index that the value is being added at
	 * @param s     the value that is being added
	 */
	public void add(int index, E s) {

		if (index > size || index < 0) {

			throw new IndexOutOfBoundsException();

		}
		ensureCapacity();
		for (int i = size; i > index; i--) {

			arr[i] = arr[i - 1];

		}
		arr[index] = s;
		size++;

	}

	/**
	 * this prints the StringArrayList
	 * 
	 * @return the StringArrayList
	 */
	public String toString() {

		String s = "";
		s += "[";
		for (int i = 0; i < size; i++) {

			s += arr[i];
			if (i < size - 1) {

				s += ", ";

			}

		}
		s += "]";
		return s;

	}

	/**
	 * this sets a given index to a value
	 * 
	 * @param index the index that is being changed
	 * @param value what the index is being changed to
	 * @return the original value at that index
	 */
	public E set(int index, E value) {

		if (index < size && index >= 0) {

			Object temp = arr[index];
			arr[index] = value;
			return (E)temp;

		}
		throw new IndexOutOfBoundsException();

	}

	/**
	 * this checks if something is equal to another
	 * 
	 * @param other the value that is being compared
	 * @return true if the value is equal to the other
	 */
	public boolean equals(Object other) {

		if (this == other) {

			return true;

		}
		if (other instanceof GenericArrayList) {

			GenericArrayList str = (GenericArrayList) other;
			for (int i = 0; i < size; i++) {

				if (!(str.get(i).equals(arr[i]))) {

					return false;

				}

			}
			return true;

		}
		return false;

	}

	/**
	 * sets the StringArrayList to a Object array
	 * 
	 * @return an Object array
	 */
	public Object[] toArray() {

		Object[] other = new Object[size];
		for (int i = 0; i < size; i++) {

			other[i] = arr[i];

		}
		return other;

	}

	/**
	 * checks if the StringArrayList has one value in it
	 * 
	 * @param other the value being searched for
	 * @return true if the value exists, false otherwise
	 */
	public boolean contains(Object other) {

		return indexOf(other) != -1;

	}

	/**
	 * returns the first occurrence of a value
	 * 
	 * @param other the value
	 * @return the first occurrence of a value, -1 if it doesn't exist
	 */
	public int indexOf(Object other) {

		for (int i = 0; i < size; i++) {

			if (arr[i].equals(other)) {

				return i;

			}

		}
		return -1;

	}

	/**
	 * finds the last occurrence of a value
	 * 
	 * @param other the value
	 * @return the last occurrence of the value, -1 if it doesn't exist
	 */
	public int lastIndexOf(Object other) {

		for (int i = size - 1; i >= 0; i--) {

			if (arr[i].equals(other)) {

				return i;

			}

		}
		return -1;

	}

	/**
	 * removes an index from the StringArrayList
	 * 
	 * @param index the index being removed
	 * @return the value that got removed
	 */
	public E remove(int index) {

		if (index >= 0 && index < size) {

			Object temp = get(index);
			for (int i = index; i < size - 1; i++) {

				arr[i] = arr[i + 1];

			}
			size--;
			return (E)temp;

		}
		throw new IndexOutOfBoundsException();

	}

	/**
	 * removes a value from the StringArrayList
	 * 
	 * @param other the value being removed
	 * @return true if something gets removed, false otherwise
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
	 * removes every value from the StringArrayList
	 */
	public void clear() {

		for (int i = 0; i < size; i++) {

			arr[i] = null;

		}
		size = 0;

	}

	/**
	 * adds all the values from the given
	 * StringArrayList to the background array
	 * 
	 * @param sarr the StringArrayList
	 * @return true if something gets added, false otherwise
	 */
	public boolean addAll(GenericArrayList<E> sarr) {

		if (!(sarr.isEmpty())) {

			if (arr.length < sarr.size() + size) {

				Object[] s = new Object[size + sarr.size()];
				for (int i = 0; i < sarr.size(); i++) {

					s[i] = arr[i];

				}
				for (int i = 0; i < sarr.size(); i++) {

					s[size] = sarr.get(i);
					size++;

				}
				arr = s;
				return true;
			}

			for (int i = 0; i < sarr.size(); i++) {

				arr[i] = sarr.get(i);
				size++;
				
			}
			return true;

		}
		return false;
	}

	/**
	 * adds all values of a given StringArrayList at a given index
	 * 
	 * @param index the index
	 * @param sarr  the StringArrayList
	 * @return true if something gets added, false otherwise
	 */
	public boolean addAll(int index, GenericArrayList<E> sarr) {
		if (index >= size || index < 0) {
			
			throw new IndexOutOfBoundsException();
			
		}
		if (!(sarr.isEmpty())) {

			Object[] s = new Object[arr.length + sarr.size()];
			int newSize = 0;
			for (int i = 0; i < index; i++) {

				s[i] = arr[i];
				newSize++;

			}
			for (int i = 0; i < sarr.size(); i++) {

				s[newSize] = sarr.get(i);
				newSize++;
				size++;

			}
			for (int i = 0; i < size - newSize; i++) {

				s[newSize] = arr[i + index];
				newSize++;

			}
			arr = s;
			size = newSize;
			return true;

		}

		for (int i = (size + sarr.size()); i >= index + sarr.size(); i--) {

			arr[i] = arr[i - sarr.size()];

		}
		int newSize = index;
		for (int i = 0; i < sarr.size(); i++) {

			arr[newSize] = sarr.get(i);
			newSize++;
			size++;

		}
		return true;

	}

	/**
	 * removes all occurrences of a given StringArrayList
	 * 
	 * @param sarr the StringArrayList
	 * @return true if something gets removed, false otherwise or if the
	 *         StringArrayList is empty
	 */
	public boolean removeAll(GenericArrayList<E> sarr) {

		if (sarr.isEmpty()) {

			return false;

		}
		boolean hello = false;
		Object[] yes = new Object[size];
		int nextIndex = 0;
		for (int i = 0; i < size; i++) {

			if (sarr.contains(arr[i])) {

				hello = true;

			}

			else {

				yes[nextIndex] = arr[i];
				nextIndex++;

			}

		}
		size = nextIndex;
		arr = yes;
		return hello;

	}

	/**
	 * shortening the background array to a new size
	 */
	public void trimToSize() {

		Object[] newArr = new Object[size];
		for (int i = 0; i < size; i++) {

			newArr[i] = arr[i];

		}
		arr = newArr;

	}

	/**
	 * returns the number of available slots
	 * 
	 * @return the number of available slots
	 */
	public int getCapacity() {

		return arr.length - size;

	}
	
	/**
	 * returns a substring of the list
	 * @param start the starting of the substring, inclusive
	 * @param end the last slot that is counted, exclusive
	 * @return the new ArrayList
	 */
	public GenericArrayList<E> subList(int start, int end) {
	    
		if (start < 0 || end > size) {
			
			throw new IndexOutOfBoundsException();
			
		}
		GenericArrayList<E> sarr = new GenericArrayList<E>();
		for (int i = start; i < end; i++) {
			
			E temp = sarr.get(i);
			temp = (E)arr[i];
			
		}
		return sarr;
		
	}
}