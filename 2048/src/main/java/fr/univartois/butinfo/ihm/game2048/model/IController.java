package fr.univartois.butinfo.ihm.game2048.model;

public interface IController {

	void setGame(Game2048 game);
	
	void endGame();
	 
	void startGame();
	 
	void updateGrid(Grid grille);
	 
	void updateScore(int score);
	
}
