package algorithm;

/**
 * @author : dingwenqiang
 * @date : 2019/10/25 14:06
 */
public class LinkedListReverseDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.listAll();

    }

    private void reverse(Node root) {

        //  a -> b -> c
        // prev curr cu.next
        //       a -> b -> c
        //
        //  a <- b <- c

        Node prev = null;
        Node curr = root;
        Node next = curr.next;
        while (curr != null) {
            prev = curr;
            curr = next;
            next = next.next;
            curr.next = prev;
        }
    }

    private static class LinkedList{
        private Node head;
        private Integer count;
        private Integer size;
        private Node curr;
        public LinkedList(Integer size) {
            head = new Node(null);
            curr = head;
            this.size = size;
        }
        public void add(Integer i ){
            Node node = new Node(i);
            node.next = null;
            curr.next = node;

        }
        public Node remove(int i) {
            return null;
        }

        public void listAll(){
            Node tem = head;
            while (tem.next != null) {
                System.out.print(tem.data + ",");
            }
        }
        //todo ...
    }

    private static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

}
