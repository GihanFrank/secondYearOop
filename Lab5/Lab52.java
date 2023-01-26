import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyNotePad extends JFrame {
    public MyNotePad() {
        super("My Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 400);
        BuildGui();
        setVisible(true);
        pack();
    }

    public void BuildGui() {
        JMenuBar mb1 = new JMenuBar();
        setJMenuBar(mb1);

        JMenu m1 = new JMenu("File");
        mb1.add(m1);

        JMenuItem ji5 = new JMenuItem("New");
        m1.add(ji5);
        JMenu m2 = new JMenu("Help");
        mb1.add(m2);

        JMenu m3 = new JMenu("Open");
        m1.add(m3);

        JMenuItem ji1 = new JMenuItem("Search on PC");
        m3.add(ji1);

        JMenu ji2 = new JMenu("Save");
        m1.add(ji2);

        JMenuItem ji6 = new JMenuItem("Save as a text file");
        ji2.add(ji6);

        m1.addSeparator();
        JMenuItem ji3 = new JMenuItem("Exit");
        m1.add(ji3);

        JMenuItem ji4 = new JMenuItem("About");
        m2.add(ji4);

        Container c1 = getContentPane();
        JTextArea ta1 = new JTextArea(20, 30);
        c1.add(ta1, BorderLayout.CENTER);

        /* Action listeners and objects */

        Exit ex = new Exit();
        ji3.addActionListener(ex);

        NewDoc newD = new NewDoc(ta1);
        ji5.addActionListener(newD);

        OpenFile opf = new OpenFile(ta1);
        ji1.addActionListener(opf);

        SaveFile sf = new SaveFile(ta1);
        ji6.addActionListener(sf);
    }
}

class Exit implements ActionListener {

    public void actionPerformed(ActionEvent a) {
        System.exit(0);
    }
}

class NewDoc implements ActionListener {
    private JTextArea a;

    public NewDoc(JTextArea a) {
        this.a = a;
    }

    public void actionPerformed(ActionEvent e) {
        a.setText(null);
    }
}

class OpenFile implements ActionListener {
    private JTextArea ta;
    File file;
    FileReader fr;
    String data;
    JFileChooser jf;
    int userSelect;

    public OpenFile(JTextArea ta) {
        this.ta = ta;
    }

    public void actionPerformed(ActionEvent e) {
        jf = new JFileChooser();
        userSelect = jf.showOpenDialog(null);

        if (userSelect == jf.APPROVE_OPTION) {

            try {
                file = jf.getSelectedFile();
                fr = new FileReader(file);
                char[] store = new char[(int) file.length()];
                fr.read(store);
                fr.close();
                data = new String(store);
                ta.setText(data);

            } catch (IOException e1) {
                ta.setText("Error.. Invalid Format");
                ;
            }
        }
    }
}

class SaveFile implements ActionListener {
    JTextArea a;

    public SaveFile(JTextArea a) {
        this.a = a;
    }

    public void actionPerformed(ActionEvent k) {
        String textArea = new String(a.getText());
        JFileChooser jf = new JFileChooser();
        int userInput = jf.showSaveDialog(null);
        if (userInput == jf.APPROVE_OPTION) {
            try {
                    File file = jf.getSelectedFile();
                    FileWriter fr = new FileWriter(file);
                    fr.write(textArea);
                    fr.close();

            } catch (IOException e1) {

            }
        }
    }
}

public class Lab52 {
    public static void main(String[] args) {
        MyNotePad mynp = new MyNotePad();
    }
}
