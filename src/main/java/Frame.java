import util.JTableUtils;
import util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Frame extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JTable tableOutputJava;
    private JButton buttonResultJava;
    private JTable tableOutputMine;
    private JButton buttonResultMine;
    private JButton buttonLoadFromFile;

    private final JFileChooser fileChooserOpen;

    public Frame() {
        this.setTitle("Task3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();


        JTableUtils.initJTableForArray(tableInput, 40, true, true, false, true);
        JTableUtils.resizeJTable(tableInput, 1, 1, 30, 70);

        JTableUtils.initJTableForArray(tableOutputMine, 40, true, true, false, false);
        JTableUtils.resizeJTable(tableOutputMine, 1, 1, 30, 70);

        JTableUtils.initJTableForArray(tableOutputJava, 40, true, true, false, false);
        JTableUtils.resizeJTable(tableOutputJava, 1, 1, 30, 70);
        tableOutputJava.setEnabled(false);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        this.setVisible(true);
        this.setSize(860, 500);

        buttonLoadFromFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    String[] words = readStringArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(tableInput, words);
                }
            } catch (Exception e) {
                displayError("Ошибка в исходных данных");
            }
        });

        buttonResultMine.addActionListener(actionEvent -> {
            try {
                String[] words = JTableUtils.readStringArrayFromJTable(tableInput);
                StringComparator comparator = new StringComparator();
                SimpleLinkedListQueue2<String> queue = new SimpleLinkedListQueue2<>(comparator);

                for (String elem : words){
                    queue.add(elem);
                }

                int j = queue.count();
                String[] result = new String[j];

                for (int i = 0; i < j; i++){
                    result[i] = queue.remove();
                }

                JTableUtils.writeArrayToJTable(tableOutputMine, result);
            } catch (Exception e) {
                displayError("Ошибка в исходных данных");
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonResultJava.addActionListener(e -> {
            try {
                String[] words = JTableUtils.readStringArrayFromJTable(tableInput);
                StringComparator comparator = new StringComparator();
                PriorityQueue<String> queue = new PriorityQueue<>(comparator);

                queue.addAll(Arrays.asList(words));

                int j = queue.size();
                String[] result = new String[j];

                for (int i = 0; i < j; i++){
                    result[i] = queue.remove();
                }

                JTableUtils.writeArrayToJTable(tableOutputJava, result);
            } catch (Exception exception) {
                displayError("Ошибка в исходных данных");
            }
        });

    }

    private void displayError(String errorText) {
        JOptionPane.showMessageDialog(this, errorText,
                "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private String[] readStringArrayFromFile(String fileName) throws Exception{
        ArrayList<String> arraylist = new ArrayList<>();
        String[] words;
        String line;
        Scanner scanner = new Scanner(new File(fileName), StandardCharsets.UTF_8);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line == null) {
                break;
            } else {
                words = line.split("\\s");
                arraylist.addAll(Arrays.asList(words));
            }
        }

        String[] result = new String[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++){
            result[i] = arraylist.get(i);
        }

        return result;
    }
}

