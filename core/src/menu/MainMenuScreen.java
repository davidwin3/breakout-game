package menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jashlaviu.jashanoid.Jashanoid;
import com.jashlaviu.jashanoid.TextureLoader;

public class MainMenuScreen extends ScreenAdapter{

	private Jashanoid game;
	private Stage stage;
	private MenuButton playButton, quitButton, optionsButton;
	private MenuButton[] menuButtons;
	private Cursor cursor;
	
	public MainMenuScreen(Jashanoid game) {
		this.game = game;
		
		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), 
				Gdx.graphics.getHeight()), game.getBatch());
		
		playButton = new MenuButton(TextureLoader.button_play, 200, 350);
		optionsButton = new MenuButton(TextureLoader.button_options, 200, 250);
		quitButton = new MenuButton(TextureLoader.button_quit, 200, 150);
		
		menuButtons = new MenuButton[] {playButton, optionsButton, quitButton};
		
		cursor = new Cursor(playButton.getX() - 70, playButton.getY(), 3, 100);
		
		stage.addActor(playButton);
		stage.addActor(optionsButton);
		stage.addActor(quitButton);	
		stage.addActor(cursor);				
	}
	
	@Override
	public void render(float delta) {		
		Gdx.gl.glClearColor(1/255f, 80/255f, 150/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isKeyJustPressed(Keys.DOWN))
			cursor.moveDown();		
		
		if(Gdx.input.isKeyJustPressed(Keys.UP))
			cursor.moveUp();
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
			int index = cursor.getIndex();
			
			if(menuButtons[index] == playButton)
				game.setScreen(game.getGameScreen());
			
			if(menuButtons[index] == optionsButton){
				
			}				
			
			if(menuButtons[index] == quitButton)
				Gdx.app.exit();	
			
		}
		

				
		stage.act();
		stage.draw();	
	}
	
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}
	
	@Override
	public void hide() {
		this.dispose();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}
	
}