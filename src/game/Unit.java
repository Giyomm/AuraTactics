package game;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class Unit {
	
	
	private String name;
	private String kind;
	private String rank;
	private int price;
	private int cmdtCost;
	private int profitability;
	private int damage;
	private int maximumLife;
	private int currentLife;
	private int counterDamage;	
	private Nation nation;
	
	static Document document;
	static Element racine;
	
	public Unit(String _name, String _rank, Nation _nation){
		this.name = _name;
		this.rank = _rank;
		this.nation = _nation;
		this.parseXML();
	}
	
	public void parseXML(){
		SAXBuilder sxb = new SAXBuilder();
	      try{
	         document = sxb.build(new File("res/"+this.nation+"/"+this.name+"/"+this.rank+"/data.xml"));
	      }
	      catch(Exception e){}
	      racine = document.getRootElement();
	
	      this.price = Integer.valueOf(racine.getChild("price").getText());
	      this.profitability = Integer.valueOf(racine.getChild("prof").getText());
	      this.cmdtCost = Integer.valueOf(racine.getChild("cmdt").getText());
	      this.maximumLife = Integer.valueOf(racine.getChild("life").getText());
	      this.currentLife = this.maximumLife;
	      this.damage = Integer.valueOf(racine.getChild("damage").getText());
	      this.counterDamage = Integer.valueOf(racine.getChild("counter").getText());
	      this.kind = racine.getChild("kind").getText();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCmdtCost() {
		return cmdtCost;
	}

	public void setCmdtCost(int cmdtCost) {
		this.cmdtCost = cmdtCost;
	}

	public int getProfitability() {
		return profitability;
	}

	public void setProfitability(int profitability) {
		this.profitability = profitability;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMaximumLife() {
		return maximumLife;
	}

	public void setMaximumLife(int maximumLife) {
		this.maximumLife = maximumLife;
	}

	public int getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

	public int getCounterDamage() {
		return counterDamage;
	}

	public void setCounterDamage(int counterDamage) {
		this.counterDamage = counterDamage;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}
	
}
