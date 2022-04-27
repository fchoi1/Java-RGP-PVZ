//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// Plants vs Zombies RPG 2015 Cadawas //////////////////////////////////////////////////
///////////////////////////////////////// Version 2.01.01.01 /////////////////////////////////////////////////////////
////////////////////////// Based on the Real PVZ Game by Pop Cap Games ///////////////////////////////////////////////
///////////////////////////////// Created by Fabio Choi (ISC 4U1) ////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


import hsa.*;
import java.awt.*;

// Extra imports needed for a picture file

import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;

public class RPGgame{
  public static void main(String[]args){
    Console con = new Console(31,102);
    Console hud = new Console(20,28,20,"hud");
    
    char chrKey = ' ';
    
    //Title Page and HUD Variables 
    
    BufferedImage theCanvas2 = null;
    BufferedImage theCanvas = null;
    char chrMenu = ' ';
    char chrBack = ' ';
    int intPlay = 0;
    int intCount;
    
    //Map Variables
    
    String strMap[][];
    strMap = new String[20][20];
    BufferedImage map = null;
    BufferedImage player = null;
    
    char chrPlayer = ' ';
    char chrMap = ' ';
    int intX = 1;
    int intY = 1;
    
    int intBack =1;
    int intFront = 1;
    int intLeft = 1;
    int intRight =1;
    
    //Chest Variable
    
    int intItems;
    int intChest;
    int intRan;
    int intMaxHealth = 50;
    int intLily = 0;
    int intToggle = 0;//Toggle the lily pad cheat on and off
    
    //Battle Scene Variables
    
    int intEmpty; //for loop to print empty lawn
    int intArray[];
    intArray = new int[7];
    intArray[0] =0; //Win
    intArray[1] = 2; //intBomb
    intArray[2] = 2; //intFreeze
    intArray[3] = 50;//intHealth
    intArray[4] = 10;//intZombie Attack
    intArray[5] = 3;//int Attack
    intArray[6] = 5;//int Zombie Speed
    
    //Game Over Variable and Quit Variable
    
    int intWinFrame;
    int intGame = 0;
    int intQuit = 0;
    
    
    //*
    //Drawing Title Page Image 
    //*
    
    //Setting up Canvas to print images on
    
    //Used for Hud Console
    theCanvas2 = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D g = theCanvas2.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,1024,768); 
    Font font = new Font("Comic Sans MS", Font.BOLD, 17);
    g.setFont(font);
    
    //Use for main Console
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    
    
    //
    //Drawing Main Title and Preparing to load/////////////////////////////////////////////////////////////////////////
    //
    
    rpg.loadingPage(con);
    
    //*
    //Non-Real time character input for Main menu/////////////////////////////////////////////////////////////////////
    //*
    
    chrKey = con.getChar();
    
    //Clear screen to load map
    
    graphics.clearRect(0,0,1024,768);
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    con.clear();
    
    
    //*
    //Main Menu//////////////////////////////////////////////////////////////////////////////////////////////////////
    //*
    
    while(intQuit!=1){  
      graphics.drawImage(rpg.drawPic("./images/menuhud.png"),10,10,null);
      con.drawImage(theCanvas, 0, 0, null);
      while(intPlay == 0){ //Will exit loop if you decide to play or quit
        chrMenu = rpg.menu(con);
        if(chrMenu == 'q'){
          intQuit = 1;
          intPlay = 1;
        }else if(chrMenu == 'p'){
          intPlay = 1;
        }else{
          while(chrBack != 'b'){
            if(chrMenu == 'a'){
              //print Credits and about the game
              graphics.drawImage(rpg.drawPic("./images/pvztitle.png"),10,10,null);
              for(intCount = 0; intCount <580;intCount ++){
                graphics.drawImage(rpg.drawPic("./images/about.png"),160,530-intCount*2,null);
                con.drawImage(theCanvas, 0, 0, null);
              }
                  chrBack = con.getChar();
            }else{
              con.drawImage(rpg.printMenu(chrMenu),10,10,null);
            }
            chrBack = con.getChar();
          } 
          //reset variables
          chrBack = ' ';
          chrMenu = ' ';
          intPlay = 0;
          
          //Clear the screen 
          
          graphics.fillRect(0,0,1024,768);
          graphics.drawImage(rpg.drawPic("./images/menuhud.png"),10,10,null);
          con.drawImage(theCanvas, 0, 0, null);
        }
      }
      //reset more variables to make sure the loops works again
      chrBack = ' ';
      chrMenu = ' ';
      intPlay = 0;
      //If you press quit you close game
      if (intQuit == 1){
        con.close();
        hud.close();
      }else{
                
        //Clear the Screen to load map
        
        graphics.clearRect(0,0,1024,768);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,1024,768);
        con.clear();
        
        chrMenu = ' ';
        intGame = 0;
        
        //Choosing which map to play 1, 2, ,3
        chrMap = ' ';
        while(chrMap != '1'&&chrMap != '2'&&chrMap != '3'){
          graphics.drawImage(rpg.drawPic("./images/map.png"),10,10,null);
          con.drawImage(theCanvas, 0, 0, null);
          if(con.isCharAvail() == true){
            chrMap = con.getChar();
          }
        }
      
        //reset variables when you lose 
        
        intArray [0] =0; //Win
        intArray[1] = 2; //intBomb
        intArray[2] = 2; //intFreeze
        intArray[3] = 50;//intHealth
        intArray[4] = 5;//intZombie Attack
        intArray[5] = 0;//int Attack
        intArray[6] = 5;//int Zombie Speed
        intLily = 0;
        intMaxHealth = 50;
        
        //*
        //Loading Maps to Play///////////////////////////////////////////////////////////////////////////////////////////
        //*
        
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        hud.drawImage(theCanvas2, 0, 0, null);
        strMap = rpg.loadValues("map"+chrMap);   
        map = rpg.loadMap("map"+chrMap);
        graphics.drawImage(map,10,10,null);
        graphics.drawImage(rpg.drawPic("./images/playerBack"+intBack+".png"),10+intX*40,10+intY*30,null);
         
        con.drawImage(theCanvas, 0, 0, null);
        
        //
        //Real Time input for character to move around map./////////////////////////////////////////////////////////////
        //
        
        
        
        while(intGame != 1){
          
          while(chrPlayer ==' '){
            
            graphics.drawImage(map,10,10,null);
            
            hud.drawImage(theCanvas2, 0, 0, null);
            if(con.isCharAvail() == true){
              chrPlayer = con.getChar();
              chrPlayer=Character.toLowerCase(chrPlayer);
              //Players  cannot walk into trees
              if(chrPlayer == 'w'){
                if (!strMap[intY-1][intX].equals("t")){
                  intY=intY-1;                   
                }
                intBack = intBack + 1;
                if(intBack >2){
                  intBack = 1;
                }
                graphics.drawImage(rpg.drawPic("./images/playerBack"+intBack+".png"),10+intX*40,10+intY*30,null);
                player = rpg.drawPic("./images/playerBack"+intBack+".png");
              }else if(chrPlayer == 's'){
                if (!strMap[intY+1][intX].equals("t")){
                  intY = intY + 1;              
                }
                intFront = intFront + 1;
                if(intFront >2){
                  intFront = 1;
                }
                graphics.drawImage(rpg.drawPic("./images/playerFront"+intFront+".png"),10+intX*40,10+intY*30,null);
                player = rpg.drawPic("./images/playerFront"+intFront+".png");
              }else if(chrPlayer =='a'){
                if (!strMap[intY][intX-1].equals("t")){
                  intX = intX-1;
                }  
                intLeft = intLeft + 1;
                if(intLeft>2){
                  intLeft = 1;
                }
                graphics.drawImage(rpg.drawPic("./images/playerLeft"+intLeft+".png"),10+intX*40,10+intY*30,null);
                player = rpg.drawPic("./images/playerLeft"+intLeft+".png");
              }else if(chrPlayer == 'd'){
                if (!strMap[intY][intX+1].equals("t")){
                  intX = intX+1;
                }
                intRight = intRight + 1;
                if(intRight >2){
                  intRight = 1;
                }
                graphics.drawImage(rpg.drawPic("./images/playerRight"+intRight+".png"),10+intX*40,10+intY*30,null);
                player = rpg.drawPic("./images/playerRight"+intRight+".png");
                
                //Cheats 
                
              }else if (chrPlayer == '1'){
                intArray[5] = intArray [5] + 10;
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
              }else if (chrPlayer == '2'){
                intMaxHealth = 80;
                intArray[3] = 80;
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
              }else if(chrPlayer == '3'){
                intArray[2] = intArray[2] + 10;
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
              }else if(chrPlayer == '4'){
                intArray[1] = intArray [1] + 10;
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
                //This is an L not a 1
              }else if(chrPlayer == 'l'){
                if(intToggle == 1){
                  intLily = 0;
                  intToggle = 0;
                }else{
                  intToggle = 1;
                  intLily = 1;
                }
                
                
                
                
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
              }else{
                // In case another key is press, plays back previous player image.
                graphics.drawImage(player,10+intX*40,10+intY*30,null);
              }
              //Player cannot cross the edge of the map
              
              if(intX <=0){
                intX = 0;
              }else if(intX >=19){
                intX = 19;
              }
              if(intY<=0){
                intY=0;
              }else if(intY>=19){
                intY = 19;
              }
              g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            }

          }
            chrPlayer = ' ';
            con.drawImage(theCanvas, 0, 0, null);
          
          
          //
          // Players walks into water, game over without lily ///////////////////////////////////////////////////////////////
          //
          
          if(strMap[intY][intX].equals("w")&& intLily == 0){
            con.clear();
            intGame = 1;
            intX = 1;
            intY = 1;
          }
          
          //
          //Player gets 10 health on health packs //////////////////////////////////////////////////////////////////////
          //
          
          if(strMap[intY][intX].equals("h")&&intArray[3]!=intMaxHealth){
            intArray[3] = intArray[3] + 10;
            strMap[intY][intX]="g";
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            hud.drawImage(theCanvas2, 0, 0, null);
          }else if(strMap[intY][intX].equals("h")){
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            hud.drawImage(theCanvas2, 0, 0, null);
          }
          
          //
          // Players Land on Chest and Get Random items //////////////////////////////////////////////////////////////////
          //
          
          
          if(strMap[intY][intX].equals("c")){
            intChest = (int)(Math.random()*5+1);
            for(intItems = 0; intItems<intChest;intItems++){
              intRan =(int)(Math.random()*5+1);
              g.setColor(Color.BLACK);
              g.drawString("You found: ",180,180);
              if(intRan == 1){        
                intArray[5] = intArray[5] + 1;//ATTACK
                g.drawImage(rpg.drawPic("./images/attackSymbol.png"),142,60,null);
              }else if(intRan == 2){ 
                intArray[4] = intArray[4] + 1;//ZOM ATTACK
              }else if(intRan == 3){
                g.drawImage(rpg.drawPic("./images/zomattackSymbol.png"),202,60,null);
                intArray[2] = intArray[2] + 1;//FREEZE
                g.drawImage(rpg.drawPic("./images/freezebombSymbol.png"),20,60,null);
              }else if(intRan ==4){
                intArray[1] = intArray[1]+1;//BOMB
                g.drawImage(rpg.drawPic("./images/bombSymbol.png"),85,60,null);
              }else if(intRan ==5){
                g.drawImage(rpg.drawPic("./images/healthSymbol.png"),265,60,null);
                intMaxHealth = intMaxHealth+10;
                if(intMaxHealth > 80){
                  intMaxHealth = 80;
                }
              }       
            }
            hud.drawImage(theCanvas2, 0, 0, null);
            strMap[intY][intX] = "g";
          }
          
          //*
          //Battle Scene/////////////////////////////////////////////////////////////////////////////////////////////////
          //*
                    
          if (strMap[intY][intX].equals("e")){
            graphics.clearRect(0,0,1024,768);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0,0,1024,768);
            con.clear();
            
            for(intEmpty = 0; intEmpty < 37; intEmpty ++){        
              graphics.fillRect(0,0,1024,768);
              graphics.drawImage(rpg.drawPic("./images/lawnEmpty.png"),-intEmpty*10,10,null);
              //  rpg.pause(60);        
              con.drawImage(theCanvas, 0, 0, null);
            }
            while (intArray[0]==0){
              intArray =  rpg.battleScene(con,hud,intArray[1],intArray[2],intArray[5],intArray[4],intArray[3],intArray[6],intMaxHealth);
              //0 = Win
              //1 = Bomb
              //2 = Freeze
              //3 = Health
              //4 = Zombie Attack
              //5 = Attack
              //6 = Zombie Speed
              if (intArray[0] == 1){
                strMap[intY][intX]=("g");
                intArray[6] = intArray[6] + 2;
              }else if (intArray[0] == 0){
                intGame = 1;
                intArray[0]= 1;
              }
            }
            graphics.clearRect(0,0,1024,768);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0,0,1024,768);
            graphics.drawImage(map,10,10,null);
            graphics.drawImage(rpg.drawPic("./images/playerBack"+intBack+".png"),10+intX*40,10+intY*30,null);
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            con.clear();
            hud.drawImage(theCanvas2, 0, 0, null);
            con.drawImage(theCanvas, 0, 0, null);
            intArray[0]=0;
          }
          
          //
          //BOSS BATTLE //////////////////////////////////////////////////////////////////////////////////////////
          //
          
           if (strMap[intY][intX].equals("b")){
             for(intEmpty = 0; intEmpty < 37; intEmpty ++){        
              graphics.fillRect(0,0,1024,768);
              graphics.drawImage(rpg.drawPic("./images/lawnEmpty.png"),-intEmpty*10,10,null);
              //  rpg.pause(60);        
              con.drawImage(theCanvas, 0, 0, null);
            }
             intArray = rpg.BossBattle(con,hud,intArray[1],intArray[2],intArray[5],intArray[3],intMaxHealth,intLily);
             intGame = 1;
            
            graphics.clearRect(0,0,1024,768);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0,0,1024,768);
            graphics.drawImage(map,10,10,null);
            graphics.drawImage(rpg.drawPic("./images/playerBack"+intBack+".png"),10+intX*40,10+intY*30,null);
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            con.clear();
            hud.drawImage(theCanvas2, 0, 0, null);
            con.drawImage(theCanvas, 0, 0, null);
        }
          
        }//Game Over bracket
      
        if (intArray[0] == 1){
          hud.clear();
          con.clear();
          //Zombies dancing animation
          
          for(intWinFrame = 1;intWinFrame<237;intWinFrame++){
            graphics.drawImage(rpg.drawPic("./images/win.png"),10,10,null);
            graphics.drawImage(rpg.drawPic("./images/groupdance_frame_0"+intWinFrame+".png"),280,250,null);
            con.drawImage(theCanvas, 0, 0, null);
            rpg.pause(30);
          }
        }else if(intArray[0] == 0){
          con.clear();
          hud.clear();
          graphics.drawImage(rpg.drawPic("./images/gameOver.png"),10,10,null);
          con.drawImage(theCanvas, 0, 0, null);
          rpg.pause(2000);
          graphics.clearRect(0,0,1024,768);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,1024,768);
        intX = 1;
        intY = 1;
       }
      }//Quit Bracket
    }//QuitBracket
    
    
    
  }//Class Brackets
}//Class Brackets
