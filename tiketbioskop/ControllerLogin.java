/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ControllerLogin {

    VLogin VL;
    ModelBioskop MB;
    
    public ControllerLogin(VLogin VL,ModelBioskop MB) {
        this.VL=VL;
        this.MB=MB;
        VL.BtnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MB.login(VL.getUsername(), VL.getPassword())){
                    VMainMenu VM=new VMainMenu();
                    ControllerMenu CM=new ControllerMenu(VM,MB);
                    VM.setVisible(true);
                    VL.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username/password salah!");
                }
            }
            
        });
    
     }
}
