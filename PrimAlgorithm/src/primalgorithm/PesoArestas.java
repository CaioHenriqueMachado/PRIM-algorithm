package primalgorithm;

public class PesoArestas {
    public Integer PesoAresta;
    public String VerticeOrigem;
    public String VerticeDestino;

    public Integer getPesoAresta() {
            return PesoAresta;
    }
    
    public String getVerticeOrigem() {
            return VerticeOrigem;
    }

    public String getVerticeDestino() {
            return VerticeDestino;
    }

    public void setPesoAresta(Integer _pesoAresta) {
            PesoAresta = _pesoAresta;
    }

    public void setVerticeOrigem(String _vertice) {
        VerticeOrigem = _vertice;
    }
    public void setVerticeDestino(String _vertice) {
        VerticeDestino = _vertice;
    }

}
