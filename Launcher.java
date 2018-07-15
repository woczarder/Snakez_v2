package dev.harddrillstudio.genetics;

public class Launcher {

    public static void main(String[] args) {
        Main main = new Main();
        Thread mainThread = new Thread(main);
        mainThread.start();

        Main.launch(args);
    }

}
