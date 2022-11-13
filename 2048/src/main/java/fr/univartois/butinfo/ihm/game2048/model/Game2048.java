package fr.univartois.butinfo.ihm.game2048.model;


import java.util.List;
import java.util.Random;

public class Game2048 {
	private Grid grille;
	private int score;
	private IController controller;
	Random RANDOM =new Random();

	
	public Game2048() {
		grille = new Grid();
	}
	public void setController(IController controller) {
		this.controller = controller;
		
	}
	public void addrandomTiles() {
	//recuperer les tiles 
	List<Tile>availables =grille.availableTiles();
	int randIndex=RANDOM.nextInt(availables.size());
	Tile Tile_Index=availables.get(randIndex);
	Tile_Index.setValue(2);
	}

	public void initialize() {
		score=0;
		grille.clear();
		addrandomTiles();
		addrandomTiles();
	}
	
	public void update(MoveResult result) {
		if(result.hasMoved()) {
			score+=result.getMergeScore();
			addrandomTiles();
			addrandomTiles();
			controller.updateScore(score);
			controller.updateGrid(grille);
		}
	}
	
	public void moveUP() {
		MoveResult result  =grille.moveUp();
		update(result);
	}

	public void moveDOWN() {
		MoveResult result  =grille.moveDown();
		update(result);
	}
	
	public void moveLEFT() {
		MoveResult result  =grille.moveLeft();
		update(result);
	}
	
	public void moveRight() {
		MoveResult result  =grille.moveRight();
		update(result);
		}

}
