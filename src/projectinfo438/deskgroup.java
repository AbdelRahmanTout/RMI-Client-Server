package projectinfo438;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class deskgroup extends JFrame{
    JButton btn = new JButton("create group");
    JPanel panel = new JPanel();
    JDesktopPane pane = new JDesktopPane();
    internalGropup itrn = new internalGropup();

    public deskgroup(){
        initAction();
        initComponents();
    }

    private void initAction() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupPerformed(e);
            }
        });
    }

    private void groupPerformed(ActionEvent e) {
        itrn.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        panel.add(btn);
        this.add(panel,"West");
        pane.setBackground(Color.cyan);
        pane.add(itrn);
        this.add(pane,"Center");
    }

    public static void main(String[] args) {
        new deskgroup().setVisible(true);
    }
}