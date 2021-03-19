public class node {
    int key;
    node next;
    String[] nameArray = {
        "Kitsos",
        "Hekate",
        "Amatheia",
        "Thoösa",
        "Latona",
        "Panope",
        "Medesicaste",
        "Timandra",
        "Gygaea",
        "Alcandre",
        "Hero",
        "Anastasios",
        "Iros",
        "Eurysthios",
        "Protogenes",
        "Asonides",
        "Keos",
        "Archytas",
        "Menoitios",
        "Sostias",
        "Sotera",
        "Leucothea",
        "Antiochis",
        "Latona",
        "Laothoe",
        "Procris",
        "Iolanthe",
        "Phylomedusa",
        "Pales",
        "Roxane",
        "Zagreus",
        "Olympicus",
        "Nicias",
        "Podalinus",
        "Therapon",
        "Pandaros",
        "Erichthonius",
        "Gyrtias",
        "Cobon",
        "Hypatius",
        "Anchialus"
    };

    public node(int key) {
        this.key = key;
        next = null;
    }

    public void display() {
        System.out.print("(" + nameArray[key] + ")-->");
    }
    
}