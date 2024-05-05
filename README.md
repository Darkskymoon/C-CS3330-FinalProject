# C-CS3330-FinalProject

For our final project in Object Oriented, we decided to do an RPG inspired fight simulator. The user can play as a character they create against enemies with random weapons. The user can create custom enemies and custom weapons as well. After each round of combat, a user can decide to loot the enemy's weapon and use that to battle instead. Music is played throughout most of the screens to add some ambience. Additionally, any previous combat can be replayed. 

The original scope of our project was too large, so we narrowed it down to the features listed above. If we had decided to go for a non-gui approach we could have developed more of the original features. But despite starting on time, we just couldn't reach the full scope of the project. Ultimately however, the program functions as a battle simulator and does do the things listed above.

To save Enemies, battles, and Players a singleton logger pattern is used to populate/read json files. 

MVC design pattern was attempted for the actual GUI.

Strategy Design pattern was used for weapon attacking.

Factory Method design pattern was used to create entities and weapons.

Adapter design pattern was used for GSON.

# Authors:
- Zoe:
-----------------------
Designed all of the logging mechanisms including battle, enemy, character, and the GSON adapter. Besides the logging mechanisms, they designed the Battles class and helped implement actual combat. They also worked on entities, enemies, weaponFactoryMethod, AbstractWeapon, MagicWeapon, and SwordWeapon. Furthermore, they wrote the readme. Ultimately they helped on almost every part of the project except for audio and the views.
- Ryan:
-------------------------------
Designed the MainController and many of the views such as the MainMenuView, CreditMenuView, and others. Additionally, implemented the weapon code which would utilize a strategy design pattern with the entities. Also set up combat to actually attack the opponent. Helped with a little bit of everything on the project. Additionally wrote a lot of tests for the main controller and views. 
- Ando:
--------------------------------
Designed an audio player that wraps the Clip and AudioSystem library to play music or sounds and stop them on demand. Designed  GameInfoView and PreviousBattlesView along with the logic to queue a previous battle bot not overwrite the character save. Randomizing enemy weapons. Additionally helped a little with the win screen and pick up weapon logic.
- John:
--------------------------------
Create custom character, create custom weapon, win screen, lose screen, TODO

# Audio Attributions
- Battle Music: Anime Fight Music Loop #1 by Sirkoto51 -- https://freesound.org/s/414214/ -- License: Attribution 4.0

- Main Game Music: BAS-23022014 - Game Loop 2.mp3 by B_Lamerichs -- https://freesound.org/s/220325/ -- License: Creative Commons 0 

- Character Menu Sound: Smixkit-medieval-show-fanfare-announcement-226  -- https://mixkit.co/free-sound-effects/game/?page=2
