/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        VLogin VL=new VLogin();
        ModelBioskop MB=new ModelBioskop();
        ControllerLogin CL=new ControllerLogin(VL,MB);
        VL.setVisible(true);
    }
}
