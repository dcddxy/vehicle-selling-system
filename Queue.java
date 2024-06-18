import java.util.LinkedList;

public class Queue extends LinkList
{
    private Node front;
    private Node rear;
    public Queue()
    {
    }
    
    public void enqueue(Object data)
    {
        insertAtBack(data);
    }
    
    public Object dequeue()
    {
        return removeFromFront();
    }
    
    public Object getFront()
    {
        return getFirst();
    }
    
    public Object getEnd()
    {
        return removeFromBack();
    }
    
    public int size()
    {
        return countNodes();
    }
}