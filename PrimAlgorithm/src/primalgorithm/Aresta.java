package primalgorithm;

public class Aresta {
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

    public void setVerticeOrigem(String _verticeO) {
        VerticeOrigem = _verticeO;
    }
    public void setVerticeDestino(String _verticeD) {
        VerticeDestino = _verticeD;
    }

}
