package rubro_negro;

public class No {
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;
    private String cor;
    private int chave;


    public No(No pai, int chave) {
        this.pai = pai;
        this.chave = chave;

        this.filhoDireito = null;
        this.filhoEsquerdo = null;

        this.setCor("vermelho");
    }


    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }


    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }


    public No getFilhoDireito() {
        return filhoDireito;
    }


    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }


    public No getPai() {
        return pai;
    }


    public void setPai(No pai) {
        this.pai = pai;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public int getChave() {
        return chave;
    }


    public void setChave(int chave) {
        this.chave = chave;
    }

    

    
}
