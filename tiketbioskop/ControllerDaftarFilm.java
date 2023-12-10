/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ControllerDaftarFilm {
    VDaftarFilm VD;
    ModelBioskop MB;
    public ControllerDaftarFilm( VDaftarFilm VD, ModelBioskop MB) {
        this.VD = VD;
        this.MB = MB;
        ShowDataFilm();
        VD.btnMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VMainMenu MM =new VMainMenu();
                ControllerMenu CM = new ControllerMenu (MM,MB);
                MM.setVisible(true);
                VD.dispose();
            } 
        });
        VD.btnTiket.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
               VTiketFilm VT =new VTiketFilm();
               ControllerTiketFilm CF = new ControllerTiketFilm (VT,MB);
               VT.setVisible(true);
               VD.dispose();
            }
        });
        
    }
    void ShowDataFilm(){
        String[][] datatabel=MB.readDataFilm();
        String[] namakolom={"id film","Nama film","genre","usia"};
        VD.tabelFilm.setModel((new JTable(datatabel,namakolom)).getModel());
    }
}
