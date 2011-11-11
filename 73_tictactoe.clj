(fn [b]
  (let [v (reduce #(into %1 %2) b)
	      m (take-nth 3 v)
	      n (take-nth 3 (rest v))
	      o (take-nth 3 (rest (rest v)))
	      q (take-nth 4 v)
	      r (drop-last (take-nth 2 (rest (rest v))))
	      
	      u (map (fn [a] (reduce #(if (= %1 %2) %1 :e) a)) (into b [m n o q r]))
	      
	      v (into #{} u)]
	      
	      (if (= (v :x) :x)
		    :x
		    (v :o))))