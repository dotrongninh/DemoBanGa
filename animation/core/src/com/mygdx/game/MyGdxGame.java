package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	SpriteBatch batch;float elapsedTime = 0;int dem=0;
	Texture img ,img2,imgga,backgroundTexture;
	int NumWidth_ga = 7;
	int NumHeight_ga=2;
	int spacing_ga=120;
	player play;
	ga[] gas  =new ga[20];
	int demturn1=0;
	
	
	
	   turn2 t2;
	
	
	Sprite backgroundSprite;
//	private Texture resizeTexture(Texture originalTexture, int newWidth, int newHeight) {
//        int originalWidth = originalTexture.getWidth();
//        int originalHeight = originalTexture.getHeight();
//
//        float widthRatio = (float) newWidth / originalWidth;
//        float heightRatio = (float) newHeight / originalHeight;
//        
//        return new Texture(originalTexture, (int) (originalWidth * widthRatio), (int) (originalHeight * heightRatio));
//    }
	
	
	
	public void create () {
		 backgroundTexture = new Texture("back3.jpg"
		 		+ ""
		 		+ "");
		 
		 
		 
//		 SpriteBatch spriteBatch = new SpriteBatch();
//		 spriteBatch.begin();
//		 spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		 spriteBatch.end();
		 
		batch = new SpriteBatch();
		img = new Texture("phicochiendau.png");
		img2 = new Texture("danlua.png");
		imgga = new Texture("3. Gà con.png");
	   play = new player(img,img2);
	   int i=0;
	  
	   for(int y=0;y<20;y++) {
		   
			   Vector2 position = new Vector2(0,0);

			   
			   position.x=MathUtils.random(100, 1100);
			   position.y=800;
			   
			   gas[i]=new ga(position, imgga,0.5f,"gacon-1.png","gacon-2.png","gacon-3.png");i++;
			  
		   
	   }
	   

	  
	   
	t2=new turn2(play, batch);
	   t2.tao1(-200,500);
	   t2.tao2(1800,500 );
	   t2.tao3(0, 500);
	   
	   
	   
	   
	   
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(backgroundTexture, 0, 0);
		
		elapsedTime += Gdx.graphics.getDeltaTime();
		
		if (elapsedTime >= 1.3f && dem<14) {
		  gas[dem].Alive=true;dem++;
		  elapsedTime=0;
		  
		}
		
		  t2.xuat3();
		play.Draw(batch);
		
		if (!play.gameOver)
		{
			for(int i=0;i<gas.length;i++) {
				
				
				if(gas[i].Alive)
				gas[i].draw(batch);
			}
		for (int i = 0; i < gas.length; i++) {
		    if(gas[i].Alive==true)
		    gas[i].updatePosition(Gdx.graphics.getDeltaTime()/2);
		}

		
		for(int i=0;i<gas.length;i++) {
			if(gas[i].Alive) {
			
			if(play.sprite_bullet.getBoundingRectangle().overlaps(gas[i].sprite.getBoundingRectangle())) {
				play.p_bullet.y=10000;
			
				gas[i].Alive=false;demturn1++;
				//break;
			}
			
			if(play.sprite.getBoundingRectangle().overlaps(gas[i].sprite.getBoundingRectangle())) {
				 play.gameOver = true;
			}}
			
			
	
			
			
			
			
			
			
		
		}int a1=0;
		if (demturn1>=1) {
			
		    // Đặt lại tất cả gas[i] về trạng thái sống (Alive = true)
		   	
		 a1=  t2.xuat1();
		}	
		if(a1>=5) t2.xuat2();
		
        }
		else {
			// String gameOverText = "Game Over";
			String gameOverText =  String.valueOf(Gdx.graphics.getDeltaTime()) ;
		
		        float textX = 330; // Thay thế YourXPosition bằng vị trí X mong muốn
		        float textY = 200; // Thay thế YourYPosition bằng vị trí Y mong muốn
		        batch.draw(new TextureRegion(new Texture("gameover.jpg")), textX, textY);
		        
		        
	    }
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
