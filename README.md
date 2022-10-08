# Goldbachs-Conjecture
A project testing two different algorithms to prove Goldbach's Conjecture up to a specified number. 

Goldbach's Conjecture is a unsolved mathematical problem which this project would attempt to disprove. It states that every even natural number greater than 2 can be expressed as the sum of two prime numbers.

ex:
  4 = 2 + 2
  6 = 3 + 3
  8 = 3 + 5
  etc.
  
This project utilizes two different approaches to test this theory. 

The first approach is the "loops" method. It iterates through hundreds of possibilites to look for a prime sum, and is slower in runtime. I developed this algorithm myself for a class project junior year of high school, and it has since been updated and optimized. 

  Given a maximum number, the algorithm iterates through each even number up to the maximum, starting at four. For each even number, a method call is made to getPrimeSum. Within getPrimeSum, a for loop iterates through odd numbers, beginning at 3, and processes each number in two ways. First, it checks if the current number is prime. This check is done using another method, isPrime, which operates through repeated division up to the square root of the current number. If it is prime, it then checks if (n - current number) is prime, using the same method. When both conditions are met, getPrimeSum returns a string representation of the sum. 
  
The second approach is the "arrays" method. The idea for this comes from my computer science teacher, and I developed this on my own for fun during my senior year of high school. This method is significantly faster during runtime. 

  A public array of booleans is first initialized with length (max + 1). This array is named is_composite, and upon initilization, all the values are defaulted to false. A method call is made to fillPrimes, which utilizes the Sieve of Eratosthenes to test every number up to the max for primality. If a number is found to be prime, the value at that index in is_composite is changed to true. After fillPrimes is complete, the algorithm is very similar to the loops method. It iterates through every even number up to the maximum, starting at 4. For each even number, a method call to getPrimeSum2 is made. The method then 
