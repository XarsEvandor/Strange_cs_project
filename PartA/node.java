public class node {
    int key;
    node next;


    public node(int key) {
        this.key = key;
        next = null;
    }

    public void display() {
        System.out.print("("+key+")-->");
    }
}