package javagame;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Options extends BasicGameState implements MusicListener {
	private Music optionMusic;
	public Options(int state){

	}

	public int getID() {

		return 1;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		optionMusic = loadMusic("res/music/options_1.ogg");

		optionMusic.addListener(this);

	}

	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		optionMusic.loop();
		optionMusic.setVolume(0.5f);

	}
	public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException {
		

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		Input input = gc.getInput();
		if(input.isKeyPressed(Keyboard.KEY_ESCAPE)){
			sbg.enterState(0);
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

	@Override
	public void musicEnded(Music arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void musicSwapped(Music arg0, Music arg1) {
		// TODO Auto-generated method stub
		
	}
}
