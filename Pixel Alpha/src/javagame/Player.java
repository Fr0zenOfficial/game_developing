package javagame;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.Sys;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Point;


public class Player {

	//Attributes

	private String name = "Tony";
	private double age = 16;
	private double weight = 80;
	private final int width = 30;
	private final int height = 90;
	private double strength = 2;
	private boolean isAlive = true;


	private Storage storage = new Storage();
	private Weapon weapons = null;
	private double enchantmentLevel = 0;
	private int[] spawnpoint;
	private String enchantmentStatus = "Present";
	private double health = 10;
	private String healthStatus = "Fit";
	private double hunger = 10;
	private String hungerStatus = "Fulness";
	private double water = 10;
	private String waterStatus = "Normal";
	private int sight = 5;
	private double speed = 1;



	//Legs
	private double legLength = 15;
	private double maxLegDeg = 180;
	private double minLegDeg = 145;
	
	private double currentLegLeftDeg = 45;
	private double currentLegRightDeg = currentLegLeftDeg - 45;
	
	private double gehenWinkel = Math.PI*currentLegLeftDeg/180;
	private double gehenWinkel2 = Math.PI*currentLegRightDeg/180;

	// Left Leg
	private Point legLeftTopP1 = new Point(200,200);
	
	private double leftLeg_aplha = gehenWinkel ;
	private float legLeft_a =(float)(legLength*Math.cos(leftLeg_aplha));

	private float legLeft_b =(float)(legLength*Math.sin(leftLeg_aplha));
	private Point legLeftTopP2 = new Point(legLeftTopP1.getX() + legLeft_b,legLeftTopP1.getY() + legLeft_a);
	private Point legleftBottomP2 = new Point(legLeftTopP2.getX() - legLeft_b,legLeftTopP2.getY() + legLeft_a);

	// Right Leg
	private Point legRightTopP1 = new Point(200,200); 
	private double rightLeg_aplha = gehenWinkel2;
	private float legRight_a =(float)(legLength*Math.cos(rightLeg_aplha));
	private float legRight_b =(float)(legLength*Math.sin(rightLeg_aplha));
	private Point legRightTopP2 = new Point(legRightTopP1.getX() + legLeft_b,legRightTopP1.getY() + legLeft_a);
	private Point legRightBottomP2 = new Point(legRightTopP2.getX() - legRight_b,legRightTopP2.getY() + legRight_a);



	private Color playerColor = new Color(0, 110, 255, 1f);

	private TimerTask checkAll = new TimerTask() {

		@Override
		public void run() {
			checkHummanity();

		}
	};
	private Graphics gameGraphics = null;



	public Player(String name){
		this.name = name;
		Timer timer = new Timer();
		timer.schedule(checkAll, 1, 10);
		System.out.println(legLeft_a);
	}

	public String getName(){return this.name;}

	public void checkHummanity(){
		if(!this.isAlive){

			System.out.println("I'm dead, respawning...");
		}else{


			checkHunger();
			checkWater();
			checkStorage();
			checkWeapons();
			checkSight();
			if(this.hunger <=2){
				strength = this.hunger * 2;
			}
			if(this.water <=2){
				strength = this.water * 2;
			}
		}
	}

	private void checkHunger() {

		if(this.hunger >= 10){
			this.hunger = 10;
			this.hungerStatus = "Fulness";
			this.isAlive = true;
		}
		if(this.hunger < 10 && this.hunger >= 7){
			this.hungerStatus = "Hungry";
			this.isAlive = true;
		}
		if(this.hunger < 7 && this.hunger > 2){
			this.hungerStatus = "Very Hungry";
			this.isAlive = true;
		}
		if(this.hunger == 2){
			this.hungerStatus = "Very Very Hungry ";
			this.isAlive = true;
		}
		if(this.hunger <= 0){
			this.hunger = 0;
			this.hungerStatus = "Died of Hunger";
			this.isAlive = false;
		}

		this.hunger = hunger - 0.0005;
	}

	private void checkWater() {

		if(this.water >= 10){
			this.water = 10;
			this.waterStatus = "Fulness";
			this.isAlive = true;
		}
		if(this.water < 10 && this.water >= 7){
			this.waterStatus = "Dursty";
			this.isAlive = true;
		}
		if(this.water < 7 && this.water > 2){
			this.waterStatus = "Very Hungry";
			this.isAlive = true;
		}
		if(this.water == 2){
			this.waterStatus = "Very Very Hungry ";
			this.isAlive = true;
		}
		if(this.water <= 0){
			this.water = 0;
			this.waterStatus = "Died of Starvation";
			this.isAlive = false;
		}
		this.water = water - 0.0005;

	}
	private void checkStorage() {


	}
	private void checkWeapons() {}
	private void checkSight() {}
	public void save() {



	}


	public void run() {}
	public void attack() {}
	public void getEnchantmentLevel() {}
	public Storage showStorage(){return this.storage;}
	public double getHunger(){return hunger;}
	public String getHungerStatus(){return hungerStatus;}
	public double getWater(){return water;}

	public int getWith() {

		return this.width;
	}
	public int getHeight() {

		return this.height;
	}

	private int getTopLeftLegX1() {

		return (int)this.legLeftTopP1.getX();
	}

	private int getTopLeftLegY1() {

		return (int)this.legLeftTopP1.getY();
	}
	private int getTopLeftLegX2() {

		return (int)this.legLeftTopP2.getX();
	}

	private int getTopLeftLegY2() {

		return (int)this.legLeftTopP2.getY();
	}
	private int getBottomLeftLegX1() {

		return (int)this.legleftBottomP2.getX();
	}

	private int getBottomLeftLegY1() {

		return (int)this.legleftBottomP2.getY();
	}

	private int getTopRightLegX1() {

		return (int)this.legRightTopP1.getX();
	}

	private int getTopRightLegY1() {

		return (int)this.legRightTopP1.getY();
	}
	private int getTopRightLegX2() {

		return (int)this.legRightTopP2.getX();
	}

	private int getTopRightLegY2() {

		return (int)this.legRightTopP2.getY();
	}
	private int getBottomRightLegX1() {

		return (int)this.legRightBottomP2.getX();
	}

	private int getBottomRightLegY1() {

		return (int)this.legRightBottomP2.getY();
	}


	public void giveGraphics(Graphics g) {
		this.gameGraphics  = g;

	}

	public void drawSelf() {
		gameGraphics.setColor(this.playerColor);
		gameGraphics.drawLine(this.getTopLeftLegX1(), this.getTopLeftLegY1(), this.getTopLeftLegX2(), this.getTopLeftLegY2());
		gameGraphics.drawLine(this.getTopLeftLegX2(), this.getTopLeftLegY2(), this.getBottomLeftLegX1(), this.getBottomLeftLegY1());
		gameGraphics.drawLine(this.getTopRightLegX1(), this.getTopRightLegY1(), this.getTopRightLegX2(), this.getTopRightLegY2());
		gameGraphics.drawLine(this.getTopRightLegX2(), this.getTopRightLegY2(), this.getBottomRightLegX1(), this.getBottomRightLegY1());

	}
}
