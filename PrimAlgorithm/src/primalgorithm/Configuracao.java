package primalgorithm;

class Configuracao {
    public Boolean Direcionado;
    public String VerticeInicial;
    
    public String getVerticeInicial() {
        return VerticeInicial;
    }
    
    public Boolean getDirecionado() {
        return Direcionado;
    }
    
    public void setDirecionado(Boolean _direcionado) {
        Direcionado = _direcionado;
    }
    public void setVerticeInicial(String _verticeInicial) {
        VerticeInicial = _verticeInicial;
    }
}
