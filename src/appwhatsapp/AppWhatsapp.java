package appwhatsapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AppWhatsapp implements Serializable{

    public static void main(String[] args) {
        // TODO code application logic here
        /*LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM" + "-" + "HH:mm");
        String dataEHora = now.format(formatter);
        System.out.println(dataEHora);*/
        JFrameWhatsapp wpp = null;
        File f = new File("Whats.txt");
        if(f.exists()){
            abrir(f, wpp);
        }else{
            wpp  = new JFrameWhatsapp();
        }
        wpp.setIconImage(new ImageIcon("wpp.png").getImage());
        wpp.setLocationRelativeTo(null);
        wpp.setVisible(true);

    }

    public String dataEHora() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM" + "-" + "HH:mm");
        String dataEHora = now.format(formatter);
        return (dataEHora);
    }
    
    public void salvar(JFrameWhatsapp wpp) {
        String fileName = "Whats.txt";
        try(FileOutputStream fout = new FileOutputStream(fileName);
                ObjectOutputStream oout = new ObjectOutputStream(fout)){
            oout.writeObject(wpp);
            //oout.writeObject(wpp.w);
        }catch(Exception e){}
    }

    static public void abrir(File f, JFrameWhatsapp wpp) {
        
        try(FileInputStream fin = new FileInputStream(f);
                ObjectInputStream oin = new ObjectInputStream(fin)){
            wpp = (JFrameWhatsapp) oin.readObject();
            //wpp.w = (Whatsapp) oin.readObject();
        }catch(Exception e){}
        
        
    }

}
