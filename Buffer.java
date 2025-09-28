import java.util.concurrent.Semaphore;

/**
 * @author GAVEROO AND ARI
 */
public class Buffer
{
    private int current = 0; // Current value we are modifying
    private int originalValue = 0; // starter value that is randomly generated

    // Semaphore to indicate we are ready to write to next Buffer
    // Value is 1 so we can immediately write to first buffer
    private final Semaphore readyToWrite = new Semaphore(1);
    //Semaphore to indicate we are ready to read from the previous Buffer
    // Value is 0 so we don't try to read a buffer that doesn't exist or is empty
    private final Semaphore readyToRead =  new Semaphore(0);

    /**
     * write an int into this buffer
     * @param x the int we should store
     */
    public void write(int x)
    {
        try {
            readyToWrite.acquire();
            this.current = x;
            readyToRead.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * @return the next int in the buffer
     */
    public int read() {
        int returnValue = 0;
        try {
            readyToRead.acquire();
            returnValue = this.current;
            readyToWrite.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return returnValue;
    }

    /**
     * Sets the original value before we do the maths
     * @param value it's a value
     */
    public synchronized void setOriginalValue(int value) { this.originalValue = value; }

    /**
     * Returns the original random value we generated
     * @return originalValue
     */
    public synchronized int getOriginalValue() { return this.originalValue; }
}
