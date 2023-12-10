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
/**
 *
 * @author ACER
 */
public class ControllerTiketFilm {
    
    VTiketFilm VT = new VTiketFilm();
    ModelBioskop MB = new ModelBioskop();
    String studio;
    String[][] datafilm;
    String selectedFilm;
    String tanggal;
    String waktu;
    int harga;
    public ControllerTiketFilm(VTiketFilm VT, ModelBioskop MB) {
        this.VT=VT;
        this.MB=MB;
        ShowFilm();
        VT.lharga.setText("0");
        VT.SR.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED ){
                    studio="Reguler";
                }
            } 
        });
        VT.SP.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED ){
                    studio="Premiere";
                }
            } 
        });
        VT.SD.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED ){
                    studio="Dolby Atmos";
                }
            } 
        });
        VT.SI.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED ){
                    studio="Imax";
                }
            } 
        });
        VT.cbfilm.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectedFilm=(String) VT.cbfilm.getSelectedItem();
            }
            
        });
        VT.cbtanggal.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                tanggal=(String) VT.cbtanggal.getSelectedItem();
            }
        });
        VT.cbwaktu.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                waktu=(String) VT.cbwaktu.getSelectedItem();
            }
        });
        VT.sjumlah.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                int jumlah=(int) VT.sjumlah.getValue();
                harga=jumlah*35000;
                VT.lharga.setText(Integer.toString(harga));
            }
            
        });
        VT.btnBayar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MB.InputTiket(studio,tanggal,selectedFilm, waktu, harga);
            }
            
        });
         VT.btnMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VMainMenu MM =new VMainMenu();
                ControllerMenu CM = new ControllerMenu (MM,MB);
                MM.setVisible(true);
                VT.dispose();
            } 
        });
         
        VT.btnCetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VTransaksiFilm TF =new VTransaksiFilm();
                ControllerTransaksi CT = new ControllerTransaksi (TF,MB);
                TF.setVisible(true);
                VT.dispose();
            }
        });
    }
    void ShowFilm(){
        datafilm=MB.readDataFilm();
        String[] film=new String[MB.jumlahFilm()];
        for(int i=0;i<MB.jumlahFilm();i++){
            film[i]=datafilm[i][1];
        }
        VT.cbfilm.setModel(new DefaultComboBoxModel(film));
        VT.cbfilm.setSelectedIndex(-1);
    }
}
   