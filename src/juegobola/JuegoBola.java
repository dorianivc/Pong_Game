package juegobola;


public class JuegoBola {

     
     
      
       public static void main(String[] args) throws InterruptedException {    
            
           Model modelo= new Model();
           Vista vista= new Vista();
           Controlador control= new Controlador(modelo, vista);
           modelo.addObserver(vista);
           vista.setVisible(true);
           int veces=200;
           for(;;){
               
            Thread.sleep(100);
            modelo.step();
          
           }
          
    }
        
    
        
}
