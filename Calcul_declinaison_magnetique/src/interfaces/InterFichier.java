package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * 
 * Classe d'interface utilisée par l'utilisateur pour guider la Transformation par Fichier
 * Elle est composée de 5 Boutons (Sélectionner un fichier, Entrer une matrice à la main, Choisir une matrice de la BDD, Transformer, Sauvegarder le fichier de points)
 * 
 * 
 * 
 * @author Fanny Pagnier, Julien Mottier et Corentin Desse
 *
 */

public class InterFichier {

	//creation de la fenetre (objet de type JFrame)
			JFrame f = new JFrame ("Rot");
			Ecouteur e = new Ecouteur();
			
			public static JButton parcourir = new JButton ("Sélectionner un fichier");
			public static JButton valider = new JButton ("Transformer");
			
			
			public InterFichier() {
				
				f.setResizable(false); //ne pas pouvoir la redimensionner
		    	f.setLocationRelativeTo(null); //ne pas positionner la fenetre en haut à gauche de l'ecran
		    	f.pack();
		    	f.setVisible(true);
		    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		    	parcourir.setAlignmentX(Component.CENTER_ALIGNMENT);
		    	valider.setAlignmentX(Component.CENTER_ALIGNMENT);
		 
		    	
		    
		    	Box boutonBox = Box.createVerticalBox(); 
		   
		    	
		    	boutonBox.add(parcourir);
		    	boutonBox.add(valider);
		    	
		    	f.add(boutonBox,BorderLayout.CENTER);
		    	f.setSize(new Dimension(180,81));
		    	
		    	parcourir.addActionListener(e);
		    	valider.addActionListener(e);
		    	
		    	
			}
			
}
