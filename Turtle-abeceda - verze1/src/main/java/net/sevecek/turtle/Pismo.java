package net.sevecek.turtle;

import java.awt.*;
import net.sevecek.turtle.engine.*;
import sun.util.resources.cldr.fa.*;

public class Pismo {
    Turtle zofka = new Turtle();

    private double stranaX = 70.0;
    private double stranaY = 100.0;

    private double velikostPima;

    private int cisloRadku = 1;

    private double uhelA = Math.toDegrees(Math.atan(stranaX / stranaY));
    private double uhelB = 180.0 - (2.0 * uhelA);
    private double uhelC = 90.0 - uhelA;
    private double uhelD = 180.0 - (2.0 * uhelC);
    private double uhelE =
            Math.toDegrees(Math.atan((stranaX / 2.0) / (stranaY)));
    private double uhelF = 90.0 - uhelE;
    private double uhelG =
            Math.toDegrees(Math.atan(stranaX / (stranaY / 2.0)));
    private double uhelH = 90.0 - uhelG;
    private double uhelI =
            Math.toDegrees(Math.atan((stranaY / 4.0) / stranaX));
    private double uhelJ = 90.0 - uhelI;

    private double uhlopricka =
            Math.sqrt((stranaX * stranaX) + (stranaY * stranaY));
    private double uhloprickaProA =
            Math.sqrt(((stranaX / 2.0) * (stranaX / 2.0)) +
                    ((stranaY) * (stranaY)));
    private double uhloprickaProB =
            Math.sqrt((stranaX * stranaX) +
                    (stranaY / 4.0) * (stranaY / 4.0));
    private double uhloprickaProC =
            Math.sqrt(((stranaY / 2.0) * (stranaY / 2.0)) +
                    (stranaX * stranaX));



    public Pismo(double velikostPima) {
        this.velikostPima = velikostPima;
    }

    public int getCisloRadku() {
        return cisloRadku;
    }

    public void setZoomPisma(double cisloVelikostiPisma) {
        velikostPima = cisloVelikostiPisma;
    }

    public void zofkaMoveForward(double vzdalenost) {
        zofka.move(vzdalenost * velikostPima);
    }

    public void setTloustkuPera() {
        int defaultTloustkaPera = 10;
        zofka.setPenWidth((int)(defaultTloustkaPera * velikostPima));
    }

    public void setBarvuPisma(Color barva) {
        zofka.setPenColor(barva);
    }

    public void novyRadek() {
        zofka.setLocation((stranaX / 2.5) * velikostPima,
                (stranaY / stranaY * 165.0) * velikostPima * getCisloRadku());
        this.cisloRadku++;
    }

    public void setRadek(int cisloRadku) {
        this.cisloRadku = cisloRadku;
        zofka.setLocation((stranaX / 2.5) * velikostPima,
                (stranaY / stranaY * 165.0) * velikostPima * getCisloRadku());
        this.cisloRadku++;
    }



    public void nakresliA() {
        setTloustkuPera();
        zofka.penDown();

        zofka.turnRight(uhelE);
        zofkaMoveForward(uhloprickaProA);
        zofka.turnRight(uhelF * 2.0);
        zofkaMoveForward(uhloprickaProA / 2.0);
        zofka.turnRight(uhelE + 90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(uhelF);
        zofkaMoveForward(uhloprickaProA / 2.0);
        zofka.turnLeft(uhelF + 90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliB() {
        setTloustkuPera();
        zofka.penDown();

        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        for (int i = 0; i < 2; i++) {
            zofka.turnRight(uhelI);
            zofkaMoveForward(uhloprickaProB);
            zofka.turnRight(uhelJ * 2);
            zofkaMoveForward(uhloprickaProB);
            zofka.turnLeft(uhelJ + 90.0);
        }

        zofka.penUp();
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliC() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);

        zofka.penDown();
        zofka.turnRight(uhelG);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnRight(180.0);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnLeft(uhelG * 2.0);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnLeft(uhelH + 90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliD() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelH);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnRight(uhelG * 2.0);
        zofkaMoveForward(uhloprickaProC);

        zofka.turnLeft(uhelG + 90.0);
        zofka.penUp();
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliE() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX);

        zofka.turnRight(90.0);
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 3.0);

        zofka.penDown();
        zofkaMoveForward(stranaX / 3.0 * 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliF() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX);

        zofka.turnRight(90.0);
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 3.0);

        zofka.penDown();
        zofkaMoveForward(stranaX / 3.0 * 2.0);

        zofka.penUp();
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliG() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(90.0 + uhelA);

        zofka.penDown();
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelD);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX / 3.0);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaX / 3.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliH() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);

        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliI() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliJ() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(uhelA);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnRight(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);

        zofka.penUp();
        zofka.turnLeft(uhelC + 90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliK() {
        setTloustkuPera();
        zofka.penDown();

        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliC();
    }

    public void nakresliL() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliM() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelC);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnRight(uhelC + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliN() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelC);
        zofkaMoveForward(uhlopricka);
        zofka.turnLeft(uhelC + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliO() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(uhelH);

        zofka.penDown();
        zofkaMoveForward(uhloprickaProC / 2.0);
        zofka.turnLeft(uhelG);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(uhelG);
        zofkaMoveForward(uhloprickaProC / 2.0);
        zofka.turnLeft(uhelH * 2.0);
        zofkaMoveForward(uhloprickaProC / 2.0);
        zofka.turnLeft(uhelG);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(uhelG);
        zofkaMoveForward(uhloprickaProC / 2.0);
        zofka.turnLeft(uhelH);

        zofka.penUp();
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliP() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelI);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnRight(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelJ);

        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliQ() {
        setTloustkuPera();
        zofka.turnRight(90.0);
        zofka.penUp();
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0 + uhelA);

        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofkaMoveForward(uhlopricka / 2.0);
            zofka.turnRight(uhelD);
            zofkaMoveForward(uhlopricka / 2.0);
            zofka.turnRight(uhelB);
        }

        zofka.turnRight(uhelD);
        zofkaMoveForward((uhlopricka / 2.0) / 2.0);
        zofka.turnLeft(uhelD);
        zofkaMoveForward((uhlopricka / 2.0) / 4.0);
        zofka.turnLeft(180.0);
        zofkaMoveForward(((uhlopricka / 2.0) / 4.0) +
                (uhlopricka / 2.0) / 2.0);
        zofka.turnLeft(uhelC + 90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliR() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelI);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnRight(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelJ + uhelG);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnLeft(uhelH + 90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliS() {
        setTloustkuPera();
        zofka.penDown();
        zofka.turnRight(uhelG);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnLeft(uhelG + 90.0);
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0 + uhelG);
        zofkaMoveForward(uhloprickaProC);

        zofka.penUp();
        zofka.turnRight(uhelH + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliT() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY);

        zofka.penUp();
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliU() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(uhelA);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelA);
        zofkaMoveForward(stranaY / 2.0);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliV() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelF);

        zofka.penDown();
        zofkaMoveForward(uhloprickaProA);
        zofka.turnLeft(uhelF * 2.0);
        zofkaMoveForward(uhloprickaProA);

        zofka.penUp();
        zofka.turnRight(uhelF + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliW() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(90.0 + uhelC);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnRight(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelC + 90.0);
        for (int i = 0; i < 2; i++) {
            zofkaMoveForward(stranaY);
            zofka.turnLeft(180.0);
        }

        nakresliMezeruMeziPismeny();
    }

    public void nakresliX() {
        setTloustkuPera();
        zofka.penDown();
        zofka.turnRight(uhelA);
        zofkaMoveForward(uhlopricka);

        zofka.penUp();
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0 + uhelA);

        zofka.penDown();
        zofkaMoveForward(uhlopricka);
        zofka.turnLeft(180.0 - uhelA);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliY() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(uhelA);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(180.0);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);

        zofka.penUp();
        zofka.turnRight(uhelC + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliZ() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0 + uhelA);
        zofkaMoveForward(uhlopricka);
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli0() {
        setTloustkuPera();
        zofka.turnRight(90.0);
        zofka.penUp();
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0 + uhelA);

        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofkaMoveForward(uhlopricka / 2.0);
            zofka.turnRight(uhelD);
            zofkaMoveForward(uhlopricka / 2.0);
            zofka.turnRight(uhelB);
        }

        zofka.penUp();
        zofka.turnRight(uhelA + 90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }
    
    public void nakresli1() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(uhelG);

        zofka.penDown();
        zofkaMoveForward(uhloprickaProC);
        zofka.turnRight(uhelH + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli2() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(uhelA);

        zofka.penDown();
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnRight(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnRight(uhelA + uhelG);
        zofkaMoveForward(uhloprickaProC);
        zofka.turnLeft(180.0 - uhelH);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli3() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0 + uhelI);

        zofka.penDown();
        zofkaMoveForward(uhloprickaProB);
        zofka.turnRight(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnRight(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelJ + 90.0);

        zofka.penUp();
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli4() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(90.0 + uhelA);

        zofka.penDown();
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli5() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(uhelJ);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);
        zofka.turnLeft(uhelI + 90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli6() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnRight(90.0 + uhelA);

        zofka.penDown();
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelD);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);

        zofka.penUp();
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli7() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX);
        zofka.turnRight(90.0 + uhelA);
        zofkaMoveForward(uhlopricka);

        zofka.penUp();
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli8() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);

        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                zofka.turnLeft(uhelH);
                zofkaMoveForward(uhloprickaProC / 2.0);
                zofka.turnLeft(uhelG * 2.0);
                zofkaMoveForward(uhloprickaProC / 2.0);
                zofka.turnRight(180.0 - uhelH);
            }
            zofka.turnRight(180.0);
        }

        zofka.penUp();
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresli9() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(uhelC);

        zofka.penDown();
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelD);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelB);
        zofkaMoveForward(uhlopricka / 2.0);
        zofka.turnLeft(uhelA + 90.0);
        zofkaMoveForward(stranaX);

        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliTecku() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / stranaY);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliCarku() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY / 10.0);
        zofka.turnLeft(180.0);
        zofkaMoveForward((stranaY / 10.0) * 2.0);
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / 10.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliStrednik() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY / 10.0);

        zofka.penUp();
        zofkaMoveForward(stranaY / 10.0 * 4.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward((stranaY / stranaY) + (stranaY / 10 * 4.0));

        zofka.penDown();
        zofkaMoveForward(stranaY / 10.0 * 2.0);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / 10.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliVykricnik() {
        setTloustkuPera();
        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);

        zofka.penUp();
        zofkaMoveForward(stranaY / 4.0);

        zofka.penDown();
        zofkaMoveForward((stranaY / 4.0 * 3.0) - (stranaY / stranaY));

        zofka.penUp();
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaY);
        zofka.turnRight(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliOtaznik() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);

        zofka.penUp();
        zofkaMoveForward(stranaY / 4.0 - stranaY / stranaY);

        zofka.penDown();
        zofkaMoveForward(stranaY / 4.0 + (stranaY / 4.0 / 2.0));
        zofka.turnRight(uhelJ);
        zofkaMoveForward(uhloprickaProB / 2.0);
        zofka.turnLeft(uhelJ * 2.0);
        zofkaMoveForward(uhloprickaProB);

        zofka.penUp();
        zofka.turnLeft(uhelI + 90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliDvojtecku() {
        setTloustkuPera();
        zofkaMoveForward(stranaY / 6.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);

        zofka.penUp();
        zofkaMoveForward((stranaY / 6.0 * 2.0) - stranaY / stranaY);

        zofka.penDown();
        zofkaMoveForward(stranaY / stranaY);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / 2.0 + stranaY / stranaY);
        zofka.turnLeft(180);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliPomlcku() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnRight(90.0);

        zofka.penDown();
        zofkaMoveForward(stranaX / 3.0);

        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 2.0);
        zofka.turnLeft(180.0);

        nakresliMezeruMeziPismeny();
    }

    public void nakresliCarkuNadPismenem() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 20.0);
        zofka.turnRight(45.0);
        zofkaMoveForward(stranaY / 10.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / 5.0);

        zofka.penUp();
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / 10.0 + stranaY / 5.0);
        zofka.turnLeft(45.0);
        zofkaMoveForward(stranaY / 20.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);
    }

    public void nakresliHacekNadPismenem() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 8.0);
        zofka.turnRight(45.0);

        zofka.penDown();
        zofkaMoveForward(stranaY / 5.0);
        zofka.turnLeft(180.0);
        zofkaMoveForward(stranaY / 5.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 5.0);

        zofka.penUp();
        zofka.turnRight(180.0);
        zofkaMoveForward(stranaY / 5.0);
        zofka.turnRight(45.0);
        zofkaMoveForward(stranaY / 8.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);
    }

    public void nakresliKrouzekNadPismenem() {
        setTloustkuPera();
        zofka.penUp();
        zofkaMoveForward(stranaY);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY / 8.0);
        zofka.turnRight(90.0);

        zofka.penDown();
        for (int i = 0; i < 60; i++) {
            zofkaMoveForward(1.0);
            zofka.turnLeft(6.0);
        }

        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaY / 8.0);
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 2.0);
        zofka.turnLeft(90.0);
        zofkaMoveForward(stranaY);
        zofka.turnLeft(180.0);
    }

    public void nakresliMezeru() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX);
        zofka.turnLeft(90.0);
    }

    public void nakresliMezeruMeziPismeny() {
        setTloustkuPera();
        zofka.penUp();
        zofka.turnRight(90.0);
        zofkaMoveForward(stranaX / 3.0);
        zofka.turnLeft(90.0);
    }

    public void novyRadekProSwitch() {
        zofka.setLocation((stranaX / 2.5) * velikostPima,
                (stranaY / stranaY * 165.0) * velikostPima *
                        getCisloRadku());
    }

    public void napisText(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'A':
                    nakresliA();
                    break;
                case 'Á' :
                    nakresliCarkuNadPismenem();
                    nakresliA();
                    break;
                case 'B':
                    nakresliB();
                    break;
                case 'C':
                    nakresliC();
                    break;
                case 'Č' :
                    nakresliHacekNadPismenem();
                    nakresliC();
                    break;
                case 'D':
                    nakresliD();
                    break;
                case 'Ď' :
                    nakresliHacekNadPismenem();
                    nakresliD();
                    break;
                case 'E' :
                    nakresliE();
                    break;
                case 'É' :
                    nakresliCarkuNadPismenem();
                    nakresliE();
                    break;
                case 'Ě' :
                    nakresliHacekNadPismenem();
                    nakresliE();
                    break;
                case 'F' :
                    nakresliF();
                    break;
                case 'G' :
                    nakresliG();
                    break;
                case 'H' :
                    nakresliH();
                    break;
                case 'I' :
                    nakresliI();
                    break;
                case 'Í' :
                    nakresliCarkuNadPismenem();
                    nakresliI();
                    break;
                case 'J' :
                    nakresliJ();
                    break;
                case 'K' :
                    nakresliK();
                    break;
                case 'L' :
                    nakresliL();
                    break;
                case 'M' :
                    nakresliM();
                    break;
                case 'N' :
                    nakresliN();
                    break;
                case 'Ň' :
                    nakresliHacekNadPismenem();
                    nakresliN();
                    break;
                case 'O' :
                    nakresliO();
                    break;
                case 'Ó' :
                    nakresliCarkuNadPismenem();
                    nakresliO();
                    break;
                case 'P' :
                    nakresliP();
                    break;
                case 'Q' :
                    nakresliQ();
                    break;
                case 'R' :
                    nakresliR();
                    break;
                case 'Ř' :
                    nakresliHacekNadPismenem();
                    nakresliR();
                    break;
                case 'S' :
                    nakresliS();
                    break;
                case 'Š' :
                    nakresliHacekNadPismenem();
                    nakresliS();
                    break;
                case 'T' :
                    nakresliT();
                    break;
                case 'U' :
                    nakresliU();
                    break;
                case 'Ú' :
                    nakresliCarkuNadPismenem();
                    nakresliU();
                    break;
                case 'Ů' :
                    nakresliKrouzekNadPismenem();
                    nakresliU();
                    break;
                case 'V' :
                    nakresliV();
                    break;
                case 'W' :
                    nakresliW();
                    break;
                case 'X' :
                    nakresliX();
                    break;
                case 'Y' :
                    nakresliY();
                    break;
                case 'Ý' :
                    nakresliCarkuNadPismenem();
                    nakresliY();
                    break;
                case 'Z' :
                    nakresliZ();
                    break;
                case 'Ž' :
                    nakresliHacekNadPismenem();
                    nakresliZ();
                    break;
                case '0' :
                    nakresli0();
                    break;
                case '1' :
                    nakresli1();
                    break;
                case '2' :
                    nakresli2();
                    break;
                case '3' :
                    nakresli3();
                    break;
                case '4' :
                    nakresli4();
                    break;
                case '5' :
                    nakresli5();
                    break;
                case '6' :
                    nakresli6();
                    break;
                case '7' :
                    nakresli7();
                    break;
                case '8' :
                    nakresli8();
                    break;
                case '9' :
                    nakresli9();
                    break;
                case ' ' :
                    nakresliMezeru();
                    break;
                case '.' :
                    nakresliTecku();
                    break;
                case ',' :
                    nakresliCarku();
                    break;
                case '?' :
                    nakresliOtaznik();
                    break;
                case '!' :
                    nakresliVykricnik();
                    break;
                case ';' :
                    nakresliStrednik();
                    break;
                case '-' :
                    nakresliPomlcku();
                    break;
                case ':' :
                    nakresliDvojtecku();
                    break;
                case '\n' :
                    novyRadekProSwitch();
                    cisloRadku++;
                    break;
                default: nakresliTecku();

            }
        }
    }
}
