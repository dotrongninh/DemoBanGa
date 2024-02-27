package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 */
public class turn2 {
	ga[] gas  =new ga[20];
	
	player play;gathuong[] list =new gathuong[20];SpriteBatch batch;int demturn1=0,dem=0;Texture img	 = new Texture("4. Gà đặc nhiệm.png");
	float elapsedTime = 0,elapsedTime2 = 0,elapsedTime3 = 0;gathuong[] list2 =new gathuong[20]; gathuong[] list3 = new gathuong[20];
	int dem2=0;
	 public turn2(player a,SpriteBatch b) {
		 play=a;batch=b;
		 
	 }
	 
     public void tao0() {
   	
   	  
      for(int i =0;i<20;i++) {
		   
		   Vector2 position = new Vector2(0,0);

		   
		   position.x=MathUtils.random(100, 1100);
		   position.y=800;
		   
		   gas[i]=new ga(position, img,0.5f,"gacon-1.png","gacon-2.png","gacon-3.png");
		  
	   
  }
  
   	  
     }
	 
	 
      	
      
      public void tao1(int x,int y) {
    	  for(int i=0;i<20;i++)
    	  {
    	  Vector2 position = new Vector2(x,y);		   
		 //  position.x=MathUtils.random(100, 1100);
		 //  position.y=800;
		   
		   list[i]=new gathuong(position, img,"gadacnhiem1.png","gadacnhiem2.png","gadacnhiem3.png");
    	  
    	  }  
      }
      public void tao2(int x,int y) {
    	  for(int i=0;i<20;i++)
    	  {
    	  Vector2 position = new Vector2(x,y);		   
		 //  position.x=MathUtils.random(100, 1100);
		 //  position.y=800;
		   
		   list2[i]=new gathuong(position, img,"gadacnhiem1.png","gadacnhiem2.png","gadacnhiem3.png");
    	  
    	  }  
      }
      
      public void tao3(int x, int y) {
    	  for(int i=0; i< 20; i++) {
    		  Vector2 position = new Vector2(x,y);	
    		  list3[i]=new gathuong(position, img,"gacon-1.png","gacon-2.png","gacon-3.png");
    	  }
      }
      
      public void xuat3() {
    	   elapsedTime3 += Gdx.graphics.getDeltaTime();
    	  if (elapsedTime3 >= 1.6f && dem<20) {
      		  list3[dem].Alive=true;dem++;
      		  elapsedTime3=0;
      		  
      		}
    	  for(int i=0;i<list3.length;i++) {
				if(list3[i].Alive)
				list3[i].draw(batch);
			}
    	  for (int i = 0; i < list3.length; i++) {
  		    if(list3[i].Alive==true)
  		    list3[i].updatePosition4(Gdx.graphics.getDeltaTime()/2);
    	  }
    	  
  			for(int i=0;i<list3.length;i++) {
  				if(list3[i].Alive) {
  				
  				if(play.sprite_bullet.getBoundingRectangle().overlaps(list3[i].sprite.getBoundingRectangle())) {
  					play.p_bullet.y=10000;
  
  					list3[i].Alive=false;demturn1++;
  					//break;
  				}
  				
  				if(play.sprite.getBoundingRectangle().overlaps(list3[i].sprite.getBoundingRectangle())) {
  					play.gameOver = true;
  				}}}   	  
  			
  	    	//  return demturn1;
    	  
      }
      
      
      public int xuat0() {
    	  return 0;
      }
      
      
      
      public int xuat1( ) {
    	  
      elapsedTime += Gdx.graphics.getDeltaTime();

  		if (elapsedTime >= 1.6f && dem<20) {
  		  list[dem].Alive=true;dem++;
  		  elapsedTime=0;
  		  
  		}
			for(int i=0;i<list.length;i++) {
				if(list[i].Alive)
				list[i].draw(batch);
			}
		for (int i = 0; i < list.length; i++) {
		    if(list[i].Alive==true)
		    list[i].updatePosition1(Gdx.graphics.getDeltaTime()/2);    
		}
		for(int i=0;i<list.length;i++) {
			if(list[i].Alive) {
			
			if(play.sprite_bullet.getBoundingRectangle().overlaps(list[i].sprite.getBoundingRectangle())) {
				play.p_bullet.y=10000;
				
				
			
				list[i].Alive=false;demturn1++;
				//break;
			}
			
			if(play.sprite.getBoundingRectangle().overlaps(list[i].sprite.getBoundingRectangle())) {
				play.gameOver = true;
			}}}   	  
		
    	  return demturn1;
	
}
      
      public int xuat2( ) {
    	  
          elapsedTime2 += Gdx.graphics.getDeltaTime();

      		if (elapsedTime2 >= 1.6f && dem2<20) {
      		  list2[dem2].Alive=true;dem2++;
      		  elapsedTime2=0;
      		  
    }
        	  
        	  
        	  
        	  

    			for(int i=0;i<list2.length;i++) {
    				
    				
    				if(list2[i].Alive)
    				list2[i].draw(batch);
    			}
    		for (int i = 0; i < list2.length; i++) {
    		    if(list2[i].Alive==true)
    		    list2[i].updatePosition2(Gdx.graphics.getDeltaTime()/2);
    		    
    		    
    		    
    		    
    		}
    		for(int i=0;i<list2.length;i++) {
    			if(list2[i].Alive) {
    			
    			if(play.sprite_bullet.getBoundingRectangle().overlaps(list2[i].sprite.getBoundingRectangle())) {
    				play.p_bullet.y=10000;
    				
    				
    			
    				list2[i].Alive=false;demturn1++;
    				//break;
    			}
    			
    			if(play.sprite.getBoundingRectangle().overlaps(list2[i].sprite.getBoundingRectangle())) {
    				play.gameOver = true;
    			}}}   	  
        	  return demturn1;
    	
    }
      
}
