(ns coins.core
  (:use midje.sweet))

(defn reduce-amount [amount coin]
  (- amount (* coin (quot amount coin))))

(defn minimum-change [amount coins so-far]
  (if (empty? coins)
    so-far
    (minimum-change (reduce-amount amount (first coins))
                      (rest coins)
                      (conj so-far (quot amount (first coins))))))

(defn dispense [& {amount :amount coins :coin-denomination}]
  (reverse (minimum-change amount (reverse coins) [])))