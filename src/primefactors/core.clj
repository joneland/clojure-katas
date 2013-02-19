(ns primefactors.core)

(defn smallest-prime [x current]
  (if (zero? (mod x current))
    current
    (smallest-prime x (inc current))))

(defn prime-factors [x so-far]
  (if (= x 1)
    (reverse so-far)
    (prime-factors (/ x (smallest-prime x 2))
                   (conj so-far (smallest-prime x 2)))))

(defn generate [x]
  (prime-factors x '()))