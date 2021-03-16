/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author working
 */
public class Histograma {
    
    private Image imagenOriginal;
    private int[]r;
    private int[]g;
    private int[]b;

    public Histograma(Image imagen) {
        this.imagenOriginal = imagen;
        this.r = new int[256];
        this.g = new int[256];
        this.b = new int[256];
    }
    public void calcularHistogramas(){
        // recorrer la imagen
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
                // extraer el color
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed(); // (0-255)
                int g = color.getGreen(); // (0-255)
                int b = color.getBlue(); // (0-255)
                this.r[r]++;
                this.g[g]++;
                this.b[b]++;
                
            }
        
    }
       
    public void convertirANegativo(){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0; y< bi.getHeight();y++){
               int p=bi.getRGB(x, y);
               int a=(p>>24)&0xff;
               int r=(p>>16)&0xff;
               int g=(p>>8)&0xff;
               int b=p&0xff; 
               r=255-r;
               g=255-g;
               b=255-b;
               
               p=(a<<24)|(r<<16)|(g<<8)|b;
               bi.setRGB(x,y,p);
            }
            
            
            }
            try{
            File f=new File("C:\\Users\\LAST_\\Desktop\\Negativo.jpg");
            ImageIO.write(bi, "jpg", f);
            }catch(IOException e){
                e.printStackTrace();
            }
   
    }
    public void graficar (){
    
    }

    /**
     * @return the r
     */
    public int[] getR() {
        return r;
    }

    /**
     * @return the g
     */
    public int[] getG() {
        return g;
    }

    /**
     * @return the b
     */
    public int[] getB() {
        return b;
    }
    
}
