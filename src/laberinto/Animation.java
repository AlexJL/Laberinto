/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author AlexJL
 */
public class Animation extends JFrame{
    
    private int x = 30;
    private int y = 330;
    int bandera = 0; 
    Image fondo,imagen2,imagen3; //declaro 3 variables del tipo iamgen
    InputStream imgStream;
    AudioClip audio,audio1;
    
    Animation()
    {
        super("Laberinto v1.0");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/pacman2.png"));
        setIconImage(icon);
        audio = java.applet.Applet.newAudioClip(getClass().getResource("../sound/pacman_chomp.wav"));
       // audio = java.applet.Applet.newAudioClip(getClass().getResource("../sound/pacman_beginning.wav"));
        audio1 = java.applet.Applet.newAudioClip(getClass().getResource("../sound/pacman_death.wav"));
        audio.play();
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargaImagen();
        repaint();
    }
    
    //método que nos permite cargar imagenes
     public void cargaImagen() {
        try {
            
                  imgStream = Animation.class.getResourceAsStream("../img/fondo.png");//el path debe ser directo img es mi directorio
                  fondo = ImageIO.read(imgStream);
                  if(bandera==0)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/1.png");
                  }
                  if(bandera == 1)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/2.png");
                  }
                  if(bandera==2)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/3.png");
                  }
                  if(bandera == 3)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/4.png");
                  }
                  if(bandera==4)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/5.png");
                  }
                  if(bandera == 5)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/6.png");
                  }
                  if(bandera==6)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/7.png");
                  }
                  if(bandera == 7)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/8.png");
                  }
                  imagen2 = ImageIO.read(imgStream);
                  if(bandera == 8)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/villano1.png");
                  }
                  if(bandera!=8)
                  {
                      imgStream = Animation.class.getResourceAsStream("../img/villano.png");
                  }
                  imagen3 = ImageIO.read(imgStream);
            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
    }
     
     
     //método para pintar en nuestra ventana
      public void paint(Graphics g)
      {
            Graphics g2 = (Graphics2D)g;
            g2.setColor(Color.black);
            //g2.fillRect(0, 0, 250, 400);//creo un triangulo negro del tamaño de la ventana para fondo
            g2.drawImage(fondo, 0, 0, 400, 400, null);//dibujo la imagen x, y, tamaño vertical y horizontal
            g2.drawImage(imagen2, x, y, 40, 40, null);
            g2.drawImage(imagen3, 30, 30, 40, 40, null);
      }
    
      public int getX()
      {
          return x;
      }
      
      public int getY()
      {
          return y;
      }
      
      public void setBandera(int i)
      {
          this.bandera = i;
      }
      
      public void setX(int x)
      {
          this.x = this.x+x;
      }
      
      public void setY(int x)
      {
          this.y = this.y+x;
      }
      
      public void setMusic()
      {
          audio.play();
      }
      public void setMusic1()
      {
          audio1.play();
      }
}
