package javagame;


import org.newdawn.slick.*;

public class World {
	Image allBlocks;
	Block[] blocks;
	private Block lastgeneratedBlock;
	private Image[] drawBlockImages;
	Image frameImage;
	public World(){
		System.out.println("Generated World");
		init();
		
	}
	
	public Image getFrame(){
		
		return frameImage;
	}
	private void init(){
		try {
			allBlocks = new Image("res/all_blocks.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Image[] getBlockImageArray(){
		return drawBlockImages;
	}

	public int getBlockNumber(int GCwidth) {
		
		return GCwidth / 30;
	}
	public String getLastGeneratedBlock(){
		
		return lastgeneratedBlock.getBlockName();
	}

	public Image generateNewBlock() {
		int howManyBlocks = new Block(0, allBlocks).getHowManyBlocksAvialible();
		int random =(int) Math.round(Math.random()* howManyBlocks) + 1;
		Block block = new Block(random, allBlocks);
		lastgeneratedBlock = block;
		return block.getBlockImage();
	}

}
