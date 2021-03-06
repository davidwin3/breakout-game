package com.jashlaviu.jashanoid.actors.bricks;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jashlaviu.jashanoid.actors.ActorJashanoid;

/**
 * Parent class of every type of brick.
 * Each brick child has its own TextureRegion and variables.
 * @author jonseijo
 *
 */
public class Brick extends ActorJashanoid {
	
	protected String type;
	protected boolean vulnerable;
	protected boolean indestructible;
	
	protected int maxHits, currentHits;
	
	public Brick(TextureRegion loaderTexture, float posX, float posY) {
		super(loaderTexture);
		setPosition(posX, posY);
		maxHits = 1;
	}
	
	public boolean isVulnerable(){
		return vulnerable;
	}
	
	public void makeVulnerable(){
		//only make vulnerable if it isnt indestructible.
		if(!isIndestructible()){
			currentHits++;
			if(currentHits >= maxHits)
				vulnerable = true;
		}
		
	}
	
	public boolean isIndestructible(){
		return indestructible;
	}
	
	public String getType(){
		return type;
	}
	
	

}
