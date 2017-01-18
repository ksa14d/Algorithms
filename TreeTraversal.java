import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by karthik on 11/1/2016.
 */
public class TreeTraversal {

    private class Node<T>
    {
        T data;
        Node<T> left;
        Node<T> right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public void print()
        {
            System.out.println(data);
        }
    }


    public TreeTraversal()
    {
        Node<Integer> x = new Node<Integer>();
        x.setData(10);
        Node<Integer> x1 = new Node<Integer>();
        x1.setData(12);
        Node<Integer> x2 = new Node<Integer>();
        x2.setData(17);
        Node<Integer> x3 = new Node<Integer>();
        x3.setData(19);
        Node<Integer> x4 = new Node<Integer>();
        x4.setData(50);
        Node<Integer> x5 = new Node<Integer>();
        x5.setData(20);
        Node<Integer> x6 = new Node<Integer>();
        x6.setData(30);
        Node<Integer> x7 = new Node<Integer>();
        x7.setData(5);
        x.setLeft(x1);x.setRight(x2);
        x1.setLeft(x3);x1.setRight(x4);
        x2.setLeft(x5);x2.setRight(x6);
        x3.setLeft(x7);
        levelOrder(x);

    }

    public void inOrder(Node root) // L -> N -> R
    {
        if(root == null)return;
        inOrder(root.getLeft());
        root.print();
        inOrder(root.getRight());
    }

    public void preOrder(Node root) // N -> L -> R
    {
        if(root == null)return;
        root.print();
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void postOrder(Node root) // L -> R -> N
    {
        if(root == null)return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        root.print();
    }

    public void levelOrder(Node root) // bfs L ---> R
    {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            Node front = que.poll();
            front.print();
            if(front.getLeft() != null)que.offer(front.getLeft());
            if(front.getRight() != null)que.offer(front.getRight());
        }
    }

}
