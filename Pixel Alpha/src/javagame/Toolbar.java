package javagame;

import org.newdawn.slick.*;

public class Toolbar {

	private int width;
	private int height;


	private boolean isVisible = true;
	private Color toolbarColor;

	public Toolbar(){
		init();
	}

	private void init() {
		this.width = 960;
		this.height = 60;
		toolbarColor = new Color(214,214,214);

		setVisibility(true);

	}


	public void setVisibility(boolean visibility){
		isVisible = visibility;
		if(!visibility){

			toolbarColor.a = 0f;
		}else {
			toolbarColor.a = 1f;
		}

	}


	public void setWidth(int width){

		this.width = width;

	}
	public int getWidth(){

		return this.width;

	}

	public boolean isVisible(){

		return isVisible;
	}

	public void switchVisibility() {
		if(this.isVisible()){

			this.setVisibility(false);
		}else {
			this.setVisibility(true);
		}


	}

	public Color getColor() {
		return toolbarColor;
	}

	public int getHeight() {
		
		return this.height;
	}
}
