package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	



	public static final String gamename = "Pixel";
	public static final int menu = 0;
	public static final int options = 1;
	public static final int play = 2;
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Options(options));
		this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}
	
	

}
