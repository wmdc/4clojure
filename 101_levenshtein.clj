(fn l
    ([s t] (l s t (count s) (count t)))
	  ([s t i j]
	      (cond (zero? i)
                  j
		          (zero? j)
                  i
		          (= (nth s (dec i)) (nth t (dec j))) 
		              (l s t (dec i) (dec j))
		          :else
		              (inc (min (l s t (dec i) j)
				                    (l s t i (dec j))
				                    (l s t (dec i) (dec j)))))))