package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

import java.awt.*;

public class GameOverScreen implements ToDo {

    Rectangle mainMenuRect;
    Text mainMenuText;

    public GameOverScreen() {

        Inputs.setInputScreen(this);
        init();

    }

    private void init(){
        mainMenuText = new Text(1280/2,720/2,"Start agia bitches!");

        mainMenuRect = new Rectangle(mainMenuText.getX(), mainMenuText.getY(), mainMenuText.getWidth(), mainMenuText.getHeight());
        mainMenuRect.draw();
        mainMenuText.draw();



    }


    @Override
    public void actionPressed(int key) {

    }

    @Override
    public void actionReleased(int key) {

    }

}
