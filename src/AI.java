import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class AI {
    private final int suits = 4;
    private final int values = 13;

    /*
    Card states:
    0 unknown location
    1 in player 1's hand
    2 in player 2's hand
    3 in discard pile
     */
    private final int[][] cardStates = new int[suits][values];
    private final double[][] handEvalConvMatrix = {
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0},
            {0.0, 1.0, 2.0, 1.0, 2.0, 1.0, 0.0},
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 1.5, 0.0, 0.0, 0.0}
    };

    public AI(){
        //make the card unknown
        for (int s=0 ; s<suits ; s++) {
            for (int v = 0; v < values; v++){
                cardStates[s][v] = 0;
            }
        }
    }

    private void HandEvaluation(){
        double[][] cardValues = Utils.convolveMatrix(cardStates, handEvalConvMatrix);
        
    }
}
