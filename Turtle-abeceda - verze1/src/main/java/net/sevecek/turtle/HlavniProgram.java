package net.sevecek.turtle;

import java.awt.*;
import java.text.spi.*;
import com.sun.org.apache.bcel.internal.generic.*;
import net.sevecek.turtle.engine.*;
import net.sevecek.turtle.*;

public class HlavniProgram {

/*
    Naprogramováno:
        písmena: A - Z, háček, čárka, kroužek
        čísla: 0 - 9
        znaky: tečka, čárka, vykřičník, otazník, dvojtečka, středník, pomlčka,
            mezera, řádek

    Psaní bez switche:
        založ objekt Pismo
        pismo.setBarvuPisma(new Color(...)) - metoda pro barvu pisma
            (pro tridu Pismo)
        pismo.novyRadek() - jinak se začne psát v prostředku
        metodu pro napsání háčku, čárky, kroužku nad písmenem napiš před
            napsáním metody pro napsání písmena
        pismo.setRadek(cislo rakdu) - metoda pro posunutí na určitý řádek
    Psaní se switchem
        založ objekt Pismo
        pismo.setBarvuPisma
        pismo.napisText("Zde napiš požadovaný text")
            musí být v ""
            \n musí být na začátku, jinak se začne psát od prostředka,
                potom funguje jako nový řádek
            písmena se znakem nad nimi se píší: Á, Š, Ů, atd.

*/
    public void main(String[] args) {

        Pismo pismo = new Pismo(0.5);



    }

}
