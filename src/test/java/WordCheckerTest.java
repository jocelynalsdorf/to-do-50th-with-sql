import org.junit.*;
import static org.junit.Assert.*;

public class WordCheckerTest {

  @Test
  public void getChanged_ReturnsnumberOfRepeatedWords_2() {
      WordChecker testWordChecker = new WordChecker();
      String word = "paper";
      String sentence ="paper is paper they win";
      Integer answer = 2;
      assertEquals(answer, testWordChecker.getChanged(sentence,word));
  }

@Test
public void getChanged_ReturnsnumberOfRepeatedWordsRegardlessOfCase_2(){
   WordChecker testWordChecker = new WordChecker();
      String word = "paper";
      String sentence ="Paper is paper they win";
      Integer answer = 2;
      assertEquals(answer, testWordChecker.getChanged(sentence,word));
}
//
// @Test
// public void whoWins_ReturnsValueForKeyThatEqualsPlayerTwoGuess_String_3(){
//   RockPaper testRockPaper = new RockPaper();
//   assertEquals("It's a tie.", testRockPaper.whoWins("rock", "rock"));
// }
//
// @Test
// public void whoWins_ChangesCaseToLowerCase_String(){
//   RockPaper testRockPaper = new RockPaper();
//   assertEquals("It's a tie.", testRockPaper.whoWins("ROCK", "roCk"));
// }

}
