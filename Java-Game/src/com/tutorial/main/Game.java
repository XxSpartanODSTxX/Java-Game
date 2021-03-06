package com.tutorial.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private Boolean running = false;

	public Game() {
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

}
