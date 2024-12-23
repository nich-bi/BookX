package org.project.logic.view;
import java.io.BufferedReader;
import java.io.IOException;

public class CliFornitore {

    boolean quit;
    BufferedReader br;

    public boolean mainMenu() throws IOException {
       Printer.printMsgln("CLI Fornitore");
        return true;
    }
}
