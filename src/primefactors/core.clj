(ns primefactors.core)

(defn smallest-prime [x current]
  (if (zero? (mod x current))
    current
    (smallest-prime x (inc current))))

(defn prime-factors [x so-far]
  (if (= x 1)
    (reverse so-far)
    (let [next-prime (smallest-prime x 2)]
      (prime-factors (/ x next-prime)
                     (conj so-far next-prime)))))

(defn generate [x]
  (prime-factors x '()))