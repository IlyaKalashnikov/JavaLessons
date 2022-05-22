package learning_collections;

public class test {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        Node last = new Node(5);
        head.setNode(second);
        second.setNode(third);
        third.setNode(forth);
        forth.setNode(last);
        test.print(head);
        System.out.println();
        test.printReverse(head);
        System.out.println();
        test.remove(head, 1);
        test.print(head);

    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.node;
        }
    }

    public static void printReverse(Node head) {
        if (head.node == null) {
            System.out.print(head.val);
            return;
        }
        printReverse(head.node);
        System.out.print(head.val);
    }

    public static void remove(Node head, int index) {
        while (head != null) {
            index--;
            if (index-1 == 0) {
                if (head.node.node == null) {
                    head.setNode(null);
                    return;
                }
                head.setNode(head.node.node);
                return;
            }
            head = head.node;
        }
    }
}

class Node {
    Node node;
    Integer val;

    public Node(Integer val) {
        this.val = val;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}