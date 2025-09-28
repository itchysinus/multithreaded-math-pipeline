/**
 * Abstract class that defines how math operations
 * should be performed.  Concrete classes
 * (e.g. IncrementBehavior) will provide specific
 * implementation (e.g. increment, add, multiply)
 */
public abstract class MathBehavior
{
    /**
     *
     * @param input is the input Buffer to pull value
     *              from
     * @param output is the output Buffer to write
     *               to
     */
    public synchronized void doTheMath(Buffer input, Buffer output)
    {
        int oldMathValue = input.read(); // oldMathValue gets the value we read from the input Buffer
        int newMathValue = delegateMath(oldMathValue); // newMathValue gets the value after we do the math on oldMathValue
        int originalValue = input.getOriginalValue(); // Original value is read from input Buffer
        output.write(newMathValue); // writing newMathValue to the output buffer
        output.setOriginalValue(originalValue); // Passes original value to the next buffer
    }

    /**
     * Concrete subclass override this method to implement
     * their specific math operation
     * @param x is input
     */
    protected abstract int delegateMath(int x);
}
