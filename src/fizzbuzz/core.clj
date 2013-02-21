(ns fizzbuzz.core)

(def make-divider
  (fn [divider]
    (fn [x]
      (zero? (mod x divider)))))

(def divisible-by-3 (make-divider 3))

(def divisible-by-5 (make-divider 5))

(defn print-output [x]
  (if (and (divisible-by-3 x)
           (divisible-by-5 x))
    "FizzBuzz"
    (if (divisible-by-3 x)
      "Fizz"
      (if (divisible-by-5 x)
        "Buzz"
        x))))

(defn print-range [upper-limit]
  (map print-output (range 1 (inc upper-limit))))
