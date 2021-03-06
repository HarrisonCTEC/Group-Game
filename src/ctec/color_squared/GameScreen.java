package ctec.color_squared;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main mode Color Squared
 * 
 * @author Mark Shamy
 * @author Nickolas Komarnitsky
 * @version 1.03 11/25/14 (c) Orange Lightning Research 2014
 */
public class GameScreen extends Activity {
	public int pink, magenta, red, yellow, orange, green, grue, blue, purple, reallyRed, reallyGreen, black;
	private Button[] tile = new Button[9],color = new Button[6];
	private Button hotButton;
	private int[] gameColors = new int[9];
	private int hotColor;
	private ArrayList<Integer> playerColors, gameGrid, notUsedColors;
	private int playerScore, level, playerProgress;
	private TextView scoreDisplay;
	private TextView levelDisplay;
	private MediaPlayer fail;
	private MediaPlayer levelUp;
	private MediaPlayer buttonClick;
	private Vibrator bad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);

		level = 1;
		playerScore = 0;
		playerProgress = 0;
		hotColor = 0;

		notUsedColors = new ArrayList<Integer>();
		playerColors = new ArrayList<Integer>();
		gameGrid = new ArrayList<Integer>();

		red = Color.rgb(255, 0, 0);
		pink = Color.rgb(255, 105, 180);
		magenta = Color.rgb(255, 0, 255);
		yellow = Color.rgb(255, 255, 0);
		orange = Color.rgb(255, 165, 0);
		green = Color.rgb(0, 128, 0);
		grue = Color.rgb(0, 96, 76);
		blue = Color.rgb(0, 0, 255);
		purple = Color.rgb(128, 0, 128);
		black = Color.rgb(255, 255, 255);

		gameColors[0] = pink;
		gameColors[1] = magenta;
		gameColors[2] = red;
		gameColors[3] = yellow;
		gameColors[4] = orange;
		gameColors[5] = green;
		gameColors[6] = grue;
		gameColors[7] = blue;
		gameColors[8] = purple;

		color[0] = (Button) findViewById(R.id.Color1);
		color[1] = (Button) findViewById(R.id.Color2);
		color[2] = (Button) findViewById(R.id.Color3);
		color[3] = (Button) findViewById(R.id.Color4);
		color[4] = (Button) findViewById(R.id.Color5);
		color[5] = (Button) findViewById(R.id.Color6);

		tile[0] = (Button) findViewById(R.id.tile1);
		tile[1] = (Button) findViewById(R.id.tile2);
		tile[2] = (Button) findViewById(R.id.tile3);
		tile[3] = (Button) findViewById(R.id.tile4);
		tile[4] = (Button) findViewById(R.id.tile5);
		tile[5] = (Button) findViewById(R.id.tile6);
		tile[6] = (Button) findViewById(R.id.tile7);
		tile[7] = (Button) findViewById(R.id.tile8);
		tile[8] = (Button) findViewById(R.id.tile9);

		notUsedColors.add(pink);
		notUsedColors.add(magenta);
		notUsedColors.add(red);
		notUsedColors.add(yellow);
		notUsedColors.add(orange);
		notUsedColors.add(green);
		notUsedColors.add(grue);
		notUsedColors.add(blue);
		notUsedColors.add(purple);
		
		fail =  MediaPlayer.create(this, R.raw.fail);
		levelUp = MediaPlayer.create(this, R.raw.levelup);
		buttonClick = MediaPlayer.create(this, R.raw.click);
		
		Vibrator bad = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);
		levelDisplay = (TextView) findViewById(R.id.levelDisplay);
		
		levelGenerator();
		updateGameGrid();
	}


	private void levelGenerator() 
	{
		for(int count = 0; count != 6; count++)
		{
			int randomIndex = (int) Math.ceil(Math.random() * 9);
			color[count].setBackgroundColor(gameColors[randomIndex]);
			playerColors.add(gameColors[randomIndex]);
		}
		
	}

	private void updateGameGrid() 
	{
		int randomTile = (int) Math.ceil(Math.random() * 9);
		int currentColor = playerColors.get(playerProgress);
		//Sets hot button and color
		hotButton = tile[randomTile];
		hotColor = currentColor;
		hotButton.setBackgroundColor(hotColor);
		
		fillGameGridList();
		hotButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				int available = 9;
				for(int x = 0; x != 9; x++, available--)
				{
					random = (int) Math.floor(Math.random()*available);
					tile[x].setBackgroundColor(playerColors.get(random));
					playerColors.remove(random);
				}
				onTilePress(true);
			}
		});
	}

	private void fillGameGridList() 
	{
		int counter = 0;
		while (counter < 9)
		{
			gameGrid.add(gameColors[counter]);
			counter++;
		}
		
		//Down below, this is supposed to take the hotColor out of the list and put it back in at the
		//correct index, according to the hotButton number.
		//int color = hotColor;
		//int index = gameGrid.indexOf(hotColor);
		//int newIndex = hotButton;
		
		//gameGrid.remove(index);
		//gameGrid.add(newIndex, color);
	}

	private void resetGrid() 
	{
		notUsedColors.clear(); //Fail safe
		fillNotUsedColors();
		gameGrid.clear();
		hotColor = 0;
	}

	private void onTilePress(boolean isHotButton) 
	{
		//Stop clocks
		if (isHotButton = true && playerProgress != 6) 
		{
			updateBoxes(playerProgress);
			playerProgress++;
			updateAndDisplayScore();
			updateGameGrid();
			buttonClick.start();
		}
		else if (isHotButton = true && playerProgress == 6)
		{
			
			//Makes new level
			playerProgress++;
			playerColors.clear();
			levelGenerator();
			updateGameGrid();
			levelDisplay.setText("Level: " + level);
			updateAndDisplayScore();
			levelUp.start(); //Sound
		}
		else
		{
			fail.start(); //Sound
			bad.vibrate(500);
			endGame();
		}
	}

	private void updateBoxes(int playerProg) 
	{
		if      (playerProg == 1) {color[0].setBackgroundColor(black);}
		else if (playerProg == 2) {color[1].setBackgroundColor(black);}
		else if (playerProg == 3) {color[2].setBackgroundColor(black);}
		else if (playerProg == 4) {color[3].setBackgroundColor(black);}
		else if (playerProg == 5) {color[4].setBackgroundColor(black);}
		else if (playerProg == 6) {color[5].setBackgroundColor(black);}
	}

	private void updateAndDisplayScore() 
	{
		scoreDisplay.setText("Score: " + playerScore);
	}

	private void endGame() 
	{
		//Vibrate 500 milliseconds
		Intent passScore = new Intent(GameScreen.this, GameOver.class);
		startActivityForResult(passScore, playerScore);
	}

	private void fillNotUsedColors() 
	{
		notUsedColors.add(pink);
		notUsedColors.add(magenta);
		notUsedColors.add(red);
		notUsedColors.add(yellow);
		notUsedColors.add(orange);
		notUsedColors.add(green);
		notUsedColors.add(grue);
		notUsedColors.add(blue);
		notUsedColors.add(purple);
	}
}
