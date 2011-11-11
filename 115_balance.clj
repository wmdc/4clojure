(fn [x]
  (let [s (str x)]
	     (letfn [(f [y] (reduce + (map #(- (int \0) (int %)) y)))]
	       (= (f (subs s 0 (/ (count s) 2)))
		  (f (subs s (/ (inc (count s)) 2) (count s)))))))