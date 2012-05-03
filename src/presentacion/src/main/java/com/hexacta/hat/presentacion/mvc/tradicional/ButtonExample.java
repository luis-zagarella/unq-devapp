package com.hexacta.hat.presentacion.mvc.tradicional;

import static com.hexacta.hat.presentacion.mvc.tradicional.Button.aButton;

import com.hexacta.hat.presentacion.mvc.tradicional.support.Display;
import com.hexacta.hat.presentacion.mvc.tradicional.support.Rectangle;

@SuppressWarnings("unused")
public class ButtonExample {

    public void buttonUse() {
        Button helloButton = new Button("Hello", aRectangle().fromPoint(10, 4).toPoint(12, 58), new Callback() {

            @Override
            public void execute() {
                Display.show("HELLO WORLD!!!");
            }
        });

        //@formatter:off
		Button byeButton = aButton()
							 .named("Bye")
							 .fromPoint(20, 9).toPoint(30, 20)
							 .with(new Callback() {
									@Override
                                    public void execute() {
										Display.show("BYEE WORLD!!!");
								   }});
		//@formatter:on
    }

    private Rectangle aRectangle() {
        return new Rectangle();
    }

}
