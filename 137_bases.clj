(fn d [x b]
    (if (< x b)
	      [x]
	      (conj (d (int (/ x b)) b) (rem x b))))