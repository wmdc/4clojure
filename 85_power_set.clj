(fn p [s]
    (if (empty? s)
	    #{#{}}
	    (into (p (rest s))
		  (map #(conj % (first s)) (p (rest s))))))