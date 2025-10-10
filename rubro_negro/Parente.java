package rubro_negro;

public class Parente {
    private No avo;
    private No tio;

    public Parente() {
        this.avo = null;
        this.tio = null;
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

}
