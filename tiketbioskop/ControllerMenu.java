/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class ControllerMenu {
    
    VMainMenu MM;
    ModelBioskop MB;
    String[] film = new String[2];
    
    public ControllerMenu(VMainMenu MM, ModelBioskop MB ) {
        this.MB = MB;
        this.MM = MM;
        MM.btnFilm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                    VDaftarFilm VF =new VDaftarFilm();
                    ControllerDaftarFilm DF = new ControllerDaftarFilm (VF,MB);
                    VF.setVisible(true);
                    MM.dispose();
                   
            }
        
    });
        MM.btnMakanan.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                VDaftarMakanan DM = new VDaftarMakanan();
                ControllerDaftarMakanan CD = new ControllerDaftarMakanan(DM,MB);
                DM.setVisible(true);
                MM.dispose();
            }
        });
        MM.btnTiket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               VTiketFilm VT = new VTiketFilm();
               ControllerTiketFilm CF = new ControllerTiketFilm(VT,MB);
               VT.setVisible(true);
               MM.dispose();
            }
        });
        MM.btnTiketMakanan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               VTiketMakanan VM = new VTiketMakanan();
               ControllerTiketMakanan TM = new ControllerTiketMakanan(VM,MB);
               VM.setVisible(true);
               MM.dispose();
            }
        });
    }
}

  
