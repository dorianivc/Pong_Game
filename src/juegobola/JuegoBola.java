package juegobola;


public class JuegoBola {

     
     
      
       public static void main(String[] args) {
          System.out.println("Hola Mundo");
          
         Bola principal= new Bola(20,20,10,10,20);
          Rectangulo rec = new Rectangulo(0,0,610,400);
          System.out.println(rec.toString());
           System.out.println(renderBall(principal));
           int veces=250;
           String html="";
           html+="<svg height=1000 width =1000>"+"\n";
           html+="<rect x="+ rec.getX()+"y="+rec.getY()+" width="+rec.getW()+" height="+ rec.getH()+" fill= white stroke=black />"+"\n";
           for(int i=0;i<veces;i++){
               html+="<circle cx="+principal.getX()+" cy="+principal.getY()+" r="+principal.getRadio()+" />"+ "\n";
              principal.move(rec);
           }
           System.out.println(html);
    }
        static String renderBall(Bola x){
              
              return "Valor X: "+ x.getX()+" Valor Y: "+ x.getY();
             
          }
    
}
