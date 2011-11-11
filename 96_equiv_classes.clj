(fn [f s]
    (loop [c s r #{}]
	       (if (empty? c)
		   r
		   (let [n (filter #(= (f (first c)) (f %)) c)]
			(recur (apply disj c n)
			       (conj r (set n)))))))