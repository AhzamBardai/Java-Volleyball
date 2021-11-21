import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

class Roster{
    private ArrayList<Player> players;

    public Roster(){
        this.players = new ArrayList<Player>();
    }
    
    public Roster(String file) throws IOException {
        this.players = new ArrayList<Player>();
        FileInputStream myFile = new FileInputStream(file);
        Scanner myFileReader = new Scanner(myFile);

        while( myFileReader.hasNextLine() ){
            String next = myFileReader.nextLine();
            String[] split = next.split(" ");
            String name = split[0] + " " + split[1];
            double attack = Double.parseDouble(split[2]);
            double block = Double.parseDouble(split[3]);
            Player newPlayer = new Player(name, attack, block);
            players.add(newPlayer);
        }

        myFileReader.close();
        sort();
    }

    public void addPlayer(String name, double attack, double block){
        Player newPlayer = new Player(name, attack, block);
        players.add(newPlayer);        
    }

    public int countPlayers(){
        return players.size();
    }

    public Player getPlayerByName(String s){
        for(Player p : players){
            if(p.getName().compareTo(s) == 0){
                return p;
            }
        }
        return null;
    }

    private void sort(){
        Player p = new Player();
        for(int i = 0; i < players.size(); i++){
            for(int j = 0; j < players.size() - i - 1; j++){
                if(players.get(j).getName().compareTo(players.get(j+1).getName()) > 0){ 
                    // Swap
                    p = players.get(j);
                    players.set(j, players.get(j+1));
                    players.set(j+1, p);
                 }
            }
        }
    }

    public void printTopAttackers(){
        Player topOne = new Player();
        Player topTwo = new Player();
        for(Player p : players){
            if(p.getAttackStat() > topOne.getAttackStat()){
                topOne = p;
            } 
        }
        for(Player p2 : players){
            if(p2.getAttackStat() > topTwo.getAttackStat() && p2.getAttackStat() < topOne.getAttackStat()){
                topTwo = p2;
            }
        }
        System.out.println("===== Top Attackers =====");
        topOne.printPlayerInfo();
        topTwo.printPlayerInfo();
    }
    
    public void printTopBlockers(){
        Player topOne = new Player();
        Player topTwo = new Player();
        for(Player p : players){
            if(p.getBlockStat() > topOne.getBlockStat()){
                topOne = p;
            }
        }
        for(Player p2: players){
            if(p2.getBlockStat() > topTwo.getBlockStat() && p2.getBlockStat() < topOne.getBlockStat()){
                topTwo = p2;
            }
        }
        System.out.println("===== Top Blockers =====");
        topOne.printPlayerInfo();
        topTwo.printPlayerInfo();
    }
    
    public void printAllPlayers(){
        System.out.println("===== All Players =====");
        for(Player p : players){
            p.printPlayerInfo();
        }
    }
}