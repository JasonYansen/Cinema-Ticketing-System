/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class ModelBioskop {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bioskop";
    static final String USER = "root";
    static final String PASS = ""; 
    public Connection koneksi;
    public Statement statement;
    
    public ModelBioskop() {
         try{
            Class.forName(JDBC_DRIVER);
            koneksi = (java.sql.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public boolean login(String username, String password){
        try{
            System.out.println(username);
            System.out.println(password);
            String Query = "SELECT COUNT(*) as total FROM admin WHERE username = '"+ username + "' AND password= BINARY '"+ password +"'";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                if(ada.getString("total").equals("1"))
                {
                    System.out.println("tes");
                    return true;
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
        return false;
    }
    public String[][] readDataFilm(){
        String[][] film=new String[jumlahFilm()][4];
        try{
            int jumlah=0;
            String Query = "SELECT * from data_film";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                film[jumlah][0]=ada.getString("id_film");
                film[jumlah][1]=ada.getString("nama_film");
                film[jumlah][2]=ada.getString("genre");
                film[jumlah][3]=ada.getString("usia");
                jumlah++;
            }
        }catch(Exception e){
            e.getMessage();
        }
        return film;
    }
    public int jumlahFilm(){
        int jumlah=0;
        try{
            String Query = "SELECT * from data_film";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                jumlah++;
            }
        }catch(Exception e){
            e.getMessage();
        }
        return jumlah;
    }
    public String[][] readDataMakanan(){
        String[][] film=new String[jumlahMakanan()][3];
        try{
            int jumlah=0;
            String Query = "SELECT * from data_makanan";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                film[jumlah][0]=ada.getString("id_makanan");
                film[jumlah][1]=ada.getString("nama_paket");
                film[jumlah][2]=ada.getString("harga");
                jumlah++;
            }
        }catch(Exception e){
            e.getMessage();
        }
        return film;
    }
    public int jumlahMakanan(){
        int jumlah=0;
        try{
            String Query = "SELECT * from data_makanan";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                jumlah++;
            }
        }catch(Exception e){
            e.getMessage();
        }
        return jumlah;
    }
    public void InputTiket(String studio,String tanggal,String judul, String mulai, int harga){
        try{
            String Query ="INSERT INTO data_pemesan_tiket (`id_pemesanan`,`nama_studio`,`tanggal`,`judul_film`,`jam_mulai`,`harga`) VALUES (NULL,'"+studio+"','"+tanggal+"','"+judul+"','"+mulai+"','"+harga+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Pembelian berhasil!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Void InputTiketMakanan(String makanan, int jumlah, int harga) {
        try{
            String Query = "INSERT INTO data_pemesan_makanan (`id_pemesanan`,`nama_makanan`,`jumlah`,`harga`) VALUES (NULL,'"+makanan+"','"+jumlah+"','"+harga+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Pembelian berhasil!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public int totalDataTransaksiFilm(){
        int jumlah = 0;
        try{
            String Query = "SELECT * FROM data_pemesan_tiket";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                jumlah++;
            }
            return jumlah;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }
    
    public String[][] readDataTransaksiFilm(){
        String data[][] = new String[totalDataTransaksiFilm()][6];
        int index = 0;
        try{
            String Query = "SELECT * FROM data_pemesan_tiket ";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                data[index][0] = ada.getString("id_pemesanan");
                data[index][1] = ada.getString("nama_studio");
                data[index][2] = ada.getString("tanggal");
                data[index][3] = ada.getString("judul_film");
                data[index][4] = ada.getString("jam_mulai");
                data[index][5] = ada.getString("harga");
                index++;
            }
            return data;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return data;
    }
    
    public int totalDataTransaksiMakanan(){
        int jumlah = 0;
        try{
            String Query = "SELECT * FROM data_pemesan_makanan";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                jumlah++;
            }
            return jumlah;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }
    
    public String[][] readDataTransaksiMakanan(){
        String data[][] = new String[totalDataTransaksiMakanan()][4];
        int index = 0;
        try{
            String Query = "SELECT * FROM data_pemesan_makanan ";
            statement = koneksi.createStatement();
            ResultSet ada=statement.executeQuery(Query);
            while(ada.next()){
                data[index][0] = ada.getString("id_pemesanan");
                data[index][1] = ada.getString("nama_makanan");
                data[index][2] = ada.getString("jumlah");
                data[index][3] = ada.getString("harga");
                index++;
            }
            return data;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return data;
    }
}
    

