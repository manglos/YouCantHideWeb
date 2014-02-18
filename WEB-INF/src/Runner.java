package youcanthide;
public class Runner extends Role{

	int numBeenTaggedThisTurn;
	int numBeenTaggedThisGame;
	int xpGained;

	Runner(){
		super();
		setType("Runner");
		numBeenTaggedThisTurn=0;
		numBeenTaggedThisGame=0;
		xpGained=0;
	}
	
	void gameEventHandler(GameEvent e){
		/* Large method with logic for handling any given event
		 * according to player role 'it'
		 */
	}
	
}
