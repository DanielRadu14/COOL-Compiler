package cool.structures;

public class ClassSymbol extends Symbol {
    // Fiecare identificator posedă un tip.
    protected SymbolTable type;
    
    public ClassSymbol(String name) {
        super(name);
    }
    
    public void setType(SymbolTable type) {
        this.type = type;
    }
    
    public SymbolTable getType() {
        return type;
    }
}