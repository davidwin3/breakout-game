package com.jashlaviu.jashanoid.actors.bonus;

import com.jashlaviu.jashanoid.JashanoidScreen;
import com.jashlaviu.jashanoid.TextureLoader;

public class BonusLevel extends Bonus {

	public BonusLevel(JashanoidScreen gameScreen, float posX, float posY) {
		super(gameScreen, TextureLoader.bonus_level, posX, posY);		
	}
	
	@Override
	public void apply() {
		super.apply();
		gameScreen.levelUp();
	}

}
