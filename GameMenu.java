import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class GameMenu{

	private Color lightBlue;
	private JFrame frame;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private MenuButton addHealth, minusHealth, addAttack, minusAttack, addSpeed, minusSpeed, finalize, newGame, cont, settings, exit, sizeButton, difficultyButton, backButton, newSaveOneButton, newSaveTwoButton, newSaveThreeButton, toMainMenu, toMainMenu2, loadSaveOneButton, loadSaveTwoButton, loadSaveThreeButton;
	private int width, height, attack = 0, health = 0, speed = 0, screenSize, difficultyNum, total = 20, saveNum;
	private String difficulty = "easy", saveFileName = "StatSaved1.txt";
	private final int PANELS = 25;
	private JLabel[] labels2, labels1, labels3, labels4;
	private JPanel[] panelList;
	private JLabel contLabel;

	public GameMenu(int WIDTH, int HEIGHT){
		width = WIDTH;
		height = HEIGHT;
		frame = new JFrame();
		lightBlue = new Color(40, 200, 250);
		frame.setTitle("Game Menu");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		contLabel = new JLabel("you fucked up");

		try{
			Scanner fileReader = new Scanner(new File("Settings.txt"));
			screenSize = fileReader.nextInt();
			difficultyNum = fileReader.nextInt();
		}catch(IOException e) {
			screenSize = 1;
			difficulty = "normal";
			difficultyNum = 2;
		}
		frame.setSize(width * screenSize, height * screenSize);
		labels1 = new JLabel[5];
		for(int i = 0; i < 5; i++){
			labels1[i] = new JLabel();
		}
		labels1[0].setText("Generic RPG Title");
		labels1[1].setText("Start Fresh");
		labels1[2].setText("Pick up where you left off");
		labels1[3].setText("Changes them settings");
		labels1[4].setText("close that program");

		labels2 = new JLabel[5];
		for(int i = 0; i < 5; i++){
			labels2[i] = new JLabel();
		}
		labels2[0].setText("Choose your character's atributes. Total Points: " + total);
		labels2[1].setText("Base attack: " + attack);
		labels2[2].setText("Base health: " + health);
		labels2[3].setText("Base speed:  " + speed);
		labels2[4].setText("Finalize Creation?");

		labels3 = new JLabel[5];
		for(int i = 0; i < 5; i++){
			labels3[i] = new JLabel();
		} //for continue option
		labels4 = new JLabel[5];
		for(int i = 0; i < 5; i++){
			labels4[i] = new JLabel();
		}
		labels4[0].setText("Settings");
		labels4[1].setText("Screen size: " + screenSize);
		labels4[2].setText("Difficulty: " + difficulty);
		labels4[3].setText("-unused-");
		labels4[4].setText("back to home");

		panelList = new JPanel[PANELS];
		for(int i = 0; i < PANELS; i++){
			panelList[i] = new JPanel();
			panelList[i].setBackground(lightBlue);
		}
		MenuButtonClick buttonPressed = new MenuButtonClick();
		addAttack = new MenuButton("+", "addAttack");
		addAttack.addActionListener(buttonPressed);
		addHealth = new MenuButton("+", "addHealth");
		addHealth.addActionListener(buttonPressed);
		addSpeed = new MenuButton("+", "addSpeed");
		addSpeed.addActionListener(buttonPressed);

		minusAttack = new MenuButton("-", "minusAttack");
		minusAttack.addActionListener(buttonPressed);
		minusHealth = new MenuButton("-", "minusHealth");
		minusHealth.addActionListener(buttonPressed);
		minusSpeed = new MenuButton("-", "minusSpeed");
		minusSpeed.addActionListener(buttonPressed);
		finalize = new MenuButton("Done", "finalize");
		finalize.addActionListener(buttonPressed);

		newGame = new MenuButton("New", "newGame");
		newGame.addActionListener(buttonPressed);
		cont = new MenuButton("Continue", "cont");
		cont.addActionListener(buttonPressed);
		settings = new MenuButton("Options", "settings");
		settings.addActionListener(buttonPressed);
		exit = new MenuButton("X", "exit");
		exit.addActionListener(buttonPressed);

		sizeButton = new MenuButton("+", "sizeButton");
		sizeButton.addActionListener(buttonPressed);
		difficultyButton = new MenuButton("<->", "difficultyButton");
		difficultyButton.addActionListener(buttonPressed);
		backButton = new MenuButton("<--", "backButton");
		backButton.addActionListener(buttonPressed);

		newSaveTwoButton = new MenuButton("New game", "newSaveTwo");
		newSaveTwoButton.addActionListener(buttonPressed);
		newSaveOneButton = new MenuButton("New game", "newSaveOne");
		newSaveOneButton.addActionListener(buttonPressed);
		newSaveThreeButton = new MenuButton("New game", "newSaveThree");
		newSaveThreeButton.addActionListener(buttonPressed);
		toMainMenu = new MenuButton("<--", "toMainMenu");
		toMainMenu.addActionListener(buttonPressed);

		loadSaveTwoButton = new MenuButton("Load game 2:", "loadSaveTwo");
		loadSaveTwoButton.addActionListener(buttonPressed);
		loadSaveOneButton = new MenuButton("Load game 1:", "loadSaveOne");
		loadSaveOneButton.addActionListener(buttonPressed);
		loadSaveThreeButton = new MenuButton("Load game 3:", "loadSaveThree");
		loadSaveThreeButton.addActionListener(buttonPressed);
		toMainMenu2 = new MenuButton("<--", "toMainMenu");
		toMainMenu2.addActionListener(buttonPressed);

		panel1.setLayout(new GridLayout(5, 1));
		panel2.setLayout(new GridLayout(5, 1));
		panel3.setLayout(new GridLayout(5, 1));
		panel4.setLayout(new GridLayout(5, 1));
		panel5.setLayout(new GridLayout(5, 1));
		//panelList[1].add
		panelList[1].add(newGame);
		panelList[2].add(cont);
		panelList[3].add(settings);
		panelList[4].add(exit);

		panelList[6].add(addAttack);
		panelList[6].add(minusAttack);
		panelList[7].add(addHealth);
		panelList[7].add(minusHealth);
		panelList[8].add(addSpeed);
		panelList[8].add(minusSpeed);
		panelList[9].add(finalize);

		panelList[11].add(sizeButton);
		panelList[12].add(difficultyButton);
		panelList[14].add(backButton);

		panelList[16].add(newSaveOneButton);
		panelList[17].add(newSaveTwoButton);
		panelList[18].add(newSaveThreeButton);
		panelList[19].add(toMainMenu);

		panelList[20].add(contLabel);
		panelList[21].add(loadSaveOneButton);
		panelList[22].add(loadSaveTwoButton);
		panelList[23].add(loadSaveThreeButton);
		panelList[24].add(toMainMenu2);

		for(int i = 0; i < 5; i++){
			panelList[i].add(labels1[i]);
			panel1.add(panelList[i]);
		}
		for(int i = 5; i < 10; i++){
			panelList[i].add(labels2[i-5]);
			panel2.add(panelList[i]);
		}
		for(int i = 10; i < 15; i++){
			panelList[i].add(labels4[i-10]);
			panel3.add(panelList[i]);
		}
		for(int i = 20; i < 25; i++){
			panel4.add(panelList[i]);
		}
		for(int i = 15; i < 20; i++){
			panel5.add(panelList[i]);
		}
		//frame.add(panel2);
		//panel2.setVisible(false);
		//frame.add(panel3);
		//panel3.setVisible(false);
		frame.add(panel1);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public class MenuButtonClick implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//System.out.println(event.getSource().toString());
			if(!(event.getSource() instanceof MenuButton)) {return;}
			MenuButton b = (MenuButton)event.getSource();
			if(b.getId() == "addAttack"){
				if(total > 0){
					attack++;
					total--;
					updateText();
				}
			}
			else if(b.getId() == "minusAttack"){
				if(attack > 0){
					attack--;
					total++;
					updateText();
				}
			}
			else if(b.getId() == "addHealth"){
				if(total > 0){
					health++;
					total--;
					updateText();
				}
			}
			else if(b.getId() == "minusHealth"){
				if(health > 0){
					health--;
					total++;
					updateText();
				}
			}
			else if(b.getId() == "addSpeed"){
				if(total > 0){
					speed++;
					total--;
					updateText();
				}
			}
			else if(b.getId() == "minusSpeed"){
				if(speed > 0){
					speed--;
					total++;
					updateText();
				}
			}
			else if(b.getId() == "finalize"){

				try{
					PrintWriter theWriter = new PrintWriter(new File(saveFileName));
					theWriter.println(attack);
					theWriter.println(health);
					theWriter.println(speed);
					theWriter.println(total);
					theWriter.close();
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				} catch(IOException g){

				}
			}
			else if(b.getId() == "newGame"){
				attack = 0;
				health = 0;
				speed = 0;
				total = 20;
				frame.add(panel5);
				panel5.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel4 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel2 != null){
					panel2.setVisible(false);
					frame.remove(panel2);
				}
				updateText();
			}
			else if(b.getId() == "newSaveOne"){
				saveFileName = "StatSaved1.txt";
				frame.add(panel2);
				panel2.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel4 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}
				try{
					PrintWriter theWriter = new PrintWriter(new File("StoreSaveName.txt"));
					theWriter.println(saveFileName);
					theWriter.close();
				} catch(IOException g){

				}
			}
			else if(b.getId() == "newSaveTwo"){
				saveFileName = "StatSaved2.txt";
				frame.add(panel2);
				panel2.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel4 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}
				try{
					PrintWriter theWriter = new PrintWriter(new File("StoreSaveName.txt"));
					theWriter.println(saveFileName);
					theWriter.close();
				} catch(IOException g){

				}
			}
			else if(b.getId() == "newSaveThree"){
				saveFileName = "StatSaved3.txt";
				frame.add(panel2);
				panel2.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel4 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}
				try{
					PrintWriter theWriter = new PrintWriter(new File("StoreSaveName.txt"));
					theWriter.println(saveFileName);
					theWriter.close();
				} catch(IOException g){

				}
			}
			else if(b.getId() == "cont"){
				frame.add(panel4);
				panel4.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel2 != null){
					panel2.setVisible(false);
					frame.remove(panel2);
				}
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}
			}
			else if(b.getId() == "loadSaveOne"){

				try{
					Scanner fileReader = new Scanner(new File("StatSaved1.txt"));
					attack = fileReader.nextInt();
					health = fileReader.nextInt();
					speed = fileReader.nextInt();
					total = fileReader.nextInt();
					//screenSize = fileReader.nextInt();
					//difficulty = fileReader.nextLine();
				}catch(IOException e) {
					attack = 0;
					health = 2;
					speed = 0;
					total = 20;
					//screenSize = 1;
					//difficulty = "normal";
				}
				updateText();
			}
			else if(b.getId() == "loadSaveTwo"){

				try{
					Scanner fileReader = new Scanner(new File("StatSaved2.txt"));
					attack = fileReader.nextInt();
					health = fileReader.nextInt();
					speed = fileReader.nextInt();
					total = fileReader.nextInt();
					//screenSize = fileReader.nextInt();
					//difficulty = fileReader.nextLine();
				}catch(IOException e) {
					attack = 0;
					health = 2;
					speed = 0;
					total = 20;
					//screenSize = 1;
					//difficulty = "normal";
				}
				updateText();
			}
			else if(b.getId() == "loadSaveThree"){

				try{
					Scanner fileReader = new Scanner(new File("StatSaved3.txt"));
					attack = fileReader.nextInt();
					health = fileReader.nextInt();
					speed = fileReader.nextInt();
					total = fileReader.nextInt();
					//screenSize = fileReader.nextInt();
					//difficulty = fileReader.nextLine();
				}catch(IOException e) {
					attack = 0;
					health = 2;
					speed = 0;
					total = 20;
					//screenSize = 1;
					//difficulty = "normal";
				}
				updateText();
			}
			else if(b.getId() == "settings"){
				frame.add(panel3);
				panel3.setVisible(true);
				if(panel1 != null){
					panel1.setVisible(false);
					frame.remove(panel1);
				}
				if(panel2 != null){
					panel2.setVisible(false);
					frame.remove(panel2);
				}
				if(panel4 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}

			}
			else if(b.getId() == "exit"){
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
			else if(b.getId() == "sizeButton"){
				if(screenSize < 2){
					screenSize++;
				}
				else{
					screenSize = 1;
				}
				frame.setSize(width*screenSize, height*screenSize);
				updateText();
			}
			else if(b.getId() == "difficultyButton"){
				if(difficultyNum == 2){
					difficulty = "hard";
					difficultyNum = 3;
				}
				else if(difficultyNum == 3){
					difficulty = "easy";
					difficultyNum = 1;
				}
				else{
					difficulty = "normal";
					difficultyNum = 2;
				}
				updateText();
			}
			else if(b.getId() == "backButton"){
				frame.add(panel1);
				panel1.setVisible(true);
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel2 != null){
					panel2.setVisible(false);
					frame.remove(panel2);
				}
				if(panel3 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}
				try{
					PrintWriter theWriter = new PrintWriter(new File("Settings.txt"));
					theWriter.println(screenSize);
					theWriter.println(difficultyNum);
					theWriter.close();
				}
				catch (IOException e){

				}

			}
			else if(b.getId() == "toMainMenu"){
				frame.add(panel1);
				panel1.setVisible(true);
				if(panel3 != null){
					panel3.setVisible(false);
					frame.remove(panel3);
				}
				if(panel2 != null){
					panel2.setVisible(false);
					frame.remove(panel2);
				}
				if(panel3 != null){
					panel4.setVisible(false);
					frame.remove(panel4);
				}
				if(panel5 != null){
					panel5.setVisible(false);
					frame.remove(panel5);
				}

			}
		}
	}
	public void updateText(){
		labels2[0].setText("Choose your character's atributes. Total Points: " + String.valueOf(total));
		labels2[1].setText("Base attack: " + String.valueOf(attack));
		labels2[2].setText("Base health: " + String.valueOf(health));
		labels2[3].setText("Base speed:  " + String.valueOf(speed));
		labels4[1].setText("Screen size: " + String.valueOf(screenSize));
		labels4[2].setText("Difficulty: " + difficulty);
		contLabel.setText("total " + String.valueOf(total) + "Base attack: " + String.valueOf(attack) + "Base health: " + String.valueOf(health) + "Base speed:  " + String.valueOf(speed));
	}
}
