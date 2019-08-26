
package juegobola;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JFrame;	
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;




public class Vista extends JFrame implements java.util.Observer {
    
    public Model modelo;
    public Controlador controller;
//ATRUBUTOS

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
            }catch(Exception e){
                
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
    public Vista(){
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
        });
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
       renderMarco(m.marco, media);
       renderRectangule(m.rectangulo, media);
       renderRacket(m.racketa, media);
       renderBall(m.bola, media);
       
        
    }
    void renderMarco(MarcoRedondo mar, Graphics media){
        media.setColor(Color.red);
         media.fillOval(mar.x, mar.y, 2*modelo.marco.getRadio(),2*modelo.marco.getRadio());
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

    
}
