public class SubtractOriginalBehavior extends MathBehavior
{
    @Override
    protected int  delegateMath(int x)
    {
        x = x - previousBuffer.getOriginalValue();
        return x;
    }
}
