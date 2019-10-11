class ArrayStack<T> implements Stack<T> {

  // Top is the index of the "top" item
  protected int top = -1;
  // 'a' is the array of generic objects
  protected T[] a;



  // Constructor
  public ArrayStack() {
    // Creates new generic array
    a = (T[]) new Object[10];
  }



  // Checks if empty
  public boolean empty() {
    return(top == -1);
  }

  // Add a new item to the array, iterate top by 1
  public void push(T item) {
    // If the length is at the top then grow the array
    if(a.length - 1 == top) {
      grow_array();
    }
    // Iterate the top value and set it to the item pushed
    a[++top] = item;
  }

  // Pop an item from the top, iterate the top downward
	public T pop() throws Exception {
    if(empty()) {
      throw new Exception("Cannot pop: Stack is empty.");
    }
    // Return top item and iterate 'top' downward
    return a[top--];
  }

  // Peek at the top value
	public T peek() throws Exception {
    if(empty()) {
      throw new Exception("Cannot peek: Stack is empty.");
    }
    // returns the top value
    return a[top];
  }



  // Doubles the size of the array
  private void grow_array() {
    // Create a new generic array of twice the size
    T[] new_a = (T[]) new Object[a.length*2];
    // Copy the values over
		System.arraycopy(a, 0, new_a, 0, a.length);
    // Set the 'a' pointer to the 'new_a' pointer
    a = new_a;
  }

}
