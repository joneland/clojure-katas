(ns fizzbuzz.core-test
  (:use midje.sweet
        fizzbuzz.core))

(fact "returns true if number is divisible by 3"
      (divisible-by-3 5) => false
      (divisible-by-3 12) => true)

(fact "returns true if number is divisible by 5"
      (divisible-by-5 7) => false
      (divisible-by-5 20) => true)

(fact "Fizz is printed instead of numbers divisible by 3"
      (print-output 9) => "Fizz"
      (print-output 8) => 8)

(fact "Buzz is printed instead of numbers divisible by 5"
      (print-output 10) => "Buzz"
      (print-output 8) => 8)
      
(fact "FizzBuzz is printed instead of numbers divisible by 3 and 5"
      (print-output 15) => "FizzBuzz"
      (print-output 8) => 8)

(fact "prints 1 to specified upper limit whilst substituting numbers divisible by 3 and 5"
  (print-range 15)
  => [1 2 "Fizz" 4 "Buzz" "Fizz" 7 8 "Fizz" "Buzz" 11 "Fizz" 13 14 "FizzBuzz"])