import java.util.*;

public final class CommunityLSim {
	//instance variables
	ArrayList<Player> players;
	ArrayList<Integer> indices;
	//int numPeeps;
	Random random = new Random();
	//TODO: you will need to add more instance variables

  //Constructor
	public CommunityLSim( int numP) {
		//numPeeps = numP;
		//create the players
		this.players = new ArrayList<>();
		this.indices = new ArrayList<>();

		//generate a community of 30
		for (int i = 0; i < numP; i++) {
			if (i < numP/2.0)
				this.players.add(new Player(PlayerKind.POORLY_PAID, (float)(99+Math.random())));
			else
				this.players.add(new Player(PlayerKind.WELL_PAID, (float)(100.1+Math.random())));
		}

	}

	public int getSize(){
	  return this.players.size();
    }

	public Player getPlayer(int i) {
	  return this.players.get(i);
    }

    public void addPocketChange(ArrayList<Player> players) {
		for(Player player: players){
			if (player.getKind() == PlayerKind.POORLY_PAID){
			  player.addMoney(0.03f);
			} else if (player.getKind() == PlayerKind.WELL_PAID) {
			  player.addMoney(0.1f);
			}
		}
   }

	private void reDoWhoPlays() {
		indices.clear();
		//60% of poorly paid people will play the lottery
		Object[] PP = randomUniqIndx((int)(players.size() * 0.3), 0, (int)(players.size()*0.5));
		Object[] RP = randomUniqIndx((int)(players.size() * 0.2), (int)(players.size()*0.5), players.size());
		for(Object o: PP){
			indices.add((Integer) o);
		}
		for(Object o: RP){
			indices.add((Integer) o);
		}

	}


	/*TODO generate some random indices for who might play the lottery 
		in a given range of indices */ 
 	public Object[] randomUniqIndx(int numI, int startRange, int endRange) {
		 HashSet<Integer> set = new HashSet<>();
		 int count = 0;
		 while(count < numI){
			 if(set.add((int)(Math.random()*(endRange-startRange))+startRange)){
				 count ++;
			 }
		 }
		 return set.toArray();
	}

	public void scholarship(float amt){
		 double rand = Math.random();
		 int index = 0;
		 if(rand < 0.3){
			 //well paid
			 index = (Integer)(randomUniqIndx(1, 0, (int)(players.size()*0.5+0.5))[0]);
		 } else{
			 //poorly paid
			 index = (Integer)(randomUniqIndx(1, (int)(players.size()*0.5+0.5),players.size())[0]);
		 }
		 //System.out.println(players.get(index).getKind());
		 players.get(index).addMoney(amt);
	}
    
	public void simulateYears(int numYears) {
  		/*now simulate lottery play for some years */
  		for (int year=0; year < numYears; year++) {
			//add pocket change for all players
			addPocketChange(players);
			//see who is playing this year
			reDoWhoPlays();
    		//initialize game
			Game lotto = new Game();
			//lotto.winningLotNumber();
			for (int idx : indices) {
				Player curPlayer = players.get(idx);
				curPlayer.playRandom();
				int matches = lotto.numMatch(curPlayer.getPlayerSet());
				float winnings = lotto.winnings(matches);
				curPlayer.addMoney(winnings);
				//System.out.println("Winnings Plus One: " + (winnings + 1.0f));
				if(Math.abs(1.0f + winnings)<= 0.0f){
					scholarship(1.0f);
					}
				}
				for(Player p: players){
					p.updateMoneyEachYear();
				}
			}
		  moneyPrintout(numYears);
    	} //years

	public float mostMoney(int year){
		 float money = players.get(0).getPastMoney(year);
		 for(Player player : players){
			 if (player.getPastMoney(year) > money){
				money = player.getPastMoney(year);
			 }
		 }
		 return money;
	}

	public float leastMoney(int year){
		float money = players.get(0).getPastMoney(year);
		for(Player player : players){
			if (player.getPastMoney(year) < money){
				money = player.getPastMoney(year);
			}
		}
		return money;
	}

	public void moneyPrintout(int numYears){
		for(int i = 0; i < numYears; i++){
			System.out.println("After year "+i+":");
			System.out.println("The person with the most money has: "+mostMoney(i));
			System.out.println("The person with the least money has: "+leastMoney(i));
		}
	}
  }	


