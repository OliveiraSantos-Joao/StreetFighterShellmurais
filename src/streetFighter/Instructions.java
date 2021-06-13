package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Instructions implements ToDo {


    private Rectangle exitRect;
    private Rectangle player1Background;
    private Rectangle player1Background2;
    private Rectangle player2Background;
    private Rectangle player2Background2;

    private Text exitText;

    private Picture InstructionsMenuPic;
    private Picture key1;
    private Picture keySpace;
    private Picture keyUp;
    private Picture keyLeft;
    private Picture keyRight;
    private Picture keyW;
    private Picture keyA;
    private Picture keyD;

    public Instructions() {

        Inputs.setInputScreen(this);

        InstructionsMenuPic = new Picture(10, 10, "elephantes_1280x720.jpeg");
        InstructionsMenuPic.draw();

        exitRect = new Rectangle(Game.WIDTH /2,Game.HEIGHT -Game.HEIGHT /5,100,50);
        exitRect.setColor(Color.WHITE);
        exitRect.draw();

        exitText = new Text(Game.WIDTH /2+8,Game.HEIGHT -Game.HEIGHT /5+18,"SPACE to exit");
        exitText.setColor(Color.WHITE);
        exitText.draw();

    //som 
    }






    public void deleteInstruction(){
        InstructionsMenuPic.delete();

    }

    @Override
    public void actionPressed(int key) {
        switch (key){
            case KeyboardEvent.KEY_SPACE:
                System.out.println("entrou");

                deleteInstruction();
                new MainMenu();
                break;
        }
    }

    @Override
    public void actionReleased(int key) {

    }
}
