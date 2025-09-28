/**
 * UnsharedBuffer is used for the first and last buffers in the chain.
 * Unlike Buffer, it does not block on semaphores since only one thread
 * accesses it at a time (producer-only or consumer-only).
 */
public class UnsharedBuffer extends Buffer
{
    private int originalValue;
    private int value;

    @Override
    public void write(int x)
    {
        this.value = x;
    }

    @Override
    public int read()
    {
        return value;
    }

    @Override
    public void setOriginalValue(int value) { this.originalValue = value; }

    @Override
    public int getOriginalValue() { return this.originalValue; }
}
