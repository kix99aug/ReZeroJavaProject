import java.io.*;
import java.io.IOException;
import javax.sound.sampled.*;

public class PlaySounds extends Thread {

    private String filename;
    AudioInputStream audioInputStream;
    boolean ifstop = false;
    float volume;
    PlaySounds(String wavfile) {
        this.filename = wavfile;
        this.volume = 0;
    }

    PlaySounds(String wavfile , float volume) {
        this.filename = wavfile;
        this.volume = volume;
    }

    public void change(String wavefile,float volume) {
        if (wavefile == filename)
            return;
        filename = wavefile;
        new PlaySounds(wavefile,volume).start();
        ifstop = true;
        _stop();
    }

    public void change(String wavefile) {
        if (wavefile == filename)
            return;
        filename = wavefile;
        new PlaySounds(wavefile,0).start();
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
        FloatControl gainControl = 
    (FloatControl)auline.getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(volume);
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