/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
public class ControllerTiketMakanan {
    VTiketMakanan VM;
    ModelBioskop MB;
    String makanan;
    int jumlah;
    String[][] dataMakanan;
    int harga;
    int idxmakanan;
    public ControllerTiketMakanan(VTiketMakanan VM,ModelBioskop MB) {
        this.VM=VM;
        this.MB=MB;
        ShowMakanan();
        VM.cbmakanan.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                idxmakanan=VM.cbmakanan.getSelectedIndex();
            }
            
        });
        VM.sjumlah.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                updateMakanan();
            }
            
        });
        VM.btnbayar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                makanan=dataMakanan[idxmakanan][1];
                MB.InputTiketMakanan(makanan, jumlah, harga);
            }
            
        });
        VM.btnmenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VMainMenu MM =new VMainMenu();
                ControllerMenu CM = new ControllerMenu (MM,MB);
                MM.setVisible(true);
                VM.dispose();
            }
        });
        VM.btnCetak.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VTransaksiMakanan TM =new VTransaksiMakanan();
                ControllerTransaksiMakanan CM = new ControllerTransaksiMakanan (TM,MB);
                TM.setVisible(true);
                VM.dispose();
            }
        });
    }
    void updateMakanan(){
        jumlah=(int) VM.sjumlah.getValue();
        harga=jumlah*Integer.parseInt(dataMakanan[idxmakanan][2]);
        VM.lharga.setText(Integer.toString(harga));
    }
    void ShowMakanan(){
        dataMakanan=MB.readDataMakanan();
        String[] makanan=new String[MB.jumlahMakanan()];
        for(int i=0;i<MB.jumlahMakanan();i++){
            makanan[i]=dataMakanan[i][1];
        }
        VM.cbmakanan.setModel(new DefaultComboBoxModel(makanan));
        VM.cbmakanan.setSelectedIndex(-1);
    }
    
}
