package primalgorithm;

public class Vertice {
    /*
    public String[] Adjacentes;
    
    public String[] getAdjacentes() {
        return Adjacentes;
    }


    public void setAresta(String[] _adjacentes) {
        Adjacentes = _adjacentes;
    }
    
    */
    public String Nome;
    public Integer Custo = -1;
    public Boolean ArestaConectada = false;
 /*
    public Integer ID;


    public Integer getID() {
            return ID;
    }
*/
    public String getNome() {
            return Nome;
    }

    public Integer getCusto() {
            return Custo;
    }
    
    public Boolean getArestaConectada() {
            return ArestaConectada;
    }

    public void setNome(String _nome) {
            Nome = _nome;
    }

    public void setCusto(Integer _custo) {
            Custo = _custo;
    }
    
    public void setArestaConectada(Boolean _arestaConectada) {
            ArestaConectada = _arestaConectada;
    }
/*
    public void setID(Integer _id) {
            ID = _id;
    }
*/

}

