
/*
 * Copyright Adrian Raff 2018.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.example.android.courtcounter;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



import java.util.Random;
public class MainActivity extends AppCompatActivity {

    /**
     * Random generator
     */

    public static final Random rgenerator = new Random();

    /**
     * Set up a variable to keep score for team A
     */

    int scoreTeamA = 0;
    int winsTeamA = 0;
    /**
     * Set up a variable to keep score for team B
     */

    int scoreTeamB = 0;
    int winsTeamB = 0;
    /**
     * Set up name variables for the players and grab them from the EditText on previous activity
     *
     */

    String playerTwo = Main2Activity.etPlayer2.getText().toString();
    String playerOne = Main2Activity.etPlayer1.getText().toString();
    /**
     * This string will be used to store winner message.
     */
    String winnerString;
    /**
     * Sound effects
     */
    public MediaPlayer mpToiletFlush;
    public MediaPlayer mpCensorBeep;
    public MediaPlayer mpSadLoser;
    public MediaPlayer mpBgMusic;

    /**
     * Variables for text fields.
     */
    public TextView gamesWon;
    public TextView winner;
    public TextView scoreViewA;
    public TextView scoreViewB;
    public TextView nameViewA;
    public TextView nameViewB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Start the background music
        bgMusic();

        // Call our first methods to display player names
        displayPlayerTwoName(playerTwo);
        displayPlayerOneName(playerOne);

        //init variable for games won message
        gamesWon = findViewById(R.id.text_games_won);

        //init variable for winner message
        winner = findViewById(R.id.text_who_is_winner);

        //init score variables
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);

        //init player name variables
        //nameViewA = findViewById(R.id.team_a_tag);
       // nameViewB = findViewById(R.id.team_b_tag);
    }

    /**
     * Displays the given score for team A.
     */

    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Display name of player two
     * @param name name of players from
     */
    public void displayPlayerOneName(String name) {
        nameViewA = findViewById(R.id.team_a_tag);
        nameViewA.setText(String.valueOf(name));
    }

    /**
     *
     * Increase score by 3 for team A
     * IF score is at winning point then do not increase any more. This routine
     * follows in all the rest of the button actions.
     *
     */
    public void threePointsForTeamA(View v) {

        if (scoreTeamA >= 50 || scoreTeamB >= 50) {
            scoreTeamA = scoreTeamA;
        } else {
            scoreTeamA = scoreTeamA + 3;
            displayForTeamA(scoreTeamA);
            playCensorBeep();
            checkScore();
        }

    }

    /**
     * Increase score by 2 for team A
     */
    public void twoPointsForTeamA(View v) {
        if (scoreTeamA >= 50 || scoreTeamB >= 50) {
            scoreTeamA = scoreTeamA;
        } else {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
            playCensorBeep();
            checkScore();
        }
    }


    /**
     * Increase score by 1 for team A
     */
    public void onePointForTeamA(View v) {
        if (scoreTeamA >= 50 || scoreTeamB >= 50) {
            scoreTeamA = scoreTeamA;
        } else {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA);
            playCensorBeep();
            checkScore();
        }

    }


    /**
     * Displays the given score for Team B
     * @param score player total score
     */
    public void displayForTeamB(int score) {
             scoreViewB.setText(String.valueOf(score));
    }

    /**
     * Display name of player two
     */
    public void displayPlayerTwoName(String name) {
        nameViewB = findViewById(R.id.team_b_tag);
        nameViewB.setText(String.valueOf(name));
    }

    /**
     * Increase score by 3 for team B
     */

    public void threePointsForTeamB(View v) {
        if (scoreTeamB >= 50 || scoreTeamA >= 50) {
            scoreTeamB = scoreTeamB;

            displayGamesWon();
        } else {
            scoreTeamB = scoreTeamB + 3;
            displayForTeamB(scoreTeamB);
            playCensorBeep();
            checkScore();
        }

    }

    /**
     * Increase score by 2 for team B
     */

    public void twoPointsForTeamB(View v) {
        if (scoreTeamB >= 50 || scoreTeamA >= 50) {
            scoreTeamB = scoreTeamB;
        } else {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
            playCensorBeep();
            checkScore();
        }

    }

    /**
     * Increase score by 1 for team B
     */

    public void onePointForForTeamB(View v) {
        if (scoreTeamB >= 50 || scoreTeamA >= 50) {
            scoreTeamB = scoreTeamB;
        } else {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamB(scoreTeamB);
            playCensorBeep();
            checkScore();
        }

    }

    /**
     * Reset the game
     */

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = "Ready to play again!";
        toiletFlush();
        bgMusic();
        winner.setText(String.valueOf(winnerString));
    }

    /**
     * Players eat a Tide Pod washes out that potty mouth and resets score
     */

    public void resetTeamA(View v) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = playerOne + " " + getString(R.string.playerReset);
        toiletFlush();
        winner.setText(String.valueOf(winnerString));
    }

    public void resetTeamB(View v) {
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        winnerString = playerTwo + " " + getString(R.string.playerReset);
        toiletFlush();
        winner.setText(String.valueOf(winnerString));
    }

    /**
     * These methods are to play sound effects when button is clicked. I used MediaPlayer here.
     * TDL: There is an odd bug here where continuous clicks on buttons cause sound to stop working.
     */

    // Main buttons sound effect
    public void playCensorBeep() {

        if (mpCensorBeep != null) {
            mpCensorBeep.stop();
            mpCensorBeep.release();
        }

        mpCensorBeep = MediaPlayer.create(getApplicationContext(), R.raw.censorbeep);
        mpCensorBeep.start();


    }

    // General sound effect
    public void toiletFlush() {

        if (mpToiletFlush != null) {
            mpToiletFlush.stop();
            mpToiletFlush.release();
        }

        mpToiletFlush = MediaPlayer.create(getApplicationContext(), R.raw.toiletflush);
        mpToiletFlush.start();

    }

    // Loser sound effect
    public void sadLoser() {
        if (mpSadLoser != null) {
            mpSadLoser.stop();
            mpSadLoser.release();
        }

        mpSadLoser = MediaPlayer.create(getApplicationContext(), R.raw.sadloser);
        mpSadLoser.start();


    }

    // Background music
    public void bgMusic() {
        if (mpBgMusic != null) {
            mpBgMusic.stop();
            mpBgMusic.release();
        }

        mpBgMusic = MediaPlayer.create(getApplicationContext(), R.raw.bgmusic);
        mpBgMusic.start();

    }

    /**
     * This method is used to check for a winner (or loser in this case) When someone loses, play the sad loser sound effect, stop the background music
     * and display who lost.
     */

    public void checkScore() {

        String[] myMessage;

        Resources res = getResources();

        myMessage = res.getStringArray(R.array.loserMessageArray);

        String randomString = myMessage[rgenerator.nextInt(myMessage.length)];

        // Check to see if team a lost if not go to next
        if (scoreTeamA >= 50) {
            /**
             *  The strings here are stored in resources so we can change them real easy later on. See strings.xml to see how this works.
             *  I basically use getString to gets a value from resources which is the strings called winString1 - etc. I then concatenate
             *  them into one sentence with the player names in variable form             */

            scoreTeamA = scoreTeamA + 0;

            winnerString = getString(R.string.winString1) + " " + playerOne + " " + getString(R.string.winString3) + " " + randomString;
            winner.setText(String.valueOf(winnerString));
            winsTeamA = winsTeamA + 1;
            sadLoser();
            mpBgMusic.stop();
            displayGamesWon();
            return;

        }
        // check to see if team b lost if not go to next
        if (scoreTeamB >= 50) {

            scoreTeamB = scoreTeamB + 0;
            winnerString = getString(R.string.winString1) + " " + playerTwo + " " + getString(R.string.winString3) + " " + randomString;
            winner.setText(String.valueOf(winnerString));
            winsTeamB = winsTeamB + 1;
            sadLoser();
            mpBgMusic.stop();
            displayGamesWon();



        } else {
            // If no one has lost yet display a message stating the game is still on
            winnerString = getString(R.string.winString2);
            winner.setText(String.valueOf(winnerString));
        }


    }

    public void displayGamesWon() {
        String gamesWonMessage = getString(R.string.totalScoreStringA) + playerOne + getString(R.string.totalScoreStringB) + winsTeamA + "\n" + getString(R.string.totalScoreStringA) + playerTwo + getString(R.string.totalScoreStringB) + winsTeamB;
        gamesWon.setText(String.valueOf(gamesWonMessage));

    }
}


