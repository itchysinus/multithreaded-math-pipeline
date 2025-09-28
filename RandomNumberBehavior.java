import java.util.Random;

/**
 * Generates a random number to perform more math behaviors on
 */
public class RandomNumberBehavior extends MathBehavior
{
    @Override
    protected int delegateMath(int x) {
        int randomNumber = new Random().nextInt(100);
        input.setOriginalValue(randomNumber);
        return randomNumber;
    }
}
