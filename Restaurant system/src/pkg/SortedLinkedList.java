package pkg;
public class SortedLinkedList<T>{
    private Node start = null;
    private int size = 0;

    class Node{
        Node next = null;
        T data;
        Node(T x){
            data = x;
        }
    }

    public Boolean isEmpty(){
        if(start == null){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean add(T data){
        if(start == null){
            start = new Node(data);
        }
        else{
            return null;
        }
    }

    public T remove(String dateString){
        if(start == null){
            return null;
        }
        else{
            return null;
        }
    }


    public int size(){
        return size;
    }
}
