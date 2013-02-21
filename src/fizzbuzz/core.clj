(ns fizzbuzz.core)

(def make-divider
  (fn [divider]
    (fn [x]
      (zero? (mod x divider)))))

(def divisible-by-3 (make-divider 3))

(def divisible-by-5 (make-divider 5))

(defn print-fizz? [x]
  (divisible-by-3 x))

(defn print-buzz? [x]
  (divisible-by-5 x))

(defn print-fizzbuzz? [x]
  (and (print-fizz? x)
       (print-buzz? x)))

(defn print-output [x]
  (if (print-fizzbuzz? x)
    "FizzBuzz"
    (if (print-fizz? x)
      "Fizz"
      (if (print-buzz? x)
        "Buzz"
        x))))

(defn print-range [upper-limit]
  (map print-output (range 1 (inc upper-limit))))