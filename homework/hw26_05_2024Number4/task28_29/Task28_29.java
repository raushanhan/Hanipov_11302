package hw26_05_2024Number4.task28_29;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.text.html.HTML;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task28_29 {

    public static void main(String[] args) {

        String inputPath = "D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java\\hw26_05_2024Number4\\task28_29" +
                "\\html.txt";
        String outputPath = "D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java\\hw26_05_2024Number4\\task28_29" +
                "\\extractedText.txt";
        Node HTMLTree = parseHTML(inputPath);

        extractContents(outputPath, HTMLTree);
    }

    public static Node parseHTML(String inputPath) {
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(Files.newInputStream(Paths.get(inputPath))))) {
            String line;
            Node currNode = new Node("The head", null);
            while ((line = reader.readLine()) != null) {

                int state = 0;
                String nodeName = "";
                String nodeText = "";

                for (int i = 0; i < line.length(); i++) {
                    char currChar = line.charAt(i);

                    if (state == 0) { // outside the tag
                        if (currChar == '<') {
                            state = 1;
                        } else { // the case, when the symbol is a letter. otherwise the html file is invalid,
                            // but I didn't take it into account
                            state = 5;
                            nodeText = Character.toString(currChar);
                        }

                    } else if (state == 1) { // inside a tag
                        if (currChar == '/') { // tag is the finishing tag
                            state = 4;
                        } else if (currChar == '!') { // tag is a commentary tag
                            state = 6;
                        } else if (isGoodName(currChar)) { // tag is an opening tag
                            state = 2;
                            nodeName = Character.toString(currChar);
                        }

                    } else if (state == 2) { // tag <...>
                        if (currChar == '>') { // get out of the tag and create a new Node
                            state = 0;
                            currNode = currNode.add(new Node(nodeName, currNode));
                            nodeName = "";
                        } else if (currChar == ' ') { // found a space, stop reading the name
                            state = 3;
                        } else if (isGoodName(currChar)) { // reading the tag's name
                            nodeName = nodeName + currChar;
                        }

                    } else if (state == 3) { // <...> tags name is read, now read what's left
                        if (currChar == '>') { // get out of the tag
                            if (!(nodeName.equals("meta") || nodeName.equals("link") || nodeName.equals("img"))) {
                                currNode = currNode.add(new Node(nodeName, currNode));
                                nodeName = "";
                            }
                            state = 0;
                        }

                    } else if (state == 4) { // tag </...>
                        if (currChar == '>') { // get out of the tag and get out of the current Node
                            state = 0;
                            currNode = currNode.getParent();
                        }

                    } else if (state == 5) { // are outside any tags and now reading the text to print
                        if (currChar == '<') { // a new tag is open so reading the text is stopped
                            state = 1;
                            currNode.setTextContent(nodeText);
                            nodeText = "";
                        } else {
                            nodeText = nodeText + currChar;
                        }

                    } else if (state == 6) { // tag <!...>
                        if (currChar == '-') {
                            state = 7;
                        } else if (currChar == '>') {
                            state = 0;
                        }

                    } else if (7 <= state && state <= 8) { // tag <!--...--> opened
                        if (currChar == '-') {
                            state++;
                        }
                    } else if (state == 9) { // tag <!--...--> finished
                        if (currChar == '-') {
                            state = 6;
                        }
                    }
                }
            }
            return currNode;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isGoodName(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ||
                (ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я') ||
                (ch == 'ё' || ch == 'Ё') ||
                ('0' <= ch && ch <= '9') || ch == '-' || ch == '_';
    }

    public static void extractContents(String outputPath, Node head) {
        try (BufferedWriter writer = new BufferedWriter
                (new OutputStreamWriter(Files.newOutputStream(Paths.get(outputPath)))))
        {
            String indent = "";
            Node currentNode = head.getNext().get(0); // took the 'html' node
            enterTheContents(currentNode, "", writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void enterTheContents(Node htmlTree, String indent, BufferedWriter writer) {
        try {
            String nodesTextContent =  htmlTree.getTextContent();
            if (nodesTextContent != null) {
                writer.write(indent + nodesTextContent + "\n");
            }
            if (htmlTree.getNext() != null) {
                for (Node elem : htmlTree.getNext()) {
                    enterTheContents(elem, indent + " ", writer);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
