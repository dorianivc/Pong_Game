package juegobola;


public class JuegoBola {

     
     
      
       public static void main(String[] args) {
          System.out.println("Hola Mundo");
          
         Bola principal= new Bola(20,20,10,10,20,"black");
          Rectangulo rec = new Rectangulo(0,0,610,400);
          Racketa rack= new Racketa(0,0,30,30,"red",10,100);
          System.out.println(rec.toString());
           System.out.println(renderBall(principal));
           int veces=20;
           String html="";
           String colorFondo="white";
           html+="<svg height=1000 width =1000>"+"\n";
           html+="<rect x="+ rec.getX()+"y="+rec.getY()+" width="+rec.getW()+" height="+ rec.getH()+" fill= "+colorFondo+" stroke=black />"+"\n";
           for(int i=0;i<veces;i++){
             //  html+=renderBall(principal);
               html+=renderRacket(rack);
              principal.move();
              rack.move();
           }
           System.out.println(html);
    }
        static String renderBall(Bola principal){
              
              return "<circle cx="+principal.getX()+" cy="+principal.getY()+" r="+principal.getRadio()+" fill="+principal.getColor()+" />"+ "\n";
             
          }
    
        static String renderRacket(Racketa r){
            
           return "<rect x="+r.getX()+ " y="+ r.getY()+ " width="+ r.getWeight()+ " height="+r.getHeight()+" fill="+r.getColor()+ " stroke=black />"+ "\n";
        }
}
