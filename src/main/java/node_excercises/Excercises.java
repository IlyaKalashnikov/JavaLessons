package node_excercises;

public class Excercises {
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
        Excercises.removeFromTail(head, 5);
        printAllNodes(head);
    }

    public static void removeFromTail(Node head, int elementFromTail) {
        Node starter = head;
        int countNodes = 0;
        while (starter != null) {
            starter = starter.node;
            countNodes++;
        }
        int elementToDelete = countNodes - elementFromTail;
        if (elementFromTail == countNodes) {
            head.val = head.node.val;
            head.setNode(head.node.node);
            head.node.setNode(null);
            return;
        }
        while (--elementToDelete != 0) {
            head = head.node;
        }
        head.setNode(head.node.node);
    }

    public static void reverseNodes(Node head) {
        while (head.node.node != null) {
            Node iterator = head;
            while (iterator.node.node != null) {
                iterator = iterator.node;
            }
            iterator.node.setNode(iterator);
            iterator.setNode(null);
        }
        head.node.setNode(head);
        head.setNode(null);
    }


    public static void printAllNodes(Node head) {
        while (head != null) {
            System.out.print(head.val);
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