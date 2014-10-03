package javagame;

import org.newdawn.slick.*;

public class Block {

	
	
	Image allBlocks;
	private int currentID = 0;
	
//	private String[] allIDs = new String[]{"None","Dirt","Dirt2","Stone"};
	private int howManyBlocks = 9;
	private int x = 0;
	private int y = 0;
	final private int width = 30;
	final private int height = 30;
	private String[] allIDs = new String[howManyBlocks];
	Image blockImage;
	
	public Block(int setID,Image allBlocks){
		this.allBlocks = allBlocks;
		init(setID);
		
	}
	
	private void init(int setID){
		currentID = setID;
		
		allIDs[0] = "None";
		allIDs[1] = "Dirt";
		allIDs[2] = "Dirt2";
		allIDs[3] = "Grass";
		allIDs[4] = "Wood";
		allIDs[5] = "Cloud";
		allIDs[6] = "Water";
		allIDs[7] = "Cleaned Stone";
		allIDs[8] = "Cobbled Stone";
		
		x = width * (currentID-1);
		
			this.blockImage = allBlocks.getSubImage(x, y, width, height);
		
		
	}
	
	public Image getBlockImage(){
		return blockImage;
	}
	public String getBlockName() {
		
		return allIDs[currentID];
	}

	public int getHowManyBlocksAvialible() {
		
		return howManyBlocks;
	}

	public void setImage(Image allBlocks) {
		this.allBlocks = allBlocks;
		
	}
}
