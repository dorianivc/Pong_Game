package juegobola;


public class JuegoBola {

     
     
      
       public static void main(String[] args) throws InterruptedException {    
           StringBuilder html= new StringBuilder();
           html.append("<svg height=1000 width =1000>"+"\n");
           System.out.println(html);
           
           Model modelo= new Model();
           Vista vista= new Vista();
           Controlador control= new Controlador(modelo, vista);
           modelo.addObserver(vista);
           vista.setVisible(true);
           int veces=200;
           for(;;){
               
            Thread.sleep(500);
            modelo.step();
          
           }
          
    }
        
    
        
}
