package main;

import game.Nation;
import game.Unit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	
	private static Unit unit1;
	private static Unit unit2;
	
	public static void main (String[] args){
		//Creating Jframe
		final JFrame frame = new JFrame("Aura Tactics");
		Dimension dim = new Dimension(800, 400);
		frame.setMinimumSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Nation myNation = new Nation("bluehaven");
		unit1 = new Unit("lancier","base",myNation);
		unit2 = new Unit("lancier","base",myNation);
		
		//Initializing frame panel
		JPanel mainPanel = new JPanel(new GridLayout(2,4));
		
		//Cell 1
		JPanel unit1ImagePanel = new JPanel(new BorderLayout());
		unit1ImagePanel.add(unit1.displayAnimation("idle"));
		mainPanel.add(unit1ImagePanel);//add to grid
		
		//Cell 2
		JPanel unit1StatPanel = new JPanel();
		//unit1StatPanel.setBackground(Color.BLUE);
		
		JLabel pv1 = new JLabel();
		pv1.setText("Pv: "+unit1.getCurrentLife()+" / "+unit1.getMaximumLife());
		unit1StatPanel.add(pv1);
		
		JLabel damage1 = new JLabel();
		damage1.setText("Damage: "+unit1.getDamage());
		unit1StatPanel.add(damage1);
		
		JLabel counter1 = new JLabel();
		counter1.setText("Counter: "+unit1.getCounterDamage());
		unit1StatPanel.add(counter1);
		
		JLabel costPrice1 = new JLabel();
		costPrice1.setText("Cost Price: "+unit1.getPrice());
		unit1StatPanel.add(costPrice1);
		
		final JLabel cmdtCost1 = new JLabel();
		cmdtCost1.setText("Cmdt cost: "+unit1.getCmdtCost());
		unit1StatPanel.add(cmdtCost1);
		
		final JLabel prof1 = new JLabel();
		prof1.setText("Profitability: "+unit1.getProfitability());
		unit1StatPanel.add(prof1);
		
		JLabel kindOfAttack1 = new JLabel();
		kindOfAttack1.setText("Kind of Attack: "+unit1.getKind());
		unit1StatPanel.add(kindOfAttack1);
		
		unit1StatPanel.setLayout(new BoxLayout(unit1StatPanel, BoxLayout.PAGE_AXIS));
		
		mainPanel.add(unit1StatPanel);//add to grid
		
		//Cell 3
		JPanel unit2ImagePanel = new JPanel(new BorderLayout());
		unit2ImagePanel.add(unit2.displayAnimation("idle"));
		//unit2ImagePanel.setBackground(Color.GREEN);
		mainPanel.add(unit2ImagePanel);//add to grid
		
		//Cell 4
		JPanel unit2StatPanel = new JPanel();
		unit2StatPanel.setBackground(Color.YELLOW);
		unit2StatPanel.setLayout(new BoxLayout(unit2StatPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(unit2StatPanel);//add to grid
		
		//Cell 5
		JPanel unit1ActionPanel = new JPanel();
		//unit1ActionPanel.setBackground(Color.RED);
		JButton attack1 = new JButton("Attack");
		attack1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton heal1 = new JButton("Heal");
		heal1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton rankUp1 = new JButton("Rank Up");
		rankUp1.setAlignmentX(Component.CENTER_ALIGNMENT);
		unit1ActionPanel.add(attack1); 
		unit1ActionPanel.add(heal1); unit1ActionPanel.add(rankUp1);
		unit1ActionPanel.setLayout(new BoxLayout(unit1ActionPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(unit1ActionPanel);//add to grid
		
		//Cell 6
		JPanel voidPanel1 = new JPanel(new BorderLayout());
		mainPanel.add(voidPanel1);//add to grid
		
		//Cell 7
		JPanel unit2ActionPanel = new JPanel();
		JButton attack2 = new JButton("Attack");
		attack2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton heal2 = new JButton("Heal");
		heal2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton rankUp2 = new JButton("Rank Up");
		rankUp2.setAlignmentX(Component.CENTER_ALIGNMENT);
		unit2ActionPanel.add(attack2); 
		unit2ActionPanel.add(heal2); unit2ActionPanel.add(rankUp2);
		//unit2ActionPanel.setBackground(Color.GREEN);
		unit2ActionPanel.setLayout(new BoxLayout(unit2ActionPanel, BoxLayout.PAGE_AXIS));
		
		mainPanel.add(unit2ActionPanel);//add to grid
		
		//Cell 8
		JPanel voidPanel2 = new JPanel(new BorderLayout());
		mainPanel.add(voidPanel2);//add to grid

		
		rankUp1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				unit1.rankUp();
				frame.revalidate();
				System.out.println("New cmdtCost: "+unit1.getCmdtCost());
				System.out.println("New Prof: "+unit1.getProfitability());
				
				prof1.setText("Profitability: "+unit1.getProfitability());
				cmdtCost1.setText("Cmdt cost: "+unit1.getCmdtCost());
			}
		});
		
		/*JButton createButton = new JButton("Create");
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
				frame.getContentPane().add(myUnit.displayAnimation("idle"), BorderLayout.CENTER);
				frame.revalidate();
			}
		});
	
		/*JButton attackButton = new JButton("Attack");
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
		killButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myUnit.killUnit();
				myUnit = null;
			}
		});
		
		frame.getContentPane().add(createButton, BorderLayout.NORTH);
		frame.getContentPane().add(attackButton, BorderLayout.SOUTH);
		frame.getContentPane().add(killButton, BorderLayout.EAST);*/
		frame.setContentPane(mainPanel);
		frame.pack();
		frame.setVisible(true);
    }
		
}

