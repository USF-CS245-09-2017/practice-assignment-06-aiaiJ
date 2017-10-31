public class BinaryHeap{

	private int size;//size for tracking how many elements are in the array
	private int[] arr = new int[10];//initial the array as size 10

	public BinaryHeap(){
		size = 0;
	}
	//add element into the priority tree,
	public void add(int priority){
		//if the array is full, grow.
		if(arr.length==size){
			grow_heap();
		}
		//add the new element at the end of the tree
		arr[size]=priority;
		int index=size;
		//compare the new element with his parent. if it is smaller swap up.
		while(index>0 && arr[index]<arr[parent(index)]){
			swap(parent(index), index);
			index=parent(index);
		}
		//indecrease size.
		size++;
	}
	//get parent
	public int parent(int index){

		return (index-1)/2;
	}
	//get left child
	public int left_child(int index){

		return (index*2)+1;
	}
	//get right child
	public int right_child(int index){

		return (index*2)+2;
	}
	//grow the heap
	public void grow_heap(){

		int newsize = arr.length * 2;
		int[] newarr = new int[newsize];
		for(int i = 0; i < size; i++){
			newarr[i] = arr[i];
		}
		arr = newarr;
	}
	//remove the priority.
	public int remove(){
		//remove the first element
		int removed = arr[0]; 
		//if array is empty
		if(size == 0){
			System.out.println("This is an empty array");
			System.exit(1);
		}
		//give the value of the last element to the first position.
		arr[0] = arr[size-1];
		//decrease size.
		size--;
		int index = 0;
		int child = left_child(index);
		//initial child as left_child.
		if(left_child(index) < size){
			//get the smallest child and give the value to child.
			child=getSmallChild(index);
		} 
		//compare the element with its smallest child, if it is bigger swap down.
		while(child < size && arr[child] < arr[index]){
			swap(index, child);
			index = child;
			if(left_child(index) < size){
				child = getSmallChild(child);

			}
		}		
		return removed;
	}
	//compare the left and child children, and get the smallest child.
	public int getSmallChild(int index){

		int child = left_child(index);
		int right = right_child(index);
		if(arr[right] < arr[child]){

			child = right;
		}
		return child;
	}
	//swap two position.
	public void swap(int a, int b){

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}
}