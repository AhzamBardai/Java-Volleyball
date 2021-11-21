import java.text.DecimalFormat; 

class Player{
    private String name;
    private double attackStat;
    private double blockStat;

    public Player(){
        this.name = "";
        this.attackStat= 0.0;
        this.blockStat= 0.0;

    }

    public Player(String name, double attack, double block){
        DecimalFormat d = new DecimalFormat("##.00");
        this.name = name;
        this.attackStat = Double.parseDouble(d.format(attack));
        this.blockStat = Double.parseDouble(d.format(block));
    }

    public String getName(){
        return this.name;
    }

    public double getAttackStat() {
        return this.attackStat;
    }

    public void setAttackStat(double d){
        this.attackStat = d;
    }

    public double getBlockStat() {
        return this.blockStat;
    }

    public void setBlockStat(double d){
        this.blockStat = d;
    }

    public void printPlayerInfo() {
        String attack = "attack = " + String.format("%.2f", this.attackStat);
        String block = ", block = " + String.format("%.2f", this.blockStat);
        System.out.println(this.name + " (" + attack + block + ")");
    }
}