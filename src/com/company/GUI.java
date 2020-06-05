package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayDeque;


public class GUI extends JFrame {
    private JButton resultButton;
    private JPanel panel1;
    private JTextField resultText;
    private JButton createButton;
    private JTextField createText;
    private JCheckBox checkBox;
    private JTextField textList;
    private LinkedListStack<String> linkedListStack = new LinkedListStack<>();
    private ArrayDeque<String> strings = new ArrayDeque<>();
    private int operation = 0;

    public GUI() {
        textList.setEditable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operation) {
                    case 0: {
                        linkedListStack.push(createText.getText());
                        break;
                    }
                    case 1: {
                        strings.add(createText.getText());
                        strings.add(createText.getText());
                        break;
                    }
                }
                createText.setText("");
                textList.setText(linkedListStack.toString());
            }
        });
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operation) {
                    case 0: {
                        linkedListStack.duplicationStack();
                        resultText.setText(linkedListStack.toString());
                        break;
                    }
                    case 1: {
                        resultText.setText(strings.toString());
                    }
                }
            }
        });
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                operation = 1;
            }
        });
    }

}
