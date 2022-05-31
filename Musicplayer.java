import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

/*import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;*/

public class Musicplayer {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try (Scanner scanner = new Scanner(System.in)) {
            File file = new File("Blue_Day.wav");
            AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);
            String response = " ";
            while (!response.equals("Q")) {
                System.out.println("P=Play , S=Stop ,R=Reset,Q=Quit");
                System.out.println("Enter your choice:");
                response = scanner.next();
                response = response.toUpperCase();
                switch (response) {
                    case ("P"):
                        clip.start();
                        break;
                    case ("S"):
                        clip.stop();
                        break;
                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        break;
                    case ("Q"):
                        clip.close();
                        break;

                    default:
                        System.out.println("Not a valid response");
                        break;
                }
            }
        }

        System.out.println("Thanks for playing this song");

    }

}
