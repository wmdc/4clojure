; 4Clojure problem #78 - Trampoline
; Implementation of the clojure.core/trampoline function

(fn t [f & a]
    (let [r (apply f a)]
	       (if (fn? r)
		   (t r)
		   r)))