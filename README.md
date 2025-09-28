# Trying to fix the following issues with the code I submitted to gradescope for lab 2.
## Issues with Behavior array 
```
String[] behaviorSet = {
                    "RandomNumberBehavior",
                    "MultiplyBehavior",
                    "AddBehavior",
                    "DivideBehavior",
                    "SubtractBehavior"
            };
```
- ~~Don't have a verifier as the last step~~ FIXED
- ~~Names are not specific enough~~ REFER TO FIRST FILE UPLOAD FOR NEW NAMES
```
String[] behaviorSet = {
                "RandomNumberBehavior",
                "MultiplyByThreeBehavior",
                "AddSixBehavior",
                "DivideByThreeBehavior",
                "SubtractOriginalNumBehavior",
                "CheckEqualsTwo"
        };
```
## Issues with Behavior Class
```
import java.util.Random;

/**
 * Generates a random number to perform more math behaviors on
 */
public class RandomNumberBehavior extends MathBehavior
{
    @Override
    protected int delegateMath(int x, Buffer input) {
        int randomNumber = new Random().nextInt(100);
        input.setOriginalValue(randomNumber);
        return randomNumber;
    }
}
```
- no javadocs
- ~~delegateMath should NOT be playing with your buffer.~~ FIXED BUT SEE BELOW
- RandomNumberBehavior and SubtractOriginalNumBehavior no longer work without having access to input buffers.  Need to find way to pass current value and original value through the pipeline.  Pair them in class????
## Issues with Checker
- ~~Checker should only output errors~~
- Didn't submit runnable class.  What does that mean?  How do I make it a runnable class?
## Issues with Test Code
- Should each test be a separate class?  Why can't I have all my tests in one class like it is now?
