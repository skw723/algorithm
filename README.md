# algorithm


//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    //int[] data = {1,3,2,5,4};
    //int[] data = {8,3,2,4,7,9,5,1,6};
    //int[] data = {5,4,3,2,1};
    int[] data = {1,2,3,4,5,6};
    
    for (int i = 0; i < data.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < data.length; j++) {
        if (data[minIndex] > data[j]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
      }
    }
    
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i]); 
    }
  }
}
