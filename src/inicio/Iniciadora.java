package inicio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import visual.Autenticar;
import auxiliar.Poblar;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;



public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
                    Poblar.iniciar();
                    UIManager.setLookAndFeel(new McWinLookAndFeel());
					Autenticar dialog = new Autenticar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
					//e.printStackTrace();
				}
			}
		});

	}

}
