# Toy Robot Simulator 

#### Instructions:
1. To start the application run the Main class
2. Enter the following commands to control the robot;




#### Commands:
The following commands are permitted;

- PLACE X,Y,F

- MOVE

- LEFT

- RIGHT

- REPORT


**PLACE** will put the toy robot on the table in position X,Y and facing NORTH,SOUTH, EAST or WEST

**MOVE** will move the toy robot one unit forward in the direction it is currently facing

**LEFT** and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot

**REPORT** will announce the X,Y and F of the robot. 


#### Example input and output;

- PLACE 0,0,NORTH
- MOVE
- REPORT
- > Output: 0,1,NORTH
- PLACE 0,0,NORTH
- LEFT
- REPORT
- >	Output: 0,0,WEST
- PLACE 1,2,EAST
- MOVE
- MOVE
- LEFT
- MOVE
- REPORT
- >	Output: 3,3,NORTH