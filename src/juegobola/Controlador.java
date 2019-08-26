
package juegobola;


public class Controlador {
    Model modelo;
    Vista vista;
    
    public Controlador(Model m, Vista vi){
        modelo=m;
        vista=vi;
        vista.setControl(this);
        vista.setModelo(m);
    }
    public void move(int flecha){
       modelo.move(flecha);
    }
    public void stopVertical(){
        modelo.stopVertical();
    }
    public void stopHorizontal(){
        modelo.stopHorizontal();
    }

    void settings(int i, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
