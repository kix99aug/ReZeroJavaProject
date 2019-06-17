import java.io.*;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class PlaySounds extends Thread {

    private String filename;
    AudioInputStream audioInputStream;
    boolean ifstop = false;

    PlaySounds(String wavfile) {
        filename = wavfile;
    }

    public void change(String wavefile) {
        if (wavefile == filename)
            return;
        filename = wavefile;
        new PlaySounds(wavefile).start();
        ifstop = true;
        _stop();
    }

    public void run() {

        File soundFile = new File(filename);
        audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        auline.start();
        int nBytesRead = 0;
        // 這是緩衝
        byte[] abData = new byte[512];
        try {
            while (nBytesRead != -1) {
                if (audioInputStream == null) 
                throw new IOException();
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }

    public void _stop() {
        audioInputStream = null;
    }
}