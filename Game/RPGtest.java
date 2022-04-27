import hsa.*;
import java.awt.*;

// Extra imports needed for a picture file

import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;

public class RPGtest{
  public static void main(String[]args){
    Console con = new Console(31,102);
    Console hud = new Console(30,30);
    
    char chrKey = ' ';
    
    //Title Page Variables
    
    BufferedImage theCanvas = null;
    char chrMenu = ' ';
    char chrBack = ' ';
    int intPlay = 0;
    
    //Map Variables
    
    String strMap[][];
    strMap = new String[20][20];
    BufferedImage map = null;
    BufferedImage player = null;
    
    char chrPlayer = ' ';
    int intX = 1;
    int intY = 1;
    
    //Chest Variable
    
    String strItems[];
    int intItems;
    int intChest;
    int intRan;
    
    int intAttack = 0;
    int intskin = 0;
    int intFreeze = 0;
    int intBomb = 0;
    int intLily = 0;
    
    
    //Battle Scene Variables
    
    int intEmpty; //for loop to print empty lawn
    int intZombie;
    int intZombie1 = 2;
    int intZombieWalk = 0;
    int intZombieWalk1 = 0;
    int intZombieRow = 0;
    int intZombieRow1 = 0;
    int intZombieHard = 1;
    
    int intPlant = 1;
    int intPlantDir = 0;
    int intPlantDir1 = 0;
    int intPea=0;
    int intPeaRow = 0;
    int intPeaCol = 0;
    char chrPea= ' ';
    
    int intWin = 0;
    int intZomHealth=5;
    
    
    char chrPlant = ' ';
    
    //Game Over Variable and Quit Variable
    
    
    
    int intGame = 0;
    int intQuit = 0;    
    
    
    
    
    
    
    /////////////////////////////////////
    
    
    int intZomRow = 0;
    int intZomRow1=110;
    int intPeaRowNum = 0;
    int intZomRowNum = 0;
    intZombie = 2;
    int intFireRate = 20;
    int intPlantRow=0;
    int intZomPea=0;
    int intZomPeaRow=0;
    int intZomDis =0;
    int intZomProjectile=0;
    int intZomFireRate =20; //Zombie Fire rate
    
    
    
//    intPeaRow=10;
//      intZomRow =45;
    //////////////////////////////////
    
    
    
    
    
    
    theCanvas = new BufferedImage(1024, 768,  BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = theCanvas.createGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768); 
    //if (strMap[intY][intX].equals("e")){
    
//       graphics.drawImage(rpg.drawPic("lawnGame.png"),10,10,null);
//     graphics.drawImage(rpg.drawPic("ProjectilePea.png"),200,150,null);
//         // graphics.drawImage(rpg.drawPic("PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
//          graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),200,10,null);
//           con.drawImage(theCanvas, 0, 0, null);
//          rpg.pause(10000);
//    
    
    hud.println("Prepare to battle");
    graphics.clearRect(0,0,1024,768);
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0,0,1024,768);
    con.clear();
    
    ///////////////////////
    int intHealth = 40;
    
 
    
    //strString = rpg.loadZombies(5);
    //strString1 = rpg.loadDistance(5);
    
    
//    hud.println(strString1[0]);
//    hud.println(strString1[1]);
//    hud.println(strString1[2]);
//    hud.println(strString1[3]);
//    hud.println(strString1[4]);
    //rpg.pause(2000);
    
    int intDir =0 ;
    
    while(intZomHealth > 0&&intHealth > 0){
      graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
      chrPlant = ' ';
      if(con.isCharAvail() == true){
        chrPlant = con.getChar();
        chrPlant=Character.toLowerCase(chrPlant);
      }
      
      //Zombie Projectile 
      intZomDis = intZomDis + intZomFireRate; //Printing Projectile going to the right with various firerate.
      if(750 - intZomDis <= 0){
        intZomDis = 0;
        intZomProjectile= 0;
      }
      //setting row for projectile to be printed
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
      
      
      //Determining Pea Shot position and row
      intPeaRow = rpg.plantY(chrPlant,intPlantDir);
      intPeaCol = rpg.plantX(chrPlant,intPlantDir1);
      if (intPeaRow+50 == 50){
        intPeaRowNum = 1;
      }else if (intPeaRow+50==160){
        intPeaRowNum= 2;
      }else if (intPeaRow+50==270){
        intPeaRowNum= 3;
      }else if (intPeaRow+50==380){
        intPeaRowNum= 4;
      }else if (intPeaRow+50==490){
        intPeaRowNum= 5;
      }
      
      //When you shot the pea projectile
      if(chrPlant == 'p'){
        while(intPea*intFireRate <= 680+(intPeaRow)){
          graphics.drawImage(rpg.drawPic("./images/lawnGame.png"),10,10,null);
          intPea = intPea + 1; //Printing Pea Projectile to the left
          
          
          //Zombie Y direction movement Up and Down
          if (intDir == 0){
            if (intZomRow  >=430){
              intDir =1;
            }else{
              intZomRow = (intZomRow + 5);
            }
          }else if(intDir ==1){
            if(intZomRow <=0 ){
              intDir=0;
            }else{
              intZomRow = (intZomRow - 5);
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
          graphics.drawImage(rpg.drawPic("./images/ProjectilePea.png"),intPeaCol+50  + intPea*intFireRate,intPeaRow+50 ,null);
          graphics.drawImage(rpg.drawPic("./images/PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
          graphics.drawImage(rpg.drawPic("./images/conezombie_frame_00"+intZombie+".png"),730,10+intZomRow,null);
          con.drawImage(theCanvas, 0, 0, null);        
          
          //If statement to see if pea projectile hits zombie. If x and y coordinates both match
          if((intPeaRow+50>=intZomRow+10&&intPeaRow+50<=intZomRow +140)&&(intPeaCol+50+intPea*intFireRate <=740&&intPeaCol+50+intPea*intFireRate >=730)){
            intZomHealth = intZomHealth - 1;
          }
          //If statement to see if Zombie projectile his you.If x and y coordinates both match
          if(750-intZomDis >= 5+intPlantDir1&&750-intZomDis <=55+intPlantDir1&&intZomPeaRow ==intPlantRow){
            intHealth = intHealth -10;
          }
          //hud.println ("Zombie Health: "+intZomHealth+"Your Health: " +intHealth); Print onto Hud
        }
        intPea = 0; //Rset Printing Pea Porjectile
        
        //If you do not press the shoot button
      }else{
        
        //Zombie X movement
        if (intDir == -0){
          if (intZomRow  >=430){
            intDir =1;
          }else{
            intZomRow = (intZomRow + 5);
          }
        }else if(intDir ==1){
          if(intZomRow <=-30 ){
            intDir=0;
          }else{
            intZomRow = (intZomRow - 5);
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
        if(750-intZomDis >= 35+intPlantDir1&&750-intZomDis <=55+intPlantDir1&&intZomPeaRow ==intPlantRow){
          intHealth = intHealth -10;
        }
        hud.println ("Zombie Health: "+intZomHealth+"Your Health: " +intHealth);
      }
      con.drawImage(theCanvas, 0, 0, null);
    }
    
    
//    ///////////////////////////////////////////////////////////////////////////////////////////////////////// 
//    
//    while(intWin ==0){
//      while(intZombieWalk1 <= 800&&intWin==0){      
//        
//        graphics.setColor(Color.WHITE);
//        graphics.fillRect(0,0,1024,768);
//        graphics.drawImage(rpg.drawPic("lawnGame.png"),10,10,null);
//        intZombieWalk1 = intZombieWalk1 + 2;
//        
//        /////////
//        intZombie = intZombie + 1;
//        if (intZombie>=51){
//          intZombie = 2;
//        }
//        ////////
//        
//        //*********ADD IF statement if zombie reaches the plant
//        
//        //Plant 
//        
//        //**** Find Plant position
//        intPlant = intPlant + 1;
//        if(intPlant >= 24){
//          intPlant = 1;
//        }
//        if(con.isCharAvail() == true){
//          chrPlant = con.getChar();
//          chrPlant=Character.toLowerCase(chrPlant);
//        }
//        intPlantDir = rpg.plantY(chrPlant,intPlantDir);
//        intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
//        hud.println(chrPlant);
//        if(intPlantDir<=0){
//          intPlantDir = 0;
//        }else if(intPlantDir>=440){
//          intPlantDir = 440;
//        }
//        if(intPlantDir1<0){
//          intPlantDir1 = 0;
//        } else if(intPlantDir1>=160){
//          intPlantDir1 = 160;
//        }
//        //****
//        
//        
//        ///**** new stuff 
//        chrPea =chrPlant;
//        intPeaRow = intPlantDir+50;
//        intPeaCol = intPlantDir1+50;
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //WHen you press v you fire ammo
//        if (chrPlant == 'v'){
//          //  while((intPea+intPeaCol)<= (850-intZombieWalk1)){
//          while((intPea+intPeaCol)<= 800&&intWin == 0){
//            graphics.drawImage(rpg.drawPic("lawnGame.png"),10,10,null);
//            intZombieWalk1 = intZombieWalk1 + 2; // Walking Distance for Zombie
//            intZombie = intZombie + 1;           // Animation
//             if (intZombie>=51){                 //Goes back to start when it hits fram 51
//              intZombie = 2;
//            }
//            
//            intPlant = intPlant + 1;           //Goes back to start when it hits fram 24
//            if(intPlant >= 24){
//              intPlant = 1;
//            }
//            
//            //**** Find Plant Position when v is pressed
//            if(con.isCharAvail() == true){
//              chrPlant = con.getChar();
//              chrPlant=Character.toLowerCase(chrPlant);
//            }
//            intPlantDir = rpg.plantY(chrPlant,intPlantDir);
//            intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
//            hud.println(chrPlant);
//            if(intPlantDir<=0){
//              intPlantDir = 0;
//            }else if(intPlantDir>=440){
//              intPlantDir = 440;
//            }
//            if(intPlantDir1<0){
//              intPlantDir1 = 0;
//            } else if(intPlantDir1>=160){
//              intPlantDir1 = 160;
//            }
//            chrPlant = ' ';
//            //*****
//            
//            
//            intPea = intPea+intFireRate;  // How fast will the pea shoot?
//            
//            //Determining which row the pea is fired
//            
//            if (intPeaRow == 50){
//              intPeaRowNum = 1;
//            }else if (intPeaRow ==160){
//              intPeaRowNum= 2;
//            }else if (intPeaRow ==270){
//              intPeaRowNum= 3;
//            }else if (intPeaRow ==380){
//              intPeaRowNum= 4;
//            }else if (intPeaRow ==490){
//              intPeaRowNum= 5;
//            }
//            
//            //if the Pea hits the zombie and on the same row as the zombie, the health of zombie goes down
//            if((intPea+intPeaCol)>= (850-intZombieWalk1)&&intPeaRowNum == intZomRowNum && (intPea+intPeaCol)<= (850+intFireRate-intZombieWalk1)&&intPeaRowNum == intZomRowNum){
//              intZomHealth = intZomHealth - 1;
//              //if Zombie Health Goes to 0 you win and exits loop
//              if(intZomHealth <= 0){
//                intWin = 1;
//                con.clear();
//              }
//              //The pea is not drawn on canvas after it hits zombie
//            }else if(intPea+intPeaCol> (850-intZombieWalk1)&&intPeaRowNum == intZomRowNum){
//            }else{
//              graphics.drawImage(rpg.drawPic("ProjectilePea.png"),intPeaCol + intPea,intPeaRow,null);
//            }
//            //Draw the rest of everything
//            graphics.drawImage(rpg.drawPic("PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
//            
//            //Slow Zombie Animaton      
//            graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,intZomRow,null);
//            con.drawImage(theCanvas, 0, 0, null);
//            // hud.print("health: "+intZomHealth);
//            
//          }
//          intPea = 0; 
//          
//          ////////////////////////////////////////////////////////////////////////////////////////////////
//          //Prints everything normally if v is not pressed
//        }else{                             
//          graphics.drawImage(rpg.drawPic("PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
//          //Slow Zombie         
//          graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,intZomRow,null);
//          con.drawImage(theCanvas, 0, 0, null);
//        }
//        chrPea = ' ';
//        chrPlant= ' ';
//      }
//      
//    }
//     //    
//    if (intWin == 1){
//      intWin = 0;
//      strMap[intY][intX]=("g");
//    }else if(intWin ==0){
//      intGame = 1;
//    }
//    intZomHealth = 10;
//    
    //}//If statement strMap = e
    
    
    //          hud.println("Prepare to battle");
//          graphics.clearRect(0,0,1024,768);
//          graphics.setColor(Color.WHITE);
//          graphics.fillRect(0,0,1024,768);
//          con.clear();
//          
//          for(intEmpty = 0; intEmpty < 40; intEmpty ++){        
//            graphics.fillRect(0,0,1024,768);
//            graphics.drawImage(rpg.drawPic("lawnEmpty.png"),10-intEmpty*20,10,null);
//            //  rpg.pause(60);        
//            con.drawImage(theCanvas, 0, 0, null);
//          }
//          graphics.fillRect(0,0,1024,768);
//          con.clear();
//          
//          if(intZombieHard == 1){
//            while(intZombieWalk1 <= 800&&intWin==0){      
//              for(intZombie=2;intZombie<51;intZombie++){
//                graphics.setColor(Color.WHITE);
//                graphics.fillRect(0,0,1024,768);
//                graphics.drawImage(rpg.drawPic("lawnGame.png"),10,10,null);
//                intZombieWalk1 = intZombieWalk1 + 2;
//                
//                //*********ADD IF statement if zombie reaches the plant
//                
//                //Plant 
//                
//                intPlant = intPlant + 1;
//                if(intPlant >= 24){
//                  intPlant = 1;
//                }
//                if(con.isCharAvail() == true){
//                  chrPlant = con.getChar();
//                  chrPlant=Character.toLowerCase(chrPlant);
//                }
//                intPlantDir = rpg.plantY(chrPlant,intPlantDir);
//                intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
//                hud.println(chrPlant);
//                if(intPlantDir<=0){
//                  intPlantDir = 0;
//                }else if(intPlantDir>=440){
//                  intPlantDir = 440;
//                }
//                if(intPlantDir1<0){
//                  intPlantDir1 = 0;
//                } else if(intPlantDir1>=160){
//                  intPlantDir1 = 160;
//                }
//                
//                chrPea =chrPlant;
//                if (chrPea == 'v'){
//                  //while(intPea != 400){
//                 // for (intPea= 0;intPea<=20;intPea++){
//                    intPeaRow = intPlantDir+50;
//                    intPeaCol = intPlantDir1+50;
//                    
//                    
//                    
//                  }
//              //  }
//                
//                chrPea = ' ';
//                chrPlant= ' ';
//                
//                intPea = intPea+20;
//                if((intPea+intPeaCol)>= (850-intZombieWalk1)){
//                  intPea=0;
//                  intZomHealth = intZomHealth - 1;
//                  hud.print(intZomHealth);
//                }
//                if(intZomHealth <= 0){
//                  intWin = 1;
//                }
//                if(intZombieWalk>=700){
//                }
//                graphics.drawImage(rpg.drawPic("ProjectilePea.png"),intPeaCol + intPea,intPeaRow,null);
//                
//                graphics.drawImage(rpg.drawPic("PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
//                
//                //Slow Zombie
//                int intZomRow;
//                intZomRow = 10;
////                if(intZombieRow1 ==5){
////                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,10,null);
////                }else if(intZombieRow1 == 4){
////                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,110,null);
////                }else if(intZombieRow1 == 3){
////                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,210,null);
////                }else if (intZombieRow1 == 2){ 
////                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,320,null);
////                }else if (intZombieRow1 == 1){
////                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,420,null);
////                }      
//                graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,intZomRow,null);
//                con.drawImage(theCanvas, 0, 0, null);
//                
//                
//              }
//            }
//            
//            
//          }else if(intZombieHard == 2){
//            while(intZombieWalk1 <= 800){      
//              for(intZombie=2;intZombie<51;intZombie++){
//                graphics.setColor(Color.WHITE);
//                graphics.fillRect(0,0,1024,768);
//                graphics.drawImage(rpg.drawPic("lawnGame.png"),10,10,null);
//                intZombieWalk1 = intZombieWalk1 + 2;
//                intZombieWalk = intZombieWalk + 3;
//                
//                //*********ADD IF statement if zombie reaches the plant
//                
//                //Plant 
//                
//                intPlant = intPlant + 1;
//                if(intPlant >= 24){
//                  intPlant = 1;
//                }
//                if(con.isCharAvail() == true){
//                  chrPlant = con.getChar();
//                  chrPlant=Character.toLowerCase(chrPlant);
//                }
//                intPlantDir = rpg.plantY(chrPlant,intPlantDir);
//                intPlantDir1 = rpg.plantX(chrPlant,intPlantDir1);
//                chrPlant = ' ';
//                if(intPlantDir<=0){
//                  intPlantDir = 0;
//                }else if(intPlantDir>=440){
//                  intPlantDir = 440;
//                }
//                if(intPlantDir1<0){
//                  intPlantDir1 = 0;
//                } else if(intPlantDir1>=160){
//                  intPlantDir1 = 160;
//                }
//                
//                graphics.drawImage(rpg.drawPic("PeaShooter_frame_00"+intPlant+".png"),30+intPlantDir1,40+intPlantDir,null);
//                
//                //Fast Zombie 
//                
//                if(intZombieWalk >=900){
//                }else{
//                  
//                  intZombie1 = intZombie1 + 1;
//                  if(intZombie1 >= 34){
//                    intZombie1 = 2;
//                  }
//                  if(intZombieRow ==5){
//                    graphics.drawImage(rpg.drawPic("zombie"+intZombie1+".png"),850-intZombieWalk,10,null);
//                  }else if(intZombieRow == 4){
//                    graphics.drawImage(rpg.drawPic("zombie"+intZombie1+".png"),850-intZombieWalk,110,null);
//                  }else if(intZombieRow == 3){
//                    graphics.drawImage(rpg.drawPic("zombie"+intZombie1+".png"),850-intZombieWalk,210,null);
//                  }else if (intZombieRow == 2){ 
//                    graphics.drawImage(rpg.drawPic("zombie"+intZombie1+".png"),850-intZombieWalk,320,null);
//                  }else if (intZombieRow == 1){
//                    graphics.drawImage(rpg.drawPic("zombie"+intZombie1+".png"),850-intZombieWalk,420,null);
//                  }              
//                }
//                
//                //Slow Zombie
//                
//                if(intZombieRow1 ==5){
//                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,10,null);
//                }else if(intZombieRow1 == 4){
//                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,110,null);
//                }else if(intZombieRow1 == 3){
//                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,210,null);
//                }else if (intZombieRow1 == 2){ 
//                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,320,null);
//                }else if (intZombieRow1 == 1){
//                  graphics.drawImage(rpg.drawPic("conezombie_frame_00"+intZombie+".png"),850-intZombieWalk1,420,null);
//                }      
//                
//                con.drawImage(theCanvas, 0, 0, null);
//                
//              }
//            }
//          }
//          
//          if (intWin == 1){
//            intWin = 0;
//            strMap[intY][intX]=("g");
//          }else if(intWin ==0){
//            intGame = 1;
//          }
//          intZomHealth = 10;
//          
        }//If statement strMap = e
    
    
    
  }
