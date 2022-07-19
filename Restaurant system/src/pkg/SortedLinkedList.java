package pkg;
public class SortedLinkedList<T extends Comparable <T>>{
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

    public void printAll(){
        Node currentNode = start;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void add(T data){
        /*
        Take a data and compare it with other datas stored in the list.
        Place the date infront of the data, that by compareing is larger than
        new data we want to place.

        Args: data (Any compareble data type)
        Return: None
        */
        Node newNode = new Node(data);

        //If list is empty then just place the new data
        if(isEmpty()){
            start = newNode;
            size += 1;
        }
        //Check the new data is smaller than start.
        else if(data.compareTo(start.data) <= 0){
            Node tmp = start;
            start = newNode;
            start.next = tmp;
            size += 1;
        }
        else{
            //Iterativ going through datas, until it find a data that is larger than
            //new data, or reach the end.
            Node currentNode = start;
            Boolean placed = false;
            while(currentNode != null && !placed){
                if(currentNode.next == null){
                    currentNode.next = newNode;
                    size += 1;
                    placed = true;
                }
                else if(data.compareTo(currentNode.next.data) <= 0){
                    Node tmp = currentNode.next;
                    currentNode.next = newNode;
                    newNode.next = tmp;
                    size += 1;
                    placed = true;
                }
                else{
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public T remove(T data){
        /*
        Find the data we want to remove and remove it from the list.

        Args: data (Any compareble data type)
        Return: data (Any compareble data type)
        */
        if(start == null){
            return null;
        }
        else if(data.compareTo(start.data) == 0){
            Node removeNode = start;
            start = removeNode.next;
            size -= 1;
            return removeNode.data;

        }
        else{
            Node currentNode = start;
            while(currentNode != null){
                if(currentNode.next == null){
                    return null;
                }
                else if(data.compareTo(currentNode.next.data) == 0){
                    Node removeNode = currentNode.next;
                    currentNode.next = removeNode.next;
                    size -= 1;
                    return removeNode.data;
                }
                else{
                    currentNode = currentNode.next;
                }
            }
            //No data match to the given argument.
            return null;
        }
    }

    public T remove(){
        /*
        Remove the first element of list

        Args: None
        Return: data (Any compareble data type)
        */

        if(start == null){
            return null;
        }
        else{
            Node tmp = start;
            start = start.next;
            size -= 1;
            return tmp.data;
        }
    }

    public T get(T data){
        /*
        Find the data with the given argument and return it.
        Ex:
        For Reservation, we make a empty Reservation-object with a given dateString.
        Then use this Reservation object to find the Reservation-object we want that
        is stored in the list.

        Args: data (Any compareble data type)
        Return: data (Any compareble data type)
        */
        if(start == null){
            return null;
        }
        else if(data.compareTo(start.data) == 0){
            return start.data;

        }
        else{
            Node currentNode = start;
            while(currentNode != null){
                if(currentNode.next == null){
                    return null;
                }
                else if(data.compareTo(currentNode.next.data) == 0){
                    return currentNode.next.data;
                }
                else{
                    currentNode = currentNode.next;
                }
            }
            //No data match to the given argument.
            return null;
        }
    }

    public int size(){
        return size;
    }
}
