import java.lang.reflect.InvocationTargetException;

/**
 * Starter creates and starts threads, each uses a
 * MathBehavior to process data in a buffer (shared
 * buffer in part 1)
 */
public class Starter
{
    /**
     * finalValue is the value we get from the last buffer after all the MathBehaviors
     * have been processed
     */
    private Buffer finalBuffer;
    /**
     * NUMBER_OF_TRIALS is the number of iterations each behavior should do
     * behaviors are the class names of the math behaviors
     */
    public static final int NUMBER_OF_TRIALS = 10000;
    /**
     * spawn all the behaviors giving them appropriate input and output
     * buffers
     *
     *
     * @throws ClassNotFoundException
     *             shouldn't
     * @throws NoSuchMethodException
     *             shouldn't
     * @throws SecurityException
     *             shouldn't
     * @throws InstantiationException
     *             shouldn't
     * @throws IllegalAccessException
     *             shouldn't
     * @throws IllegalArgumentException
     *             shouldn't
     * @throws InvocationTargetException
     *             shouldn't
     * @throws InterruptedException
     *             shouldn't
     */
    public Starter(String[] setOfBehaviors) throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            InterruptedException
    {
        Thread[] threads = new Thread[setOfBehaviors.length];
        Buffer[] buffers = new Buffer[setOfBehaviors.length + 1];
        for (int i = 0; i < buffers.length; i++)
        {
            if (i == 0 || i == (buffers.length -1))
            {
                buffers[i] = new UnsharedBuffer();
            } else {
                buffers[i] = new Buffer();
                }
        }
        for (int i = 0; i < setOfBehaviors.length; i++)
        {
            // load behavior class using reflection
            Class<?> behavior = Class.forName(setOfBehaviors[i]);
            // create instance of MathBehavior
            MathBehavior mathBehavior = (MathBehavior) behavior.getConstructor().newInstance();
            // Create Modifier thread with specific behavior
            threads[i] = new Modifier(mathBehavior, i, buffers[i], buffers[i + 1]);
            threads[i].start();
        }
        // join threads after they finish
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].join();
        }
        this.finalBuffer = buffers[buffers.length - 1];
    }

    /**
     *
     * @return the last buffer to the calling class
     */
//    public Buffer finalBuffer()
//    {
//        return finalBuffer;
//    }
}
