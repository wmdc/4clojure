; 4Clojure problem 59: Juxtaposition

(defn my-juxt [& fns]
	(fn [& a]
	    (loop [f fns r []]
	       (if (empty? f)
		         r
		         (recur (rest f) (conj r (apply (first f) a)))))))

; Example
((my-juxt (partial + 2) (partial * 2)) 3)

(fn [& f]
	(fn [& a]
	    (loop [c f r []]
	       (if (empty? c)
		         r
		         (recur (rest c) (conj r (apply (first c) a)))))))