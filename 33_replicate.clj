; 33

(fn [c t]
	(loop [s c r (empty c) n t]
	   (if (empty? s)
	       r
	       (recur (rest s) (into r (take n (repeat (first s)))) n))))