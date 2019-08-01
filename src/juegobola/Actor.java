
package juegobola;

public abstract class Actor {
    protected int x=0;
    protected  int y=0;
    protected  int deltaX=0;
    protected  int deltaY=0;
    protected  String color=" ";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public Actor(int x, int y, int H, int K, String colo) {
        this.x=x;
        this.y=y;
        deltaX=H;
        deltaY=K;
        color=colo;
    }
    
    public abstract void move();
    
    
}
