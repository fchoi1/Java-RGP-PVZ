import hsa.*;
import java.awt.*;

// Extra imports needed for a picture file
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;

import java.awt.event.*;


public class rpg{
  
  public static void pause (int intMS){
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
  }
  
  //
  //Loading Game Maps to array list////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static String[][] loadValues(String strFilename){
    
    String strString[][];
    String strSplit[];
    String strCode;
    int intRow;
    int intCol;  
    TextInputFile filename;
    
    strString = new String[20][20];
    
    filename = new TextInputFile(strFilename +".csv");
    for(intRow = 0;intRow <20;intRow++){
      // graphics.println(" ");
      strCode = filename.readLine();
      for(intCol = 0;intCol<20;intCol++){
        strSplit = strCode.split(",");
        strString[intRow][intCol] = strSplit[intCol];
      }    
    }
    filename.close();
    return strString;
  }
  
  
  //
  //Loading Game Maps into buffered image to print/////////////////////////////////////////////////////////////////////
  //
  
  public static BufferedImage loadMap(String strFilename){
    BufferedImage theCanvas = null;
    String strString[][];
    String strSplit[];
    String strCode;
    int intRow;
    int intCol;  
    int intCount1;
    int intCount2;
    char chrMap;
    TextInputFile filename;
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    
    strString = new String[20][20];
    
    filename = new TextInputFile(strFilename +".csv");
    for(intRow = 0;intRow <20;intRow++){
      // graphics.println(" ");
      strCode = filename.readLine();
      for(intCol = 0;intCol<20;intCol++){
        strSplit = strCode.split(",");
        strString[intRow][intCol] = strSplit[intCol];
      }    
    }
    filename.close();
    
    for(intCount1 = 0; intCount1 <20;intCount1++){
      for(intCount2=0;intCount2 <20;intCount2++){
        chrMap = (strString[intCount1][intCount2]).charAt(0);
        if(chrMap == 't'){
          graphics.drawImage(rpg.drawPic("./images/tree.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'w'){
          graphics.drawImage(rpg.drawPic("./images/water.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'c'){
          graphics.drawImage(rpg.drawPic("./images/chest.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'h'){
          graphics.drawImage(rpg.drawPic("./images/health.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'g'){
          graphics.drawImage(rpg.drawPic("./images/grass.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'e'){
          graphics.drawImage(rpg.drawPic("./images/enemy.png"),1+(intCount2*40),10+(intCount1*30),null);
        }else if(chrMap == 'b'){
          graphics.drawImage(rpg.drawPic("./images/boss.png"),1+(intCount2*40),10+(intCount1*30),null);
        }
      }
    }
    
    return theCanvas;
  }
  
  
  
  //
  //Draw Image Command/////////////////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static BufferedImage drawPic(String strFilename){
    
    File strName;
    BufferedImage strBufferName;
    
    strName= null;
    strBufferName = null;
    
    try{
      strName= new File (strFilename);
      strBufferName = ImageIO.read(strName);
    }catch(IOException e){
    }
    return strBufferName;
    
    //con.drawImage(strBufferName,x,y,null);
  }
  
  
  
  
  
  
  //
  //Loading Page Method//////////////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static void loadingPage(Console con){
    
    BufferedImage theCanvas = null;
    int intLoadingBar;
    int intLoadingCircle = 0;
    
    //Setting up Canvas to print images on
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    
    //Drawing Main Title and Preparing to load
    
    while(intLoadingCircle < 40){
      for(intLoadingBar = 1;intLoadingBar < 7;intLoadingBar++){ 
        intLoadingCircle = intLoadingCircle + 1; 
        
        graphics.drawImage(rpg.drawPic("./images/pvztitle.png"),10,10,null);
        graphics.drawImage(rpg.drawPic("./images/LoadingBarBefore.png"),287,545,null);
        
        if(intLoadingCircle >= 0 &&intLoadingCircle<=10){
          graphics.drawImage(rpg.drawPic("./images/LoadingBar1.png"),295,526,null);
        }else if(intLoadingCircle>=10&&intLoadingCircle<=20){
          graphics.drawImage(rpg.drawPic("./images/LoadingBar1.png"),295,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar2.png"),340,526,null);
        }else if(intLoadingCircle>=20&&intLoadingCircle<=29){
          graphics.drawImage(rpg.drawPic("./images/LoadingBar1.png"),295,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar2.png"),340,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar3.png"),385,521,null);          
        }else if(intLoadingCircle>=29&&intLoadingCircle<=38){
          graphics.drawImage(rpg.drawPic("./images/LoadingBar1.png"),295,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar2.png"),340,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar3.png"),385,521,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar4.png"),430,525,null);
        }else if(intLoadingCircle>=38&&intLoadingCircle<=50){
          graphics.drawImage(rpg.drawPic("./images/LoadingBar1.png"),295,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar2.png"),340,526,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar3.png"),385,521,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar4.png"),430,525,null);
          graphics.drawImage(rpg.drawPic("./images/LoadingBar5.png"),481,521,null);
        }else{
        }
        
        //Animation of the Green Grass Circle on Loading Bar
        
        graphics.drawImage(rpg.drawPic("./images/LoadingBarCircle"+intLoadingBar+".png"),287+(intLoadingCircle*5),512,null);
        con.drawImage(theCanvas, 0, 0, null);
        rpg.pause(60);
      }
    }
    
    //Drawing finished loading bar and title to canvas
    
    graphics.drawImage(rpg.drawPic("./images/pvztitle.png"),10,10,null);
    graphics.drawImage(rpg.drawPic("./images/LoadingBarFinal.png"),261,510,null);
    con.drawImage(theCanvas, 0, 0, null);
  }
  
  
  
  
  //
  //Determining Plant Position/////////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static int plantY(char chrPlant,int intPlantDir){
    
    if(chrPlant == 'w'){
      intPlantDir = intPlantDir - 110;
      return intPlantDir; 
    }else if (chrPlant == 's'){
      intPlantDir = intPlantDir + 110;
      return intPlantDir; 
    }else{
      return intPlantDir; 
    }
  }
  
  public static int plantX(char chrPlant, int intPlantDir1 ){
    
    if(chrPlant == 'a'){
      intPlantDir1 = intPlantDir1 - 80;
      return intPlantDir1;
    }else if(chrPlant == 'd'){
      intPlantDir1 = intPlantDir1 + 80;
      return intPlantDir1;
    }else{
      return intPlantDir1;
    }
  }
  
  //
  //Print Menu Pictures and getting charcter input/////////////////////////////////////////////////////////////////////
  //
  
  public static char menu(Console con){
    char chrMenu = ' '; 
    while(chrMenu!='p'&&chrMenu!='h'&&chrMenu!='c'&&chrMenu!='q'&&chrMenu!='a'){
      if(con.isCharAvail() == true){
        chrMenu = con.getChar();
      }
      rpg.pause(100);
    }
    return chrMenu;
  }
  
  public static BufferedImage printMenu(char chrMenu){
    
    BufferedImage theCanvas = null;
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768); 
    
    if (chrMenu == 'h'){
      //Print How to play, clear screen) 
      graphics.drawImage(drawPic("./images/howtoplay.png"),0,0,null);
    }else if(chrMenu == 'c'){
      //print cheats 
      graphics.drawImage(drawPic("./images/cheats.png"),0,0,null);
    }else if(chrMenu == 'q'){
    }
    return theCanvas;
  }    
  
  
  
  //
  //Battle Scene///////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static int[] battleScene(Console con,Console hud, int intBomb, int intFreeze, int intAttack,int intZomAttack,int intHealth,int intZomSpeed,int intMaxHealth){
    int intArray[];
    intArray = new int[7];
    
    int intZombie = 2; //Zombie Frames
    int intPlant = 1;// PeaShooter Frames
    
    int intZomRow = 0; //Y value for Zombie
    int intZomPea=0; //Y Valoue for Zombie Projectile
    int intPlantDir1 = 0;//Y Value for PeaShooter
    int intPeaRow = 0; //Y Values for Pea Projectile
    
    int intZomDis =0; // X value to print Zombie Projectile
    int intPlantDir = 0; //X Values for PeaShooter
    int intPeaCol = 0;//X Values for Pea Projectile
    int intPea=0; // Prints Values for Pea Projectile to the left
    
    int intPlantRow=0; //Row Number for Pea Shooter
    int intZomPeaRow=0; //Row Number for Zombie Projectile
    int intFireRate = 20; //Pea Shooter Fire Rate
    intFireRate = 20 + intAttack *5;
    int intZomFireRate =20; //Zombie Fire rate
    intZomFireRate = 20 + intZomAttack *5;
    int intZomProjectile=0; //Making sure the Zombie Projectile prints to only one row at a time
    int intDir =0 ;//Make sure that the Zombie goes up and down
    
    int intHealthcount = 1;// makes sure it u lose only 10 hp per hit
    int intHealthcount1= 1;//Makes sure zombie only uses 10 health per hit
    int intZomHealth=5; //Zombie Health
    int intWin = 0;//Do you win?
    char chrPlant = ' ';//Real Time input for Pea Shooter 
    int intDelay= 0; //Variable to pause zombie when used freeze bomb
    BufferedImage theCanvas = null;
    BufferedImage theCanvas2 = null;
    
    intArray[0]= intWin;
    intArray[1] = intBomb;
    intArray[2] = intFreeze;
    intArray[3]=intHealth;
    intArray[4] = intZomAttack;
    intArray [5] = intAttack;
    intArray [6] = intZomSpeed;
    
    theCanvas2 = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D g = theCanvas2.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,1024,768); 
    Font font = new Font("Comic Sans MS", Font.BOLD, 17);
    g.setFont(font);
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768); 
    
    
    graphics.clearRect(0,0,1024,768);
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    con.clear();
    
    g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
    
    while(intZomHealth > 0&&intHealth > 0){
      //Drawing HUD            
      
      
      graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
      chrPlant = ' ';
      if(con.isCharAvail() == true){
        chrPlant = con.getChar();
        chrPlant=Character.toLowerCase(chrPlant);
      }
      
      //Determining Pea Shot position and row
      intPeaRow = rpg.plantY(chrPlant,intPlantDir);
      intPeaCol = rpg.plantX(chrPlant,intPlantDir1);
      
      //When you shoot the pea projectile*******************************************************************************
      if(chrPlant == 'p'){
        while(intPea*intFireRate <= 640+(intPeaRow)){
          graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
          intPea = intPea+1; //Printing Pea Projectile to the left
          
          
          //Zombie Y direction movement Up and Down
          if (intDir == 0){
            if (intZomRow  >=430){
              intDir =1;
            }else{
              intZomRow = (intZomRow + 6+intZomSpeed);
            }
          }else if(intDir ==1){
            if(intZomRow <=0 ){
              intDir=0;
            }else{
              intZomRow = (intZomRow - 6 -intZomSpeed);
            }
          }
          //Zombie Animation Variable and Frames
          intZombie = intZombie + 1; 
          if (intZombie>=51){
            intZombie =2;
          }
          chrPlant = ' ';
          if(con.isCharAvail() == true){
            chrPlant = con.getChar();
            chrPlant=Character.toLowerCase(chrPlant);
          }
          
          
          //Zombie Projectile (same as above)
          intZomDis = intZomDis + intZomFireRate;
          if(750 - intZomDis <= 0){
            intZomDis = 0;
            intZomProjectile= 0;
          }
          if(intZomRow+10 > 10&&intZomRow<=80&& intZomProjectile== 0){
            intZomPea = 60;
            intZomPeaRow=1;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 80 &&intZomRow<=170 && intZomProjectile== 0){
            intZomPea = 180;
            intZomPeaRow=2;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 170 &&intZomRow<=260 && intZomProjectile== 0){
            intZomPea = 280;
            intZomPeaRow=3;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 260 &&intZomRow<=350 && intZomProjectile== 0){
            intZomPea = 390;
            intZomPeaRow=4;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 420 && intZomProjectile== 0){
            intZomPea = 500;
            intZomPeaRow=5;
            intZomProjectile= 1;
          }
          
          //Plant Position Code        
          intPlant = intPlant + 1;//Plant Animation
          if(intPlant >= 24){
            intPlant = 1;
          }
          intPlantDir = rpg.plantY(chrPlant,intPlantDir);
          intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
          if(intPlantDir<=0){
            intPlantDir = 0;
          }else if(intPlantDir>=440){
            intPlantDir = 440;
          }
          if(intPlantDir1<0){
            intPlantDir1 = 0;
          } else if(intPlantDir1>=160){
            intPlantDir1 = 160;
          }
          //Determining Plant Row number
          if (intPlantDir == 0){
            intPlantRow = 1;
          }else if (intPlantDir==110){
            intPlantRow= 2;
          }else if (intPlantDir==220){
            intPlantRow= 3;
          }else if (intPlantDir==330){
            intPlantRow= 4;
          }else if (intPlantDir==440){
            intPlantRow= 5;
          }
          
          graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
          graphics.drawImage(rpg.drawPic("./images/ProjectilePea.png"),intPeaCol+50 + intPea*intFireRate,intPeaRow+50 ,null);
          graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
          graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
          
          con.drawImage(theCanvas, 0, 0, null);        
          
          //If statement to see if pea projectile hits zombie. If x and y coordinates both match
          if((intPeaRow+50>=intZomRow+10&&intPeaRow+50<=intZomRow +140)&&(intPeaCol+intPea*intFireRate <=740&&intPeaCol+50+intPea*intFireRate >=730)){
            if(intHealthcount1 == 1){
              intZomHealth = intZomHealth - 1;
              intHealthcount1 = 0;
              g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
              g.setColor(Color.BLACK);
              g.setFont(font);
              g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
            }
          }
          //If statement to see if Zombie projectile his you.If x and y coordinates both match
          if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
            if(intHealthcount == 1){
              intHealth = intHealth -10;
              intHealthcount = 0;
               intArray[3] = intHealth;
              g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            }
          }
          
        }
        intPea = 0; //Rset Printing Pea Porjectile
        
        //WHEN you use Items************************************************************************************************
      }else if(chrPlant == 'q'&&intBomb != 0){
        intZomHealth = intZomHealth -1;
        intBomb =intBomb -1;
        
        //Drawing the Hud
        
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("Used A Bomb!!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
      }else if(chrPlant == 'q'&&intBomb == 0){
        
        //Drawing HUD
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("NO MORE BOMBS!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
        graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
        
        con.drawImage(theCanvas, 0, 0, null);  
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
             intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
      }else if(chrPlant == 'e'&&intFreeze == 0){
        
        //Drawing the Hud
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("NO MORE FREEZES!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);  
        
        graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
        
        con.drawImage(theCanvas, 0, 0, null);  
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
             intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
      }else if(chrPlant == 'e'&&intFreeze != 0){
        intFreeze = intFreeze - 1;
        
        //Drawing the Hud
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("Used A Freeze Bomb!!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
        while(intDelay<=50){
          intDelay = intDelay + 5;
          graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
          
          intPeaRow = rpg.plantY(chrPlant,intPlantDir);
          intPeaCol = rpg.plantX(chrPlant,intPlantDir1);
          
          chrPlant = ' ';
          if(con.isCharAvail() == true){
            chrPlant = con.getChar();
            chrPlant=Character.toLowerCase(chrPlant);
          }
          
          //Plant Position Code        
          intPlant = intPlant + 1;//Plant Animation
          if(intPlant >= 24){
            intPlant = 1;
          }
          intPlantDir = rpg.plantY(chrPlant,intPlantDir);
          intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
          if(intPlantDir<=0){
            intPlantDir = 0;
          }else if(intPlantDir>=440){
            intPlantDir = 440;
          }
          if(intPlantDir1<0){
            intPlantDir1 = 0;
          } else if(intPlantDir1>=160){
            intPlantDir1 = 160;
          }
          //Determining Plant Row number
          if (intPlantDir == 0){
            intPlantRow = 1;
          }else if (intPlantDir==110){
            intPlantRow= 2;
          }else if (intPlantDir==220){
            intPlantRow= 3;
          }else if (intPlantDir==330){
            intPlantRow= 4;
          }else if (intPlantDir==440){
            intPlantRow= 5;
          }
          
          if(chrPlant == 'p'){ 
            while(intPea*intFireRate <= 640+(intPeaRow)){
              chrPlant = ' ';
              if(con.isCharAvail() == true){
                chrPlant = con.getChar();
                chrPlant=Character.toLowerCase(chrPlant);
              }
              //Plant Position Code        
              intPlant = intPlant + 1;//Plant Animation
              if(intPlant >= 24){
                intPlant = 1;
              }
              intPlantDir = rpg.plantY(chrPlant,intPlantDir);
              intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
              if(intPlantDir<=0){
                intPlantDir = 0;
              }else if(intPlantDir>=440){
                intPlantDir = 440;
              }
              if(intPlantDir1<0){
                intPlantDir1 = 0;
              } else if(intPlantDir1>=160){
                intPlantDir1 = 160;
              }
              //Determining Plant Row number
              if (intPlantDir == 0){
                intPlantRow = 1;
              }else if (intPlantDir==110){
                intPlantRow= 2;
              }else if (intPlantDir==220){
                intPlantRow= 3;
              }else if (intPlantDir==330){
                intPlantRow= 4;
              }else if (intPlantDir==440){
                intPlantRow= 5;
              }
              
              intPea = intPea + 1; //Printing Pea Projectile to the left
              graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
              graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
              graphics.drawImage(rpg.drawPic("./images/ProjectilePea.png"),intPeaCol+50  + intPea*intFireRate,intPeaRow+50 ,null);
              graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
              graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
              
              con.drawImage(theCanvas, 0, 0, null);  
              
              //If statement to see if pea projectile hits zombie. If x and y coordinates both match
              if((intPeaRow+50>=intZomRow+10&&intPeaRow+50<=intZomRow +140)&&(intPeaCol+intPea*intFireRate <=740&&intPeaCol+50+intPea*intFireRate >=730)){
                if(intHealthcount1 == 1){
                  intZomHealth = intZomHealth - 1;
                  intHealthcount1 = 0;
                  g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
                  g.setColor(Color.BLACK);
                  g.setFont(font);
                  g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
                  g.setFont(g.getFont().deriveFont(15f));
                  g.drawString("Used A Freeze Bomb!!",140,180);
                  hud.drawImage(theCanvas2, 0, 0, null);
                }
              }
              //If statement to see if Zombie projectile his you.If x and y coordinates both match
              if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
                if(intHealthcount == 1){
                  intHealth = intHealth -10;
                  intHealthcount = 0;
                   intArray[3] = intHealth;
                  g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
                  g.setColor(Color.BLACK);
                  g.setFont(font);
                  g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
                  g.setFont(g.getFont().deriveFont(15f));
                  g.drawString("Used A Freeze Bomb!!",140,180);
                  hud.drawImage(theCanvas2, 0, 0, null);
                }
              }
            }
          }else{
            graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
            graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
            graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
            graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
            
            con.drawImage(theCanvas, 0, 0, null);  
            //If statement to see if Zombie projectile his you.If x and y coordinates both match
            if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
              if(intHealthcount == 1){
                intHealth = intHealth -10;
                intHealthcount = 0;
                intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
              }
            }
            
          }
        }
        intPea = 0; //Rset Printing Pea Porjectile
        intDelay = 0; //Reset Delay Variable
      }else{
        
        //Zombie Projectile (same as above)
        intZomDis = intZomDis + intZomFireRate;
        if(750 - intZomDis <= 0){
          intZomDis = 0;
          intZomProjectile= 0;
        }
        if(intZomRow+10 > 10&&intZomRow<=80&& intZomProjectile== 0){
          intZomPea = 60;
          intZomPeaRow=1;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 80 &&intZomRow<=170 && intZomProjectile== 0){
          intZomPea = 180;
          intZomPeaRow=2;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 170 &&intZomRow<=260 && intZomProjectile== 0){
          intZomPea = 280;
          intZomPeaRow=3;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 260 &&intZomRow<=350 && intZomProjectile== 0){
          intZomPea = 390;
          intZomPeaRow=4;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 420 && intZomProjectile== 0){
          intZomPea = 500;
          intZomPeaRow=5;
          intZomProjectile= 1;
        }
        //Zombie Y direction movement Up and Down
        if (intDir == 0){
          if (intZomRow  >=430){
            intDir =1;
          }else{
            intZomRow = (intZomRow + 6+intZomSpeed);
          }
        }else if(intDir ==1){
          if(intZomRow <=0 ){
            intDir=0;
          }else{
            intZomRow = (intZomRow - 6 -intZomSpeed);
          }
        }
        intZombie = intZombie + 1; //Zombie Animation
        if (intZombie>=51){
          intZombie =2;
        }
        //Plant Position Code        
        intPlant = intPlant + 1;//Plant Animation
        if(intPlant >= 24){
          intPlant = 1;
        }
        //Determining Plant Position
        intPlantDir = rpg.plantY(chrPlant,intPlantDir);
        intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
        if(intPlantDir<=0){
          intPlantDir = 0;
        }else if(intPlantDir>=440){
          intPlantDir = 440;
        }
        if(intPlantDir1<0){
          intPlantDir1 = 0;
        } else if(intPlantDir1>=160){
          intPlantDir1 = 160;
        }
        //Determining Plant Row number
        if (intPlantDir == 0){
          intPlantRow = 1;
        }else if (intPlantDir==110){
          intPlantRow= 2;
        }else if (intPlantDir==220){
          intPlantRow= 3;
        }else if (intPlantDir==330){
          intPlantRow= 4;
        }else if (intPlantDir==440){
          intPlantRow= 5;
        }
        
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
        
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
              intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
        
      }
      
      
      con.drawImage(theCanvas, 0, 0, null);
      //Drawing the Hud
      intArray[0]= intWin;
      intArray[1] = intBomb;
      intArray[2] = intFreeze;
      intArray[3] = intHealth;
      intArray[4] = intZomAttack;
      intArray [5] = intAttack;
      intArray [6] = intZomSpeed;
      
      g.setFont(font);
      g.setColor(Color.BLACK);
      g.drawString(Integer.toString(intZomHealth) +"/5 hp",210,45);
      g.setFont(graphics.getFont().deriveFont(15f));
      hud.drawImage(theCanvas2, 0, 0, null);
      
      if(750-intZomDis <30+intPlantDir1+intZomFireRate){
        intHealthcount = 1;//Reset health counter if zombie projectile hits, using or statement
      }
      if(intPeaRow+50<=intZomRow+10||intPeaRow+50>=intZomRow +140){
        intHealthcount1 = 1;//Reset health counter for either if zombie or pea projectile hits, using or statement
      }
    } 
    
    if(intZomHealth <=0){
      intWin = 1;
    }else if(intHealth <= 0){
      intWin = 0;
    }
    //1 = intWin
    //2 = intBomb
    //3 = intFreeze
    //4 = intHealth
    intArray[0]= intWin;
    intArray[1] = intBomb;
    intArray[2] = intFreeze;
    intArray[3]=intHealth;
    intArray[4] = intZomAttack;
    intArray [5] = intAttack;
    intArray [6] = intZomSpeed;
    return intArray;
  }
  
  
  
  //
  ///Drawing Hud concole////////////////////////////////////////////////////////////////////////////////////////////////////////
  //
  
  public static BufferedImage drawHud (int[] intArray,int intMaxHealth){
    BufferedImage theCanvas;
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768); 
    
    Font font = new Font("Comic Sans MS", Font.BOLD, 17);
    graphics.setFont(font);
    graphics.drawImage(rpg.drawPic("./images/HUD.png"),2,6,null);
    graphics.setColor(Color.BLUE);
    graphics.drawString(Integer.toString(intArray[2])+" bombs",200,308);
    graphics.setColor(Color.RED);
    graphics.drawString(Integer.toString(intArray[1])+" bombs",200,362);
    graphics.setColor(Color.BLACK);
    graphics.drawString(Integer.toString(intArray[3])+"/"+Integer.toString(intMaxHealth)+" hp",200,416);
    graphics.setColor(Color.YELLOW);
    graphics.drawString("   +"+Integer.toString(intArray[5]),200,476);
    //graphics.drawString("50/50 hp",210,45);1
    //graphics.setFont(graphics.getFont().deriveFont(19f));
    //graphics.setColor(Color.BLACK);
    //graphics.drawString("This is a sentance!",140,180);
    return theCanvas;
    
    
  }
  
//  
//  //
//  //BOSS BATTLE SCENE SIMILAR TO BATTLE SCENE///////////////////////////////////////////////////////////////////////////////////////////////////////
//  //
  
public static int[] BossBattle(Console con,Console hud, int intBomb, int intFreeze, int intAttack,int intHealth,int intMaxHealth, int intLily){
    int intArray[];
    intArray = new int[7];
    int intZomSpeed = 0;
    int intZomAttack = 10;
    if(intLily == 1){
      intZomAttack = 1;
    }
    int intZombie = 2; //Zombie Frames
    int intPlant = 1;// PeaShooter Frames
    
    int intZomRow = 0; //Y value for Zombie
    int intZomPea=0; //Y Valoue for Zombie Projectile
    int intPlantDir1 = 0;//Y Value for PeaShooter
    int intPeaRow = 0; //Y Values for Pea Projectile
    
    int intZomDis =0; // X value to print Zombie Projectile
    int intPlantDir = 0; //X Values for PeaShooter
    int intPeaCol = 0;//X Values for Pea Projectile
    int intPea=0; // Prints Values for Pea Projectile to the left
    
    int intPlantRow=0; //Row Number for Pea Shooter
    int intZomPeaRow=0; //Row Number for Zombie Projectile
    int intFireRate = 20; //Pea Shooter Fire Rate
    intFireRate = 20 + intAttack *5;
    int intZomFireRate =20; //Zombie Fire rate
    intZomFireRate = 20 + intZomAttack *5;
    int intZomProjectile=0; //Making sure the Zombie Projectile prints to only one row at a time
    int intDir =0 ;//Make sure that the Zombie goes up and down
    
    int intHealthcount = 1;// makes sure it u lose only 10 hp per hit
    int intHealthcount1 = 1; //makes sure zombie only loses 10 hp per hit
    int intZomHealth=10; //Zombie Health
    int intWin = 0;//Do you win?
    char chrPlant = ' ';//Real Time input for Pea Shooter 
    int intDelay= 0; //Variable to pause zombie when used freeze bomb
    BufferedImage theCanvas = null;
    BufferedImage theCanvas2 = null;
    
    intArray[0]= intWin;
    intArray[1] = intBomb;
    intArray[2] = intFreeze;
    intArray[3]=intHealth;
    intArray[4] = intZomAttack;
    intArray [5] = intAttack;
       
    theCanvas2 = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D g = theCanvas2.createGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,1024,768); 
    Font font = new Font("Comic Sans MS", Font.BOLD, 17);
    g.setFont(font);
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768); 
    
    
    graphics.clearRect(0,0,1024,768);
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    con.clear();
    
    g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
    
    while(intZomHealth > 0&&intHealth > 0){
      //Drawing HUD            
      
      graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
      chrPlant = ' ';
      if(con.isCharAvail() == true){
        chrPlant = con.getChar();
        chrPlant=Character.toLowerCase(chrPlant);
      }
      
      //Determining Pea Shot position and row
      intPeaRow = rpg.plantY(chrPlant,intPlantDir);
      intPeaCol = rpg.plantX(chrPlant,intPlantDir1);
      
      //When you shoot the pea projectile*******************************************************************************
      if(chrPlant == 'p'){
        while(intPea*intFireRate <= 640+(intPeaRow)){
          graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
          intPea = intPea+1; //Printing Pea Projectile to the left
          
          
          //Zombie Y direction movement Up and Down
          intZomSpeed = -50+(int)(Math.random()*100+0);
          intZomRow = (intZomRow  +intZomSpeed);
          if (intZomRow  >=430){
            intZomRow = 429;
          }else if(intZomRow <=0 ){
            intZomRow = 1;
          }    
          
          //Zombie Animation Variable and Frames
          intZombie = intZombie + 1; 
          if (intZombie>=34){
            intZombie =2;
          }
          chrPlant = ' ';
          if(con.isCharAvail() == true){
            chrPlant = con.getChar();
            chrPlant=Character.toLowerCase(chrPlant);
          }
          
          
          //Zombie Projectile (same as above)
          intZomDis = intZomDis + intZomFireRate;
          if(750 - intZomDis <= 0){
            intZomDis = 0;
            intZomProjectile= 0;
          }
          if(intZomRow+10 > 10&&intZomRow<=80&& intZomProjectile== 0){
            intZomPea = 60;
            intZomPeaRow=1;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 80 &&intZomRow<=170 && intZomProjectile== 0){
            intZomPea = 180;
            intZomPeaRow=2;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 170 &&intZomRow<=260 && intZomProjectile== 0){
            intZomPea = 280;
            intZomPeaRow=3;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 260 &&intZomRow<=350 && intZomProjectile== 0){
            intZomPea = 390;
            intZomPeaRow=4;
            intZomProjectile= 1;
          }else if(intZomRow+10 > 420 && intZomProjectile== 0){
            intZomPea = 500;
            intZomPeaRow=5;
            intZomProjectile= 1;
          }
          
          //Plant Position Code        
          intPlant = intPlant + 1;//Plant Animation
          if(intPlant >= 24){
            intPlant = 1;
          }
          intPlantDir = rpg.plantY(chrPlant,intPlantDir);
          intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
          if(intPlantDir<=0){
            intPlantDir = 0;
          }else if(intPlantDir>=440){
            intPlantDir = 440;
          }
          if(intPlantDir1<0){
            intPlantDir1 = 0;
          } else if(intPlantDir1>=160){
            intPlantDir1 = 160;
          }
          //Determining Plant Row number
          if (intPlantDir == 0){
            intPlantRow = 1;
          }else if (intPlantDir==110){
            intPlantRow= 2;
          }else if (intPlantDir==220){
            intPlantRow= 3;
          }else if (intPlantDir==330){
            intPlantRow= 4;
          }else if (intPlantDir==440){
            intPlantRow= 5;
          }
          
          graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
          graphics.drawImage(rpg.drawPic("./images/ProjectilePea.png"),intPeaCol+50 + intPea*intFireRate,intPeaRow+50 ,null);
          graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
          graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
        
          con.drawImage(theCanvas, 0, 0, null);        
          
          //If statement to see if pea projectile hits zombie. If x and y coordinates both match
          if((intPeaRow+50>=intZomRow+10&&intPeaRow+50<=intZomRow +140)&&(intPeaCol+intPea*intFireRate <=740&&intPeaCol+50+intPea*intFireRate >=730)){
            if(intHealthcount1 == 1){
              intZomHealth = intZomHealth - 1;
              intHealthcount1 = 0;
              g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
              g.setColor(Color.BLACK);
              g.setFont(font);
              g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
              
            }
          }
          //If statement to see if Zombie projectile his you.If x and y coordinates both match
          if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
            if(intHealthcount == 1){
              intHealth = intHealth -10;
              intHealthcount = 0;
               intArray[3] = intHealth;
              g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
            }
          }
          
        }
        intPea = 0; //Rset Printing Pea Porjectile
        
        //WHEN you use Items************************************************************************************************
      }else if(chrPlant == 'q'&&intBomb != 0){
        intZomHealth = intZomHealth -1;
        intBomb =intBomb -1;
        
        //Drawing the Hud
        
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("Used A Bomb!!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
      }else if(chrPlant == 'q'&&intBomb == 0){
        
        //Drawing HUD
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("NO MORE BOMBS!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
        graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
        
        con.drawImage(theCanvas, 0, 0, null);  
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
             intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
      }else if(chrPlant == 'e'&&intFreeze == 0){
        
        //Drawing the Hud
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("NO MORE FREEZES!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);  
        
        graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
        
        con.drawImage(theCanvas, 0, 0, null);  
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
             intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
      }else if(chrPlant == 'e'&&intFreeze != 0){
        intFreeze = intFreeze - 1;
        
        //Drawing the Hud
        intArray[0]= intWin;
        intArray[1] = intBomb;
        intArray[2] = intFreeze;
        intArray[3]=intHealth;
        intArray[4] = intZomAttack;
        intArray [5] = intAttack;
        intArray [6] = intZomSpeed;
        g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("Used A Freeze Bomb!!",140,180);
        hud.drawImage(theCanvas2, 0, 0, null);
        
        while(intDelay<=50){
          intDelay = intDelay + 5;
          graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
          
          intPeaRow = rpg.plantY(chrPlant,intPlantDir);
          intPeaCol = rpg.plantX(chrPlant,intPlantDir1);
          
          chrPlant = ' ';
          if(con.isCharAvail() == true){
            chrPlant = con.getChar();
            chrPlant=Character.toLowerCase(chrPlant);
          }
          
          //Plant Position Code        
          intPlant = intPlant + 1;//Plant Animation
          if(intPlant >= 24){
            intPlant = 1;
          }
          intPlantDir = rpg.plantY(chrPlant,intPlantDir);
          intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
          if(intPlantDir<=0){
            intPlantDir = 0;
          }else if(intPlantDir>=440){
            intPlantDir = 440;
          }
          if(intPlantDir1<0){
            intPlantDir1 = 0;
          } else if(intPlantDir1>=160){
            intPlantDir1 = 160;
          }
          //Determining Plant Row number
          if (intPlantDir == 0){
            intPlantRow = 1;
          }else if (intPlantDir==110){
            intPlantRow= 2;
          }else if (intPlantDir==220){
            intPlantRow= 3;
          }else if (intPlantDir==330){
            intPlantRow= 4;
          }else if (intPlantDir==440){
            intPlantRow= 5;
          }
          
          if(chrPlant == 'p'){ 
            while(intPea*intFireRate <= 640+(intPeaRow)){
              chrPlant = ' ';
              if(con.isCharAvail() == true){
                chrPlant = con.getChar();
                chrPlant=Character.toLowerCase(chrPlant);
              }
              //Plant Position Code        
              intPlant = intPlant + 1;//Plant Animation
              if(intPlant >= 24){
                intPlant = 1;
              }
              intPlantDir = rpg.plantY(chrPlant,intPlantDir);
              intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
              if(intPlantDir<=0){
                intPlantDir = 0;
              }else if(intPlantDir>=440){
                intPlantDir = 440;
              }
              if(intPlantDir1<0){
                intPlantDir1 = 0;
              } else if(intPlantDir1>=160){
                intPlantDir1 = 160;
              }
              //Determining Plant Row number
              if (intPlantDir == 0){
                intPlantRow = 1;
              }else if (intPlantDir==110){
                intPlantRow= 2;
              }else if (intPlantDir==220){
                intPlantRow= 3;
              }else if (intPlantDir==330){
                intPlantRow= 4;
              }else if (intPlantDir==440){
                intPlantRow= 5;
              }
              
              intPea = intPea + 1; //Printing Pea Projectile to the left
              graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
              graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
              graphics.drawImage(rpg.drawPic("./images/ProjectilePea.png"),intPeaCol+50  + intPea*intFireRate,intPeaRow+50 ,null);
              graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
              graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
              
              con.drawImage(theCanvas, 0, 0, null);  
              
              //If statement to see if pea projectile hits zombie. If x and y coordinates both match
              if((intPeaRow+50>=intZomRow+10&&intPeaRow+50<=intZomRow +140)&&(intPeaCol+intPea*intFireRate <=740&&intPeaCol+50+intPea*intFireRate >=730)){
                if(intHealthcount1 == 1){
                  intZomHealth = intZomHealth - 1;
                  intHealthcount1 = 0;
                  g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
                  g.setColor(Color.BLACK);
                  g.setFont(font);
                  g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
                  g.setFont(g.getFont().deriveFont(15f));
                  g.drawString("Used A Freeze Bomb!!",140,180);
                  hud.drawImage(theCanvas2, 0, 0, null);
                }
              }
              //If statement to see if Zombie projectile his you.If x and y coordinates both match
              if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
                if(intHealthcount == 1){
                  intHealth = intHealth -10;
                  intHealthcount = 0;
                   intArray[3] = intHealth;
                  g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
                  g.setColor(Color.BLACK);
                  g.setFont(font);
                  g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
                  g.setFont(g.getFont().deriveFont(15f));
                  g.drawString("Used A Freeze Bomb!!",140,180);
                  hud.drawImage(theCanvas2, 0, 0, null);
                }
              }
            }
          }else{
            graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
            graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
            graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
            graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
            
            con.drawImage(theCanvas, 0, 0, null);  
            //If statement to see if Zombie projectile his you.If x and y coordinates both match
            if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
              if(intHealthcount == 1){
                intHealth = intHealth -10;
                intHealthcount = 0;
                intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
              }
            }
            
          }
        }
        intPea = 0; //Rset Printing Pea Porjectile
        intDelay = 0; //Reset Delay Variable
      }else{
        
        //Zombie Projectile (same as above)
        intZomDis = intZomDis + intZomFireRate;
        if(750 - intZomDis <= 0){
          intZomDis = 0;
          intZomProjectile= 0;
        }
        if(intZomRow+10 > 10&&intZomRow<=80&& intZomProjectile== 0){
          intZomPea = 60;
          intZomPeaRow=1;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 80 &&intZomRow<=170 && intZomProjectile== 0){
          intZomPea = 180;
          intZomPeaRow=2;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 170 &&intZomRow<=260 && intZomProjectile== 0){
          intZomPea = 280;
          intZomPeaRow=3;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 260 &&intZomRow<=350 && intZomProjectile== 0){
          intZomPea = 390;
          intZomPeaRow=4;
          intZomProjectile= 1;
        }else if(intZomRow+10 > 420 && intZomProjectile== 0){
          intZomPea = 500;
          intZomPeaRow=5;
          intZomProjectile= 1;
        }
        //Zombie Y direction movement Up and Down
        intZomSpeed = -50+(int)(Math.random()*100+0);
        intZomRow = (intZomRow  +intZomSpeed);
        if (intZomRow  >=430){
          intZomRow = 429;
        }else if(intZomRow <=0 ){
          intZomRow = 1;
        }      
        
        intZombie = intZombie + 1; //Zombie Animation
        if (intZombie>=34){
          intZombie =2;
        }
        //Plant Position Code        
        intPlant = intPlant + 1;//Plant Animation
        if(intPlant >= 24){
          intPlant = 1;
        }
        //Determining Plant Position
        intPlantDir = rpg.plantY(chrPlant,intPlantDir);
        intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
        if(intPlantDir<=0){
          intPlantDir = 0;
        }else if(intPlantDir>=440){
          intPlantDir = 440;
        }
        if(intPlantDir1<0){
          intPlantDir1 = 0;
        } else if(intPlantDir1>=160){
          intPlantDir1 = 160;
        }
        //Determining Plant Row number
        if (intPlantDir == 0){
          intPlantRow = 1;
        }else if (intPlantDir==110){
          intPlantRow= 2;
        }else if (intPlantDir==220){
          intPlantRow= 3;
        }else if (intPlantDir==330){
          intPlantRow= 4;
        }else if (intPlantDir==440){
          intPlantRow= 5;
        }
        
        graphics.drawImage(rpg.drawPic("./images/zombieProjectile.png"),750 - intZomDis, intZomPea ,null);
        graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
        graphics.drawImage(rpg.drawPic("./images/zombie"+intZombie+".png"),730,10+intZomRow,null);
        
        //If statement to see if Zombie projectile his you.If x and y coordinates both match
        if(750-intZomDis >=30 + intPlantDir1&&750-intZomDis <=120+intPlantDir1+intZomFireRate&&intZomPeaRow ==intPlantRow){
          if(intHealthcount == 1){
            intHealth = intHealth -10;
            intHealthcount = 0;
              intArray[3] = intHealth;
            g.drawImage(rpg.drawHud(intArray,intMaxHealth), 0, 0, null);
          }
        }
        
      }
      
      
      con.drawImage(theCanvas, 0, 0, null);
      //Drawing the Hud
      intArray[0]= intWin;
      intArray[1] = intBomb;
      intArray[2] = intFreeze;
      intArray[3] = intHealth;
      intArray[4] = intZomAttack;
      intArray [5] = intAttack;
      intArray [6] = intZomSpeed;
      
      g.setFont(font);
      g.setColor(Color.BLACK);
      g.drawString(Integer.toString(intZomHealth) +"/10 hp",210,45);
      g.setFont(graphics.getFont().deriveFont(15f));
      hud.drawImage(theCanvas2, 0, 0, null);
      
      if(750-intZomDis <30+intPlantDir1+intZomFireRate){
        intHealthcount = 1;//Reset health counter if zombie projectile hits, using or statement
      }
      if(intPeaRow+50<=intZomRow+10||intPeaRow+50>=intZomRow +140){
        intHealthcount1 = 1;//Reset health counter if pea projectile hits, using or statement
      }
    } 
    
    if(intZomHealth <=0){
      intWin = 1;
    }else if(intHealth <= 0){
      intWin = 0;
    }
    //1 = intWin
    //2 = intBomb
    //3 = intFreeze
    //4 = intHealth
    intArray[0]= intWin;
    intArray[1] = intBomb;
    intArray[2] = intFreeze;
    intArray[3]=intHealth;
    intArray[4] = intZomAttack;
    intArray [5] = intAttack;
    intArray [6] = intZomSpeed;
    return intArray;
  }
  
  
  
  
  
  
  
  
  
}
