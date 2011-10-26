; 4clojure problem #75 -- Euler's totient function

(defn gcd [a b]
  (if (zero? b)
    a
    (gcd b (- a (* b (int (/ a b)))))))
    
(defn coprime [a b] (= 1 (gcd a b)))

(defn totient [x]
  (reduce + (map #(if (coprime x %) 1 0) (range x))))
  
; ugly anonymous function for 4clojure

(fn [x]
  (reduce +
          (map #(if (= 1 ((fn c [a b] (if (zero? b) a (c b (- a (* b (int (/ a b ))))))) x %))
                    1
                    0)
               (range x))))