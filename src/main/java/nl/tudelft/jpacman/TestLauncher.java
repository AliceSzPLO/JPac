package nl.tudelft.jpacman;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.ui.GameEnd;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

import java.util.ArrayList;
import java.util.List;


public class TestLauncher extends Launcher {

    public static int getNumberOfLevels() {
        return NUMBER_OF_LEVELS;
    }

    public static void setNumberOfLevels(int numberOfLevels) {
        NUMBER_OF_LEVELS = numberOfLevels;
    }

    private static int NUMBER_OF_LEVELS = 15;

    private MultiLevelGame multiGame;

    public int getStartStage() {
        return StartStage;
    }

    public void setStartStage(int startStage) {
        StartStage = startStage;
    }

    private int StartStage = 7;

    public String getNameoftest() {
        return Nameoftest;
    }

    public void setNameoftest(String nameoftest) {
        Nameoftest = nameoftest;
    }
    public void LenghtOfMap(int StartStage,int EndStage){
        this.StartStage = StartStage;
        NUMBER_OF_LEVELS = EndStage;

    }
    private String Nameoftest = "";
    PacManUI p;

    @Override
    public MultiLevelGame getGame() {
        return multiGame;
    }
    public GameEnd gameEnd(String headtext,int score,double time){
        return new GameEnd(headtext,score,time);
    }

    @Override
    public MultiLevelGame makeGame() {
        try{
            Player player = getPlayerFactory().createPacMan();
            List<Level> levels = new ArrayList<>();
            for (int i = StartStage; i < NUMBER_OF_LEVELS+1; i++) {
                String _INDEX_MAP_ = String.valueOf(i)+Nameoftest;
                levels.add(makeLevel(_INDEX_MAP_));
            }
            multiGame = new MultiLevelGame(player, levels, loadPointCalculator(),p);
            
        } finally {
        }
        
        return multiGame;
    }
    @Override
    public void launch() {
        this.makeGame();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        setPacManUI(builder.build(getGame()));
        System.out.println(getPacManUI());
        getPacManUI().start();
    }
    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }

}
