/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Paweł
 */
public class Egzemplarz {
    private String id_dziela;
    private String kod_ean;
    private String tytul;
    private String autor;
    private String typ;
    private String gatunek;
    private String tagi;
    private String jezyk;
    private String isbn;

    public Egzemplarz(String id_dziela, String kod_ean, String tytul, String autor, String typ, String gatunek, String tagi, String jezyk, String isbn) {
        this.id_dziela = id_dziela;
        this.kod_ean = kod_ean;
        this.tytul = tytul;
        this.autor = autor;
        this.typ = typ;
        this.gatunek = gatunek;
        this.tagi = tagi;
        this.jezyk = jezyk;
        this.isbn = isbn;
    }

    Egzemplarz() {
        this.id_dziela = null;
        this.kod_ean = null;
        this.tytul = null;
        this.autor = null;
        this.typ = null;
        this.gatunek = null;
        this.tagi = null;
        this.jezyk = null;
        this.isbn = null;    }
}
