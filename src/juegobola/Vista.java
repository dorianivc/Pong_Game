
package juegobola;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JFrame;	
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;



    


public class Vista extends JFrame implements java.util.Observer {
    private static final String imagen= "media/Space-Transparent.png";
    public Model modelo;
    public Controlador controller;
//ATRUBUTOS
    private final BufferedImage ballImage;

    private void jMenuItem2ActionPerformed(java.awt.ActiveEvent evt){
        //controller.pause();
        JTextField esferas= new JTextField("1");
        JTextField velocidad= new JTextField("2");
        Object[] message={
            "Esferas: ",esferas, "Velocidad: ", velocidad
        };
        int option=JOptionPane.showConfirmDialog(null, message, "settings",JOptionPane.OK_CANCEL_OPTION);
        if(option==JOptionPane.OK_OPTION){
            try{
                controller.settings((Integer.parseInt(esferas.getText())), Integer.parseInt(velocidad.getText()));
            }catch(NumberFormatException e){
                
            }
        }
        //controller.activate();
    }
    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public Controlador getControl() {
        return controller;
    }
    

    public void setControl(Controlador control) {
        this.controller = control;
    }
    
    @Override
   public void update(Observable o, Object arg){
       this.repaint();
   }
    public Vista() throws IOException{
        File file = new File(imagen);
        this.ballImage = ImageIO.read(file);
        this.setSize(800, 700);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener( new java.awt.event.KeyAdapter()
        {
           @Override
           public void keyPressed(java.awt.event.KeyEvent evt){
               formKeyPressed(evt);
           } 
           @Override
           public void keyReleased(java.awt.event.KeyEvent evt){
               formKeyReleased(evt);
           }
                  } );
 
    }
    private void formKeyPressed(java.awt.event.KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_UP: controller.move(Model.ARR);break;
            case KeyEvent.VK_DOWN: controller.move(Model. ABJ);break;
            case KeyEvent.VK_LEFT: controller.move(Model.IZQ);break;
            case KeyEvent.VK_RIGHT: controller.move(Model.DER);break;
        }
    }
    private void formKeyReleased(java.awt.event.KeyEvent evt){
        int key= evt.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT: case KeyEvent.VK_RIGHT: controller.stopHorizontal();break;
            case KeyEvent.VK_UP: case KeyEvent.VK_DOWN: controller.stopVertical();break;
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.renderModel(modelo,g);
    }

    /*@Override
    public void update(Observable o, Object o1) {
    StringBuilder html=new StringBuilder();   
    this.renderModel(modelo, html);
    System.out.println(html);
    }*/
    
    void renderModel(Model m, Graphics media){
       
      // renderRectangule(m.rectangulo, media);
       renderMarco(m.marco, media);
       renderRacket(m.racketa, media);
       renderBall(m.bola, media);
      // renderLines(m.lineas, media);
    
       
        
    }
    void renderMarco(MarcoRedondo mar, Graphics media){
        media.setColor(Color.BLACK);
        media.fillOval(mar.x, mar.y, 2*modelo.marco.getRadio(),2*modelo.marco.getRadio());
        int x=((int)mar.x-mar.radio)+130;
        int y=((int)mar.y-mar.getRadio()+170);
        media.drawImage(ballImage,x,y,this); 
        
    }
    void renderRectangule(Rectangulo rec, Graphics media){
          media.setColor(Color.black);
            media.drawRect(modelo.rectangulo.x, modelo.rectangulo.y, modelo.rectangulo.w, modelo.rectangulo.h);
    }
   void renderBall(Bola principal, Graphics media){
              media.setColor(Color.green);
              media.fillOval(modelo.bola.x- modelo.bola.getRadio(), modelo.bola.y-modelo.bola.getRadio(), 2*modelo.bola.getRadio(),2*modelo.bola.getRadio() );
          
             
          }
    void renderRacket(Racketa r, Graphics media){
        media.setColor(Color.blue);
        media.fillRect(modelo.racketa.x, modelo.racketa.y,modelo.racketa.getWeight(), modelo.racketa.getHeight());
        }
    public void renderLineVertical(Graphics g){
         g.setColor(Color.BLUE);
        int ejeX=270;
        g.drawLine(ejeX, 50 ,ejeX, 650);
         g.setColor(Color.BLUE);
        int ejeX2=ejeX+105;
        g.drawLine(ejeX2, 50 ,ejeX2, 650);
        
    }
    void renderLines(Linea[] lin, Graphics media){
        for(int i=0;i<10;i++){
            media.setColor(Color.RED);
            media.drawLine(lin[i].x1, lin[i].x2 ,lin[i].x3,lin[i].x4);
        }
    }

    
}
