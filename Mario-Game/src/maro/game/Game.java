package maro.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import maro.display.Display;
import maro.gfx.Assets;
import maro.gfx.GameCamera;
import maro.gfx.ImageLoader;
import maro.gfx.SpriteSheet;
import maro.input.KeyManager;
import maro.input.MouseManager;
import maro.states.GameState1;
import maro.states.MenuState;
import maro.states.SettingsState;
import maro.states.State;


public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	//BufferStrategy is made to prevent flickering in the game. It will draw the game first into a hidden screen and then into the user's screen.
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public static State gameState;
	public State menuState;
	private State settingsState;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); //allows us to access the keyboard
		display.getFrame().addMouseListener(mouseManager);//allows us to access the mouse
		display.getFrame().addMouseMotionListener(mouseManager);//allows us to access the mouse
		//need to add mouseManager to canvas as well, or it wont work. this is because the Canvas might be the focused object instead of jframe.
		display.getCanvas().addMouseListener(mouseManager); 
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init(); //loads in all resources (sprites,musics, ...)
		
		gameCamera = new GameCamera(this, 0, 0);
		
		gameState = new GameState1(this); //initialize our game state
		menuState = new MenuState(this); //initialize our main menu state
		settingsState = new SettingsState(this); //initialize our settings menu state
		
		State.setState(menuState);
//		State.setState(gameState);
		
		
	}
	
	
	private void tick(){
		keyManager.tick();
		if (State.getState() != null) { //checks if a game state is available
			State.getState().tick();
		}
		
	}
	
	private void render(){ //method for drawing stuff on screen.
		bs = display.getCanvas().getBufferStrategy(); //gets canvas' bufferStrategy object.
		if (bs == null){ //if no bufferStrategy obj has yet been created, this will create one.
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height); //super important. without this line, game will flicker.
		
		g.drawImage(Assets.background_pic, 0, 0, 1500, 1000, null);
		
		if (State.getState() != null) { //checks if a game state is available
			State.getState().render(g);
		}

		bs.show(); //this line is required to do the buffering stuff.
		g.dispose(); //this line makes sure graphics object gets done with properly.
	}
	
	//if class implements Runnable, this method is required to exist.
	public void run(){
		init();
		
		int fps = 60; //defines the FramePerSecond for our game. IMPORTANT.
		double timePerTick = 1000000000 / fps; //is the maximum amount of time we're allowed to run tick() and render() in one second(one billion nanosec).
		double delta = 0; //amount of time we have left till we run tick() and render() method again.
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		while(running) {
			now = System.nanoTime(); //current time of computer(in nanosec).
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
			tick();
			render();
			ticks++;
			delta--; //subtracts delta by 1.
			}
			if (timer >=  1000000000) { 
				System.out.println("Ticks and Frames: " + ticks); //prints the fps once every second.
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if (running) { //if the game is already running, this will assure the game won't restart itself.
			return;
		}
		running = true;
		thread = new Thread(this); //this will run the Game class, aka "this".
		thread.start(); //this line starts the run() method.
	}
	
	public synchronized void stop() {
		if (!running) { //if game is already stopped, this will assure it won't stop itself again.
			return;
		}
		running = false;
		try { //thread.join() must be in a try/catch or it wont work.
			thread.join(); //closes the thread.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
