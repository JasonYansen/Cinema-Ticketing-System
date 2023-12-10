/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ControllerTransaksiMakanan {
    VTransaksiMakanan VT = new VTransaksiMakanan();
    ModelBioskop MB = new ModelBioskop();
    public ControllerTransaksiMakanan(VTransaksiMakanan VT,ModelBioskop MB) {
        this.VT=VT;
        this.MB=MB;
        String data[][] = MB.readDataTransaksiMakanan();
        VT.TMakan.setModel(new DefaultTableModel(data, new String[]{
            "id_pemesanan","nama_makanan","jumlah","harga"
        }));
    }
}
