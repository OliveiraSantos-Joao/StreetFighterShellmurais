package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ScreenTypes;
import streetFighter.inputs.ToDo;


public class ChooseFighter implements ToDo {
  private Picture saraPic;
  private Picture pauloPic;
  private Picture pedroPic;
  private Picture fighter1Pic;

  private Picture mainMenu;

  Rectangle rect1;
  Rectangle rect2;
  Rectangle rect3;
  Rectangle rect4;

  private int maxchampions = 4;

  private int pressedCharacterP1 = 1;
  private int pressedCharacterP2 = maxchampions;


  private Rectangle[] photoFrame = new Rectangle[maxchampions];


  public ChooseFighter() {
    Inputs.setInputScreen(this);
    createFighters();
  }

  public Rectangle[] getPhotoFrame() {
    return photoFrame;
  }

  public void createFighters() {
    mainMenu = new Picture(Game.PADDING, Game.PADDING, "BlackBackground2.png");
    mainMenu.draw();

    saraPic = new Picture(mainMenu.getWidth() / 2, mainMenu.getHeight() * 0.6, "sara.png");
    saraPic.draw();

    pauloPic = new Picture(saraPic.getX() - saraPic.getWidth() - 20, saraPic.getY(), "paulo.png");
    pauloPic.draw();

    pedroPic = new Picture(pauloPic.getX() - pauloPic.getWidth() - 20, pauloPic.getY(), "paulo.png");
    pedroPic.draw();

    fighter1Pic = new Picture((pedroPic.getX()) - pedroPic.getWidth() - 20 , pauloPic.getY() , "sara.png");
    fighter1Pic.draw();

    rect1 = new Rectangle(saraPic.getX(), saraPic.getY(), saraPic.getWidth(), pauloPic.getHeight());
    rect1.setColor(Color.BLUE);
    rect1.draw();
    photoFrame[3]=rect1;

    rect2 = new Rectangle(pauloPic.getX(), pauloPic.getY(), pauloPic.getWidth(), pauloPic.getHeight());
    photoFrame[2]=rect2;

    rect3 = new Rectangle(pedroPic.getX(), pedroPic.getY(), pedroPic.getWidth(), pedroPic.getHeight());
    photoFrame[1]=rect3;

    rect4 = new Rectangle(fighter1Pic.getX(), fighter1Pic.getY(), fighter1Pic.getWidth(), fighter1Pic.getHeight());
    rect4.setColor(Color.RED);
    rect4.draw();
    photoFrame[0]=rect4;

  }

  public int getMaxchampions() {
    return maxchampions;
  }

  @Override
  public ScreenTypes getScreen() {
    return ScreenTypes.CHAMPSELECT;
  }

  @Override
  public void action(int key) {
    switch (key) {

      case KeyboardEvent.KEY_RIGHT:
        switch (pressedCharacterP1){
          case 1:
            pressedCharacterP1++;
            break;

          case 2:
            pressedCharacterP1++;
            break;

          case 3:
            pressedCharacterP1++;
            break;

          case 4:
            pressedCharacterP1 = 1;
            break;
        }
        break;

      case KeyboardEvent.KEY_LEFT:

        switch (pressedCharacterP1){

          case 1:
            pressedCharacterP1 = getMaxchampions();//para voltar ao ultimo
            break;
          case 2:
            pressedCharacterP1--;
            break;
          case 3:
            pressedCharacterP1--;
            break;

          case 4:
            pressedCharacterP1--;
            break;
        }
        break;

      case KeyboardEvent.KEY_D:
        switch (pressedCharacterP2){
          case 1:
            pressedCharacterP2 ++;
            break;

          case 2:
            pressedCharacterP2 ++;
            break;

          case 3:
            pressedCharacterP2 ++;
            break;

          case 4:
            pressedCharacterP2 = 1; //pq da a volta !!
            break;
        }
        break;

      case KeyboardEvent.KEY_A:
        switch (pressedCharacterP2){
          case 1:
            pressedCharacterP2 = getMaxchampions();
            break;

          case 2:
            pressedCharacterP2--;
            break;

          case 3:
            pressedCharacterP2--;
            break;

          case 4:
            pressedCharacterP2--;
            break;

        }
        break;
    }
    update();


  }

  private void update(){

    for (int i = 0; i < getPhotoFrame().length; i++) {
      if(pressedCharacterP1 == i+1 && pressedCharacterP2 == i+1){
        getPhotoFrame()[i].setColor(Color.WHITE);
        getPhotoFrame()[i].draw();
        continue;
      }
      if(pressedCharacterP1 == i + 1) {
        getPhotoFrame()[i].setColor(Color.RED);
        getPhotoFrame()[i].draw();
        continue;
      }
      if(pressedCharacterP2 == i + 1) {
        getPhotoFrame()[i].setColor(Color.BLUE);
        getPhotoFrame()[i].draw();
        continue;
      }
      getPhotoFrame()[i].delete();
    }

  }

}