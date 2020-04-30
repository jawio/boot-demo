package cn.atofinon.cloud.freshman.lrudemo;

import java.util.LinkedList;

/**
 * @Author yangjw@tuya.com
 * @Date 2020/3/28 10:56 AM
 * @Descrition
 */


public class LruDemo {


    static class Node {
        private Object data;
//        private Node pre;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    private static class DoubleLinkedList {
        private Node head = new Node(null);
        private Integer size;

        private Boolean add(Node o, int index) {
            addBefore(o, getNode(index));
            return true;
        }


        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        private void addBefore(Node newNode, Node node) {
//            newNode.pre = node.pre;
            newNode.next = node;
//            newNode.next.pre = newNode;
//            newNode.pre.next = newNode;
            size++;
        }

        private Boolean removeFirst() {
            removeNode(head.next);
            return true;
        }

        private void removeNode(Node node) {
//            node.pre.next = node.next;
//            node.next.pre = node.pre;
//            node.pre = null;
            node.next = null;
            size--;
        }


    }


    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        for (int i = 0; i < 10; i++) {
            if (i < 9) {
                Node node = new Node(i);
                list.add(node, i);
            } else {
                list.removeFirst();
                Node node = new Node(i);
                list.add(node, i);
            }
        }
        System.out.println(list.toString());

    }


}
