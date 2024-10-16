package StudentManagementApp;

class StudentStack {
    Node top;
    private int size;
    public StudentStack(){
        top = null;
        size = 0;
    }

    public void push(Student student){
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Student pop(){
        if(isEmpty()){
            System.out.println("Stack is empty. No students to remove!");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        size--;
        return poppedStudent;
    }

    public Student peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return null;
        }
        return top.student;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return size;
    }

    public void displayStudents(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Students in stack:");
        Node current = top;
        while(current != null){
            System.out.println(current.student);
            current = current.next;
        }
    }
}
