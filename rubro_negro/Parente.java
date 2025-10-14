package rubro_negro;

public class Parente {
    private No avo;
    private No tio;
    private No sobrinhoPerto;
    private No sobrinhoLonge;

    public Parente() {
        this.avo = null;
        this.tio = null;
        this.sobrinhoPerto = null;
        this.sobrinhoLonge = null;
    }

    public void setAvo(No avo) {
        this.avo = avo;
    }

    public void setTio(No tio) {
        this.tio = tio;
    }

    public No getAvo() {
        return avo;
    }
    public No getTio() {
        return tio;
    }

    public No getSobrinhoPerto() {
        return sobrinhoPerto;
    }

    public void setSobrinhoPerto(No sobrinhoPerto) {
        this.sobrinhoPerto = sobrinhoPerto;
    }

    public No getSobrinhoLonge() {
        return sobrinhoLonge;
    }

    public void setSobrinhoLonge(No sobrinhoLonge) {
        this.sobrinhoLonge = sobrinhoLonge;
    }

    
}
