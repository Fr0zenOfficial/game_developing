package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Controll {
	
	public static final String gamename = "Pixel";
	private int width = 960;
	private int height = 640;
	private boolean fullscreen = false;
	

	public void run(){
		
		AppGameContainer appgc;

		try {
			appgc = new AppGameContainer(new Game(gamename));
			
			appgc.setDisplayMode(width, height, fullscreen);
			appgc.setVSync(true);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}
