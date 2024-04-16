import java.util.*;
public class Sound{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit) {  
    // /* to be implemented in part (a) */
    // return 0;

    int count = 0;
    
    for (int i = 0; i < samples.length; i++) {
        int amplitude = Math.abs(samples[i]); // Calculate amplitude
        if (amplitude > limit) {
            if (samples[i] > 0)
                samples[i] = limit; // Change positive values to limit
            else
                samples[i] = -limit; // Change negative values to -limit
            count++;
        }
    }
    
    return count;
  }

  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning() {
    /* to be implemented in part (b) */

    int firstNonZeroIndex = 0;
    
    // Find the index of the first non-zero element
    while (firstNonZeroIndex < samples.length && samples[firstNonZeroIndex] == 0) {
        firstNonZeroIndex++;
    }
    
    // Create a new array with non-zero elements
    int[] trimmedSamples = new int[samples.length - firstNonZeroIndex];
    System.arraycopy(samples, firstNonZeroIndex, trimmedSamples, 0, trimmedSamples.length);
    
    // Update the samples array reference
    samples = trimmedSamples;
  }
}
