package javagame;

import java.io.InputStream;
import java.awt.Font;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.*;

public class Menu extends BasicGameState implements MusicListener{

	private Image playGameButton;
	private Image optionsButton;
	private Image closeGameButton;

	private Image buttonUp;
	private Image buttonDown;
	private Image exitButtonDown;
	private Font awtFont;
	private TrueTypeFont font;
	private InputStream fontfile;
	private int mousePositionX;
	private int mousePositionY;
	private Music menuMusic;
	public Menu(int state){

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		menuMusic = loadMusic("res/music/menu_1.ogg");
		
		menuMusic.addListener(this);
		

		try{


			fontfile = ResourceLoader.getResourceAsStream("res/PixelFont.ttf");
			awtFont = Font.createFont(Font.TRUETYPE_FONT,fontfile);
			awtFont= awtFont.deriveFont(24f);
			font = new TrueTypeFont(awtFont, true);
		}catch(Exception e){
			e.printStackTrace();
		}
		buttonUp = new Image("res/menu_button.png");
		playGameButton = buttonUp;
		optionsButton =  buttonUp;
		closeGameButton =  buttonUp;
		buttonDown = new Image("res/menu_button_down.png");
		exitButtonDown = new Image("res/menu_button_down_exit.png");

	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		menuMusic.loop();
		menuMusic.setVolume(0.5f);
	}
	
	
	public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException {
		menuMusic.stop();

	}

	public  void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Pixel", gc.getWidth()/2 - 20, 40);
		g.setColor(Color.black);
		playGameButton.setFilter(Image.FILTER_NEAREST);//Anti-Aliasing
		playGameButton.draw(20, gc.getHeight()/2 - (80/40*60));

		g.drawString("Start", 40, gc.getHeight()/2 - (110));

		optionsButton.setFilter(Image.FILTER_NEAREST);//Anti-Aliasing
		optionsButton.draw(20,gc.getHeight()/2 - 40);
		g.drawString("Options", 40, gc.getHeight()/2 - (30));
		closeGameButton.setFilter(Image.FILTER_NEAREST);//Anti-Aliasing
		closeGameButton.draw(20,gc.getHeight()/2 + 40);
		g.drawString("Exit", 40, gc.getHeight()/2 + (50));
	}

	public void update(GameContainer gc, StateBasedGame sbg,int delta) throws SlickException {
		
		mousePositionX = Mouse.getX();
		mousePositionY = Mouse.getY();
		Input input = gc.getInput();
		if(mousePositionX >=20 && mousePositionX <= 270 && mousePositionY >= 380 && mousePositionY <= 440){
			playGameButton = buttonDown;
			if(input.isMousePressed(0)){
				sbg.enterState(2);
			}
		}else {
			playGameButton = buttonUp;
		}
		if(mousePositionX >=20 && mousePositionX <= 270 && mousePositionY >= 300 && mousePositionY <= 360){
			optionsButton = buttonDown;
			if(input.isMousePressed(0)){
				sbg.enterState(1);
			}
		}else {
			optionsButton = buttonUp;
		}
		if(mousePositionX >=20 && mousePositionX <= 270 && mousePositionY >= 220 && mousePositionY <= 280){
			closeGameButton = exitButtonDown;
			if(input.isMousePressed(0)){
				System.exit(0); // Exiting game.
			}
		}else {
			closeGameButton = buttonUp;
		}


	}

	private Music loadMusic(String path) throws SlickException {
		if (path == null || path.length() == 0)
			throw new SlickException("Sound resource has invalid path");

		Music music = null;

		try {
			
			music = new Music(path);
		} catch (SlickException e) {
			throw new SlickException("Could not load sound", e);
		}

		return music;
	}
	

	public int getID() {

		return 0;
	}

	@Override
	public void musicEnded(Music arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void musicSwapped(Music arg0, Music arg1) {
		// TODO Auto-generated method stub

	}

}
