import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean [] is_composite;
    //using is_composite rather than is_prime allows for default initialization to false instead of having to manually set everything to true

    public static boolean[] fillPrimes(int n){
        //uses sieve of eratosthenes to find if numbers are prime up to max number
        //goes through each number and marks its multiples as not prime(true), if a number is already not prime it skips it
        //the remaining primes are all false and can be accessed by their index

        for (int p = 2; p * p <= n; p++) {
            if (is_composite[p] == false) {
                for (int i = p * p; i <= n; i += p)
                    is_composite[i] = true;
            }
        }
        return is_composite;
    }
    public static String getPrimeSum2(int n){
        //returns a string representation of the prime sum of given number, n
        //goes through every odd number starting at 3, and first checks if it is prime by checking if element at that index in is_composite is false
        //if that element is prime(false in array), it checks if the element at the index n-counter is also prime
        //if so, it returns a string representation of the prime sum (ex 6=3+3)

        for (int counter = 3; counter<n; counter+=2){
            if (!is_composite[counter] && !is_composite[n-counter])
                return(n + "=" + counter + "+" + (n-counter));
        }
        return null;
    }

    public static boolean testGoldbach2(int max){
        //driver function to collect strings of sums using array algorithm

        is_composite = new boolean[max + 1];
        is_composite = fillPrimes(max);
        //initilizes size of array, automatically assigns everything to false, then changes elements at prime indexes to true

        StringBuilder builder = new StringBuilder(max * (((Integer.toString(max).length()-1)* 2) + 4));
        //StringBuilder int constructor pre-allocates enough memory to fit all the lines into
        //doing this allows for it to not have to update the memory after initilization

        if(max>=4) builder.append("4=2+2\n");
        //makes an exception for 4 so as to not have to make a base case in the getPrimeSum method, which would then be tested every time

        String x;
        for (int tester = 6; tester <= max; tester += 2){
            //iterates through all even numbers starting at 6, as 4 was already done
            x = getPrimeSum2(tester);
            if (x!= null)
                //adds the string representation of the sum of primes to the stringbuilder object
                builder.append(x + "\n");
            else
                //if it is null, it means it couldn't find a prime sum for a given even number
                //this is theoretically impossible according to goldbach's conjecture, so it probably means something broke
                return false;
        }

        System.out.println(builder);
        return true;
        //prints out all the prime sums at the end using only one print statement, to reduce runtime
    }
    public static boolean isPrime(int n){
        //given a number n, determines if it is prime through blunt force of division
        //assumes n is odd and greater than or equal to 3

        for (int i = 3; i < (int)Math.sqrt(n) + 1; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;


//        if (n % 2 == 0){
//            return false;
//        }
//        if (n ==2){
//            return true;
//        }
//        if (n <2){
//            return false;
//        }
        //these above if statements are the base cases that have been eliminated manually within the algorithm, but for a proper isPrime method would be necessary
    }
    public static String getPrimeSum(int n) {
        //returns a string representation of the prime sum of n
        //assumes n is even and greater than 4
        //counter starts at 3 and iterates through every odd number up to n
        //first checks if the counter is prime, and then checks if n-counter is prime
        //if both conditions are met, it returns string representation of the sum(ex 6=3+3)
        //the base case of 4=2+2 was manually removed

        for (int counter = 3; counter<n; counter+=2){
            if (isPrime(counter) && isPrime(n-counter))
                return(n + "=" + counter + "+" + (n-counter));
        }
        return null;
    }
    public static boolean testGoldbach(int max){
        //driver function to collect strings of sums using loop algorithm

        StringBuilder builder = new StringBuilder(max * (((Integer.toString(max).length()-1)* 2) + 4));
        //StringBuilder int constructor pre-allocates enough memory to fit all the lines into
        //doing this allows for it to not have to update the memory after initilization

        if(max>=4) builder.append("4=2+2\n");
        //makes an exception for 4 to not have to make a base case in the getPrimeSum method, which would then be tested every time

        String x;
        for (int tester = 6; tester <= max; tester += 2){
            //iterates through all even numbers starting at 6, as 4 was already done
            x = getPrimeSum(tester);
            if (x!= null)
                //adds the string representation of the sum of primes to the stringbuilder object
                builder.append(x + "\n");
            else
                //if it is null, it means it couldn't find a prime sum for a given even number
                //this is theoretically impossible according to goldbach's conjecture, so it probably means something broke
                return false;
        }

        System.out.println(builder);
        return true;
        //prints out all the prime sums at the end using only one print statement, to reduce runtime
    }
    public static void main(String[] args){
		//below is driver code, asks user for which algorithm and maximum number
        Scanner scan = new Scanner(System.in);
        int alg; int max;
        try{
            System.out.println("Enter 1 for loop algorithm, and 2 for array algorithm:");
            alg = scan.nextInt();
            System.out.println("Enter maximum number");
            max = scan.nextInt();
        }catch(IllegalArgumentException e){
            max = 1000;
            alg = 2;
        }
        
        long startTime = 0;
        if (max<=3){
            System.out.println("Invalid input");
            System.exit(0);
        }
        else{
            if(alg == 1){
                startTime = System.currentTimeMillis();
                System.out.println(testGoldbach(max));
            }
            else{
                startTime = System.currentTimeMillis();
                System.out.println(testGoldbach2(max));
            }

        }
        long endTime = System.currentTimeMillis();
        //startTime and endTime used to measure runtime in milliseconds

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        //decimalFormat used to display milliseconds in easier way
        System.out.println("That took " + decimalFormat.format(endTime - startTime) + " milliseconds");
    }
}
