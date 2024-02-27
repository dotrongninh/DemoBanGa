package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class gathuong extends ga{

	private long startTime;

	public gathuong(Vector2 _position, Texture img,String a1,String a2,String a3) {
		super(_position, img,0.5f,a1,a2,a3);
		// TODO Auto-generated constructor stub
		 startTime = TimeUtils.nanoTime();
	}
	
	public void draw(SpriteBatch batch) {
		super.draw(batch);
		
	}
	public void updatePosition(float deltaTime) {
		super.updatePosition(deltaTime);
	}
	
	public void updatePosition1(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.x+=300*deltaTime;
	 	super.elapsedTime += deltaTime;
       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
    	        
		
	}
	public void updatePosition2(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.x-=300*deltaTime;
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}
	public void updatePosition3(float deltaTime) {
		//super.updatePosition(deltaTime);
	     position.y-=300*deltaTime;
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}
	float dt2=0;	
	/*
	public void updatePosition4(float deltaTime) {
		//super.updatePosition(deltaTime);
		long currentTime = TimeUtils.nanoTime();
        float elapsedSeconds = (currentTime - time) / 1_000_000_000.0f;

	   /* if(deltaTime > 0.005f)
	    	dt2=deltaTime;
	    if(deltaTime > 0.01f)
	    	dt2=deltaTime;
	    	
	     if(elapsedSeconds>2.0f) {
	    		System.out.println("DeltaTime: " + deltaTime);
	    	 position.y-=100*deltaTime;
	    	 position.x+=100*deltaTime;
	     }else {
	    	 position.y+=100*deltaTime;
	    	 position.x+=100*deltaTime;
	     }
	     super.elapsedTime += deltaTime;
	       super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    	             
		
	}*/
	 public void updatePosition4(float deltaTime) {
		 long currentTime = TimeUtils.nanoTime();
	        float elapsedSeconds = (currentTime - startTime) / 1_000_000_000.0f;

	        // Kiểm tra điều kiện sau mỗi 2 giây
	        if (elapsedSeconds > 2.0f) {
	            // Reset thời điểm startTime
	            startTime = TimeUtils.nanoTime();

	            // Thực hiện đoạn code trong if sau mỗi 2 giây
	            position.y -= 100 * deltaTime;
	            position.x += 100 * deltaTime;
	        } else {
	            // Thực hiện đoạn code trong else trong trường hợp còn dưới 2 giây
	            position.y += 100 * deltaTime;
	            position.x += 100 * deltaTime;
	        }

	        super.elapsedTime += deltaTime;
	        super.currentFrame = animation.getKeyFrame(elapsedTime, true);
	    }
}
	
	
	
	

