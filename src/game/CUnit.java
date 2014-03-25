package game;

import java.util.Timer;
import java.util.TimerTask;

public class CUnit {
	
	private VUnit view;
	private Unit model;
	
	public CUnit(String _name, String _rank, Nation _nation){
		this.model = new Unit(_name, _rank, _nation);
		this.view = new VUnit(_nation, _name,_rank);
	}
	
	public void rankUp(){
		if(model.getRank() != "legendaire"){
			String newRank = "";
			
			if(model.getRank() == "base")
				newRank = "veteran";
			else
				newRank = "legendaire";
			
			model.setRank(newRank);
			view.getAnimationDictionnary().put("idle","res/"+model.getNation()+"/"+model.getName()+"/"+model.getRank()+"/idle.gif");
			view.getAnimationDictionnary().put("attack","res/"+model.getNation()+"/"+model.getName()+"/"+model.getRank()+"/attack.gif");
			view.getAnimationDictionnary().put("death","res/"+model.getNation()+"/"+model.getName()+"/"+model.getRank()+"/death.gif");
			view.displayAnimation("idle");
			
			model.setProfitability((int) (model.getProfitability()*1.50));
			model.setCmdtCost((int) (model.getCmdtCost()-(model.getCmdtCost()*0.33)));
		}
	}
	
	public void killUnit(){
		view.displayAnimation("death");
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		            @Override
		            public void run() {
		            	//destroy object
		            	view.getUnitLabel().setIcon(null);
		            	view = null;
		            }
		        }, view.processAnimationTime("death"));
	}
	
	public void dealDamageByUnit(CUnit targetUnit){
		targetUnit.getModel().setCurrentLife(
				targetUnit.getModel().getCurrentLife()-this.model.getDamage());
		
		System.out.println("Damage");
		System.out.println(this.getModel().toString());
		System.out.println(targetUnit.getModel().toString());
		
		if(targetUnit.getModel().getCounterDamage() > 0){
			targetUnit.dealDamageByCounter(this);
		}		

		if(targetUnit.getModel().getCurrentLife() <= 0){
			System.out.println("dead by attack!");
			targetUnit.killUnit();
			targetUnit.setModel(null);
		}
		
		if(this.getModel() != null){
			view.updateAnimationFromIdle("attack");
		}	
	}
	
	public void dealDamageByCounter(CUnit attackingUnit){
			
		attackingUnit.getModel().setCurrentLife(
				attackingUnit.getModel().getCurrentLife()-this.model.getCounterDamage());
		
		System.out.println("Counter");
		System.out.println(attackingUnit.getModel().toString());
		System.out.println(this.getModel().toString());
		
		if(attackingUnit.getModel().getCurrentLife() <= 0){
			System.out.println("dead by counter!");
			attackingUnit.killUnit();
			attackingUnit.setModel(null);
		}
	}

	public VUnit getView() {
		return view;
	}

	public Unit getModel() {
		return model;
	}

	public void setView(VUnit view) {
		this.view = view;
	}

	public void setModel(Unit model) {
		this.model = model;
	}

}
