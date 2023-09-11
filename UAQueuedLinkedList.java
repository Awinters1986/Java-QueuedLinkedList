/***********************************
Due Date:		April 3rd, 2020
***********************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UAQueuedLinkedList {
	private int size;
	private UAStudent first;
	private UAStudent last;
	
	public UAQueuedLinkedList() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	public void enqueue(UAStudent s) {
		if(s != null) {
			if (last == null) {
				first = s;
				last = s;
				size++;
			} else {
				last.next = s;
				last = s;
				size++;
			}
		}
	} 
	
	public UAStudent dequeue() {
		UAStudent temp = first;
		if(first != null) {
			first = first.next;
			temp.next = null;
			size--;
		}
		
		if (first == null) {
			last = null;
		}
		return temp;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return size;
		}
		
	}
	
	public boolean isEmpty() {
		if(first == null) {
			return true;
		} else {
			return false;
		}	
	}
	
	public UAStudent peek() {
		return last;	
	}
	
	public static class UAStudent {
		
		private int studentId;
		private String firstName;
		private String lastName;
		private UAStudent next;
		private UAStudent prev;
		
		public UAStudent(String input) {
			
			String[] tokens = input.split( "," );
			
			this.studentId = Integer.parseInt(tokens[2]);
			this.firstName = tokens[1];
			this.lastName = tokens[0];
			
			this.next = null;
			this.prev = null;
			
		}
		
		public UAStudent(int id, String fName, String lName) {
			
			this.studentId = id;
			this.firstName = fName;
			this.lastName = lName;
			
			this.next = null;
			this.prev = null;
			
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public UAStudent getNext() {
			return next;
		}
		
		public void setNext(UAStudent next) {
			this.next = next;
		}
		
		public UAStudent getPrev() {
			return prev;
		}
		
		public void setPrev(UAStudent prev) {
			this.prev = prev;
		}
		
		public String toString() {
			return "Student: \t" + lastName + ", " + firstName;
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		UAQueuedLinkedList qll = new UAQueuedLinkedList();
	
		//...insert code to read records.txt and load into your stack
		
		String line;
		String file = "records.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		while ( (line = br.readLine()) != null) {
			
			UAStudent stu = new UAStudent(line);
			
			qll.enqueue(stu);
			
		}
		
		br.close();
		
		
		System.out.println("=== Start ==============================");
		System.out.println("Size of Stack:  " + qll.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Inserts ==============================");

		UAStudent a = new UAStudent("Mackey,Andrew,44444");
		qll.enqueue( a );	
		qll.enqueue( new UAStudent("Mackey,Andrew,55555") );
		qll.enqueue( new UAStudent("Mackey,Andrew,99999") );
		
		System.out.println("Size of Stack:  " + qll.size() );
		
		System.out.println("\n\n");
		System.out.println("=== Deletes ==============================");	
		System.out.println(qll.dequeue());
		System.out.println(qll.dequeue());
		
		System.out.println("Size of Stack:  " + qll.size() );
		
		System.out.println(qll.dequeue());
		
		System.out.println("Size of Stack:  " + qll.size() );
		
	}

}
