package maro.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import maro.Handler;
import maro.MainMenu.MenuMouseInput;
import maro.display.Display;
import maro.gfx.Assets;
import maro.gfx.GameCamera;
import maro.gfx.ImageLoader;
import maro.gfx.SpriteSheet;
import maro.input.KeyManager;
import maro.states.GameState;
import maro.states.MenuState;
import maro.states.SettingsState;
import maro.states.State;

//kabab is the best 
//kabab is not best
//kabab is bad 

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
	private State gameState;
	private State menuState;
	private State settingsState;
	
	//input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	public static Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); //allows us to access the keyboard
		display.getFrame().addMouseListener(new MenuMouseInput());
		Assets.init(); //loads in all resources (sprites,musics, ...)
		
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		
		gameState = new GameState(handler); //initialize our game state
		menuState = new MenuState(handler); //initialize our main menu state
		settingsState = new SettingsState(handler); //initialize our settings menu state
		
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
		
//		g.drawImage(Assets.background_pic, 0, 0, 1500, 1000, null);
		
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
