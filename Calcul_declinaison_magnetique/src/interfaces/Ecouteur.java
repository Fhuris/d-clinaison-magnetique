package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import image.Rotation;


public class Ecouteur implements ActionListener {


	JOptionPane jop = new JOptionPane();
	boolean gg=false;
	File file;
	
		
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		if(event.getSource()==InterFichier.parcourir){
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("Image", "tif");
			chooser.setFileFilter(filtre);
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				jop.showMessageDialog(null, "Fichier chargé", "Information", JOptionPane.INFORMATION_MESSAGE);
				//Lecture du fichier txt et récupération des données
				gg=true;
			}
			
		}
		
		
	
		
		
		if(event.getSource()==InterFichier.valider && gg==true) {
			try {
				Rotation.exe(file.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			jop.showMessageDialog(null, "Fichier transformé.", "Travail terminé", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if(event.getSource()==InterFichier.valider && gg==false) {
			jop.showMessageDialog(null, "Chargez un fichier.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}


}

