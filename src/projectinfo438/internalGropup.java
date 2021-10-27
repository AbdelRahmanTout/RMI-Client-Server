package projectinfo438;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class internalGropup extends JInternalFrame{
    private JLabel name = new JLabel("Name of group");
    private JTextField fld = new JTextField(20);
    public internalGropup(){
        initComponentes();
    }

    private void initComponentes() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        setLayout(new FlowLayout());
        this.add(name);
        this.add(fld);
        this.pack();
    }
}