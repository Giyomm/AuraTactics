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

public class VUnit {
	
	private Map<String, String> animationDictionnary = new HashMap<String,String>();
	private JLabel unitLabel;
	
	public VUnit(Nation _nation,String _name,String _rank){
		this.unitLabel = new JLabel();
		this.animationDictionnary.put("idle","res/"+_nation+"/"+_name+"/"+_rank+"/idle.gif");
		this.animationDictionnary.put("attack","res/"+_nation+"/"+_name+"/"+_rank+"/attack.gif");
		this.animationDictionnary.put("death","res/"+_nation+"/"+_name+"/"+_rank+"/death.gif");
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
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}  
        try {
			reader.setInput(ImageIO.createImageInputStream(new FileInputStream("res/bluehaven/lancier/base/attack.gif")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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
	
	public Map<String, String> getAnimationDictionnary() {
		return animationDictionnary;
	}

	public void setAnimationDictionnary(Map<String, String> animationDictionnary) {
		this.animationDictionnary = animationDictionnary;
	}

	public JLabel getUnitLabel() {
		return unitLabel;
	}

	public void setUnitLabel(JLabel unitLabel) {
		this.unitLabel = unitLabel;
	}

}
