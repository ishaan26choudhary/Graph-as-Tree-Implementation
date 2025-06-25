import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    String pos;
    ArrayList<Node> next;

    public Node(String pos) {
        this.pos = pos;
        this.next = new ArrayList<>();
    }
}

class Graph {
    static Node Start = null;

    // Add the start node
    public void AddStartPoint(String c) {
        Start = new Node(c);
    }

    // Search for a node using BFS
    public static boolean SearchNode(String v) {
        if (Start == null) {
            return false;
        }
        Queue<Node> nodelist = new LinkedList<>();
        nodelist.add(Start);

        while (!nodelist.isEmpty()) {
            Node current = nodelist.poll();
            if (current.pos.equals(v)) {
                return true;
            }
            nodelist.addAll(current.next);
        }
        return false;
    }

    // Return node with given value
    public static Node ReturnNode(String c) {
        if (Start == null) {
            return null;
        }
        Queue<Node> nodelist = new LinkedList<>();
        nodelist.add(Start);

        while (!nodelist.isEmpty()) {
            Node current = nodelist.poll();
            if (current.pos.equals(c)) {
                return current;
            }
            nodelist.addAll(current.next);
        }
        return null;
    }

    // Add edge from c1 to c2
    public void AddEdge(String c1, String c2) {
        if (SearchNode(c1)) {
            if (SearchNode(c2)) {
                Node v1 = ReturnNode(c1);
                Node v2 = ReturnNode(c2);
                boolean alreadyConnected = false;

                for (Node m : v1.next) {
                    if (m.pos.equals(v2.pos)) {
                        System.out.println(v2.pos + " is already connected to " + v1.pos + "!");
                        alreadyConnected = true;
                        break;
                    }
                }
                if (!alreadyConnected) {
                    v1.next.add(v2);
                    System.out.println(v2.pos + " is successfully added to " + v1.pos);
                }
            } else {
                Node v3 = new Node(c2);
                Node v4 = ReturnNode(c1);
                v4.next.add(v3);
                System.out.println(c2 + " is successfully created and added to " + c1);
            }
        } else {
            System.out.println(c1 + " not found!");
        }
    }

    // Display the graph using BFS
    public void Display() {
        if (Start == null) {
            System.out.println("Found empty graph!");
            return;
        }

        Queue<Node> hj = new LinkedList<>();
        hj.add(Start);

        while (!hj.isEmpty()) {
            Node j = hj.poll();
            System.out.println("Scanning position: " + j.pos);
            for (Node b : j.next) {
                System.out.println(j.pos + " -> " + b.pos);
                hj.add(b);
            }
        }
    }
}

    // Main function to test
public class graphs{
    public static void main(String[] args) {
        Graph g=new Graph();
        g.AddStartPoint("Mumbai");
        g.AddEdge("Mumbai", "Pune");
        g.AddEdge("Pune", "Nashik");
        g.AddEdge("Mumbai", "Nashik");
        g.AddEdge("Nashik", "Nagpur");
        g.Display();
    }
}

