Project Description
----------------------------------------------------------------------------------------------------------------------------------------
This project seeks to create a narrative driven dungeon/adventure game.  Each dungeon will be randomly generated, complete with an assortment of monsters, puzzles, traps, and treasure.  Players will be given difficult decisions to make, and if they choose correctly they will be greatly rewarded.  Players will play the game until their character dies, and will be awarded a score based on their performance.  Additional [future] features include:

•	Multiple dungeon environments.

•	Scaling difficulty.

•	NPCs and story elements.

•	Many collectables that contribute to overall score.

•	An intuitive and enjoyable combat and crafting system.

Installation
----------------------------------------------------------------------------------------------------------------------------------------
Clone repository into a file of your choosing.  Follow operating commands, detailed below, based on operating system.

Operating
----------------------------------------------------------------------------------------------------------------------------------------
All programs are present on the face of the repository. With the addition of Maze Block instructions, Lore instructions, and the projects font style vecna.otf.  To run the game, run the command displayed in brackets [ant run] with your terminal (if using Linux) or run GameEngine.java directly with an automated java compiler (such as J-grasp or eclipse) after compiling all java files.

For the sake of efficiency, it is recommended that you run the project through a Linux terminal with the appropriate ant commands displayed below:

•	[ant] – default command automatically compiles and runs the project.

•	[ant run] – run command automatically compiles and runs the project.

•	[ant compile] – automatically compiles the project, but does not run.

•	[ant clean] – automatically deletes all class files created through the compile and run processes.

Development
----------------------------------------------------------------------------------------------------------------------------------------
Each Java file is named per its function in the overall system.  Modification and additions to the maze aspect of the game are isolated in Maze.java, functions related to the player character are contained in Character.java, etc. 
The contents and purpose of each folder are as follows:

•	Generated Mazes: Used to contain the mapped images of static mazes for testing purposes.  Each successful creation of a static maze should be stored here, along with any data pertinent to that maze design.

•	Implemented Maze Blocks: Used to track and store Maze Block designs used in the maze’s random generation process.  

•	Unimplemented Maze Blocks: Used to track and store Maze Block designs used in the maze’s random generation process that have not yet been implemented into the code or system.  

•	Img: Used to store asset graphics and related content.

•	Trunk/docs: Stores documents relevant to the project.  Currently storing architectural presentations and instruction files.

Additional Notes
----------------------------------------------------------------------------------------------------------------------------------------
Future releases require the switch to Unity as a game engine.  Further development is advised against while using current assets and code.  Unity transfer scheduled to take place soon.  It is advised that current development be restricted to familiarizing yourself with current code and the Unity engine.
