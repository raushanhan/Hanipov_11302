package hw26_05_2024Number4.task28_29;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private String textContent;
    private List<Node> next = new ArrayList<>();
    private Node parent;

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Node add(Node node) {
        next.add(node);
        return node;
    }

    public Node getParent() {
        return parent;
    }

    public String toString() {
        return name + " " + textContent;
    }

    public List<Node> getNext() {
        return next;
    }

    public String getTextContent() {
        return textContent;
    }
}
