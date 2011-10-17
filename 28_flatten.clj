; Problem 28 - Flatten a sequence

(defn flatten [sequence]
	(loop [c sequence r (empty sequence)]
	   (if (empty? c)
	     r
       (if (seq? (first c))
	       (recur (drop-last c) (conj r (flatten (last c) (empty c))))
	       (recur (drop-last c) (conj r (last c)))))))
         
(fn [sequence]
	(loop [c sequence r (empty sequence)]
	   (if (empty? c)
	     r
       (if (seq? (first c))
	       (recur (drop-last c) (conj r (flatten (last c) (empty c))))
	       (recur (drop-last c) (conj r (last c)))))))