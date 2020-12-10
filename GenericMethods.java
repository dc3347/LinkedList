import java.util.*;
public class GenericMethods {
    
  public static <T extends Comparable<T>> int findMin(T[] arr) {
    /*Iterate through the array to find the index of the smallest element in the array. 
    If there are two elements with the smallest value, the method should 
    return the index of the first one. The method should run in O(n).*/
    T min = arr[0];
    int index =0; 
    //find min value in array
    for (int i =0; i< arr.length; i++){
        if (arr[i].compareTo(min)<0){
          min = arr[i];
          index = i;
        }
    }
    return index;
  }
  
  public static <T extends Comparable<T>> int findMinRecursive(T[] arr) {
    /*Should behave just like findMin,
    but should be implemented recursively.
    Hint: the public findMinRecursive method should not, itself, be recursive.
    Instead, write an additional private helper method with additional parameters. 
    This private helper method should be called from findMinRecursive. This must run in O(n) time.*/
    int helper = findMinRecursive(arr, 0, 0);
    return helper; 
    
  }
  
  //helper
  private static <T extends Comparable<T>> int findMinRecursive(T[] a, int locMin, int idx){
      if(a.length==1){
          return 0;
      }  
    
      if (idx>=(a.length-1))
          return locMin;
      else if(a[locMin].compareTo(a[idx+1])<=0){
          return findMinRecursive(a,locMin,idx+1);
      }
      else { //a[locMin].compareTo(a[idx+1])>0
          locMin=idx+1;
          return findMinRecursive(a, locMin,idx+2); 
      }
  }
  
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
      /*Implement a recursive binary search to find a value equal to x.
      Hint: The public binarySearch method, itself, should not be recursive.
      Instead, write an additional private helper method with additional parameters.
      This private helper method should be called from the public binarySearch method. 
      This must run in O(log n) time. If the value is not found in the array, return -1. 
      Else, return the index in the array where the value was found.*/
     
    int helper = binarySearch(arr, 0, arr.length-1, x);
      return helper;
    
      /*if(helper != -1){
          return helper; //calls the binarySearch from below, recursively
      }
      else{
          return -1; //value was not found
      }*/
  }
  
  //new private class
  private static <T extends Comparable<T>> int binarySearch(T[] a, int start, int end, T y){
    //start and end are indices
    
      if(start> end){
          return -1; //not found
      }
      int mid = (start+end)/2;
      if (a[mid].compareTo(y)==0){
          return mid; //found!
      }
      else if(a[mid].compareTo(y)<0){ //a[mid] is less than y, y is in second half
          return binarySearch(a, mid+1, end, y);
      }
      else{ //a[mid].compareTo(y)>0
          return binarySearch(a, start, mid-1, y); //y is in first half
      }
  }
  
}

