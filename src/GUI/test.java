/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class test {
    public static void main(String[] args) throws MalformedURLException {
//        C:\Users\ASUS\Projects\HotelManagementProject
        File file = new File("src/main/java/images/logo.png");
        if (file.exists()) {
            URL location = file.toURI().toURL();
            ImageIcon icon = new ImageIcon(location);
            System.out.println("test.main()");
                    
        } else {
            System.err.println("File not found: " + file.getAbsolutePath());
        }
    }
}
