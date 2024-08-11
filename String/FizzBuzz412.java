class Solution {
    public List<String> fizzBuzz(int n) {
        // Initialize an empty list to store the result.
        List<String> result = new ArrayList<>();
        
        // Traverse numbers from 1 to n.
        for(int i = 1; i <= n; i++) {
            // Check if the number is divisible by both 3 and 5.
            if(i % 3 == 0 && i % 5 == 0) {
                // If true, add "FizzBuzz" to the list.
                result.add("FizzBuzz");
            }
            // Check if the number is divisible by 3.
            else if(i % 3 == 0) {
                // If true, add "Fizz" to the list.
                result.add("Fizz");
            }
            // Check if the number is divisible by 5.
            else if(i % 5 == 0) {
                // If true, add "Buzz" to the list.
                result.add("Buzz");
            }
            else {
                // If the number is not divisible by 3 or 5,
                // convert the number to a string and add it to the list.
                result.add(Integer.toString(i));
            }
        }
        
        // Return the list of FizzBuzz results.
        return result; 
    }
}
