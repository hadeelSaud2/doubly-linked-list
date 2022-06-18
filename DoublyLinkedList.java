
import java.util.Scanner;

public class DoublyLinkedList<E> {

    class Node<E> {

        protected E element;
        protected Node<E> next, prev;

        /**
         * Constructor that creates a node with given fields
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E newElem) {
            element = newElem;
        }

        public void setPrev(Node<E> newPrev) {
            prev = newPrev;
        }

        public void setNext(Node<E> newNext) {
            next = newNext;
        }
    }

    protected Node<E> header;
    protected Node<E> trailer;
    protected int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null; // nothing to remove
        }
        return remove(header.getNext()); // first element is beyond header
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {

        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    void printList() {
        Node<E> Current = header;
        while (Current.next != null) {
            System.out.print("{ " + Current.element + " } ");
            Current = Current.next;
        }
        System.out.println("{ " + Current.element + " } ");
    }
    
    public  void removeKey( int key) {

        Node<E> current = header.next;
         while (current.getNext() != null) {
         if ((Integer)current.getElement() == key){
          current.next.prev = current.prev;
          current.prev.next = current.next;
          size--;
         }
         current= current.next;
         }
    }
public void printBackward(){
 Node<E> current = trailer;
  while (current.prev != null){
      System.out.print("{"+current.element+"}");
  current = current.prev;
  }
    System.out.println("{"+current.element+"}");

}

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(2);
        list.addLast(9);
        list.addLast(8);
        list.addLast(5);
        list.addLast(4);
        System.out.println("wich number of the list you want to delete :");
        int key = read.nextInt();
        list.removeKey(key);
        System.out.println("after delet "+key);
       list.printList();
        System.out.println("list:");
        list.printList();
        System.out.println("\n backward list :");
        list.printBackward();
    }

}





