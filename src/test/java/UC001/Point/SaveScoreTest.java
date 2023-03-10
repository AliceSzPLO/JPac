package UC001.Point;

import nl.tudelft.jpacman.points.SaveScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SaveScoreTest {
    @DisplayName("TC01:Save name, score and time")
    @Test
    void TC01() throws IOException {
        String name = "TestPlayer";
        int point = 100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertTrue(json.contains("\"name\":\"Test Player\""));
        Assertions.assertTrue(json.contains("\"point\":100"));
        Assertions.assertTrue(json.contains("\"time\":50.0"));
    }
    @DisplayName("TC02:Save name more 16, score and time")
    @Test
    void TC02() throws IOException {
        String name = "TestPlayerTestPlus";
        int point = 100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertFalse(json.contains("\"name\":\"TestPlayerTestPlus\""));
        Assertions.assertTrue(json.contains("\"point\":100"));
        Assertions.assertTrue(json.contains("\"time\":50.0"));
    }
    @DisplayName("TC03:Save name more 16, score and time")
    @Test
    void TC03() throws IOException {
        String name = "TestPlayer";
        int point = -100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertFalse(json.contains("\"point\":-100"));
    }
    @DisplayName("TC04: Save name, score and time")
    @Test
    void TC04() throws IOException {
        String name = "TestPlayerTestPlus";
        int point = 100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertTrue(json.contains("\"point\":100"));
    }
    @DisplayName("TC05:Save name more 16, score and time")
    @Test
    void TC05() throws IOException {
        String name = "TestPlayerTestPlus";
        int point = 100;
        double time = 50.0;
        SaveScore saveScore = new SaveScore(name, time, point);
        File file = new File("src/main/resources/score_board.json");
        FileReader reader = new FileReader(file);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        reader.close();
        String json = sb.toString();
        Assertions.assertFalse(json.contains("\"name\":\"TestPlayerTestPlus\""));
        Assertions.assertTrue(json.contains("\"point\":100"));
        Assertions.assertTrue(json.contains("\"time\":50.0"));
    }
}
