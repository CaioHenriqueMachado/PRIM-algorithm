package primalgorithm;

public class Vertice {
    public String Nome;
    public Integer Custo = -1;
    public String[] Aresta;
    
    public String getNome() {
        return Nome;
    }
    
    public Integer getCusto() {
        return Custo;
    }
    
    public String[] getAresta() {
        return Aresta;
    }
    
    public void setAresta(String[] _aresta) {
        Aresta = _aresta;
    }
    
    public void setNome(String _nome) {
        Nome = _nome;
    }

    public void setCusto(Integer _custo) {
        Custo = _custo;
    }
}

