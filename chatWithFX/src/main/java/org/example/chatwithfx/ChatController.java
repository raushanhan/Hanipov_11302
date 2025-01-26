package org.example.chatwithfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

/* chat controller это на самом деле client, кодом я вдохновился
     у Кости, но сделал некоторые изменения так, как чувствовал. */
public class ChatController implements Initializable, Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private String name;

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;

    /* метод initialize - то же самое, что и main у Клиента,
    разве что это не клиент, а контроллер, и отдельно его запускать не надо
    (я не понимаю, как и когда запускается контроллер, но он это делает сам) */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Socket socket = new Socket("localhost", 1234);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connected");

            askForNameAction();
            if (name == null) {
                Platform.exit();
                return;
            }

            out.println(name);
            new Thread(this).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void sendButtonAction() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            out.println(message);
            messageField.clear();
        }
    }

    private void askForNameAction() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Entering a chat");
        dialog.setHeaderText("Input name");
        name = dialog.showAndWait().orElse(null);
    }

    @Override
    public void run() {
        try {
            String message;

            System.out.println(in);

            while ((message = in.readLine()) != null) {
                chatArea.appendText(message + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
