package primalgorithm;

public class Grafo {
    public String Aresta;
    public Integer CustoAresta;
    public Integer ID;
    public Boolean ArestaConectada = false;

    public Boolean getArestaConectada() {
            return ArestaConectada;
    }

    public Integer getID() {
            return ID;
    }

    public String getAresta() {
            return Aresta;
    }

    public Integer getCustoAresta() {
            return CustoAresta;
    }

    public void setAresta(String _aresta) {
            Aresta = _aresta;
    }

    public void setCustoAresta(Integer _custoAresta) {
            CustoAresta = _custoAresta;
    }

    public void setID(Integer _id) {
            ID = _id;
    }

    public void setArestaConectada(Boolean _arestaConectada) {
            ArestaConectada = _arestaConectada;
    }
}

