package main;

import game.CUnit;
import game.Nation;

import java.awt.BorderLayout;
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
	
	private static CUnit unit1;
	private static CUnit unit2;
	
	public static void main (String[] args){
		//Creating Jframe
		final JFrame frame = new JFrame("Aura Tactics");
		Dimension dim = new Dimension(800, 400);
		frame.setMinimumSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		final Nation myNation = new Nation("bluehaven");
		
		//Initializing frame panel
		JPanel mainPanel = new JPanel(new GridLayout(2,4));
		
		//Cell 1
		final JPanel unit1ImagePanel = new JPanel(new BorderLayout());
		mainPanel.add(unit1ImagePanel);//add to grid
		
		//Cell 2
		JPanel unit1StatPanel = new JPanel();
		//unit1StatPanel.setBackground(Color.BLUE);
		
		final JLabel pv1 = new JLabel();
		unit1StatPanel.add(pv1);
		
		final JLabel damage1 = new JLabel();
		unit1StatPanel.add(damage1);
		
		final JLabel counter1 = new JLabel();
		unit1StatPanel.add(counter1);
		
		final JLabel costPrice1 = new JLabel();
		unit1StatPanel.add(costPrice1);
		
		final JLabel cmdtCost1 = new JLabel();
		unit1StatPanel.add(cmdtCost1);
		
		final JLabel prof1 = new JLabel();
		unit1StatPanel.add(prof1);
		
		final JLabel kindOfAttack1 = new JLabel();
		unit1StatPanel.add(kindOfAttack1);
		
		unit1StatPanel.setLayout(new BoxLayout(unit1StatPanel, BoxLayout.PAGE_AXIS));
		
		mainPanel.add(unit1StatPanel);//add to grid
		
		//Cell 3
		final JPanel unit2ImagePanel = new JPanel(new BorderLayout());
		//unit2ImagePanel.setBackground(Color.GREEN);
		mainPanel.add(unit2ImagePanel);//add to grid
		
		//Cell 4
		JPanel unit2StatPanel = new JPanel();
		//unit2StatPanel.setBackground(Color.YELLOW);
		unit2StatPanel.setLayout(new BoxLayout(unit2StatPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(unit2StatPanel);//add to grid
		
		final JLabel pv2 = new JLabel();
		unit2StatPanel.add(pv2);
		
		final JLabel damage2 = new JLabel();
		unit2StatPanel.add(damage2);
		
		final JLabel counter2 = new JLabel();
		unit2StatPanel.add(counter2);
		
		final JLabel costPrice2 = new JLabel();
		unit2StatPanel.add(costPrice2);
		
		final JLabel cmdtCost2 = new JLabel();
		unit2StatPanel.add(cmdtCost2);
		
		final JLabel prof2 = new JLabel();
		unit2StatPanel.add(prof2);
		
		final JLabel kindOfAttack2 = new JLabel();
		unit2StatPanel.add(kindOfAttack2);
		
		//Cell 5
		JPanel unit1ActionPanel = new JPanel();
		//unit1ActionPanel.setBackground(Color.RED);
		JButton create1 = new JButton("Create");
		create1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton attack1 = new JButton("Attack");
		attack1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton heal1 = new JButton("Heal");
		heal1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton rankUp1 = new JButton("Rank Up");
		rankUp1.setAlignmentX(Component.CENTER_ALIGNMENT);
		unit1ActionPanel.add(create1); unit1ActionPanel.add(attack1);
		unit1ActionPanel.add(heal1); unit1ActionPanel.add(rankUp1);
		unit1ActionPanel.setLayout(new BoxLayout(unit1ActionPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(unit1ActionPanel);//add to grid
		
		//Cell 6
		JPanel voidPanel1 = new JPanel(new BorderLayout());
		mainPanel.add(voidPanel1);//add to grid
		
		//Cell 7
		JPanel unit2ActionPanel = new JPanel();
		JButton create2 = new JButton("Create");
		create2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton attack2 = new JButton("Attack");
		attack2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton heal2 = new JButton("Heal");
		heal2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton rankUp2 = new JButton("Rank Up");
		rankUp2.setAlignmentX(Component.CENTER_ALIGNMENT);
		unit2ActionPanel.add(create2); unit2ActionPanel.add(attack2); 
		unit2ActionPanel.add(heal2); unit2ActionPanel.add(rankUp2);
		//unit2ActionPanel.setBackground(Color.GREEN);
		unit2ActionPanel.setLayout(new BoxLayout(unit2ActionPanel, BoxLayout.PAGE_AXIS));
		
		mainPanel.add(unit2ActionPanel);//add to grid
		
		//Cell 8
		JPanel voidPanel2 = new JPanel(new BorderLayout());
		mainPanel.add(voidPanel2);//add to grid

		create1.addMouseListener(new MouseListener() {
			
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
				if(unit1 == null){
					unit1 = new CUnit("lancier","base",myNation);
					unit1ImagePanel.add(unit1.getView().displayAnimation("idle"));
					pv1.setText("Pv: "+unit1.getModel().getCurrentLife()+" / "+unit1.getModel().getMaximumLife());
					damage1.setText("Damage: "+unit1.getModel().getDamage());
					counter1.setText("Counter: "+unit1.getModel().getCounterDamage());
					costPrice1.setText("Cost Price: "+unit1.getModel().getPrice());
					cmdtCost1.setText("Cmdt cost: "+unit1.getModel().getCmdtCost());
					prof1.setText("Profitability: "+unit1.getModel().getProfitability());
					kindOfAttack1.setText("Kind of Attack: "+unit1.getModel().getKind());
					frame.revalidate();
				}
			}
		});

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
				System.out.println("New cmdtCost: "+unit1.getModel().getCmdtCost());
				System.out.println("New Prof: "+unit1.getModel().getProfitability());
				
				prof1.setText("Profitability: "+unit1.getModel().getProfitability());
				cmdtCost1.setText("Cmdt cost: "+unit1.getModel().getCmdtCost());
			}
		});
		
		attack1.addMouseListener(new MouseListener() {
			
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
				unit1.dealDamageByUnit(unit2);
				if(unit2.getModel() == null){
					pv2.setText("Pv: 0");
					damage2.setText("Damage: 0");
					counter2.setText("Counter: 0");
					costPrice2.setText("Cost Price: 0");
					cmdtCost2.setText("Cmdt cost: 0");
					prof2.setText("Profitability: 0");
					kindOfAttack2.setText("Kind of Attack: null");
					unit2 = null;
				}
				else{
					pv2.setText("Pv: "+unit2.getModel().getCurrentLife()+" / "+unit2.getModel().getMaximumLife());
					damage2.setText("Damage: "+unit2.getModel().getDamage());
					counter2.setText("Counter: "+unit2.getModel().getCounterDamage());
					costPrice2.setText("Cost Price: "+unit2.getModel().getPrice());
					cmdtCost2.setText("Cmdt cost: "+unit2.getModel().getCmdtCost());
					prof2.setText("Profitability: "+unit2.getModel().getProfitability());
					kindOfAttack2.setText("Kind of Attack: "+unit2.getModel().getKind());
				}
				frame.revalidate();
			}
		});
		
		create2.addMouseListener(new MouseListener() {
			
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
				if(unit2 == null){
					unit2 = new CUnit("lancier","base",myNation);
					unit2ImagePanel.add(unit2.getView().displayAnimation("idle"));
					pv2.setText("Pv: "+unit2.getModel().getCurrentLife()+" / "+unit2.getModel().getMaximumLife());
					damage2.setText("Damage: "+unit2.getModel().getDamage());
					counter2.setText("Counter: "+unit2.getModel().getCounterDamage());
					costPrice2.setText("Cost Price: "+unit2.getModel().getPrice());
					cmdtCost2.setText("Cmdt cost: "+unit2.getModel().getCmdtCost());
					prof2.setText("Profitability: "+unit2.getModel().getProfitability());
					kindOfAttack2.setText("Kind of Attack: "+unit2.getModel().getKind());
					frame.revalidate();
				}
			}
		});
		
		frame.setContentPane(mainPanel);
		frame.pack();
		frame.setVisible(true);
    }
		
}

