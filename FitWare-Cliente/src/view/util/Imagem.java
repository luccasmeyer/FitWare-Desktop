package view.util;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Image.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author alice
 */
public class Imagem {
    /* Forcei um aspect ratio de 16:9 e tamanho máximo de 150x84
    Se vierem imagens com tamanho ou aspect ratio diferentes o
    método getImageIcon corrige e adequa pra 16:9*/
    
    private static final int LARGURA = 300;
    private static final int ALTURA = 300;
    
    private byte[] imagem;
    
    public byte[] getImagem(){
        return imagem;
    }
    
    public Imagem(byte[] imagem){
        this.imagem = imagem;
    }
    
    public Imagem(File file){
        this.imagem = ImageToByte(file);
    }

    private byte[] ImageToByte(File file) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            try {
                //System.out.println(bos.size());
                for(int readNum; (readNum = fis.read(buf)) != -1;){
                    bos.write(buf, 0, readNum);
                    //System.out.println("read " + readNum + " bytes");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        byte[] bytes = bos.toByteArray();
        return bytes;
    }
    
    private ImageIcon ScaleImage(Dimension medida){
        return new ImageIcon(new ImageIcon(imagem).getImage().getScaledInstance(medida.width, medida.height,java.awt.Image.SCALE_SMOOTH));
    }
    
    public ImageIcon getImageIcon(){
        try {
            BufferedImage bimg = ImageIO.read(new ByteArrayInputStream(imagem));
            
            //calculando aspect ratio
            float imageAspect = (float) bimg.getWidth() / (float) bimg.getHeight();
            float canvasAspect = (float) LARGURA / (float) ALTURA;
            
            int imgWidth = 300;
            int imgHeight = 300;
            if (imageAspect < canvasAspect) {
                //Se o aspect ratio da imagem for menor que o da tela então altera a largura
                float w = (float) ALTURA * imageAspect;
                imgWidth = (int) w;
            } else {
                //Senão altera a altura
                float h = (float) LARGURA / imageAspect;
                imgHeight = (int) h;
            }
            Dimension dimensao = new Dimension(imgWidth, imgHeight);
            
            return ScaleImage(dimensao);
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}