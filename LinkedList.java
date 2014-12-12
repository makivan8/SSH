public class LinkedList{

	// reference to the head node.
	private Node head;
	private Node Start;
	
	// LinkedList constructor
	public LinkedList(){

		// this is an empty list, so the reference to the head node
		// is set to a new node with no IP, Time
		head = new Node(null, "25:25:25");
	}
	
	public void add(String IP, String Time){

		// post: appends the specified element to the end of this list.
		Node temp = new Node(IP,Time);
		if(head.getIP() == null){
			head = temp;
			Start = head;
		}else{
			Node current = head;
			// starting at the head node, crawl to the end of the list
			while(current.getNext() != null){
				current = current.getNext();
			}
			// the last node's "next" reference set to our new node
			current.setNext(temp);
		}
	}
	
	public String getIP(){

		// post: returns the element at the head of this list.
		Node current = head;
		return current.getIP();

	}

	public String getTime(){

		// post: returns the element at the head of this list.		
		Node current = head;
		return current.getTime();

	}
	
	public void remove(){

		// post: removes the element at the head of this list.	
		if (head == null){
          		head = null;
		}else{
          		if (head.getNext() == null){
               			head = new Node(null, "25:25:25");
               		}else{
				head = head.next;
			}
		}
	}
	
	private class Node{
		// reference to the next node in the chain, or null if there isn't one.
		Node next;
		// IP carried by this node.
		// could be of any type you need.
		String IP;
		String Time;
		
		// Node constructor
		public Node(String _IP, String _Time){
			next = null;
			IP = _IP;
			Time = _Time;
		}
		
		public Node(String _IP, String _Time, Node _next){
			next = _next;
			IP = _IP;
			Time = _Time;
		}

		public String getIP(){
			return IP;
		}

		public String getTime(){
			return Time;
		}
				
		public void setIP(String _IP, String _Time){
			IP = _IP;
			Time = _Time;
		}

		public Node getNext(){
			return next;
		}

		public Node getStart(){
			return Start;
		}
		
		public void setNext(Node _next){
			next = _next;
		}
	}
}
