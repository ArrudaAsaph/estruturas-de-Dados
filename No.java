public class No {
    private No pai;
    private No filhoEsquerdo;
    private No filhoDireito;
    private Object elemento;
    private int chave;
    private int fator_balanceamento;

    
    public No(int chave, Object elemento) {
        this.chave = chave;
        this.elemento = elemento;
        this.fator_balanceamento = 0;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

   
    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
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

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getFator_balanceamento() {
        return fator_balanceamento;
    }

    public void setFator_balanceamento(int fator_balanceamento) {
        this.fator_balanceamento = fator_balanceamento;
    }
}
