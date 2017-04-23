public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    private int size;

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
       IntNode node = this.first;
       while(node.next != null) {
           node = node.next;
       }
       node.next = new IntNode(x, null);
       size += 1;
    }

    private static int size(IntNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + size(node.next);
    }
    /** Returns the number of items in the list using recursion. */
    public int size() {
        return this.size;
    }

    public static void main(String args[]) {
        SLList ls = new SLList(20);
        ls.addLast(10);
        ls.addLast(0);
        System.out.println(ls.size());
    }

}
