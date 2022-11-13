package fr.univartois.butinfo.ihm.game248.controller;

import fr.univartois.butinfo.ihm.game2048.model.Game2048;
import fr.univartois.butinfo.ihm.game2048.model.Grid;
import fr.univartois.butinfo.ihm.game2048.model.IController;

import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Controller2048 implements IController {
	
	Game2048 game;
	private Label[][] labelTiles = new Label[Grid.SIZE][Grid.SIZE];

    @FXML
    private Label welcomeText;
    
    @FXML
    private Label labelScore;
    
    @FXML
    private GridPane grilleid;
    
    public void setGame(Game2048 game) {
    	this.game=game;
    }

    @FXML
    void onHButtonClick() {
    	game.moveDOWN();

    }

    @FXML
    void onHelButtonClick() {
    	game.moveUP();
    }

    @FXML
    void onHellButtonClick() {
    	game.moveLEFT();
    }

    @FXML
    void onHelloButtonClick() {
    	game.moveRight();
    }
    @FXML
    void initialize() {
       for (Node child : grilleid.getChildren()) {
             // On récupère la ligne où le label se trouve.
             Integer row = GridPane.getRowIndex(child);
             if (row == null) {
                row = 0;
             }

             // On récupère la colonne où le label se trouve.
             Integer column = GridPane.getColumnIndex(child);
             if (column == null) {
                column = 0;
             }

             labelTiles[row][column] = (Label) child;
    	   
       }}
       public void updateGrid(Grid grille) {
		for(int i = 0; i<Grid.SIZE;i++) {
			for(int j=0; j<Grid.SIZE;j++) {
				 labelTiles [i][j].setText(grille.get(i,j).toString());
			}}
		}
       public  void updateScore(int score) {
    	   labelScore.setText(Integer.toString(score));
       }

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}
       
}

