/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

/**
 *
 * @author M.zubair
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class board extends JFrame
{
    private JTextField txt;
    private PopUpKeyboard keyboard;

    public board()
    {
        super("pop-up keyboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txt = new JTextField(20);
        keyboard = new PopUpKeyboard(txt);

        txt.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Point p = txt.getLocationOnScreen();
                p.y += 30;
                keyboard.setLocation(p);
                keyboard.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(txt);

        pack();
        setLocationByPlatform(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                board().setVisible(true);
            }
        });
    }

    private class PopUpKeyboard extends JDialog implements ActionListener
    {
        private JTextField txt;

        public PopUpKeyboard(JTextField txt)
        {
            this.txt = txt;
            setLayout(new GridLayout(4, 13));
            createButton("~");
            createButton("1");
            createButton("2");
            createButton("3");
            createButton("4");
            createButton("5");
            createButton("6");
            createButton("7");
            createButton("8");
            createButton("9");
            createButton("10");
            createButton("-");
            createButton("+");
            createButton("Q");
            createButton("W");
            createButton("E");
            createButton("R");
            createButton("T");
            createButton("Y");
            createButton("U");
            createButton("I");
            createButton("O");
            createButton("P");
            createButton("{");
            createButton("}");
            createButton("'\'");
            createButton("A");
            createButton("S");createButton("D");createButton("F");createButton("G");createButton("H");createButton("J");
            createButton("K");createButton("L");createButton("';'");createButton("'");createButton("Z");createButton("X");
            createButton("C");createButton("V");createButton("B");createButton("N");createButton("M");createButton(",");
            createButton(".");createButton("'/'");createButton(" ");
            
            pack();
        }
        public String b(String text){
            
            return text.substring(0,text.length()-1);
        }
        

   

        private void createButton(String label)
        {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(100, 100));
            Font font = btn.getFont();
            float size = font.getSize() + 15.0f;
            btn.setFont(font.deriveFont(size));
            add(btn);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            txt.setText(txt.getText() + actionCommand);
        }
    }
}
