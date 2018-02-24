/*
 * Copyright Adrian Raff 2018.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.example.android.courtcounter;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * This activity grabs the  player names and gives the players instructions.
 */
public class Main2Activity extends Activity {

    /**
     * Lets create some variables here. I am making one set of public statics to be accessible in the second activity to store players names
     * The string playersOutputText will later be used to concatenate the players names for a toast message
     */
    public static EditText etPlayer1, etPlayer2;
    Button btnSubmit;
    String playersOutputText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addListenOnButton();
    }

    public void addListenOnButton() {

        /**
         * Set the player variables to the EditText box contents
         */
        etPlayer1 = findViewById(R.id.edit_text_1);
        etPlayer2 = findViewById(R.id.edit_text_2);
        btnSubmit = findViewById(R.id.button_play);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            /**
             * Set up a toast message. Concatenate the players names into a single string to be presented to players then open the
             * next activity.
             */
            @Override
            public void onClick(View v) {

                /**
                 * TDL: set up error handling in case nothing is entered into boxes. Currently it defaults to Players One and Player Two for string values.
                 */

                // I used toast here to send a message to the players

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                playersOutputText = ("Get ready to play " + etPlayer2.getText().toString() + " and " + etPlayer1.getText().toString());

                Toast.makeText(Main2Activity.this, playersOutputText, Toast.LENGTH_SHORT).show();

                //play the sound effect
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.toiletflush);
                mp.start();
                // open the next activity and exit this one for now
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);


            }

        });

    }


}