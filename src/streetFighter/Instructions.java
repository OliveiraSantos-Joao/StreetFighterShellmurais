package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Instructions implements ToDo {

    private Rectangle rectangleInst;
    private Text textInst1;
    private Rectangle exitRect;

    private Text exitText;

    public Instructions() {

        Inputs.setInputScreen(this);

        rectangleInst = new Rectangle(Game.PADDING + 35, Game.PADDING + 35, Game.width - 70, Game.height - 70);
        rectangleInst.setColor(Color.DARK_GRAY);
        rectangleInst.fill();

        this.textInst1 = new Text(Game.PADDING + 45, Game.PADDING + 45, "Teste");
        textInst1.setColor(Color.WHITE);
        textInst1.draw();


        exitRect = new Rectangle(Game.width/2,Game.height-Game.height/5,100,50);
        exitRect.setColor(Color.WHITE);
        exitRect.draw();

        exitText = new Text(Game.width/2+8,Game.height-Game.height/5+18,"SPACE to exit");
        exitText.setColor(Color.WHITE);
        exitText.draw();



    }

    public Rectangle getRectangleInst() {
        return rectangleInst;
    }

    public Text getTextInst1() {
        return textInst1;
    }

    public void deleteInstruction(){
        rectangleInst.delete();
        textInst1.delete();
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
