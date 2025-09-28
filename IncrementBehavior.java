/**
 * Implementation of MathBehavior that increments
 * the input value by 1
 */
public class IncrementBehavior extends MathBehavior {
    /**
     *
     * @param x input value to be incremented by 1
     * @return x after incremented
     */
    @Override
    protected int delegateMath(int x) {
        x = x + 1; // Increment x by one
        return x;
    }
}
