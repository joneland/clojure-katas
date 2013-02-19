(ns primefactors.core-test
  (:use midje.sweet
        primefactors.core))

(fact "smallest prime is the lowest number divisible by the given integer"
      (smallest-prime 2 2) => 2
      (smallest-prime 3 2) => 3
      (smallest-prime 10 2) => 2)

(fact "prime factors is a list of prime factors that make up the given integer"
      (prime-factors 8 []) => '(2 2 2))

(fact
  (generate 2) => '(2)
  (generate 6) => '(2 3)
  (generate 10) => '(2 5))