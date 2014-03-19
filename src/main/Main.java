package main;

import game.Nation;
import game.Unit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	
	private static Unit myUnit;
	
	public static void main (String[] args){
		final JFrame frame = new JFrame("AuraTactics");
		Dimension dim = new Dimension(300, 400);
		frame.setMinimumSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Nation myNation = new Nation("bluehaven");	
		
		JButton createButton = new JButton("Create");
		createButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myUnit = new Unit("lancier","base",myNation);
				frame.getContentPane().add(myUnit.displayAnimation("idle"), BorderLayout.CENTER);
				frame.revalidate();
			}
		});
	
		JButton attackButton = new JButton("Attack");
		attackButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().add(myUnit.updateAnimationFromIdle("attack"), BorderLayout.CENTER);
				frame.revalidate();
			}
		});
		
		JButton killButton = new JButton("Kill");
		
		frame.getContentPane().add(createButton, BorderLayout.NORTH);
		frame.getContentPane().add(attackButton, BorderLayout.SOUTH);
		frame.getContentPane().add(killButton, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
    }
		
}

