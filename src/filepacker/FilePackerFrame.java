package filepacker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FilePackerFrame extends JFrame
{
    JButton PackButton;
    JButton UnpackButton;

    FilePackerFrame()
    {
        setTitle("Java File Packer");
        setSize(500, 300);
        setLayout(new FlowLayout());

        PackButton = new JButton("Pack Files");
        UnpackButton = new JButton("Unpack Files");

        add(PackButton);
        add(UnpackButton);

        PackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Use Packer.java to pack files."
                );
            }
        });

        UnpackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Use Unpacker.java to unpack files."
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}