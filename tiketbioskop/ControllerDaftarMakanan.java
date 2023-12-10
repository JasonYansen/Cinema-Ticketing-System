/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ControllerDaftarMakanan {
    VDaftarMakanan DM;
    ModelBioskop MB;
    public ControllerDaftarMakanan(VDaftarMakanan DM, ModelBioskop MB) {
        this.DM=DM;
        this.MB=MB;
        ShowDataMakanan();
        DM.btnMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VMainMenu MM =new VMainMenu();
                ControllerMenu CM = new ControllerMenu (MM,MB);
                MM.setVisible(true);
                DM.dispose();
            } 
        });
        DM.btnTiket.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
               VTiketMakanan VM =new VTiketMakanan();
               ControllerTiketMakanan CM = new ControllerTiketMakanan (VM,MB);
               VM.setVisible(true);
               DM.dispose();
            }
        });
    }
    void ShowDataMakanan(){
        String[][] datatabel=MB.readDataMakanan();
        String[] namakolom={"ID Makanan","Nama Makanan","Harga"};
        DM.tabelMakanan.setModel((new JTable(datatabel,namakolom)).getModel());
    }
}
