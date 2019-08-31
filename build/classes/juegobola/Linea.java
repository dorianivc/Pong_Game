/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegobola;


public final class Linea {
    int x1;
    int x2;
    int x3;
    int x4;
    Linea(int x1, int x2, int x3, int x4){
        this.x1=x1;
        this.x2=x2;
        this.x3=x3;
        this.x4=x4;
    }

    @Override
    public String toString() {
        return "Linea{" + "x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + '}';
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }
}
