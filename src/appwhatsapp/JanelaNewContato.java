/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appwhatsapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author leona
 */
public class JanelaNewContato extends JFrame implements ActionListener{
    private JLabel labelTel;
    private JTextField textTel;
    private JButton btnAdd;
    private String tel;

    public JanelaNewContato() {
        setLayout(null);

        labelTel = new JLabel("Telefone: ");
        labelTel.setBounds(10, 10, 60, 20);
        add(labelTel);

        try {
            MaskFormatter mk = new MaskFormatter("(##)#####-####");
            mk.setPlaceholderCharacter('_');
            mk.setValidCharacters("0123456789");
            textTel = new JFormattedTextField(mk);
            textTel.setBounds(70, 10, 100, 20);
            add(textTel);
        } catch (Exception e) {
        }

        btnAdd = new JButton("Adicionar");
        btnAdd.setBounds(45, 35, 100, 25);
        btnAdd.addActionListener(this);
        add(btnAdd);
    }

    public String getTel() {
        return tel;
    }

    private void setTel(String tel) {
        this.tel = tel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent acesso) {
        if (acesso.getSource() == btnAdd) {
            setTel(textTel.getText());
            this.dispose();
        }
    }

}
