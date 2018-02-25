# PottyMouth
Potty Mouth. A branch from the original Court Counter app made during the Udacity Grow With Google Android Nanodegree program.

The original app required students to make a score counter app. This app takes things on step further and turns it into a game to keep track of who is the biggest potty mouth. Instead of a swear jar. You now have a swear app!

This comes complete with sound effects and random message generators. The code makes good use of resource files instead of hard coding strings everywhere. This allows for greater app portability and custom branding along with easier localization.

The app also takes advantage of a two page layout, grabbing user input from a EditText element and making use of variables across activities. There is also use of MediaPlayer to play sound effects.

The UI has a locked orientation to prevent the background image from not looking as it should. This requires modification of the manifest file to do so.

The app also makes use of conditional statements and object creation which was not discussed yet, however I was on a roll.

A random generator is used to select a random string from the resources file called array.xml One can easily create more random messages or take advantage of this to reskin the entire app into a different game.

For those who wish to try the app out, I have included an ready to go APK file to install on your device. Just drag and drop to your device and click to install. 

Note that this app is optimized for xxhdpi screens in a vertical orientation. It is also rotation locked to prevent distortion of the layout graphics. Future releases will include reactive designs.

# KNOWN ISSUES:

Total game keeper keeps increasing games won even after the game has ended. [FIXED]

Game does not auto start background music loop when it ends.

Game does not terminate on two back clicks.
