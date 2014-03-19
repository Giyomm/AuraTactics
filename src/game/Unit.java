package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Unit {

	private String name;
	private String kind;
	private String rank;
	private int price;
	private int cmdtCost;
	private int profitability;
	private int damage;
	private double maximumLife;
	private double currentLife;
	private int counterDamage;
		
	private Nation nation;
	private Map<String, String> animationDictionnary = new HashMap<String,String>();
	private JLabel unitLabel;
	
	public Unit(String _name, String _rank, Nation _nation){
		this.unitLabel = new JLabel();
		this.name = _name;
		this.rank = _rank;
		this.nation = _nation;
		
		this.animationDictionnary.put("idle","res/"+this.nation+"/"+this.name+"/"+this.rank+"/idle.gif");
		this.animationDictionnary.put("attack","res/"+this.nation+"/"+this.name+"/"+this.rank+"/attack.gif");
	}
	
	public JLabel displayAnimation(String animationKey){
		ImageIcon image = new ImageIcon(this.getAnimationDictionnary().get(animationKey));		
		if(unitLabel.getIcon() != null){
			this.removeImage();
		}
		this.addImage(image);
		return unitLabel;
	}
	
	public void addImage(ImageIcon _image){
		unitLabel.setIcon(_image);
		unitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unitLabel.repaint();
	}
	
	public void removeImage(){
		unitLabel.setIcon(null);
		unitLabel.repaint();
		
	}
	
	public JLabel updateAnimationFromIdle(String newAnimationKey){
		unitLabel = displayAnimation(newAnimationKey);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		            @Override
		            public void run() {
		            	unitLabel = displayAnimation("idle");
		            }
		        }, processAnimationTime(newAnimationKey));
		return unitLabel;
	}
	
	public int processAnimationTime(String animationKey){
		int numberOfFrames = 0;
		int delayBetweenFrames = 0;
		
		ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
		ImageInputStream in;
		try {
			in = ImageIO.createImageInputStream(new FileInputStream(this.animationDictionnary.get(animationKey)));
			reader.setInput(in);  
			for (int i = 1, count = reader.getNumImages(true); i <= count; i++)  
			{  
				++numberOfFrames;
			}
			 System.out.println("Frames: "+numberOfFrames); 
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
        try {
			reader.setInput(ImageIO.createImageInputStream(new FileInputStream("res/bluehaven/lancier/base/attack.gif")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        int i = reader.getMinIndex();
        try {
			int numImages = reader.getNumImages(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        IIOMetadata imageMetaData;
		try {
			imageMetaData = reader.getImageMetadata(0);
			String metaFormatName = imageMetaData.getNativeMetadataFormatName();
	        IIOMetadataNode root = (IIOMetadataNode)imageMetaData.getAsTree(metaFormatName);
	        IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");
	        delayBetweenFrames = 10*Integer.parseInt(graphicsControlExtensionNode.getAttribute("delayTime"));
	        System.out.println("Delay entre les frames: "+String.valueOf(delayBetweenFrames));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return (delayBetweenFrames*numberOfFrames);
		
	}
	
	private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
        int nNodes = rootNode.getLength();
        for (int i = 0; i < nNodes; i++) {
            if (rootNode.item(i).getNodeName().compareToIgnoreCase(nodeName)== 0) {
            return((IIOMetadataNode) rootNode.item(i));
            }
       }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return(node);
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

	public double getMaximumLife() {
		return maximumLife;
	}

	public void setMaximumLife(double maximumLife) {
		this.maximumLife = maximumLife;
	}

	public double getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(double currentLife) {
		this.currentLife = currentLife;
	}

	public int getCounterDamage() {
		return counterDamage;
	}

	public void setCounterDamage(int counterDamage) {
		this.counterDamage = counterDamage;
	}

	public Map<String, String> getAnimationDictionnary() {
		return animationDictionnary;
	}

	public void setAnimationDictionnary(Map<String, String> animationDictionnary) {
		this.animationDictionnary = animationDictionnary;
	}
	
	
}
