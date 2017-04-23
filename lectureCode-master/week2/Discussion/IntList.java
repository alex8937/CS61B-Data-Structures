public class IntList {
    public int val;
    public IntList next;
    public IntList(int val, IntList next) {
        this.val = val;
        this.next = next;
    }
    /** Destructively squares each element of the given IntList L.
     * Don’t use ’new’; modify the original IntList.
     * Should be written iteratively. */
    public static IntList SquareDestructive(IntList L) {
        IntList node = L;
        while(node != null) {
            node.val *= node.val;
            node = node.next;
        }
        return L;
    }
    /** Non-destructively squares each element of the given IntList L.
     * Don’t modify the given IntList.
     * Should be written recursively*/
    public static IntList SquareNonDestructive(IntList L) {
        if(L == null) {
            return null;
        }
        L.val *= L.val;
        L.next = SquareNonDestructive(L.next);
        return L;
    }

    public static void print(IntList L) {
        if(L == null) {
            return;
        }
        else if(L.next == null) {
            System.out.println(Integer.toString(L.val));
            return;
        }
        System.out.print(Integer.toString(L.val) + " -> ");
        print(L.next);
        return;

    }

    public static void main(String args[]) {
        IntList ls = new IntList(2, new IntList(3, new IntList(4, null)));
        print(ls);
        ls = SquareDestructive(ls);
        print(ls);
        ls = SquareNonDestructive(ls);
        print(ls);
    }
}