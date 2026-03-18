package org.example;

import javafx.scene.media.AudioClip;
import java.net.URL;

public class SoundManager {

    // Take in parameters the name of the msuic withe extnsion
    public static void playAttackSound(String fileName) {
        try {
            // Va chercher le fichier dans src/main/resources/sounds/
            URL path = SoundManager.class.getResource("/sounds/" + fileName);

            if (path != null) {
                AudioClip clip = new AudioClip(path.toExternalForm());
                clip.play();
            } else {
                System.err.println("error : " + fileName);
            }
        } catch (Exception e) {
            System.err.println("error : " + fileName);
            e.printStackTrace();
        }
    }
}