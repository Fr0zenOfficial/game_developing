package javagame;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{

	private Robot robot;
	World world;
	private Image drawBlockImage;
	private Image[] drawBlockImages;
	private int worldBlockNumber = 0;
	private Toolbar toolbar; 


	private Player player;
	private double currentHunger;
	private Color hungerColor;
	private int hungerWidth;
	private int hungerMaxWidth = 150;
	private String playerHungerStatus;

	private Color waterColor;
	private int waterWidth;
	private int waterMaxWidth = 150;
	private String playerWaterStatus;


	private int mousePositionX;
	private int mousePositionY;
	private boolean drawToolBar = true;
	private int humanityX;
	private float humanityY;

	private float OutventoryWidth = 200;
	private float OutventoryHeight = 40;
	private Color outventoryColor = new Color(0,0,0,0.2f);
	private boolean drawInventorySelector = false;
	private Color inventorySelectorColor = new Color(0,153,255,0.2f);
	private float drawInventorySelectorX;
	private float drawInventorySelectorY;
	private float drawInventorySelectorWidth = 40;
	private float drawInventorySelectorHeight = 40;
	private boolean drawInventorySelector2 = false;
	private Color inventorySelector2Color = new Color(255,255,255,0.2f);
	private float drawInventorySelector2X;
	private float drawInventorySelector2Y;

	

	Animation playerIsGoingAnimation;



	public Play(int state){

	}

	// intialisierung des Spiele-Bereichs
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		player = new Player("Toby");
		
		toolbar = new Toolbar();
		toolbar.setWidth(gc.getWidth());
		hungerWidth = hungerMaxWidth;
		waterWidth = waterMaxWidth;
		playerHungerStatus = Integer.toString((int)Math.round(player.getHunger()));
		
		world = new World();
		humanityX = gc.getWidth() - 180;
		humanityY = gc.getHeight() - 44;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Renderer
	public  void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//player Movements
		player.giveGraphics(g);
		player.drawSelf();
		
		if(drawToolBar){
			g.setColor(toolbar.getColor());
			g.fillRect(0, gc.getHeight() - 60, toolbar.getWidth(), toolbar.getHeight());
			g.setColor(outventoryColor);
			g.fillRect(gc.getWidth()/2 - OutventoryWidth/2, gc.getHeight() - 50, OutventoryWidth, OutventoryHeight);
			if(drawInventorySelector2){
				drawInventorySelector2Y = (gc.getHeight() - 50);
				g.setColor(inventorySelector2Color);
				g.fillRect(drawInventorySelector2X, drawInventorySelector2Y, drawInventorySelectorWidth, drawInventorySelectorHeight);
			}
			if(drawInventorySelector){
				g.setColor(inventorySelectorColor);
				g.fillRect(drawInventorySelectorX, drawInventorySelectorY, drawInventorySelectorWidth, drawInventorySelectorHeight);
			}

			g.setColor(hungerColor);
			g.fillRect(humanityX,humanityY,hungerWidth,4);
			g.setColor(waterColor);
			g.fillRect(humanityX,humanityY+20,waterWidth,4);

		}

	}
	// Updated den Renderer
	public void update(GameContainer gc, StateBasedGame sbg,int delta) throws SlickException {
		mousePositionX = Mouse.getX();
		mousePositionY = Mouse.getY();
		Input input = gc.getInput();
		input.disableKeyRepeat();
		checkMouseMovement(input,gc);
		drawPlayerHumanity();
		checkKeyboardInput(input,gc);
		

	}






	private void checkKeyboardInput(Input input,GameContainer gc) {
		if(input.isKeyPressed(Keyboard.KEY_1)){

			drawInventorySelector2X = (gc.getWidth()/2 - OutventoryWidth/2);
			drawInventorySelector2 = true;

		}
		if(input.isKeyPressed(Keyboard.KEY_2)){
			drawInventorySelector2X = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*1);
			drawInventorySelector2 = true;

		}
		if(input.isKeyPressed(Keyboard.KEY_3)){

			drawInventorySelector2X = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*2);
			drawInventorySelector2 = true;

		}
		if(input.isKeyPressed(Keyboard.KEY_4)){
			drawInventorySelector2X = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*3);
			drawInventorySelector2 = true;

		}
		if(input.isKeyPressed(Keyboard.KEY_5)){
			drawInventorySelector2X = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*4);
			drawInventorySelector2 = true;

		}
		if(input.isKeyPressed(Keyboard.KEY_TAB)){
			toolbar.switchVisibility();
			if(drawToolBar){

				drawToolBar = false;
			}else {
				drawToolBar = true;
			}
		}
		if(input.isKeyPressed(Keyboard.KEY_ESCAPE)){

		}
	}

	private void drawPlayerHumanity() {
		playerHungerStatus = Integer.toString((int)Math.round(player.getHunger()));
		if(player.getHunger() >= 7.0 && player.getHunger() <= 10.0){
			hungerColor = Color.green;
		}else if(player.getHunger() > 2.0 && player.getHunger() < 7.0){
			hungerColor = Color.yellow;
		}else if(player.getHunger() >= 0 && player.getHunger() <= 2.0){
			hungerColor = Color.red;
		}
		hungerWidth =(int)Math.round(15 * player.getHunger()) ;

		playerWaterStatus = Integer.toString((int)Math.round(player.getWater()));
		if(player.getWater() >= 7.0 && player.getWater() <= 10.0){
			waterColor = Color.green;
		}else if(player.getWater() > 2.0 && player.getWater() < 7.0){
			waterColor = Color.yellow;
		}else if(player.getWater() >= 0 && player.getWater() <= 2.0){
			waterColor = Color.red;
		}
		waterWidth =(int)Math.round(15 * player.getWater()) ;

	}

	private void checkMouseMovement(Input input, GameContainer gc) {
		if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) &&
				mousePositionX <= ((gc.getWidth()/2 - OutventoryWidth/2) + OutventoryWidth) &&
				mousePositionY >= (10) && mousePositionY <= (10) + OutventoryHeight){
			drawInventorySelectorY = gc.getHeight() - 50;
			if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) && mousePositionX < (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*1)){
				drawInventorySelectorX = (gc.getWidth()/2 - OutventoryWidth/2);
				if(input.isMousePressed(0)){

					robot.keyPress(KeyEvent.VK_1);
					robot.keyRelease(KeyEvent.VK_1);
				}
			}else if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*1) && mousePositionX < (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*2)){
				if(input.isMousePressed(0)){

					robot.keyPress(KeyEvent.VK_2);
					robot.keyRelease(KeyEvent.VK_2);
				}
				drawInventorySelectorX = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*1);
			}else if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*2) && mousePositionX < (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*3)){
				if(input.isMousePressed(0)){

					robot.keyPress(KeyEvent.VK_3);
					robot.keyRelease(KeyEvent.VK_3);
				}
				drawInventorySelectorX = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*2);
			}else if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*3) && mousePositionX < (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*4)){
				if(input.isMousePressed(0)){

					robot.keyPress(KeyEvent.VK_4);
					robot.keyRelease(KeyEvent.VK_4);
				}
				drawInventorySelectorX = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*3);
			}else if(mousePositionX >= (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*4) && mousePositionX < (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*5)){
				if(input.isMousePressed(0)){

					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
				}
				drawInventorySelectorX = (gc.getWidth()/2 - OutventoryWidth/2) + (drawInventorySelectorWidth*4);
			}
			drawInventorySelector = true;


		}else {
			drawInventorySelector = false;
		}

	}

	public int getID() {

		return 2;
	}

}
