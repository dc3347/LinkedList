/**
 *  A Range iterable that can be used to iterate over a sequence of integers
 *  (similar to Python's range function).
 */

//iterator interface methods: next(), hasNext(), remove()
//To implement Range, use an inner class for the 
//Iterator that is returned by the iterator() method. 
//The Iterator does not need to support the remove() operation.

import java.util.Iterator; 

public class Range implements Iterable<Integer> {
  // you probably need some variables here and an inner class.
  
    int start;
    int stop;
    int step;
  
    public Range(int start, int stop, int step) {
        this.start = start; //where the iterator starts
        this.stop = stop; //iterator stops before stop is reached
        this.step = step; //the increment each time around the loop, can be neg
    }

    private class RangeIterator implements Iterator<Integer>{
        private int cursor;
        
        public RangeIterator(){
            cursor = start;
        }
      
        public boolean hasNext(){ //is there something in the next position?
            if (step > 0){
                /*if (cursor < stop){
                    return true;
                }
                else
                    return false;*/
                return cursor < stop;
            }
            else //if step<0
                /*if (cursor>stop){
                   return true;
                }
                else
                    return false;*/
                return cursor > stop;
        }

        public Integer next(){ //^if hasNext, then print out
            //set temp=cursor, then increment cursor by step, then return temp
            int temp;
            temp = cursor;
            cursor += step;
            return temp;
        }
      
        public void remove(){
            //not implemented
        }
      
    }
  
  
    public Iterator<Integer> iterator() {
        return new RangeIterator(); // change this    
    }
  
  
  
  
 
  
  
  /* Test code in TestRange for reference
   * for(Integer j : new Range(1,8,1)) {
             System.out.print(j);
            }
            // Prints the sequence 1 2 3 4 5 6 7

            for(Integer j : new Range(1,8,2)) {
             System.out.print(j);
            }
            // Prints the sequence 1 3 5 7         

            for(Integer j : new Range(8,0,-1)) {
             System.out.print(j);
            }
            // Prints the sequence 8 7 6 5 4 3 2 1*/
}

