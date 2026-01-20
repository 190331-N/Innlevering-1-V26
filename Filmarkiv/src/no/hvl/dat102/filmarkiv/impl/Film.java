package no.hvl.dat102.filmarkiv.impl;

public class Film {

    //Objektvariabler
    private int filmnr;
    private String produsent;
    private String tittel;
    private int utAr;
    private Sjanger sjanger;
    private String utgiver;

    public Film(){ //Standarkonstruktør
    }

    //Konstruktør
    public Film(int filmnr, String produsent, String tittel, int utAr, Sjanger sjanger, String utgiver){
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.utAr = utAr;
        this.sjanger = sjanger;
        this.utgiver = utgiver;
    }

    //Get-metoder
    public int getFilmnr() {return filmnr;}
    public String getProdusent() {return produsent;}
    public String getTittel() {return tittel;}
    public int getUtAr() {return utAr;}
    public Enum getSjanger() {return sjanger;}
    public String getUtgiver() {return utgiver;}

    //Set-metoder
    public void setFilmnr(int ny) {filmnr = ny;}
    public void setProdusent(String ny) {produsent = ny;}
    public void setTittel(String ny) {tittel = ny;}
    public void setUtAr(int ny) {utAr = ny;}
    public void setSjanger(Sjanger ny) {sjanger = ny;}
    public void setUtgiver(String ny) {utgiver = ny;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Film other = (Film) obj;
        return filmnr == other.filmnr;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(filmnr);
    }


}
