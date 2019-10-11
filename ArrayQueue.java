public class ArrayQueue<T> implements Queue<T> {
  // 'a' is the array of all items
  protected T[] a;
  // 'Front' is the front of the data in the queue
  protected int front = 0;
  // 'Back' is the 'back' of the array values
  protected int back = 0;

  // Constructor
  public ArrayQueue(){
    a = (T[]) new Object[10];
  }


  // Checks if Queue is empty
  public boolean empty() {
    return front == back;
  }

  // Dequeues an item from the end
  public T dequeue() throws Exception {
    // First check if it's valid
    if(empty()) {
      throw new Exception("Cannot dequeue: Queue is empty.");
    }
    // Select the front item
    T item = a[front];
    front = (front + 1)%a.length;
    // Return the front item
    return item;
  }

  // Enqueues an item to the end
	public void enqueue(T item) {
    // If the front is at the end of the slots, grow the array
    if(front == (back+1) % a.length) {
      grow_array();
    }
    // Set the item at the back of 'a' to the enqueued item
    a[back] = item;
    // Set a new 'back' value to the Queue
    back = (back+1) % a.length;
  }



  // Doubles the size of the array
  private void grow_array() {
    // Create a new generic array of twice the length
    T[] new_a = (T[]) new Object[a.length*2];
    // Copy the items over
    System.arraycopy(a, 0, new_a, 0, a.length);
    // Set the front again
    front = 0;
    // Set the back to the end of the array slots
    back = a.length-1;
    // Set values over
    a = new_a;
  }
}
