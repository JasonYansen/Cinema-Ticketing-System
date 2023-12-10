/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ControllerTransaksi {
    VTransaksiFilm VB = new VTransaksiFilm();
    ModelBioskop MB = new ModelBioskop();
    public ControllerTransaksi(VTransaksiFilm VB,ModelBioskop MB) {
        this.VB=VB;
        this.MB=MB;
        String data[][] = MB.readDataTransaksiFilm();
        VB.TFilm.setModel(new DefaultTableModel(data, new String[]{
            "id_pemesanan","nama_studio","tanggal","judul_film","jam_mulai","harga"
        }));
    }
    
}
