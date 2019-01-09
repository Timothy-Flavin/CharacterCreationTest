import java.io.*;
public class Driver{
	public final int WIDTH = 640, HEIGHT = WIDTH * 9 / 12;
	public Driver(){
		new GameMenu(WIDTH, HEIGHT);
	}
	public static void main(String[] args){
		new Driver();
	}

}
