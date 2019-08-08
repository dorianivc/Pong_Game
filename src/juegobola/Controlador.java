
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
}
