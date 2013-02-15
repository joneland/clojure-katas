(ns coins.core-test
  (:use [midje.sweet])
  (:require [coins.core :as coins]))

(fact "should reduce amount by quotient multiplied by value of coin"
      (coins/reduce-amount 40 50) => 40
      (coins/reduce-amount 70 50) => 20
      (coins/reduce-amount 110 50) => 10)

(fact "should return least amount of each coin needed to equal amount"
      (coins/minimum-change .unimportant. [] []) => []
      (coins/minimum-change 40 [50 25 10 5 1] []) => [0 1 1 1 0])
      
(fact "should dispense minimum change for amount using coin denomination"
      (let [coin-denomination [1 5 10 25 50 100]]
        (coins/dispense :amount 0 :coin-denomination coin-denomination)
        => [0 0 0 0 0 0]
        (coins/dispense :amount 40 :coin-denomination coin-denomination)
        => [0 1 1 1 0 0]
        (coins/dispense :amount 127 :coin-denomination coin-denomination)
        => [2 0 0 1 0 1]))
