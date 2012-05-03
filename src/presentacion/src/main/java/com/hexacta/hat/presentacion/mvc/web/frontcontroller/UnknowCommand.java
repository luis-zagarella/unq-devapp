package com.hexacta.hat.presentacion.mvc.web.frontcontroller;

public class UnknowCommand extends BaseCommand {

    @Override
    public void execute() {
        forwardTo("/unknow.jsp");
    }

}
