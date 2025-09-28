/**
 * Reads from an input buffer, increments and writes to an output buffer unless
 * it is number 0. In that case, it just writes increasing integers to the
 * output buffer
 *
 * @author Merlin
 *
 */
public class Modifier extends Thread
{
    private final MathBehavior mathBehavior;
    private Integer myNum;
    private Buffer inBuffer;
    private Buffer outBuffer;

    /**
     * Create an incrementer
     *
     * @param myNum
     *            ignored unless it is zero
     * @param inBuffer
     *            the buffer to read from
     * @param outBuffer
     *            the buffer to write to
     */
    public Modifier(MathBehavior mathBehavior, Integer myNum, Buffer inBuffer, Buffer outBuffer)
    {
        System.out.println("Initialized Incrementor with " + myNum);
        this.mathBehavior = mathBehavior; // Added parameter mathBehavior to specify operation
        this.myNum = myNum;
        this.inBuffer = inBuffer;
        this.outBuffer = outBuffer;
    }

    /**
     * @see java.lang.Thread#run()
     * Called when the thread starts.  Applies math behavior a fixed
     * number of times
     */
    @Override
    public void run()
    {
        System.out.println("Running Modifier with " + myNum);
        for (int i = 0; i < Starter.NUMBER_OF_TRIALS; i++){
            mathBehavior.doTheMath(inBuffer, outBuffer);
        }
    }
}
