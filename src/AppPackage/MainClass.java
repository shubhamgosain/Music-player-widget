package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Graphics;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
public class MainClass 
{
    public long songremaining;
    public long totallength;
    public float bar;
    int duration;
    public String filename;
    FileInputStream FIS;
    BufferedInputStream BIS;
    public Player player;
    public void stop()
    {
        if(player != null)
        {
        player.close();
        
        }
    }
    
    
    public void pause() 
    {
        if(player != null)
        {
            try {         
 
             songremaining=FIS.available();

            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        player.close();
        
        }
    }
    
    
    
    
    public void play(String path)
    {
     try{
         FIS=new FileInputStream(path);
        BIS =new BufferedInputStream(FIS);
        player=new Player(FIS);
        filename=path+"";
        totallength=FIS.available();
        
     }
    catch(FileNotFoundException | JavaLayerException ex)
    {

        
    }   catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }


    new Thread()
    {
 @Override
        public void run()
        {
            try {                
                System.out.println(".asadsssaadsad");
                
                player.play();
                
                System.out.println(".run()");
                if(player.isComplete() && MP3PlayerGUI.count==1)
                {
                    System.out.print("Sssss");
                    play(filename);
                     }
                }
             catch (JavaLayerException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }.start();
}
    
    
public void resume()
    {
     try{
         FIS=new FileInputStream(filename);
     
        BIS =new BufferedInputStream(FIS);
        player=new Player(BIS);
        FIS.skip(totallength-songremaining);
               }
    catch(FileNotFoundException | JavaLayerException ex)
    {

        
    }   catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }


    new Thread()
    {
 @Override
        public void run()
        {
            try {
                player.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }.start();
}    
    
    
    public void d() 
    {
        try {
            bar=totallength-FIS.available();
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    float line=(bar/totallength)*100;
    System.out.println(line);
        
        
    }
    
}

