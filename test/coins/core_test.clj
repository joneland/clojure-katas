(ns coins.core-test
  (:use midje.sweet
        coins.core))

(fact "should reduce amount by quotient multiplied by value of coin"
      (reduce-amount 40 50) => 40
      (reduce-amount 70 50) => 20
      (reduce-amount 110 50) => 10)

(fact "should return least amount of each coin needed to equal amount"
      (minimum-change .unimportant. [] []) => []
      (minimum-change 40 [50 25 10 5 1] []) => [0 1 1 1 0])
      
(fact "should dispense minimum change for amount using coin denomination"
      (let [coin-denomination [1 5 10 25 50 100]]
        (dispense :amount 0 :coin-denomination coin-denomination)
        => [0 0 0 0 0 0]
        (dispense :amount 40 :coin-denomination coin-denomination)
        => [0 1 1 1 0 0]
        (dispense :amount 127 :coin-denomination coin-denomination)
        => [2 0 0 1 0 1]))