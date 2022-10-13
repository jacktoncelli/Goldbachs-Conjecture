# Goldbachs-Conjecture
A project testing two different algorithms to prove Goldbach's Conjecture up to a specified number. 

------------------------------------------------------------------

[**Goldbach's Conjecture**](https://en.wikipedia.org/wiki/Goldbach%27s_conjecture) is a unsolved mathematical problem which this project would attempt to disprove. It states that every even natural number greater than 2 can be expressed as the sum of two prime numbers. If any even number is not a sum of two prime numbers, then the conjecture would be proven false.  

ex:
   4 = 2 + 2,
   6 = 3 + 3,
   8 = 3 + 5,
   etc.
  
------------------------------------------------------------------

This project utilizes two different approaches to test this theory.


The first approach is the **"loops"** method. It iterates through hundreds of possibilites to look for a prime sum, and is slower in runtime. I developed this algorithm myself for a class project junior year of high school, and it has since been updated and optimized. 

   Given a maximum number, the algorithm iterates through each even number up to the maximum, starting at four. For each even number, a method call is made to getPrimeSum. Within getPrimeSum, a for loop iterates through odd numbers up to n, beginning at 3, and processes each number in two ways. First, it checks if the current number is prime. This check is done using another method, isPrime, which operates through repeated division up to the square root of the current number. If it is prime, it then checks if (n - current number) is prime, using the same method. When both conditions are met, getPrimeSum returns a string representation of the sum. 

**Summary: iterates manually through possible sums until it finds one in which both numbers are prime**

------------------------------------------------------------------

The second approach is the **"arrays"** method. The idea for this comes from my computer science teacher, and I developed this on my own for fun during my senior year of high school. This method is significantly faster during runtime. 

   A public array of booleans is first initialized with length (max + 1). This array is named is_composite, and upon initilization, all the values are defaulted to false. A method call is made to fillPrimes, which utilizes the Sieve of Eratosthenes to test every number up to the max for primality. If a number is found to be composite, the value at that index in is_composite is changed to true. After fillPrimes is complete, the algorithm is very similar to the loops method. It iterates through every even number up to the maximum, starting at 4. For each even number, a method call to getPrimeSum2 is made. A for loop then iterates through every odd number, starting at 3, and up to n. For each odd number, it checks its primality by accessing the element at that index in is_composite. If the value is false, it checks the element at index (n - current number) within is_composite. If that value is also false, both conditions are met, and getPrimeSum2 returns a string representation of the sum. 
  
**Summary: checks every number for primality first, then iterates through looking for a sum in which both numbers are prime**

------------------------------------------------------------------

  After calculating and finding all the prime sums of even numbers up to the maximum, all that is left is to print them out. This is not necessary, but it was part of the challenge in the class project to attempt to optimize the printing of large amounts of data. Both algorithms collect and display data the same way.
  
   A StringBuilder is initialized in the driver function, and the constructer is set with a starting capacity. The capacity is an estimate of how many characters will be required total in the StringBuilder, and is based on how many digits in the maximum, as well as a few extra characters per line for '+', '=', and newline characters. Pre-allocating the expected capacity removes the need to update the memory allocation during runtime, which makes printing the data much faster.
  
  **Summary: pre-allocates estimated memory required to improve runtime**
  
------------------------------------------------------------------
  
There are definitely many ways to further improve the efficiency of this project, both big and small, and I am absolutely open to all suggestions! I would love to learn more about mkaing efficient and better algorithms, and please let me know of any ideas! 
  
