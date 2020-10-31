package primalgorithm;

public class Vertice {
    public String Nome;
    public Integer Custo = -1;
    public String VerticeProximo;
    
    public String getNome() {
        return Nome;
    }
    
    public Integer getCusto() {
        return Custo;
    }
    
    public String getVerticeProximo() {
        return VerticeProximo;
    }
    
    public void setVerticeProximo(String _verticeProximo) {
        VerticeProximo = _verticeProximo;
    }
    
    public void setNome(String _nome) {
        Nome = _nome;
    }

    public void setCusto(Integer _custo) {
        Custo = _custo;
    }
}

