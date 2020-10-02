package sample.Owner;

public class Node<E>
{
    //INSTANCES
    private E data;
    public Node<E> next;

    //CONSTRUCTOR
    public Node(E data)
    {
        this.data = data;
    }

    //GETTER
    public E getData()
    {
        return data; //return data stored in the node
    }

    //TO STRING
    @Override
    public String toString() {
        return data.toString() + "\n";
    }
}
