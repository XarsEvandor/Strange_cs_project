public class LinkList2
{
    // instance variables 
    node first;

    public LinkList2()
    {
        // initialise instance variables
        first = null;
    }

    public boolean isEmpty()
    {
        // put your code here
        return ( first == null );
    }
    
    public void insertFirst(int key)
    {
        // STEP 1: Create a new node with the given key
        node newNode = new node(key);
        // STEP 2: Make the arrow of the new node (next) point 
        //         to the previous 'first'
        newNode.next = first;
        // STEP 3: Make the new node to be the new 'first' node of the List
        first = newNode;
    }
    
    public void delete(int key)
    {
        int countDelete = 0;

        if (first.key == key) {
            deleteFirst();
        } else {
            // STEP 1: Find the node that is the 'previous' of the one to be deleted
            node temp = first;

            while (!(countDelete > 0 && temp.key == first.key)) {
                if (temp.next.key == key) // Checking if the key of the next node is the required one
                {

                    // Move the 'next' variable to point to the node that is after the one to be deleted
                    temp.next = temp.next.next; // Moving the 'arrow' of temp to the 'next' node of the one to be deleted!
                } else {
                    temp = temp.next;
                }

                countDelete++;
            }
        }
    }
    
    //This method makes the arrow of the 'last' node in the list to point towards the 'first' node in the list.
    public void linkCircle() {
        node temp = first;
        while (true) {
            if (temp.next == null) {
                temp.next = first;
                break;
            }
            else {
                temp = temp.next;
            }
        }
    }
    
    public void deleteFirst()
    {
        node temp = first;

        while (true) {
            if (temp.next.key == first.key) // Checking if the key of the next node is the required one
            {
                // Move the 'next' variable to point to the node that is after the one to be deleted
                temp.next = temp.next.next; // Moving the 'arrow' of temp to the 'next' node of the one to be deleted!
                break;
            } else {
                temp = temp.next;
            }
        }

        first = first.next;
       
    }
}
