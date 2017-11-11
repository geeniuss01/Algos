package utils;

public class Node {
    public int num;
    public Node left, right;
    public int level;
    public int hd;

    public Node(int n) {
        this.num = n;
    }

    public void connect(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}



