; 4Clojure problem #110: Pronunciation
; Take a sequence like [1 1 2 3 1] and append each run of unique elements with the number of elements in that run.
; For example [1 1] -> [2 1], [1 2 3] -> [1 1 1 2 1 3], [1 1 2 3 1] -> [2 1 1 2 1 1 1].

; How many times in a row does the first element of s repeat itself?
(defn count-run [s]
	(loop [c s r 1]
	   (if (= (first c) (fnext c))
	       (recur (rest c) (inc r))
	       r)))
         
(defn pronunciation [s]
  (if (empty? s) []
      (let [c (count-run s)]
        (concat [c (first s)] (pronunciation (drop c s))))))
        
(defn pronunciation [s]
  (if (empty? s) []
    (let [c (#(loop [c % r 1] (if (= (first c) (fnext c)) (recur (rest c) (inc r)) r)) s)]
      (concat [c (first s)] (pronunciation (drop c s))))))
      
(fn p [s]
  (if (empty? s) []
    (let [c (#(loop [c % r 1] (if (= (first c) (fnext c)) (recur (rest c) (inc r)) r)) s)]
      (concat [c (first s)] (p (drop c s))))))
      
; Now we want a lazy sequence that applies this function over and over again.

(defn p-lazy [x]
  (iterate pronunciation x))

; Output must be a vector and we drop the first iterate element, which is just x.
  
(defn p-lazy [x]
  (rest (iterate (fn p [s]
             (if (empty? s) []
               (let [c (#(loop [c % r 1] (if (= (first c) (fnext c)) (recur (rest c) (inc r)) r)) s)]
                 (vec (concat [c (first s)] (p (drop c s)))))))
           x)))
           
(fn [x]
  (rest (iterate (fn p [s]
             (if (empty? s) []
               (let [c (#(loop [c % r 1] (if (= (first c) (fnext c)) (recur (rest c) (inc r)) r)) s)]
                 (vec (concat [c (first s)] (p (drop c s)))))))
           x)))
           
; Code golf...?
      
; Tests

(= [1 1 1 3 2 1 3 2 1 1] (nth (p-lazy [1]) 6))
(= [[1 1] [2 1] [1 2 1 1]] (take 3 (p-lazy [1])))