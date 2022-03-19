package cool.structures;

import cool.compiler.DefinitionPassVisitor;

import java.util.LinkedList;

public class FuncSymbol extends Symbol{
    protected String type;
    protected String clasa;
    protected LinkedList<String> formali = new LinkedList<String>();
    protected LinkedList<String> tipuri = new LinkedList<String>();

    public FuncSymbol(String name) {
        super(name);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getClasa() {
        return clasa;
    }

    public void addFormal(String formal, String tip)
    {
        formali.add(formal);
        tipuri.add(tip);
    }

    public Boolean existsFormal(String formal)
    {
        if(formali.contains(formal))
            return true;

        return false;
    }

    public LinkedList<String> getFormali()
    {
        return formali;
    }

    public LinkedList<String> getTipuri()
    {
        return tipuri;
    }
}
